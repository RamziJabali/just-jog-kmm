package ramzi.eljabali.justjogkmm.data.network.api.configuration

import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.engine.okhttp.OkHttp

class AndroidKtorClient : KtorClient {
    override val engine: HttpClientEngine = OkHttp.create()
}

actual fun getKtorClient(): KtorClient = AndroidKtorClient()
