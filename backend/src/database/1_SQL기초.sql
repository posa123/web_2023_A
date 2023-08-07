# 확대축소 : ctrl + 마우스휠
# 한줄주석
-- 한줄주석 
/* 여러줄 주석 */

/*
	데이터베이스 : 데이터[자료] , 베이스[모임]
		- 종류
			1. 계층형 데이터 베이스 : 트리형태
            2. 네트워크형 데이터 베이스 : 양방향 형태
            3. *관계형 데이터 베이스 : 행/열 구성된 테이블[표] 형태
            4. NoSQL 데이터 베이스 : Key-value 형태
			
		- 용어
				DBA[ 데이터베이스 관리자 ]
					- 개발자 
                DBMS[ 데이터베이스 관리 시스템]
					- MYSQL , ORACLE , MARIADB , SQLSERVER -각 회사별 소프트웨어
                    - 표준 SQL [ 구조화된 질의 언어 ]
                DB [ 데이터베이스 ]
					- 실제 데이터 저장된 곳 = DB SERVER 
                    - 메모리[ 16진수/기계어 ] : 개발자 직접적으로 관리 힘듬...
                    
		- 관계
            DBA		----------> 	DB		[ X ]
			개발자					기계어 
            
            DBA		---------->		DBMS	---------> DB		[ O ]
            개발자 					관리시스템 			기계어
									MYSQL
                                    ORACLE
                    표 만들어줘					기계어
                    create
					SQL언어 학습
            이클립스	----------> 	JVM		---------> 메모리		[ O ]
			개발자					번역					
					출력해줘						기계어
                    print()
                    자바언어 학습
                    
		- SQL : DB 조작/관리/제어 할때 사용되는 언어/문법 (대소문자 구분X)
			-1. DDL [ 데이터베이스 정의어 ]
				- 1. create 	: 데이터베이스 , 테이블(표) 생성
					- create database db명;
                    - create table table명( 필드명 속성명 , 필드명 속성명 , 필드명 속성명 );
                    
                - 2. drop 		: 데이터베이스 , 테이블(표) 삭제 
					- drop database db명;
                    - drop database if exists db명;
                    - drop table table명;
                    
                - 3. alter 		: 테이블(표) 속성 수정 
                - 4. truncate  	: 테이블(표)내 데이터 초기화/삭제
                - 5. rename 	: 테이블(표) 의 이름 변경 
                - 6. show		:
					- show databases;					: 데이터베이스 전체 목록보기 
                    - show variables like 'datadir';	: 데이터베이스 저장소 로컬 경로 확인 
				- 7. use
					- use db명	: 데이터베이스 사용 선택
                    
            -2. DML [ 데이버베이스 조작어 ]
				- 1. insert 	: 테이블(표)에 레코드(행) 삽입 
                - 2. select 	: 테이블(표)에 레코드(행) 검색 
					- select * from 테이블명	: 테이블내 모든 필드의 레코드(행) 검색 [ * : 와일드카드(모든) ]
                    
                - 3. update 	: 테이블(표)에 레코드(행) 수정 
                - 4. delete 	: 테이블(표)에 레코드(행) 삭제 
            -3. DCL [ 데이터베이스 제어어 ]
				- 1. grant		: 사용자 권한 부여 
                - 2. revoke		: 사용자 권한 취소 
            -4. TCL [ 트랜잭션 제어어 ]
				- 1. commit		: !! 트랜잭션[명령어 단위] 완료
                - 2. rollback	: 트랜잭션[명령어 단위] 취소
                
                
		- 테이블 용어   /  테이블 [ 표 ]
                속성		colum	  열				필드
				 |		  |       |              |
				학번		학생명	전화번호			주소 
                1010	김현수	010-4444-3333	안산 	- 가로 = 행 = row = 레코드 = 1번레코드
                1011	강호동	010-3333-3333	수원 	- 2번 레코드 
                
			1. colum=열=필드=속성 : 테이블[표]의 열 
				학번필드 , 학생명필드 , 전화번호필드 주소필드
                
			2. row = 행 = 레코드	: 테이블[표]의 행 
				1번레코드 , 2번레코드 , 3번레코드
			
            3. 행/열 로 구성된 테이블(표)를 다른 테이블(표)와 연결/관계 = 관계형 데이터베이스 
            
		- 데이터 필드 타입 [ mysql기준 *DBMS 조금씩 다름 ] 
			(숫자) : 바이트 단위 
            1.정수
				tinyint		[1] 		: -128~127  
                smallint	[2] 		: +-3만정도  
                mediumint	[3]			: +-8백만정도  
                int			[4] 		: +-21억정도
                bigint		[8] 		: +-21억 이상
			2.실수 
				float		[4] 		: 소수점 7자리  
                double		[8]			: 소수점 15자리 
			3.문자
				char(문자길이)			: [ 글자수 최소1~최대255 ] 고정길이			char(3) -> 'ab'	-> 3바이트  	[ *저장할 데이터의 글자수가 정확히 정해져 있는경우 ]
                varchar(문자길이)			: [ 글자수 최소1~최대65535 ] 가변길이			varchar(3) -> 'ab' -> 2바이트 [ *저장할 데이터의 글자수가 정확하지 않을때 ]
            5.대용량 문자 
				text [ 최소1~최대65535 ]
                mediumtext[ 최소1 ~ 최대 16000000 ]
                longtext [ 4G ]		: 긴글 텍스트 
			4.날짜
				date				: (날짜) YYYY-MM-DD
                time 				: (시간) HH:MM:SS
                datetime			: (날짜시간)YYYY-MM-DD HH:MM:SS
			6.논리
				boolean		[1]			: 0 or 1 
*/
/* ------------ 데이터베이스 만들기 -------------- */
#예1 : 데이터베이스( 여러개의 테이블(표) 들이 저장 할 수 있는 공간 - 폴더와 비슷한 형태 ) 생성
create database sqldb1;
	# create 	: 생성한다. 
    # database 	: 데이터베이스.
    # sqldb1 	: 이름정의 [ 아무거나 , 대소문자 구분X , 키워드X ]
    # ;			: 명령어 끝마침.
		# 명령어 실행 : 해당 명령어 줄에 커서 위치한 상태에서  ctrl+엔터  
		# navigator 새로고침
