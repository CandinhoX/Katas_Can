CREATE DATABASE globers_kata;
use globers_kata;

create table seniorities(
            id_seniority int auto_increment primary key,
            seniority_description varchar(255) NOT NULL,
            constraint unq_seniority unique (seniority_description)
);

INSERT INTO seniorities values (1,'Sr');
INSERT INTO seniorities values (2,'Jr Adv');
INSERT INTO seniorities values (3,'Software Designer');
INSERT INTO seniorities values (4,'Jr');
INSERT INTO seniorities values (5,'SSr');
INSERT INTO seniorities values (6,'Level 5');
INSERT INTO seniorities values (7,'Architect');
INSERT INTO seniorities values (8,'SSr Adv');
INSERT INTO seniorities values (9,'C-Level');
INSERT INTO seniorities values (10,'Level 4');


create table positions(
            id_position int auto_increment primary key,
            position_name varchar(255) NOT NULL,
            constraint unq_position unique (position_name)
);

INSERT INTO positions values (1,'Java Developer');
INSERT INTO positions values (2,'WebUI Developer');
INSERT INTO positions values (3,'Project Manager');
INSERT INTO positions values (4,'Marketing Automation');
INSERT INTO positions values (5,'QC Analyst');
INSERT INTO positions values (6,'Tech Director');
INSERT INTO positions values (7,'Data Engineer');
INSERT INTO positions values (8,'Founder');
INSERT INTO positions values (9,'Tech Manager');
INSERT INTO positions values (10,'Quality Automation ');
INSERT INTO positions values (11,'NodeJS Developer');
INSERT INTO positions values (12,'Python Developer');
INSERT INTO positions values (13,'Delivery Manager');

create table studios(
            id_studio int auto_increment primary key,
            studio_name varchar(255) NOT NULL,
            constraint unq_studio unique (studio_name)
);

INSERT INTO studios values (1,'Engineering');
INSERT INTO studios values (2,'Agile Delivery');
INSERT INTO studios values (3,'Marketing ');
INSERT INTO studios values (4,'Quality Engineering');
INSERT INTO studios values (5,'Data');
INSERT INTO studios values (6,'Staff');


create table countries(
            id_country int auto_increment primary key,
            country_name varchar(255) NOT NULL,
            constraint unq_studio unique (country_name)
);

INSERT INTO countries values (1,'AR');
INSERT INTO countries values (2,'PT');
INSERT INTO countries values (3,'BR');
INSERT INTO countries values (4,'FR');
INSERT INTO countries values (5,'PE');
INSERT INTO countries values (6,'CO');
INSERT INTO countries values (7,'MX');
INSERT INTO countries values (8,'SP');


create table cities(
    id_city int auto_increment primary key,
    city_name varchar(255) not null,
    id_country int not null,
    constraint unq_city unique (city_name, id_country),
    constraint fk_cities_countries foreign key (id_country) references countries(id_country)
);

insert into cities values (1,'Buenos Aires',1);
insert into cities values (2,'Mar del Plata',1);
insert into cities values (3,'Lisbon',2);
insert into cities values (4,'Rosario',1);
insert into cities values (5,'Sao Paulo',3);
insert into cities values (6,'Paris',4);
insert into cities values (7,'Lima',5);
insert into cities values (8,'Cordoba',1);
insert into cities values (9,'Resistencia',1);
insert into cities values (10,'Jujuy',1);
insert into cities values (11,'Bogota',6);
insert into cities values (12,'Cali',6);
insert into cities values (13,'Medellin',6);
insert into cities values (14,'Barranquilla',6);
insert into cities values (15,'Mexico DF',7);
insert into cities values (16,'Guadalajara',7);
insert into cities values (17,'Valencia',8);
insert into cities values (18,'Barcelona',8);
insert into cities values (19,'Madrid',8);

drop table globers;
CREATE TABLE globers(
    id_glober int auto_increment primary key,
    glober_email varchar(255) not null,
    glober_name varchar(255) not null,
    id_city int not null,
    id_studio int not null,
    id_position int not null,
    id_seniority int not null,
    salary int,
    constraint unq_glober unique (glober_email),
    constraint fk_globers_cities foreign key (id_city) references cities(id_city),
    constraint fk_globers_studios foreign key (id_studio) references studios(id_studio),
    constraint fk_globers_positions foreign key (id_position) references positions(id_position),
    constraint fk_globers_seniorities foreign key (id_seniority) references seniorities(id_seniority)
);

