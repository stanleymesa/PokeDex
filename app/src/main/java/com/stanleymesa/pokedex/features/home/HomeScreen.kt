package com.stanleymesa.pokedex.features.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.stanleymesa.pokedex.R
import com.stanleymesa.pokedex.features.home.component.DefaultEditText
import com.stanleymesa.pokedex.features.home.component.PokemonCard
import com.stanleymesa.pokedex.ui.theme.PokeDexTheme
import com.stanleymesa.pokedex.utils.asState
import com.stanleymesa.pokedex.utils.loge
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

@Composable
fun HomeScreen(
    stateFlow: () -> StateFlow<HomeState>,
    onEvent: (HomeEvent) -> Unit
) {
    loge("render home screen")

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Box(modifier = Modifier.fillMaxWidth()) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
                    .align(Alignment.TopCenter)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.img_pokemon_logo),
                    contentDescription = stringResource(id = R.string.content),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 16.dp),
                    alignment = Alignment.TopCenter,
                    contentScale = ContentScale.Fit,
                )
                Spacer(modifier = Modifier.height(16.dp))
                DefaultEditText(
                    modifier = Modifier.fillMaxWidth(),
                    onValueChange = {
                        onEvent(HomeEvent.SearchText(it))
                    },
                    value = stateFlow().asState().searchText,
                    hint = stringResource(id = R.string.search_pokemon)
                )
                Spacer(modifier = Modifier.height(24.dp))
                LazyVerticalGrid(
                    modifier = Modifier.fillMaxSize(),
                    columns = GridCells.Fixed(2),
                    verticalArrangement = Arrangement.spacedBy(16.dp),
                    horizontalArrangement = Arrangement.spacedBy(16.dp),
                    contentPadding = PaddingValues(bottom = 24.dp)
                ) {
                    loge("render grid")
                    items(
                        count = 10,
                    ) {
                        PokemonCard()
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    PokeDexTheme(darkTheme = false, dynamicColor = false) {
        HomeScreen(
            stateFlow = { MutableStateFlow(HomeState()) },
            onEvent = {}
        )
    }
}

