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
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.wishlistapp.data.Wish
import kotlinx.coroutines.launch
import java.time.format.TextStyle

@Composable
fun AddEditDetailView(
    id : Long ,
    viewModel: WishViewModel ,
    navController: NavController
){
    //snackMessage is also the reason why it takes a little while until oru UI  moves over to another screen
    val snackMessage  =  remember {
        mutableStateOf("")
    }
    // since we're going to do "Add Detail"  method asynchronously we need a scope
    // so now we can use this scope in order to run asynchronous methodssuch as storing data in our database
    val scope = rememberCoroutineScope()

    val scaffoldState = rememberScaffoldState()





    Scaffold(
        scaffoldState = scaffoldState ,
        topBar = {AppBarView(title =
        if(id != 0L) stringResource(id = R.string.update_wish)
        else stringResource(id = R.string.add_wish)
    ) {navController.navigateUp()}


    }){
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
                    if(id != 0L){
                        // TODO UpdateWish

                    }
                    else if(id == 0L){
                        //  AddWish
                        viewModel.addWish(
                            Wish(
                            title = viewModel.wishTitleState.trim() ,
                            description  = viewModel.wishDescriptionState.trim() )
                        )
                        snackMessage.value = "Wish has been created"
                    }
                }
                else {
                        // Enter fields for  wish to be created
                        snackMessage.value = "Enter fields to create a Wish "
                }
                scope.launch {
                     // scaffoldState.snackbarHostState.showSnackbar(snackMessage.value)
                    navController.navigateUp()
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