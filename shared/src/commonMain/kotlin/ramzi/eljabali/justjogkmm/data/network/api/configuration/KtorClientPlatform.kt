package ramzi.eljabali.justjogkmm.data.network.api.configuration

import io.ktor.client.engine.HttpClientEngine

class KtorClientPlatform {
    val clientForPlatform: HttpClientEngine = getKtorClient().engine
}

interface KtorClient {
    val engine: HttpClientEngine
}

expect fun getKtorClient(): KtorClient
