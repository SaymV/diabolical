-- Test fixture items.
insert into item(id, name, slot, mindamage, maxdamage, critchance, atkspeed, defense, absorption, blockchance, level) values(5000000, 'MyBracer', 'Bracer', 1600.0, 1450.0, 90.0, 2, 99.9, 99.8, 99.7, 30);
insert into item(id, name, slot, critchance, atkspeed, absorption, level) values(5000001, 'SOJ', 'Finger', 85.0, 2, 90.0, 80);

insert into itemtemplate(id, name, slot, minMindamage, maxMindamage, minMaxdamage, maxMaxdamage, minCritchance, maxCritchance, minAtkspeed, maxAtkspeed, minLevel, maxLevel) values(5000000, 'MyBracer', 'Bracer', 1400.0, 1450.0, 1700.0, 1750.0, 0.9, 0.99, 2, 5, 20, 30);
insert into itemtemplate(id, name, slot, minLevel, maxLevel) values(5000001, 'SOJ', 'Finger', 34, 42);

insert into account(id, firstName, lastName, login, password, gender) values(100001, 'Jose', 'Jose', 'upswimsdn', 'aaaaaa', 0);
insert into account(id, firstName, lastName, login, password, gender) values(100002, 'Ignatius', 'Lion', 'lmulion', 'iggy', 0);
insert into account(id, firstName, lastName, login, password, gender) values(100003, 'Bart', 'Simpson', 'bs', 'hello', 1);
insert into account(id, firstName, lastName, login, password, gender) values(100004, 'Isabelle', 'Johnson', 'iz', 'hello', 1);

insert into character(id, classtype, gender, level, money, name) values(100001, 'Wizard', 0, 99, 1000, 'HarryPotter');
insert into character(id, classtype, gender, level, money, name) values(100002, 'Wizard', 1, 99, 1000, 'HermioneGranger');
insert into character(id, classtype, gender, level, money, name) values(100003, 'Warrior', 0, 99, 1000, 'Ogre');
insert into character(id, classtype, gender, level, money, name) values(100004, 'Rogue', 0, 57, 1000, 'RayToal');
insert into character(id, classtype, gender, level, money, name) values(100005, 'Healer', 0, 55, 1000, 'Dondi');

insert into quest(id, name, description, clue, reward, characters) values(100001, 'Quest 1', 'First quest', 'Clue 1', 'Reward 1', 0);
insert into quest(id, name, description, clue, reward, characters) values(100002, 'Quest 2', 'Second quest', 'Clue 2', 'Reward 2', 1);
insert into quest(id, name, description, clue, reward, characters) values(100003, 'Quest 3', 'Third quest', 'Clue 3', 'Reward 3', 2);
insert into quest(id, name, description, clue, reward, characters) values(100004, 'Quest 4', 'Fourth quest', 'Clue 4', 'Reward 4', 3);
insert into quest(id, name, description, clue, reward, characters) values(100005, 'Quest 5', 'Fifth quest', 'Clue 5', 'Reward 5', 4);

insert into skill(id, name, description) values(10001, 'Skill 1', 'First Skill');
insert into skill(id, name, description) values(10002, 'Skill 2', 'Second Skill');
insert into skill(id, name, description) values(10003, 'Skill 3', 'Third Skill');
insert into skill(id, name, description) values(10004, 'Skill 4', 'Fourth Skill');
insert into skill(id, name, description) values(10005, 'Skill 5', 'Fifth Skill');
