drop table RENTAMOUNT;
drop table AMOUNT;
drop table LATEFEE;
drop table RENT;
drop table VIDEO;
drop table MEMBER;
drop table CHAINSTORE;
drop table MOVIE;
drop table GRADE;
drop table JANGR;
drop sequence RENT_SEQ;
purge recyclebin;

--확인
select TNAME from TAB;
select SEQUENCE_NAME from SEQ;