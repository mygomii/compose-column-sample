package com.mygomii.compose.recycler_compose_test.models

import java.io.Serializable

data class Puppy(
    val id: Int,
    val title: String,
    val sex: String,
    val age: Int,
    val description: String,
) : Serializable
