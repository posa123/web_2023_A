# 확대축소 ctrl+ 마우스휠
# 한줄주석
-- 한줄주석
/* 여러줄 주석 */

/*
	데이터베이스 : 데이터[자료] , 베이스[모임]
		- 종류
			1. 계층형 데이터 베이스 : 트리형태
            2. 네트워크형 데이터 베이스 : 양방향 형태
            3. *관계형 데이터 베이스 : 행/열 구성된 테이블[표] 형태
            4. noSQL 데이터 베이스 : key-value
			
	- 용어
            DBA [ 데이터베이스 관리자 ]
				- 개발자
			DBMS [ 데이터베이스 관리 시스템 ]
				- MYSQL , ORACLE(1) , MARIADB , SQLSERVER -각 회사별 소프트웨어
                - SQL [ 구조화된 질의 언어 ] 
            DB [ 데이터베이스 ]
				- 실제 데이터 저장된 곳 = DB SERVER
				- 메모리 [ 16진수/기계어 ] : 개발자 직접으로 관리 힘듬...
                
	- 관계alter
		
        DBA ----------------> DB [X]
        개발자                 기계어alter
        
        
        DBA ----------------> DBMS -------------------> DB		[O]
        개발자 				관리시스템						기계어

		이클립스 ----------->  JVM  ------------------> 메모리 [O]
        개발자				번역
	-SQL : DB 조작/관리/제어 할때 사용되는 언어/문법 (대소문자 구분X)
		-1. DDL	[ 데이터베이스 정의어 ]
			- 1. create		: 데이터베이스 , 테이블 , 뷰(가상테이블) 생성
            - 2. drop		: 데이터베이스 , 테이블 , 뷰(가상테이블) 삭제
            - 3. alter		: 테이블 , 뷰(가상테이블) 속성 수정
            - 4. truncate	: 테이블내 데이터 초기화/삭제
            - 5. rename		: 테이블 , 뷰(가상테이블) 의 이름 변경
		-2. DML	[ 데이터베이스 조작어 ]
			- 1. insert		: 테이블(표)에 레코드(행) 삽입
            - 2. select		: 테이블(표)에 레코드(행) 검색
			- 3. update		: 테이블(표)에 레코드(행) 수정
            - 4. delete		: 테이블(표)에 레코드(행) 삭제
        -3. DCL	[ 데이터베이스 제어어 ]
			- 1. grant		: 사용자 권한 부여
            - 2. revoke		: 사용자 권한 취소
        -4. TCL	[ 트랜잭션 제어어 ]
			- 1. commit		: !! 트랜잭션[명령어 단위] 완료
            - 2. rollback	: 트랜잭션[명령어 단위] 취소
    
*/