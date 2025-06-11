package com.example.challengeapp.ui.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.challengeapp.ui.theme.MainBlue
import com.example.challengeapp.ui.theme.TextBlue

@Composable
fun FormTextfield(
    modifier: Modifier = Modifier,
    inputValue: String,
    onValueChange : (String) -> Unit,
    placeholderText: String,
    keyboardtype: KeyboardType,
    isError: Boolean
) {
    OutlinedTextField(
        modifier = modifier
            .border(width = 2.dp, color = MainBlue, shape = RoundedCornerShape(10.dp)),
        value = inputValue,
        onValueChange = onValueChange,
        shape = RoundedCornerShape(10.dp),
        placeholder = { Text(placeholderText, color = TextBlue, fontSize = 16.sp) },
        keyboardOptions = KeyboardOptions(keyboardType = keyboardtype, imeAction = ImeAction.Next),
        maxLines = 1,
        isError = isError
    )
}

@Preview(showBackground = true)
@Composable
private fun FormTextfieldPreview() {
    FormTextfield(Modifier.padding(20.dp),"", {}, "Nome", KeyboardType.Text, false)
}