# Inspection - Team *T04* 

The goal of an Inspection is to find defects.
We first identify the code we wish to inspect, determine the time we wish to meet, and determine the checklist we will use to find faults in our code during the preparation before the meeting.

|  | Details |
| ----- | ----- |
| Subject | *Tour.js* |
| Meeting | *11/30/2021, 5:00PM, Group Study Room 114* |
| Checklist | *[checklist.md](https://github.com/CSU-CS-314-Fall-2021/t04/blob/main/reports/checklist.md)* |

### Roles

We note the amount of time each person spent reviewing the code in preparation for the meeting.

| Name | Preparation Time |
| ---- | ---- |
| Jacki | 30 Min. |
| Abby | 25 min |
| Nick | 30 min |
|  |  |
|  |  |


### Problems found

We list each potential defect we found in the code during our preparation so we can discuss them in the meeting.
We add a GitHub issue for each defect that requires a modification to the system.

| file:line | problem | hi/med/low | who found | github#  |
| --- | --- | :---: | :---: | --- |
| Tour.js: 97-101 | Code Duplication in Code Climate | med | Jacki | #720 |
| Tour.js: ... | Function order could be reorganized for better flow/understanding | low | Jacki | |
| Tour.js: 38 | ClassName property name does not correspond to the function of the return | low | Abby | #846 |
| Tour.js: ... | Reuse base code; use "places" state variable from usePlaces instead of creating a "newTrip" array | low | Abby | #847 |
| Tour.js: 58-71 | Nested function. Violates single responsibility principle. Could be split into two seperate functions | low | Nick | |
| Tour.js: 81-93 | Nested if statements. Could reduce cognitive complexity by splitting into multiple functions | low | Nick |  |
