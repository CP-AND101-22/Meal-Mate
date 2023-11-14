# **Meal Mate**

## Table of Contents

1. [App Overview](#App-Overview)
1. [Product Spec](#Product-Spec)
1. [Wireframes](#Wireframes)
1. [Build Notes](#Build-Notes)

## App Overview

Meal Mate allows users to search for recipes based on a leftover ingredient that's about to expire!

### App Evaluation

- **Category:** Food
- **Mobile:** The mobile experience would enable users to quickly access recipes, and potentially upload images of their fridge to get recipe recommendations.
- **Story:** Would prevent food wastage, help chaotic meal preppers, and facilitate spontaneous meals with existed ingredients.
- **Market:** Anyone who has a fridge or pantry, and a willingness to make or prepare a meal. Could be monetized with ingredient brand partnerships that advertise their recommended recipes on the platform.
- **Habit:** Users would open the app whenever they open their fridge and face decision fatigue on what to make with what's there.
- **Scope:** V1 would allow users to search recipes by ingredient. V2 allow searching recipes with multiple ingredients factored in. V3 would add an image recognition feature in which the user simply uploads a picture of their fridge for recipe recommendations.

## Product Spec

### 1. User Features (Required and Optional)
    
Required features:
- [x] Meal category list
      Description: Recycler view that displays meal categories, populated with data from an API endpoint
      Goal Time: Nov 10 (Fri)
      Collaborator: Ruth
- [x] Search page
      Description: Home page with a recipe search bar (to search by main ingredient) & a button to see meal categories
      Goal Time: Nov 11 (Sat)
      Collaborator: Lingyu
- [x] Recipe results by ingredient
      Description: Recycler view that displays recipe names & images based on the main ingredient searched, populated with data from an API call
      Goal Time: Nov 12 (Sun)
      Collaborator: Ruth

Stretch features:
- [x] Recipe instructions page
      Description: Detail view that displays recipe instructions when a recipe name is clicked in the above recycler view, by passing the recipe id & getting data from another API endpoint
      Goal Time: Nov 13 (Mon)
      Collaborator: Abinaya
- [ ] Random meal generator: user can choose area or category or just go with completely random option
- [ ] Include an allergies, or ‘ingredients you dislike’ filter
- [ ] Use another API to display number of calories 
- [ ] A way to organise & save your favourite recipes
- [ ] Calendar view with the meals you made highlighted
- [ ] Expand search functionality to look up recipes by multiple ingredients
- [ ] Modify existing recipes to your liking

### 2. Chosen API(s)

- **www.themealdb.com/api/json/v1/1/filter.php?i=chicken_breast**
  - Search recipe names by main ingredient
- **www.themealdb.com/api/json/v1/1/lookup.php?i=52772**
  - Lookup recipe instructions by id
- **www.themealdb.com/api/json/v1/1/categories.php**
  - Get the recipes categories

### 3. User Interaction

Required Features
 
- [x] Click meal categories button
  => Display the meal categories

- [x] Search recipes by main ingredient
  => Display recipe names

Stretch Features

- [x] See recipe instructions
  => Display the recipe instructions when recipe name is selected
- [ ] Tab bar navigation between recipe lookup & category search screens

## Wireframes
![IMG_1062](https://github.com/CP-AND101-22/Meal-Mate/assets/78409617/f4b5e23b-b9f9-4f76-a50b-0954a66e1e2b)

## Build Notes (including GIFs of the build process from Milestone 2)

This sprint was intense, but rewarding!

First commit with a recycler view displaying meal categories fetched from an API:
![Meal Mate Build1](https://github.com/CP-AND101-22/Meal-Mate/assets/78409617/e9804394-8ffc-4129-9916-e4242d5e7d0d)

Second commit with search bar leading to categories regardless of what is typed:
![Meal Mate Build2](https://github.com/CP-AND101-22/Meal-Mate/assets/78409617/a92ce560-b63a-40c2-b5a5-838c5a994ef1)

Third commit with search bar leading to the correct recipe list & a button leading to meal categories:
![Meal Mate Build3](https://github.com/CP-AND101-22/Meal-Mate/assets/78409617/cd9fb1b3-373d-4279-a96e-2cb4a8cbc61c)

Final commit is shown in the narrated demo (see README file).

## License

Copyright **2023** **Team 22**

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
