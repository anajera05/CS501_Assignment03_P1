package com.example.a03_01

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.a03_01.ui.theme._03_01Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AssignmentPreview()
        }
    }
}

@Composable
fun StyledBox() {
    // row to hold all the boxes
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(300.dp)
            .border(1.dp, Color.Black),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // section 1
        WeightedBox("25% W, 100% H ", Modifier.weight(1f, fill = true), Color.Yellow)
        // section 2
        Column( // stacks the 3 different weighted children
            modifier = Modifier
                .weight(3f, fill = true)
                .fillMaxHeight()
                .border(1.dp, Color.Black),
        ){
            WeightedBox("75% W, 20% H", Modifier.weight(2f, fill = true), Color.Red)
            WeightedBox("75% W, 30% H", Modifier.weight(3f, fill = true), Color.Magenta)
            WeightedBox("75% W, 50% H", Modifier.weight(5f, fill = true), Color.LightGray)

        }

    }
}

@Composable
fun WeightedBox( // used to create a boxes with a weight
    text: String,
    modifier: Modifier = Modifier, // This modifier will include the .weight()
    backgroundColor: Color){
    Box(
        // modifer ensures no white space and fills the weight
        modifier = modifier
            .fillMaxHeight()
            .fillMaxWidth()
            .background(backgroundColor)
            .border(1.dp, Color.Black),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = text,
            fontSize = 20.sp,
            color = Color.Black,
            textAlign = TextAlign.Center
        )
    }
}

@Preview(showBackground = true)
@Composable
fun AssignmentPreview() {
    _03_01Theme {
        StyledBox()
    }
}