package com.stanleymesa.pokedex.features.home.component

import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.palette.graphics.Palette
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.stanleymesa.pokedex.R
import com.stanleymesa.pokedex.domain.model.PokemonList
import com.stanleymesa.pokedex.features.home.HomeEvent


@Composable
fun PokemonCard(
    modifier: Modifier = Modifier,
    pokemonList: PokemonList = PokemonList(),
) {

    val dominant = remember {
        mutableStateOf(Color.LightGray)
    }

    Card(
        colors = CardDefaults.cardColors(containerColor = dominant.value),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    brush = Brush.verticalGradient(
                        listOf(
                            Color.Transparent,
                            Color.White.copy(alpha = 1f)
                        )
                    )
                )
                .padding(16.dp),
            horizontalAlignment = CenterHorizontally
        ) {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(pokemonList.imageUrl)
                    .placeholder(R.drawable.img_pokemon_silhouette)
                    .crossfade(true)
                    .build(),
                contentDescription = stringResource(id = R.string.content),
                modifier = Modifier
                    .size(120.dp)
                    .height(120.dp),
                onSuccess = { success ->
                    calcDominantColor(
                        success.result.drawable
                    ) {
                        dominant.value = it
                    }
                }
            )
            Spacer(modifier = Modifier.height(24.dp))
            Text(
                text = pokemonList.name,
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onPrimary,
                modifier = Modifier.align(CenterHorizontally)
            )
        }
    }
}

fun calcDominantColor(drawable: Drawable, onFinish: (Color) -> Unit) {
    val bitmap = (drawable as BitmapDrawable).bitmap.copy(Bitmap.Config.ARGB_8888, true)

    Palette.from(bitmap).generate { palette ->
        palette?.dominantSwatch?.rgb?.let { colorValue ->
            onFinish(Color(colorValue))
        }
    }
}
