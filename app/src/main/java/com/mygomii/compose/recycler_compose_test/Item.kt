package com.mygomii.compose.recycler_compose_test

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mygomii.compose.recycler_compose_test.models.DataProvider
import com.mygomii.compose.recycler_compose_test.models.Puppy
import com.mygomii.compose.recycler_compose_test.ui.theme.graySurface

@Composable
fun Item(puppy: Puppy, navigateToProfile: (Puppy) -> Unit) {
    Card(
        modifier = Modifier
            .padding(horizontal = 8.dp, vertical = 8.dp)
            .fillMaxWidth(),
        elevation = 2.dp,
        backgroundColor = graySurface,
        shape = RoundedCornerShape(corner = CornerSize(16.dp)),
    ) {
        Row(Modifier.clickable { navigateToProfile(puppy) }) {
            Column(
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth()
                    .align(Alignment.CenterVertically)
            ) {
                Text(
                    text = puppy.title,
                    style = typography.h6,
                    color = Color.White
                )
                Text(
                    text = puppy.sex,
                    style = typography.caption,
                    color = Color.Cyan
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewPuppyItem() {
    val puppy = DataProvider.puppyList[0]
    Item(puppy = puppy, navigateToProfile = {})
}