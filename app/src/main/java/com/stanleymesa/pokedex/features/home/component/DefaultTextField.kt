package com.stanleymesa.pokedex.features.home.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.stanleymesa.pokedex.ui.theme.LightGrey

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun DefaultEditText(
    modifier: Modifier = Modifier,
    onValueChange: (String) -> Unit = {},
    value: String = "",
    hint: String = "Search..."
) {
    Box(modifier = modifier) {
        TextField(
            value = value,
            onValueChange = { onValueChange.invoke(it) },
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp)
                .shadow(
                    elevation = 8.dp,
                    shape = RoundedCornerShape(16.dp)
                ),
            shape = RoundedCornerShape(16.dp),
            colors = TextFieldDefaults.textFieldColors(
                containerColor = Color.White,
                unfocusedIndicatorColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent,
                textColor = Color.Black
            ),
            textStyle = MaterialTheme.typography.bodyMedium,
            maxLines = 1,
            placeholder = {
                Text(
                    text = hint,
                    style = MaterialTheme.typography.bodyMedium,
                    color = LightGrey
                )
            },
        )
    }
}