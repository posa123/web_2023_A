drop database if exists jspweb;
create database jspweb;
use jspweb;

drop table if exists visitlog;
create table visitlog(
	vno			int auto_increment , 		-- 식별번호( 방문록번호 ) , 자동번호 부여 
    vwriter 	varchar(30) not null , 		-- (방문록작성자명) , 공백불가능 
    vpwd 		varchar(10) not null , 		-- (방문록비밀번호) , 공백불가능 
    vcontent	text not null , 			-- (방문록 내용 ) 
    vdate		datetime default now() , 	-- (방문록 작성일/시간 ) , 생략시 자동날짜/시간 등록 
    primary key( vno )
);
drop table if exists member;
create table member(
	mno int auto_increment ,				-- 식별번호( 회원번호 ) , 자동번호 부여 
    mid varchar(50) not null unique ,		-- ( 회원아이디 ) , 공백불가능 , 중복불가능  
    mpwd varchar(20) not null , 			-- ( 회원비밀번호 ) , 공백불가능  
    memail varchar(50) not null unique ,	-- ( 회원이메일 )  , 공백불가능  
    mimg longtext ,							-- ( 회원 프로필의 이미지사진 이름 ) , 공백가능 
    primary key( mno )
);

# 게시판 카테고리 
drop table if exists bcategory;
create table bcategory(
	bcno int auto_increment , 		
    bcname varchar(30) not null ,
    primary key( bcno )
);
# 샘플 [ 공지사항 , 자유게시판  , 노하우 ] 
insert into bcategory value ( 1 , '공지사항');
insert into bcategory value ( 2 , '자유게시판');
insert into bcategory value ( 3 , '노하우');

# 게시판 
drop table if exists board;
create table board(
	bno			int auto_increment , 
    btitle		varchar(30) not null , 
    bcontent 	longtext , 
	bfile		longtext , 
    bdate		datetime default now() ,
    bview		int default 0 ,
    mno			int , 
    bcno		int ,
    primary key( bno ) ,
    foreign key( mno ) references member(mno) 
    		on delete cascade ,  -- 회원탈퇴시 게시물도 같이 삭제 [ 제약조건 ]
    foreign key( bcno ) references bcategory( bcno ) 
    		on delete cascade 
    		on update cascade  	-- 카테고리 삭제시 게시물도 삭제 , 카테고리번호 변경시 fk도 같이 변경   [ 제약조건 ]
);


# 모든 글출력 [ 게시물번호 , 제목 , 파일 , 작성일 , 조회수 , 작성자아이디 , 카테고리명 ]
select * from board;
select bno , btitle , bfile , bdate , bview from board;
	# 게시물 테이블과 회원 테이블 조인[테이블 합치기 / pk - fk ]
    # 게시물 테이블내 작성자번호와 회원테이블의 작성자 번호와 같으면 
select * from board b natural join member m;
select b.bno , b.btitle , b.bfile , b.bdate , b.bview from board b natural join member m;
select b.bno , b.btitle , b.bfile , b.bdate , b.bview , m.mid from board b natural join member m;
	# 게시물 테이블 모든 필드  , 회원테이블의 아이디 , 게시물카테고리테이블
select b.* , m.mid , m.mimg , bc.bcname
	from board b 
		natural join bcategory bc
        natural join member m 
        order by b.bdate desc;
# select * from board b ,bcategory bc , member m where b.bcno = bc.bcno ;
