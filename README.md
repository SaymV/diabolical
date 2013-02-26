Diabolical
==========

This is a database back-end with a web service for a role playing game. Diabolical was implemented as a project for Loyola Marymount University's CMSI 486 class. Note: there is a master branch and a secondary branch that shows the class's effort to convert the stack to use Google App Engine.(gae)
The live application may be found at [http://lmu-diabolical.appspot.com/](http://lmu-diabolical.appspot.com/)

The database consists of:

- Users: Users include a username, some sort of other name, an identifier, gender, the collection of characters under that user
- Characters: A character consists of a name, gender, class, level, a collection of items, alignment, quests accomplished, skills, stats, money, current location
- Items: stats, abilities, slots (where it goes on a character; also functions as the item's type), minimum damage, maximum damage, attack speed, critical chance, armor, block chance, melee damage mitigation
- Quests: name, NPCs, reward, description, clues
- NPCs: health, name, gender, damage rating, hostility, group aggro

[For reference documentation please see our wiki!](https://github.com/SaymV/diabolical/wiki)
