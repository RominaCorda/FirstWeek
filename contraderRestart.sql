drop database if exists contraderRestart;
create database if not exists contraderRestart;



create table contraderRestart.users (
idUser int (50) not null auto_increment,
username varchar(50),
password varchar(50),
role varchar(10),
PRIMARY KEY (idUser)
);


insert into contraderRestart.users (idUser,username,password,role) values (1,'pippo', 'paperino','admin'),
																		                                      (2,'ciccio', 'bello','local'),
                                                                          (3,'user', 'user','local'),
                                                                          (4,'admin','admin','admin');

create table contraderRestart.gomme (
idGomma int (50) not null auto_increment,
model varchar (50),
manufacturer varchar(50),
price float,
width float,
height float,
diameter float,
weight float,
speed varchar(3),
season varchar(50),
typeVehicle varchar(50),
quantity varchar(10),
PRIMARY KEY (idGomma));

insert into contraderRestart.gomme (idGomma,model, manufacturer, price, width, height, diameter, weight, speed, season, typeVehicle, quantity) values (1,'Trelleborg-B50', 'Trelleborg', 321.13,20,20,20,20,'M','Invernali','moto',20);
insert into contraderRestart.gomme (idGomma,model, manufacturer, price, width, height, diameter, weight, speed, season, typeVehicle, quantity) values (2,'SuperG-876 ', 'Super Gomme', 213.176,30,30,30,30,'M','Estivi','auto',30);
insert into contraderRestart.gomme (idGomma,model, manufacturer, price, width, height, diameter, weight, speed, season, typeVehicle, quantity) values (3,'Bridgestone R\150WT ', 'Bridgestone', 313.176,50,50,50,50,'W','Quattro Stagioni','commerciale',40);
insert into contraderRestart.gomme(idGomma,model,manufacturer,price, width, height, diameter, weight, speed, season, typeVehicle, quantity) values(4,'Michelin Alpin 5','Michelin',74.50, 60,60,60,60,'W','Invernali','commerciale',50);

create table contraderRestart.vehicle(
idVehicle int(50) not null auto_increment,
brand varchar(20),
model varchar(30),
power varchar(10),
primary key (idVehicle));
insert into contraderRestart.vehicle(idVehicle,brand,model,power) values(1,'Fiat','Punto','Benzina');
insert into contraderRestart.vehicle(idVehicle,brand,model,power) values(2,'Lancia','Delta','Benzina');
insert into contraderRestart.vehicle(idVehicle,brand,model,power) values(3,'Honda','RX50','Benzina');
create table contraderRestart.compatibility(
idVehicle int (50),
idGomma int (50),
foreign key (idVehicle) references contraderRestart.vehicle(idVehicle),
foreign key (idGomma) references contraderRestart.gomme (idGomma));

insert into contraderRestart.compatibility(idVehicle,idGomma) values (1,1),(1,2),(2,3),(2,4),(3,1),(3,4);



