drop database if exists sqldb4web;
create database sqldb4web;
use sqldb4web;
# 회원번호[자동] 아이디 비밀번호 이름 전화번호를 저장하는 member 테이블 생성
# 테이블과 비슷하게 memberDto 클래스 설계

drop table if exists member;
create table member( 
	mno int auto_increment not null unique,  -- 자동부여[무조건PK만가능]
	mid varchar(30) not null unique, 
	mpw varchar(30) not null, 	-- 중복허용
	mname varchar(30) not null , -- 중복허용
	mphone varchar(13) not null unique,
    primary key(mno)
);


