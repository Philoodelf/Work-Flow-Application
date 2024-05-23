package com.example.work_flowapplication

import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Piechart( data: Map<String, Int>,
              radiusOuter: Dp =90.dp,
              CharBarWidth: Dp =20.dp,
              animDuration: Int=1000,) {
    val totalSum = data.values.sum()
    val floatvalue = mutableListOf<Float>()

    data.values.forEachIndexed { index, values ->
        floatvalue.add(index, 360 * values.toFloat() / totalSum.toFloat())
    }


    val colors = listOf(
        Color(0xFF0470BF),
        Color(0xFFFDF001),
        Color(0xFFE70013),
        Color(0xFFFFFFFF),
    )
    var animationPlayed by remember { mutableStateOf(false) }

    var lastValue = 0f

    val animatesize by animateFloatAsState(
        targetValue = if (animationPlayed) radiusOuter.value * 2f else 0f,
        animationSpec = tween(
            durationMillis = animDuration,
            delayMillis = 0,
            easing = LinearOutSlowInEasing
        )
    )

    val animateRotation by animateFloatAsState(
        targetValue = if (animationPlayed) 90f * 11f else 0f,
        animationSpec = tween(
            durationMillis = animDuration,
            delayMillis = 0,
            easing = LinearOutSlowInEasing
        )
    )

    LaunchedEffect(key1 = true) {
        animationPlayed = true
    }
// changed
    Row(
        modifier = Modifier.fillMaxWidth(),
       // horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier.size(animatesize.dp),
            contentAlignment = Alignment.Center
        ) {
            Canvas(
                modifier = Modifier
                    .size(radiusOuter * 2f)
                    .rotate(animateRotation)
            ) {
                floatvalue.forEachIndexed { index, value ->
                    drawArc(
                        color = colors[index],
                        lastValue,
                        value,
                        useCenter = false,
                        style = Stroke(CharBarWidth.toPx(), cap = StrokeCap.Butt)
                    )
                    lastValue += value
                }
            }
        }


        Column {
            detailsPieChart(
                data = data,
                colors = colors
            )
        }

}

}

@Composable
fun detailsPieChart(
    data: Map<String,Int>,
    colors: List<Color>) {
    data.values.forEachIndexed { index, value ->
        detailsPieChartItems(
            data = Pair(data.keys.elementAt(index),value),
            color = colors[index])

    }

}


@Composable
fun detailsPieChartItems(
    data: Pair<String, Int>,
    height: Dp =45.dp,
    color: Color) {
    Surface(
        modifier = Modifier
            .padding(vertical = 5.dp, horizontal = 30.dp),
        color = Color.Transparent
    ) {
        //the info
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Box(
                modifier = Modifier
                    .background(
                        color = color,
                        shape = RoundedCornerShape(10.dp)
                    )
                    .size(height)
            )
            Column(modifier = Modifier.fillMaxWidth()) {
                Text(
                    modifier = Modifier.padding(start = 15.dp),
                    text = data.first,
                    fontWeight = FontWeight.Medium,
                    fontSize = 22.sp,
                    color = Color.Black
                )
                Text(
                    modifier = Modifier.padding(start = 15.dp),
                    text = data.second.toString(),
                    fontWeight = FontWeight.Medium,
                    fontSize = 22.sp,
                    color = Color.Gray
                )
            }

        }


    }

}



//piechart onlyyy
@Composable
fun Piechartonly(
    data: Map<String, Int>,
    radiusOuter: Dp = 90.dp,
    CharBarWidth: Dp = 20.dp,
    animDuration: Int = 1000,
) {
    val totalSum = data.values.sum()
    val floatvalue = mutableListOf<Float>()

    data.values.forEachIndexed { index, values ->
        floatvalue.add(index, 360 * values.toFloat() / totalSum.toFloat())
    }

    val colors = listOf(
        Color(0xFF956CE6),
        Color(0xFFFFBF41),
        Color(0xFFFF4948),
        Color(0xFF0470BF),
        Color(0xFFFDF001),
        Color(0xFFE70013),
        Color(0xFFFFFFFF),
    )
    var animationPlayed by remember { mutableStateOf(false) }

    var lastValue = 0f

    val animatesize by animateFloatAsState(
        targetValue = if (animationPlayed) radiusOuter.value * 2f else 0f,
        animationSpec = tween(
            durationMillis = animDuration,
            delayMillis = 0,
            easing = LinearOutSlowInEasing
        )
    )

    val animateRotation by animateFloatAsState(
        targetValue = if (animationPlayed) 90f * 11f else 0f,
        animationSpec = tween(
            durationMillis = animDuration,
            delayMillis = 0,
            easing = LinearOutSlowInEasing
        )
    )

    LaunchedEffect(key1 = true) {
        animationPlayed = true
    }

    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier.size(animatesize.dp),
            contentAlignment = Alignment.Center
        ) {
            Canvas(
                modifier = Modifier
                    .size(radiusOuter * 2f)
                    .rotate(animateRotation)
            ) {
                var lastValue = 0f
                floatvalue.forEachIndexed { index, value ->
                    drawArc(
                        color = colors[index],
                        startAngle = lastValue,
                        sweepAngle = value,
                        useCenter = false,
                        style = Stroke(CharBarWidth.toPx(), cap = StrokeCap.Butt)
                    )
                    lastValue += value
                }
            }
        }
    }
}
