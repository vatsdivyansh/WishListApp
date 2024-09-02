package com.example.wishlistapp

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Scaffold
import androidx.compose.material.Text


import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

import androidx.compose.material.TextFieldDefaults
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import java.time.format.TextStyle

@Composable
fun AddEditDetailView(
    id : Long ,
    viewModel: WishViewModel ,
    navController: NavController
){
    Scaffold(topBar = {AppBarView(title =
        if(id != 0L) stringResource(id = R.string.update_wish)
        else stringResource(id = R.string.add_wish)
    )}){
        Column( modifier = Modifier
            .padding(it)
            .wrapContentSize(),
            horizontalAlignment = Alignment.CenterHorizontally ,
            verticalArrangement = Arrangement.Center
        ) {
            Spacer(modifier = Modifier.height(10.dp))
            WishTextField(label = "Title",
                value = viewModel.wishTitleState,
                onValueChanged = {
                viewModel.onWishTitleChanged(it)
            })
            Spacer(modifier = Modifier.height(10.dp))
            WishTextField(label = "Description",
                value = viewModel.wishDescriptionState,
                onValueChanged = {
                    viewModel.onWishDescriptionChanged(it)
                })
            Spacer(modifier = Modifier.height(10.dp))
            Button(onClick = {
                if(viewModel.wishTitleState.isNotEmpty() && viewModel.wishDescriptionState.isNotEmpty()){
                    // TODO UpdateWish
                }
                else {
                    // TODO AddWish
                }
            }) {
                Text(
                    text = if(id != 0L) stringResource(id = R.string.update_wish ) else stringResource(
                        id = R.string.add_wish
                    ), style = androidx.compose.ui.text.TextStyle(fontSize = 18.sp)
                )
            }
        }
    }
}
@Composable
fun WishTextField(label: String ,
                  value: String ,
                  onValueChanged: (String)->Unit){
    OutlinedTextField(
        value = value,
        onValueChange = onValueChanged,
        label = { Text(text = label, color = Color.Black) },
        modifier = Modifier.fillMaxWidth(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            textColor = Color.Black,
            focusedBorderColor = colorResource(id = R.color.black),
            unfocusedBorderColor = colorResource(id = R.color.black),
            cursorColor = colorResource(id = R.color.black),
            focusedLabelColor = colorResource(id = R.color.black),
            unfocusedLabelColor = colorResource(id = R.color.black)
        )
    )
}
//@Preview
//@Composable
//fun WishTestFieldPrev(){
//    WishTextField(label = "text" ,value = "text" , onValueChanged = {})
//}