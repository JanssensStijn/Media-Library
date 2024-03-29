INSERT INTO MOVIE (IMDB, TITLE, YEAR_OF_RELEASE, TRAILER_LINK, DESCRIPTION, IMAGE_URL)
VALUES
    ('tt0111161', 'The Shawshank Redemption', 1994, '6hB3S9bIaco', 'Frank Darabont''s adaptation of Stephen King''s novella tells the poignant story of hope and redemption within the confines of Shawshank State Penitentiary.', 'https://firebasestorage.googleapis.com/v0/b/medialibrary-407109.appspot.com/o/The%20Shawshank%20Redemption.jpg?alt=media&token=997ac4f2-ea7d-43b6-a159-10b97736b062'),
    ('tt0468569', 'The Dark Knight', 2008, 'EXeTwQWrcwY', 'Christopher Nolan''s superhero epic features the iconic battle between Batman and the Joker, exploring themes of chaos and morality.', 'https://firebasestorage.googleapis.com/v0/b/medialibrary-407109.appspot.com/o/The%20Dark%20Knight.jpg?alt=media&token=1bd6ea83-aae4-4191-a5f5-2a0081f6e55f'),
    ('tt1375666', 'Inception', 2010, '8hP9D6kZseM', 'Christopher Nolan''s mind-bending thriller explores the concept of dreams within dreams and the power of the mind.', 'https://firebasestorage.googleapis.com/v0/b/medialibrary-407109.appspot.com/o/Inception.jpg?alt=media&token=9f8af470-fe18-4cfd-ab82-7428c27825b2'),
    ('tt0109830', 'Forrest Gump', 1994, 'bLvqoHBptjg', 'Robert Zemeckis''s heartwarming film follows Forrest Gump''s extraordinary life journey, intersecting with historical events.', 'https://firebasestorage.googleapis.com/v0/b/medialibrary-407109.appspot.com/o/Forrest%20Gump.jpg?alt=media&token=05199952-16d1-4497-9e63-ef3901f0578a'),
    ('tt0137523', 'Fight Club', 1999, 'SUXWAEX2jlg', 'David Fincher''s cult classic explores the impact of consumer culture on identity and the consequences of rebellion.', 'https://firebasestorage.googleapis.com/v0/b/medialibrary-407109.appspot.com/o/Fight%20Club.jpg?alt=media&token=aac55520-22f7-48dd-bbc1-07bb021a625e'),
    ('tt0167261', 'The Lord of the Rings - The Two Towers', 2002, 'LbfMDwc4azU', 'Peter Jackson continues the epic fantasy saga, as the fellowship faces new challenges in the quest to destroy the One Ring.', 'https://firebasestorage.googleapis.com/v0/b/medialibrary-407109.appspot.com/o/The%20Lord%20of%20the%20Rings%20-%20The%20Two%20Towers.jpg?alt=media&token=dd0e306b-39bb-48f9-8c50-59d2f3779907'),
    ('tt0068646', 'The Godfather', 1972, '2neD0MYBaL4', 'Francis Ford Coppola''s crime epic follows the Corleone family''s rise and struggles in the world of organized crime.', 'https://firebasestorage.googleapis.com/v0/b/medialibrary-407109.appspot.com/o/The%20Godfather.jpg?alt=media&token=4688e859-3cca-41db-b309-2a17514b68e1'),
    ('tt0120737', 'The Lord of the Rings - The Fellowship of the Ring', 2001, '_e8QGuG50ro', 'The first installment in Peter Jackson''s trilogy introduces the quest to destroy the One Ring and the formation of the fellowship.', 'https://firebasestorage.googleapis.com/v0/b/medialibrary-407109.appspot.com/o/The%20Lord%20of%20the%20Rings%20-%20The%20Fellowship%20of%20the%20Ring.jpg?alt=media&token=cb6a08f6-8b99-4b24-850b-48f93d16bb78'),
    ('tt0108052', 'Schindler''s List', 1993, 'JdRGC-w9syA', 'Steven Spielberg''s powerful film tells the true story of Oskar Schindler, a German businessman who saved over a thousand Jewish lives during the Holocaust.', 'https://firebasestorage.googleapis.com/v0/b/medialibrary-407109.appspot.com/o/Schindlers%20List.jpg?alt=media&token=21aa84df-3091-4da8-b56a-94d73fffa388'),
    ('tt0088763', 'Back to the Future', 1985, 'WRrCVyT09ow', 'Robert Zemeckis''s sci-fi comedy follows Marty McFly as he accidentally travels back in time and disrupts the space-time continuum, leading to hilarious and heartwarming adventures', 'https://firebasestorage.googleapis.com/v0/b/medialibrary-407109.appspot.com/o/Back%20to%20the%20Future.jpg?alt=media&token=ae1dd189-320b-4c14-8abf-66c692b79f70');

