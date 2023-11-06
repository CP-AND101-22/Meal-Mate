## Initial Brainstorming Ideas
- Aligners weartime tracker: can be shared with your orthodentist; all the existing apps on the market are still buggy & lack features
- Intentional Opens app: asks you to enter your intentions when opening an app & will record it in your Notes app (eg. can enter "wanna look up Josh from CS102" when entering Instagram)
- Property management app: a simplified, pared down version of a property management site like Buildium which is mobile-first
- Video flashcards app: existing flashcard apps only accept text or images, not videos; could be useful when going over dance move names & their demos, for example
- IBS Tracker: a glorified poop tracker that could be helpful for people with Irritable Bowel Syndrome
- Recipe finder app: to search for recipes based on a leftover ingredient that's about to expire!

We also considered looking at available public APIs for inspiration on what to build.

## Evaluation of Top 3 Ideas
1. Recipe Finder App
   - **Description**: Allows users to search for recipes based on a leftover ingredient that's about to expire!
   - **Category:** Utility/Cooking
   - **Mobile:** The mobile experience would enable users to quickly access recipes, and potentially upload images of their fridge to get recipe recommendations.
   - **Story:** Would prevent food wastage, help chaotic meal preppers, and facilitate spontaneous meals with existed ingredients.
   - **Market:** Any one who has a fridge or pantry, and a willingness to make or prepare a meal. Could be monetized with ingredient brand partnerships that advertise their recommended recipes on the platform.
   - **Habit:** Users would open the app whenever they open their fridge and face decision fatigue on what to make with what's there.
   - **Scope:** V1 would allow users to search recipes by ingredient. V2 allow searching recipes with multiple ingredients factored in. V3 would add an image recognition feature in which the user simply uploads a picture of their fridge for recipe recommendations.
  
2. Video Flashcards App
   - **Description**: Allows users to harness the power of digital flashcards by enabling video/GIF/media upload to flashcards, instead of limiting input to text & images.
   - **Category:** Education & learning
   - **Mobile:** The mobile app would enable the upload of media directly from the phone's local storage. Pictures, screenshots and screenrecordings can be easily accessed & uploaded to the flashcards, making it a seamless experience.
   - **Story:** Enables a multimedia-rich learning experience. For example, learning salsa on YouTube? Screenrecord important moves and upload them to flashcards for easy access and revision. Learning a language with your favorite Netfix series? Record dialogues and upload them for later learning. Let's innovate digital flashcards to integrate with the digital learning world.
   - **Market:** Learners of all kinds and ages.
   - **Habit:** User will open the app anytime tbey want to create new flashcards, update them or revise using the cards.
   - **Scope:** V1 would allow the user to include text, images or a video in the front/back of a flashcard. V2 would allow randomization of the cards & different viewing/revision settings.
  
3. Intentional Opens App
   - **Description**: Allows phone users to be intentional with phone usage by prompting them to note down their intention when reflexively opening designated "mindlessly opened" apps.
   - **Category:** Productivity
   - **Mobile:** Ideal as a mobile-only app, as users tend to reflexively open phone apps throughout the day without much thought for constant dopamine hits.
   - **Story:** Allows smartphone users to regain agency over their app usage, and could be a more powerful tool than screen time blockers or stats as it is preemptive tool that brings back intentionality to the way we use our phones.
   - **Market:** Any smartphone user. Period.
   - **Habit:** Is triggered whenever a pre-designated app is opened. The app itself is opened to modify the list of "mindlessly used apps" when needed.
   - **Scope:** V1 would display a screen for 3-6 seconds prompting the user to ask if they really need to open the app, and a button with the option to exit. V2 allows the users to enter in text their intention behind opening the app & the log will be recorded in the user's local Notes app. V3 will include a section in the user app where they can access their opening intention logs.

## Final App Idea Chosen
The **recipe finder app** was the winner! Introducing Meal Mate. 🍲

We looked up suitable APIs and here were a few options:
- TheMealDB: https://www.themealdb.com/api.php
- Spoonacular: https://spoonacular.com/food-api/docs
- Tasty: https://publicapi.dev/tasty-api

We decided to go with TheMealDB as a test API key was already provided for easy testing of our future app. The documentation was also easy to understand & we would be able to accomplish a lot of the app functionality we envisioned with the documented API calls.
