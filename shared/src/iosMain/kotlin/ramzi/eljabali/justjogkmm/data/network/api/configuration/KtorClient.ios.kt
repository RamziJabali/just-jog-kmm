package ramzi.eljabali.justjogkmm.data.network.api.configuration

import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.engine.darwin.Darwin

class IosKtorClient: KtorClient {
    override val engine: HttpClientEngine = Darwin.create()
}
actual fun getKtorClient(): KtorClient = IosKtorClient()