--------------------------------------------------------------------

INSERT INTO PRODUCER (NAME, HOMETOWN, NATIONALITY, BIOGRAPHY)
VALUES
    ('Frank Darabont', 'Montbéliard', 'American', 'Frank Darabont is an American filmmaker born in Montbéliard, France. He is best known for directing films such as "The Shawshank Redemption" and "The Green Mile."'),
    ('Christopher Nolan', 'London', 'British', 'Christopher Nolan is a British filmmaker born in London, England. Renowned for his work on movies like "Inception" and "The Dark Knight" trilogy, Nolan is acclaimed for his innovative storytelling and direction.'),
    ('Wendy Finerman', 'Los Angeles', 'American', 'Wendy Finerman is an American film producer hailing from Los Angeles, California. She won an Academy Award for producing "Forrest Gump" and has been involved in numerous successful film projects.'),
    ('Art Linson', 'Chicago', 'American', 'Art Linson is an American film producer born in Chicago, Illinois. Known for his work on films like "The Untouchables" and "Heat," Linson has had a significant impact on the film industry.'),
    ('Peter Jackson', 'Pukerua Bay', 'New Zealander', 'Peter Jackson is a New Zealand filmmaker born in Pukerua Bay, New Zealand. He gained international fame for directing "The Lord of the Rings" trilogy, winning multiple Academy Awards.'),
    ('Albert S. Ruddy', 'New York City', 'American', 'Albert S. Ruddy is an American film producer born in New York City. He is best known for producing the iconic film "The Godfather," which received critical acclaim and won multiple Academy Awards.'),
    ('Steven Spielberg', 'Cincinnati', 'American', 'Steven Spielberg is an American filmmaker born in Cincinnati, Ohio. A pioneer in the film industry, Spielberg has directed numerous blockbuster films, including "Jurassic Park" and "E.T. the Extra-Terrestrial."');


--------------------------------------------------------------------

INSERT INTO PRODUCTION_COMPANY (NAME, LOCATION, BIOGRAPHY)
VALUES
    ('Castle Rock Entertainment', 'Burbank', 'Castle Rock Entertainment is a film and television production company headquartered in Burbank. Founded by Martin Shafer and Rob Reiner, the company has been involved in the production of numerous successful films and TV shows.'),
    ('Warner Bros. Pictures', 'Burbank', 'Warner Bros. Pictures is a major film studio based in Burbank. Founded in 1923, it has been a leading player in the entertainment industry, producing iconic films such as "The Dark Knight" and "Harry Potter" series.'),
    ('Paramount Pictures', 'Hollywood', 'Paramount Pictures, headquartered in Hollywood, is one of the oldest film studios in the world. Established in 1912, Paramount has played a significant role in shaping the history of cinema with classics like "The Godfather" and "Titanic."'),
    ('20th Century Fox', 'Los Angeles', '20th Century Fox, based in Los Angeles, was one of the major film studios before being acquired by The Walt Disney Company. The studio produced classics like "Star Wars" and "The Sound of Music."'),
    ('New Line Cinema', 'Burbank', 'New Line Cinema is a film studio headquartered in Burbank. Known for producing the "Nightmare on Elm Street" series and "The Lord of the Rings" trilogy, New Line Cinema has left a lasting impact on the horror and fantasy genres.'),
    ('Universal Pictures', 'Universal City', 'Universal Pictures, based in Universal City, is one of the major film studios globally. Established in 1912, Universal has been involved in the production of iconic films like "Jurassic Park" and "E.T. the Extra-Terrestrial."');


--------------------------------------------------------------------

