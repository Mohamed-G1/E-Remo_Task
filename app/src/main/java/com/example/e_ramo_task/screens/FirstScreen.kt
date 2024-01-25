package com.example.e_ramo_task.screens

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.e_ramo_task.Constants.IMAGE_1
import com.example.e_ramo_task.Constants.IMAGE_2
import com.example.e_ramo_task.Constants.IMAGE_3
import com.example.e_ramo_task.Constants.IMAGE_4
import com.example.e_ramo_task.Constants.IMAGE_5
import com.example.e_ramo_task.PaletteGenerator.convertImageUrlToBitmap
import com.example.e_ramo_task.PaletteGenerator.extractColorsFromBitmap
import com.example.e_ramo_task.R
import com.example.e_ramo_task.navigation.Screens

@Composable
fun FirstScreen(
    navHostController: NavHostController,
) {

    LazyVerticalGrid(
        modifier = Modifier.fillMaxWidth().padding(16.dp),
        columns = GridCells.Fixed(3),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item {
            Surface(
                modifier = Modifier
                    .size(120.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .background(Color.White)

            ) {
                AsyncImage(
                    modifier = Modifier
                        .fillMaxSize()
                        .clickable {
                            navHostController.navigate(
                                Screens.SecondScreen.passImageUrl(
                                    imageUrl = IMAGE_1
                                )
                            )
                        },
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(IMAGE_1)
                        .crossfade(true)
                        .placeholder(R.drawable.ic_loading)
                        .error(R.drawable.ic_error)
                        .build(),
                    contentDescription = "",
                    contentScale = ContentScale.Crop
                )
            }
        }

        item {
            Surface(
                modifier = Modifier
                    .size(120.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .background(Color.White)
            ) {
                AsyncImage(
                    modifier = Modifier
                        .fillMaxSize()
                        .clickable {
                            navHostController.navigate(
                                Screens.SecondScreen.passImageUrl(
                                    imageUrl = IMAGE_2
                                )
                            )
                        },
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(IMAGE_2)
                        .crossfade(true)
                        .placeholder(R.drawable.ic_loading)
                        .error(R.drawable.ic_error)
                        .build(),
                    contentDescription = "",
                    contentScale = ContentScale.Crop
                )
            }
        }

        item {
            Surface(
                modifier = Modifier
                    .size(120.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .background(Color.White)
            ) {
                AsyncImage(
                    modifier = Modifier
                        .fillMaxSize()
                        .clickable {
                            navHostController.navigate(
                                Screens.SecondScreen.passImageUrl(
                                    imageUrl = IMAGE_3
                                )
                            )
                        },
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(IMAGE_3)
                        .crossfade(true)
                        .placeholder(R.drawable.ic_loading)
                        .error(R.drawable.ic_error)
                        .build(),
                    contentDescription = "",
                    contentScale = ContentScale.Crop
                )
            }
        }

        item {
            Surface(
                modifier = Modifier
                    .size(120.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .background(Color.White)
            ) {
                AsyncImage(
                    modifier = Modifier
                        .fillMaxSize()
                        .clickable {
                            navHostController.navigate(
                                Screens.SecondScreen.passImageUrl(
                                    imageUrl = IMAGE_4
                                )
                            )
                        },
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(IMAGE_4)
                        .crossfade(true)
                        .placeholder(R.drawable.ic_loading)
                        .error(R.drawable.ic_error)
                        .build(),
                    contentDescription = "",
                    contentScale = ContentScale.Crop
                )
            }
        }

        item {
            Surface(
                modifier = Modifier
                    .size(120.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .background(Color.White)
            ) {
                AsyncImage(
                    modifier = Modifier
                        .fillMaxSize()
                        .clickable {
                            navHostController.navigate(
                                Screens.SecondScreen.passImageUrl(
                                    imageUrl = IMAGE_5
                                )
                            )
                        },
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(IMAGE_5)
                        .crossfade(true)
                        .placeholder(R.drawable.ic_loading)
                        .error(R.drawable.ic_error)
                        .build(),
                    contentDescription = "",
                    contentScale = ContentScale.Crop
                )
            }
        }

        item {
            Surface(
                modifier = Modifier
                    .size(120.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .background(Color.White)

            ) {
                AsyncImage(
                    modifier = Modifier
                        .fillMaxSize()
                        .clickable {
                            navHostController.navigate(
                                Screens.SecondScreen.passImageUrl(
                                    imageUrl = IMAGE_1
                                )
                            )
                        },
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(IMAGE_1)
                        .crossfade(true)
                        .placeholder(R.drawable.ic_loading)
                        .error(R.drawable.ic_error)
                        .build(),
                    contentDescription = "",
                    contentScale = ContentScale.Crop
                )
            }
        }

        item {
            Surface(
                modifier = Modifier
                    .size(120.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .background(Color.White)
            ) {
                AsyncImage(
                    modifier = Modifier
                        .fillMaxSize()
                        .clickable {
                            navHostController.navigate(
                                Screens.SecondScreen.passImageUrl(
                                    imageUrl = IMAGE_4
                                )
                            )
                        },
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(IMAGE_4)
                        .crossfade(true)
                        .placeholder(R.drawable.ic_loading)
                        .error(R.drawable.ic_error)
                        .build(),
                    contentDescription = "",
                    contentScale = ContentScale.Crop
                )
            }
        }
    }
}

@Preview
@Composable
fun FirstScreenPreview() {
    FirstScreen(
        rememberNavController()
    )
}