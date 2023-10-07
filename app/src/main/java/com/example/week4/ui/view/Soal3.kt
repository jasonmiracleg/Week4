package com.example.week4.ui.view

import android.annotation.SuppressLint
import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.BottomEnd
import androidx.compose.ui.Alignment.Companion.TopEnd
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.week4.R
import com.example.week4.data.DataSource
import com.example.week4.model.Feed
import com.example.week4.model.Story
import com.example.week4.model.Suggestion
import java.text.DecimalFormat

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ViewSoal3(stories: List<Story>, suggestions: List<Suggestion>, feeds: List<Feed>) {
    val context = LocalContext.current
    Scaffold(
        modifier = Modifier.background(Color.Black),
        content = {
            LazyColumn(Modifier.padding(bottom = 47.dp)) {
                item(
                    content = {
                        TopNavigation(context)
                    }
                )
                item(content = {
                    LazyRow(
                        modifier = Modifier
                            .background(Color.Black)
                            .padding(8.dp),
                        horizontalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        item(content = {
                            StoryList(mainUser = true, story = stories[11], context = context)
                        })
                        items(stories) {
                            StoryList(mainUser = false, story = it, context = context)
                        }
                    }
                })
                items(feeds.size) {
                    Feed(feeds[it], context)
                    if ((it + 1) % 6 == 0) {
                        LazyRow(
                            modifier = Modifier
                                .background(Color.Black)
                                .padding(12.dp),
                            horizontalArrangement = Arrangement.spacedBy(16.dp)
                        ) {
                            items(suggestions) {
                                SuggestionList(it, context = context)
                            }
                        }
                    }
                }
            }
        },
        bottomBar = {
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
    )

}

@Composable
fun TopNavigation(context: Context) {
    Row(
        modifier = Modifier
            .background(Color.Black)
            .fillMaxWidth()
            .padding(12.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Image(
            painter = painterResource(id = R.drawable.logo_dark),
            contentDescription = "Logo Instagram",
        )
        Row(Modifier.padding(end = 12.dp)) {
            Icon(
                painter = painterResource(id = R.drawable.like),
                contentDescription = "Instagram Notification",
                tint = Color.White,
                modifier = Modifier
                    .padding(end = 24.dp)
                    .size(25.dp)
                    .aspectRatio(1f)
                    .clickable {
                        Toast
                            .makeText(context, "Notification Clicked", Toast.LENGTH_SHORT)
                            .show()
                    }
            )
            Icon(
                painter = painterResource(id = R.drawable.dm),
                contentDescription = "Messenger",
                tint = Color.White,
                modifier = Modifier
                    .size(25.dp)
                    .aspectRatio(1f)
                    .clickable {
                        Toast
                            .makeText(context, "DM Clicked", Toast.LENGTH_SHORT)
                            .show()
                    }
            )
        }
    }
}

@Composable
fun StoryList(mainUser: Boolean, story: Story, context: Context) {
    Card(
        colors = CardDefaults.cardColors(Color.Black),
        modifier = Modifier.width(100.dp)
    ) {
        Box(contentAlignment = BottomEnd,
            modifier = Modifier.clickable {
                Toast
                    .makeText(
                        context,
                        if (!mainUser) "${story.name} clicked" else "Your Story Clicked",
                        Toast.LENGTH_SHORT
                    )
                    .show()
            }) {
            Image(
                painter = painterResource(id = R.drawable.story),
                contentDescription = "Story",
                modifier = Modifier
                    .size(100.dp)
                    .align(Alignment.Center)
                    .clip(CircleShape)
            )
            Image(
                painter = painterResource(id = story.getProfileID(context)),
                contentDescription = "Personal photo",
                modifier = Modifier
                    .size(85.dp)
                    .clip(shape = CircleShape)
                    .align(Alignment.Center),
                contentScale = ContentScale.Crop,
            )
        }
        Text(
            text = if (mainUser) {
                "Your Story"
            } else {
                story.name
            },
            color = Color.White,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 4.dp)
        )
    }
}

@Composable
fun Feed(feed: Feed, context: Context) {
    var isLiked by rememberSaveable { mutableStateOf(false) }
    var isSaved by rememberSaveable { mutableStateOf(false) }
    var isCaptionClicked by rememberSaveable { mutableStateOf(false) }
    Column(modifier = Modifier.background(Color.Black)) {
        Row(
            modifier = Modifier
                .background(Color.Black)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .padding(vertical = 16.dp)
                    .padding(start = 8.dp)
            ) {
                Image(
                    painter = painterResource(id = feed.getProfilePhoto(context)),
                    contentDescription = "Photo Profile",
                    modifier = Modifier
                        .size(50.dp)
                        .clip(CircleShape),
                    contentScale = ContentScale.Crop
                )
                Text(
                    text = feed.name,
                    color = Color.White,
                    fontSize = 16.sp,
                    modifier = Modifier.padding(start = 8.dp)
                )
            }
            Icon(
                painter = painterResource(id = R.drawable.baseline_more_vert_24),
                contentDescription = "More Button",
                tint = Color.White,
                modifier = Modifier
                    .padding(end = 8.dp)
                    .clickable {
                        Toast
                            .makeText(context, "More Clicked", Toast.LENGTH_SHORT)
                            .show()
                    }
            )
        }
        Image(
            painter = painterResource(id = feed.getFeedPhoto(context)),
            contentDescription = "Feed IG",
            modifier = Modifier.fillMaxWidth(),
            contentScale = ContentScale.Crop
        )
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(20.dp)
            ) {
                if (isLiked) {
                    Image(
                        painter = painterResource(id = R.drawable.liked),
                        contentDescription = "Like Icon",
                        modifier = Modifier.clickable {
                            Toast
                                .makeText(context, "Unliked", Toast.LENGTH_SHORT)
                                .show()
                            isLiked = !isLiked
                        }
                    )
                } else {
                    Icon(
                        painter = painterResource(id = R.drawable.like),
                        contentDescription = "Like Icon",
                        tint = Color.White,
                        modifier = Modifier.clickable {
                            Toast
                                .makeText(context, "Liked", Toast.LENGTH_SHORT)
                                .show()
                            isLiked = !isLiked
                        }
                    )
                }
                Icon(
                    painter = painterResource(id = R.drawable.comment),
                    contentDescription = "Comment Icon",
                    tint = Color.White,
                    modifier = Modifier.clickable {
                        Toast
                            .makeText(context, "Commented", Toast.LENGTH_SHORT)
                            .show()
                    }
                )
                Icon(
                    painter = painterResource(id = R.drawable.messanger),
                    contentDescription = "Share Icon",
                    tint = Color.White,
                    modifier = Modifier.clickable {
                        Toast
                            .makeText(context, "Shared", Toast.LENGTH_SHORT)
                            .show()
                    }
                )
            }
            if (isSaved) {
                Image(
                    painter = painterResource(id = R.drawable.saved_light),
                    contentDescription = "Save Icon",
                    modifier = Modifier.clickable {
                        Toast
                            .makeText(context, "Unsaved", Toast.LENGTH_SHORT)
                            .show()
                        isSaved = !isSaved
                    }
                )
            } else {
                Icon(
                    painter = painterResource(id = R.drawable.save),
                    contentDescription = "Save Icon",
                    tint = Color.White,
                    modifier = Modifier.clickable {
                        Toast
                            .makeText(context, "Saved", Toast.LENGTH_SHORT)
                            .show()
                        isSaved = !isSaved
                    }
                )
            }

        }
        Text(
            text = if (feed.likes == 1) {
                if (isLiked) {
                    "${feed.likes + 1} Like"
                } else {
                    "${feed.likes} Like"
                }
            } else if (feed.likes > 999) {
                val thousandLikes =
                    DecimalFormat("#,###").format(
                        if (isLiked) feed.likes + 1 else feed.likes
                    )
                "$thousandLikes Likes"
            } else {
                if (isLiked) {
                    "${feed.likes + 1} Likes"
                } else {
                    "${feed.likes} Likes"
                }
            },
            color = Color.White,
            modifier = Modifier.padding(start = 12.dp)
        )
        Text(
            buildAnnotatedString {
                withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                    append(feed.name)
                }
                append(" ${feed.caption}")
            },
            color = Color.White,
            modifier = Modifier
                .padding(horizontal = 12.dp)
                .clickable { isCaptionClicked = !isCaptionClicked },
            maxLines = if (!isCaptionClicked) 2 else Int.MAX_VALUE,
            overflow = if (!isCaptionClicked) TextOverflow.Ellipsis else TextOverflow.Visible
        )
        Text(
            text = feed.formatDate(),
            modifier = Modifier.padding(horizontal = 12.dp),
            color = Color.LightGray
        )
    }
}