INSERT INTO ACTOR (NAME, HOMETOWN, NATIONALITY, BIOGRAPHY)
VALUES
    ('Tim Robbins', 'West Covina', 'American', 'Tim Robbins, born in West Covina, California, is an American actor and director. He gained acclaim for his roles in films such as ''The Shawshank Redemption'' and ''Mystic River''.'),
    ('Morgan Freeman', 'Memphis', 'American', 'Morgan Freeman, hailing from Memphis, Tennessee, is an iconic American actor and film narrator. Known for his distinguished voice, Freeman''s notable works include ''The Shawshank Redemption'' and ''Million Dollar Baby''.'),
    ('Christian Bale', 'Haverfordwest', 'British', 'Christian Bale, born in Haverfordwest, Wales, is a British actor known for his versatile roles. He gained fame for portraying Batman in Christopher Nolan''s trilogy and received acclaim for ''The Fighter''.'),
    ('Heath Ledger', 'Perth', 'Australian', 'Heath Ledger, born in Perth, Australia, was an acclaimed Australian actor. Ledger''s memorable performances include ''Brokeback Mountain'' and his posthumous Oscar-winning role as the Joker in ''The Dark Knight''.'),
    ('Leonardo DiCaprio', 'Los Angeles', 'American', 'Leonardo DiCaprio, born in Los Angeles, California, is an American actor and environmental activist. DiCaprio''s career includes roles in films like ''Titanic,'' ''Inception,'' and ''The Revenant''.'),
    ('Joseph Gordon-Levitt', 'Los Angeles', 'American', 'Joseph Gordon-Levitt, born in Los Angeles, California, is an American actor known for his diverse roles. He has appeared in films like ''Inception,'' ''500 Days of Summer,'' and ''The Dark Knight Rises''.'),
    ('Tom Hanks', 'Concord', 'American', 'Tom Hanks, born in Concord, California, is an American actor and filmmaker. Hanks has received numerous awards for his roles in films such as ''Forrest Gump,'' ''Philadelphia,'' and ''Cast Away''.'),
    ('Robin Wright', 'Dallas', 'American', 'Robin Wright, born in Dallas, Texas, is an American actress and director. She is known for her roles in ''The Princess Bride,'' ''Forrest Gump,'' and the TV series ''House of Cards''.'),
    ('Edward Norton', 'Boston', 'American', 'Edward Norton, born in Boston, Massachusetts, is an American actor and filmmaker. Norton is acclaimed for his performances in ''American History X,'' ''Fight Club,'' and ''Birdman''.'),
    ('Brad Pitt', 'Shawnee', 'American', 'Brad Pitt, born in Shawnee, Oklahoma, is an American actor and film producer. He gained fame for roles in films like ''Thelma & Louise,'' ''Fight Club,'' and ''Once Upon a Time in Hollywood''.'),
    ('Elijah Wood', 'Cedar Rapids', 'American', 'Elijah Wood, born in Cedar Rapids, Iowa, is an American actor and producer. He is best known for his role as Frodo Baggins in ''The Lord of the Rings'' trilogy.'),
    ('Ian McKellen', 'Burnley', 'British', 'Sir Ian McKellen, born in Burnley, England, is a British actor known for his distinguished career in film and theater. He is famous for portraying Gandalf in ''The Lord of the Rings'' and Magneto in ''X-Men''.'),
    ('Marlon Brando', 'Omaha', 'American', 'Marlon Brando, born in Omaha, Nebraska, was an influential American actor. Regarded as one of the greatest actors of all time, Brando''s notable films include ''The Godfather'' and ''On the Waterfront''.'),
    ('Al Pacino', 'New York City', 'American', 'Al Pacino, born in New York City, is an iconic American actor and filmmaker. He is known for his roles in classics such as ''The Godfather,'' ''Scarface,'' and ''Scent of a Woman''.'),
    ('Liam Neeson', 'Ballymena', 'Irish', 'Liam Neeson, born in Ballymena, Northern Ireland, is an Irish actor known for his powerful performances. He gained fame for roles in ''Schindler''s List,'' ''Taken,'' and ''The Dark Knight Rises''.'),
    ('Ben Kingsley', 'Snainton', 'British', 'Sir Ben Kingsley, born in Snainton, England, is a British actor with a distinguished career. He won an Academy Award for his role in ''Gandhi'' and has appeared in films like ''Schindler''s List'' and ''Iron Man 3''.'),
    ('Michael J. Fox', 'Edmonton', 'Canadian', 'Michael J. Fox, born in Edmonton, Alberta, Canada, is a Canadian-American actor and author. He is known for his roles in ''Back to the Future'' and the TV series ''Family Ties''.'),
    ('Christopher Lloyd', 'Stamford', 'American', 'Christopher Lloyd, born in Stamford, Connecticut, is an American actor known for his versatile roles. He is iconic for portraying Doc Brown in ''Back to the Future'' and Uncle Fester in ''The Addams Family''.');

