package com.example.personalgallery

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.personalgallery.ui.theme.PersonalGalleryTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PersonalGalleryTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ){}
            }
        }
    }
}

@Composable
fun GaleriaMoldura(
    IdImagem: Int,
    IdTexto_1: Int,
    IdTexto_2: Int
) {
    Card {
        Column(
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = IdImagem),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(300.dp)
            )

            Text(
                text = stringResource(id = IdTexto_1),
                fontSize = 25.sp,
                modifier = Modifier
                    .padding(3.dp)
            )

            Text(
                text = stringResource(id = IdTexto_2),
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Preview
@Composable
fun PreviewMoldura() {
    PersonalGalleryTheme {
        Column {
            GaleriaMoldura(
                IdImagem = R.drawable.imagem_1,
                IdTexto_1 = R.string.fotografia_1,
                IdTexto_2 = R.string.data_1
            )

            GaleriaMoldura(
                IdImagem = R.drawable.imagem_2,
                IdTexto_1 = R.string.fotografia_2,
                IdTexto_2 = R.string.data_2
            )
        }
    }
}