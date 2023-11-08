package com.stanleymesa.pokedex.features.home.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.stanleymesa.pokedex.features.home.HomeViewModel


@Preview(showBackground = true)
@Composable
fun PokemonCard(
    viewModel: HomeViewModel = hiltViewModel()
) {
    Card(
        modifier = Modifier
            .fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = Color.LightGray)
    ) {
        Box(modifier = Modifier.padding(16.dp)) {
            Text(
                text = "Tes halo nama saya tes\ntt\ntt\ntt\ntt",
                style = MaterialTheme.typography.titleMedium
            )
        }
    }
}
