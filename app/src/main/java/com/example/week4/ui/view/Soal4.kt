package com.example.week4.ui.view

import android.annotation.SuppressLint
import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.week4.R
import com.example.week4.data.DataSource
import com.example.week4.model.Explore

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ViewSoal4(photos: List<Explore>) {
    val context = LocalContext.current

    Scaffold(
        content = {
            LazyVerticalGrid(columns = GridCells.Fixed(3), modifier = Modifier.padding(bottom = 48.dp)) {
                item(span = { GridItemSpan(3) }) {
                    TopNavBar()
                }
                items(photos) {
                    Photos(it, context)
                }
            }
        },
        bottomBar = {
            BottomNavBar()
        }
    )

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopNavBar() {
    var input by rememberSaveable { mutableStateOf("") }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Black)
            .padding(16.dp)
    ) {
        OutlinedTextField(
            value = input,
            onValueChange = { input = it },
            modifier = Modifier
                .fillMaxWidth(),
            shape = RoundedCornerShape(40),
            placeholder = { Text(text = "Search", fontWeight = FontWeight.SemiBold) },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                textColor = Color.White,
                placeholderColor = Color.White
            ),
            leadingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.search),
                    contentDescription = "Search Icon",
                    tint = Color.White
                )
            }
        )
    }
}

@Composable
fun Photos(photo: Explore, context: Context) {
    val contextToast = LocalContext.current
    Image(
        painter = painterResource(id = photo.getPhotoID(context = context)),
        contentDescription = "Picture",
        modifier = Modifier
            .aspectRatio(1f)
            .clickable {
                Toast
                    .makeText(contextToast, photo.fileName, Toast.LENGTH_SHORT)
                    .show()
            },
        contentScale = ContentScale.Crop
    )
}

@Composable
fun BottomNavBar() {
    val contextToast = LocalContext.current
    Row(
        modifier = Modifier
            .background(Color.Black)
            .fillMaxWidth()
            .padding(12.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Icon(
            painterResource(id = R.drawable.home),
            contentDescription = "Home Button",
            tint = Color.White,
            modifier = Modifier.clickable {
                Toast
                    .makeText(contextToast, "Home Clicked", Toast.LENGTH_SHORT)
                    .show()
            }
        )
        Icon(
            painterResource(id = R.drawable.search),
            contentDescription = "Search Button",
            tint = Color.White,
            modifier = Modifier.clickable {
                Toast
                    .makeText(contextToast, "Search Clicked", Toast.LENGTH_SHORT)
                    .show()
            }
        )
        Icon(
            painterResource(id = R.drawable.post),
            contentDescription = "Post Button",
            tint = Color.White,
            modifier = Modifier.clickable {
                Toast
                    .makeText(contextToast, "Post Clicked", Toast.LENGTH_SHORT)
                    .show()
            }
        )
        Icon(
            painterResource(id = R.drawable.reels),
            contentDescription = "Reels Button",
            tint = Color.White,
            modifier = Modifier.clickable {
                Toast
                    .makeText(contextToast, "Reels Clicked", Toast.LENGTH_SHORT)
                    .show()
            }
        )
        Icon(
            painterResource(id = R.drawable.account),
            contentDescription = "Account Button",
            tint = Color.White,
            modifier = Modifier.clickable {
                Toast
                    .makeText(contextToast, "Account Clicked", Toast.LENGTH_SHORT)
                    .show()
            }
        )
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun PreviewSoal4() {
    ViewSoal4(DataSource().loadExplore())
}