package com.example.cn333as5.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp

@Composable
fun SearchItem(searchBy: MutableState<String>) {
    Row(modifier = Modifier.fillMaxWidth()) {
        TextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp),
            value = searchBy.value,
            label = { Text("Search") },
            singleLine = true,
            onValueChange = {searchBy.value=it},
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Text,autoCorrect = false),
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = MaterialTheme.colors.surface
            )
        )
    }
}