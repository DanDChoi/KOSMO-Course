 --치료받은 강아지들의 치료코드와 진료번호 확인
select MD_DATE, T_CODE from MEDICAL where MD_SEC='치료';

--''번 영수증의 치료비 업데이트
update BILL set B_TCOST=(select T_COST from TREAT where T_CODE ='t08') 
where MD_DATE='210621114848';

select * from BILL;