create database sqldb2;
create database sqldb3;
create database sqldb4;
create database sqldb5;
#예2 : 데이터베이스 목록 보기 
show databases;
#예3 : 데이터베이스가 저장된 로컬[pc] 경로 확인 
show variables like 'datadir';
#예4 : 데이터베이스 삭제 
drop database sqldb1;
	# drop : 삭제한다. 
    # database : 데이터베이스 
    # sqldb1 : DB명 
drop database sqldb2;
drop database sqldb3;
drop database sqldb4;
drop database sqldb5;

#예5 : 만약에 데이터베이스 존재했을때 삭제 [ *만약에 데이터베이스 없을때 삭제명령어 사용하면 오류발생!! ]
drop database if exists sqldb1;
	# if exists : 만약에 존재하면 

#예6 : 여러개의 데이터베이스중 사용할 데이터베이스 선택!!
use sqldb1; 
use sqldb2;

#활용1 : 데이터베이스 새롭게 생성하세요.
# 1. 데이터베이스 존재하면 삭제처리
drop database if exists test1;
# 2. 데이터베이스 생성 
create database test1;
# 3. 데이터베이스 사용준비
use test1;

/* ------------ 테이블(표) 만들기 -------------- */
# 테이블(표)는 데이터베이스 안에 저장 [ * 무슨 데이터베이스에서 테이블(표) 생성할껀지... use DB명; ]
#예1 : 테이블 생성
use sqldb1;	# 테이블을 생성할 데이터베이스 선택 
create table member( 아이디 text , 비밀번호 text );
	# create 	: 생성한다.
    # table		: 테이블
	# member	: 이름정의 [ 아무거나 , 대소문자 구분X , 키워드X ]
    # ( );		: 테이블 속성/열/필드 정의 구역 
		# ( 필드명 타입 , 필드명 타입 , 필드명 타입 , 필드명 타입 )	: 테이블(표) 제목/속성/열/필드 정의 
#예2 : 테이블 확인 
select * from member;
#예3 : 테이블 삭제 
drop table member;

