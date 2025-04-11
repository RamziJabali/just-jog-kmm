package ramzi.eljabali.justjogkmm.data.network.api.configuration

import io.ktor.client.HttpClient
import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.DEFAULT
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.http.ContentType
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

fun createHttpClient(client: HttpClientEngine): HttpClient {
    return HttpClient(client) {
        install(Logging){
            logger = Logger.DEFAULT
            level = LogLevel.ALL
        }
        install(ContentNegotiation){
            json(
                json = Json {
                    prettyPrint = true
                    isLenient = true
                    // if API returns JSON fields we don't have
                    // defined it will ignore it and will not crash our app
                    ignoreUnknownKeys = true
                },
                contentType = ContentType.Application.Json
            )
        }
    }
}