--------------------------------------------------------------------
INSERT INTO MOVIE_ACTORS (ACTORS_ID, MOVIES_ID) SELECT actor.id, movie.id FROM actor, movie WHERE actor.name IN ('Tim Robbins', 'Morgan Freeman') AND movie.title = 'The Shawshank Redemption';
INSERT INTO MOVIE_ACTORS (ACTORS_ID, MOVIES_ID) SELECT actor.id, movie.id FROM actor, movie WHERE actor.name IN ('Christian Bale', 'Heath Ledger')   AND movie.title = 'The Dark Knight';
INSERT INTO MOVIE_ACTORS (ACTORS_ID, MOVIES_ID) SELECT actor.id, movie.id FROM actor, movie WHERE actor.name IN ('Leonardo DiCaprio', 'Joseph Gordon-Levitt') AND movie.title = 'Inception';
INSERT INTO MOVIE_ACTORS (ACTORS_ID, MOVIES_ID) SELECT actor.id, movie.id FROM actor, movie WHERE actor.name IN ('Tom Hanks', 'Robin Wright') AND movie.title = 'Forrest Gump';
INSERT INTO MOVIE_ACTORS (ACTORS_ID, MOVIES_ID) SELECT actor.id, movie.id FROM actor, movie WHERE actor.name IN ('Edward Norton', 'Brad Pitt') AND movie.title = 'Fight Club';
INSERT INTO MOVIE_ACTORS (ACTORS_ID, MOVIES_ID) SELECT actor.id, movie.id FROM actor, movie WHERE actor.name IN ('Elijah Wood', 'Ian McKellen') AND movie.title = 'The Lord of the Rings - The Two Towers';
INSERT INTO MOVIE_ACTORS (ACTORS_ID, MOVIES_ID) SELECT actor.id, movie.id FROM actor, movie WHERE actor.name IN ('Marlon Brando', 'Al Pacino') AND movie.title = 'The Godfather';
INSERT INTO MOVIE_ACTORS (ACTORS_ID, MOVIES_ID) SELECT actor.id, movie.id FROM actor, movie WHERE actor.name IN ('Elijah Wood', 'Ian McKellen') AND movie.title = 'The Lord of the Rings - The Fellowship of the Ring';
INSERT INTO MOVIE_ACTORS (ACTORS_ID, MOVIES_ID) SELECT actor.id, movie.id FROM actor, movie WHERE actor.name IN ('Liam Neeson', 'Ben Kingsley') AND movie.title = 'Schindler''s List';
INSERT INTO MOVIE_ACTORS (ACTORS_ID, MOVIES_ID) SELECT actor.id, movie.id FROM actor, movie WHERE actor.name IN ('Michael J. Fox', 'Christopher Lloyd') AND movie.title = 'Back to the Future';

--------------------------------------------------------------------

INSERT INTO MOVIE_PRODUCTION_COMPANIES (MOVIES_ID, PRODUCTION_COMPANIES_ID) VALUES (select id from movie where title = 'The Shawshank Redemption', select id from production_company where name =  'Castle Rock Entertainment');
INSERT INTO MOVIE_PRODUCTION_COMPANIES (MOVIES_ID, PRODUCTION_COMPANIES_ID) VALUES (select id from movie where title = 'The Dark Knight', select id from production_company where name = 'Warner Bros. Pictures');
INSERT INTO MOVIE_PRODUCTION_COMPANIES (MOVIES_ID, PRODUCTION_COMPANIES_ID) VALUES (select id from movie where title = 'Inception', select id from production_company where name =  'Warner Bros. Pictures');
INSERT INTO MOVIE_PRODUCTION_COMPANIES (MOVIES_ID, PRODUCTION_COMPANIES_ID) VALUES (select id from movie where title = 'Forrest Gump', select id from production_company where name =  'Paramount Pictures');
INSERT INTO MOVIE_PRODUCTION_COMPANIES (MOVIES_ID, PRODUCTION_COMPANIES_ID) VALUES (select id from movie where title = 'Fight Club', select id from production_company where name =  '20th Century Fox');
INSERT INTO MOVIE_PRODUCTION_COMPANIES (MOVIES_ID, PRODUCTION_COMPANIES_ID) VALUES (select id from movie where title = 'The Lord of the Rings - The Two Towers', select id from production_company where name =  'New Line Cinema');
INSERT INTO MOVIE_PRODUCTION_COMPANIES (MOVIES_ID, PRODUCTION_COMPANIES_ID) VALUES (select id from movie where title = 'The Godfather', select id from production_company where name =  'Paramount Pictures');
INSERT INTO MOVIE_PRODUCTION_COMPANIES (MOVIES_ID, PRODUCTION_COMPANIES_ID) VALUES (select id from movie where title = 'The Lord of the Rings - The Fellowship of the Ring', select id from production_company where name =  'New Line Cinema');
INSERT INTO MOVIE_PRODUCTION_COMPANIES (MOVIES_ID, PRODUCTION_COMPANIES_ID) VALUES (select id from movie where title = 'Schindler''s List', select id from production_company where name =  'Universal Pictures');
INSERT INTO MOVIE_PRODUCTION_COMPANIES (MOVIES_ID, PRODUCTION_COMPANIES_ID) VALUES (select id from movie where title = 'Back to the Future', select id from production_company where name =  'Universal Pictures');

--------------------------------------------------------------------

