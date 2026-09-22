# SpringHW - Football Team API


## Run the Application

The application runs on:

http://localhost:9091

## Endpoints

GET /api  
Shows information about the application.

GET /teams  
Returns all football teams.

GET /teams/{id}  
Returns one team by ID.

Example:
http://localhost:9091/teams/1

GET /teams/search?name={name}  
Searches for a team by name.

Example:
http://localhost:9091/teams/search?name=liverpool

GET /teams/filter?league={league}  
Filters teams by league.

Example:
http://localhost:9091/teams/filter?league=Premier%20League

POST /teams  
Adds a new team.

Example JSON:

{
"id": 0,
"name": "Arsenal",
"country": "England",
"league": "Premier League",
"titles": 13,
"rating": 8.7
}

PUT /teams/{id}  
Updates an existing team.

Example:
http://localhost:9091/teams/1

Example JSON:

{
"id": 1,
"name": "Liverpool",
"country": "England",
"league": "Premier League",
"titles": 21,
"rating": 9.4
}

DELETE /teams/{id}  
Deletes a team by ID.

Example:
http://localhost:9091/teams/1

GET /teams/stats  
Returns the total number of teams and the average rating.

GET /teams/random  
Returns a random football team.

## Sample Teams

- Liverpool
- Barcelona
- Bayern Munich
- Real Madrid
- Manchester City


