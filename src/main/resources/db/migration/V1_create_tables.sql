create table if not exists persons (
name varchar(100),
surname varchar(100),
age int,
phone_number varchar(20),
city_of_living varchar(100),
primary key ( name, surname, age)
);