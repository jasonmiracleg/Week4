package com.example.week4.ui.view

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape

import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.week4.data.dummy_data
import com.example.week4.R
import com.example.week4.model.line_chat

@Composable
fun ViewSoal1(chats: List<line_chat>) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text(
                text = "Chats",
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp,
                modifier = Modifier.weight(1f)
            )
            Icon(
                painter = painterResource(id = R.drawable.baseline_more_vert_24),
                contentDescription = "More Button",
                tint = Color.White,
                modifier = Modifier.size(30.dp)
            )
        }
        LazyColumn {
            items(chats) {
                ChatLists(it)
            }
        }
    }
}

@Composable
fun ChatLists(chat: line_chat) {
    val context = LocalContext.current
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Black)
            .padding(8.dp)
            .clickable {
                Toast
                    .makeText(
                        context, "${chat.name} Clicked", Toast.LENGTH_SHORT
                    )
                    .show()
            },
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = painterResource(id = R.drawable.baseline_person_24),
            contentDescription = "Profile Picture",
            tint = Color.White,
            modifier = Modifier
                .padding(8.dp)
                .border(width = 1.dp, color = Color.White, shape = CircleShape)
                .background(color = Color.LightGray, shape = CircleShape)
                .size(50.dp)
        )
        Column(modifier = Modifier.padding(start = 8.dp)) {
            Text(
                text = chat.name,
                color = Color.White,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = chat.text,
                color = Color.White,
                fontSize = 14.sp,
                modifier = Modifier.width(225.dp)
            )
        }
        Text(
            text = chat.date, color = Color.White,
            fontSize = 10.sp,
            modifier = Modifier
                .weight(1f)
                .padding(end = 8.dp),
            textAlign = TextAlign.Right
        )
    }

}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun PreviewSoal1() {
//    ChatLists()
    ViewSoal1(dummy_data().get_data_line())
}