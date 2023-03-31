package com.example.moviejetpack.screens.home

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.moviejetpack.model.Movie
import com.example.moviejetpack.model.getMovies
import com.example.moviejetpack.navigation.MovieScreens
import com.example.moviejetpack.widgets.MovieRow

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun HomeScreen(navController: NavController) {

    Scaffold(topBar = {
        TopAppBar(
            backgroundColor = Color.Gray,
            elevation = 5.dp
        ) {
            Row(
                modifier = Modifier.padding(10.dp).clickable {
                    navController.navigate(route = MovieScreens.AboutScreen.name)
                },
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    modifier = Modifier.padding(start = 150.dp), text = "Movie"
                )
            }

        }
    }) {
       MainContent(navController = navController)

    }
}

@Composable
fun MainContent(navController: NavController,
                movieList: List<Movie> = getMovies()
) {
    Column(modifier = Modifier.padding(12.dp)) {
        LazyColumn {
            items(items = movieList) {
                MovieRow(movie = it) { movie ->

                    navController.navigate(route = MovieScreens.DetailsScreen.name+"/$movie")
//                    Log.d("MOVIE", "MainContent:$movie ")

                }
            }
        }
    }

}