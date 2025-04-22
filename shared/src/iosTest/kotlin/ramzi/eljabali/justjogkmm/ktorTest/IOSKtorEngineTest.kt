package ramzi.eljabali.justjogkmm.ktorTest

import kotlin.experimental.ExperimentalNativeApi
import kotlin.test.Test
import ramzi.eljabali.justjogkmm.data.network.api.configuration.IosKtorClient
import ramzi.eljabali.justjogkmm.data.network.api.configuration.KtorClientPlatform

class IOSKtorEngineTest {

    @OptIn(ExperimentalNativeApi::class)
    @Test
    fun testGetIOSEngineTest() {
        val ktorClient = KtorClientPlatform().clientForPlatform
            .toString().substring(0, 41)
        val iosKtorClientString = IosKtorClient().engine
            .toString().substring(0, 41)

        println("Ktor Client Engine String: $ktorClient")

        assert(ktorClient == iosKtorClientString)
    }
}
