package com.example.material_design.data

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

import com.example.material_design.R
import com.example.material_design.model.Affirmation
import com.example.material_design.model.Topic

/**
 * [Datasource] generates a list of [Affirmation]
 */
object  Datasource2{
  val topics = listOf(
    Topic(R.string.architecture, 58, R.drawable.architecture),
    Topic(R.string.automotive, 30, R.drawable.automotive),
    Topic(R.string.biology, 90, R.drawable.biology),
    Topic(R.string.crafts, 121, R.drawable.crafts),
    Topic(R.string.business, 78, R.drawable.business),
    Topic(R.string.culinary, 118, R.drawable.culinary),
    Topic(R.string.design, 423, R.drawable.design),
    Topic(R.string.ecology, 28, R.drawable.ecology),
    Topic(R.string.engineering, 67, R.drawable.engineering),
    Topic(R.string.fashion, 92, R.drawable.fashion),
    Topic(R.string.finance, 100, R.drawable.finance),
    Topic(R.string.film, 165, R.drawable.film),
    Topic(R.string.gaming, 37, R.drawable.gaming),
    Topic(R.string.geology, 290, R.drawable.geology),
    Topic(R.string.drawing, 326, R.drawable.drawing),
    Topic(R.string.history, 189, R.drawable.history),
    Topic(R.string.journalism, 96, R.drawable.journalism),
    Topic(R.string.law, 58, R.drawable.law),
    Topic(R.string.lifestyle, 305, R.drawable.lifestyle),
    Topic(R.string.music, 212, R.drawable.music),
    Topic(R.string.painting, 172, R.drawable.painting),
    Topic(R.string.photography, 321, R.drawable.photography),
    Topic(R.string.physics, 41, R.drawable.physics),
    Topic(R.string.tech, 118, R.drawable.tech),
  )
}
class Datasource() {

  fun loadAffirmations(): List<Affirmation> {
    return listOf<Affirmation>(
      Affirmation(R.string.affirmation1, R.drawable.image1),
      Affirmation(R.string.affirmation2, R.drawable.image2),
      Affirmation(R.string.affirmation3, R.drawable.image3),
      Affirmation(R.string.affirmation4, R.drawable.image4),
      Affirmation(R.string.affirmation5, R.drawable.image5),
      Affirmation(R.string.affirmation6, R.drawable.image6),
      Affirmation(R.string.affirmation7, R.drawable.image7),
      Affirmation(R.string.affirmation8, R.drawable.image8),
      Affirmation(R.string.affirmation9, R.drawable.image9),
      Affirmation(R.string.affirmation10, R.drawable.image10))
  }
}