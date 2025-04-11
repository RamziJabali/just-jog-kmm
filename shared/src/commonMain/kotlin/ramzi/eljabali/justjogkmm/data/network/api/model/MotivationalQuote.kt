package ramzi.eljabali.justjogkmm.data.network.api.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MotivationalQuote(
    @SerialName("author")
    val author: String?,
    @SerialName("Quote")
    val quote: String?,
    @SerialName("total_quotes")
    val totalQuotes: Int?,
    @SerialName("tags")
    val tags: List<String>?
)