# 활용2 : 문제1
/*
	문제1 : 
		1. 웹개발 하는데 DB저장소 'sqldb1web' 이름으로 DB 생성
		2. 해당 db에 member 테이블 생성 
			id( 문자열 최대 20 )	
            password( 문자열 최대 10 )
*/
# 1. 만약에 생성할 이름의 DB명이 존재하면 삭제..
drop database if exists sqldb1web;
# 2. DB 생성 
create database sqldb1web;
# 3. DB 사용 선택 
use sqldb1web;
# 4. 만약에 생성할 이름의 테이블명이 존재하면 삭제.. 
drop table if exists member;
# 5. 테이블생성	( 필드명 타입 , 필드명 타입 ) 
create table member( id varchar(20) , password varchar(20) );
# 6. 테이블생성 여부 확인
select * from member;
/*
	문제2 : 
		1. 웹개발 하는데 DB저장소 'sqldb1web2' 이름으로 DB 생성
		2. 해당 db에 board 테이블 생성 
				게시물번호 	( 필드명 :no  		타입 : 최대 21억정도 )
				게시물제목		( 필드명 :title 		타입 : 문자열 최대 100 )	
				게시물내용 	( 필드명 :content 	타입 : 문자열 최대 6만5천 이상 )
				게시물조회수	( 필드명 :view 		타입 : 최대 21억정도 )
				게시물작성일 	( 필드명 :date 		타입 : 날짜/시간 )
*/
# 1. 데이터베이스 생성 
drop database if exists sqldb1web2;
create database sqldb1web2;
# 2. 테이블 생성 
use sqldb1web2;
drop table if exists board;
create table board( no int , title varchar(100) , content longtext , view int , date datetime );
select * from board;
/*
   문제3 : 
      1. 웹개발 하는데 DB저장소 'sqldb2web1' 이름으로 DB 생성
      2. 해당 db에 memberboard 테이블 생성
            회원번호      ( 필드명 : mno      타입 : 최대 21억정도 )
			회원아이디      ( 필드명 : mid      타입 : 문자열 최대 20 )
			회원비밀번호    ( 필드명 : mpw      타입 : 문자열 최대 20 )
            게시물번호    ( 필드명 : bno        타입 : 최대 21억정도 )
            게시물제목      ( 필드명 : btitle    타입 : 문자열 최대 100 )   
            게시물내용    ( 필드명 : bcontent    타입 : 문자열 최대 6만5천 이상 )
            게시물조회수   ( 필드명 : bview       타입 : 최대 21억정도 )
            게시물작성일    ( 필드명 : bdate       타입 : 날짜/시간 )
*/

drop database if exists sqldb2web1;
create database sqldb2web1;
use sqldb2web1;
drop table if exists memberboard;
create table memberboard(  bno int , btitle varchar(100) , bcontent longtext , bview int , bdate datetime);
drop table if exists memberboard2;
create table memberboard2(  mno int , mid varchar(20) , mpw varchar(20) );
select * from memberboard;
select * from memberboard2;

-- 예1 : 1:M 관계의 / PK:FK관계
use sqldb2web1;
drop table if exists member2;
create table member2( mno_pk int , mid varchar(20) , mpw varchar(20) ,primary key( mno_pk ));

drop table if exists board2;
create table board2(bno int , btitle varchar(100) , bcontent longtext , bview int , bdate datetime ,  mno_fk int ,foreign key(mno_fk) references member2(mno_pk));
/*-----------------------------------------------------------------------------*/
drop database if exists sqldb2sys;
create database sqldb2sys;
use sqldb2sys;

drop table if exists category;
create table category( cno_pk int  ,  cname varchar(10) ,primary key(cno_pk));

drop table if exists product;
create table product( pno_fk int , pname varchar(20) , pprice int , foreign key(pno_fk) references category(cno_pk));

drop table if exists oder;
create table oder( ono int , oname varchar(20) , ondate datetime , ocount int , foreign key(ono) references product(pno_fk));

/*----------------------------------------------------------------------------------------*/
drop database if exists sqldb2team1;
create database sqldb2team1;
use sqldb2team1;

drop table if exists guest;
create table guest( gno int ,gid varchar(10) , gpw varchar(10) , gage int, primary key(gno));

drop table if exists reservation;
create table reservation( rvno int , sno int , gno int , primary key( rvno ) , foreign key(gno)references guest(gno) , foreign key(sno) references screening(sno));

drop table if exists category;
create table category( cno int , cname varchar(7) , primary key (cno));

drop table if exists movie;
create table movie( mno int , mname varchar(10) , cno int , primary key(mno) , foreign key(cno) references category(cno) );

drop table if exists localtheater;
create table localtheater( lno int , lname varchar(5) , primary key(lno) );

drop table if exists movieroom;
create table movieroom( mrno int , mrname varchar(5) , lno int , primary key(mrno) , foreign key(lno) references localtheater(lno));

drop table if exists screening;
create table screening( sno int ,  mrno int , mno int , foreign key(mrno) references movieroom(mrno) ,foreign key(mno) references movie(mno) , primary key(sno));

#------------------------------------------------------------------------------#

