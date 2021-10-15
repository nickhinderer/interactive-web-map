# Inspection - Team *T04* 

The goal of an Inspection is to find defects.
We first identify the code we wish to inspect, determine the time we wish to meet, and determine the checklist we will use to find faults in our code during the preparation before the meeting.

|  | Details |
| ----- | ----- |
| Subject | Database.java, Query.java, FindRequest.java |
| Meeting | *October 14, 2021, 5:00PM, Morgan Library: Study Room 29A* |
| Checklist | https://www.michaelagreiler.com/code-review-checklist-2/ |

### Roles

We note the amount of time each person spent reviewing the code in preparation for the meeting.

| Name | Preparation Time |
| ---- | ---- |
| Kaiyan | 30 min |
| Nick | 40 min |


### Problems found

We list each potential defect we found in the code during our preparation so we can discuss them in the meeting.
We add a GitHub issue for each defect that requires a modification to the system.

| file:line | problem | hi/med/low | who found | github#  |
| --- | --- | :---: | :---: | --- |
| Query.java:30 | ambiguous parameter| low| Kaiyan | #446 |
| Query.java:20,25 | duplication of code on lines 20-21 and 25-26 | low | Nick | #450 |