INSERT INTO MOVIE_PRODUCERS (MOVIES_ID, PRODUCERS_ID) VALUES (select id from movie where title = 'The Shawshank Redemption', select id from producer where name = 'Frank Darabont');
INSERT INTO MOVIE_PRODUCERS (MOVIES_ID, PRODUCERS_ID) VALUES (select id from movie where title = 'The Dark Knight', select id from producer where name = 'Christopher Nolan');
INSERT INTO MOVIE_PRODUCERS (MOVIES_ID, PRODUCERS_ID) VALUES (select id from movie where title = 'Inception', select id from producer where name = 'Christopher Nolan');
INSERT INTO MOVIE_PRODUCERS (MOVIES_ID, PRODUCERS_ID) VALUES (select id from movie where title = 'Forrest Gump', select id from producer where name = 'Wendy Finerman');
INSERT INTO MOVIE_PRODUCERS (MOVIES_ID, PRODUCERS_ID) VALUES (select id from movie where title = 'Fight Club', select id from producer where name = 'Art Linson');
INSERT INTO MOVIE_PRODUCERS (MOVIES_ID, PRODUCERS_ID) VALUES (select id from movie where title = 'The Lord of the Rings - The Two Towers', select id from producer where name = 'Peter Jackson');
INSERT INTO MOVIE_PRODUCERS (MOVIES_ID, PRODUCERS_ID) VALUES (select id from movie where title = 'The Godfather', select id from producer where name = 'Albert S. Ruddy');
INSERT INTO MOVIE_PRODUCERS (MOVIES_ID, PRODUCERS_ID) VALUES (select id from movie where title = 'The Lord of the Rings - The Fellowship of the Ring', select id from producer where name = 'Peter Jackson');
INSERT INTO MOVIE_PRODUCERS (MOVIES_ID, PRODUCERS_ID) VALUES (select id from movie where title = 'Schindler''s List', select id from producer where name = 'Steven Spielberg');
INSERT INTO MOVIE_PRODUCERS (MOVIES_ID, PRODUCERS_ID) VALUES (select id from movie where title = 'Back to the Future', select id from producer where name = 'Steven Spielberg');

--------------------------------------------------------------------

INSERT INTO BOOK (TITLE, YEAR_OF_RELEASE, DESCRIPTION, IMAGE_URL)
VALUES
    ('To Kill a Mockingbird', 1960, 'Harper Lee’s classic novel explores racial injustice and moral growth in the American South during the 1930s.', 'https://firebasestorage.googleapis.com/v0/b/medialibrary-407109.appspot.com/o/To%20Kill%20a%20Mockingbird.jpg?alt=media&token=e2391510-8fd1-42ac-b664-785d1cde2852'),
    ('1984', 1949, 'George Orwell''s dystopian novel depicts a totalitarian future society marked by government surveillance and thought control.', 'https://firebasestorage.googleapis.com/v0/b/medialibrary-407109.appspot.com/o/1984.jpg?alt=media&token=baa6666d-f5b2-4a61-98bd-772d0259b7a8'),
    ('The Great Gatsby', 1925, 'F. Scott Fitzgerald''s masterpiece explores themes of wealth, love, and the American Dream during the Roaring Twenties.', 'https://firebasestorage.googleapis.com/v0/b/medialibrary-407109.appspot.com/o/The%20Great%20Gatsby.jpg?alt=media&token=b55c03ac-a182-4ccf-b743-64373904338f'),
    ('Pride and Prejudice', 1813, 'Jane Austen''s timeless novel revolves around the themes of love, class, and societal expectations in early 19th-century England.', 'https://firebasestorage.googleapis.com/v0/b/medialibrary-407109.appspot.com/o/Pride%20and%20Prejudice.jpg?alt=media&token=efbeaa91-6bd3-447a-af42-e7e631b8b15d'),
    ('The Catcher in the Rye', 1951, 'J.D. Salinger''s coming-of-age novel follows the adventures of Holden Caulfield, a disenchanted teenager navigating the challenges of adulthood.', 'https://firebasestorage.googleapis.com/v0/b/medialibrary-407109.appspot.com/o/The%20Catcher%20in%20the%20Rye.jpg?alt=media&token=f016fd6f-1d71-4571-b7e4-4988be03eb70'),
    ('The Hobbit', 1937, 'J.R.R. Tolkien''s fantasy novel takes readers on a journey with Bilbo Baggins as he joins a quest to reclaim treasure guarded by the dragon Smaug.', 'https://firebasestorage.googleapis.com/v0/b/medialibrary-407109.appspot.com/o/The%20Hobbit.jpg?alt=media&token=b63c8335-5960-4d29-a5d1-9708f047695c'),
    ('One Hundred Years of Solitude', 1967, 'Gabriel García Márquez''s magical realist novel chronicles the Buendía family''s history in the fictional town of Macondo.', 'https://firebasestorage.googleapis.com/v0/b/medialibrary-407109.appspot.com/o/One%20Hundred%20Years%20of%20Solitude.jpg?alt=media&token=58a34a0a-ad84-4a3a-95b5-d6562f7eab18'),
    ('Brave New World', 1932, 'Aldous Huxley''s dystopian novel explores a future society where conformity and consumerism reign supreme.', 'https://firebasestorage.googleapis.com/v0/b/medialibrary-407109.appspot.com/o/Brave%20New%20World.jpg?alt=media&token=89da4387-a1c7-43bb-a79f-c8de26bff4e7'),
    ('To the Lighthouse', 1927, 'Virginia Woolf''s modernist novel delves into the complexities of human relationships and the passage of time.', 'https://firebasestorage.googleapis.com/v0/b/medialibrary-407109.appspot.com/o/To%20the%20Lighthouse.jpg?alt=media&token=81563634-5dc8-486b-9ea1-0990f4680413'),
    ('The Lord of the Rings', 1954, 'J.R.R. Tolkien''s epic fantasy trilogy follows the quest to destroy the One Ring and save Middle-earth from the dark forces of Sauron.',  'https://firebasestorage.googleapis.com/v0/b/medialibrary-407109.appspot.com/o/The%20Lord%20of%20the%20Rings.jpg?alt=media&token=536db0ff-4c18-4cdf-bac3-1b0a08d1f8fa');


