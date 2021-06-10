package ru.android.anothermvvmrickandmorty

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import ru.android.anothermvvmrickandmorty.presentation.MainActivityContract
import ru.android.anothermvvmrickandmorty.presentation.character.CharacterFragmentDirections
import ru.android.anothermvvmrickandmorty.presentation.characters.CharactersFragmentDirections
import ru.android.anothermvvmrickandmorty.presentation.episode.EpisodeFragmentDirections
import ru.android.anothermvvmrickandmorty.presentation.episodes.EpisodesFragmentDirections
import ru.android.anothermvvmrickandmorty.presentation.home.HomeFragmentDirections
import ru.android.anothermvvmrickandmorty.presentation.location.LocationFragmentDirections
import ru.android.anothermvvmrickandmorty.presentation.locations.LocationsFragmentDirections
import ru.android.anothermvvmrickandmorty.presentation.utils.navigateWithAnimations

class MainActivity : AppCompatActivity(), MainActivityContract {

    private val navHostFragmentId = R.id.main_nav_host_fragment
    private val navController by lazy { findNavController(navHostFragmentId) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun openCharactersScreen() {
        navController.navigateWithAnimations(
            HomeFragmentDirections.actionHomeFragmentToCharactersFragment()
        )
    }

    override fun openCharacterScreenOne(id: Int) {
        navController.navigateWithAnimations(
            CharactersFragmentDirections.actionCharactersFragmentToCharacterFragment(id)
        )
    }

    override fun openCharacterScreenTwo(id: Int) {
        navController.navigateWithAnimations(
            EpisodeFragmentDirections.actionEpisodeFragmentToCharacterFragment(id)
        )
    }

    override fun openLocationsScreen() {
        navController.navigateWithAnimations(
            HomeFragmentDirections.actionHomeFragmentToLocationsFragment()
        )
    }

    override fun openLocationScreenOne(id: Int) {
        navController.navigateWithAnimations(
            LocationsFragmentDirections.actionLocationsFragmentToLocationFragment(id)
        )
    }

    override fun openLocationScreenTwo(id: Int) {
        navController.navigateWithAnimations(
            LocationFragmentDirections.actionLocationFragmentToCharacterFragment(id)
        )
    }

    override fun openEpisodesScreen() {
        navController.navigateWithAnimations(
            HomeFragmentDirections.actionHomeFragmentToEpisodesFragment()
        )
    }

    override fun openEpisodeScreenOne(id: Int) {
        navController.navigateWithAnimations(
            EpisodesFragmentDirections.actionEpisodesFragmentToEpisodeFragment(id)
        )
    }

    override fun openEpisodeScreenTwo(id: Int) {
        navController.navigateWithAnimations(
            CharacterFragmentDirections.actionCharacterFragmentToEpisodeFragment(id)
        )
    }

}