drop database if exists sqldb3web;
create database sqldb3web;
use sqldb3web;
# 예제 변경될때 ------------------------
drop table if exists member1;
# create table member1( mno int , primary key(mno) );
# create table member1( mno int , mid varchar(10) , primary key(mno));
# create table member1( mno int auto_increment , mid varchar(10) , primary key(mno));
# create table member1( mno int auto_increment , mid varchar(10) not null, memail varchar(20) , primary key(mno));
# create table member1( mno int auto_increment , mid varchar(10) not null unique, memail varchar(20) , primary key(mno));
create table member1( 
mno int auto_increment , 							-- 회원번호 [ pk , 자동번호 부여 ]			
mid varchar(10) not null unique, 					-- 회원아이디 [ 공백x , 중복x ] 
memail varchar(20) not null unique, 				-- 회원이메일 [ 공백x , 중복x ]
mpoint int not null default 0,						-- 회원포인트 [ 공백x ,기본값0				-- 회원가입시 고객이 입력하는 사항 x ] 
mdate datetime not null default now(),				-- 회원가입일 [ 공백x , 기본값 현재날짜/시간		-- 회원가입시 고객이 입력하는 사항 x]
mreceive boolean not null default true ,			-- 회원이메일수신여부[ 공백x , 기본값 true ]
mimg varchar(1000) not null default 'default.jpg',	-- 회원프로필사진 [ 공백x , 기본값 '기본프로필']
primary key(mno));							-- pk설정
select *from member1;
# -----------------------------------
# * 테이블에 레코드/행 추가하기 .		
	# 1. insert into 테이블명 values( 값1 , 값2 , 값3);				# 모든 필드에 값 추가할때
    # 2. insert into 테이블명( 필드명1 , 필드명2) values( 값1 , 값2)	# 특정 필드에 값 추가할때
insert into member1 values( 1 );	-- member1 테이블의  mno필드에 1 추가
# 예2)
insert into member1 values( 1, '유재석'); 
# 예3) auto_increment : insert 삽입시 해당 필드에 값 생략하면 자동번호가 삽입
insert into member1 values('유재석');


#예4) not null : 해당 필드에 값이 무조건 존재해야되는 경우에 사용 [ 안정성 보장 ]
insert into member1( mid , memail ) values('유재석' , 'qwe@com');
insert into member1(mid) values('강호동');	-- 삽입시 필드 생략하면 생략된 필드는 null(비어있음뜻) 대입
insert into member1( memail ) values('qwe@com');	-- 오류 : mid필드는 not null 제약조건을 사용했으므로 무조건 값 대입

# 예5) unique : 해당 필드에 값의 중복 방지
insert into member1( mid ) values('유재석');
insert into member1( mid ) values('유재석');		-- 오류 : mid필드는 unique 제약조건을 사용했으므로 기존에 값을 대입할수 가 없다. [ 중복방지 ]

# 예6) default : 해당 필드에 값 삽입시 생략할때 자동으로 
insert into member1( mid , memail ) values( '유재석' , 'qwe@com');

# ------------------------------------- 문제6 ---------------------------------------- #
drop database if exists sqldb3web2;
create database sqldb3web2;
use sqldb3web2;

drop table if exists product;
create table product( 
	pno int auto_increment not null,			-- 제품번호 [ 정수타입 , pk필드 , 자동번호부여] 
    pname varchar(100) unique not null , 		-- 제품명 [ 문자열(100) , 중복제거 ]
    pprice int default 0 not null , 				-- 제품가격 [ 정수타입 , 기본값 0 ]
    pdate datetime  default now() not null,		-- 제품등록일 [ 날짜/시간타입 , 기본값 현재시간 ]
    primary key(pno),
    cno int ,
    foreign key(cno) references category(cno)					-- 제품번호 필드를 pk필드 선정

);
select * from product;

insert into product(pname , pprice) values( '콜라' , 1000);
insert into product(pname) values( '사이다' );
insert into product(pname , pprice , pdate) values('환타' , 1500 ,'2023-08-03 17:10:30' );

