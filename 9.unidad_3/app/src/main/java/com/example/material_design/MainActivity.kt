package com.example.material_design

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.material_design.data.Datasource
import com.example.material_design.data.Datasource2
import com.example.material_design.data.Dog
import com.example.material_design.data.dogs
import com.example.material_design.model.Affirmation
import com.example.material_design.model.HeroesRepository
import com.example.material_design.model.Topic
import com.example.material_design.ui.theme.Material_designTheme
import javax.sql.DataSource
import kotlin.collections.component1
import kotlin.compareTo

class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    enableEdgeToEdge()
    setContent {
      Material_designTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
          Greeting(
            name = "Fernando",
            modifier = Modifier.padding(innerPadding)
          )
          Activity()
          AffirmationsApp()
          TopicGrid()
        }
      }
    }
  }
}

enum class Daypart {
  MORNING,
  AFTERNOON,
  EVENING,
}

data class Event(
  val title: String,
  val description: String? = null,
  val daypart: Daypart,
  val durationInMinutes: Int,
)

val events = mutableListOf<com.example.material_design.Event>(
  Event(
    title = "Yoga Matutino",
    description = "Sesión de yoga para comenzar el día con energía.",
    daypart = Daypart.MORNING,
    durationInMinutes = 45
  ),
  Event(
    title = "Almuerzo con equipo",
    description = "Reunión informal para discutir avances del proyecto.",
    daypart = Daypart.AFTERNOON,
    durationInMinutes = 60
  ),
  Event(
    title = "Conferencia sobre Inteligencia Artificial",
    description = "Charla técnica sobre modelos de lenguaje.",
    daypart = Daypart.EVENING,
    durationInMinutes = 90
  ),
  Event(
    title = "Cena con familia",
    description = null,
    daypart = Daypart.EVENING,
    durationInMinutes = 75
  ),
  Event(
    title = "Lectura antes de dormir",
    description = "Capítulo de novela de ciencia ficción.",
    daypart = Daypart.EVENING,
    durationInMinutes = 30
  )
)

@Composable
fun Activity(){
  println("You have ${shortEvents.size} short events.")

  val groupedEvents = events.groupBy { it.daypart }
  groupedEvents.forEach { (daypart, events) ->
    println("$daypart: ${com.example.material_design.events.size} events")
  }

  println("Last event of the day: ${events.last().title}")
}


val shortEvents = events.filter { it.durationInMinutes < 60 }


val Event.durationOfEvent: String
  get() = if (this.durationInMinutes < 60) {
    "short"
  } else {
    "long"
  }

@Composable
fun AffirmationsApp() {
  AffirmationList(
    affirmationList = Datasource().loadAffirmations(),
  )
}

@Composable
fun AffirmationList(affirmationList: List<Affirmation>, modifier: Modifier = Modifier) {
  LazyColumn(modifier = modifier) {
    items(affirmationList) { affirmation ->
      AffirmationCard(
        affirmation = affirmation,
        modifier = Modifier.padding(8.dp)
      )
    }
  }
}

@Composable
fun AffirmationCard(affirmation: Affirmation, modifier: Modifier = Modifier) {
  Card (modifier = modifier) {
    Column {
      Image(
        painter = painterResource(affirmation.imageResourceId),
        contentDescription = stringResource(affirmation.stringResourceId),
        modifier = Modifier
          .fillMaxWidth()
          .height(194.dp),
        contentScale = ContentScale.Crop
      )
      Text(
        text = LocalContext.current.getString(affirmation.stringResourceId),
        modifier = Modifier.padding(16.dp),
        style = MaterialTheme.typography.headlineSmall
      )
    }
  }
}

@Preview
@Composable
private fun AffirmationCardPreview() {
  AffirmationCard(Affirmation(R.string.affirmation1, R.drawable.image1))
}

@Composable
fun TopicGrid(modifier: Modifier = Modifier) {
  LazyVerticalGrid(
    columns = GridCells.Fixed(2),
    verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_small)),
    horizontalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_small)),
    modifier = modifier
  ) {
    items(Datasource2.topics) { topic ->
      TopicCard(topic)
    }
  }
}

