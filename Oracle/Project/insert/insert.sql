------------------------------------------------------------------------
--미리 넣어둘 값
insert into SUPPLY values(1, 1, 200, 60, 400);
insert into SUPPLY values(2, 2, 300, 100, 600);
insert into SUPPLY values(3, 3, 240, 70, 350);
insert into SUPPLY values(4, 4, 330, 40, 500);
insert into SUPPLY values(5, 5, 340, 60, 630);
insert into SUPPLY values(6, 6, 150, 80, 210);
insert into SUPPLY values(7, 7, 310, 90, 730);
insert into SUPPLY values(8, 8, 200, 200, 530);
insert into SUPPLY values(9, 9, 600, 150, 1200);
insert into SUPPLY values(10, 10, 300, 100, 630);

insert into MENU values('chicken', 20000 );
insert into MENU values('alcohol', 4000);
insert into MENU values('drink', 3000);

insert into FRANCHISE values (1, '가산디지털단지점', 4.33, 2, '서울특별시 금천구 가산디지털단지로 3', '김치킨', 'PM12 ~ AM12');
insert into FRANCHISE values (2, '구로디지털단지점', 4.11, 3, '서울특별시 구로구 구로로 53', '박통닭', 'PM2 ~ PM10');
insert into FRANCHISE values (3, '가산점', 4.89, 2, '서울특별시 금천구 가산로 55', '최순살', 'AM11 ~ AM2');
insert into FRANCHISE values (4, '서울점', 3.23, 3, '서울특별시 서울구 서울로 66', '이후추', 'PM12 ~ AM12');
insert into FRANCHISE values (5, '천왕역점', 3.90, 2, '서울특별시 천왕구 천왕로 12', '강황금', 'PM3 ~ PM9');
insert into FRANCHISE values (6, '철산점', 4.35, 9, '경기 광명시 철산동 398', '노랑치킨', 'PM12 ~ AM12');
insert into FRANCHISE values (7, '부평점', 4.29, 6, '인천광역시 부평구 부평5동 24', '아웃닭', 'PM12 ~ PM11');
insert into FRANCHISE values (8, '신도림점', 3.83, 8, '서울 구로구 신도림동 435-10 대우프루지오 3차', '보들보들', 'PM1 ~ AM12');
insert into FRANCHISE values (9, '영등포점', 4.90, 7, '서울 영등포구 당산동2가 135', '맛치킨', 'PM12 ~ AM12');
insert into FRANCHISE values (10, '주안점', 4.03, 6, '인천 미추홀구 주안동 145', '뼈치킨', 'PM2 ~ AM1');

insert into EMPLOYEE values (511, '김치킨', 4900000, '사업주', 1);
insert into EMPLOYEE values (99, '박통닭', 5300000, '사업주' , 2);
insert into EMPLOYEE values (134, '최순살', 6100000, '사업주', 3);
insert into EMPLOYEE values (223, '이후추', 5500000, '사업주', 4);
insert into EMPLOYEE values (122, '강황금', 4800000, '점장' , 5);
insert into EMPLOYEE values (45, '이가나', 3200000, '매니저' , 1);
insert into EMPLOYEE values (52, '박나나', 3000000, '매니저' , 2);
insert into EMPLOYEE values (103, '김다라', 2500000, '사원' , 1);
insert into EMPLOYEE values (178, '최마바', 2700000, '사원' , 1);
insert into EMPLOYEE values (145, '강사아', 1800000, '아르바이트', 1);
insert into EMPLOYEE values (155, '손자차', 1900000, '아르바이트', 3);
insert into EMPLOYEE values (172, '정타카', 1500000, '아르바이트' , 4);
insert into EMPLOYEE values (391, '하파하', 1200000, '아르바이트', 5);
insert into EMPLOYEE values (999, '이사장', 5600000, '사업주', 6);
insert into EMPLOYEE values (998, '최사장', 5900000, '사업주' , 7);
insert into EMPLOYEE values (997, '집주인', 6100000, '사업주', 8);
insert into EMPLOYEE values (996, '안주인', 5500000, '사업주', 9);
insert into EMPLOYEE values (567, '통다리', 4800000, '점장' , 6);
insert into EMPLOYEE values (444, '이가네', 3100000, '매니저' , 6);
insert into EMPLOYEE values (445, '최가네', 3600000, '매니저' , 7);
insert into EMPLOYEE values (159, '감나라', 2600000, '사원' , 8);
insert into EMPLOYEE values (162, '배나라', 2500000, '사원' , 9);
insert into EMPLOYEE values (101, '아이유', 2000000, '아르바이트', 10);
insert into EMPLOYEE values (102, '김고은', 1950000, '아르바이트', 9);
insert into EMPLOYEE values (105, '이루다', 1600000, '아르바이트' , 6);
insert into EMPLOYEE values (104, '최박사', 1400000, '아르바이트', 7);

