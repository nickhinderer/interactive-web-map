# Sprint 5 - *T04* - *Geek Velocity*

## Goal
### *Release!*

## Sprint Leader: 
### *Mallory Cahill*

## Definition of Done

* The Increment release for `v5.x` created as a GitHub Release and deployed on black-bottle under SPRINT.
* The design document (`design.md`) is updated.
* The sprint document (`sprint.md`) is updated with scrums, completed metrics, review, and retrospective.

## Policies

### Mobile First Design
* Design for mobile, tablet, laptop, desktop in that order.
* Use ReactStrap for a consistent user experience (no HTML, CSS, style, etc.).

### Clean Code
* Code Climate maintainability of A (technical debt ratio==0).
* Minimize code smells and duplication.
* Use Single Responsibility Principle.

### Test Driven Development
* Write the tests before the code.
* Unit tests are fully automated.
* Code coverage is 70%

### Processes
* Incremental development.  No big bangs.
* Main is never broken. 
* All pull request builds and tests for Main are successful.
* All dependencies managed using Maven, npm, and WebPack.
* GitHub etiquette is followed always.


## Planned Epics

* This sprint, our team will work on completing six epics in order to add more features to our application. There isn’t necessarily an order of precedence since the designated epics are the same as Sprint 4. Besides the new epics we plan on finishing, we will also be making edits to our previous “Shorter Tour” and “Save Trip” epics to fix bugs, add tests, and implement 2-opt.

* We plan to complete “Trip Name”, which will allow the user to edit the name of their trip; this will appear at the top of the itinerary and if the user decides to download their trip, the name they chose will appear before the json extension. For this feature, we will be adding an icon next to the default “My Trip” that the user will be able to click on and input a name of their choosing.

* Next, we plan to complete the “Highlight Place” epic. This feature will allow the user to select a place in the trip itinerary and have it displayed on the map with a marker as well as in the itinerary. We will be adding onClick functionality for the itinerary rows in order to create the ability to highlight a place in the list with a different color. 

* We also plan to complete the “Where Is?” epic, which allows the user to search for a latitude/longitude combination and have the option to add it to their trip. For this feature, we will be adding a button to the main hamburger and an input box for the user to search. The input will send a request to the server and the user will see a list of options returned from the server. Then the user will be able to choose whether to add places from the list to their trip; if so, a marker will be added to the map and the place will appear in the itinerary. 

* Next, we plan to complete the “Maps” epic, which will allow the user to choose different backgrounds for the map of their trip. This will be implemented through adding a layers icon/button to the corner of the map; when the user clicks on the button, a list will appear with different map options to choose from. The selected map will be remembered for future sessions.

* We also plan on completing another “User Experience” epic similar to in Sprint 4, where each team member will get feedback from somebody outside of class based on a list of tasks we create. Each of us will document our observations and feedback, based on what the user had trouble with, in order to improve our application and user experience.

* Finally, we plan to complete the “Random Places” epic, which will allow the user to see a list of random places they might visit with their details, and have the option to select one or more to add to their trip. This feature should be relatively easy for our team to implement because currently our search feature generates a list of random places if an empty string is inputted. For this epic, we will continue to use the protocol find feature and progressive disclosure. 


## Metrics

| Statistic | # Planned | # Completed |
| --- | ---: | ---: |
| Epics | *6* | *6* |
| Tasks |  *54*   | *95* | 
| Story Points |  *63*  | *87* | 


## Scrums

| Date | Tasks closed  | Tasks in progress | Impediments |
| :--- | :--- | :--- | :--- |
| *11/16* | *#752, #749, #742, #784, #783, #777, #788* | *#759, #740, #741, #767* | N/A |
| *11/17* | *#780, #796, #798, #799, #802, #804* | *#759, #740, #741, #767* | N/A |
| *11/19* | *#78, #635, #736, #751, #811 #816, #746* | *#814, #691, #759, #740, #741, #767, #778, #781*| N/A |
| *11/30* | *#781, #688, #691, #790, #793, #824, #828, #829, #833, #747, #759, #814, #835, #837, #839, #844, #846, #848, #850, #854, #856, #859, #861* | *#740, #741, #767, #778* | N/A |
| *12/6* | *#762, #769, #842, #865, #867, #872, #873, #874, #760, #713, #765, #778, #879, #882* | *#740, #741, #767, #806, #883* | N/A |
| *12/9* | *#712, #753, #754, #755, #756, #887, #889, #892, #748, #806, #883, #899, #902, #903, #745, #767, #770, #771, #773, #774, #906* | *#740, #741, #772, #870* | N/A |


## Review

### Epics completed  
We were able to complete all epics that we planned for at the beginning of the sprint: Trip Name, Highlight Place, Where Is, Maps, User Experience, and Random Places. Users are now able to customize the name of their trip, highlight a certain place on the map, search a latitude/longitude combination, change the map background, and generate a list of random places to add to their trip.

### Epics not completed 
We were able to complete all epics.

## Retrospective

### Things that went well
I think our team did a great job communicating with each other and listening to each other's ideas. Our scrum meetings were very helpful to see where we all were at. I think we also did a good job of each completing pull requests every day and working on small chunks of code every day so it wouldn't be last minute. Like the last few sprints, we also did a good job of splitting work up between each member so that we could finish more epics.

### Things we need to improve
One of the main things we could've done better was just cutting out more time to complete work for this class. While we did finish all of our planned epics, I think it was easier to spend less time on this class because it was the last sprint and because finals are coming up. That being said, we have definitely improved our time management skills since the first sprint. 

### One thing we will change next time
This is the last sprint, but for future classes, I think we could be better about testing our code; I think a lot of us struggled with that and it would be a good thing to do going forward.
