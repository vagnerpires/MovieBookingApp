# Mobile Apps 1 CA2

- Student Name: Your name
- Student ID: 123456
- Course: Your course

## Requirement Checklist

- [X] 1. Movie recycler view:
   - [X] 1.1. Create a Movie class with the structure specified in movie.json (provided on Moodle)
   - [X] 1.2. Obtain and fill data (minimum of 4 movies)
      - [X] 1.2.1. Obtain relevant movie data from Vue (https://www.myvue.com/cinema/dublin/whats-on) or your favourite provider and add data credits at the bottom of the app
      - [X] 1.2.2. Generate a random number between 0 and 15 for each movie and assign to seats_remaining
      - [X] 1.2.3. Start with an initial default seats_selected value of 0 for all movies
      - [X] 1.2.4. You shall fill random URLs for images from pixabay or other free image providers to begin with
   - [X] 1.3. Build a Recycler View using the specified template, refer to recycler_view_template_*.jpg (provided on Moodle)
   - [ ] 1.4. If any seats are selected, show how many seats are selected and hide remaining seats
- [X] 2. Seat selection feature:
   - [X] 2.1. Clicking any item (anywhere on the item) on the movie recycler view should open a new MovieActivity, refer to movie_activity_*.jpg (provided on Moodle)
   - [X] 2.2. Add plus and minus icons, show seats_selected in the middle
   - [X] 2.3. On click plus/minus, update both seats_selected and seats_remaining for that movie
   - [X] 2.4. Add validation, when 0 seats selected minus is disabled, when 0 seats remaining plus is disabled
   - [ ] 2.5. When back is pressed, the selected seats are retained and reflected in the recycler view. (Hint: If you don’t see any updates, call adapter notifyItemChanged as soon as you return to the recycler view activity)
- [X] 3. Bonus:
   - [X] 3.1. Add "filling fast" badge if less than 3 seats remaining
   - [X] 3.2. Use "Roboto Condensed" font to replicate same style
   - [X] 3.3. Use original movie images from myvue.com or your favourite provider (Hint: check get_movie_image_url.gif (provided on Moodle))