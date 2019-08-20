package br.com.rafaelmiranda.roomwordsample.di

import androidx.room.Room
import br.com.rafaelmiranda.roomwordsample.WordListAdapter
import br.com.rafaelmiranda.roomwordsample.WordViewModel
import br.com.rafaelmiranda.roomwordsample.dao.WordRoomDatabase
import br.com.rafaelmiranda.roomwordsample.repository.WordRepository
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val dbModule = module {
    single {
        Room.databaseBuilder(
            get(),
            WordRoomDatabase::class.java,
            "Word_database"
        ).build()
    }

    single {
        get<WordRoomDatabase>().wordDao()
    }
}

val repositoryModule = module {
    single{
        WordRepository(get())
    }
}

val uiModule = module {
    factory { WordListAdapter(get()) }
}

val viewModelModule = module {
    viewModel { WordViewModel(get(), get ()) }
}