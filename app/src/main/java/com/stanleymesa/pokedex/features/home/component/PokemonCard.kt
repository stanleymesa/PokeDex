package com.stanleymesa.pokedex.features.home.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.stanleymesa.pokedex.R


@Preview(showBackground = true)
@Composable
fun PokemonCard(
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier,
        colors = CardDefaults.cardColors(containerColor = Color.Yellow),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
    ) {
        Column(
            modifier = Modifier
                .background(
                    brush = Brush.verticalGradient(
                        listOf(
                            Color.Transparent,
                            Color.White.copy(alpha = 1f)
                        )
                    )
                )
                .padding(16.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.img_pikachu),
                contentDescription = stringResource(
                    id = R.string.content
                ),
            )
            Spacer(modifier = Modifier.height(24.dp))
            Text(
                text = "Pikachu",
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.align(CenterHorizontally)
            )
        }
    }
}
