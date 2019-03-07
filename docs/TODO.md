### TODO list

#### Question
- Can I have only one manager?
##### DB INIT
1. DONE Construct TABLE characters character_id (primary), user_id, character_name (unique), class_id, level 
2. DONE Construct TABLE classs class_id (primary), class_name, ability_list
3. DONE fill these tables


##### REST stuff
1. GET /users 
    - DONE SQL query
    - DONE make controller

2. GET /user/{id}
    - DONE  need a SQL query table users on userId
    - DONE  make controller

3. GET /character/{id}
    - DONE need a SQL query table character on characterId
    - DONE make controller

4. GET /class/{className} 
    - DONE need a SQL query on table class_ability on className showing its abilities
    - DONE make controller

5. POST /user 
    - DONE add a new user
    - DONE make controller for use in curl

6. POST /character 
    - DONE add a new character
    - DONE make controller for use in curl


#### Improvements
1. DONE in CharacterQueries.addCharacter() check whether character class is legal
2. in User add list or map of all owned characters.
3. DONE eliminate usage of enum. Instead make class_name a foreign key in table class_abilities
4. DONE Delete table abilities. Its information is stored in table class_abilities.
5. make a HTML main page at ("/")


## TODO after 7.03.2019 13:50
1. In class User add map of owned characters.
2. Create HTML main page at ("/") with links to all get pages
3. Deploy to Heroku
4. README.md