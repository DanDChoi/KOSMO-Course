--DELICUSTOMER
insert into DELICUSTOMER values (3842, '이재영', '서울특별시 강남구 도산대로 1', '010-1212-3434', SYSDATE);
insert into DELICUSTOMER values (5341, '조한영', '서울특별시 금천구 가산디지털1로 13', '010-5552-2233', SYSDATE);
insert into DELICUSTOMER values (9374, '이나영', '서울특별시 종로구 아무개로 13', '010-1122-3334', SYSDATE);
insert into DELICUSTOMER values (2012, '송보석', '서울특별시 강서구 강서로 45', '010-1552-3534', SYSDATE);
insert into DELICUSTOMER values (2038, '최대현', '서울특별시 강서구 강강로 56', '010-6485-3458', SYSDATE);
insert into DELICUSTOMER values (7492, '홍길동', '서울특별시 어쩌구 그런대로 9', '010-6953-4534', SYSDATE);
insert into DELICUSTOMER values (4752, '이순신', '서울특별시 저쩌구 치킨로 30-1', '010-0394-3452', SYSDATE);
insert into DELICUSTOMER values (5583, '조핸영', '서울특별시 서울구 서울로 6', '010-6945-3458', SYSDATE);
insert into DELICUSTOMER values (5823, '고길동', '서울특별시 부산구 해운대로 99', '010-3958-3494', SYSDATE);

--CUSTOMER
insert into CUSTOMER values (6434, SYSDATE, '1차');
insert into CUSTOMER values (7542, SYSDATE, '3차');
insert into CUSTOMER values (3342, SYSDATE, '완료');
insert into CUSTOMER values (7945, SYSDATE, '미접종');
insert into CUSTOMER values (7024, SYSDATE, '완료');
insert into CUSTOMER values (2045, SYSDATE, '완료');
insert into CUSTOMER values (7704, SYSDATE, '2차');
insert into CUSTOMER values (9403, SYSDATE, '3차');
insert into CUSTOMER values (2394, SYSDATE, '완료');

--FRANCHISE
insert into FRANCHISE values (1, '가산디지털단지점', 4.33, 2, '서울특별시 금천구 가산디지털단지로 3', '김치킨', 'PM12 ~ AM12');
insert into FRANCHISE values (2, '구로디지털단지점', 4.11, 3, '서울특별시 구로구 구로로 53', '박통닭', 'PM2 ~ PM10');
insert into FRANCHISE values (3, '가산점', 4.89, 2, '서울특별시 금천구 가산로 55', '최순살', 'AM11 ~ AM2');
insert into FRANCHISE values (4, '서울점', 3.23, 3, '서울특별시 서울구 서울로 66', '이후추', 'PM12 ~ AM12');
insert into FRANCHISE values (5, '천왕역점', 3.90, 2, '서울특별시 천왕구 천왕로 12', '강황금', 'PM3 ~ PM9');

--EMPLOYEE
insert into EMPLOYEE values (511, '김치킨', 4900000, '사업주');
insert into EMPLOYEE values (99, '박통닭', 5300000, '사업주');
insert into EMPLOYEE values (134, '최순살', 6100000, '사업주');
insert into EMPLOYEE values (223, '이후추', 5500000, '사업주');
insert into EMPLOYEE values (122, '강황금', 4800000, '점장');
insert into EMPLOYEE values (45, '이가나', 3200000, '매니저');
insert into EMPLOYEE values (52, '박나나', 3000000, '매니저');
insert into EMPLOYEE values (103, '김다라', 2500000, '사원');
insert into EMPLOYEE values (178, '최마바', 2700000, '사원');
insert into EMPLOYEE values (145, '강사아', 1800000, '아르바이트');
insert into EMPLOYEE values (155, '손자차', 1900000, '아르바이트');
insert into EMPLOYEE values (172, '정타카', 1500000, '아르바이트');
insert into EMPLOYEE values (391, '하파하', 1200000, '아르바이트');

--MENU
insert into MENU values('chicken', 20000, '치킨', '후라이드치킨');
insert into MENU values('alcohol', 4000, '술', '생맥주(500cc)');
insert into MENU values('drink', 3000, '음료', '코카콜라1.5L');
--SUPPLY
insert into SUPPLY values (59234, 200, 130, 320, 3);
insert into SUPPLY values (59632, 320, 90, 300, 3);
insert into SUPPLY values (59123, 190, 70, 250, 4);
insert into SUPPLY values (56934, 370, 150, 330, 5);
insert into SUPPLY values (53949, 280, 60, 250, 2);

--INVENTORYCONTROL
insert into INVENTORYCONTROL values (3, SYSDATE, SYSDATE, 1300, 800, 2500);

--ORDERS

