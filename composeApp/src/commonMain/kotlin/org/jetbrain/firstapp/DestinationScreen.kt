package org.jetbrain.firstapp

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinproject.composeapp.generated.resources.Res
import kotlinproject.composeapp.generated.resources.compose_multiplatform
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview


@Composable
@Preview
fun DestinationScreen() {
    Scaffold(
        topBar = { StepIndicator(1) },
        bottomBar = { BottomButtons() }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp)
        ){
            Spacer(modifier = Modifier.height(32.dp))

            Text(
                text = "DESTINATION",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(32.dp))

            TextField(
                value = "",
                onValueChange = {},
                placeholder = { Text(text = "e.g. Paris, Dubai, Lima, Barcelona") },
                modifier = Modifier.fillMaxWidth()
            )

            LazyColumn(modifier = Modifier.fillMaxHeight()) {
                items(listOf("Current location", "Berlin, Germany", "Paris, France", "Lisbon, Portugal")) {location->
                    DestinationItem(location)
                }
            }
        }
    }
}

@Composable
fun StepIndicator(currentStep:Int) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        for (step in 1..5) {
            Icon(
                painter = painterResource(if (step<=currentStep) Res.drawable.compose_multiplatform else Res.drawable.compose_multiplatform),
                contentDescription = "Step $step",
                modifier = Modifier.size(24.dp)
            )
        }
    }
}

@Composable
fun DestinationItem(location: String){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .background(Color.White)
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Spacer(modifier = Modifier.width(16.dp))
        Text(text = location, fontSize = 16.sp)
    }
}
@Composable
fun BottomButtons() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Button(onClick = {}, colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFFFFC107))) {
            Text(text = "Back")
        }
        Button(onClick = {}, colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFF00BCD4))) {
            Text(text = "Next")
        }
    }
}

