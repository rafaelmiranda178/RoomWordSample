package br.com.rafaelmiranda.roomwordsample

import android.app.Application
import br.com.rafaelmiranda.roomwordsample.di.dbModule
import br.com.rafaelmiranda.roomwordsample.di.repositoryModule
import br.com.rafaelmiranda.roomwordsample.di.uiModule
import br.com.rafaelmiranda.roomwordsample.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyApplication : Application() {
    override fun onCreate(){
        super.onCreate()
        // start Koin!
        startKoin {
            // declare used Android context
            androidContext(this@MyApplication)
            // declare modules
            modules(
                listOf(
                    viewModelModule,
                    uiModule,
                    repositoryModule,
                    dbModule
                )
            )
        }
    }
}