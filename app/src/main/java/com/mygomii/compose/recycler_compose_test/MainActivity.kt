package com.mygomii.compose.recycler_compose_test

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mygomii.compose.recycler_compose_test.models.DataProvider
import com.mygomii.compose.recycler_compose_test.models.Puppy
import com.mygomii.compose.recycler_compose_test.ui.theme.RecyclercomposetestTheme
import com.mygomii.compose.recycler_compose_test.ui.theme.graySurface

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RecyclercomposetestTheme {
                MyApp {
                    startActivity(ProfileActivity.newIntent(this, it))
                }
            }
        }
    }
}

@Composable
fun MyApp(navigateToProfile: (Puppy) -> Unit) {
    Scaffold(
        content = {
            BarkHomeContent(navigateToProfile = navigateToProfile)
        }
    )
}

@Composable
fun BarkHomeContent(navigateToProfile: (Puppy) -> Unit) {
    val puppies = remember { DataProvider.puppyList }
    LazyColumn(
        Modifier.background(color = graySurface),
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
    ) {
        items(
            items = puppies,
            itemContent = {
                Item(puppy = it, navigateToProfile)
            }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    RecyclercomposetestTheme(darkTheme = false) {
        MyApp { }
    }
}