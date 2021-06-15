package ru.android.anothermvvmrickandmorty.app

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import ru.android.anothermvvmrickandmorty.data.character.CharacterDataSourceImpl
import ru.android.anothermvvmrickandmorty.data.characters.CharactersDataSourceImpl
import ru.android.anothermvvmrickandmorty.data.episode.EpisodeDataSourceImpl
import ru.android.anothermvvmrickandmorty.data.episodes.EpisodesDataSourceImpl
import ru.android.anothermvvmrickandmorty.data.location.LocationDataSourceImpl
import ru.android.anothermvvmrickandmorty.data.locations.LocationsDataSourceImpl
import ru.android.anothermvvmrickandmorty.domain.character.CharacterDataSource
import ru.android.anothermvvmrickandmorty.domain.character.CharacterInteractor
import ru.android.anothermvvmrickandmorty.domain.character.CharacterInteractorImpl
import ru.android.anothermvvmrickandmorty.domain.characters.CharactersDataSource
import ru.android.anothermvvmrickandmorty.domain.characters.CharactersInteractor
import ru.android.anothermvvmrickandmorty.domain.characters.CharactersInteractorImpl
import ru.android.anothermvvmrickandmorty.domain.episode.EpisodeDataSource
import ru.android.anothermvvmrickandmorty.domain.episode.EpisodeInteractor
import ru.android.anothermvvmrickandmorty.domain.episode.EpisodeInteractorImpl
import ru.android.anothermvvmrickandmorty.domain.episodes.EpisodesDataSource
import ru.android.anothermvvmrickandmorty.domain.episodes.EpisodesInteractor
import ru.android.anothermvvmrickandmorty.domain.episodes.EpisodesInteractorImpl
import ru.android.anothermvvmrickandmorty.domain.location.LocationDataSource
import ru.android.anothermvvmrickandmorty.domain.location.LocationInteractor
import ru.android.anothermvvmrickandmorty.domain.location.LocationInteractorImpl
import ru.android.anothermvvmrickandmorty.domain.locations.LocationsDataSource
import ru.android.anothermvvmrickandmorty.domain.locations.LocationsInteractor
import ru.android.anothermvvmrickandmorty.domain.locations.LocationsInteractorImpl
import ru.android.anothermvvmrickandmorty.presentation.character.CharacterViewModel
import ru.android.anothermvvmrickandmorty.presentation.characters.CharactersViewModel
import ru.android.anothermvvmrickandmorty.presentation.episodes.EpisodesViewModel
import ru.android.anothermvvmrickandmorty.presentation.locations.LocationsViewModel

private val allModules = module {

    viewModel {
        CharactersViewModel(
            charactersInteractor = get()
        )
    }

    viewModel {
        CharacterViewModel(
            characterInteractor = get()
        )
    }

    viewModel {
        EpisodesViewModel(
            episodesInteractor = get()
        )
    }

    viewModel {
        LocationsViewModel(
            locationsInteractor = get()
        )
    }

    single<CharacterDataSource> {
        CharacterDataSourceImpl()
    }

    single<CharactersDataSource> {
        CharactersDataSourceImpl()
    }

    single<EpisodeDataSource> {
        EpisodeDataSourceImpl()
    }

    single<EpisodesDataSource> {
        EpisodesDataSourceImpl()
    }

    single<LocationDataSource> {
        LocationDataSourceImpl()
    }

    single<LocationsDataSource> {
        LocationsDataSourceImpl()
    }

    single<CharacterInteractor> {
        CharacterInteractorImpl(
            characterDataSource = get()
        )
    }

    single<CharactersInteractor> {
        CharactersInteractorImpl(
            charactersDataSource = get()
        )
    }

    single<EpisodeInteractor> {
        EpisodeInteractorImpl(
            episodeDataSource = get()
        )
    }

    single<EpisodesInteractor> {
        EpisodesInteractorImpl(
            episodesDataSource = get()
        )
    }

    single<LocationInteractor> {
        LocationInteractorImpl(
            locationDataSource = get()
        )
    }

    single<LocationsInteractor> {
        LocationsInteractorImpl(
            locationsDataSource = get()
        )
    }

}

val modules = listOf(allModules)
