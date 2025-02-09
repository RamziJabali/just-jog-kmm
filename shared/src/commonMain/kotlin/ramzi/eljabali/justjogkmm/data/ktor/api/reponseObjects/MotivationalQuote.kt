package ramzi.eljabali.justjogkmm.data.ktor.api.reponseObjects

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MotivationalQuote(
    @SerialName("author")
    val author: String?,
    @SerialName("Quote")
    val quote: String?
)