@Composable
fun TopicCard(topic: Topic, modifier: Modifier = Modifier) {
  Card {
    Row {
      Box{
        Image(
          painter = painterResource(id = topic.imageRes),
          contentDescription = null,
          modifier = modifier
            .size(width = 68.dp, height = 68.dp)
            .aspectRatio(1f),
          contentScale = ContentScale.Crop
        )
      }

      Column {
        Text(
          text = stringResource(id = topic.name),
          style = MaterialTheme.typography.bodyMedium,
          modifier = Modifier.padding(
            start = dimensionResource(R.dimen.padding_medium),
            top = dimensionResource(R.dimen.padding_medium),
            end = dimensionResource(R.dimen.padding_medium),
            bottom = dimensionResource(R.dimen.padding_small)
          )
        )
        Row(verticalAlignment = Alignment.CenterVertically) {
          Icon(
            painter = painterResource(R.drawable.ic_grain),
            contentDescription = null,
            modifier = Modifier
              .padding(start = dimensionResource(R.dimen.padding_medium))
          )
          Text(
            text = topic.availableCourses.toString(),
            style = MaterialTheme.typography.labelMedium,
            modifier = Modifier.padding(start = dimensionResource(R.dimen.padding_small))
          )
        }
      }
    }
  }
}

@Preview(showBackground = true)
@Composable
fun TopicPreview() {
  Material_designTheme {
    val topic = Topic(R.string.photography, 321, R.drawable.photography)
    Column(
      modifier = Modifier.fillMaxSize(),
      verticalArrangement = Arrangement.Center,
      horizontalAlignment = Alignment.CenterHorizontally
    ) {
      TopicCard(topic = topic)
    }
  }
}

/**
 * Composable that displays an app bar and a list of dogs.
 */
@Composable
fun WoofApp() {
  Scaffold(
    topBar = {
      WoofTopAppBar()
    }
  ) { it ->
    LazyColumn(contentPadding = it) {
      items(dogs) {
        DogItem(
          dog = it,
          modifier = Modifier.padding(dimensionResource(R.dimen.padding_small))
        )
      }
    }
  }
}

/**
 * Composable that displays a list item containing a dog icon and their information.
 *
 * @param dog contains the data that populates the list item
 * @param modifier modifiers to set to this composable
 */
@Composable
fun DogItem(
  dog: Dog,
  modifier: Modifier = Modifier
) {
  var expanded by remember { mutableStateOf(false) }
  Card(
    modifier = modifier
  ) {
    Column(
      modifier = Modifier
        .animateContentSize(
          animationSpec = spring(
            dampingRatio = Spring.DampingRatioNoBouncy,
            stiffness = Spring.StiffnessMedium
          )
        )
    ) {
      Row(
        modifier = Modifier
          .fillMaxWidth()
          .padding(dimensionResource(R.dimen.padding_small))
      ) {
        DogIcon(dog.imageResourceId)
        DogInformation(dog.name, dog.age)
        Spacer(Modifier.weight(1f))
        DogItemButton(
          expanded = expanded,
          onClick = { expanded = !expanded },
        )
      }
      if (expanded) {
        DogHobby(
          dog.hobbies, modifier = Modifier.padding(
            start = dimensionResource(R.dimen.padding_medium),
            top = dimensionResource(R.dimen.padding_small),
            bottom = dimensionResource(R.dimen.padding_medium),
            end = dimensionResource(R.dimen.padding_medium)
          )
        )
      }
    }
  }
}

/**
 * Composable that displays a button that is clickable and displays an expand more or an expand less
 * icon.
 *
 * @param expanded represents whether the expand more or expand less icon is visible
 * @param onClick is the action that happens when the button is clicked
 * @param modifier modifiers to set to this composable
 */
@Composable
private fun DogItemButton(
  expanded: Boolean,
  onClick: () -> Unit,
  modifier: Modifier = Modifier
) {
  IconButton(
    onClick = onClick,
    modifier = modifier
  ) {
    Icon(
      imageVector = if (expanded) Icons.Filled.ExpandLess else Icons.Filled.ExpandMore,
      contentDescription = stringResource(R.string.expand_button_content_description),
      tint = MaterialTheme.colorScheme.secondary
    )
  }
}

