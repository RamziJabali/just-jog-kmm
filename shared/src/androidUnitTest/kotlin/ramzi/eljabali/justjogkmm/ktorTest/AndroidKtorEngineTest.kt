package ramzi.eljabali.justjogkmm.ktorTest

import org.junit.Test
import ramzi.eljabali.justjogkmm.data.network.api.configuration.AndroidKtorClient
import ramzi.eljabali.justjogkmm.data.network.api.configuration.KtorClientPlatform

class AndroidKtorEngineTest {

    @Test
    fun testGetAndroidEngineTest() {
        val ktorClient = KtorClientPlatform().clientForPlatform
            .toString().substring(0, 41)
        val androidKtorClientString = AndroidKtorClient().engine
            .toString().substring(0, 41)

        println("Ktor Client Engine String: $ktorClient")

        assert(ktorClient == androidKtorClientString)
    }
}
