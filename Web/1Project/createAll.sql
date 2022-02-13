--alter session set "_oracle_script"=true;
--create user togather identified by team1;
--grant connect, resource, unlimited tablespace to togather;
--conn togather/team1;



drop table BLOCK;
drop sequence MEMBER_SEQ;
drop sequence BLOCK_SEQ;
drop table MEM_IN_GROUP;
drop table GROUPTAB;
drop sequence GROUP_SEQ;
drop table REPLY;
drop sequence B_NUM_SEQ;
drop sequence RSEQ_SEQ;
drop sequence MNUM_SEQ;
drop sequence MEMBER_SEQ;
drop table GATHERING;
drop table GROUPTAB;
drop table BOARD;
drop table MEMBER;
drop sequence GROUPTAB_SEQ;
drop sequence GATHERING_SEQ;
purge recyclebin;

create table MEMBER(
   MNUM NUMBER constraint MEMBER_PK primary key, 
   MADDR NVARCHAR2(40) NOT NULL, 
   PFR_LOC NVARCHAR2(40) NOT NULL,
   MNAME NVARCHAR2(20) NOT NULL,
   GENDER NVARCHAR2(2) NOT NULL,
   BIRTH NVARCHAR2(20) NOT NULL,
   PWD NVARCHAR2(20) NOT NULL,
   PHONE NUMBER NOT NULL UNIQUE,
   ATHUR NUMBER default 2 check(ATHUR in(0, 1, 2))
); 
create sequence MEMBER_SEQ increment by 1 start with 1 nocache;

insert into MEMBER values(MEMBER_SEQ.nextval, '서울시 금천구', '가산동', '조현기', '남자', '970411', 'gusrl', '01050575914',default);
insert into MEMBER values(MEMBER_SEQ.nextval, '서울시 관악구', '신림동', '김미영', '여자', '950216', 'aldud', '01076218854',default);
insert into MEMBER values(MEMBER_SEQ.nextval, '경기도 광명시', '철산동', '박성우', '남자', '931018', 'tjddn', '01094388412',default);
insert into MEMBER values(MEMBER_SEQ.nextval, '서울시 금천구', '독산동', '김준', '남자', '900314', 'wns', '01042285691',default);
insert into MEMBER values(MEMBER_SEQ.nextval, '서울시 금천구', '가산동', '이지민', '여자', '990527', 'wlals', '01030589422',default);


create table BLOCK(
   BSEQ number constraint BSEQ_PK primary key,
   BLOCKING number,
   BLOCKED number
);
create sequence BLOCK_SEQ increment by 1 start with 1 nocache;

insert into BLOCK values(BLOCK_SEQ.nextval, 1, 2);
insert into BLOCK values(BLOCK_SEQ.nextval, 1, 3);
insert into BLOCK values(BLOCK_SEQ.nextval, 2, 4);

create table GROUPTAB(
	GSEQ number constraint GROUPTAB_PK primary key,
	GLOC nvarchar2(30),
	GNAME nvarchar2(40),
	GINTRO nvarchar2(2000),
	INTEREST nvarchar2(40),
	LIMIT number,
	RDATE date,
	MNUM number REFERENCES MEMBER (MNUM) on delete cascade
);
create sequence GROUPTAB_SEQ increment by 1 start with 1 nocache;

insert into GROUPTAB values(GROUPTAB_SEQ.nextval, '서울시 금천구', '코딩해요~', '같이 코딩하면서 즐겨요!', 'IT', 50, SYSDATE, 1);
insert into GROUPTAB values(GROUPTAB_SEQ.nextval, '서울시 관악구', '행축 (행복축구 하실 분)', '축구하면서 친목쌓고 노실 분들 오세요~', '스포츠', 30, SYSDATE, 2);
insert into GROUPTAB values(GROUPTAB_SEQ.nextval, '경기도 광명시', '맛집탐방', '동네 숨은 맛집 같이 찾으실 분들 ㄱㄱ', '사교', 50, SYSDATE, 3);

create table MEM_IN_GROUP(
    GSEQ number REFERENCES GROUPTAB(GSEQ),
    MNUM number,
    GRADE number default 0 check(GRADE in(0, 1, 2))
);