@Composable
fun SuggestionList(suggestion: Suggestion, context: Context) {
    var isFollowed by rememberSaveable {
        mutableStateOf(false)
    }
    Card(
        colors = CardDefaults.cardColors(Color.Black),
        modifier = Modifier.width(150.dp),
        border = BorderStroke(
            1.dp, Color.White
        )
    ) {
        Column(
            modifier = Modifier.padding(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(contentAlignment = TopEnd) {
                Image(
                    painter = painterResource(id = suggestion.getSuggestionPhoto(context)),
                    contentDescription = "Personal photo",
                    modifier = Modifier
                        .size(130.dp)
                        .clip(shape = CircleShape)
                        .align(Alignment.Center),
                    contentScale = ContentScale.Crop,
                )
            }
            Text(
                text = suggestion.name,
                color = Color.White,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 12.dp, bottom = 8.dp)
            )
            Button(
                onClick = {
                    isFollowed = !isFollowed
                    Toast
                        .makeText(
                            context,
                            if (!isFollowed) "${suggestion.name} Unfollowed" else "${suggestion.name} Followed",
                            Toast.LENGTH_SHORT
                        )
                        .show()
                },
                colors = if (!isFollowed) ButtonDefaults.buttonColors(
                    Color(0xFF409CEC)
                ) else ButtonDefaults.buttonColors(
                    Color.Gray
                ),
                shape = RoundedCornerShape(35)
            ) {
                if (!isFollowed) {
                    Text(
                        text = "Follow",
                        color = Color.White,
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.Bold,
                        fontSize = 14.sp,
                    )
                } else {
                    Text(
                        text = "Unfollow",
                        color = Color.White,
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.Bold,
                        fontSize = 14.sp,
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = false)
@Composable
fun PreviewSoal3() {
    ViewSoal3(DataSource().loadStory(), DataSource().loadSuggestion(), DataSource().loadFeed())
}