insert into ORDERS values (orderNumber_SEQ.nextval, 'GODJY', 3842, 43000, 'chicken', 4, 3, '배달', SYSDATE, '현금', 1, 0, 2);
insert into ORDERS values (orderNumber_SEQ.nextval, 'JOE', 5341, 50000, 'chicken', 4, 2, '방문', SYSDATE, '카카오페이', 2, 1, 3);
insert into ORDERS values (orderNumber_SEQ.nextval, 'Nayoung_GOD', 9374, 90000, 'chicken', 5, 1, '배달', SYSDATE, '카드', 2, 1, 3);
insert into ORDERS values (orderNumber_SEQ.nextval, 'Jewelry_SONG', 2012, 53000, 'drink', 3, 4, '배달', SYSDATE, '삼성페이', 5, 0, 2);
insert into ORDERS values (orderNumber_SEQ.nextval, 'CHOOOOOI', 2038, 86000, 'alcohole', 4, 4, '방문', SYSDATE, '카드', 2, 10, 2);
insert into ORDERS values (orderNumber_SEQ.nextval, 'HKD', 7492, 223000, 'chicken', 2, 2, '배달', SYSDATE, '카드', 5, 2, 10);
insert into ORDERS values (orderNumber_SEQ.nextval, 'LEESS', 4752, 86000, 'alcohole', 4, 3, '방문', SYSDATE, '현금', 2, 0, 4);
insert into ORDERS values (orderNumber_SEQ.nextval, 'HAEEN', 5583, 23000, 'drink', 5, 5, '배달', SYSDATE, '카드', 1, 0, 1);
insert into ORDERS values (orderNumber_SEQ.nextval, 'Go_GD', 5823, 135000, 'chicken', 4, 5, '배달', SYSDATE, '카드', 5, 5, 5);


--VISIT
insert into VISIT values (25, 9374, '후라이드치킨', 0, 0, 1, 20000, 4, '카드');
insert into VISIT values (12, 2038, '후라이드치킨(2), 코카콜라', 1, 0, 2, 43000, 2, '계좌이체');
insert into VISIT values (14, 5583, '후라이드치킨(2), 코카콜라', 1, 0, 2, 43000, 1, '계좌이체');

--DELIVERY
insert into DELIVERY values (24, 3842, 3, '이재영', '후라이드치킨(2), 코카콜라', 1, 0, 2, 43000, '서울특별시 강남구 도산대로 1', '010-1212-3434', '현금');
insert into DELIVERY values (34, 5341, 4, '조한영', '후라이드치킨, 코카콜라', 1, 0, 1, 23000,'서울특별시 금천구 가산디지털1로 13', '010-5552-2233', '카카오페이');
insert into DELIVERY values (30, 7492, 5, '홍길동', '후라이드치킨, 코카콜라', 1, 0, 2, 23000, '서울특별시 어쩌구 그런대로 9', '010-6953-4534', '현금');
insert into DELIVERY values (39, 5823, 2, '고길동', '후라이드치킨, 코카콜라', 1, 0, 2, 23000, '서울특별시 부산구 해운대로 99', '010-3958-3494', '현금');

--RESERVATION
insert into RESERVATION values (2, 38, 1, 2012, SYSDATE, '010-1552-3534', 4, '카드');
insert into RESERVATION values (5, 31, 5, 4752, SYSDATE, '010-0394-3452', 3, '삼성페이');

--SALES
insert into SALES values (1, '25, 38, 14', 123000, SYSDATE, '후라이드치킨');
insert into SALES values (2, '12, 39', 66000, SYSDATE, '후라이드치킨');
insert into SALES values (3, '24', 43000, SYSDATE, '후라이드치킨');
insert into SALES values (4, '34', 23000, SYSDATE, '후라이드치킨');
insert into SALES values (5, '30, 31', 87000, SYSDATE, '후라이드치킨');


select EMPNO, DNAME from EMP natural join DEPT; 

select orderNumber, ID, FranchiseNumber, customerNumber, drinkCount, 
alcholeCount, chickenCount, customercost, Loc, customerPhonenumber, payment
from ORDERS natural join DELICUSTOMER;



select * from EMPLOYEE;
select * from FRANCHISE;
select * from MENU;
select * from INVENTORYCONTROL;
select * from ORDERS;
select * from DELICUSTOMER;
select * from ORDERSBACKUP;
select * from DELIVERY;
select * from RESERVATION;
select * from SUPPLY;
select * from SALES;
select * from VISIT;

/*
--SUPPLYCOMPANY
insert into SUPPLYCOMPANY values (4323, 1, '서울특별시 금천구 가산디지털단지로 3', 200, 1);
insert into SUPPLYCOMPANY values (4325, 1, '서울특별시 금천구 가산디지털단지로 3', 100, 2);
insert into SUPPLYCOMPANY values (4562, 2, '서울특별시 구로구 구로로 53', 300, 1);
insert into SUPPLYCOMPANY values (4567, 2, '서울특별시 구로구 구로로 53', 50, 3);
insert into SUPPLYCOMPANY values (4112, 3, '서울특별시 금천구 가산로 55', 500, 1);
insert into SUPPLYCOMPANY values (4788, 4, '서울특별시 서울구 서울로 66', 120, 1);
insert into SUPPLYCOMPANY values (4785, 4, '서울특별시 서울구 서울로 66', 10, 2);
insert into SUPPLYCOMPANY values (5001, 5, '서울특별시 천왕구 천왕로 12', 70, 1);
insert into SUPPLYCOMPANY values (5023, 5, '서울특별시 천왕구 천왕로 12', 30, 3);
*/



