alter session set "_oracle_script"=true;
create user togather identified by team1;
grant connect, resource, unlimited tablespace to togather;
conn togather/team1;

drop table REPLY;
drop sequence B_NUM;
purge recyclebin;

create table BOARD(
   BNUM number NOT NULL constraint BNUM_PK FOREIGN KEY REFERENCES BOARD (BNUM),
   CONTENT nvarchar2(100), 
   LIKE number NOT NULL,
   REF number NOT NULL,
   LEV number NOT NULL,
); 
create sequence B_NUM increment by 1 start with 1 nocache;

--insert into REPLY values(B_NUM.nextval);



commit;

select * from REPLY;