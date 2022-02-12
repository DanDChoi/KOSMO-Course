--alter session set "_oracle_script"=true;
--create user togather identified by team1;
--grant connect, resource, unlimited tablespace to togather;
--conn togather/team1;



drop table BLOCK;
drop sequence MEMBER_SEQ;
drop sequence BLOCK_SEQ;
drop table MEM_IN_GROUP;
drop table GATHERING;
drop sequence GATHERING_SEQ;
drop table GROUPTAB;
drop sequence GROUPTAB_SEQ;
drop table REPLY;
drop sequence B_NUM_SEQ;
drop sequence RSEQ_SEQ;
drop table BOARD;
drop table MEMBER;
purge recyclebin;

create table MEMBER(
	MNUM number constraint MNUM_PK primary key,
	MADDR nvarchar2(40),
	PFR_LOC nvarchar2(40),
	MNAME nvarchar2(40),
	GENDER nvarchar2(2),
	BIRTH nvarchar2(20),
	PWD nvarchar2(40),
	PHONE nvarchar2(13) unique
);
create sequence MEMBER_SEQ increment by 1 start with 1 nocache;

insert into MEMBER values(MEMBER_SEQ.nextval, '서울시 금천구', '가산동', '조현기', '남자', '970411', 'gusrl', '01050575914');
insert into MEMBER values(MEMBER_SEQ.nextval, '서울시 관악구', '신림동', '김미영', '여자', '950216', 'aldud', '01076218854');
insert into MEMBER values(MEMBER_SEQ.nextval, '경기도 광명시', '철산동', '박성우', '남자', '931018', 'tjddn', '01094388412');
insert into MEMBER values(MEMBER_SEQ.nextval, '서울시 금천구', '독산동', '김준', '남자', '900314', 'wns', '01042285691');
insert into MEMBER values(MEMBER_SEQ.nextval, '서울시 금천구', '가산동', '이지민', '여자', '990527', 'wlals', '01030589422');


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
   MNUM number REFERENCES MEMBER (MNUM)
);
create sequence GROUPTAB_SEQ increment by 1 start with 1 nocache;

insert into GROUPTAB values(GROUPTAB_SEQ.nextval, '서울시 금천구', '코딩해요~', '같이 코딩하면서 즐겨요!', 'IT', 50, SYSDATE, 1);
insert into GROUPTAB values(GROUPTAB_SEQ.nextval, '서울시 관악구', '행축 (행복축구 하실 분)', '축구하면서 친목쌓고 노실 분들 오세요~', '스포츠', 30, SYSDATE, 2);
insert into GROUPTAB values(GROUPTAB_SEQ.nextval, '경기도 광명시', '맛집탐방', '동네 숨은 맛집 같이 찾으실 분들 ㄱㄱ', '사교', 50, SYSDATE, 3);

create table GATHERING(
   GT_SEQ number constraint GATHERING_PK primary key,
   GT_NAME nvarchar2(40),
   GT_DATE nvarchar2(20),
   TIME nvarchar2(40),
   GT_PLACE nvarchar2(40),
   PRICE nvarchar2(20),
   GT_LIMIT number,
   GSEQ number REFERENCES GROUPTAB (GSEQ)
     );

create sequence GATHERING_SEQ increment by 1 start with 1 nocache;

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
   BCONTENT nvarchar2(500) NOT NULL,
   B_FILE nvarchar2(20),
   BLIKE number,
   BVIEW number NOT NULL
); 
create sequence B_NUM_SEQ increment by 1 start with 1 nocache;

insert into BOARD values(B_NUM_SEQ.nextval, 'IT', 'it하실분', '1', '구해요', 'it파일', 3, 10);
insert into BOARD values(B_NUM_SEQ.nextval, '게임', '롤하실분', '2', '구해요2', 'it파일2', 3, 10);
insert into BOARD values(B_NUM_SEQ.nextval, 'IT', 'it하실분', '3', '구해요2', 'it파일2', 3, 10);

create table REPLY(
   BNUM number NOT NULL REFERENCES BOARD (BNUM),
   RSEQ number constraint REPLY_PK primary key,
   CONTENT nvarchar2(100), 
   R_LIKE number NOT NULL,
   REF number NOT NULL,
   LEV number NOT NULL
); 
create sequence RSEQ_SEQ increment by 1 start with 1 nocache;

insert into REPLY values(1, RSEQ_SEQ.nextval, 'reply1', 10, 0, 1);
insert into REPLY values(2, RSEQ_SEQ.nextval, 'reply2', 5, 1, 0);
insert into REPLY values(3, RSEQ_SEQ.nextval, 'reply3', 7, 0, 0);


select sequence_name from user_sequences;

commit;

select * from MEMBER order by MNUM desc;
select * from BLOCK order by BSEQ desc;
select * from GROUPTAB order by GSEQ desc;
select * from MEM_IN_GROUP order by GSEQ desc;
select * from REPLY;
select * from BOARD;
