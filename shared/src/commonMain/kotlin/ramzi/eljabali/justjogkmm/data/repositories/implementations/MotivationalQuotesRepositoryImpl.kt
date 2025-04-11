package ramzi.eljabali.justjogkmm.data.repositories.implementations

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import io.ktor.util.network.UnresolvedAddressException
import kotlinx.serialization.SerializationException
import ramzi.eljabali.justjogkmm.data.network.api.model.MotivationalQuote
import ramzi.eljabali.justjogkmm.domain.repository.MotivationalQuotesRepository
import ramzi.eljabali.justjogkmm.util.NetworkError
import ramzi.eljabali.justjogkmm.util.Result

class MotivationalQuotesRepositoryImpl(
    private val httpClient: HttpClient // TODO: Inject this
) : MotivationalQuotesRepository {
    override suspend fun getRandomQuotes(): Result<MotivationalQuote, NetworkError> {
        val response = try {
            httpClient.get(urlString = "https://thequoteshub.com/api/")
        } catch (e: UnresolvedAddressException) {
            return Result.Error(NetworkError.NO_INTERNET)
        } catch (e: SerializationException) {
            return Result.Error(NetworkError.SERIALIZATION)
        }

        return when (response.status.value) {
            in 200..299 -> {
                val motivationalQuote = Result.Success(response.body<MotivationalQuote>())
                return motivationalQuote
            }
            401 -> Result.Error(NetworkError.UNAUTHORIZED)
            408 -> Result.Error(NetworkError.REQUEST_TIMEOUT)
            409 -> Result.Error(NetworkError.CONFLICT)
            413 -> Result.Error(NetworkError.PAYLOAD_TOO_LARGE)
            in 500..599 -> Result.Error(NetworkError.SERVER_ERROR)
            else -> Result.Error(NetworkError.UNKNOWN)
        }
    }

    override suspend fun getSpecificQuotes(tag: String): Result<List<MotivationalQuote>, NetworkError> {
        val response = try {
            httpClient.get(urlString = "https://thequoteshub.com/api/") {
                parameter("tags", tag)
            }
        } catch (e: UnresolvedAddressException) {
            return Result.Error(NetworkError.NO_INTERNET)
        } catch (e: SerializationException) {
            return Result.Error(NetworkError.SERIALIZATION)
        }

        return when (response.status.value) {
            in 200..299 -> {
                val motivationalQuote = Result.Success(response.body<List<MotivationalQuote>>())
                return motivationalQuote
            }
            in 400..499 -> {
                return Result.Error(NetworkError.UNKNOWN)
            }

            in 500..599 -> {
                return Result.Error(NetworkError.SERVER_ERROR)
            }

            else -> {
                return Result.Error(NetworkError.UNKNOWN)
            }
        }
    }
}