package com.example.personalgallery

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.personalgallery.data.FonteDados
import com.example.personalgallery.model.ImageDescricaoId
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
                ){
                    AppGallery()
                }
            }
        }
    }
}

@Composable
fun AppGallery()
{
    LazyColumn()
    {
        items(FonteDados().CarregaListDados()){
            galeriaMoldura -> GaleriaMoldura(galeriaMoldura)
        }
    }
}


@Composable
fun GaleriaMoldura(ImageDescricaoId:ImageDescricaoId)
{
    var expandir by remember { mutableStateOf(false) }

    Card (
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        colors = CardDefaults.cardColors(Color(123 ,104, 238)),
        elevation = CardDefaults.cardElevation(5.dp)
            ){
        Column(
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .animateContentSize(
                    animationSpec = spring(
                        dampingRatio = Spring.DampingRatioLowBouncy,
                        stiffness = Spring.StiffnessMedium
                    )
                )
        ) {

            Image(
                painter = painterResource(id = ImageDescricaoId.idFotografia),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(300.dp)
                    .padding(10.dp)
                    .clickable {
                        expandir = !expandir
                    }
            )

            Text(
                text = stringResource(id = ImageDescricaoId.idTexto_1),
                fontSize = 20.sp,
                modifier = Modifier
                    .padding(3.dp)
            )
            if (expandir==true){
                Text(
                    text = stringResource(id = ImageDescricaoId.idTexto_2),
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}

@Preview
@Composable
fun PreviewMoldura() {
    PersonalGalleryTheme {
        Column {
            GaleriaMoldura(
                ImageDescricaoId(R.drawable.foto_8, R.string.fotografia_8, R.string.data_8)
            )
        }
    }
}