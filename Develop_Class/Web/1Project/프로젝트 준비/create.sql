drop table MEMBER;
drop table BLOCK;

--alter session set "_oracle_script"=true;
--create user togather identified by team1;
--grant connect, resource, unlimited tablespace to togather;
--conn togather/team1;

drop sequence MEMBER_SEQ;
drop sequence BLOCK_SEQ;

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

select CONSTRAINT_NAME, CONSTRAINT_TYPE from user_constraints where TABLE_NAME='MEMBER';
select * from MEMBER order by MNUM desc;

create table BLOCK(
	BSEQ number constraint BSEQ_PK primary key,
	BLOCKING number,
	BLOCKED number
);
create sequence BLOCK_SEQ increment by 1 start with 1 nocache;

insert into BLOCK values(BLOCK_SEQ.nextval, 1, 2);
insert into BLOCK values(BLOCK_SEQ.nextval, 1, 3);
insert into BLOCK values(BLOCK_SEQ.nextval, 2, 4);

select CONSTRAINT_NAME, CONSTRAINT_TYPE from user_constraints where TABLE_NAME='BLOCK';
select * from BLOCK order by BSEQ desc;

commit;
