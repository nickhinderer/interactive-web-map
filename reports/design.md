# Introduction

This document describes the architecture and design of a single page web application that interacts with microservices via RESTful APIs.
The key elements in this document include the architecture, user interface, client components, and server classes.

This is a living document that is updated as changes are made each sprint.
The initial document describes the Base code students are given as a starting point for the semester.
Students are expected to update this document as changes are made each sprint to reflect the evolution of their application and key decisions they make.
The Base section serves as an example.


# Base

The Base is a simple application to provide the architecture to the students at the beginning of the semester.
The JavaScript code will be useful examples for students to learn from and leverage in the code they write for sprint 1.
The progressive display of information using collapsible sections and popups will serve as examples of good user interface design.
The overall design is somewhat minimalist/simple for the intended mobile device audience.

### Architecture

The Base architecture is a JavaScript single page web application in an HTML5 browser that uses RESTful APIs to access Micro-services provided by a Java server running on Linux.
The client consists of a minimal index.html file that loads and executes the bundled JavaScript application.
The client and server files are bundled into a single JAR file for execution on the Linux server at a specified port.
The browser fetches the client files from the server on the specified port.

![overview](../images/BaseArchitecture.png)

The browser loads the index.html file (by default) which in turn loads the bundled JavaScript single page application bundle.js.
* The single page application makes RESTful API requests to the server on the same port using  JavaScript's asynchronous fetch.  
* A protocol document describes the JSON format for the RESTful API requests and responses.
* JSON Schemas are used to verify requests on the server side and responses on the client side.
* On the client, ReactJS renders the application using ReactStrap, Leaflet, and application defined components.
* GSON is used on the server to convert JSON requests to Java objects and Java objects to JSON responses.
* The client (ulog) and server (SLF4J) logging mechanisms control debugging output during development and production - print statements and console logging should never be used. 

The following architecture elements are not included in the Base system.
They will be added later in the semester.
* Client filesystem.
* Server SQL.
* Server concurrency.


### User Interface
![base](../images/Map.png)

The basic screen in black shows the view on a mobile device, with a header, footer, and trip.
The header contains a earth logo and the team name obtained from the server when the client was loaded.
The footer contains a connection icon along with the current server name and server URL the client is connected to.
The trip shows a map and the current list of destinations.

Rather than buttons or icons to signify actions, we are associating actions with elements that are already on the screen to reduce the clutter.
We are using both popups and collapsible sections in this design rather than choosing to use one exclusively.
* Collapsible/Hidden sections are used for the map and about sections since they have a significant amount of content and we don't need to see them at the same time.
* A popup is used for the URL change since we want to control the interaction until the operation is completed. It seemed more natural than another collapsible section.

#### Clicking on the team name in the header displays an empty about screen.
Clicking again restores the trip screen.
We will fill this in later.

#### Clicking on the map adds to the trip.
Whenever a user clicks on the map, the client should display a marker with latitude, longitude, and a description at that location.
The description is obtained from reverse geocoding.
The location information is also added to the trip list below the map.
We only maintain a single marker at this point displaying the most recently clicked location.

#### Clicking the hamburgers (&#8942;) displays a menu of options.
At the trip level you can add the home (CSU Oval) location or clear the list.
At the destination level you can remove that destination from the list.