--------------------------------------------------------------------

INSERT INTO AUTHOR (NAME, HOMETOWN, NATIONALITY, BIOGRAPHY)
VALUES
    ('Harper Lee', 'Monroeville', 'American', 'Harper Lee (1926-2016) was an American author, famous for "To Kill a Mockingbird." Born in Monroeville, Alabama, Lee addressed racial injustice and moral growth.'),
    ('George Orwell', 'Motihari', 'English', 'George Orwell (1903-1950) was a British writer known for "1984" and "Animal Farm," critiquing totalitarianism. Born in Motihari, British India.'),
    ('F. Scott Fitzgerald', 'St. Paul', 'American', 'F. Scott Fitzgerald (1896-1940) was an iconic American novelist linked with the Jazz Age. Born in St. Paul, Minnesota, "The Great Gatsby" explores the American Dream.'),
    ('Jane Austen', 'Steventon', 'English', 'Jane Austen (1775-1817) was an English novelist known for romantic fiction like "Pride and Prejudice." Born in Steventon, Hampshire, her works are celebrated for wit and social commentary.'),
    ('J.D. Salinger', 'New York City', 'American', 'J.D. Salinger (1919-2010) wrote "The Catcher in the Rye." Born in NYC, his work explores struggles of adolescence and alienation.'),
    ('J.R.R. Tolkien', 'Bloemfontein', 'British', 'J.R.R. Tolkien (1892-1973) was a British author known for fantasy works like "The Hobbit" and "The Lord of the Rings." Born in Bloemfontein, South Africa.'),
    ('Gabriel García Márquez', 'Aracataca', 'Colombian', 'Gabriel García Márquez (1927-2014) was a Colombian Nobel laureate known for magical realism in works like "One Hundred Years of Solitude." Born in Aracataca, Colombia.'),
    ('Aldous Huxley', 'Godalming', 'English', 'Aldous Huxley (1894-1963) was an English writer known for "Brave New World." Born in Godalming, Surrey, his work explores technology and totalitarianism.'),
    ('Virginia Woolf', 'London', 'English', 'Virginia Woolf (1882-1941) was an influential English modernist writer. Born in London, known for "Mrs. Dalloway" and "Orlando."');

--------------------------------------------------------------------

INSERT INTO BOOK_AUTHORS (BOOKS_ID, AUTHORS_ID) VALUES (select id from book where title = 'To Kill a Mockingbird', select id from author where name = 'Harper Lee');
INSERT INTO BOOK_AUTHORS (BOOKS_ID, AUTHORS_ID) VALUES (select id from book where title = '1984', select id from author where name = 'George Orwell');
INSERT INTO BOOK_AUTHORS (BOOKS_ID, AUTHORS_ID) VALUES (select id from book where title = 'The Great Gatsby', select id from author where name = 'F. Scott Fitzgerald');
INSERT INTO BOOK_AUTHORS (BOOKS_ID, AUTHORS_ID) VALUES (select id from book where title = 'Pride and Prejudice', select id from author where name = 'Jane Austen');
INSERT INTO BOOK_AUTHORS (BOOKS_ID, AUTHORS_ID) VALUES (select id from book where title = 'The Catcher in the Rye', select id from author where name = 'J.D. Salinger');
INSERT INTO BOOK_AUTHORS (BOOKS_ID, AUTHORS_ID) VALUES (select id from book where title = 'The Hobbit', select id from author where name = 'J.R.R. Tolkien');
INSERT INTO BOOK_AUTHORS (BOOKS_ID, AUTHORS_ID) VALUES (select id from book where title = 'One Hundred Years of Solitude', select id from author where name = 'Gabriel García Márquez');
INSERT INTO BOOK_AUTHORS (BOOKS_ID, AUTHORS_ID) VALUES (select id from book where title = 'Brave New World', select id from author where name = 'Aldous Huxley');
INSERT INTO BOOK_AUTHORS (BOOKS_ID, AUTHORS_ID) VALUES (select id from book where title = 'To the Lighthouse', select id from author where name = 'Virginia Woolf');
INSERT INTO BOOK_AUTHORS (BOOKS_ID, AUTHORS_ID) VALUES (select id from book where title = 'The Lord of the Rings', select id from author where name = 'J.R.R. Tolkien');

