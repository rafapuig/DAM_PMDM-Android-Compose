package es.rafapuig.pmdm.compose.learning.layout.modifiers

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

/**
 * https://developer.android.com/develop/ui/compose/layouts/constraints-modifiers#requiredsize-modifier
 */

@Composable
private fun MyBox(modifier: Modifier = Modifier) {
    Box(
        modifier = Modifier
            .border(1.dp, Color.LightGray)
                then modifier
                then Modifier.background(Color.Red)
    )
}


@Preview(widthDp = 300, heightDp = 200)
@Composable
private fun MyBoxRequiredSizePreview() {
    Box {
        MyBox(modifier = Modifier
            .size(100.dp) // tamaño que pasará al padre
            .requiredSize(50.dp) // tamaño con el que se dibujará)
        )
    }
}


@Preview(widthDp = 300, heightDp = 200)
@Composable
private fun MyBoxWidthPreview() {
    Box {
        MyBox(modifier = Modifier
            .width(50.dp)
            .fillMaxHeight()
        )
    }
}

@Preview(widthDp = 300, heightDp = 200)
@Composable
private fun MyBoxHeightPreview() {
    Box {
        MyBox(modifier = Modifier
            .height(50.dp)
            .fillMaxWidth()
        )
    }
}

@Preview(widthDp = 300, heightDp = 200)
@Composable
private fun MyBoxRequiredWidthPreview() {
    Box {
        MyBox(modifier = Modifier
            .width(100.dp)
            .requiredWidth(50.dp)
            .fillMaxHeight()
        )
    }
}

@Preview(widthDp = 300, heightDp = 200)
@Composable
private fun MyBoxRequiredHeightPreview() {
    Box {
        MyBox(modifier = Modifier
            .height(100.dp)
            .requiredHeight(50.dp)
            .fillMaxWidth()
        )
    }
}

@Preview(widthDp = 300, heightDp = 200)
@Composable
private fun MyBoxRequiredWidthPreview2() {
    Box (modifier = Modifier
        .wrapContentSize()
        .size(200.dp, 150.dp)
        .border(1.dp, Color.Yellow)
    ) {
        MyBox(modifier = Modifier
            .height(50.dp)
            .requiredWidth(250.dp)
        )
    }
}