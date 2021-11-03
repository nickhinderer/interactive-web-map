# Interop for t04

Interoperability testing allows us to verify correct operation when connected to another team's client or server.
Each team member must verify interoperability with the client and server from another team.
Each of the different aspects of the protocol must be verified.
We will discuss these issues with the other team and create defects in GitHub for any problems found in our system.
 
### Other Teams

This table lists each student in the team, the team they verified interoperability with, and the time to complete the testing.

| Name | Team | Time |
| ---- | ---- | ---- |
| Jacki | 23 | 25 min |
| Abby | 24 | 20 min |


### Client Problems found

We found these problems when connecting our client to another team's server.

| team | problem | github# |
| :--- |  :--- | --- |
| 23 | error: Site breaks when dave's is input in search bar | #621 |
| 24 | No UI feature for shorter trips requests | #629 |


### Server Problems found

We found these problems when connecting the other team's client to our server.

| team |  problem | github# |
| :--- |  :--- | --- |
| 23 | error: React failed to build DOM, when dave's is input into search bar | #621 |
| 24 | Bug in interop popup which doesn't allow t24's server to connect to our client | #629 |