insert into MEM_IN_GROUP values(1, 1, 2);
insert into MEM_IN_GROUP values(1, 2, 0);
insert into MEM_IN_GROUP values(1, 3, 1);

create table BOARD(
   BNUM number constraint BNUM_PK primary key, 
   BCATEGORY nvarchar2(20) NOT NULL, 
   BTITLE nvarchar2(20) NOT NULL,
   MNUM number REFERENCES MEMBER (MNUM),
   MNAME nvarchar2(20) NOT NULL,
   BCONTENT nvarchar2(500) NOT NULL,
   BFILE nvarchar2(20),
   BLIKE number,
   BVIEW number NOT NULL,
   RDATE date
); 
create sequence B_NUM_SEQ increment by 1 start with 1 nocache;

insert into BOARD values(B_NUM_SEQ.nextval, 'IT1', 'it하실분!', '1', '조현기', '구해요', 'it파일', 3, 10, SYSDATE);
insert into BOARD values(B_NUM_SEQ.nextval, '게임', '롤하실분!!', '2', '김미영', '구해요2', 'it파일2', 3, 10, SYSDATE);
insert into BOARD values(B_NUM_SEQ.nextval, 'IT2', 'it하실분!!!', '3', '박성우', '구해요2', 'it파일2', 3, 10, SYSDATE);
insert into BOARD values(B_NUM_SEQ.nextval, 'IT3', 'it하실분!!!!', '4', '김준', '구해요4', 'it파일42', 3, 12, SYSDATE);

create table REPLY(
   RSEQ number constraint REPLY_PK primary key,
   BNUM number NOT NULL REFERENCES BOARD (BNUM) on delete cascade,
   MNAME nvarchar2(40) NOT NULL,
   MNUM number NOT NULL,
   CONTENT nvarchar2(100), 
   R_LIKE number NOT NULL,
   RDATE date,
   LEV number NOT NULL
); 
create sequence RSEQ_SEQ increment by 1 start with 1 nocache;
create sequence MNUM_SEQ increment by 1 start with 1 nocache;

insert into REPLY values(RSEQ_SEQ.nextval, 1, '조현기3', 1, '저도 하고 싶33어요', 2, SYSDATE, 1);
insert into REPLY values(RSEQ_SEQ.nextval, 2, '김미영3', 2, '자리 있나3요??', 3, SYSDATE, 2);
insert into REPLY values(RSEQ_SEQ.nextval, 3, '박성우3', 3, '재밌어 보3여요', 1, SYSDATE, 2);
insert into REPLY values(RSEQ_SEQ.nextval, 4, '김준3', 4, '몇명 있3나요??', 0, SYSDATE, 1);
insert into REPLY values(RSEQ_SEQ.nextval, 2, '조현기3', 1, '저도 하고 싶33어요', 2, SYSDATE, 1);
insert into REPLY values(RSEQ_SEQ.nextval, 3, '김미영3', 2, '자리 있나3요??', 3, SYSDATE, 2);
insert into REPLY values(RSEQ_SEQ.nextval, 4, '박성우3', 3, '재밌어 보3여요', 1, SYSDATE, 2);
insert into REPLY values(RSEQ_SEQ.nextval, 1, '김준3', 4, '몇명 있3나요??', 0, SYSDATE, 1);




create table GATHERING(
	GT_SEQ number constraint GATHERING_PK primary key,
	GT_NAME nvarchar2(40),
	GT_DATE nvarchar2(20),
	TIME nvarchar2(40),
	GT_PLACE nvarchar2(40),
	PRICE nvarchar2(20),
	GT_LIMIT number,
	GSEQ number REFERENCES GROUPTAB (GSEQ) on delete cascade
     );

create sequence GATHERING_SEQ increment by 1 start with 1 nocache;


commit;


select sequence_name from user_sequences;

select * from MEMBER order by MNUM desc;
select * from BLOCK order by BSEQ desc;
select * from GROUPTAB order by GSEQ desc;
select * from MEM_IN_GROUP order by GSEQ desc;
select * from REPLY;
select * from BOARD;