/**
 * Composable that displays a Top Bar with an icon and text.
 *
 * @param modifier modifiers to set to this composable
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WoofTopAppBar(modifier: Modifier = Modifier) {
  CenterAlignedTopAppBar(
    title = {
      Row(
        verticalAlignment = Alignment.CenterVertically
      ) {
        Image(
          modifier = Modifier
            .size(dimensionResource(R.dimen.image_size))
            .padding(dimensionResource(R.dimen.padding_small)),
          painter = painterResource(R.drawable.ic_woof_logo),

          // Content Description is not needed here - image is decorative, and setting a
          // null content description allows accessibility services to skip this element
          // during navigation.

          contentDescription = null
        )
        Text(
          text = stringResource(R.string.app_name),
          style = MaterialTheme.typography.displayLarge
        )
      }
    },
    modifier = modifier
  )
}

/**
 * Composable that displays a photo of a dog.
 *
 * @param dogIcon is the resource ID for the image of the dog
 * @param modifier modifiers to set to this composable
 */
@Composable
fun DogIcon(
  @DrawableRes dogIcon: Int,
  modifier: Modifier = Modifier
) {
  Image(
    modifier = modifier
      .size(dimensionResource(R.dimen.image_size))
      .padding(dimensionResource(R.dimen.padding_small))
      .clip(MaterialTheme.shapes.small),
    contentScale = ContentScale.Crop,
    painter = painterResource(dogIcon),

    // Content Description is not needed here - image is decorative, and setting a null content
    // description allows accessibility services to skip this element during navigation.

    contentDescription = null
  )
}

/**
 * Composable that displays a dog's name and age.
 *
 * @param dogName is the resource ID for the string of the dog's name
 * @param dogAge is the Int that represents the dog's age
 * @param modifier modifiers to set to this composable
 */
@Composable
fun DogInformation(
  @StringRes dogName: Int,
  dogAge: Int,
  modifier: Modifier = Modifier
) {
  Column(modifier = modifier) {
    Text(
      text = stringResource(dogName),
      style = MaterialTheme.typography.displayMedium,
      modifier = Modifier.padding(top = dimensionResource(R.dimen.padding_small))
    )
    Text(
      text = stringResource(R.string.years_old, dogAge),
      style = MaterialTheme.typography.bodyLarge
    )
  }
}

/**
 * Composable that displays a dog's hobbies.
 *
 * @param dogHobby is the resource ID for the text string of the hobby to display
 * @param modifier modifiers to set to this composable
 */
@Composable
fun DogHobby(
  @StringRes dogHobby: Int,
  modifier: Modifier = Modifier
) {
  Column(
    modifier = modifier
  ) {
    Text(
      text = stringResource(R.string.about),
      style = MaterialTheme.typography.labelSmall
    )
    Text(
      text = stringResource(dogHobby),
      style = MaterialTheme.typography.bodyLarge
    )
  }
}

/**
 * Composable that displays what the UI of the app looks like in light theme in the design tab.
 */
@Preview
@Composable
fun WoofPreview() {
  Material_designTheme(darkTheme = false) {
    WoofApp()
  }
}

/**
 * Composable that displays what the UI of the app looks like in dark theme in the design tab.
 */
@Preview
@Composable
fun WoofDarkThemePreview() {
  Material_designTheme(darkTheme = true) {
    WoofApp()
  }
}

/**
 * Composable that displays an app bar and a list of heroes.
 */
@Composable
fun SuperheroesApp() {
  Scaffold(
    modifier = Modifier.fillMaxSize(),
    topBar = {
      TopAppBar()
    }
  ) {
    /* Important: It is not a good practice to access data source directly from the UI.
    In later units you will learn how to use ViewModel in such scenarios that takes the
    data source as a dependency and exposes heroes.
     */
    val heroes = HeroesRepository.heroes
    HeroesList(heroes = heroes, contentPadding = it)
  }
}

/**
 * Composable that displays a Top Bar with an icon and text.
 *
 * @param modifier modifiers to set to this composable
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBar(modifier: Modifier = Modifier) {
  CenterAlignedTopAppBar(
    title = {
      Text(
        text = stringResource(R.string.app_name),
        style = MaterialTheme.typography.displayLarge,
      )
    },
    modifier = modifier
  )
}

@Preview(showBackground = true)
@Composable
fun SuperHeroesPreview() {
  Material_designTheme {
    SuperheroesApp()
  }
}
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
  Text(
    text = "Hello $name!",
    modifier = modifier
  )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
  Material_designTheme {
    Greeting("Android")
  }
}