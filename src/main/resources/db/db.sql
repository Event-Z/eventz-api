 create database valenotadb;

create table address (
	id varchar(36) primary key,
    street varchar(255) not null,
    city varchar(255) not null,
    district varchar(255) not null,
    number int not null,
    cep varchar(10) not null
);

create table person (
	id varchar(36) primary key,
	name varchar(255) not null,
    cpf varchar(11) unique not null,
    password varchar(255) not null,
    address_id varchar(36) not null,
    foreign key(address_id) references address (id)
);

create table company (
	id varchar(36) primary key,
	name varchar(255) unique null,
    cnpj varchar(14) unique null,
    password varchar(255) not null,
    address_id varchar(36) not null,
    foreign key(address_id) references address (id)
);

create table support (
	id varchar(36) primary key,
    number varchar(45),
    email varchar(255),
    site varchar(255)
);

create table event (
	id varchar(36) primary key,
    date_event datetime not null,
    price double not null,
    name varchar(255) not null,
    company_id varchar(36) not null,
    support_id varchar(36),
    address_id varchar(36) not null,
    foreign key(company_id) references company (id),
    foreign key(address_id) references address (id)
);

create table person_event (
	id varchar(36) primary key,
    person_id varchar(36) not null,
    event_id varchar(36) not null,
	foreign key(person_id) references person (id),
    foreign key(event_id) references event (id)
);

create table question (
	id varchar(36) primary key,
    q varchar(255) not null,
    resp varchar(255) not null
);

create table session_token (
	token varchar(32) primary key,
    person_id varchar(36),
    company_id varchar(36),
    expired boolean default false not null,
    created_at timestamp default current_timestamp,
    updated_at timestamp default current_timestamp,
    foreign key (person_id) references person (id),
    foreign key (company_id) references company (id)
);