#### Clicking on the URL in the footer should let me change the server.
Whenever a user clicks on the URL a popup should open showing the team name, the URL in an input text box, and a Cancel button.
When the user modifies the URL, the client will attempt to connect to the new server and update the configuration.
When the Test button is clicked, it will attempt to connect to the server.
If not successful, nothing changes and the user may continue to make URL changes or click the Cancel button to return to the original sever (it shouldn't change).
If successful, the new server name should appear and a Save button should replace the Test button.
When the user clicks the Save button, the server connection should change and the popup closes, revealing the new servername and URL in the footer.

### Component Hierarchy
The component hierarchy for the base application depicted below shows the our top level App component with four children components.
* App renders the major components on the screen.
* Header renders an icon and a team name in the top banner.
* Footer renders the current server connection in the bottom footer.
* Atlas renders a map.
* About renders information about the team.

![base component hierarchy](../images/ComponentsBase.png)

We do not show the many ReactStrap components in this hierarchy, even though they will appear when you are debugging on the client.

### Class Diagram
The class diagram for the base application depicted below shows the basic structure of the web server application.

![class diagram](../images/serverclasses.png )

The classes in blue represent the classes specific to this application.  
* WebApplication processes command line parameters and creates MicroServer.
* MicroServer start a web server on the given port, configures the server for security, static files, and APIs for different types of requests, and processes the requests as they arrive.
* JSONValidator verifies a request is properly formatted before attempting to process it using JSON Schemas.
* ConfigRequest is a specific request that allows the server to respond with its configuration to allow interoperability between clients and servers. 
* Request defines the basic components of all requests.
* BadReqeustException allows us to distinguish bad requests from other types of exceptions that may occur.
* Place is a class that extends a hashmap of two strings
* Places is a class that extends arraylist of type place
* FindRequest is a specific request that allows the server to respond with a query from the database containing the number of matches and a list of Places
* Query takes the parameters given to FindRequest and creates a search for the database
* Database creates a connection to the database, sends the query, and then processes and returns results
* DistanceRequest
* TestDistanceRequest

These test classes provide automated tests for unit testing.
* TestWebApplication
* TestConfigRequest
* TestJSONValidator
* TestFindRequest
* TestDistanceRequest

# Sprint 1


### User Interface

In this sprint, we will focus on team information.
There are two primary parts:
* browser tab, header, and footer.
* about page which includes team and member information,

Whenever a user clicks the team name in the header, a collapsible section should appear under the header with information about the team.
The collapsible map should disappear so only the about or map are displayed.
A simple toggle in state should be able to control this rendering.
The about page should contain the team name as a heading. 

![base](../images/About.png)

The team name in the browser tab, header and are simple changes to constants in the client and server.

### Client Components

We will add 3 new components to the base architecture on the client to support the about page.
* Team component will render the team information
* Person component will render the individual information for a team member
* AboutCard component will render the team/individual information in a consistent fashion.

The existing About component will be modified to control the layout of the Team and Person components on the page.

![components1](../images/ComponentsSprint1.png)

### Server Classes
There are no changes to the server class structure in this sprint.
Only minor changes to text constants are required.

# Sprint 2


### User Interface

In this sprint, we will focus on adding new interface components to the map, and add features to trip configuration.
There are two primary parts:
* Find places
* Highlight place

When a user enters a simple string in a search bar, matching places and their details should appear in a list. 
The user can then select one or more places from the list to add to their trip. 
The user will be able to select and highlight a place in their trip list.

#### Drawing for #68 Highlight Place Epic

<img src="https://user-images.githubusercontent.com/82910022/133346881-60cf74e7-dce8-473c-9683-e482ed274b90.jpg" alt="User Interface Highlights Drawing" width="525"/>

As the drawing shows, the highlighted place will have an H icon above it in the map portion of the interface. 
To make the highlighted place stand out, we are going to change a bit of css from the base code by :
* dropping the row css attribute that makes every other row of places bordered and filled in with a grey background. 
* changing the background color within the borders to a beige/light-green brackground. For lack of a beige colored pencil, this was not demonstrated in the drawing.  


### Drawing for #66 Find Places Epic

<img src="https://user-images.githubusercontent.com/74014694/133350487-e2c7efe1-c115-4825-bb8b-e56683899c7e.jpg" alt="User Interface Find Places Drawing" width="525"/>


<img src="https://user-images.githubusercontent.com/82910022/134398817-fbeebd31-4e0f-4362-9620-7528f03a88c9.jpg" alt="findPlacesDrawing" width="525"/>

<img src="https://user-images.githubusercontent.com/74014694/135551810-0de23c3c-acf7-4b8c-92eb-4c103546b053.jpg" width="525" alt="findPlacesList"/>

There will be a search button above the map. When clicked, a modal opens and contains a search bar in which a string may be input. When a string is input into the search bar and the button is clicked, a list will pop up underneath the bar and the user will be able to add an item from the list to their trip. We will be changing the code by:
* Adding a search button that pops up a modal 
* Adding in a search bar in the modal
* Adding in a list 
* Adding dynamic functionality to accomplish adding item from list



### Client Components
![componenthierarchy](../images/componentHierarchySprint2.png)

We will add two new components to the base architecture on the client to support the planner page.
* The FindModal component will render the search bar information
* The List component will render the information found when the user searches for a location

### Server Classes
![serverclassdiagram](../images/ServerClassDiagram.jpg)

The server class structure will change as a result of this sprint to provide new components and features for the user. 
* By enforcing the use of the find protocol for Epic #66 "Find Places", the server will change such that it supports valid find requests sent from the client. 

# Sprint 3

### User Interface

In this sprint, we will continue working on aspects that we started in the previous sprint as well as adding more features to the trip configuration. 
There will be 5 primary parts:
* Finish Find Places
* Finish Interoperability
* Trip Distances
* Where I am?
* Load Trip

The user will be able to add items from a list to the trip itinerary. 
The user will be able to see distances between each location on the trip itinerary. 

### Drawing for #238 Distances Epic

<img src=https://user-images.githubusercontent.com/74014694/136080738-6ee093ed-ce2c-4b9a-857b-a49721c20ff0.jpg width="525" alt="Distances Interface"/>

Updates to the interface for this epic will add new features to the itinerary list. There will be an area for distance between each location added to the trip as well as the total distance of the trip. We will be changing the code by: 
* Adding a new column on the itinerary
* Adding a new row on the itinerary 
* Add a label for "Total:"

### Drawing for #253 Save Epic

For the Save File epic, the user will have the ability to save a trip to their local file system. The hamburger dropdown will have a save file option icon.

By clicking save file, the user will be able to add a trip object to any desired location in their system. When they press done this should either send the user an alert success or failure for their attempt to save a trip. 

We will have a file explorer popup for the user to use however their heart desires. 


### Client Components

We will be adding the following components to the client:
* Distance class to render the distance between locations

![sp3components](../images/Sprint3Components.png)

### Server Classes

# Sprint 4 
# Sprint 5
