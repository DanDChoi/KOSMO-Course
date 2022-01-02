
create table SUPPLY( --납품 //                           
   supplyNumber number(10) not null, --납품번호 PK
   FranchiseNumber number(5) not null, --가맹점번호
   drinkCount number(5) default 0,     --음료재고
   alcoholCount number(5) default 0,   --술재고
   chickenCount number(10) default 0   --치킨재고
);
alter table SUPPLY add constraint Supply_PK primary key(supplyNumber);


create table MENU(  
   menuName nvarchar2(30) not null check(menuName in('drink' , 'chicken' , 'alcohol')), --메뉴이름 PK
   price number(20) not null --가격  
);
alter table MENU add constraint menuName_PK primary key(menuName);


create table FRANCHISE(  --가맹점 
   FranchiseNumber number(5) not null,                  --가맹점번호 PK
   FranchiseName nvarchar2(30) not null,                --지점명
   star number(5,2) ,                                   --평점
   employeeCount number(2) not null,                    --직원수
   FLoc nvarchar2(200) not null,                        --가맹점 주소
   businessOwner nvarchar2(20) default '점장',           --사업주
   businesshours nvarchar2(40) default 'AM 11시00 ~ AM 1시00' --영업시간
);
alter table FRANCHISE add constraint Franchise_PK primary key(FranchiseNumber);


create table EMPLOYEE(  --직원
   employeeNumber number(10) not null,--직원번호 PK
   employeeName nvarchar2(20) not null, --직원이름
   salary number(20),                   --급여
   position nvarchar2(30) not null check(position in( '아르바이트', '사원', '매니저','점장', '사업주')), --직급
   FranchiseNumber number(5) not null --가맹점번호 FK
);

alter table EMPLOYEE add constraint Employee_PK primary key(employeeNumber);
alter table EMPLOYEE add constraint Employee_FK foreign key(FranchiseNumber) references FRANCHISE(FranchiseNumber);

create table INVENTORYCONTROL(  --재고관리
   supplyNumber number(10) not null,        --재고번호 PK, FK
   FranchiseNumber number(5) not null,      --가맹점번호 FK
   warehousingDATE DATE default SYSDATE not null, --입고일
   useDATE DATE default SYSDATE not null,         --사용일
   drinkCount number(5) default 0,                --음료재고
   alcoholCount number(5) default 0,              --술재고
   chickenCount number(10) default 0              --치킨재고
);

alter table INVENTORYCONTROL add constraint supplyNumber_PK primary key(supplyNumber);
alter table INVENTORYCONTROL add constraint supplyNumber_FK foreign key(supplyNumber) references SUPPLY(supplyNumber);
alter table INVENTORYCONTROL add constraint FranchiseNumber_FK foreign key(FranchiseNumber) references FRANCHISE(FranchiseNumber); -- 프렌차이즈 테이블 먼저 생성 후 하기!

create table ORDERS(  -- 주문   
   orderNumber number(8) not null,          --주문번호 PK, SEQ
   ID nvarchar2(40) default '방문' not null,             -- 고객번호
   star number(1) check(star in( 1 , 2 , 3 , 4 , 5)),   --평점
   FranchiseNumber number(5) not null,                  -- 가맹점번호 FK
   orderDATE DATE default SYSDATE,                      -- 주문(방문)일자
   payment nvarchar2(50) not null check(payment in('현금' , '카드' , '계좌이체' , '삼성페이' , '카카오페이' )), --결제방식
   drinkCount number(5)  default 0,     --주문한 음료 수량
   alcoholCount number(5)  default 0,   --주문한 술 수량
   chickenCount number(5)  default 0    --주문한 치킨 수량
);

alter table ORDERS add constraint orders_PK primary key(orderNumber);
alter table ORDERS add constraint orders_FranchiseNumber_FK foreign key(FranchiseNumber) references FRANCHISE(FranchiseNumber);
create sequence orderCount_SEQ increment by 1 start with 1 nocache;


create table DELICUSTOMER(  -- 이미가입된 배달전용 고객 데이터
        ID nvarchar2(40) not null,          --고객번호 PK
        customerName nvarchar2(40) not null, --고객이름
        Loc nvarchar2(200) ,                -- 고객주소
        customerPhonenumber nvarchar2(80) , -- 고객전화번호
        joinDATE DATE default SYSDATE       -- 가입날짜      
);
alter table DELICUSTOMER add constraint DELICUSTOMER_PK primary key(ID);

create table VISIT( --방문고객 주문
   orderNumber number(8) not null, --주문번호 PK, FK, SEQ
   drinkCount number(5)  default 0,  --주문한 음료 수량
   alcoholCount number(5)  default 0,  --주문한 술 수량 
   chickenCount number(10)  default 0, --주문한 치킨 수량
   customercost number(20) not null, --결제금액
   FranchiseNumber number(5) not null, -- 가맹점 번호
   payment nvarchar2(50) not null check(payment in('현금' , '카드' , '계좌이체' , '삼성페이' , '카카오페이' )),
   orderDATE DATE --주문날짜
);
alter table VISIT add constraint Visit_PK primary key(orderNumber);
alter table VISIT add constraint Visit_FK foreign key(orderNumber) references ORDERS(orderNumber) on delete cascade;


create table DELIVERY( --배달고객 주문
   orderNumber number(8) not null,      --주문번호 PK, FK, SEQ
   ID nvarchar2(40) not null,           --고객번호 FK
   FranchiseNumber number(5) not null,  --가맹점번호
   drinkCount number(5)  default 0,  --주문한 음료 수량
   alcoholCount number(5)  default 0,   --주문한 술 수량
   chickenCount number(10)  default 0,  --주문한 치킨 수량
   customercost number(20) not null, -- 결제금액
   Loc nvarchar2(200) not null, -- 고객주소
   customerPhonenumber nvarchar2(80) not null , -- 고객번호
   payment nvarchar2(50) not null check(payment in('현금' , '카드' , '계좌이체' , '삼성페이' , '카카오페이' )), --결제방식
   orderDATE DATE --주문날짜
);
alter table DELIVERY add constraint DELIVERY_PK primary key(orderNumber);
alter table DELIVERY add constraint DELIVERY_FK foreign key(orderNumber) references ORDERS on delete cascade;
alter table DELIVERY add constraint DELIVERY_ID_FK foreign key(ID) references DELICUSTOMER(ID);

create table SALES( --매출 테이블 
   FranchiseNumber number(5) not null, --가맹점번호 PK
   lastorderNumber number(8) not null, --가맹점번호
   f_totsal number(20) not null, --매출액
   f_daysal number(20) not null, -- 당일 매출액
   orderDATE DATE --날짜
);
alter table SALES add constraint FranchiseNumber_PK primary key(FranchiseNumber);