--------------------------------------------------------------------

INSERT INTO END_USER (NAME, USERNAME) VALUES ('admin','admin');
INSERT INTO END_USER (NAME, USERNAME) VALUES ('user','user');

--------------------------------------------------------------------

INSERT INTO USERS (USERNAME, PASSWORD, ENABLED)
VALUES ('admin', '$2a$10$9MIX8kYPkuB7uE/H5nHF8.KG6.YdjBA/voOnjSZnZDxLXL/2BIerS', true);
INSERT INTO AUTHORITIES (USERNAME, AUTHORITY) VALUES ('admin', 'ADMIN');
INSERT INTO USERS (USERNAME, PASSWORD, ENABLED)
VALUES ('user', '$2a$10$9TeBFudS7HsgCa4sSvP//O627sMq.KiTFrOr8IzrVlYw5c8aoKzNm', true);
INSERT INTO AUTHORITIES (USERNAME, AUTHORITY) VALUES ('user', 'USER');

--------------------------------------------------------------------

INSERT INTO END_USER_WISHLIST_MOVIES (END_USERS_WISHLIST_ID, WISHLIST_MOVIES_ID)
VALUES (select id from END_USER where username = 'admin', select id from movie where title = 'The Shawshank Redemption');
INSERT INTO END_USER_WISHLIST_BOOKS (END_USERS_WISHLIST_ID, WISHLIST_BOOKS_ID)
VALUES (select id from END_USER where username = 'admin', select id from book where title = 'The Hobbit');
INSERT INTO END_USER_WISHLIST_MOVIES (END_USERS_WISHLIST_ID, WISHLIST_MOVIES_ID)
VALUES (select id from END_USER where username = 'user', select id from movie where title = 'The Lord of the Rings - The Two Towers');
INSERT INTO END_USER_WISHLIST_BOOKS (END_USERS_WISHLIST_ID, WISHLIST_BOOKS_ID)
VALUES (select id from END_USER where username = 'user', select id from book where title = 'The Lord of the Rings');

--------------------------------------------------------------------

--genres for movies
INSERT INTO GENRE (NAME, GENRE_FOR)
VALUES
    ('Action', 'movie'),
    ('Drama', 'movie'),
    ('Sci-Fi', 'movie'),
    ('Fantasy', 'movie'),
    ('Thriller', 'movie'),
    ('Romance', 'movie'),
    ('Comedy', 'movie'),
    ('Adventure', 'movie'),
    ('Biography', 'movie'),
    ('History', 'movie'),
    ('Crime', 'movie');
--genres for books
INSERT INTO GENRE (NAME, GENRE_FOR)
VALUES
    ('Fiction', 'book'),
    ('Dystopian', 'book'),
    ('Political Fiction', 'book'),
    ('Science Fiction', 'book'),
    ('Biography', 'book'),
    ('Coming-of-Age', 'book'),
    ('Classic', 'book'),
    ('Literary Fiction', 'book'),
    ('Romance', 'book'),
    ('Bildungsroman', 'book'),
    ('Children''s Literature', 'book'),
    ('Magical Realism', 'book'),
    ('Latin American Literature', 'book'),
    ('Epic Fantasy', 'book'),
    ('Adventure', 'book'),
    ('Modernist Literature', 'book'),
    ('Historical Fiction', 'book');

--------------------------------------------------------------------

