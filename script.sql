create schema fonyou_employee collate latin1_swedish_ci;

create table hibernate_sequence
(
	next_val bigint null
);

create table person
(
	dtype varchar(31) not null,
	id int auto_increment
		primary key,
	creation_time datetime(6) null,
	update_time datetime(6) null,
	version int null,
	birth_date varchar(255) null,
	last_names varchar(255) null,
	names varchar(255) null,
	salary decimal(19,2) null
);

create table student
(
	id bigint not null
		primary key,
	version int null,
	email varchar(255) null,
	firstname varchar(255) null,
	lastname varchar(255) null
);

