package ramzi.eljabali.justjogkmm.data.repositories.implementations

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.headers
import io.ktor.client.request.parameter
import io.ktor.util.network.UnresolvedAddressException
import kotlinx.serialization.SerializationException
import ramzi.eljabali.justjogkmm.data.network.api.model.Quote
import ramzi.eljabali.justjogkmm.domain.repository.MotivationalQuotesRepository
import ramzi.eljabali.justjogkmm.shared.BuildKonfig
import ramzi.eljabali.justjogkmm.util.NetworkError
import ramzi.eljabali.justjogkmm.util.Result

class MotivationalQuotesRepositoryImpl(
    private val httpClient: HttpClient // TODO: Inject this
) : MotivationalQuotesRepository {
    companion object {
        private const val TAG = "MotivationalQuotesRepository"
        private const val BASE_URL = "https://api.api-ninjas.com/v1/quotes"
    }

    override suspend fun getRandomQuotes(): Result<Quote, NetworkError> {
        val response = try {
            httpClient.get(urlString = BASE_URL) {
                headers {
                    append(
                        "X-Api-Key",
                        value = BuildKonfig.QUOTES_API_KEY
                    )
                }
            }
        } catch (e: UnresolvedAddressException) {
            return Result.Error(NetworkError.NO_INTERNET)
        } catch (e: SerializationException) {
            return Result.Error(NetworkError.SERIALIZATION)
        }

        return when (response.status.value) {
            in 200..299 -> {
                val quote = Result.Success(response.body<Quote>())
                Result.Success(quote.data)
            }

            401 -> Result.Error(NetworkError.UNAUTHORIZED)
            408 -> Result.Error(NetworkError.REQUEST_TIMEOUT)
            409 -> Result.Error(NetworkError.CONFLICT)
            413 -> Result.Error(NetworkError.PAYLOAD_TOO_LARGE)
            in 500..599 -> Result.Error(NetworkError.SERVER_ERROR)
            else -> Result.Error(NetworkError.UNKNOWN)
        }
    }

    override suspend fun getSpecificQuotes(tag: String): Result<List<Quote>, NetworkError> {
        val response = try {
            httpClient.get(urlString = BASE_URL) {
                parameter("tags", tag)
                headers {
                    append(
                        "X-Api-key",
                        BuildKonfig.QUOTES_API_KEY
                    )
                }
            }
        } catch (e: UnresolvedAddressException) {
            return Result.Error(NetworkError.NO_INTERNET)
        } catch (e: SerializationException) {
            return Result.Error(NetworkError.SERIALIZATION)
        }

        return when (response.status.value) {
            in 200..299 -> {
                val quote = Result.Success(response.body<List<Quote>>())
                Result.Success(quote.data)
            }

            401 -> Result.Error(NetworkError.UNAUTHORIZED)
            408 -> Result.Error(NetworkError.REQUEST_TIMEOUT)
            409 -> Result.Error(NetworkError.CONFLICT)
            413 -> Result.Error(NetworkError.PAYLOAD_TOO_LARGE)
            in 500..599 -> Result.Error(NetworkError.SERVER_ERROR)
            else -> Result.Error(NetworkError.UNKNOWN)
        }
    }
}
