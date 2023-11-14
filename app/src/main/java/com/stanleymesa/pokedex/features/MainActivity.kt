package com.stanleymesa.pokedex.features

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.stanleymesa.pokedex.features.home.HomeScreen
import com.stanleymesa.pokedex.features.home.HomeViewModel
import com.stanleymesa.pokedex.ui.theme.PokeDexTheme
import com.stanleymesa.pokedex.utils.screen.Screen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PokeDexTheme(darkTheme = false, dynamicColor = false) {
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = Screen.Home.route
                ) {
                    composable(
                        route = Screen.Home.route
                    ) {
                        val viewModel: HomeViewModel = hiltViewModel()
                        HomeScreen(
                            navController = navController,
//                            state = { viewModel.state.value }  ,
                            onEvent = viewModel::onEvent,
                            stateSearch = viewModel.stateSearch,
                            stateTest = viewModel.stateTest,
                        )
                    }
//                        composable(
//                            route = "${Screen.Detail.route}/{dominantColor}/{pokemonName}",
//                            arguments = listOf(
//                                navArgument("dominantColor") {
//                                    type = NavType.IntType
//                                },
//                                navArgument("pokemonName") {
//                                    type = NavType.StringType
//                                },
//                            )
//                        ) {
//                            val dominantColor = remember {
//                                val color = it.arguments?.getInt("dominantColor")
//                                color?.let { Color(it) } ?: Color.White
//                            }
//                            val pokemonName = remember {
//                                it.arguments?.getString("pokemonName").orEmpty()
//                            }
//                        }
                }
            }
        }
    }
}