insert into DELICUSTOMER values (3842, '이재영', '서울특별시 강남구 도산대로 1', '010-1212-3434', SYSDATE);
insert into DELICUSTOMER values (5341, '조한영', '서울특별시 금천구 가산디지털1로 13', '010-5552-2233', SYSDATE);
insert into DELICUSTOMER values (9374, '이나영', '서울특별시 종로구 아무개로 13', '010-1122-3334', SYSDATE);
insert into DELICUSTOMER values (2012, '송보석', '서울특별시 강서구 강서로 45', '010-1552-3534', SYSDATE);
insert into DELICUSTOMER values (2038, '최대현', '서울특별시 강서구 강강로 56', '010-6485-3458', SYSDATE);
insert into DELICUSTOMER values (7492, '홍길동', '서울특별시 어쩌구 그런대로 9', '010-6953-4534', SYSDATE);
insert into DELICUSTOMER values (4752, '이순신', '서울특별시 저쩌구 치킨로 30-1', '010-0394-3452', SYSDATE);
insert into DELICUSTOMER values (5583, '조핸영', '서울특별시 서울구 서울로 6', '010-6945-3458', SYSDATE);
insert into DELICUSTOMER values (5823, '고길동', '서울특별시 부산구 해운대로 99', '010-3958-3494', SYSDATE);

insert into sales values (1 , 0 , 0 , 0 , SYSDATE);
insert into sales values (2 , 0 , 0 , 0 , SYSDATE);
insert into sales values (3 , 0 , 0 , 0 , SYSDATE);
insert into sales values (4 , 0 , 0 , 0 , SYSDATE);
insert into sales values (5 , 0 , 0 , 0 , SYSDATE);



---------------------------------------------------------------------------------
--넣으면서 테이블 변화 확인할 값

insert into INVENTORYCONTROL values (1, 1, SYSDATE, SYSDATE, 50, 50, 50);
insert into INVENTORYCONTROL values (2, 2, SYSDATE, SYSDATE, 50, 50, 50);
insert into INVENTORYCONTROL values (3, 3, SYSDATE, SYSDATE, 50, 50, 50);
insert into INVENTORYCONTROL values (4, 4, SYSDATE, SYSDATE, 50, 50, 50);
insert into INVENTORYCONTROL values (5, 5, SYSDATE, SYSDATE, 50, 50, 50);
insert into INVENTORYCONTROL values (6, 6, SYSDATE, SYSDATE, 50, 50, 50);
insert into INVENTORYCONTROL values (7, 7, SYSDATE, SYSDATE, 50, 50, 50);
insert into INVENTORYCONTROL values (8, 8, SYSDATE, SYSDATE, 50, 50, 50);
insert into INVENTORYCONTROL values (9, 9, SYSDATE, SYSDATE, 50, 50, 50);
insert into INVENTORYCONTROL values (10, 10, SYSDATE, SYSDATE, 50, 50, 50);


insert into ORDERS values (orderCount_SEQ.nextval, '방문' , 1, 5, SYSDATE, '카드', 3, 1, 3);
insert into ORDERS values (orderCount_SEQ.nextval, '방문' , 5, 10, SYSDATE, '카드', 1, 1, 1);
insert into ORDERS values (orderCount_SEQ.nextval,  3842 , 4, 2, SYSDATE, '현금', 2, 1, 5);
insert into ORDERS values (orderCount_SEQ.nextval,  5341 , 4, 1, SYSDATE, '계좌이체', 2, 2, 2);
insert into ORDERS values (orderCount_SEQ.nextval, '방문' , 3, 3, SYSDATE, '현금', 1, 2, 2);
insert into ORDERS values (orderCount_SEQ.nextval,  9374 , 4, 6, SYSDATE, '삼성페이', 2, 0, 1);
insert into ORDERS values (orderCount_SEQ.nextval, '방문' , 5, 4, SYSDATE, '카드', 2, 1, 3);
insert into ORDERS values (orderCount_SEQ.nextval,  2012 , 3, 7, SYSDATE, '삼성페이', 1, 4, 2);
insert into ORDERS values (orderCount_SEQ.nextval,  2038 , 4, 9, SYSDATE, '카카오페이', 1, 2, 1);
insert into ORDERS values (orderCount_SEQ.nextval, '방문' , 3, 8, SYSDATE, '계좌이체', 7, 1, 3);
insert into ORDERS values (orderCount_SEQ.nextval,  2038 , 2, 2, SYSDATE, '카드', 5, 2, 1);
insert into ORDERS values (orderCount_SEQ.nextval,  7492 , 5, 6, SYSDATE, '현금', 1, 6, 6);
insert into ORDERS values (orderCount_SEQ.nextval,  4752 , 4, 8, SYSDATE, '삼성페이', 1, 0, 3);
insert into ORDERS values (orderCount_SEQ.nextval, '방문' , 3, 10, SYSDATE, '카카오페이', 1, 2, 2);
insert into ORDERS values (orderCount_SEQ.nextval, '방문' , 4, 1, SYSDATE, '카카오페이', 3, 2, 6);
insert into ORDERS values (orderCount_SEQ.nextval,  5583 , 2, 5, SYSDATE, '카카오페이', 1, 2, 6);
insert into ORDERS values (orderCount_SEQ.nextval, '방문' , 4, 9, SYSDATE, '카카오페이', 6, 5, 10);
insert into ORDERS values (orderCount_SEQ.nextval,  5823 , 1, 7, SYSDATE, '카카오페이', 3, 2, 4);
insert into ORDERS values (orderCount_SEQ.nextval, '방문' , 4, 3, SYSDATE, '카카오페이', 2, 2, 3);