insert into globers values (1,'pedro.perez@company.com','Pedro Perez',1,1,1,1,1000);
insert into globers values (2,'jose.rodriguez@company.com','Jose Rodriguez',2,1,2,2,1500);
insert into globers values (3,'cristiano.ronaldo@company.com','Cristiano Ronaldo',3,2,3,1,300);
insert into globers values (4,'lionel.messi@company.com','Lionel Messi',4,1,1,3,900);
insert into globers values (5,'neymar.jr@company.com','Neymar Jr.',5,3,4,4,1900);
insert into globers values (6,'kylian.mbappe@company.com','Kylian Mbappé',6,4,5,5,3000);
insert into globers values (7,'mohamed.salah@company.com','Mohamed Salah',7,1,6,6,1200);
insert into globers values (8,'kevin.debruyne@company.com','Kevin De Bruyne',8,5,7,7,1200);
insert into globers values (9,'robert.lewandowski@company.com','Robert Lewandowski',9,5,7,8,1200);
insert into globers values (10,'ariel.ortega@company.com','Ariel Ortega',10,6,8,9,100000);
insert into globers values (11,'virgil.vandijk@company.com','Virgil van Dijk',11,5,9,10,3802);
insert into globers values (12,'harry.kane@company.com','Harry Kane',12,2,3,1,1234);
insert into globers values (13,'sadio.mane@company.com','Sadio Mané',13,2,3,5,5678);
insert into globers values (14,'antoine.griezmann@company.com','Antoine Griezmann',12,4,10,1,1234);
insert into globers values (15,'luka.modric@company.com','Luka Modrić',14,1,11,1,3333);
insert into globers values (16,'son.heungmin@company.com','Son Heung-min',15,1,12,1,4568);
insert into globers values (17,'romelu.lukaku@company.com','Romelu Lukaku',15,1,12,1,6543);
insert into globers values (18,'sergio.ramos@company.com','Sergio Ramos',11,2,13,5,3344);
insert into globers values (19,'paul.pogba@company.com','Paul Pogba',16,1,1,1,12334);
insert into globers values (20,'raheem.sterling@company.com','Raheem Sterling',17,1,1,1,1234);
insert into globers values (21,'bruno.fernandes@company.com','Bruno Fernandes',18,1,1,8,1223);
insert into globers values (22,'jadon.sancho@company.com','Jadon Sancho',19,1,1,3,1444);
insert into globers values (23,'guillermo.barros@company.com','Guillermo Barros Schelotto',19,1,1,7,91218);
insert into globers values (24,'fernando.gago@company.com','Fernando Gago',19,1,1,7,91218);
insert into globers values (25,'dario.bennedetto@company.com','Dario Bennedetto',19,1,1,7,91218);



CREATE TABLE accounts(
    id_account int auto_increment primary key,
    account_code varchar(20) not null,
    account_name varchar(255) not null,
    constraint unq_account unique(account_code)
);


INSERT INTO accounts values (1,'ADM01','Almacen Don Manolo');
INSERT INTO accounts values (2,'DOJO','DOJO');
INSERT INTO accounts values (3,'LALIGA01','La Liga');
INSERT INTO accounts values (4,'BANK01','Banco Nuevo X');
INSERT INTO accounts values (5,'ADM01','Banco Nuevo ');
INSERT INTO accounts values (6,'TRAVEL01','Agencia de Viajes Lgante');
INSERT INTO accounts values (7,'COMPANY','COMPANY');
INSERT INTO accounts values (8,'TRAVEL02','Agencia de Viajes Lgante');
INSERT INTO accounts values (9,'BANK02','Banco Mexico');


CREATE TABLE projects (
    id_project int auto_increment primary key,
    project_code varchar(255) not null,
    project_name varchar(255) not null,
    id_account int not null,
    constraint unq_account unique(project_code),
    constraint fk_project_account foreign key (id_account) references accounts(id_account)
);

INSERT INTO projects values (1,'ADMSTOCK01','Almacen Stock',1);
INSERT INTO projects values (2,'ADMBILLING01','Almacen Billing',1);
INSERT INTO projects values (3,'ARDOJO','DOJO Argentina',2);
INSERT INTO projects values (4,'LALIGA','Marketing La Liga',3);
INSERT INTO projects values (5,'BRDOJO','DOJO Brasil',2);
INSERT INTO projects values (6,'BANK01CC','Banco Nuevo Mkt Campaign',4);
INSERT INTO projects values (7,'BANK01CC','Banco Nuevo Mkt Campaign',1);
INSERT INTO projects values (8,'TRAVELLG','Accommodations',6);
INSERT INTO projects values (9,'COMPANY','My Company',7);
INSERT INTO projects values (10,'TRAVELLGH','Hotels',8);
INSERT INTO projects values (11,'CODOJO','DOJO Colombia',2);
INSERT INTO projects values (12,'BANK02-DATA','Data Ingestion',9);
INSERT INTO projects values (13,'MXDOJO','DOJO Mexico',2);
INSERT INTO projects values (14,'BANK02-WEB','Website Transformation',9);
INSERT INTO projects values (15,'SPDOJO','DOJO Spain',2);