drop table if exists category;
create table category( 
	cno int auto_increment not null, 
	cname varchar(20) unique not null,
    primary key(cno)
);
insert into category( cname ) values('에이드'); 	# '에이드'카테고리 등록 [ 자동번호 부여 = 1 ]
insert into category( cname ) values('탄산'); 	# '탄산' 카테고리 등록 [ 자동번호 부여 = 2 ]
# 1번카테고리[에이드] 에 제품 등록
insert into product( pname , pprice , cno ) values( '사과에이드 ' , 3000 , 1);
# 1번카테고리[에이드] 에 제품 등록
insert into product( pname , pprice , cno ) values( '포도에이드' , 3500 , 1);
# 2번카테고리[탄산] 에 제품 등록
insert into product ( pname , pprice , cno ) values('제로콜라' , 4000 , 2 );
select * from ctegory;
# ------------------------------------------------------------------------------- #
# JDBC 와 연결할 DB선언
drop database if exists sqldb4web;
create database sqldb4web;
use sqldb4web;
#member 테이블
drop table if exists member;
create table member( 
	mno int auto_increment not null unique,  -- 자동부여[무조건PK만가능]
	mid varchar(30) not null unique, 
	mpw varchar(30) not null, 	-- 중복허용
	mname varchar(30) not null , -- 중복허용
	mphone varchar(13) not null unique,
    primary key(mno)
);
select * from member;
# 1. 회원가입 [ 테이블에 레코드 삽입(insert) ]
insert into member( mid, mpw, mname, mphone) values( 'ezen01 ','1234','이젠','031-444-2222' );

# 2. 로그인 [ 테이블에 값 검색(select) ]		필드 : 열/세로		레코드 : 행/가로
select mid from member;					-- mid 필드의 레코드만 검색
select mid , mpw from member; 			-- mid 와 mpw 필드의 레코드만 검색
select mid , mpw , mname from member;	-- mid 와 mpw 와 mnaem 필드의 레코드만 검색
# 1. 로그인할때 필요한 필드 검색		select * from member;
select mid , mpw from member;	
# 2. 아이디와 패스워드가 일치한 레코드 검색
select mid , mpw from member where mid = 'qwe';						# 만약에 mid필드에 'qwe'문자열에 있는 레코드 검색
select mid , mpw from member where mid = 'ezen01';					# 만약에 mid필드에 'ezen01' 문자열이 있는 레코드 검색

# 만약에 mid필드가 'ezen01' 이면서 mpw필드가  '1234' 인 레코드 검색
select mid , mpw from member where mid = 'ezen01' and mpw ='1234';
# 자바 문자열
select mid , mpw from member where mid = ? and mpw = ?;


/*
	1. 테이블의 필드에 해당하는 레코드 검색
		select 필드명  from 테이블명					: 해당 필드의 레코드 검색
        select 필드명 , 필드명 , 필드명 from 테이블명	: 여러개 필드들의 레코드 검색
		select * from 테이블명						: 모든 필드[*] 의 레코드 검색
	2. 필드에 조건 추가							[ where 조건절 ( 필드명 연산자 값 ) ]
		select 필드명 				from 테이블명 where 조건
        select 필드명 , 필드명 , 필드명 	from 테이블명 where 조건
        select * 					from 테이블명 where 조건

*/
# -------------------------------------------------------------------------- #
drop database if exists sqldb5web;
create database sqldb5web;
use sqldb5web;
drop table if exists table1;
create table table1( 데이터1 int , 데이터2 varchar(100));
select * from table1;
# 1. insert [C : create]
	# insert into 테이블명(필드명 , 필드명 ) values ( 값1 , 값2 )
insert into table1( 데이터1 , 데이터2 ) values( 1, '유재석' );
insert into table1( 데이터1 , 데이터2 ) values( 2, '강호동' );

# 2. select [R : read]	로그인 , 아이디찾기 , 비밀번호찾기 , 글목록 , 글조회 , 제품조회 , 주문현황 등등
	# select 필드명 from 테이블명
	# select 필드명 from 테이블명 where 조건절
select * from table1;						# 모든 레코드 검색	[모든필드 표시]
select * from table1 where 데이터2 = '강호동'; # 데이터2 필드의 값이 '강호동'인 레코드 검색 [모든필드 표시]

# 3. update [U : update]
	# update 테이블명 set 필드명 = 수정값 , 필드명 = 수정값
    # update 테이블명 set 필드명 = 수정값 , 필드명 = 수정값 where 조건절
update table1 set 데이터1 = 3;							# 모든 레코드의 데이터1 필드의 값을 3으로 변경
update table1 set 데이터1 = 2 where 데이터2 = '유재석';		# 데이터2 필드의 값이 '유재석' 이면 데이터1 필드의 값을 2로 변경

# 4. delete [D : delete]
	# delete from 테이블명
    # delete from 테이블명 where 조건절
delete from table1;							# 모든 레코드 삭제
delete from table1 where 데이터1 = '유재석';	# 데이터2 필드의 값이 '유재석'인 레코드 삭제


