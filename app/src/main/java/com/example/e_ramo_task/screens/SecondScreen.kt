package com.example.e_ramo_task.screens

import android.graphics.Color.parseColor
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.e_ramo_task.PaletteGenerator
import com.example.e_ramo_task.R

@Composable
fun SecondScreen(
    selectedImageUrl: String,
    paletteViewModel: PaletteViewModel = viewModel(),
    navHostController: NavHostController
) {
    val context = LocalContext.current

    val colorPalette by paletteViewModel.colorPalette
//    ScreenContent(selectedImageUrl, colorPalette)
    if (colorPalette.isNotEmpty()) {
        ScreenContent(selectedImageUrl, colorPalette)

    } else {
        paletteViewModel.generatePaletteColor()

    }

    LaunchedEffect(key1 = true) {
        paletteViewModel.uiState.collect { uiEvent ->
            when (uiEvent) {
                is UiEvent.GenerateColorPalette -> {
                    val bitmap = PaletteGenerator.convertImageUrlToBitmap(
                        imageUrl = selectedImageUrl,
                        context = context
                    )
                    if (bitmap != null) {
                        paletteViewModel.setColorPalette(
                            colors = PaletteGenerator.extractColorsFromBitmap(
                                bitmap = bitmap
                            )
                        )
                    }
                }
            }

        }
    }


}

@Composable
fun ScreenContent(selectedImageUrl: String, colorPalette: Map<String, String>) {
    var vibrant by remember { mutableStateOf("#000000") }
    var darkVibrant by remember { mutableStateOf("#000000") }
    var lightVibrant by remember { mutableStateOf("#000000") }
    var domainSwatch by remember { mutableStateOf("#000000") }
    var mutedSwatch by remember { mutableStateOf("#000000") }
    var lightMutedSwatch by remember { mutableStateOf("#000000") }
    var darkMutedSwatch by remember { mutableStateOf("#000000") }
    var onDarkVibrant by remember { mutableStateOf("#ffffff") }

    // get the colors from the Map
    LaunchedEffect(key1 = true) {
        vibrant = colorPalette["vibrant"]!!
        darkVibrant = colorPalette["darkVibrant"]!!
        lightVibrant = colorPalette["lightVibrant"]!!
        domainSwatch = colorPalette["domainSwatch"]!!
        mutedSwatch = colorPalette["mutedSwatch"]!!
        lightMutedSwatch = colorPalette["lightMuted"]!!
        darkMutedSwatch = colorPalette["darkMuted"]!!
        onDarkVibrant = colorPalette["onDarkVibrant"]!!
    }


    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        val itemCount = 12
        itemsIndexed((1..itemCount).toList()) { index, item ->
            Surface(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(120.dp),
                shape = RoundedCornerShape(12.dp),
                color = Color(parseColor(darkVibrant))
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(8.dp),
                    horizontalArrangement = Arrangement.spacedBy(12.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Surface(
                        modifier = Modifier
                            .size(80.dp)
                            .clip(RoundedCornerShape(8.dp))
                            .background(Color.White)
                    ) {
                        AsyncImage(
                            model = ImageRequest.Builder(LocalContext.current)
                                .data(selectedImageUrl)
                                .crossfade(true)
                                .placeholder(R.drawable.ic_loading)
                                .error(R.drawable.ic_error)
                                .build(),
                            contentDescription = "",
                            contentScale = ContentScale.Crop                        )
                    }
                    Column {
                        Text(
                            text = "Lorem",
                            color = Color(parseColor(lightMutedSwatch)),
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit",
                            color = Color(parseColor(onDarkVibrant)),
                            maxLines = 2
                        )
                    }
                }
            }

            // After every 3rd item (excluding the last), insert a text element
            if ((index + 1) % 3 == 0 && index < itemCount - 3) {
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        "Ads.",
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp),
                        textAlign = TextAlign.Center,
                        color = Color(parseColor(domainSwatch)),
                        fontWeight = FontWeight.Bold
                    )

                    Image(
                        painter = painterResource(id = R.drawable.baseline_android_24),
                        contentDescription = "",
                        modifier = Modifier
                            .width(100.dp)
                            .height(40.dp)
                    )
                }
            }
        }

    }


}

@Preview
@Composable
fun ScondScreenPreview() {
    ScreenContent("", mapOf())
}