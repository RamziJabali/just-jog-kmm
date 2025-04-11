package ramzi.eljabali.justjogkmm.domain.repository

import ramzi.eljabali.justjogkmm.data.network.api.model.MotivationalQuote
import ramzi.eljabali.justjogkmm.util.NetworkError
import ramzi.eljabali.justjogkmm.util.Result

interface MotivationalQuotesRepository {
    suspend fun getRandomQuotes(): Result<MotivationalQuote, NetworkError>
    suspend fun getSpecificQuotes(tag: String): Result<List<MotivationalQuote>, NetworkError>
}