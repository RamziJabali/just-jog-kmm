package ramzi.eljabali.justjogkmm.di

import org.koin.core.module.Module
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module
import ramzi.eljabali.justjogkmm.data.network.api.configuration.KtorClient
import ramzi.eljabali.justjogkmm.data.network.api.configuration.createHttpClient
import ramzi.eljabali.justjogkmm.data.network.api.configuration.getKtorClient
import ramzi.eljabali.justjogkmm.data.repositories.implementations.MotivationalQuotesRepositoryImpl
import ramzi.eljabali.justjogkmm.domain.repository.MotivationalQuotesRepository

expect val platformModule: Module

val quotesRepositoryModule = module {
    single<KtorClient> { getKtorClient() } // expect/actual will resolve correctly

    single { createHttpClient(get<KtorClient>().engine) }

    singleOf(::MotivationalQuotesRepositoryImpl).bind<MotivationalQuotesRepository>()
}
