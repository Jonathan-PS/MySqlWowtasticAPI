##Overview:

####Build a database
_Use hibernate to persist data
Build rest points for the database_

I found MAMP to be an easy to setup a mySQL server
 https://www.mamp.info/en/
On windows, go to settings and reset the mamp ports before running.

###Database Requirements:

The database will hold information for characters in an online rpg game:

1. user table (5 minimum)
    User login information
2. character table (1-3 per user)
    Character details (name/level)
3. class table (3 minimum)
    What abilities that class has access to

## REST Requirements:

1. GET /users 
    returns all user names
2. GET /user/{id}
    returns info for one user
3. GET /character/{id}
     returns character info
4. GET /class/{className} 
    returns info for that class 
5. POST /user 
add a new user
6. POST /character 
add a new character

- Data must be sent in POST body (not header/parameters)
IE. as if the data could be sent as form-data

#### (Optional)
- Use Postman to set up sample GETs and POSTs for testing

- The REST API does not need to handle update/delete

#### Hosting Requirements / Hand-in:

You may hand in either:

- The complete source code AND and export of the database (.sql)

OR

- A link to the app on Heroku (preferable - README.md)
Optional: A link to everything hosted on github/gitlab (Code and SQL)
Optional: Sample GET & POST methods for me to test (in README.md)
