실행창: sqlplus / as sysdba

create user scott identified by tiger;
grant connect, resource, unlimited tablespace to scott;
show user;

conn scott/tiger;
show user;
select * from tab;