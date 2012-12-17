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