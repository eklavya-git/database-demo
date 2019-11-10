/*This SQL file is executed once the Spring Framework is up*/

/*Create Table need to be executed if using JDBC. This isn't required if JPA is being used.*/
/*create table person
(
    id integer not null,
    name varchar(255) not null,
    location  varchar(255),
    birth_date timestamp,
    primary key (id)
);*/

/*
Select * from PERSON
delete from person
*/

INSERT INTO PERSON
    (ID, NAME, LOCATION, BIRTH_DATE)
VALUES
    (100001, 'ANSHUL', 'Bengaluru', '19870924'),
    (100002, 'Mishra Ji', 'Bengaluru', '19890123'),
    (100003, 'Rachit Bhai', 'UK', '19881229')

    /*INSERT INTO PERSON
        (ID, NAME, LOCATION, BIRTH_DATE)
    VALUES
        (100001, 'ANSHUL', 'Bengaluru', '19870924')*/