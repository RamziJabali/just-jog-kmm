package ramzi.eljabali.justjogkmm.data.ktor.api.definitions

import ramzi.eljabali.justjogkmm.data.ktor.api.reponseObjects.MotivationalQuote

interface MotivationalQuotesAPI {
    suspend fun getRandomQuotes(): MotivationalQuote
}