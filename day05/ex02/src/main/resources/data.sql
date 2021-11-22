INSERT INTO Users(login, password) VALUES('snaomi', 'macbookpro');
INSERT INTO Users(login, password) VALUES('lchantel', 'qwerty123');
INSERT INTO Users(login, password) VALUES('burger_bot', 'king');
INSERT INTO Users(login, password) VALUES('deadpool', 'delamuerta');

INSERT INTO Chatroom(name, owner) VALUES('burger_spam', 3);
INSERT INTO Chatroom(name, owner) VALUES('marvel_chat', 4);
INSERT INTO Chatroom(name, owner) VALUES('java_piscine', 1);

INSERT INTO Message(author, room, text, date_time) VALUES(2,
                                                          1,
                                                          'Go to the hell with your burgers, i prefer KFC',
                                                          '2021-11-06 06:01:34');
INSERT INTO Message(author, room, text, date_time) VALUES(3,
                                                          1,
                                                          'You''d better study java, instead of yelling all over, scrub',
                                                          '2021-11-08 06:10:21');
INSERT INTO Message(author, room, text, date_time) VALUES(2,
                                                          3,
                                                          'Hey guys, when java piscine starts?',
                                                          '2021-11-19 23:18:04');
INSERT INTO Message(author, room, text, date_time) VALUES(1,
                                                          3,
                                                          'Are you kidding, where you''ve been alltime? Serious man...',
                                                          '2021-11-19 23:18:41');
INSERT INTO Message(author, room, text, date_time) VALUES(2,
                                                          3,
                                                          'What? ffffffffffffuuuuuuuuuu!!!!11',
                                                          '2021-11-19 23:19:31');
INSERT INTO Message(author, room, text, date_time) VALUES(3,
                                                          3,
                                                          'lol',
                                                          '2021-11-19 23:21:42');