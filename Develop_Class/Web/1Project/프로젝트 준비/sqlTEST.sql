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

insert into MEMBER values(MEMBER_SEQ.nextval, '����� ��õ��', '���굿', '������', '����', '970411', 'gusrl', '01050575914');
insert into MEMBER values(MEMBER_SEQ.nextval, '����� ���Ǳ�', '�Ÿ���', '��̿�', '����', '950216', 'aldud', '01076218854');
insert into MEMBER values(MEMBER_SEQ.nextval, '��⵵ �����', 'ö�굿', '�ڼ���', '����', '931018', 'tjddn', '01094388412');
insert into MEMBER values(MEMBER_SEQ.nextval, '����� ��õ��', '���굿', '����', '����', '900314', 'wns', '01042285691');
insert into MEMBER values(MEMBER_SEQ.nextval, '����� ��õ��', '���굿', '������', '����', '990527', 'wlals', '01030589422');


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

insert into GROUPTAB values(GROUP_SEQ.nextval, '�׷��̸�1', '�׷�Ұ�1', 1, '�׷��̸�1�� ��������ּ�', '15��30�� - 16�� 30��', '�� �׷��� ���Ե� ���ɻ��±�', 5, 10000, SYSDATE);
insert into GROUPTAB values(GROUP_SEQ.nextval, '�׷��̸�2', '�׷�Ұ�2', 2, '�׷��̸�2�� ��������ּ�', '17��00�� - 18�� 00��', '�� �׷��� ���Ե� ���ɻ��±�', 3, 0, SYSDATE);
insert into GROUPTAB values(GROUP_SEQ.nextval, '�׷��̸�3', '�׷�Ұ�3', 3, '�׷��̸�3�� ��������ּ�', '15��40�� - 19�� 00��', '�� �׷��� ���Ե� ���ɻ��±�', 2, 10000, SYSDATE);

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

insert into BOARD values(B_NUM_SEQ.nextval, 'IT1', 'it�ϽǺ�!', '1', '���ؿ�', 'it����', 3, 10, SYSDATE);
insert into BOARD values(B_NUM_SEQ.nextval, '����', '���ϽǺ�!!', '2', '���ؿ�2', 'it����2', 3, 10, SYSDATE);
insert into BOARD values(B_NUM_SEQ.nextval, 'IT2', 'it�ϽǺ�!!!', '3', '���ؿ�2', 'it����2', 3, 10, SYSDATE);
insert into BOARD values(B_NUM_SEQ.nextval, 'IT3', 'it�ϽǺ�!!!!', '4', '���ؿ�4', 'it����42', 3, 12, SYSDATE);

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