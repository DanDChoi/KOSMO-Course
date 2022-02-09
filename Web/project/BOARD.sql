alter session set "_oracle_script"=true;
create user togather identified by team1;
grant connect, resource, unlimited tablespace to togather;
conn togather/team1;

drop table BOARD;
drop sequence B_NUM;
purge recyclebin;

create table BOARD(
   BNUM number NOT NULL constraint BNUM_PK primary key, 
   BCATEGORY nvarchar2(20) NOT NULL, 
   BTITLE nvarchar2(20) NOT NULL,
   MNUM number NOT NULL constraint MNUM_FK FOREIGN KEY REFERENCES MEMBER (MNUM),
   BCONTENT nvarchar2(500) NOT NULL,
   B_FILE nvarchar2(20),
   BLIKE number,
   BVIEW number NOT NULL
); 
create sequence B_NUM increment by 1 start with 1 nocache;

insert into BOARD values(B_NUM.nextval, 'IT', 'it하실분', '1', '구해요', 'it파일', 3, 10);



commit;

select * from BOARD;