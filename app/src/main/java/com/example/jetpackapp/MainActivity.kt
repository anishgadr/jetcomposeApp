package com.example.jetpackapp

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.indication
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackapp.ui.theme.JetPackAppTheme
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val painter = painterResource(id = R.drawable.tree)
            val desc = "Keremit in the snow"
            val title = "Kermit LALAL"
            Box(modifier = Modifier
                .fillMaxWidth(0.3f)
                .padding(16.dp)) {
                ImageCard(
                    painter = painter,
                    contentDesc = desc,
                    title = title
                )
            }


          //  ColorBox(Modifier.fillMaxSize())
//            Row(modifier = Modifier
//                .background(Color.Blue)
//                .fillMaxSize(), verticalAlignment = Alignment.CenterVertically) {
//                Text(text = "Anish")
//                Spacer(modifier = Modifier.width(5.dp))
//                Text(text = "GG")
//            }


        }
    }

    @Composable
    fun ImageCard(painter: Painter, contentDesc: String, title:String, modifier: Modifier = Modifier){
       Card(modifier = modifier.fillMaxWidth(), shape = RoundedCornerShape(15.dp), elevation = 5.dp ) {
           Box(modifier = Modifier.height(400.dp)){
            Image(painter = painter, contentDescription = contentDesc, modifier = Modifier.fillMaxSize(),contentScale = ContentScale.Crop, alignment = Alignment.Center )
              
               Box(modifier = Modifier
                   .fillMaxSize()
                   .background(
                       brush = Brush.verticalGradient(
                           colors = listOf(
                               Color.Transparent,
                               Color.Black
                           ),
                           startY = 100f
                       )
                   ))
              
               Box(modifier = Modifier
                   .fillMaxSize()
                   .padding(12.dp),
                   contentAlignment = Alignment.BottomCenter){
                   Column() {
                       Text(text = title, style = TextStyle(color = Color.White, fontSize = 16.sp,))
                       Text(text = contentDesc, style = TextStyle(color = Color.White, fontSize = 16.sp,))
                   }

               }


           }

       }

    }

    @SuppressLint("UnrememberedMutableState")
    @Composable
    fun ColorBox(modifier: Modifier= Modifier){
        val color = remember { mutableStateOf(Color.Yellow)}
        Box(modifier = modifier
            .background(color.value)
            .clickable {
                color.value = Color(
                    Random.nextFloat(),
                    Random.nextFloat(),
                    Random.nextFloat(),
                    1f
                )
            }


        )
    }
}

