/*
 * Copyright (C) 2023 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.fusionapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.unidad_2.ui.theme.Unidad_2Theme

class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      Unidad_2Theme {
        FusionApp()
      }
    }
  }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FusionApp() {
  var currentScreen by remember { mutableStateOf("menu") }

  Scaffold(
    topBar = {
      CenterAlignedTopAppBar(
        title = {
          Text(
            text = "Fusion App",
            fontWeight = FontWeight.Bold
          )
        },
        colors = TopAppBarDefaults.largeTopAppBarColors(
          containerColor = MaterialTheme.colorScheme.primaryContainer
        )
      )
    }
  ) { innerPadding ->
    Surface(
      modifier = Modifier
        .fillMaxSize()
        .padding(innerPadding)
        .background(MaterialTheme.colorScheme.tertiaryContainer),
      color = MaterialTheme.colorScheme.background
    ) {
      when (currentScreen) {
        "menu" -> MainMenu(onNavigate = { currentScreen = it })
        "dice" -> DiceRollerApp(onBack = { currentScreen = "menu" })
        "lemonade" -> LemonadeApp(onBack = { currentScreen = "menu" })
      }
    }
  }
}

@Composable
fun MainMenu(onNavigate: (String) -> Unit) {
  Column(
    modifier = Modifier
      .fillMaxSize()
      .wrapContentSize(Alignment.Center),
    horizontalAlignment = Alignment.CenterHorizontally
  ) {
    Button(
      onClick = { onNavigate("dice") },
      modifier = Modifier.padding(16.dp)
    ) {
      Text(text = "Dice Roller", fontSize = 24.sp)
    }
    Button(
      onClick = { onNavigate("lemonade") },
      modifier = Modifier.padding(16.dp)
    ) {
      Text(text = "Lemonade", fontSize = 24.sp)
    }
  }
}

@Composable
fun DiceRollerApp(onBack: () -> Unit) {
  var result by remember { mutableIntStateOf(1) }
  val imageResource = when (result) {
    1 -> R.drawable.dice_1
    2 -> R.drawable.dice_2
    3 -> R.drawable.dice_3
    4 -> R.drawable.dice_4
    5 -> R.drawable.dice_5
    else -> R.drawable.dice_6
  }

  Column(
    modifier = Modifier
      .fillMaxSize()
      .wrapContentSize(Alignment.Center),
    horizontalAlignment = Alignment.CenterHorizontally
  ) {
    Image(
      painter = painterResource(imageResource),
      contentDescription = result.toString()
    )
    Button(
      onClick = { result = (1..6).random() },
      modifier = Modifier.padding(16.dp)
    ) {
      Text(text = stringResource(R.string.roll), fontSize = 24.sp)
    }
    Spacer(modifier = Modifier.height(16.dp))
    Button(
      onClick = onBack,
      modifier = Modifier.padding(16.dp)
    ) {
      Text(text = "Back to Menu", fontSize = 18.sp)
    }
  }
}

@Composable
fun LemonadeApp(onBack: () -> Unit) {
  var currentStep by remember { mutableStateOf(1) }
  var squeezeCount by remember { mutableStateOf(0) }

  when (currentStep) {
    1 -> {
      LemonTextAndImage(
        textLabelResourceId = R.string.lemon_select,
        drawableResourceId = R.drawable.lemon_tree,
        contentDescriptionResourceId = R.string.lemon_tree_content_description,
        onImageClick = {
          currentStep = 2
          squeezeCount = (2..4).random()
        }
      )
    }
    2 -> {
      LemonTextAndImage(
        textLabelResourceId = R.string.lemon_squeeze,
        drawableResourceId = R.drawable.lemon_squeeze,
        contentDescriptionResourceId = R.string.lemon_content_description,
        onImageClick = {
          squeezeCount--
          if (squeezeCount == 0) {
            currentStep = 3
          }
        }
      )
    }
    3 -> {
      LemonTextAndImage(
        textLabelResourceId = R.string.lemon_drink,
        drawableResourceId = R.drawable.lemon_drink,
        contentDescriptionResourceId = R.string.lemonade_content_description,
        onImageClick = { currentStep = 4 }
      )
    }
    4 -> {
      LemonTextAndImage(
        textLabelResourceId = R.string.lemon_empty_glass,
        drawableResourceId = R.drawable.lemon_restart,
        contentDescriptionResourceId = R.string.empty_glass_content_description,
        onImageClick = { currentStep = 1 }
      )
    }
  }

  Spacer(modifier = Modifier.height(16.dp))
  Button(
    onClick = onBack,
    modifier = Modifier.padding(16.dp)
  ) {
    Text(text = "Back to Menu", fontSize = 18.sp)
  }
}

@Composable
fun LemonTextAndImage(
  textLabelResourceId: Int,
  drawableResourceId: Int,
  contentDescriptionResourceId: Int,
  onImageClick: () -> Unit,
  modifier: Modifier = Modifier
) {
  Column(
    horizontalAlignment = Alignment.CenterHorizontally,
    verticalArrangement = Arrangement.Center,
    modifier = Modifier.fillMaxSize()
  ) {
    Button(
      onClick = onImageClick,
      shape = RoundedCornerShape(16.dp)
    ) {
      Image(
        painter = painterResource(drawableResourceId),
        contentDescription = stringResource(contentDescriptionResourceId),
        modifier = Modifier
          .width(100.dp)
          .height(100.dp)
      )
    }
    Spacer(modifier = Modifier.height(16.dp))
    Text(
      text = stringResource(textLabelResourceId),
      style = MaterialTheme.typography.bodyLarge
    )
  }
}

@Preview
@Composable
fun PreviewFusionApp() {
  Unidad_2Theme {
    FusionApp()
  }
}