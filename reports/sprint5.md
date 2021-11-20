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
| Epics | *6* | *count* |
| Tasks |  *54*   | *count* | 
| Story Points |  *63*  | *sum* | 


## Scrums

| Date | Tasks closed  | Tasks in progress | Impediments |
| :--- | :--- | :--- | :--- |
| *11/16* | *#752, #749, #742, #784, #783, #777, #788* | *#759, #740, #741, #767* |  |
| *11/17* | *#780, #796, #798, #799, #802, #804* | *#759, #740, #741, #767* |  |
| *11/19* | *#78, #635, #736, #751, #811 #816, #746* | *#814, #691, #759, #740, #741, #767, #778, #781*| |


## Review

### Epics completed  

### Epics not completed 

## Retrospective

### Things that went well

### Things we need to improve

### One thing we will change next time
