package ramzi.eljabali.justjogkmm.data.network.api.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Quote(
    @SerialName("quote")
    val quote: String?,
    @SerialName("author")
    val author: String?,
    @SerialName("tags")
    val tags: List<String>?
)
