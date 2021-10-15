# Interop for t04

Interoperability testing allows us to verify correct operation when connected to another team's client or server.
Each team member must verify interoperability with the client and server from another team.
Each of the different aspects of the protocol must be verified.
We will discuss these issues with the other team and create defects in GitHub for any problems found in our system.
 
### Other Teams

This table lists each student in the team, the team they verified interoperability with, and the time to complete the testing.

| Name | Team | Time |
| ---- | ---- | ---- |
| Kaiyan | 13 | 15 min |
| Abby | 12 | 15 min. |
| Nick | ---- | ---- |
| Mallory | 22 | 15 min |
| Jacki | 1 | 15 min |
|  |  | |


### Client Problems found

We found these problems when connecting our client to another team's server.

| team | problem | github# |
| ---- | ---- | ---- |
| 12 | Config request was not supported; could not connect to team 12's server to test find or distance features; unable to hit "Save" button | #444, #421 |
| 1 | Distance request returns 404 Error instead of 400 | |
| 13| None Found | #414, #415 |
| 22 | None Found | |


### Server Problems found

We found these problems when connecting the other team's client to our server.

| team |  problem | github# |
| ---- | ---- | ---- |
| 12 | Config request to localhost:31412 failed; Once connected to our server at localhost: 31404, config requests were successful | #455, #428, #435 |
| 1 | None Found | |
| 13 | Config features to localhost:31413 failed with invalid json response | #414, #415 |
| 22 | None Found | |
