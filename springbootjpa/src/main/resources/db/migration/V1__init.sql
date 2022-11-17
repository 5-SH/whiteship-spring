-- 한번 적용이 된 flyway script 파일은 절대로 다시 건드리면 안된다.
-- 항상 스크립트 파일 변경은 새 버전의 스크립트 파일을 만들어서 사용해야 한다.
drop table if exists account;
drop sequence if exists hibernate_sequence;
create sequence hibernate_sequence start 1 increment 1;
create table account (id int8 not null, email varchar(255), password varchar(255), username varchar(255), primary key (id));