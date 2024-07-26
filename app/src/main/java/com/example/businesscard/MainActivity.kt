package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Phone
import androidx.compose.material.icons.rounded.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BusinessCardTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ComposableCard()
                }
            }
        }
    }
}

@Composable
fun ComposableHead(modifier: Modifier = Modifier) {
    val image = painterResource(id = R.drawable.android_logo)
    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Box(
            Modifier
                .background(Color(0xFF073042))
                .width(150.dp)
                .height(150.dp)
        ) {
            Image(
                painter = image,
                contentDescription = null,
                modifier = Modifier.fillMaxSize()
            )
        }
        Text(
            text = stringResource(R.string.card_full_name),
            fontSize = 60.sp
        )
        Text(
            text = stringResource(R.string.card_title),
            fontSize = 15.sp,
            color = Color(0xFF1F7C4D)
        )
    }
}

@Composable
fun ComposableItem(
    imageVector: ImageVector,
    contentDescription: String,
    itemText: String,
    modifier: Modifier = Modifier
) {
    Row {
        Icon(
            imageVector = imageVector,
            contentDescription = contentDescription,
            modifier = Modifier
                .size(20.dp)
                .align(Alignment.CenterVertically),
            tint = Color(0xFF006D3B)
        )
        Text(
            text = itemText,
            fontSize = 12.sp,
            modifier = Modifier.padding(start = 10.dp)
        )
    }
}

@Composable
fun ComposableItems(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.TopCenter
    ) {
        Column {
            ComposableItem(
                imageVector = Icons.Rounded.Phone,
                contentDescription = "phone",
                itemText = "+11(123) 444 555 666"
            )
            ComposableItem(
                imageVector = Icons.Rounded.Share,
                contentDescription = "share",
                itemText = "@AndroidDev"
            )
            ComposableItem(
                imageVector = Icons.Rounded.Email,
                contentDescription = "email",
                itemText = "brucelee@android.com"
            )
        }
    }
}

@Composable
fun ComposableCard() {
    Column(
        Modifier
            .fillMaxSize()
            .background(Color(0xFFD2E8D4)),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ComposableHead(Modifier.weight(4f))
        ComposableItems(Modifier.weight(1f))
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BusinessCardTheme {
        ComposableCard()
    }
}