INSERT INTO MOVIE_GENRES (GENRES_ID, MOVIES_ID) SELECT genre.id, movie.id FROM genre, movie WHERE genre.name IN ('Drama', 'Crime') AND genre.genre_for = 'movie' AND movie.title = 'The Shawshank Redemption';
INSERT INTO MOVIE_GENRES (GENRES_ID, MOVIES_ID) SELECT genre.id, movie.id FROM genre, movie WHERE genre.name IN ('Action', 'Drama', 'Crime') AND genre.genre_for = 'movie' AND movie.title = 'The Dark Knight';
INSERT INTO MOVIE_GENRES (GENRES_ID, MOVIES_ID) SELECT genre.id, movie.id FROM genre, movie WHERE genre.name IN ('Sci-Fi', 'Action', 'Thriller') AND genre.genre_for = 'movie' AND movie.title = 'Inception';
INSERT INTO MOVIE_GENRES (GENRES_ID, MOVIES_ID) SELECT genre.id, movie.id FROM genre, movie WHERE genre.name IN ('Drama', 'Romance', 'Comedy') AND genre.genre_for = 'movie' AND movie.title = 'Forrest Gump';
INSERT INTO MOVIE_GENRES (GENRES_ID, MOVIES_ID) SELECT genre.id, movie.id FROM genre, movie WHERE genre.name IN ('Drama', 'Thriller', 'Crime') AND genre.genre_for = 'movie' AND movie.title = 'Fight Club';
INSERT INTO MOVIE_GENRES (GENRES_ID, MOVIES_ID) SELECT genre.id, movie.id FROM genre, movie WHERE genre.name IN ('Fantasy', 'Adventure', 'Action') AND genre.genre_for = 'movie' AND movie.title = 'The Lord of the Rings - The Two Towers';
INSERT INTO MOVIE_GENRES (GENRES_ID, MOVIES_ID) SELECT genre.id, movie.id FROM genre, movie WHERE genre.name IN ('Drama', 'Crime') AND genre.genre_for = 'movie' AND movie.title = 'The Godfather';
INSERT INTO MOVIE_GENRES (GENRES_ID, MOVIES_ID) SELECT genre.id, movie.id FROM genre, movie WHERE genre.name IN ('Fantasy', 'Adventure', 'Action') AND genre.genre_for = 'movie' AND movie.title = 'The Lord of the Rings - The Fellowship of the Ring';
INSERT INTO MOVIE_GENRES (GENRES_ID, MOVIES_ID) SELECT genre.id, movie.id FROM genre, movie WHERE genre.name IN ('Biography', 'Drama', 'History') AND genre.genre_for = 'movie' AND movie.title = 'Schindler''s List';
INSERT INTO MOVIE_GENRES (GENRES_ID, MOVIES_ID) SELECT genre.id, movie.id FROM genre, movie WHERE genre.name IN ('Adventure', 'Comedy', 'Sci-Fi') AND genre.genre_for = 'movie' AND movie.title = 'Back to the Future';

--------------------------------------------------------------------

INSERT INTO BOOK_GENRES (GENRES_ID, BOOKS_ID) SELECT genre.id, book.id FROM genre, book WHERE genre.name IN ('Fiction', 'Historical Fiction', 'Coming-of-Age') AND genre.genre_for = 'book' AND book.title = 'To Kill a Mockingbird';
INSERT INTO BOOK_GENRES (GENRES_ID, BOOKS_ID) SELECT genre.id, book.id FROM genre, book WHERE genre.name IN ('Fiction', 'Dystopian', 'Political Fiction') AND genre.genre_for = 'book' AND book.title = '1984';
INSERT INTO BOOK_GENRES (GENRES_ID, BOOKS_ID) SELECT genre.id, book.id FROM genre, book WHERE genre.name IN ('Fiction', 'Classic', 'Literary Fiction') AND genre.genre_for = 'book' AND book.title = 'The Great Gatsby';
INSERT INTO BOOK_GENRES (GENRES_ID, BOOKS_ID) SELECT genre.id, book.id FROM genre, book WHERE genre.name IN ('Fiction', 'Classic', 'Romance') AND genre.genre_for = 'book' AND book.title = 'Pride and Prejudice';
INSERT INTO BOOK_GENRES (GENRES_ID, BOOKS_ID) SELECT genre.id, book.id FROM genre, book WHERE genre.name IN ('Fiction', 'Coming-of-Age', 'Bildungsroman') AND genre.genre_for = 'book' AND book.title = 'The Catcher in the Rye';
INSERT INTO BOOK_GENRES (GENRES_ID, BOOKS_ID) SELECT genre.id, book.id FROM genre, book WHERE genre.name IN ('Fantasy', 'Adventure', 'Children''s Literature') AND genre.genre_for = 'book' AND book.title = 'The Hobbit';
INSERT INTO BOOK_GENRES (GENRES_ID, BOOKS_ID) SELECT genre.id, book.id FROM genre, book WHERE genre.name IN ('Magical Realism', 'Fiction', 'Latin American Literature') AND genre.genre_for = 'book' AND book.title = 'One Hundred Years of Solitude';
INSERT INTO BOOK_GENRES (GENRES_ID, BOOKS_ID) SELECT genre.id, book.id FROM genre, book WHERE genre.name IN ('Fiction', 'Dystopian', 'Science Fiction') AND genre.genre_for = 'book' AND book.title = 'Brave New World';
INSERT INTO BOOK_GENRES (GENRES_ID, BOOKS_ID) SELECT genre.id, book.id FROM genre, book WHERE genre.name IN ('Fiction', 'Modernist Literature') AND genre.genre_for = 'book' AND book.title = 'To the Lighthouse';
INSERT INTO BOOK_GENRES (GENRES_ID, BOOKS_ID) SELECT genre.id, book.id FROM genre, book WHERE genre.name IN ('Fantasy', 'Epic Fantasy', 'Adventure') AND genre.genre_for = 'book' AND book.title = 'The Lord of the Rings';