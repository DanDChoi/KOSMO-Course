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
    GSEQ number constraint GROUP_PK primary key,
    GNAME nvarchar2(40),
    GINTRO nvarchar2(2000),
    MNUM number,
    GADDR nvarchar2(40),
    TIME nvarchar2(40),
    INTEREST nvarchar2(40),
    LIMIT number,
    PRICE number,
    RDATE date
);
create sequence GROUP_SEQ increment by 1 start with 1 nocache;

insert into GROUPTAB values(GROUP_SEQ.nextval, '그룹이름1', '그룹소개1', 1, '그룹이름1이 만날장소주소', '15시30분 - 16시 30분', '이 그룹이 포함된 관심사태그', 5, 10000, SYSDATE);
insert into GROUPTAB values(GROUP_SEQ.nextval, '그룹이름2', '그룹소개2', 2, '그룹이름2이 만날장소주소', '17시00분 - 18시 00분', '이 그룹이 포함된 관심사태그', 3, 0, SYSDATE);
insert into GROUPTAB values(GROUP_SEQ.nextval, '그룹이름3', '그룹소개3', 3, '그룹이름3이 만날장소주소', '15시40분 - 19시 00분', '이 그룹이 포함된 관심사태그', 2, 10000, SYSDATE);

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
   BVIEW number NOT NULL,
   RDATE date
); 
create sequence B_NUM_SEQ increment by 1 start with 1 nocache;

insert into BOARD values(B_NUM_SEQ.nextval, 'IT1', 'it하실분!', '1', '구해요', 'it파일', 3, 10, SYSDATE);
insert into BOARD values(B_NUM_SEQ.nextval, '게임', '롤하실분!!', '2', '구해요2', 'it파일2', 3, 10, SYSDATE);
insert into BOARD values(B_NUM_SEQ.nextval, 'IT2', 'it하실분!!!', '3', '구해요2', 'it파일2', 3, 10, SYSDATE);
insert into BOARD values(B_NUM_SEQ.nextval, 'IT3', 'it하실분!!!!', '4', '구해요4', 'it파일42', 3, 12, SYSDATE);

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

select * from MEMBER order by MNUM desc;
select * from BLOCK order by BSEQ desc;
select * from GROUPTAB order by GSEQ desc;
select * from MEM_IN_GROUP order by GSEQ desc;
select * from REPLY;
select * from BOARD;