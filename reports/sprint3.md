# Sprint 3 # - *t04* - *Geek Velocity*

## Goal
### *How far is it?*

## Scrum Master
### *Kaiyan Zeng*

## Definition of Done

* The Increment release for `v3.x` created as a GitHub Release and deployed on black-bottle under SPRINT.
* The design document (`design.md`) is updated.
* The sprint document (`sprint.md`) is updated with scrums, completed metrics, review, and retrospective.


## Policies

### Mobile First Design
* Design for mobile, tablet, laptop, desktop in that order.
* Use ReactStrap for a consistent user experience (no HTML, CSS, style, etc.).

### Clean Code
* Code Climate technical debt ratio less than 3.
* Minimize code smells and duplication.

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
For this sprint, we will have our team focus on five epics which include "Find Places", "Interoperability", "Where am I", "Distance" and "Upload Trip". We will finish "
Find My Place"first to make users able to add their found place to the itinerary and trip and fix the existing bugs. Then we will get "Interoperability" done to show each
server name and ableto switch to other servers and display each feature available there. Other than that, we will mostly focus on "Distance". Our main goal is to get Distance 
completely done by shows the total miles between two places and incorporate it with the trip we added from found matches. Also, get "Load Trip" epic don to get users able to 
upload their saved trip to the system and display it in the right place, and mark it on the map. For "Where I am", a little button will handle this function. This epic will 
get users able to find their location on click.

We plan on finishing "Find Places" first by update the List file to add the "add" function. Also, add more details to show "No Result Found" when there are no places 
found in the database.And there are two existing bugs. One is matching places only show up when we close the search modal. This is related to the set display function 
inside the findModal not working well.The task for fixing this one will be assigned to either Abby or Jacki. The second bug is that the server response doesn't send back 
the right data with a specific match. The task for adding more details will assign to whoever can handle it. These tasks will be done by Nick since he handle most part of 
the server-side 

The second epic we plan on finishing is "Interoperability" that gonna list all the teams' server names and show available features on each server. To get this part working 
we intend to create a file for all servers' information, a file for handling display the list, and the last part will incorporate with ServerSetting file to add two new 
lines for display the Dropdown menu and each server's feature. This part will be handle by Kaiyan.

The third epic we plan on finishing is "Where Am I". This epic will focus on applying Geolocation to give the user their current location and abe to add it to the trip, 
for the extended feature we might apply a "where I am " button or "home" icon for setting up starting point to the user's current location. These tasks can work parallel 
with the other epic since it will not affect the other epic, which will be assigned to Mallory.

The fifth epic we plan on finishing is "Distance". This epic will allow users to see the distance between two places in a click. This task will involve both client-side
and server-side. For the client side, we will need to add a few new classes and some new features to calculate the distance and grab data from the server response. And for 
the server-side, we need to change the query to make sure that the server sends back the right information. The tasks related to the server-side will be assigned to Nick. 
Other members will offer help when needed.The tasks related to the client-side will be evenly split between all the other teammates.

In the last epic, we plan on finishing "Load Trip". This epic will consider a bonus epic to finish if we can the first four done. In this epic, we will give the user the 
ability to upload their saved trip and go over all the trip then display it on the map and itinerary. It will relate to creating a new file to save uploaded trips. 
And new class to handleadd this trip to the correct place. This task will split evenly between all team members and see who is available and able to handle the tasks.

## Metric

| Statistic | # Planned | # Completed |
| --- | ---: | ---: |
| Epics | *5* | *5* |
| Tasks |  *40*   | *133*  | 
| Story Points |  *49*  | *135*  | 

Based on our team's previous performance, it would be achievable to finish at least 4 epics. From what we left last, we can finish the "Find My place" pretty soon, which is 
already done mostly on the starting date of this sprint. And "Interoperability" already done most part on the starting date of sprint3 also. What we left will be "Where I am"
, "Distance", and "Upload Trip". Although Our team was not able to complete all tasks previously, we have more knowledge and are much more confident to handle epics on this
time working with each other. So the team is more than capable of taking on the current tasks.

## Scrums

This allows us to track our progress on tasks during the scrum.
The #*task* numbers refer to the issue numbers in GitHub.

| Date | Tasks closed  | Tasks in progress | Impediments |
| :--- | :--- | :--- | :--- |
| 10/4 | #247, #163|  | N/A |
| 10/5 | #277, #272, #263, #262, #261,#281,#285,#286,#276,#282,#298,#300,#292,#290,#283 |  #191,#267, #268 | N/A | 
| 10/6 | #312, #311, #279, #251, #264, #266, #268, #267,#315 | #191, #303 | N/A |
| 10/8 | #323, #325, #321, #259, #257, #317, #329  | #191, #303 | N/A |
| 10/11 | #343, #249, #338, #318, #280, #358, #365, #362, #355, #352, #357, #351, #353, #349, #275, #367, #191, #363, #369  |  #303,#363, #332,#333, #294, #241, #242  | N/A |
| 10/14 | #444, #455, #439, #437, #442, #443, #435, #433, #425, #430, #428, #423, #373, #421, #265, #419, #416, #414, #415, #412, #410, #408, #402, #331, #398, #391. #397, #394, #392, #244, #388, #390, #386, #383, #294, #382, #242, #377, #375, #285 | #332, #303, #333, #241, #240 | N/A |
| 10/18 | #483,#488,#486,#487,#255, #480, #477, #475, #488, #466, #440, #471, #403, #450, #380, #463, #459, #456   |#332, #303, #333, #241, #240, #274| N/A |
| 10/20 | #472, #497, #499, #493, #273, #481, #489, #274, #380, #489,  |#293, #240, #491 | Lack of Knowledge |
## Review

### Epics completed
In this sprint, our group was able to finish all the epics: "Interoperability", "Where Am I", "Distance", "Load Trip", and "Find Places". We can add matched places to the page and shows them correctly on the map. We hold a home button where users can locate themselves on the map of the trip. And the interoperability can connect to other servers and show available features and website addresses. To be user friendly we also provide a list of server can be chosen.  And the distances between each place and round trip distances will be shown by one click of the "Find Distances" button, which could be improved in the future by showing the distances onChange. And Load Trip works perfectly with only specific types of JSON and CSV files with validation.

### Epics not completed

## Retrospective

### Things that went well
As a team, I think we did really well at splitting work and updating work to each other at this time compare to last sprint. We incorporate together at the some epices but also split it resonally between each other to make this 5 epices much achievable. We also did really good at break down the epices to little task. And our communication skill get better during the scrum meeting which only mentioned the main point and progress everyone made to make meeting short and precise. 

### Things that we need to improve 
Regarding the product, one thing that we can do better is always writing a test with the code we wrote instead of writing it after the cod merged. Another things would be writing better code, checking the code climate before creating a pull request. Also, test more of the functionality of the part we wrote instead of checking or finding the bug on the due day.  Regarding the team, we can do better at responding to each other's messages on Slack.

### One thing we will change next time
Regarding the product, our team could change next time by testing and checking bugs of the product frequently, writing more test code, and writing much cleaner code. Also, we should spend more time together to understand both the client-side and server-side of the product

