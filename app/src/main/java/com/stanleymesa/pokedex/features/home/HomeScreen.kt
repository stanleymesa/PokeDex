package com.stanleymesa.pokedex.features.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.stanleymesa.pokedex.R
import com.stanleymesa.pokedex.features.home.component.DefaultEditText
import com.stanleymesa.pokedex.features.home.component.PokemonCard

@Composable
fun HomeScreen(
    navController: NavController,
    viewModel: HomeViewModel = hiltViewModel(),
) {
    val state = viewModel.state.value

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Box(modifier = Modifier.fillMaxWidth()) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .align(Alignment.TopCenter)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.img_pokemon_logo),
                    contentDescription = stringResource(id = R.string.content),
                    modifier = Modifier.fillMaxWidth(),
                    alignment = Alignment.TopCenter,
                    contentScale = ContentScale.Fit,
                )
                Spacer(modifier = Modifier.height(16.dp))
                DefaultEditText(
                    modifier = Modifier.fillMaxWidth(),
                    onValueChange = {
                        viewModel.onEvent(HomeEvent.SearchText(it))
                    },
                    value = state.searchText,
                    hint = stringResource(id = R.string.search_pokemon)
                )
                Spacer(modifier = Modifier.height(24.dp))
                PokemonCard()
            }
        }
    }
}
