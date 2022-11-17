drop sequence if exists hibernate_sequence;
create sequence hibernate_sequence start 1 increment 1;
drop table if exists account;
create table account (id int8 not null, email varchar(255), password varchar(255), username varchar(255), primary key (id));