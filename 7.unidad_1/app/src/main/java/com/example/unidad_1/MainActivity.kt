package com.example.unidad_1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.unidad_1.ui.theme.Unidad_1Theme
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      Unidad_1Theme {
        // A surface container using the 'background' color from the theme
        Surface(
          modifier = Modifier.fillMaxSize(),
          color = MaterialTheme.colorScheme.background
        ) {
          GreetingText(
            message = "Happy Birthday Sam!",
            from = "From Emma",
            modifier = Modifier.padding(8.dp)
          )
        }
      }
    }
  }
}

@Composable
fun GreetingText(message: String, from: String, modifier: Modifier = Modifier) {
  Column(
    verticalArrangement = Arrangement.Center,
    modifier = modifier
  ) {
    Text(
      text = message,
      fontSize = 100.sp,
      lineHeight = 116.sp,
      textAlign = TextAlign.Center
    )
    Text(
      text = from,
      fontSize = 36.sp,
      modifier = Modifier
        .padding(16.dp)
        .align(alignment = Alignment.End)
    )
  }
}

@Preview(showBackground = true)
@Composable
fun BirthdayCardPreview() {
  Unidad_1Theme {
    GreetingText(message = "Happy Birthday Sam!", from = "From Emma")
  }
}

fun main() {
  println("1")
  println("2")
  println("3")

  println("Tuesday")
  println("Thursday")
  println("Wednesday")
  println("Friday")
  println("Monday")

  println("There is a chance of snow")
  println("Cloudy")
  println("Partly Cloudy")
  println("Windy")

  println("How's the weather today?")

  println("Use the val keyword when the value doesn't change.")
  println("Use the var keyword when the value can change.")
  println("When you define a function, you define the parameters that can be passed to it.")
  println("When you call a function, you pass arguments for the parameters.")

  println("New chat message from a friend")

  val discountPercentage = 20
  val item = "Google Chromecast"
  val offer = "Sale  - Up to $discountPercentage% discount off $item! Hurry Up!"

  println(offer)

  val numberOfAdults = 20
  val numberOfKids = 30
  val total = numberOfAdults + numberOfKids
  println("The total party size is: $total")

  val firstNumber = 10
  val secondNumber = 5
  val thirdNumber = 8

  val result = add(firstNumber, secondNumber)
  val anotherResult = subtract(firstNumber, thirdNumber)

  println("$firstNumber + $secondNumber = $result")
  println("$firstNumber - $thirdNumber = $anotherResult")

  val steps = 4000
  val caloriesBurned = pedometerStepsToCalories(steps)
  println("Walking $steps steps burns $caloriesBurned calories")

  println("Have I spent more time using my phone today: ${compareTime(300, 250)}")
  println("Have I spent more time using my phone today: ${compareTime(300, 300)}")
  println("Have I spent more time using my phone today: ${compareTime(200, 220)}")

  printWeatherForCity("Ankara", 27, 31, 82)
  printWeatherForCity("Tokyo", 32, 36, 10)
  printWeatherForCity("Cape Town", 59, 64, 2)
  printWeatherForCity("Guatemala City", 50, 55, 7)

}

fun printWeatherForCity(cityName: String, lowTemp: Int, highTemp: Int, chanceOfRain: Int) {
  println("City: $cityName")
  println("Low temperature: $lowTemp, High temperature: $highTemp")
  println("Chance of rain: $chanceOfRain%")
  println()
}

fun compareTime(timeSpentToday: Int, timeSpentYesterday: Int): Boolean {
  return timeSpentToday > timeSpentYesterday
}

fun pedometerStepsToCalories(numberOfSteps: Int): Double {
  val caloriesBurnedForEachStep = 0.04
  val totalCaloriesBurned = numberOfSteps * caloriesBurnedForEachStep
  return totalCaloriesBurned
}

fun displayAlertMessage(
  operatingSystem: String = "Unknown OS",
  emailId: String
): String {
  return "There is a new sign-in request on $operatingSystem for your Google Account $emailId."
}

fun add(firstNumber: Int, secondNumber: Int): Int {
  return firstNumber + secondNumber
}

fun subtract(firstNumber: Int, secondNumber: Int): Int {
  return firstNumber - secondNumber
}