create table assigments(
    id_glober int not null,
    id_project int not null,
    date_from date not null,
    date_to date,
    percentage int,
    constraint pk_assigments primary key (id_glober, id_project, date_from),
    constraint fk_assigment_glober foreign key (id_glober) references globers(id_glober),
    constraint fk_assigment_project foreign key (id_project) references  projects(id_project)
);

INSERT into assigments(id_glober, id_project, date_from, date_to, percentage) values (1,1,'2023-01-01',null,100);
INSERT into assigments(id_glober, id_project, date_from, date_to, percentage) values (2,2,'2023-01-01',null,100);
INSERT into assigments(id_glober, id_project, date_from, date_to, percentage) values (3,2,'2023-01-01',null,50);
INSERT into assigments(id_glober, id_project, date_from, date_to, percentage) values (3,1,'2023-01-01',null,50);
INSERT into assigments(id_glober, id_project, date_from, date_to, percentage) values (4,1,'2023-01-01','2025-03-01',100);
INSERT into assigments(id_glober, id_project, date_from, date_to, percentage) values (4,3,'2025-03-02',null,100);
INSERT into assigments(id_glober, id_project, date_from, date_to, percentage) values (5,4,'2025-01-01','2025-02-09',100);
INSERT into assigments(id_glober, id_project, date_from, date_to, percentage) values (5,5,'2025-02-10','2025-02-20',100);
INSERT into assigments(id_glober, id_project, date_from, date_to, percentage) values (5,6,'2025-02-21',null,100);
INSERT into assigments(id_glober, id_project, date_from, date_to, percentage) values (6,6,'2025-02-21',null,100);
INSERT into assigments(id_glober, id_project, date_from, date_to, percentage) values (7,1,'2023-01-01',null,20);
INSERT into assigments(id_glober, id_project, date_from, date_to, percentage) values (7,4,'2023-01-01',null,30);
INSERT into assigments(id_glober, id_project, date_from, date_to, percentage) values (7,6,'2023-01-01',null,50);
INSERT into assigments(id_glober, id_project, date_from, date_to, percentage) values (8,8,'2024-05-01',null,100);
INSERT into assigments(id_glober, id_project, date_from, date_to, percentage) values (9,8,'2024-05-01',null,100);
INSERT into assigments(id_glober, id_project, date_from, date_to, percentage) values (10,9,'2020-01-01',null,100);
INSERT into assigments(id_glober, id_project, date_from, date_to, percentage) values (11,8,'2024-05-05','2025-02-20',70);
INSERT into assigments(id_glober, id_project, date_from, date_to, percentage) values (11,10,'2024-05-05','2025-02-20',30);
INSERT into assigments(id_glober, id_project, date_from, date_to, percentage) values (11,11,'2025-02-21',null,100);
INSERT into assigments(id_glober, id_project, date_from, date_to, percentage) values (12,11,'2025-02-21',null,100);
INSERT into assigments(id_glober, id_project, date_from, date_to, percentage) values (13,11,'2025-02-21',null,100);
INSERT into assigments(id_glober, id_project, date_from, date_to, percentage) values (14,10,'2024-05-05',null,100);
INSERT into assigments(id_glober, id_project, date_from, date_to, percentage) values (15,10,'2024-05-05',null,100);
INSERT into assigments(id_glober, id_project, date_from, date_to, percentage) values (16,12,'2022-01-01',null,100);
INSERT into assigments(id_glober, id_project, date_from, date_to, percentage) values (17,12,'2022-01-01','2025-03-01',100);
INSERT into assigments(id_glober, id_project, date_from, date_to, percentage) values (17,13,'2025-03-02',null,100);
INSERT into assigments(id_glober, id_project, date_from, date_to, percentage) values (18,12,'2022-01-01',null,50);
INSERT into assigments(id_glober, id_project, date_from, date_to, percentage) values (19,14,'2021-03-02',null,100);
INSERT into assigments(id_glober, id_project, date_from, date_to, percentage) values (18,14,'2022-01-01',null,50);
INSERT into assigments(id_glober, id_project, date_from, date_to, percentage) values (20,14,'2022-01-01',null,100);
INSERT into assigments(id_glober, id_project, date_from, date_to, percentage) values (21,14,'2022-01-01',null,100);
INSERT into assigments(id_glober, id_project, date_from, date_to, percentage) values (22,14,'2022-01-01',null,100);
INSERT into assigments(id_glober, id_project, date_from, date_to, percentage) values (23,15,'2018-12-09',null,100);
INSERT into assigments(id_glober, id_project, date_from, date_to, percentage) values (24,15,'2018-12-09',null,100);
INSERT into assigments(id_glober, id_project, date_from, date_to, percentage) values (25,15,'2018-12-09',null,100);
