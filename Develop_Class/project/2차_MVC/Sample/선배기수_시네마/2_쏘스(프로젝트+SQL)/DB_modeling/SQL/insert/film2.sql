INSERT INTO FILM(FILM_ID, FILM_TITLE,FILM_TITLE_ENG, FILM_CONTENT, GENRE_ID, MATERIAL_ID,DIRECTOR_ID,
ACTOR_ID1,ACTOR_ID2,ACTOR_ID3, FILM_POSTER, FILM_GRADE_NAVER, RUNNING_TIME) 
VALUES(FILM_SEQ.nextval, 
'로미오와 줄리엣(1968)', 'Romeo And Juliet', '비슷한 품위의 두 집안은 이 이야기가 전개되는 아름다운 베로나에서 오래전의 원한이 새로운 문제를 야기하는, 예의바른 사람들의 피가 예의바른 사람들의 손을 더럽게 한다.', 
4,13,
(select DIRECTOR_ID from Director where DIRECTOR_NAME='프랑코 제페렐리'), 
(select ACTOR_ID from ACTOR where ACTOR_NAME='올리비아 핫세'), 
(select ACTOR_ID from ACTOR where ACTOR_NAME='레너드 위팅'), 
(select ACTOR_ID from ACTOR where ACTOR_NAME='존 맥에너리'),
'로미오와 줄리엣.jpg', 9.2, 124
);

INSERT INTO FILM(FILM_ID, FILM_TITLE,FILM_TITLE_ENG, FILM_CONTENT, GENRE_ID, MATERIAL_ID,DIRECTOR_ID,
ACTOR_ID1,ACTOR_ID2,ACTOR_ID3, FILM_POSTER, FILM_GRADE_NAVER, RUNNING_TIME) 
VALUES(FILM_SEQ.nextval, 
'갓파 쿠와 여름방학을', 'Summer Days With Coo', ' 돌에서 환상의 동물 갓파가 깨어나고, ‘코이치’ 가족들은 그에게 ‘쿠’라는 새로운 이름을 붙여준다. 이렇게 한 식구가 된 그들은 즐겁고 신나는 여름날을 보낸다.',
11,9,
(select DIRECTOR_ID from Director where DIRECTOR_NAME='하라 케이이치'), 
(select ACTOR_ID from ACTOR where ACTOR_NAME='쿠'), 
(select ACTOR_ID from ACTOR where ACTOR_NAME='코이치'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='히토미'),
'갓파 쿠와 여름방학을.jpg', 9.2, 138
);

INSERT INTO FILM(FILM_ID, FILM_TITLE,FILM_TITLE_ENG, FILM_CONTENT, GENRE_ID, MATERIAL_ID,DIRECTOR_ID,
ACTOR_ID1,ACTOR_ID2,ACTOR_ID3, FILM_POSTER, FILM_GRADE_NAVER, RUNNING_TIME) 
VALUES(FILM_SEQ.nextval, 
'코코(2017)', 'Coco', '영원히 기억하고 싶은 황홀한 모험이 시작된다! 뮤지션을 꿈꾸는 소년 미구엘은 전설적인 가수 에르네스토의 기타에 손을 댔다  죽은 자들의 세상에 들어가게 된다. ',
11,9,
(select DIRECTOR_ID from Director where DIRECTOR_NAME='리 언크리치'), 
(select ACTOR_ID from ACTOR where ACTOR_NAME='미구엘'), 
(select ACTOR_ID from ACTOR where ACTOR_NAME='헥터'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='에르네스토 델라 크루즈'),
'코코.jpg', 9.2, 127);

INSERT INTO FILM(FILM_ID, FILM_TITLE,FILM_TITLE_ENG, FILM_CONTENT, GENRE_ID, MATERIAL_ID,DIRECTOR_ID,
ACTOR_ID1,ACTOR_ID2,ACTOR_ID3, FILM_POSTER, FILM_GRADE_NAVER, RUNNING_TIME) 
VALUES(FILM_SEQ.nextval, 
'인크레더블2(2018)', 'Incredible2', '각자의 위치에서 바쁜 일상을 보내던 슈퍼파워 가족 앞에 새로운 악당이 나타났다 ',
11,9 ,
(select DIRECTOR_ID from Director where DIRECTOR_NAME='브래드 버드'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='밥 파'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='헬렌 파'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='루이스 베스트'),
'인크레더블2.jpg', 9.2,125 );

INSERT INTO FILM(FILM_ID, FILM_TITLE,FILM_TITLE_ENG, FILM_CONTENT, GENRE_ID, MATERIAL_ID,DIRECTOR_ID,
ACTOR_ID1,ACTOR_ID2,ACTOR_ID3, FILM_POSTER, FILM_GRADE_NAVER, RUNNING_TIME) 
VALUES(FILM_SEQ.nextval, 
'엽문(2008)', 'The Legend Of Ip Man', '엽문은 제자를 받아들이지 않겠다던 자신의 신념을 버리고 국민들이 일본으로부터 자신의 몸을 지킬 수 있도록 무예를 가르치며, 중국의 자존심을 되찾기 위해 자신의 무술로 일본에 저항한다.',
9,19 ,
(select DIRECTOR_ID from Director where DIRECTOR_NAME='엽위신'), 
(select ACTOR_ID from ACTOR where ACTOR_NAME='견자단'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='임달화'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='슝다이린'),
'엽문.jpg', 9.2, 106);

INSERT INTO FILM(FILM_ID, FILM_TITLE,FILM_TITLE_ENG, FILM_CONTENT, GENRE_ID, MATERIAL_ID,DIRECTOR_ID,
ACTOR_ID1,ACTOR_ID2,ACTOR_ID3, FILM_POSTER, FILM_GRADE_NAVER, RUNNING_TIME) 
VALUES(FILM_SEQ.nextval, 
'스팅(1973)', 'The Sting', '노름의 명수 후커는 두목의 죽음에 복수하기 위해 콘도르프와 손잡고 거물 로네간을 골탕 먹일 계획을 세운다 .',
8, 25,
(select DIRECTOR_ID from Director where DIRECTOR_NAME='조지 로이 힐'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='폴 뉴먼'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='로버트 레드포드'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='로버트 쇼'),
'스팅.jpg', 9.2,129);

INSERT INTO FILM(FILM_ID, FILM_TITLE,FILM_TITLE_ENG, FILM_CONTENT, GENRE_ID, MATERIAL_ID,DIRECTOR_ID,
ACTOR_ID1,ACTOR_ID2,ACTOR_ID3, FILM_POSTER, FILM_GRADE_NAVER, RUNNING_TIME) 
VALUES(FILM_SEQ.nextval, 
'오즈의 마법사(1939)', 'The Wizard Of Oz', '회오리 바람에 휩쓸려 오즈의 나라로 내던져진 도로시(Dorothy Gale: 주디 가랜드 분)는 집으로 되돌아갈 수 있는 유일한 길이 위대한 오즈의 마법사를 만나는 것임을 알고 그를 찾아 긴 여정이 시작된다.',
2, 9,
(select DIRECTOR_ID from Director where DIRECTOR_NAME='빅테 플레밍'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='주디 갈랜드'), 
(select ACTOR_ID from ACTOR where ACTOR_NAME='프랭크 모건'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='레이 볼거'),
'오즈의 마법사.jpg', 9.2, 112);

INSERT INTO FILM(FILM_ID, FILM_TITLE,FILM_TITLE_ENG, FILM_CONTENT, GENRE_ID, MATERIAL_ID,DIRECTOR_ID,
ACTOR_ID1,ACTOR_ID2,ACTOR_ID3, FILM_POSTER, FILM_GRADE_NAVER, RUNNING_TIME) 
VALUES(FILM_SEQ.nextval, 
'나, 다니엘 블레이크(2016)', ' I, Daniel Blake', '평범한 이웃 사촌, 당신은 내게 영웅입니다. 평생을 성실하게 목수로 살아가던 다니엘은 지병인 심장병이 악화되어 일을 계속 해나갈 수 없는 상황이 된다.',
1, 26,
(select DIRECTOR_ID from Director where DIRECTOR_NAME='켄 로치'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='데이브 존스'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='헤일리 스콰이어'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='샤론 퍼시'),
'나, 다니엘 블레이크.jpg', 9.2, 100);

INSERT INTO FILM(FILM_ID, FILM_TITLE,FILM_TITLE_ENG, FILM_CONTENT, GENRE_ID, MATERIAL_ID,DIRECTOR_ID,
ACTOR_ID1,ACTOR_ID2,ACTOR_ID3, FILM_POSTER, FILM_GRADE_NAVER, RUNNING_TIME) 
VALUES(FILM_SEQ.nextval, 
'크루즈 패밀리(2013)', 'The Croods', '동굴 밖에 온갖 위험이 도사리고 있다고 믿고 있는 아빠 ‘그루그(니콜라스 케이지)’는 해가 지면 어느 누구도 밖으로 나갈 수 없게 한다. 하지만 어느 날 동굴이 무너지는 초유의 사태가 발생하고, 크루즈 패밀리는 새로운 보금자리를 찾아 난생처음 세상에 발을 디디게 된다.',
11, 9 ,
(select DIRECTOR_ID from Director where DIRECTOR_NAME='커크 드 미코'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='그루그'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='가이'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='이프'),
'크루즈 패밀리.jpg', 9.2, 98);

INSERT INTO FILM(FILM_ID, FILM_TITLE,FILM_TITLE_ENG, FILM_CONTENT, GENRE_ID, MATERIAL_ID,DIRECTOR_ID,
ACTOR_ID1,ACTOR_ID2,ACTOR_ID3, FILM_POSTER, FILM_GRADE_NAVER, RUNNING_TIME) 
VALUES(FILM_SEQ.nextval, 
'우리들 (2015)', 'THE WORLD OF US', '제나 혼자인 외톨이 선은 모두가 떠나고 홀로 교실에 남아있던 방학식 날, 전학생 지아를 만난다.  서로의 비밀을 나누며 순식간에 세상 누구보다 친한 사이가 된 선과 지아는 생애 가장 반짝이는 여름을 보내는데, 개학 후 학교에서 만난 지아는 어쩐 일인지 선에게 차가운 얼굴을 하고 있다.',
1, 26,
(select DIRECTOR_ID from Director where DIRECTOR_NAME='윤가은'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='최수인'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='설혜인'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='이서연'),
'우리들.jpg', 9.2, 94);


INSERT INTO FILM(FILM_ID, FILM_TITLE,FILM_TITLE_ENG, FILM_CONTENT, GENRE_ID, MATERIAL_ID,DIRECTOR_ID,
ACTOR_ID1,ACTOR_ID2,ACTOR_ID3, FILM_POSTER, FILM_GRADE_NAVER, RUNNING_TIME) 
VALUES(FILM_SEQ.nextval, 
'해바라기(2006)', 'Sunflower', ' 해바라기 식당 모녀를 제외한 모두는 태식을 믿지 않는다. 그리고 그 차가운 불신의 끝에서 아무도 상상 못 한 절망의 역습이 시작되고 있었다',
9, 19,
(select DIRECTOR_ID from Director where DIRECTOR_NAME='강석범'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='김래원'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='김해숙'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='이서연'),
'해바라기.jpg', 9.2, 116);

INSERT INTO FILM(FILM_ID, FILM_TITLE,FILM_TITLE_ENG, FILM_CONTENT, GENRE_ID, MATERIAL_ID,DIRECTOR_ID,
ACTOR_ID1,ACTOR_ID2,ACTOR_ID3, FILM_POSTER, FILM_GRADE_NAVER, RUNNING_TIME) 
VALUES(FILM_SEQ.nextval, 
'보루토 - 나루토 더 무비(2015)', 'BORUTO -NARUTO THE MOVIE-', '오랜 세월에 걸친 전쟁이 끝나고 고도성장을 이룬 새 시대, 평화의 시대를 이끌고 있는 것은 전설이 된 7대 호카게 우즈마키 나루토다. 분신술로도 감당하지 못할 만큼 바쁜 나날을 보내는 중에 나뭇잎 마을에서는 다섯 마을 통합으로 개최되는 중급닌자 선발시험이 한창이다.',
11, 10,
(select DIRECTOR_ID from Director where DIRECTOR_NAME='야마시타 히로유키'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='우즈마키 보루토'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='우치하 사라다'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='우즈마키 나루토'),
'보루토.jpg', 9.2,95);

INSERT INTO FILM(FILM_ID, FILM_TITLE,FILM_TITLE_ENG, FILM_CONTENT, GENRE_ID, MATERIAL_ID,DIRECTOR_ID,
ACTOR_ID1,ACTOR_ID2,ACTOR_ID3, FILM_POSTER, FILM_GRADE_NAVER, RUNNING_TIME) 
VALUES(FILM_SEQ.nextval, 
'쿨 러닝(1993)', 'Cool Runnings', '데리스는 우연히 단거리 선수가 동계올림픽의 봅슬레이 종목에 강하다는 사실을 알게 되자, 자신의 재미있는 단짝 친구 상카(Sanka Coffie: 더그 E. 더그 분)와 함께, 이 곳에 정착한 왕년의 금메달리스트 아이브 블리처(Irv: 존 캔디 분)를 찾아가 코치가 되어 줄 것을 부탁한다.',
1, 21,
(select DIRECTOR_ID from Director where DIRECTOR_NAME='존 터틀다웁'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='리온'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='더그 E 더그'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='롤 D 루이스'),
'쿨 러닝.jpg', 9.2, 95);

INSERT INTO FILM(FILM_ID, FILM_TITLE,FILM_TITLE_ENG, FILM_CONTENT, GENRE_ID, MATERIAL_ID,DIRECTOR_ID,
ACTOR_ID1,ACTOR_ID2,ACTOR_ID3, FILM_POSTER, FILM_GRADE_NAVER, RUNNING_TIME) 
VALUES(FILM_SEQ.nextval, 
'피아니스트의 전설(1998)', 'The Legend Of 1900', '트럼펫주자 맥스는 맨하탄의 허름한 악기점에 자신의 오래된 트럼펫을 팔려고 온다. 그런데, 그곳에서 오래 전 헤어졌던 친구 ‘나인틴 헌드레드’의 피아노 연주가 담긴 낡은 음반을 발견한다. 그리고 그는 악기점 주인에게 친구에 관한 전설적인 이야기를 들려주며 회상에 잠긴다.',
1, 20,
(select DIRECTOR_ID from Director where DIRECTOR_NAME='쥬세페 토르나토레'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='팀 로스'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='프루이트 테일러 빈스'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='멜라니 티에리'),
'피아니스트의 전설.jpg', 9.2, 123);

INSERT INTO FILM(FILM_ID, FILM_TITLE,FILM_TITLE_ENG, FILM_CONTENT, GENRE_ID, MATERIAL_ID,DIRECTOR_ID,
ACTOR_ID1,ACTOR_ID2,ACTOR_ID3, FILM_POSTER, FILM_GRADE_NAVER, RUNNING_TIME) 
VALUES(FILM_SEQ.nextval, 
'광해, 왕이 된 남자(2012)', 'Masquerade', '왕위를 둘러싼 권력 다툼과 붕당정치로 혼란이 극에 달한 광해군 8년. 자신의 목숨을 노리는 자들에 대한 분노와 두려움으로 점점 난폭해져 가던 왕 ‘광해’는 도승지 ‘허균’에게 자신을 대신하여 위협에 노출될 대역을 찾을 것을 지시한다.',
1,21,
(select DIRECTOR_ID from Director where DIRECTOR_NAME='추창민'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='이병헌'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='한효주'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='류승룡'),
'광해.jpg', 9.2,131);

INSERT INTO FILM(FILM_ID, FILM_TITLE,FILM_TITLE_ENG, FILM_CONTENT, GENRE_ID, MATERIAL_ID,DIRECTOR_ID,
ACTOR_ID1,ACTOR_ID2,ACTOR_ID3, FILM_POSTER, FILM_GRADE_NAVER, RUNNING_TIME) 
VALUES(FILM_SEQ.nextval, 
'명탐정 코난 : 천공의 난파선(2010)', 'Detective Conan: The Lost Ship in the Sky', '애니메이션 명쾌한 추리와 시원한 액션으로 사건을 해결했던 코난. 이번에는 세계 최대 비행선에서 벌어지는 사건에 휘말리게 된다.',
11,16,
(select DIRECTOR_ID from Director where DIRECTOR_NAME='야마모토 야스이치로'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='에도가와 코난'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='모리 란'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='쿠도 신이치'),
'명탐정코난-천공의 난파선.jpg', 9.2,103);

INSERT INTO FILM(FILM_ID, FILM_TITLE,FILM_TITLE_ENG, FILM_CONTENT, GENRE_ID, MATERIAL_ID,DIRECTOR_ID,
ACTOR_ID1,ACTOR_ID2,ACTOR_ID3, FILM_POSTER, FILM_GRADE_NAVER, RUNNING_TIME) 
VALUES(FILM_SEQ.nextval,'빽 투 더 퓨처2(1989)','Back To The Future Part 2','브라운 박사(Dr. Emmett Doc L. Brown: 코리스토퍼 로이드 분)와 30년 후의 미래로 온 마티(Marty McFly: 마이클 J. 폭스 분)와 제니퍼(Jennifer Parker: 엘리자베스 슈 분). 그러나 제니퍼는 타임머쉰과 미래세계에 자신이 있음에 놀라 기절한다. ',
14, 14,
(select DIRECTOR_ID from Director where DIRECTOR_NAME='로버트 저메키스'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='마이클 J 폭스'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='크리스토퍼 로이드'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='리 톰슨'),
'빽 투 더 퓨처2.jpg',9.2, 107);

INSERT INTO FILM(FILM_ID, FILM_TITLE,FILM_TITLE_ENG, FILM_CONTENT, GENRE_ID, MATERIAL_ID,DIRECTOR_ID,
ACTOR_ID1,ACTOR_ID2,ACTOR_ID3, FILM_POSTER, FILM_GRADE_NAVER, RUNNING_TIME) 
VALUES(FILM_SEQ.nextval,'어느 가족(2018)','Shoplifters','할머니의 연금과 물건을 훔쳐 생활하며 가난하지만 웃음이 끊이지 않는 어느 가족.  우연히 길 위에서 떨고 있는 한 소녀를 발견하고 집으로 데려와 가족처럼 함께 살게 된다.',
1,9,
(select DIRECTOR_ID from Director where DIRECTOR_NAME='고레에다 히로카즈'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='릴리 프랭키'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='안도 사쿠라'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='마츠오카 마유'),
'어느 가족.jpg',9.2,121);

INSERT INTO FILM(FILM_ID, FILM_TITLE,FILM_TITLE_ENG, FILM_CONTENT, GENRE_ID, MATERIAL_ID,DIRECTOR_ID,
ACTOR_ID1,ACTOR_ID2,ACTOR_ID3, FILM_POSTER, FILM_GRADE_NAVER, RUNNING_TIME) 
VALUES(FILM_SEQ.nextval,'극장판 헬로카봇 : 백악기 시대 (2018)','Hello Carbot the Movie: The Cretaceous Period',' 공룡파크의 VR 영상 속에서 진짜 공룡이 나타났다?! 이유를 알아보기 위해 백악기 시대로 시간 이동을 한 차탄!',
11, 10,
(select DIRECTOR_ID from Director where DIRECTOR_NAME='최신규'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='차탄'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='스톰'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='장군'),
'헬로카봇.jpg',9.2,84);

INSERT INTO FILM(FILM_ID, FILM_TITLE,FILM_TITLE_ENG, FILM_CONTENT, GENRE_ID, MATERIAL_ID,DIRECTOR_ID,
ACTOR_ID1,ACTOR_ID2,ACTOR_ID3, FILM_POSTER, FILM_GRADE_NAVER, RUNNING_TIME) 
VALUES(FILM_SEQ.nextval,'8월의 크리스마스(1998)','Chrismas In August','변두리 사진관에서 아버지를 모시고 사는 노총각 ‘정원’. 시한부 인생을 받아들이고 가족, 친구들과 담담한 이별을 준비하던 어느 날, 주차단속요원 다림을 만나게 되고 차츰 평온했던 일상이 흔들리기 시작한다.',
4, 13,
(select DIRECTOR_ID from Director where DIRECTOR_NAME='허진호'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='한석규'), 
(select ACTOR_ID from ACTOR where ACTOR_NAME='심은하'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='신구'),
'8월의 크리스마스.jpg',9.2,97);

INSERT INTO FILM(FILM_ID, FILM_TITLE,FILM_TITLE_ENG, FILM_CONTENT, GENRE_ID, MATERIAL_ID,DIRECTOR_ID,
ACTOR_ID1,ACTOR_ID2,ACTOR_ID3, FILM_POSTER, FILM_GRADE_NAVER, RUNNING_TIME) 
VALUES(FILM_SEQ.nextval,'마지막 황제(1987)','The Last Emperor','1950년 44세의 푸이는 소련군의 감시 아래 중국인 전쟁범 800명과 함께 조국으로 돌아가면서 자기비판의 생애를 기록하며 황제였던 과거를 회상한다.',
1, 21,
(select DIRECTOR_ID from Director where DIRECTOR_NAME='베르나르도 베르톨루치'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='존 론'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='조안 첸'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='피터 오툴'),
'마지막 황제.jpg',9.2,162);

INSERT INTO FILM(FILM_ID, FILM_TITLE,FILM_TITLE_ENG, FILM_CONTENT, GENRE_ID, MATERIAL_ID,DIRECTOR_ID,
ACTOR_ID1,ACTOR_ID2,ACTOR_ID3, FILM_POSTER, FILM_GRADE_NAVER, RUNNING_TIME) 
VALUES(FILM_SEQ.nextval,'킹콩을 들다(2009)','Lifting Kingkong',' 88올림픽 역도 동메달리스트였지만 부상으로 운동을 그만둔 후 시골여중 역도부 코치로 내려온 이지봉(이범수 분). 역도선수에게 남는 건 부상과 우락부락한 근육뿐이라며 역도에 이골 난 그가 가진 거라곤 힘 밖에 없는 시골소녀들을 만났다.',
8, 7,
(select DIRECTOR_ID from Director where DIRECTOR_NAME='박건용'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='이범수'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='조안'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='이윤희'),
'킹콩을 들다.jpg',9.2,120);

INSERT INTO FILM(FILM_ID, FILM_TITLE,FILM_TITLE_ENG, FILM_CONTENT, GENRE_ID, MATERIAL_ID,DIRECTOR_ID,
ACTOR_ID1,ACTOR_ID2,FILM_POSTER, FILM_GRADE_NAVER, RUNNING_TIME) 
VALUES(FILM_SEQ.nextval,'님아, 그 강을 건너지 마오(2014)','My Love, Dont Cross That River','89세 소녀감성 강계열 할머니, 98세 로맨티스트 조병만 할아버지 두 분은 어딜 가든 고운 빛깔의 커플 한복을 입고 두 손을 꼭 잡고 걷는 노부부이다.',
7, 21,
(select DIRECTOR_ID from Director where DIRECTOR_NAME='진모영'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='조병만'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='강계열'),
'님아, 그 강을 건너지 마오.jpg',9.2,86);

INSERT INTO FILM(FILM_ID, FILM_TITLE,FILM_TITLE_ENG, FILM_CONTENT, GENRE_ID, MATERIAL_ID,DIRECTOR_ID,
ACTOR_ID1,ACTOR_ID2,ACTOR_ID3, FILM_POSTER, FILM_GRADE_NAVER, RUNNING_TIME) 
VALUES(FILM_SEQ.nextval,'뮬란(1998)','Mulan','아름다운 영웅 뮬란이 다시 한번 용맹을 발휘하여 황제와 나라를 구하게 되고, 황제는 수많은 백성 앞에서 뮬란을 영웅으로 대접한다.',
11, 21,
(select DIRECTOR_ID from Director where DIRECTOR_NAME='토니 밴크로프트'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='뮬란'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='리 샹'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='흉노족 칸'),
'뮬란.jpg',9.2,88);

INSERT INTO FILM(FILM_ID, FILM_TITLE,FILM_TITLE_ENG, FILM_CONTENT, GENRE_ID, MATERIAL_ID,DIRECTOR_ID,
ACTOR_ID1,ACTOR_ID2,ACTOR_ID3, FILM_POSTER, FILM_GRADE_NAVER, RUNNING_TIME) 
VALUES(FILM_SEQ.nextval,'가타카(1997)','Gattaca ','인간을 지배하는 블루빛 테크놀로지의 세계- 가타카에 오신걸 환영합니다. | SF와 스릴러의 완벽한 유전자 조합이 시작된다.',
14, 14,
(select DIRECTOR_ID from Director where DIRECTOR_NAME='앤드류 니콜'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='에단 호크'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='우마 서먼'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='앨런 아킨'),
'가타카.jpg',9.2,106);

INSERT INTO FILM(FILM_ID, FILM_TITLE,FILM_TITLE_ENG, FILM_CONTENT, GENRE_ID, MATERIAL_ID,DIRECTOR_ID,
ACTOR_ID1,ACTOR_ID2,ACTOR_ID3, FILM_POSTER, FILM_GRADE_NAVER, RUNNING_TIME) 
VALUES(FILM_SEQ.nextval,'뷰티풀 마인드(2001)','A Beautiful Mind','40년대 최고의 엘리트들이 모이는 프린스턴 대학원. 시험도 보지 않고 장학생으로 입학한 웨스트버지니아 출신의 한 천재가 캠퍼스를 술렁이게 만든다. ',
1, 9,
(select DIRECTOR_ID from Director where DIRECTOR_NAME='론 하워드'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='러셀 크로우'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='에드 해리스'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='제니퍼 코넬리'),
'뷰티풀 마인드.jpg',9.2,135);

INSERT INTO FILM(FILM_ID, FILM_TITLE,FILM_TITLE_ENG, FILM_CONTENT, GENRE_ID, MATERIAL_ID,DIRECTOR_ID,
ACTOR_ID1,ACTOR_ID2,ACTOR_ID3, FILM_POSTER, FILM_GRADE_NAVER, RUNNING_TIME) 
VALUES(FILM_SEQ.nextval,'리멤버 타이탄(2000)','Remember The Titans','버지니아주에선 고교 미식축구가 단연 최고의 인기 스포츠이다. 사람들에게 있어서 고교 미식축구란 삶의 한 방식 그 자체이자, 경의와 숭배의 대상이며, 시즌의 플레이오프 게임이 있는 날은 크리스마스를 포함한 그 어느 공휴일보다도 더 축제 분위기가 연출된다.',
1, 9,
(select DIRECTOR_ID from Director where DIRECTOR_NAME='보아즈 아킨'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='덴젤 워싱톤'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='윌 패튼'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='도널드 페이슨'),
'리멤버 타이탄.jpg',9.2,113);

INSERT INTO FILM(FILM_ID, FILM_TITLE,FILM_TITLE_ENG, FILM_CONTENT, GENRE_ID, MATERIAL_ID,DIRECTOR_ID,
ACTOR_ID1,ACTOR_ID2,ACTOR_ID3, FILM_POSTER, FILM_GRADE_NAVER, RUNNING_TIME) 
VALUES(FILM_SEQ.nextval,'아름다운 비행(1996) ','Fly Away Home','여행 중이던 에이미(Amy Alden: 안나 퍼킨 분)는 교통사고로 엄마를 잃고 아버지 토마스(Thomas Alden: 제프 다니엘스 분)와 10년 만에 만나 다시 고향을 찾는다. 엄마를 잃은 슬픔과 좁혀지지 않는 아빠와의 거리 사이에서 에이미의 작은 방황이 시작된다.',
1, 26,
(select DIRECTOR_ID from Director where DIRECTOR_NAME='캐롤 발라드'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='제프 다니엘스'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='안나 파킨'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='데이나 딜레이니'),
'아름다운 비행.jpg',9.2,107);

INSERT INTO FILM(FILM_ID, FILM_TITLE,FILM_TITLE_ENG, FILM_CONTENT, GENRE_ID, MATERIAL_ID,DIRECTOR_ID,
ACTOR_ID1,ACTOR_ID2,ACTOR_ID3, FILM_POSTER, FILM_GRADE_NAVER, RUNNING_TIME) 
VALUES(FILM_SEQ.nextval,'바람과 함께 사라지다(1939)','Gone With The Wind','대농장 타라를 소유한 오하라 가문의 장녀 스칼렛은 이웃에 사는 청년 애슐리를 사모해왔다. 그러나 애슐리가 친구 멜라니와 결혼한다는 이야기를 듣게 된 스칼렛은 뒤늦게 사랑을 고백하지만 거절당하는데, 무역으로 많은 돈을 번 레트 선장이 이 모습을 숨어서 지켜보고 있었다. ',
4, 13,
(select DIRECTOR_ID from Director where DIRECTOR_NAME='빅터 플레밍'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='클락 게이블'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='비비안 리'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='레슬리 하워드'),
'바람과 함께 사라지다.jpg',9.2,222);

INSERT INTO FILM(FILM_ID, FILM_TITLE,FILM_TITLE_ENG, FILM_CONTENT, GENRE_ID, MATERIAL_ID,DIRECTOR_ID,
ACTOR_ID1,ACTOR_ID2,ACTOR_ID3, FILM_POSTER, FILM_GRADE_NAVER, RUNNING_TIME) 
VALUES(FILM_SEQ.nextval,'벤허(1959)','Ben-Hur','서기 26년, 로마 제국 시대 ‘유다 벤허’(찰톤 헤스톤)는 예루살렘의 제일 가는 유태 귀족이다. 어느날, 로마의 지배하에 있던 이스라엘에 새로운 총독이 부임해오고, 그를 보좌하는 주둔 사령관으로 벤허의 옛 친구인 멧살라(스티븐 보이드)가 임명된다. ',
1, 21,
(select DIRECTOR_ID from Director where DIRECTOR_NAME='윌리엄 와일러'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='찰톤 헤스톤'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='잭 호킨스'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='하야 하라릿'),
'벤허.jpg',9.2,222);

INSERT INTO FILM(FILM_ID, FILM_TITLE,FILM_TITLE_ENG, FILM_CONTENT, GENRE_ID, MATERIAL_ID,DIRECTOR_ID,
ACTOR_ID1,ACTOR_ID2,ACTOR_ID3, FILM_POSTER, FILM_GRADE_NAVER, RUNNING_TIME) 
VALUES(FILM_SEQ.nextval,'밴디트(1997)','Bandits','반항적이고 시니컬한 폭력전과자 루나(Luna: 야스민 타바타바이 분), 매력적인 결혼 사기범 엔젤(Angel: 니콜레트 클레비츠 분), 연약한 심성의 살인미수범 마리(Marie: 유타 호프만 분). 감옥에서 만난 그들은 각자의 소질을 살려 락밴드를 결성한다.',
1, 32,
(select DIRECTOR_ID from Director where DIRECTOR_NAME='카챠 본 가르니에'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='카챠 리만'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='야스민 타바타바이'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='니콜레트 클레비츠'),
'밴디트.jpg',9.2,106);

INSERT INTO FILM(FILM_ID, FILM_TITLE,FILM_TITLE_ENG, FILM_CONTENT, GENRE_ID, MATERIAL_ID,DIRECTOR_ID,
ACTOR_ID1,ACTOR_ID2,ACTOR_ID3, FILM_POSTER, FILM_GRADE_NAVER, RUNNING_TIME) 
VALUES(FILM_SEQ.nextval,'이웃집 토토로(1988)','My Neighbor Totoro','1955년 일본의 아름다운 시골 마을. 상냥하고 의젓한 11살 사츠키와 장난꾸러기에 호기심 많은 4살의 메이 는 사이좋은 자매로 아빠와 함께 도시를 떠나 시골로 이사온다.자상한 아빠 쿠사카베타츠오는 도쿄에서 대학 연구원이며, 입원 중이지만 따뜻한 미소를 잃지 않는 엄마가 있다.',
11, 10,
(select DIRECTOR_ID from Director where DIRECTOR_NAME='미야자키 하야오'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='사츠키'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='메이'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='토토로'),
'이웃집 토토로.jpg',9.2,87);

INSERT INTO FILM(FILM_ID, FILM_TITLE,FILM_TITLE_ENG, FILM_CONTENT, GENRE_ID, MATERIAL_ID,DIRECTOR_ID,
ACTOR_ID1,ACTOR_ID2,ACTOR_ID3, FILM_POSTER, FILM_GRADE_NAVER, RUNNING_TIME) 
VALUES(FILM_SEQ.nextval,'백발마녀전(1993)','The Bride With White Hair','중국 명나라 말기. 고아인 탁일항은 중원 8대 문파 중 하나인 무당파의 맹주 자양진 밑에서 무술을 익히고, 후계자로서 기대를 받으며 자란다. ',
3, 12,
(select DIRECTOR_ID from Director where DIRECTOR_NAME='우인태'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='장국영'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='임청하'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='오진우'),
'백발마녀전.jpg',9.2,87);


INSERT INTO FILM(FILM_ID, FILM_TITLE,FILM_TITLE_ENG, FILM_CONTENT, GENRE_ID, MATERIAL_ID,DIRECTOR_ID,
ACTOR_ID1,ACTOR_ID2,ACTOR_ID3, FILM_POSTER, FILM_GRADE_NAVER, RUNNING_TIME) 
VALUES(FILM_SEQ.nextval,'해리 포터와 마법사의 돌(2001)','Harry Potter And The Sorcerers Ston','11살 생일을 며칠 앞둔 어느 날 해리에게 초록색 잉크로 쓰여진 한 통의 편지가 배달된다. 그 편지의 내용은 다름 아닌 해리의 11살 생일을 맞이하여 전설적인“호그와트 마법학교”에서 보낸 입학초대장이었다.',
2, 37,
(select DIRECTOR_ID from Director where DIRECTOR_NAME='크리스 콜럼버스'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='다니엘 래드클리프'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='엠마 왓슨'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='루퍼트 그린트'),
'해리포터-돌.jpg',9.2,152);

INSERT INTO FILM(FILM_ID, FILM_TITLE,FILM_TITLE_ENG, FILM_CONTENT, GENRE_ID, MATERIAL_ID,DIRECTOR_ID,
ACTOR_ID1,ACTOR_ID2,ACTOR_ID3, FILM_POSTER, FILM_GRADE_NAVER, RUNNING_TIME) 
VALUES(FILM_SEQ.nextval,'칼리토(1993)','Carlitos Way','칼리토(Carlito Brigante: 알 파치노 분)는 30년형을 받고 감옥에서 복역하다가 5년만에 출옥한다. 오래 동안 뒷골목 생활을 하던 그는 바하마에서 차 임대업을 하리라는 꿈을 갖고 그 돈을 마련하기 위해 변호사인 데이브(Kleinfeld: 숀 펜 분)가 지분을 갖고 있는 클럽을 운영하게 된다.',
5, 25,
(select DIRECTOR_ID from Director where DIRECTOR_NAME='브라이언 드 팔마'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='알 파치노'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='숀 펜'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='페네로프 앤'),
'칼리토.jpg',9.2,145);

INSERT INTO FILM(FILM_ID, FILM_TITLE,FILM_TITLE_ENG, FILM_CONTENT, GENRE_ID, MATERIAL_ID,DIRECTOR_ID,
ACTOR_ID1,ACTOR_ID2,ACTOR_ID3, FILM_POSTER, FILM_GRADE_NAVER, RUNNING_TIME) 
VALUES(FILM_SEQ.nextval,'똥파리(2008)','Breathless','동료든 적이든 가리지 않고 욕하고 때리며 자기 내키는 대로 살아 온 용역 깡패 상훈. 세상 무서울 것 없는 상훈이지만, 그에게도 마음 속에 쉽게 떨쳐내지 못할 깊은 상처가 있다.',
1, 26,
(select DIRECTOR_ID from Director where DIRECTOR_NAME='양익준'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='양익준'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='김꽃비'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='이환'),
'똥파리.jpg',9.2,130);

INSERT INTO FILM(FILM_ID, FILM_TITLE,FILM_TITLE_ENG, FILM_CONTENT, GENRE_ID, MATERIAL_ID,DIRECTOR_ID,
ACTOR_ID1,ACTOR_ID2,ACTOR_ID3, FILM_POSTER, FILM_GRADE_NAVER, RUNNING_TIME) 
VALUES(FILM_SEQ.nextval,'아저씨(2010)',' The Man from Nowhere','불행한 사건으로 아내를 잃고 세상을 등진 채 전당포를 꾸려가며 외롭게 살아가는 전직 특수요원 태식. 찾아오는 사람이라곤 전당포에 물건을 맡기러 오는 사람들과 옆집소녀 소미뿐이다. 세상으로부터 버림받은 소미와 함께 보내는 시간이 많아지면서 태식과 소미는 서로 마음을 열며 친구가 되어간다.',
9, 25,
(select DIRECTOR_ID from Director where DIRECTOR_NAME='이정범'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='원빈'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='김새론'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='김희원'),
'아저씨.jpg',9.2,119);

INSERT INTO FILM(FILM_ID, FILM_TITLE,FILM_TITLE_ENG, FILM_CONTENT, GENRE_ID, MATERIAL_ID,DIRECTOR_ID,
ACTOR_ID1,ACTOR_ID2,ACTOR_ID3, FILM_POSTER, FILM_GRADE_NAVER, RUNNING_TIME) 
VALUES(FILM_SEQ.nextval,'특전 유보트(1982)','Das Boot, The Boat','대서양을 지배하려는 싸움은 독일을 외면했다. 2차대전 중 4만 명의 수병이 유보트(U-Boats)라 불리는 잠수함에 투입되었다. 그리고 3만 명이 돌아오지 못했다',
10, 21,
(select DIRECTOR_ID from Director where DIRECTOR_NAME='볼프강 페터젠'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='주겐 프로크노'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='클라우스 웨네먼'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='허버트 그로네메이어'),
'특전 유보트.jpg',9.2,210);

INSERT INTO FILM(FILM_ID, FILM_TITLE,FILM_TITLE_ENG, FILM_CONTENT, GENRE_ID, MATERIAL_ID,DIRECTOR_ID,
ACTOR_ID1,ACTOR_ID2,ACTOR_ID3, FILM_POSTER, FILM_GRADE_NAVER, RUNNING_TIME) 
VALUES(FILM_SEQ.nextval,'서서평, 천천히 평온하게(2017)','Slowly ','약 100여 년 전, 가난하고 억압받던 조선 땅에 작은 예수라 불리는 파란 눈의 여인이 있었다.  나환자와 걸인, 무지하고 힘없는 여성들의 어머니 ‘서서평’ 선교사.',
7, 21,
(select DIRECTOR_ID from Director where DIRECTOR_NAME='홍주연'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='하정우'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='윤안나'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='안온새'),
'서서평 천천히.jpg',9.2,78);

INSERT INTO FILM(FILM_ID, FILM_TITLE,FILM_TITLE_ENG, FILM_CONTENT, GENRE_ID, MATERIAL_ID,DIRECTOR_ID,
ACTOR_ID1,ACTOR_ID2,ACTOR_ID3, FILM_POSTER, FILM_GRADE_NAVER, RUNNING_TIME) 
VALUES(FILM_SEQ.nextval,'보디가드(1994)','The Bodyguard From Beijing','국민학교 여교사(종려제 분)는 우연히 살인사건을 목격한다. 음흉한 계락과 잔인성의 소유자이자 당대 최고의 갑부로 알려진 살인범은 목격자가 있음을 확인하고 그녀가 법정에 서는 것을 막기위해 전문 킬러를 고용한다. ',
9, 13,
(select DIRECTOR_ID from Director where DIRECTOR_NAME='원규'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='이연걸'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='종려시'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='정칙사'),
'보디가드.jpg',9.2,92);

INSERT INTO FILM(FILM_ID, FILM_TITLE,FILM_TITLE_ENG, FILM_CONTENT, GENRE_ID, MATERIAL_ID,DIRECTOR_ID,
ACTOR_ID1,ACTOR_ID2,ACTOR_ID3, FILM_POSTER, FILM_GRADE_NAVER, RUNNING_TIME) 
VALUES(FILM_SEQ.nextval,'서유기- 월광보합(1994)','A Chinese Odyssey Part One - Pandoras box','손오공의 환생을 간청하자 관세음은 손오공을 인간으로 환생시키기로 약속한다. 그로부터 500년 후, 손오공은 오악산의 산적무리들의 우두머리인 지존보로 태어난다.',
2, 21,
(select DIRECTOR_ID from Director where DIRECTOR_NAME='유진위'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='주성치'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='오맹달'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='채소분'),
'서유기-월광보합.jpg',9.2,88);

INSERT INTO FILM(FILM_ID, FILM_TITLE,FILM_TITLE_ENG, FILM_CONTENT, GENRE_ID, MATERIAL_ID,DIRECTOR_ID,
ACTOR_ID1,ACTOR_ID2,ACTOR_ID3, FILM_POSTER, FILM_GRADE_NAVER, RUNNING_TIME) 
VALUES(FILM_SEQ.nextval,'온리 더 브레이브(2017)','Only the Brave','미국 애리조나 주 일대에서 역사상 최악의 재난으로 기록되는 초대형 산불이 발생한다.',
1, 21,
(select DIRECTOR_ID from Director where DIRECTOR_NAME='조셉 코신스키'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='조슈 브롤린'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='마일즈 텔러'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='제프 브리지스'),
'온리 더 브레이브.jpg',9.2,133);

INSERT INTO FILM(FILM_ID, FILM_TITLE,FILM_TITLE_ENG, FILM_CONTENT, GENRE_ID, MATERIAL_ID,DIRECTOR_ID,
ACTOR_ID1,ACTOR_ID2,ACTOR_ID3, FILM_POSTER, FILM_GRADE_NAVER, RUNNING_TIME) 
VALUES(FILM_SEQ.nextval,'로마의 휴일(1953) ','Roman Holiday','왕실의 딱딱한 제약과 정해진 스케줄에 피곤해 지고 싫증난 앤 공주(Princess Ann: 오드리 헵번 분)는 거리로 뛰쳐나가 잠들었다가 어느 신사(Joe Bradley: 그레고리 펙 분)를 만난다.',
4,13,
(select DIRECTOR_ID from Director where DIRECTOR_NAME='윌리엄 와일러'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='그레고리 펙'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='오드리 헵번'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='에디 앨버트'),
'로마의 휴일.jpg',9.2,118);

INSERT INTO FILM(FILM_ID, FILM_TITLE,FILM_TITLE_ENG, FILM_CONTENT, GENRE_ID, MATERIAL_ID,DIRECTOR_ID,
ACTOR_ID1,ACTOR_ID2,ACTOR_ID3, FILM_POSTER, FILM_GRADE_NAVER, RUNNING_TIME) 
VALUES(FILM_SEQ.nextval,'하이 스피드! –프리! 스타팅 데이즈(2016)','Free! Starting Days, High Speed! Free Starting days ','물을 접하고 느끼는 데 특별한 애착을 가진 나나세 하루카.  초등학교 시절 마지막 혼계영 대회에서 타치바나 마코토, 하즈키 나기사, 마츠오카 린과 함께 본 적 없는 풍경에 도달한다.',
11, 10,
(select DIRECTOR_ID from Director where DIRECTOR_NAME='타케모토 야스히로'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='나나세 하루카'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='타치바나 마코토'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='시이나 아사히'),
'프리.jpg',9.2,111);

INSERT INTO FILM(FILM_ID, FILM_TITLE,FILM_TITLE_ENG, FILM_CONTENT, GENRE_ID, MATERIAL_ID,DIRECTOR_ID,
ACTOR_ID1,ACTOR_ID2,ACTOR_ID3, FILM_POSTER, FILM_GRADE_NAVER, RUNNING_TIME) 
VALUES(FILM_SEQ.nextval,'오아시스(2002)','Oasis ','종두(설경구 분)는 뺑소니 교통 사고로 형을 살다가 교도소에서 막 출소했다. 그 사이 이사를 가버린 가족들을 겨우 찾아가지만 가족들은 귀찮은 내색을 숨기지 않는다.',
1, 32,
(select DIRECTOR_ID from Director where DIRECTOR_NAME='이창동'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='설경구'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='문소리'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='안내상'),
'오아시스.jpg',9.2,132);


INSERT INTO FILM(FILM_ID, FILM_TITLE,FILM_TITLE_ENG, FILM_CONTENT, GENRE_ID, MATERIAL_ID,DIRECTOR_ID,
ACTOR_ID1,ACTOR_ID2,ACTOR_ID3, FILM_POSTER, FILM_GRADE_NAVER, RUNNING_TIME) 
VALUES(FILM_SEQ.nextval,'저수지 게임(2017)','The Reservoir Game ','탐사보도 전문 ‘악마 기자’ 주진우가 누구나 알지만, 아무도 말 못하는 그분의 ‘검은 돈’을 찾고 있다. ',
7,26,
(select DIRECTOR_ID from Director where DIRECTOR_NAME='최진성'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='주진우'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='조미래'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='정재호'),
'저수지 게임.jpg',9.2,100);

INSERT INTO FILM(FILM_ID, FILM_TITLE,FILM_TITLE_ENG, FILM_CONTENT, GENRE_ID, MATERIAL_ID,DIRECTOR_ID,
ACTOR_ID1,ACTOR_ID2,ACTOR_ID3, FILM_POSTER, FILM_GRADE_NAVER, RUNNING_TIME) 
VALUES(FILM_SEQ.nextval,'시월애(2000)','A Love Story ','1998년 1월엔 눈이 많이 왔어요. 감기 조심하세요. 일마레로 이사온 성현(이정재 분)에게 이상한 편지가 남겨있다. 1999년, 2년 후로부터 온 편지. 그 편지에 있던 내용들이 예언과도 같이 현실 속에 나타난다.',
4,13,
(select DIRECTOR_ID from Director where DIRECTOR_NAME='이현승'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='이정재'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='전지현'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='김무생'),
'시월애.jpg',9.2,94);

INSERT INTO FILM(FILM_ID, FILM_TITLE,FILM_TITLE_ENG, FILM_CONTENT, GENRE_ID, MATERIAL_ID,DIRECTOR_ID,
ACTOR_ID1,ACTOR_ID2,ACTOR_ID3, FILM_POSTER, FILM_GRADE_NAVER, RUNNING_TIME) 
VALUES(FILM_SEQ.nextval,'타인의 삶(2006)','Das Leben Der Anderen','1984년, 동독. 비밀경찰(슈타지)의 감시로부터 자신도 모르게 철저히 조사 당했던 동독의 국민들. 보이지 않는 정보국 요원의 삶. 10만 명의 비밀경찰과 20만 명이 넘는 스파이. 그들의 목표는 단 하나…',
1,21,
(select DIRECTOR_ID from Director where DIRECTOR_NAME='플로리안 헨켈 폰 도너스마르크'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='울리히 뮤흐'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='마르티나 게덱'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='세바스티안 코치'),
'타인의 삶.jpg',9.2,137);


INSERT INTO FILM(FILM_ID, FILM_TITLE,FILM_TITLE_ENG, FILM_CONTENT, GENRE_ID, MATERIAL_ID,DIRECTOR_ID,
ACTOR_ID1,ACTOR_ID2,ACTOR_ID3, FILM_POSTER, FILM_GRADE_NAVER, RUNNING_TIME) 
VALUES(FILM_SEQ.nextval,'인셉션(2010)','Inception','드림머신이라는 기계로 타인의 꿈과 접속해 생각을 빼낼 수 있는 미래사회. ‘돔 코브’(레오나르도 디카프리오)는 생각을 지키는 특수보안요원이면서 또한 최고의 실력으로 생각을 훔치는 도둑이다. ',
9, 14,
(select DIRECTOR_ID from Director where DIRECTOR_NAME='크리스토퍼 놀란'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='레오나르도 디카프리오'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='마리옹 꼬띠아르'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='조셉 고든 레빗'),
'인셉션.jpg',9.2,147);

INSERT INTO FILM(FILM_ID, FILM_TITLE,FILM_TITLE_ENG, FILM_CONTENT, GENRE_ID, MATERIAL_ID,DIRECTOR_ID,
ACTOR_ID1,ACTOR_ID2,ACTOR_ID3, FILM_POSTER, FILM_GRADE_NAVER, RUNNING_TIME) 
VALUES(FILM_SEQ.nextval,'그랜 토리노(2008)','Gran Torino','이웃집 소년 타오가 갱단의 협박으로 월트의 72년산 그랜 토리노를 훔치려 하고 뜻하지 않았던 이 만남으로 월트는 차고 속에 모셔두기만 했던 자신의 자동차 그랜 토리노처럼 전쟁 이후 닫아둔 자신의 진심을 드러내기 시작한다.',
12,26,
(select DIRECTOR_ID from Director where DIRECTOR_NAME='클린트 이스트우드'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='클린트 이스트우드'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='크리스토퍼 칼리'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='아니 허'),
'그랜 토리노.jpg',9.2,116);

INSERT INTO FILM(FILM_ID, FILM_TITLE,FILM_TITLE_ENG, FILM_CONTENT, GENRE_ID, MATERIAL_ID,DIRECTOR_ID,
ACTOR_ID1,ACTOR_ID2,ACTOR_ID3, FILM_POSTER, FILM_GRADE_NAVER, RUNNING_TIME) 
VALUES(
FILM_SEQ.nextval,
'패치 아담스',
'Patch Adams',
'상처를 치유하다 라는 의미의 패치(PATCH)라는 별명을 얻으면서 패치 아담스로서 새 인생을 시작한다.',
1,
24,
(select DIRECTOR_ID from Director where DIRECTOR_NAME='톰 새디악'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='로빈 윌리암스'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='모니카 포터'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='필립 세이모어 호프만'),
'패치아담스.jpg',
9.1,
115
);

INSERT INTO FILM(FILM_ID, FILM_TITLE,FILM_TITLE_ENG, FILM_CONTENT, GENRE_ID, MATERIAL_ID,DIRECTOR_ID,
ACTOR_ID1,ACTOR_ID2,ACTOR_ID3, FILM_POSTER, FILM_GRADE_NAVER, RUNNING_TIME) 
VALUES(
FILM_SEQ.nextval,
'블러드 다이아몬드',
'Blood Diamond',
'아무도 막을 수 없다 2007년, 최강의 다이나믹 액션!',
5,
23,
(select DIRECTOR_ID from Director where DIRECTOR_NAME='에드워드 즈윅'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='레오나르도 디카프리오'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='제니퍼 코넬리'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='디몬 하운수'),
'블러드 다이아몬드.jpg',
9.1,
142
);

INSERT INTO FILM(FILM_ID, FILM_TITLE,FILM_TITLE_ENG, FILM_CONTENT, GENRE_ID, MATERIAL_ID,DIRECTOR_ID,
ACTOR_ID1,ACTOR_ID2,ACTOR_ID3, FILM_POSTER, FILM_GRADE_NAVER, RUNNING_TIME) 
VALUES(
FILM_SEQ.nextval,
'국가대표',
'Take Off',
'하늘을 나는 꿈 (국가대표) 우리는 대한민국 국가대표다!',
1,
8,
(select DIRECTOR_ID from Director where DIRECTOR_NAME='김용화'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='하정우'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='성동일'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='김지석'),
'국가대표.jpg',
9.1,
137
);

INSERT INTO FILM(FILM_ID, FILM_TITLE,FILM_TITLE_ENG, FILM_CONTENT, GENRE_ID, MATERIAL_ID,DIRECTOR_ID,
ACTOR_ID1,ACTOR_ID2,ACTOR_ID3, FILM_POSTER, FILM_GRADE_NAVER, RUNNING_TIME) 
VALUES(
FILM_SEQ.nextval,
'파워 오브 원',
'The Power Of One',
'남아프리카 공화국이 독립하기 18년전인 1930년',
1,
21,
(select DIRECTOR_ID from Director where DIRECTOR_NAME='존 G 아빌드센'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='스티븐 도프'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='가이 위처'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='시몬 펜톤'),
'파워오브원.jpg',
9.1,
123
);

INSERT INTO FILM(FILM_ID, FILM_TITLE,FILM_TITLE_ENG, FILM_CONTENT, GENRE_ID, MATERIAL_ID,DIRECTOR_ID,
ACTOR_ID1,ACTOR_ID2,ACTOR_ID3, FILM_POSTER, FILM_GRADE_NAVER, RUNNING_TIME) 
VALUES(
FILM_SEQ.nextval,
'아는 여자',
'Someone Special',
'오직 한 남자만... (아는 여자) 눈높이 특이한 여자의 눈치코치 없는 러브 스토리',
8,
15,
(select DIRECTOR_ID from Director where DIRECTOR_NAME='장진'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='정재영'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='이나영'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='장영남'),
'아는여자.jpg',
9.1,
107
);

INSERT INTO FILM(FILM_ID, FILM_TITLE,FILM_TITLE_ENG, FILM_CONTENT, GENRE_ID, MATERIAL_ID,DIRECTOR_ID,
ACTOR_ID1,ACTOR_ID2,ACTOR_ID3, FILM_POSTER, FILM_GRADE_NAVER, RUNNING_TIME) 
VALUES(
FILM_SEQ.nextval,
'클릭',
'Click',
'아담 샌들러의 인생 개조 프로젝트 빨리 감고, 되돌리고, 정지하고... 내 인생 내 맘대로!',
8,
9,
(select DIRECTOR_ID from Director where DIRECTOR_NAME='프랭크 코라치'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='아담 샌들러'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='케이튼 베킨세일'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='크리스토퍼 월켄'),
'클릭.jpg',
9.1,
107
);

INSERT INTO FILM(FILM_ID, FILM_TITLE,FILM_TITLE_ENG, FILM_CONTENT, GENRE_ID, MATERIAL_ID,DIRECTOR_ID,
ACTOR_ID1,ACTOR_ID2,ACTOR_ID3, FILM_POSTER, FILM_GRADE_NAVER, RUNNING_TIME) 
VALUES(
FILM_SEQ.nextval,
'우드잡',
'Wood Job',
'도시 청년이 산림관리를 통해 연애와 인생을 배우는 이야기',
8,
26,
(select DIRECTOR_ID from Director where DIRECTOR_NAME='야구치 시노부'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='소메타니 쇼타'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='나가사와 마사미'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='이토 히데아키'),
'우드잡.jpg',
9.1,
116
);

INSERT INTO FILM(FILM_ID, FILM_TITLE,FILM_TITLE_ENG, FILM_CONTENT, GENRE_ID, MATERIAL_ID,DIRECTOR_ID,
ACTOR_ID1,ACTOR_ID2,ACTOR_ID3, FILM_POSTER, FILM_GRADE_NAVER, RUNNING_TIME) 
VALUES(
FILM_SEQ.nextval,
'타짜',
'The War Of Flower',
'인생을 건 한판 승부! 큰거 한판에 인생은 예술이 된다! 목숨을 걸 수 없다면, 배팅하지 마라! 꽃들의 전쟁',
12,
27,
(select DIRECTOR_ID from Director where DIRECTOR_NAME='최동훈'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='조승우'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='김혜수'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='백윤식'),
'타짜.jpg',
9.1,
139
);

INSERT INTO FILM(FILM_ID, FILM_TITLE,FILM_TITLE_ENG, FILM_CONTENT, GENRE_ID, MATERIAL_ID,DIRECTOR_ID,
ACTOR_ID1,ACTOR_ID2,ACTOR_ID3, FILM_POSTER, FILM_GRADE_NAVER, RUNNING_TIME) 
VALUES(
FILM_SEQ.nextval,
'미션 임파서블:폴아웃',
'Mission Impossible - Fallout',
'도난당한 핵무기, 핵재앙을 막기위한 역대 제일 불가능한 미션!!',
9,
25,
(select DIRECTOR_ID from Director where DIRECTOR_NAME='크리스토퍼 맥쿼리'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='톰 크루즈'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='헨리 카빌'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='사이먼 페그'),
'미션임파서블_폴아웃.jpg',
9.1,
147
);

INSERT INTO FILM(FILM_ID, FILM_TITLE,FILM_TITLE_ENG, FILM_CONTENT, GENRE_ID, MATERIAL_ID,DIRECTOR_ID,
ACTOR_ID1,ACTOR_ID2,ACTOR_ID3, FILM_POSTER, FILM_GRADE_NAVER, RUNNING_TIME) 
VALUES(
FILM_SEQ.nextval,
'뱀파이어와의 인터뷰',
'Interview With the Vampire: The Vampire Chronicles',
'샌프란시스코의 어두운 밤. 빌딩의 한 어두운 방에서는 라디오 방송 작가(크리스찬 슬레이터 분)와 뱀파이어와의 인터뷰가 시작된다.',
1,
28,
(select DIRECTOR_ID from Director where DIRECTOR_NAME='닐 조던'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='톰 크루즈'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='브래드 피트'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='안토니오 반데라스'),
'뱀파이어와의인터뷰.jpg',
9.1,
123
);

INSERT INTO FILM(FILM_ID, FILM_TITLE,FILM_TITLE_ENG, FILM_CONTENT, GENRE_ID, MATERIAL_ID,DIRECTOR_ID,
ACTOR_ID1,ACTOR_ID2,ACTOR_ID3, FILM_POSTER, FILM_GRADE_NAVER, RUNNING_TIME) 
VALUES(
FILM_SEQ.nextval,
'오직 그대만',
'Always',
'지켜주고 싶습니다. 그 여자... 보고 싶습니다. 그 남자...',
4,
6,
(select DIRECTOR_ID from Director where DIRECTOR_NAME='송일곤'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='소지섭'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='한효주'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='강신일'),
'오직 그대만.jpg',
9.1,
105
);

INSERT INTO FILM(FILM_ID, FILM_TITLE,FILM_TITLE_ENG, FILM_CONTENT, GENRE_ID, MATERIAL_ID,DIRECTOR_ID,
ACTOR_ID1,ACTOR_ID2,ACTOR_ID3, FILM_POSTER, FILM_GRADE_NAVER, RUNNING_TIME) 
VALUES(
FILM_SEQ.nextval,
'철가방 우수氏',
'Iron Bag mr WuSu',
'슬픈인생 기적같은 만남 희망',
1,
24,
(select DIRECTOR_ID from Director where DIRECTOR_NAME='윤학렬'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='최수종'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='기주봉'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='이수나'),
'철가방 우수씨.jpg',
9.1,
100
);

INSERT INTO FILM(FILM_ID, FILM_TITLE,FILM_TITLE_ENG, FILM_CONTENT, GENRE_ID, MATERIAL_ID,DIRECTOR_ID,
ACTOR_ID1,ACTOR_ID2,FILM_POSTER, FILM_GRADE_NAVER, RUNNING_TIME) 
VALUES(
FILM_SEQ.nextval,
'피아니스트 세이모어의 뉴욕 소네트',
'Seymour: An Introduction',
'헐리우드 탑스타 에단호크와 가장 화려한 순간 무대를 내려온 세이모어 뉴욕의 작은 스튜디오에서 보내온 음악편지',
7,
21,
(select DIRECTOR_ID from Director where DIRECTOR_NAME='에단 호크'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='세이모어 번스타인'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='에단 호크'),
'피아니스트세이모어.jpg',
9.1,
84
);

INSERT INTO FILM(FILM_ID, FILM_TITLE,FILM_TITLE_ENG, FILM_CONTENT, GENRE_ID, MATERIAL_ID,DIRECTOR_ID,
ACTOR_ID1,ACTOR_ID2,ACTOR_ID3, FILM_POSTER, FILM_GRADE_NAVER, RUNNING_TIME) 
VALUES(
FILM_SEQ.nextval,
'카메라를 멈추면 안 돼!',
'One Cut of the Dead',
'원 테이크로 담아낸 아비규환 좀비 출몰 현장!',
3,
1,
(select DIRECTOR_ID from Director where DIRECTOR_NAME='우에다 신이치로'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='하마츠 타카유키'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='아키야마 유즈키'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='나가야 카즈아키'),
'카메라를 멈추면 안 돼.jpg',
9.1,
95
);

INSERT INTO FILM(FILM_ID, FILM_TITLE,FILM_TITLE_ENG, FILM_CONTENT, GENRE_ID, MATERIAL_ID,DIRECTOR_ID,
ACTOR_ID1,ACTOR_ID2,ACTOR_ID3, FILM_POSTER, FILM_GRADE_NAVER, RUNNING_TIME) 
VALUES(
FILM_SEQ.nextval,
'불량소녀, 너를 응원해!',
'Biri Gal, Flying Colors',
'사고뭉치 문제아! 명문대 진학 도전을 선포하다?!',
1,
24,
(select DIRECTOR_ID from Director where DIRECTOR_NAME='도이 노부히로'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='아라무라 카스미'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='아토 아츠시'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='요시다 요'),
'불량소녀 너를 응원해.jpg',
9.1,
117
);

INSERT INTO FILM(FILM_ID, FILM_TITLE,FILM_TITLE_ENG, FILM_CONTENT, GENRE_ID, MATERIAL_ID,DIRECTOR_ID,
ACTOR_ID1,FILM_POSTER, FILM_GRADE_NAVER, RUNNING_TIME) 
VALUES(
FILM_SEQ.nextval,
'댄서(2016)',
'Dancer',
'천재 발레리노, 세계적인 스타, 꽃미남 그리고 반항아 세상에서 가장 우아한 짐승의 모든 것!',
7,
29,
(select DIRECTOR_ID from Director where DIRECTOR_NAME='스티븐 캔터'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='세르게이 폴루닌'),
'댄서 2016.jpg',
9.1,
85
);

INSERT INTO FILM(FILM_ID, FILM_TITLE,FILM_TITLE_ENG, FILM_CONTENT, GENRE_ID, MATERIAL_ID,DIRECTOR_ID,
ACTOR_ID1,FILM_POSTER, FILM_GRADE_NAVER, RUNNING_TIME) 
VALUES(
FILM_SEQ.nextval,
'7인의 사무라이',
'Seven Samurai',
'때는 전국시대, 끊이지 않는 전란이 만들어낸 노부시의 횡포에 백성들이 떨고있던 그때..',
9,
30,
(select DIRECTOR_ID from Director where DIRECTOR_NAME='구로사와 아키라'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='미후네 도시로'),
'7인의 사무라이.jpg',
9.1,
205
);

INSERT INTO FILM(FILM_ID, FILM_TITLE,FILM_TITLE_ENG, FILM_CONTENT, GENRE_ID, MATERIAL_ID,DIRECTOR_ID,
ACTOR_ID1,ACTOR_ID2,ACTOR_ID3, FILM_POSTER, FILM_GRADE_NAVER, RUNNING_TIME) 
VALUES(
FILM_SEQ.nextval,
'겨울왕국',
'Frozen',
'얼어붙은 세상을 녹일 자매가 온다! 렛잇고',
11,
10,
(select DIRECTOR_ID from Director where DIRECTOR_NAME='크리스 벅'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='크리스틴 벨'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='이다나 멘젤'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='조시 게드'),
'겨울왕국.jpg',
9.1,
108
);

INSERT INTO FILM(FILM_ID, FILM_TITLE,FILM_TITLE_ENG, FILM_CONTENT, GENRE_ID, MATERIAL_ID,DIRECTOR_ID,
ACTOR_ID1,ACTOR_ID2,ACTOR_ID3, FILM_POSTER, FILM_GRADE_NAVER, RUNNING_TIME) 
VALUES(
FILM_SEQ.nextval,
'스트레인저 무황인담',
'Sword of The Stranger',
'전란의 불꽃이 꺼지지 않은 일본 전국시대,최강의 두 검객 피할 수 없는 대결',
11,
30,
(select DIRECTOR_ID from Director where DIRECTOR_NAME='안도 마사히로'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='치넨 유리'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='나가세 토모야'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='오츠카 아키오'),
'스트레인저 무황인담.jpg',
9.1,
103
);

INSERT INTO FILM(FILM_ID, FILM_TITLE,FILM_TITLE_ENG, FILM_CONTENT, GENRE_ID, MATERIAL_ID,DIRECTOR_ID,
ACTOR_ID1,ACTOR_ID2,ACTOR_ID3, FILM_POSTER, FILM_GRADE_NAVER, RUNNING_TIME) 
VALUES(
FILM_SEQ.nextval,
'빅뱅 메이드',
'BIGBANG MADE',
'가장 빅뱅다운 영화, BIGBANG MADE가 팬들을 찾아간다.',
7,
20,
(select DIRECTOR_ID from Director where DIRECTOR_NAME='변진호'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='G-DRAGON'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='태양'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='TOP'),
'빅뱅메이드.jpg',
9.1,
114
);

INSERT INTO FILM(FILM_ID, FILM_TITLE,FILM_TITLE_ENG, FILM_CONTENT, GENRE_ID, MATERIAL_ID,DIRECTOR_ID,
ACTOR_ID1,ACTOR_ID2,ACTOR_ID3, FILM_POSTER, FILM_GRADE_NAVER, RUNNING_TIME) 
VALUES(
FILM_SEQ.nextval,
'코렐라인: 비밀의 문',
'Coraline',
'비밀의 문을 통해 연결된 또다른 세계 들어올때는 마음대로였지만 나갈때는 아니란다.',
11,
23,
(select DIRECTOR_ID from Director where DIRECTOR_NAME='헨리 셀릭'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='다코타 패닝'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='테리 해처'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='제니퍼 손더스'),
'코렐라인.jpg',
9.1,
100
);

INSERT INTO FILM(FILM_ID, FILM_TITLE,FILM_TITLE_ENG, FILM_CONTENT, GENRE_ID, MATERIAL_ID,DIRECTOR_ID,
ACTOR_ID1,ACTOR_ID2,ACTOR_ID3, FILM_POSTER, FILM_GRADE_NAVER, RUNNING_TIME) 
VALUES(
FILM_SEQ.nextval,
'명탐정 코난:제로의 집행인',
'Detective Conan: Zero the Enforcer',
'영화설명',
11,
16,
(select DIRECTOR_ID from Director where DIRECTOR_NAME='타치카와 유즈루'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='타카야마 미나미'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='야마자키 와카나'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='코야마 리키야'),
'명탐정코난 제로의집행인.jpg',
9.1,
110
);

INSERT INTO FILM(FILM_ID, FILM_TITLE,FILM_TITLE_ENG, FILM_CONTENT, GENRE_ID, MATERIAL_ID,DIRECTOR_ID,
ACTOR_ID1,ACTOR_ID2,ACTOR_ID3, FILM_POSTER, FILM_GRADE_NAVER, RUNNING_TIME) 
VALUES(
FILM_SEQ.nextval,
'웨딩 드레스',
'Wedding Dress',
'영화설명',
1,
9,
(select DIRECTOR_ID from Director where DIRECTOR_NAME='권형진'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='송윤아'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='김향기'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='김명국'),
'웨딩드레스.jpg',
9.1,
109
);

INSERT INTO FILM(FILM_ID, FILM_TITLE,FILM_TITLE_ENG, FILM_CONTENT, GENRE_ID, MATERIAL_ID,DIRECTOR_ID,
ACTOR_ID1,ACTOR_ID2,ACTOR_ID3, FILM_POSTER, FILM_GRADE_NAVER, RUNNING_TIME) 
VALUES(
FILM_SEQ.nextval,
'나는 고양이로소이다',
'I am a Cat',
'여유만만 일본냥! 위풍당당 대만냥! 눈치백단 한국냥?! 행복한 삶을 위해 꽃길 찾아 떠난다옹!',
7,
31,
(select DIRECTOR_ID from Director where DIRECTOR_NAME='조은성'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='김하연'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='박선미'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='장혁진'),
'나는 고양이로소이다.jpg',
9.1,
90
);

INSERT INTO FILM(FILM_ID, FILM_TITLE,FILM_TITLE_ENG, FILM_CONTENT, GENRE_ID, MATERIAL_ID,DIRECTOR_ID,
ACTOR_ID1,ACTOR_ID2,ACTOR_ID3, FILM_POSTER, FILM_GRADE_NAVER, RUNNING_TIME) 
VALUES(
FILM_SEQ.nextval,
'투캅스 3',
'Two Cops 3',
'새시대, 새정부, 새경찰!',
9,
22,
(select DIRECTOR_ID from Director where DIRECTOR_NAME='김상진'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='김보성'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='권민중'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='박용우'),
'투캅스3.jpg',
9.1,
96
);

INSERT INTO FILM(FILM_ID, FILM_TITLE,FILM_TITLE_ENG, FILM_CONTENT, GENRE_ID, MATERIAL_ID,DIRECTOR_ID,
ACTOR_ID1,ACTOR_ID2,ACTOR_ID3, FILM_POSTER, FILM_GRADE_NAVER, RUNNING_TIME) 
VALUES(
FILM_SEQ.nextval,
'노킹 온 헤븐스 도어',
'Knockin On Heavens Door',
'생의 마지막 순간, 천국을 향한 두 남자의 뜨거운 여행!',
9,
32,
(select DIRECTOR_ID from Director where DIRECTOR_NAME='토머스 얀'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='틸 슈바이거'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='잔 조세프 리퍼스'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='모리츠 블라이브트로이'),
'노킹온헤븐스도어.jpg',
9.1,
89
);

INSERT INTO FILM(FILM_ID, FILM_TITLE,FILM_TITLE_ENG, FILM_CONTENT, GENRE_ID, MATERIAL_ID,DIRECTOR_ID,
ACTOR_ID1,ACTOR_ID2,ACTOR_ID3, FILM_POSTER, FILM_GRADE_NAVER, RUNNING_TIME) 
VALUES(
FILM_SEQ.nextval,
'에너미 오브 스테이트',
'Enemy Of The State',
'거대세력과 한 변호사와의 숨막히는 두뇌싸움',
5,
25,
(select DIRECTOR_ID from Director where DIRECTOR_NAME='토니 스콧'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='윌 스미스'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='진 핵크만'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='존 보이트'),
'에너미 오브 스테이트.jpg',
9.1,
131
);

INSERT INTO FILM(FILM_ID, FILM_TITLE,FILM_TITLE_ENG, FILM_CONTENT, GENRE_ID, MATERIAL_ID,DIRECTOR_ID,
ACTOR_ID1,ACTOR_ID2,ACTOR_ID3, FILM_POSTER, FILM_GRADE_NAVER, RUNNING_TIME) 
VALUES(
FILM_SEQ.nextval,
'에이리언(1979)',
'Alien',
'시고니 위버가 출현하는 첫번째 에이리언',
14,
33,
(select DIRECTOR_ID from Director where DIRECTOR_NAME='리들리 스콧'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='톰 스커릿'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='시고니 위버'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='베로니카 캣라이트'),
'에이리언 1979.jpg',
9.1,
117
);

INSERT INTO FILM(FILM_ID, FILM_TITLE,FILM_TITLE_ENG, FILM_CONTENT, GENRE_ID, MATERIAL_ID,DIRECTOR_ID,
ACTOR_ID1,ACTOR_ID2,ACTOR_ID3, FILM_POSTER, FILM_GRADE_NAVER, RUNNING_TIME) 
VALUES(
FILM_SEQ.nextval,
'호로비츠를 위하여',
'For Horowitz',
'어느날 내 인생에, 보석같은 녀석이 다가왔습니다. 내가 만난 아이는 미운 오래새끼였습니다. 내 인생을 빛내줄 천재소년을 만났다',
1,
20,
(select DIRECTOR_ID from Director where DIRECTOR_NAME='권형진'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='엄정화'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='신의재'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='박용우'),
'호로비츠를 위하여.jpg',
9.1,
108
);

INSERT INTO FILM(FILM_ID, FILM_TITLE,FILM_TITLE_ENG, FILM_CONTENT, GENRE_ID, MATERIAL_ID,DIRECTOR_ID,
ACTOR_ID1,ACTOR_ID2,ACTOR_ID3, FILM_POSTER, FILM_GRADE_NAVER, RUNNING_TIME) 
VALUES(
FILM_SEQ.nextval,
'써니',
'Sunny',
'가장 찬란한 순간, 우리는 하나였다',
8,
8,
(select DIRECTOR_ID from Director where DIRECTOR_NAME='강형철'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='유호정'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='심은경'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='강소라'),
'써니.jpg',
9.1,
124
);

INSERT INTO FILM(FILM_ID, FILM_TITLE,FILM_TITLE_ENG, FILM_CONTENT, GENRE_ID, MATERIAL_ID,DIRECTOR_ID,
ACTOR_ID1,ACTOR_ID2, FILM_POSTER, FILM_GRADE_NAVER, RUNNING_TIME) 
VALUES(
FILM_SEQ.nextval,
'제자, 옥한흠',
'Disciple Ock HanHm',
'옥한흠 목사의 일대기',
7,
21,
(select DIRECTOR_ID from Director where DIRECTOR_NAME='김상철'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='권오중'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='성유리'),
'제자옥한흠.jpg',
9.1,
92
);

INSERT INTO FILM(FILM_ID, FILM_TITLE,FILM_TITLE_ENG, FILM_CONTENT, GENRE_ID, MATERIAL_ID,DIRECTOR_ID,
ACTOR_ID1,ACTOR_ID2,ACTOR_ID3, FILM_POSTER, FILM_GRADE_NAVER, RUNNING_TIME) 
VALUES(
FILM_SEQ.nextval,
'이터널 선샤인',
'Eternal Sunshine Of The Spotless Mind',
'당신을 지우면 이 아픔도 사라질까요? 사랑은 그렇게 다시 기억된다.',
4,
13,
(select DIRECTOR_ID from Director where DIRECTOR_NAME='미셸 공드리'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='짐 캐리'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='케이트 윈슬렛'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='커스틴 던스트'),
'이터널선샤인.jpg',
9.1,
107
);

INSERT INTO FILM(FILM_ID, FILM_TITLE,FILM_TITLE_ENG, FILM_CONTENT, GENRE_ID, MATERIAL_ID,DIRECTOR_ID,
ACTOR_ID1,ACTOR_ID2,ACTOR_ID3, FILM_POSTER, FILM_GRADE_NAVER, RUNNING_TIME) 
VALUES(
FILM_SEQ.nextval,
'늑대아이',
'Wolf Children',
'내가 사랑하게 된 사람은… 늑대인간이었습니다.',
11,
10,
(select DIRECTOR_ID from Director where DIRECTOR_NAME='호소다 마모루'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='하나'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='늑대인간'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='유키'),
'늑대아이.jpg',
9.1,
117
);

INSERT INTO FILM(FILM_ID, FILM_TITLE,FILM_TITLE_ENG, FILM_CONTENT, GENRE_ID, MATERIAL_ID,DIRECTOR_ID,
ACTOR_ID1,ACTOR_ID2,ACTOR_ID3, FILM_POSTER, FILM_GRADE_NAVER, RUNNING_TIME) 
VALUES(
FILM_SEQ.nextval,
'빽 투 더 퓨쳐3',
'Back To The Future Part 3',
'미래는 백지야. 자네가 직접 만드는 것이라네, 멋진 인생을',
14,
34,
(select DIRECTOR_ID from Director where DIRECTOR_NAME='로버트 저메키스'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='마이클 J 폭스'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='크리스토퍼 로이드'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='메리 스틴버겐'),
'빽 투 더 퓨처3.jpg',
9.1,
117
);

INSERT INTO FILM(FILM_ID, FILM_TITLE,FILM_TITLE_ENG, FILM_CONTENT, GENRE_ID, MATERIAL_ID,DIRECTOR_ID,
ACTOR_ID1,ACTOR_ID2,ACTOR_ID3, FILM_POSTER, FILM_GRADE_NAVER, RUNNING_TIME) 
VALUES(
FILM_SEQ.nextval,
'패딩턴2',
'Paddington2',
'런던 현지 적응 완료! 더욱 강력해진 트러블을 몰고 패딩턴 IS BACK!',
8,
10,
(select DIRECTOR_ID from Director where DIRECTOR_NAME='폴 킹'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='패딩턴'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='휴 그랜트'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='샐리 호킨스'),
'패딩턴2.jpg',
9.1,
104
);

INSERT INTO FILM(FILM_ID, FILM_TITLE,FILM_TITLE_ENG, FILM_CONTENT, GENRE_ID, MATERIAL_ID,DIRECTOR_ID,
ACTOR_ID1,ACTOR_ID2,ACTOR_ID3, FILM_POSTER, FILM_GRADE_NAVER, RUNNING_TIME) 
VALUES(
FILM_SEQ.nextval,
'무간도',
'Infernal Affairs',
'경찰의 스파이가 된 범죄 조직원 , 범죄 조직의 스파이가 된 경찰',
6,
25,
(select DIRECTOR_ID from Director where DIRECTOR_NAME='맥조휘'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='양조위'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='유덕화'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='황추생'),
'무간도.jpg',
9.1,
100
);

INSERT INTO FILM(FILM_ID, FILM_TITLE,FILM_TITLE_ENG, FILM_CONTENT, GENRE_ID, MATERIAL_ID,DIRECTOR_ID,
ACTOR_ID1,ACTOR_ID2,ACTOR_ID3, FILM_POSTER, FILM_GRADE_NAVER, RUNNING_TIME) 
VALUES(
FILM_SEQ.nextval,
'빅 히어로',
'Big Hero',
'치명적인 몸매! 꼭 안아주고 싶은 힐링로봇 베이맥스, 가장 사랑스러운 슈퍼히어로가 온다!',
11,
35,
(select DIRECTOR_ID from Director where DIRECTOR_NAME='돈 홀'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='테디 아르마다'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='히로 아르마다'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='베이맥스'),
'빅 히어로.jpg',
9.1,
108
);

INSERT INTO FILM(FILM_ID, FILM_TITLE,FILM_TITLE_ENG, FILM_CONTENT, GENRE_ID, MATERIAL_ID,DIRECTOR_ID,
ACTOR_ID1,ACTOR_ID2,ACTOR_ID3, FILM_POSTER, FILM_GRADE_NAVER, RUNNING_TIME) 
VALUES(
FILM_SEQ.nextval,
'시스터 액트2',
'Sister Act 2: Back In The Habit',
'문제아 아이들과 수녀로 변장한 인기 가수의 합창대회',
8,
20,
(select DIRECTOR_ID from Director where DIRECTOR_NAME='빌 듀크'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='우피 골드버그'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='캐시 나지미'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='제임스 코번'),
'시스터 액트2.jpg',
9.1,
107
);

INSERT INTO FILM(FILM_ID, FILM_TITLE,FILM_TITLE_ENG, FILM_CONTENT, GENRE_ID, MATERIAL_ID,DIRECTOR_ID,
ACTOR_ID1,ACTOR_ID2,ACTOR_ID3, FILM_POSTER, FILM_GRADE_NAVER, RUNNING_TIME) 
VALUES(
FILM_SEQ.nextval,
'분노의 질주: 더 세븐',
'Fast and Furious 7',
'역대 최강의 멤버 VS 사상 최악의 상대 팀을 지키기 위한 그들의 반격이 시작된다!',
9,
36,
(select DIRECTOR_ID from Director where DIRECTOR_NAME='제임스 완'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='빈 디젤'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='폴 워커'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='드웨인 존슨'),
'분노의 질주 더 세븐.jpg',
9.1,
138
);

INSERT INTO FILM(FILM_ID, FILM_TITLE,FILM_TITLE_ENG, FILM_CONTENT, GENRE_ID, MATERIAL_ID,DIRECTOR_ID,
ACTOR_ID1,ACTOR_ID2,ACTOR_ID3, FILM_POSTER, FILM_GRADE_NAVER, RUNNING_TIME) 
VALUES(
FILM_SEQ.nextval,
'하울의 움직이는 성',
'Howls Moving Castle',
'소녀가 마법에 걸린 순간, 꽃미남 마법사의 성문이 열렸다!',
11,
37,
(select DIRECTOR_ID from Director where DIRECTOR_NAME='미야자키 하야오'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='소피'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='하울'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='카루시파'),
'하울의 움직이는 성.jpg',
9.1,
119
);

INSERT INTO FILM(FILM_ID, FILM_TITLE,FILM_TITLE_ENG, FILM_CONTENT, GENRE_ID, MATERIAL_ID,DIRECTOR_ID,
ACTOR_ID1,ACTOR_ID2,FILM_POSTER, FILM_GRADE_NAVER, RUNNING_TIME) 
VALUES(
FILM_SEQ.nextval,
'정무문',
'Fist Of Fury',
'이소룡의 정무문, 스승의 복수',
9,
17,
(select DIRECTOR_ID from Director where DIRECTOR_NAME='나유'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='이소룡'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='묘가수'),
'정무문.jpg',
9.1,
106
);

INSERT INTO FILM(FILM_ID, FILM_TITLE,FILM_TITLE_ENG, FILM_CONTENT, GENRE_ID, MATERIAL_ID,DIRECTOR_ID,
ACTOR_ID1,ACTOR_ID2,ACTOR_ID3, FILM_POSTER, FILM_GRADE_NAVER, RUNNING_TIME) 
VALUES(
FILM_SEQ.nextval,
'스틸 라이프',
'Still Life',
'나의 외로움과 쓸모를 발견해준 단 한 사람,당신의 존 메이는 누구인가요?',
1,
24,
(select DIRECTOR_ID from Director where DIRECTOR_NAME='우베르토 파솔리니'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='에디 마산'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='조앤 프로갓'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='앤드류 부찬'),
'스틸 라이프.jpg',
9.1,
93
);

INSERT INTO FILM(FILM_ID, FILM_TITLE,FILM_TITLE_ENG, FILM_CONTENT, GENRE_ID, MATERIAL_ID,DIRECTOR_ID,
ACTOR_ID1,ACTOR_ID2,ACTOR_ID3, FILM_POSTER, FILM_GRADE_NAVER, RUNNING_TIME) 
VALUES(
FILM_SEQ.nextval,
'보헤미안 랩소디',
'Bohemian Rhapsody',
'시대를 앞서가는 독창적인 음악과 화려한 퍼포먼스로 관중들을 사로잡으며 성장하던 ‘퀸’...',
1,
20,
(select DIRECTOR_ID from Director where DIRECTOR_NAME='브라이언 싱어'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='라미 말렉'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='루시 보인턴'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='귈림 리'),
'보헤미안 랩소디.jpg',
9.5,
134
);

INSERT INTO FILM(FILM_ID, FILM_TITLE,FILM_TITLE_ENG, FILM_CONTENT, GENRE_ID, MATERIAL_ID,DIRECTOR_ID,
ACTOR_ID1,ACTOR_ID2,ACTOR_ID3, FILM_POSTER, FILM_GRADE_NAVER, RUNNING_TIME) 
VALUES(
FILM_SEQ.nextval,
'베일리 어게인',
'A Dog'||CHR(39)||'s Purpose',
'귀여운 소년 ‘이든’의 단짝 반려견 ‘베일리’는 행복한 생을 마감한다.  하지만 눈을 떠보니 다시 시작된 견생 2회차, 아니 3회차?! ',
8,
23,
(select DIRECTOR_ID from Director where DIRECTOR_NAME='라세 할스트롬'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='조시 게드'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='데니스 퀘이드'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='K.J 아파'),
'베일리 어게인.jpg',
9.38,
100
);

INSERT INTO FILM(FILM_ID, FILM_TITLE,FILM_TITLE_ENG, FILM_CONTENT, GENRE_ID, MATERIAL_ID,DIRECTOR_ID,
ACTOR_ID1,ACTOR_ID2,ACTOR_ID3, FILM_POSTER, FILM_GRADE_NAVER, RUNNING_TIME) 
VALUES(
FILM_SEQ.nextval,
'아일라',
'Ayla: The Daughter of War',
'포화 속 생에 다시 없을 운명 같은 만남, 그리고… 60년간의 그리움 한국전쟁 참전병 ‘슐레이만’과 5살 소녀 ‘아일라’의 가슴 뜨거운 감동 실화! ',
10,
24,
(select DIRECTOR_ID from Director where DIRECTOR_NAME='잔 울카이'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='김설'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='이스마일 하지오글루'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='세틴 테킨도르'),
'아일라.jpg',
9.1,
123
);

INSERT INTO FILM(FILM_ID, FILM_TITLE,FILM_TITLE_ENG, FILM_CONTENT, GENRE_ID, MATERIAL_ID,DIRECTOR_ID,
ACTOR_ID1,ACTOR_ID2,ACTOR_ID3, FILM_POSTER, FILM_GRADE_NAVER, RUNNING_TIME) 
VALUES(
FILM_SEQ.nextval,
'폴란드로간 아이들',
'The Children Gone to Poland',
'“그 아이들에게 우리가 사랑한다고 전해주세요” 1951년, 한국전쟁 고아 1,500명이 비밀리에 폴란드로 보내졌다.',
7,
21,
(select DIRECTOR_ID from Director where DIRECTOR_NAME='추상미'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='이송'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='추상미'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='욜란타 크리소바타'),
'폴란드로간 아이들.jpg',
9.4,
79
);

INSERT INTO FILM(FILM_ID, FILM_TITLE,FILM_TITLE_ENG, FILM_CONTENT, GENRE_ID, MATERIAL_ID,DIRECTOR_ID,
ACTOR_ID1,ACTOR_ID2,ACTOR_ID3, FILM_POSTER, FILM_GRADE_NAVER, RUNNING_TIME) 
VALUES(
FILM_SEQ.nextval,
'당갈',
'Dangal',
'“남자든 여자든 금메달은 금메달인데!” 누구도 예상하지 못한 감동의 명승부!',
1,
7,
(select DIRECTOR_ID from Director where DIRECTOR_NAME='니테쉬 티와리'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='아미르 칸'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='파티마 사나 셰이크'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='산야 말호트라'),
'당갈.jpg',
9.4,
161
);

INSERT INTO FILM(FILM_ID, FILM_TITLE,FILM_TITLE_ENG, FILM_CONTENT, GENRE_ID, MATERIAL_ID,DIRECTOR_ID,
ACTOR_ID1,ACTOR_ID2,ACTOR_ID3, FILM_POSTER, FILM_GRADE_NAVER, RUNNING_TIME) 
VALUES(
FILM_SEQ.nextval,
'덕구',
'Stand by me',
'어린 손자와 살고 있는 일흔 살 덕구 할배는 자신에게 주어진 시간이 얼마 남지 않음을 알게 된다.',
1,
9,
(select DIRECTOR_ID from Director where DIRECTOR_NAME='방수인'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='이순재'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='정지훈'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='장광'),
'덕구.jpg',
9.45,
91
);

INSERT INTO FILM(FILM_ID, FILM_TITLE,FILM_TITLE_ENG, FILM_CONTENT, GENRE_ID, MATERIAL_ID,DIRECTOR_ID,
ACTOR_ID1,ACTOR_ID2,ACTOR_ID3, FILM_POSTER, FILM_GRADE_NAVER, RUNNING_TIME) 
VALUES(
FILM_SEQ.nextval,
'쇼생크 탈출',
'The Shawshank Redemption',
'촉망 받던 은행 부지점장 ‘앤디(팀 로빈슨 分)’는 아내와 그 애인을 살해한 혐의로 종신형을 받고 쇼생크 교도소에 수감된다. ',
1,
16,
(select DIRECTOR_ID from Director where DIRECTOR_NAME='프랭크 다라본트'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='팀 로빈스'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='모건 프리먼'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='밥 건튼'),
'쇼생크 탈출.jpg',
9.42,
142
);

INSERT INTO FILM(FILM_ID, FILM_TITLE,FILM_TITLE_ENG, FILM_CONTENT, GENRE_ID, MATERIAL_ID,DIRECTOR_ID,
ACTOR_ID1,ACTOR_ID2,ACTOR_ID3, FILM_POSTER, FILM_GRADE_NAVER, RUNNING_TIME) 
VALUES(
FILM_SEQ.nextval,
'원더',
'Wonder',
'넌 못생기지 않았어, 네게 관심있는 사람은 알게 될 거야 헬멧 속에 숨었던 아이 ‘어기, 세상 밖으로 나오다!',
1,
9,
(select DIRECTOR_ID from Director where DIRECTOR_NAME='스티븐 크보스키'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='제이콥 트렘블레이'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='줄리아 로버츠'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='오웬 윌슨'),
'원더.jpg',
9.41,
113
);

INSERT INTO FILM(FILM_ID, FILM_TITLE,FILM_TITLE_ENG, FILM_CONTENT, GENRE_ID, MATERIAL_ID,DIRECTOR_ID,
ACTOR_ID1,ACTOR_ID2,ACTOR_ID3, FILM_POSTER, FILM_GRADE_NAVER, RUNNING_TIME) 
VALUES(
FILM_SEQ.nextval,
'터미네이터2',
'Terminator 2: Judgment Day',
'인간과 기계의 대전쟁.. 그를 지키지 않으면 미래 또한 없다!',
14,
11,
(select DIRECTOR_ID from Director where DIRECTOR_NAME='제임스 카메론'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='아놀드 슈왈제네거'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='린다 해밀턴'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='에드워드 펄롱'),
'터미네이터2.jpg',
9.4,
137
);

INSERT INTO FILM(FILM_ID, FILM_TITLE,FILM_TITLE_ENG, FILM_CONTENT, GENRE_ID, MATERIAL_ID,DIRECTOR_ID,
ACTOR_ID1,ACTOR_ID2,ACTOR_ID3, FILM_POSTER, FILM_GRADE_NAVER, RUNNING_TIME) 
VALUES(
FILM_SEQ.nextval,
'번 더 스테이지:더 무비',
'Burn the Stage: the Movie',
'19개 도시, 40회의 공연, 55만석 날개를 펼친 소년들의 역사 성공적인 월드 투어로 마무리된 ‘2017 방탄소년단 라이브 트릴로지 에피소드3 윙스 투어',
1,
20,
(select DIRECTOR_ID from Director where DIRECTOR_NAME='박준수'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='RM'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='진'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='슈가'),
'번 더 스테이지_더 무비.jpg',
9.4,
83
);

INSERT INTO FILM(FILM_ID, FILM_TITLE,FILM_TITLE_ENG, FILM_CONTENT, GENRE_ID, MATERIAL_ID,DIRECTOR_ID,
ACTOR_ID1,ACTOR_ID2,ACTOR_ID3, FILM_POSTER, FILM_GRADE_NAVER, RUNNING_TIME) 
VALUES(
FILM_SEQ.nextval,
'인생은 아름다워',
'La Vita E Bella, Life Is Beautiful',
'로마에 갓 상경한 시골 총각 ‘귀도’는 운명처럼 만난 여인 ‘도라’에게 첫눈에 반한다. 넘치는 재치와 유머로 약혼자가 있던 그녀를 사로잡은 ‘귀도’는 ‘도라’와 단란한 가정을 꾸리며...',
1,
8,
(select DIRECTOR_ID from Director where DIRECTOR_NAME='로베르토 베니니'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='로베르토 베니니'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='니콜레타 브라스키'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='조르지오 깐따리니'),
'인생은 아름다워.jpg',
9.3,
116
);

INSERT INTO FILM(FILM_ID, FILM_TITLE,FILM_TITLE_ENG, FILM_CONTENT, GENRE_ID, MATERIAL_ID,DIRECTOR_ID,
ACTOR_ID1,ACTOR_ID2,ACTOR_ID3, FILM_POSTER, FILM_GRADE_NAVER, RUNNING_TIME) 
VALUES(
FILM_SEQ.nextval,
'매트릭스',
'The Matrix',
'서기 2199년, 인공지능 AI에 의해 인류가 재배되고 있다! 인간의 기억마저 AI에 의해 입력되고 삭제 되는 세상 진짜보다 더 진짜 같은 가상 현실 매트릭스',
14,
11,
(select DIRECTOR_ID from Director where DIRECTOR_NAME='릴리 워쇼스키'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='키아누 리브스'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='로렌스 피시번'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='캐리 앤 모스'),
'매트릭스.jpg',
9.3,
136
);

INSERT INTO FILM(FILM_ID, FILM_TITLE,FILM_TITLE_ENG, FILM_CONTENT, GENRE_ID, MATERIAL_ID,DIRECTOR_ID,
ACTOR_ID1,ACTOR_ID2,ACTOR_ID3, FILM_POSTER, FILM_GRADE_NAVER, RUNNING_TIME) 
VALUES(
FILM_SEQ.nextval,
'라이언 일병 구하기',
'Saving Private Ryan',
'임무는 단 한 사람(The Mission is a Man) 1944년 6월 6일 노르망디 상륙 작전. 오마하 해변에 대기하고 있던 병사들은 한치 앞도 내다볼 수 없는 긴장된 상황과 두려움에 무기력함을 감출 수 없었다.',
10,
21,
(select DIRECTOR_ID from Director where DIRECTOR_NAME='스티븐 스필버그'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='톰 행크스'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='에드워드 번즈'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='톰 시주모어'),
'라이언 일병 구하기.jpg',
9.3,
170
);

INSERT INTO FILM(FILM_ID, FILM_TITLE,FILM_TITLE_ENG, FILM_CONTENT, GENRE_ID, MATERIAL_ID,DIRECTOR_ID,
ACTOR_ID1,ACTOR_ID2,ACTOR_ID3, FILM_POSTER, FILM_GRADE_NAVER, RUNNING_TIME) 
VALUES(
FILM_SEQ.nextval,
'포레스트 검프',
'Forrest Gump',
'인생은 초콜릿 상자와 같은 거야. 네가 무엇을 고를지 아무도 모른단다…',
1,
8,
(select DIRECTOR_ID from Director where DIRECTOR_NAME='로버트 저메키스'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='톰 행크스'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='로빈 라이트'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='게리 시나이즈'),
'포레스트 검프.jpg',
9.3,
142
);

INSERT INTO FILM(FILM_ID, FILM_TITLE,FILM_TITLE_ENG, FILM_CONTENT, GENRE_ID, MATERIAL_ID,DIRECTOR_ID,
ACTOR_ID1,ACTOR_ID2,ACTOR_ID3, FILM_POSTER, FILM_GRADE_NAVER, RUNNING_TIME) 
VALUES(
FILM_SEQ.nextval,
'죽은 시인의 사회',
'Dead Poets Society',
'1859년에 창립된 미국의 명문 웰튼 아카데미의 새학기 개강식.  이 학교 출신인 ‘존 키팅’ 선생(로빈 윌리엄스)은 새 영어 교사로 부임한다. 첫 시간부터 ‘키팅’ 선생은 “카르페 디엠”을 외치며 파격적인 수업방식으로 학생들에게 신선한 충격을 주는데...',
1,
24,
(select DIRECTOR_ID from Director where DIRECTOR_NAME='피터 위어'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='로빈 윌리엄스'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='로버트 숀 레오나드'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='에단 호크'),
'죽은 시인의 사회.jpg',
9.3,
128
);

INSERT INTO FILM(FILM_ID, FILM_TITLE,FILM_TITLE_ENG, FILM_CONTENT, GENRE_ID, MATERIAL_ID,DIRECTOR_ID,
ACTOR_ID1,ACTOR_ID2,ACTOR_ID3, FILM_POSTER, FILM_GRADE_NAVER, RUNNING_TIME) 
VALUES(
FILM_SEQ.nextval,
'빽 투 더 퓨쳐',
'Back To The Future',
'힐 밸리(Hill Valley)에 사는 주인공 마티 맥플라이(Marty McFly: 마이클 J. 폭스 분)는 록큰롤, 스케이트보드, 그리고 자동차를 좋아하는 명랑 쾌할한 고교생으로, 아버지 죠지(George Douglas McFly: 크리스핀 글로버 분)와 어머니 로레인(Lorraine Baines: 리아 톰슨 분), 그리고 형과 누나가 있는 가정의 평범한 청소년이다....',
14,
34,
(select DIRECTOR_ID from Director where DIRECTOR_NAME='로버트 저메키스'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='마이클 J 폭스'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='크리스토퍼 로이드'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='리 톰슨'),
'빽 투 더 퓨쳐.jpg',
9.3,
120
);

INSERT INTO FILM(FILM_ID, FILM_TITLE,FILM_TITLE_ENG, FILM_CONTENT, GENRE_ID, MATERIAL_ID,DIRECTOR_ID,
ACTOR_ID1,ACTOR_ID2,ACTOR_ID3, FILM_POSTER, FILM_GRADE_NAVER, RUNNING_TIME) 
VALUES(
FILM_SEQ.nextval,
'월-E',
'WALL-E',
'예측불허! 차세대 영웅, 그가 지구 구하기에 나섰다! 텅 빈 지구에 홀로 남아 수백 년이란 시간을 외롭게 일만 하며 보내던 월-E...',
11,
35,
(select DIRECTOR_ID from Director where DIRECTOR_NAME='앤드류 스탠튼'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='월-E'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='이브'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='선장'),
'월-E.jpg',
9.3,
104
);

INSERT INTO FILM(FILM_ID, FILM_TITLE,FILM_TITLE_ENG, FILM_CONTENT, GENRE_ID, MATERIAL_ID,DIRECTOR_ID,
ACTOR_ID1,ACTOR_ID2,ACTOR_ID3, FILM_POSTER, FILM_GRADE_NAVER, RUNNING_TIME) 
VALUES(
FILM_SEQ.nextval,
'헬프',
'The Help',
'1963년, 미국 남부 미시시피 잭슨 흑인 가정부는 백인 주인과 화장실도 같이 쓸 수 없다?! 아무도 가정부의 삶에 대해 묻지 않았다. 그녀가 책을 쓰기 전까지는…',
10,
9,
(select DIRECTOR_ID from Director where DIRECTOR_NAME='테이트 테일러'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='엠마 스톤'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='비올라 데이비스'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='옥타비아 스펜서'),
'헬프.jpg',
9.3,
146
);

INSERT INTO FILM(FILM_ID, FILM_TITLE,FILM_TITLE_ENG, FILM_CONTENT, GENRE_ID, MATERIAL_ID,DIRECTOR_ID,
ACTOR_ID1,ACTOR_ID2,ACTOR_ID3, FILM_POSTER, FILM_GRADE_NAVER, RUNNING_TIME) 
VALUES(
FILM_SEQ.nextval,
'사운드 오브 뮤직',
'The Sound Of Music',
'알프스에서 들려오는 환상의 하모니! 세상에서 가장 사랑스러운 합창이 시작된다! 다 함께 도-레-미~♪♬ 음악을 사랑하는 말괄량이 견습 수녀 ‘마리아’는 원장 수녀의 권유로 해군 명문 집안 폰 트랩가의 가정교사가 된다.',
4,
20,
(select DIRECTOR_ID from Director where DIRECTOR_NAME='로버트 와이즈'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='줄리 앤드류스'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='크리스토퍼 플러머'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='엘레노 파커'),
'사운드 오브 뮤직.jpg',
9.3,
172
);

INSERT INTO FILM(FILM_ID, FILM_TITLE,FILM_TITLE_ENG, FILM_CONTENT, GENRE_ID, MATERIAL_ID,DIRECTOR_ID,
ACTOR_ID1,ACTOR_ID2,ACTOR_ID3, FILM_POSTER, FILM_GRADE_NAVER, RUNNING_TIME) 
VALUES(
FILM_SEQ.nextval,
'토이스토리3',
'Toy Story 3',
'전세계가 감동한 가장 위대한 탈출! 이별은 없어! 우리는 반드시 함께 돌아가야 해! 모든 장난감들이 겪는 가장 슬픈일은 바로 주인이 성장해 더이상 자신들과 놀아주지 않는 것. 우디와 버즈에게도 그 위기가 찾아온다....',
11,
23,
(select DIRECTOR_ID from Director where DIRECTOR_NAME='리 언크리치'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='우디'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='버즈라이트이어'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='제시'),
'토이스토리3.jpg',
9.3,
102
);

INSERT INTO FILM(FILM_ID, FILM_TITLE,FILM_TITLE_ENG, FILM_CONTENT, GENRE_ID, MATERIAL_ID,DIRECTOR_ID,
ACTOR_ID1,ACTOR_ID2,ACTOR_ID3, FILM_POSTER, FILM_GRADE_NAVER, RUNNING_TIME) 
VALUES(
FILM_SEQ.nextval,
'나 홀로 집에',
'Home Alone',
'이제 혼자 남은 꼬마 캐빈의 기발한 집지키기 전쟁이 시작된다! 크리스마스 시즌의 시카고. 말썽꾸러기라 집안 가족들로부터 욕을 듣고 따돌림 당하는 케빈은 늘 자신은 혼자 살거라면서 가족들이 모두 없어졌으면 좋겠다고 생각한다....',
12,
9,
(select DIRECTOR_ID from Director where DIRECTOR_NAME='크리스 콜럼버스'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='맥컬리 컬킨'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='조 페시'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='다니엘 스턴'),
'나 홀로 집에.jpg',
9.3,
105
);

INSERT INTO FILM(FILM_ID, FILM_TITLE,FILM_TITLE_ENG, FILM_CONTENT, GENRE_ID, MATERIAL_ID,DIRECTOR_ID,
ACTOR_ID1,ACTOR_ID2,ACTOR_ID3, FILM_POSTER, FILM_GRADE_NAVER, RUNNING_TIME) 
VALUES(
FILM_SEQ.nextval,
'살인의 추억',
'Memories Of Murder',
'연쇄살인 실화극 1986년 시골마을, 두 형사에겐 모든 것이 처음이었다. 당신은 지금 어디에 있는가... 미치도록 잡고 싶었다.....',
12,
14,
(select DIRECTOR_ID from Director where DIRECTOR_NAME='봉준호'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='송강호'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='김상경'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='김뢰하'),
'살인의 추억.jpg',
9.3,
132
);

INSERT INTO FILM(FILM_ID, FILM_TITLE,FILM_TITLE_ENG, FILM_CONTENT, GENRE_ID, MATERIAL_ID,DIRECTOR_ID,
ACTOR_ID1,ACTOR_ID2,ACTOR_ID3, FILM_POSTER, FILM_GRADE_NAVER, RUNNING_TIME) 
VALUES(
FILM_SEQ.nextval,
'위대한 쇼맨',
'The Greatest Showman',
'쇼 비즈니스의 창시자이자, 꿈의 무대로 전세계를 매료시킨 남자 ‘바넘’의 이야기에서 영감을 받아 탄생한 오리지널 뮤지컬 영화 <위대한 쇼맨>',
1,
20,
(select DIRECTOR_ID from Director where DIRECTOR_NAME='마이클 그레이시'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='휴 잭맨'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='잭 에프론'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='미셸 윌이엄스'),
'위대한 쇼맨.jpg',
9.3,
104
);

INSERT INTO FILM(FILM_ID, FILM_TITLE,FILM_TITLE_ENG, FILM_CONTENT, GENRE_ID, MATERIAL_ID,DIRECTOR_ID,
ACTOR_ID1,ACTOR_ID2,ACTOR_ID3, FILM_POSTER, FILM_GRADE_NAVER, RUNNING_TIME) 
VALUES(
FILM_SEQ.nextval,
'센과 치히로의 행방불명',
'The Spiriting Away Of Sen And Chihiro',
'이사 가던 날, 수상한 터널을 지나자 인간에게는 금지된 신들의 세계로 오게 된 치히로.. 신들의 음식을 먹은 치히로의 부모님은 돼지로 변해버린다.',
11,
9,
(select DIRECTOR_ID from Director where DIRECTOR_NAME='미야자키 하야오'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='치히로'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='하쿠'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='유바바'),
'센과 치히로의 행방불명.jpg',
9.3,
126
);

INSERT INTO FILM(FILM_ID, FILM_TITLE,FILM_TITLE_ENG, FILM_CONTENT, GENRE_ID, MATERIAL_ID,DIRECTOR_ID,
ACTOR_ID1,ACTOR_ID2,ACTOR_ID3, FILM_POSTER, FILM_GRADE_NAVER, RUNNING_TIME) 
VALUES(
FILM_SEQ.nextval,
'글래디에이터',
'Gladiator',
'느낄 수 있는가, 이 거대한 스펙터클의 전율을... ! 절정기의 로마제국은 그 영토가 광대하여 아프리카 사막에서 잉글랜드 북쪽까지 걸쳐 있었다. 그 당시 세계는 그 총인구의 1/4이 로마 황제의 지배 하에 있었다.',
9,
21,
(select DIRECTOR_ID from Director where DIRECTOR_NAME='리들리 스콧'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='러셀 크로우'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='호아킨 피닉스'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='코니 닐슨'),
'글래디에이터.jpg',
9.3,
154
);

INSERT INTO FILM(FILM_ID, FILM_TITLE,FILM_TITLE_ENG, FILM_CONTENT, GENRE_ID, MATERIAL_ID,DIRECTOR_ID,
ACTOR_ID1,ACTOR_ID2,ACTOR_ID3, FILM_POSTER, FILM_GRADE_NAVER, RUNNING_TIME) 
VALUES(
FILM_SEQ.nextval,
'반지의 제왕: 왕의 귀환',
'The Lord Of The Rings: The Return Of The King',
'21세기 가장 위대한 판타지 걸작의 귀환! 모든 힘을 지배할 악의 군주 ‘사우론’의 절대반지가 깨어나고 악의 세력이 세상을 지배해가며 중간계는 대혼란에 처한다. ',
10,
23,
(select DIRECTOR_ID from Director where DIRECTOR_NAME='피터 잭슨'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='일라이저 우드'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='숀 애스틴'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='앤디 서키스'),
'반지의 제왕_왕의 귀환.jpg',
9.3,
263
);

INSERT INTO FILM(FILM_ID, FILM_TITLE,FILM_TITLE_ENG, FILM_CONTENT, GENRE_ID, MATERIAL_ID,DIRECTOR_ID,
ACTOR_ID1,ACTOR_ID2,ACTOR_ID3, FILM_POSTER, FILM_GRADE_NAVER, RUNNING_TIME) 
VALUES(
FILM_SEQ.nextval,
'패왕별희',
'Farewell My Concubine',
'경극을 하는 두 남자의 사랑과 질투, 그리고 경극의 아름다움을 노래하는 이야기! 어려서 북경 경극학교에 맡겨진 ‘두지’(장국영)와 ‘시투’(장풍의)는 노력 끝에 최고의 경극배우가 된다.',
1,
13,
(select DIRECTOR_ID from Director where DIRECTOR_NAME='천카이거'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='장국영'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='공리'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='장풍의'),
'패왕별희.jpg',
9.3,
171
);

INSERT INTO FILM(FILM_ID, FILM_TITLE,FILM_TITLE_ENG, FILM_CONTENT, GENRE_ID, MATERIAL_ID,DIRECTOR_ID,
ACTOR_ID1,ACTOR_ID2,ACTOR_ID3, FILM_POSTER, FILM_GRADE_NAVER, RUNNING_TIME) 
VALUES(
FILM_SEQ.nextval,
'레옹',
'Leon',
'“사랑해요. 내 첫사랑 레옹.”_마틸다 “나도 행복해 지고 싶어. 잠도 자고, 뿌리도 내릴 꺼야.”_레옹',
12,
15,
(select DIRECTOR_ID from Director where DIRECTOR_NAME='뤽 베송'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='장 르노'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='나탈리 포트만'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='게리 올드만'),
'레옹.jpg',
9.3,
110
);

INSERT INTO FILM(FILM_ID, FILM_TITLE,FILM_TITLE_ENG, FILM_CONTENT, GENRE_ID, MATERIAL_ID,DIRECTOR_ID,
ACTOR_ID1,ACTOR_ID2,ACTOR_ID3, FILM_POSTER, FILM_GRADE_NAVER, RUNNING_TIME) 
VALUES(
FILM_SEQ.nextval,
'아이 캔 스피크',
'I Can Speak',
'꼭…하고 싶은 말이 있고, 듣고 싶은 말이 있다!  20여 년간 누구도 막을 수 없었던 그녀 앞에 원칙주의 9급 공무원 ‘민재’가 나타나면서 팽팽한 긴장감이 흐른다.',
1,
24,
(select DIRECTOR_ID from Director where DIRECTOR_NAME='김현석'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='나문희'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='이제훈'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='박철민'),
'아이 캔 스피크.jpg',
9.3,
119
);

INSERT INTO FILM(FILM_ID, FILM_TITLE,FILM_TITLE_ENG, FILM_CONTENT, GENRE_ID, MATERIAL_ID,DIRECTOR_ID,
ACTOR_ID1,ACTOR_ID2,ACTOR_ID3, FILM_POSTER, FILM_GRADE_NAVER, RUNNING_TIME) 
VALUES(
FILM_SEQ.nextval,
'클래식',
'The Classic',
'우연히, 우연히, 우연히... 그러나... 반드시 잊혀진 약속이 깨어났다. 같은 대학에 다니는 지혜(손예진 분)와 수경(이수인 분)은 연극반 선배 상민(조인성 분)을 좋아한다.',
4,
13,
(select DIRECTOR_ID from Director where DIRECTOR_NAME='곽재용'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='손예진'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='조승우'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='조인성'),
'클래식.jpg',
9.3,
132
);

INSERT INTO FILM(FILM_ID, FILM_TITLE,FILM_TITLE_ENG, FILM_CONTENT, GENRE_ID, MATERIAL_ID,DIRECTOR_ID,
ACTOR_ID1,ACTOR_ID2,ACTOR_ID3, FILM_POSTER, FILM_GRADE_NAVER, RUNNING_TIME) 
VALUES(
FILM_SEQ.nextval,
'동주',
'DongJu; The Portrait of A Poet',
'이름도, 언어도, 꿈도, 모든 것이 허락되지 않았던 일제강점기. 한 집에서 태어나고 자란 동갑내기 사촌지간 동주와 몽규. 시인을 꿈꾸는 청년 동주',
1,
21,
(select DIRECTOR_ID from Director where DIRECTOR_NAME='이준익'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='강하늘'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='박정민'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='김인우'),
'동주.jpg',
9.3,
110
);

INSERT INTO FILM(FILM_ID, FILM_TITLE,FILM_TITLE_ENG, FILM_CONTENT, GENRE_ID, MATERIAL_ID,DIRECTOR_ID,
ACTOR_ID1,ACTOR_ID2,ACTOR_ID3, FILM_POSTER, FILM_GRADE_NAVER, RUNNING_TIME) 
VALUES(
FILM_SEQ.nextval,
'캐스트 어웨이',
'Cast Away',
'세상의 끝에서 그의 여행이 시작된다! 캘리가 선물해준 시계를 손에 꼭 쥐고 "페덱스" 전용 비행기에 올랐는데, 착륙하기 직전 사고가 나고, 기내는 아수라장이 된다.',
1,
23,
(select DIRECTOR_ID from Director where DIRECTOR_NAME='로버트 저메키스'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='톰 행크스'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='헬렌 헌트'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='닉 서시'),
'캐스트 어웨이.jpg',
9.3,
143
);

INSERT INTO FILM(FILM_ID, FILM_TITLE,FILM_TITLE_ENG, FILM_CONTENT, GENRE_ID, MATERIAL_ID,DIRECTOR_ID,
ACTOR_ID1,ACTOR_ID2,ACTOR_ID3, FILM_POSTER, FILM_GRADE_NAVER, RUNNING_TIME) 
VALUES(
FILM_SEQ.nextval,
'굿바이 마이 프랜드',
'The Cure',
'왕성한 호기심에 제법 의협심까지 갖춘 에릭(Erik: 브래드 렌프로 분)은, 이혼한 엄마와 살며 불치병에 걸린 옆집 소년 덱스터(Dexter: 조셉 마젤로 분)의 친구다. 덱스터는 어린 아이 때 수혈에 의해 에이즈에 감염됐다. ',
1,
24,
(select DIRECTOR_ID from Director where DIRECTOR_NAME='피터 호튼'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='조셉 마젤로'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='브래드 렌프로'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='다이아나 스카위드'),
'굿바이 마이 프랜드.jpg',
9.3,
97
);

INSERT INTO FILM(FILM_ID, FILM_TITLE,FILM_TITLE_ENG, FILM_CONTENT, GENRE_ID, MATERIAL_ID,DIRECTOR_ID,
ACTOR_ID1,ACTOR_ID2,ACTOR_ID3, FILM_POSTER, FILM_GRADE_NAVER, RUNNING_TIME) 
VALUES(
FILM_SEQ.nextval,
'여인의 향기',
'Scent Of A Woman',
'스텝이 엉키면 그게 바로 탱고예요! 크리스마스에 고향에 가기 위해 부활절 연휴 동안 아르바이트를 해야 하는 고등학생 찰리(크리스 오도넬 분)은 교내 아르바이트 게시판을 보고 찾아간 집에서 퇴역한 장교 프랭크 슬레이드(알 파치노 분) 중령과 만나게 된다.',
1,
8,
(select DIRECTOR_ID from Director where DIRECTOR_NAME='마틴 브레스트'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='알 파치노'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='크리스 오도넬'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='제임스 레브혼'),
'여인의 향기.jpg',
9.3,
157
);

INSERT INTO FILM(FILM_ID, FILM_TITLE,FILM_TITLE_ENG, FILM_CONTENT, GENRE_ID, MATERIAL_ID,DIRECTOR_ID,
ACTOR_ID1,ACTOR_ID2,ACTOR_ID3, FILM_POSTER, FILM_GRADE_NAVER, RUNNING_TIME) 
VALUES(
FILM_SEQ.nextval,
'반지의 제왕: 두 개의 탑',
'The Lord Of The Rings: The Two Towers',
'21세기 가장 위대한 판타지 걸작의 귀환! 모든 힘을 지배할 악의 군주 ‘사우론’의 절대반지가 깨어나고 악의 세력이 세상을 지배해가며 중간계는 대혼란에 처한다.',
10,
23,
(select DIRECTOR_ID from Director where DIRECTOR_NAME='피터 잭슨'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='일라이저 우드'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='이안 맥켈런'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='비고 모텐슨'),
'반지의 제왕_두 개의 탑.jpg',
9.3,
235
);

INSERT INTO FILM(FILM_ID, FILM_TITLE,FILM_TITLE_ENG, FILM_CONTENT, GENRE_ID, MATERIAL_ID,DIRECTOR_ID,
ACTOR_ID1,ACTOR_ID2,ACTOR_ID3, FILM_POSTER, FILM_GRADE_NAVER, RUNNING_TIME) 
VALUES(
FILM_SEQ.nextval,
'미세스 다웃파이어',
'Mrs. Doubtfire',
'만화영화 더빙 성우이며 거리낌 없고 자유분방한 삶을 사는 다니엘(Daniel Hillard: 로빈 윌리암스 분)은 주변 사람들을 늘 즐겁게 해준다. 특히, 그의 아이들에게 아빠는 영웅이다. 그 또한 세 아이들을 위해서 무엇이든지 한다.',
8,
9,
(select DIRECTOR_ID from Director where DIRECTOR_NAME='크리스 콜럼버스'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='로빈 윌리엄스'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='샐리 필드'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='피어스 브로스넌'),
'미세스 다웃파이어.jpg',
9.3,
125
);

INSERT INTO FILM(FILM_ID, FILM_TITLE,FILM_TITLE_ENG, FILM_CONTENT, GENRE_ID, MATERIAL_ID,DIRECTOR_ID,
ACTOR_ID1,ACTOR_ID2,ACTOR_ID3, FILM_POSTER, FILM_GRADE_NAVER, RUNNING_TIME) 
VALUES(
FILM_SEQ.nextval,
'주토피아',
'Zootopia',
'누구나 살고 싶은 도시 1위, 주토피아 연쇄 실종 사건 발생! “미치도록 잡고 싶었다!” ',
11,
22,
(select DIRECTOR_ID from Director where DIRECTOR_NAME='바이론 하워드'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='주디 홉스'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='닉 와일드'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='가젤'),
'주토피아.jpg',
9.3,
108
);

INSERT INTO FILM(FILM_ID, FILM_TITLE,FILM_TITLE_ENG, FILM_CONTENT, GENRE_ID, MATERIAL_ID,DIRECTOR_ID,
ACTOR_ID1,ACTOR_ID2,ACTOR_ID3, FILM_POSTER, FILM_GRADE_NAVER, RUNNING_TIME) 
VALUES(
FILM_SEQ.nextval,
'에이리언 2',
'Aliens2',
'에이리언과의 싸움에서 간신히 살아남은 리플리는 잠든 채로 57년을 떠돌다 구조선에 의해 구출된다. ',
14,
11,
(select DIRECTOR_ID from Director where DIRECTOR_NAME='제임스 카메론'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='시고니 위버'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='마이클 빈'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='가폴 레이저'),
'에이리언 2.jpg',
9.3,
137
);

INSERT INTO FILM(FILM_ID, FILM_TITLE,FILM_TITLE_ENG, FILM_CONTENT, GENRE_ID, MATERIAL_ID,DIRECTOR_ID,
ACTOR_ID1,ACTOR_ID2,ACTOR_ID3, FILM_POSTER, FILM_GRADE_NAVER, RUNNING_TIME) 
VALUES(
FILM_SEQ.nextval,
'알라딘',
'Aladdin',
'오늘, 당신의 꿈이 이루어집니다! | 함께 가요! 사랑의 양탄자를 타고 꿈과 모험이 있는 환상의 세계로',
11,
9,
(select DIRECTOR_ID from Director where DIRECTOR_NAME='존 머스커'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='알라딘'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='램프의 요정지니'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='쟈스민 공주'),
'알라딘.jpg',
9.3,
90
);

INSERT INTO FILM(FILM_ID, FILM_TITLE,FILM_TITLE_ENG, FILM_CONTENT, GENRE_ID, MATERIAL_ID,DIRECTOR_ID,
ACTOR_ID1,ACTOR_ID2,ACTOR_ID3, FILM_POSTER, FILM_GRADE_NAVER, RUNNING_TIME) 
VALUES(
FILM_SEQ.nextval,
'서유기 2 - 선리기연',
'A Chinese Odyssey Part Two - Cinderella',
'<서유기 월광보합>의 완결편. 지존보는 500년전의 세계로 와서 자하란 여자를 만나는데 이 여자는 500년 후에 백정정과 춘삼십낭의 사부가 되는 반사대사이다.',
8,
23,
(select DIRECTOR_ID from Director where DIRECTOR_NAME='유진위'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='주성치'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='주인'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='나가영'),
'서유기 2_선리기연.jpg',
9.3,
99
);

INSERT INTO FILM(FILM_ID, FILM_TITLE,FILM_TITLE_ENG, FILM_CONTENT, GENRE_ID, MATERIAL_ID,DIRECTOR_ID,
ACTOR_ID1,ACTOR_ID2, FILM_POSTER, FILM_GRADE_NAVER, RUNNING_TIME) 
VALUES(
FILM_SEQ.nextval,
'다시 태어나도 우리',
'Becoming Who I Was',
'약속해요, 언젠가 돌아와 다시 만나게 될 거라고… 모든 것을 초월한 오직 두 사람의 가장 아름다운 여정',
7,
21,
(select DIRECTOR_ID from Director where DIRECTOR_NAME='문찬용'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='파드마 앙뚜'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='우르갼 릭젠'),
'다시 태어나도 우리.jpg',
9.3,
95
);

INSERT INTO FILM(FILM_ID, FILM_TITLE,FILM_TITLE_ENG, FILM_CONTENT, GENRE_ID, MATERIAL_ID,DIRECTOR_ID,
ACTOR_ID1,ACTOR_ID2, ACTOR_ID3, FILM_POSTER, FILM_GRADE_NAVER, RUNNING_TIME) 
VALUES(
FILM_SEQ.nextval,
'세 얼간이',
'3 Idiots',
'‘알 이즈 웰’을 외치던 유쾌한 세 남자가 돌아왔다! 천재들만 간다는 일류 명문대 ICE, 성적과 취업만을 강요하는 학교를 발칵 뒤집어 놓은 대단한 녀석 란초! ',
8,
8,
(select DIRECTOR_ID from Director where DIRECTOR_NAME='라지쿠마르 히라니'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='아미르 칸'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='마드하반'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='셔먼조쉬'),
'세 얼간이.jpg',
9.3,
141
);

INSERT INTO FILM(FILM_ID, FILM_TITLE,FILM_TITLE_ENG, FILM_CONTENT, GENRE_ID, MATERIAL_ID,DIRECTOR_ID,
ACTOR_ID1,ACTOR_ID2, ACTOR_ID3, FILM_POSTER, FILM_GRADE_NAVER, RUNNING_TIME) 
VALUES(
FILM_SEQ.nextval,
'히든 피겨스',
'Hidden Figures',
'회의 참여 불가 화장실 이용 불가 식당 이용 불가 세상의 편견에 맞선, 정.면.돌.파 그녀들이 온다',
1,
24,
(select DIRECTOR_ID from Director where DIRECTOR_NAME='데오도르 멜피'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='타라지 P 헨슨'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='옥타비아 스펜서'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='자넬 모네'),
'히든 피겨스.jpg',
9.3,
127
);

INSERT INTO FILM(FILM_ID, FILM_TITLE,FILM_TITLE_ENG, FILM_CONTENT, GENRE_ID, MATERIAL_ID,DIRECTOR_ID,
ACTOR_ID1,ACTOR_ID2, ACTOR_ID3, FILM_POSTER, FILM_GRADE_NAVER, RUNNING_TIME) 
VALUES(
FILM_SEQ.nextval,
'굿 윌 헌팅',
'Good Will Hunting',
'윌, 네 잘못이 아니야.',
1,
24,
(select DIRECTOR_ID from Director where DIRECTOR_NAME='구스 반 산트'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='맷 데이먼'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='로빈 윌리엄스'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='벤 애플랙'),
'굿 윌 헌팅.jpg',
9.3,
126
);

INSERT INTO FILM(FILM_ID, FILM_TITLE,FILM_TITLE_ENG, FILM_CONTENT, GENRE_ID, MATERIAL_ID,DIRECTOR_ID,
ACTOR_ID1,ACTOR_ID2, FILM_POSTER, FILM_GRADE_NAVER, RUNNING_TIME) 
VALUES(
FILM_SEQ.nextval,
'울지마 톤즈',
'Dont Cry for Me Sudan',
'2010년 2월, 아프리카 수단 남쪽의 작은 마을 톤즈. 남 수단의 자랑인 톤즈 브라스 밴드가 마을을 행진했다. 선두에선 소년들은 한 남자의 사진을 들고 있고 있었다. 환하게 웃고 있는 사진 속 한 남자…',
7,
21,
(select DIRECTOR_ID from Director where DIRECTOR_NAME='구수환'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='이금희'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='이태석'),
'울지마 톤즈.jpg',
9.3,
91
);

INSERT INTO FILM(FILM_ID, FILM_TITLE,FILM_TITLE_ENG, FILM_CONTENT, GENRE_ID, MATERIAL_ID,DIRECTOR_ID,
ACTOR_ID1,ACTOR_ID2,ACTOR_ID3, FILM_POSTER, FILM_GRADE_NAVER, RUNNING_TIME) 
VALUES(
FILM_SEQ.nextval,
'그대를 사랑합니다',
'I Love You',
'This couple is… 따뜻하게 눈 내리는 새벽 골목길에서 우연히 만난 만석과 이뿐! 사랑하는 그대를 생각하기만 해도 얼굴에 함박웃음이 가득 번지는 설레는 사랑으로 이어지기 시작한다.',
1,
13,
(select DIRECTOR_ID from Director where DIRECTOR_NAME='추창민'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='이순재'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='윤소정'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='송재호'),
'그대를 사랑합니다.jpg',
9.3,
118
);

INSERT INTO FILM(FILM_ID, FILM_TITLE,FILM_TITLE_ENG, FILM_CONTENT, GENRE_ID, MATERIAL_ID,DIRECTOR_ID,
ACTOR_ID1,ACTOR_ID2,ACTOR_ID3, FILM_POSTER, FILM_GRADE_NAVER, RUNNING_TIME) 
VALUES(
FILM_SEQ.nextval,
'아마데우스',
'Amadeus',
'천재를 시기한 평범한 궁정음악가의 질투에서 시작된 광기에 찬 파멸의 서곡!',
1,
20,
(select DIRECTOR_ID from Director where DIRECTOR_NAME='밀로스 포만'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='F 머레이 아브라함'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='엘리자베스 베리지'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='로이 도트라이스'),
'아마데우스.jpg',
9.3,
180
);

INSERT INTO FILM(FILM_ID, FILM_TITLE,FILM_TITLE_ENG, FILM_CONTENT, GENRE_ID, MATERIAL_ID,DIRECTOR_ID,
ACTOR_ID1,ACTOR_ID2,ACTOR_ID3, FILM_POSTER, FILM_GRADE_NAVER, RUNNING_TIME) 
VALUES(
FILM_SEQ.nextval,
'쉰들러 리스트',
'Schindlers List',
'독일군 점령지인 폴란드의 크라코우. 기회주의자인 오스카 쉰들러(Oskar Schindler: 리암 니슨 분)는 폴란드계 유태인이 경영하는 그릇 공장을 인수하러 도착한다.',
10,
21,
(select DIRECTOR_ID from Director where DIRECTOR_NAME='스티븐 스필버그'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='리암 니슨'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='벤 킹슬리'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='랄프 파인즈'),
'쉰들러 리스트.jpg',
9.3,
192
);

INSERT INTO FILM(FILM_ID, FILM_TITLE,FILM_TITLE_ENG, FILM_CONTENT, GENRE_ID, MATERIAL_ID,DIRECTOR_ID,
ACTOR_ID1,ACTOR_ID2,ACTOR_ID3, FILM_POSTER, FILM_GRADE_NAVER, RUNNING_TIME) 
VALUES(
FILM_SEQ.nextval,
'지금 만나러 갑니다',
'Be With You',
'이 세상, 하나뿐인 내 사랑… 남편 ‘타쿠미’와 아들 ‘유우지’에게 비의 계절에 다시 돌아오겠다는 약속을 남기고 세상을 떠난 미오',
4,
14,
(select DIRECTOR_ID from Director where DIRECTOR_NAME='도이 노부히로'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='다케우치 유코'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='나카무라 시도'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='다케이 아카시'),
'지금 만나러 갑니다.jpg',
9.3,
118
);

INSERT INTO FILM(FILM_ID, FILM_TITLE,FILM_TITLE_ENG, FILM_CONTENT, GENRE_ID, MATERIAL_ID,DIRECTOR_ID,
ACTOR_ID1,ACTOR_ID2,ACTOR_ID3, FILM_POSTER, FILM_GRADE_NAVER, RUNNING_TIME) 
VALUES(
FILM_SEQ.nextval,
'토이 스토리',
'Toy Story',
'우디(톰 행크스 목소리 분)는 6살짜리 남자 아이 앤디가 가장 아끼는 카우보이 인형인데, 어느날 접었다 폈다 하는 날개와 레이저 디지털 음성을 가진 최신 액션 인형 버즈(팀 알렌 목소리 연기)가 나타나자 그의 위치가 흔들리기 시작한다.',
11,
9,
(select DIRECTOR_ID from Director where DIRECTOR_NAME='존 라세터'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='우디'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='버즈라이트이어'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='미스터 포테이토 헤드'),
'토이 스토리.jpg',
9.3,
77
);

INSERT INTO FILM(FILM_ID, FILM_TITLE,FILM_TITLE_ENG, FILM_CONTENT, GENRE_ID, MATERIAL_ID,DIRECTOR_ID,
ACTOR_ID1,ACTOR_ID2,ACTOR_ID3, FILM_POSTER, FILM_GRADE_NAVER, RUNNING_TIME) 
VALUES(
FILM_SEQ.nextval,
'길버트 그레이프',
'Whats Eating Gilbert Grape',
'한치 앞도 모르는 게 인생이지만, 그래서 인생은 재미있지 않니?',
1,
24,
(select DIRECTOR_ID from Director where DIRECTOR_NAME='라세 할스트롬'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='조니 뎁'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='줄리엣 루이스'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='레오나르도 디카프리오'),
'길버트 그레이프.jpg',
9.0,
118
);

INSERT INTO FILM(FILM_ID, FILM_TITLE,FILM_TITLE_ENG, FILM_CONTENT, GENRE_ID, MATERIAL_ID,DIRECTOR_ID,
ACTOR_ID1,ACTOR_ID2,ACTOR_ID3, FILM_POSTER, FILM_GRADE_NAVER, RUNNING_TIME) 
VALUES(
FILM_SEQ.nextval,
'에반게리온:파',
'Evangelion: 2.0 You Can [Not] Advance',
'2015년 현재, ‘세컨드 임팩트’의 충격으로 인류의 절반이 사라진 이 곳에 정체불명의 사도들이 다시 공격해 오기 시작한다.',
11,
11,
(select DIRECTOR_ID from Director where DIRECTOR_NAME='안노 히데아키'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='이카리 신지'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='아야나미 레이'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='아스카'),
'에반게리온_파.jpg',
9.1,
108
);

INSERT INTO FILM(FILM_ID, FILM_TITLE,FILM_TITLE_ENG, FILM_CONTENT, GENRE_ID, MATERIAL_ID,DIRECTOR_ID,
ACTOR_ID1,ACTOR_ID2,ACTOR_ID3, FILM_POSTER, FILM_GRADE_NAVER, RUNNING_TIME) 
VALUES(
FILM_SEQ.nextval,
'샤인',
'Shine',
'난 충분히 미쳤어요. 그렇지 않아요?',
1,
20,
(select DIRECTOR_ID from Director where DIRECTOR_NAME='스콧 힉스'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='제프리 러쉬'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='노아 테일러'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='아민 믈러 스탈'),
'샤인.jpg',
9.0,
105
);

INSERT INTO FILM(FILM_ID, FILM_TITLE,FILM_TITLE_ENG, FILM_CONTENT, GENRE_ID, MATERIAL_ID,DIRECTOR_ID,
ACTOR_ID1,ACTOR_ID2,ACTOR_ID3, FILM_POSTER, FILM_GRADE_NAVER, RUNNING_TIME) 
VALUES(
FILM_SEQ.nextval,
'히트',
'Heat',
'LA 경찰국 강력계의 빈센트 한나(알 파치노) 반장은 두 번의 이혼 경력과 순탄치 않은 세 번째 결혼생활로 불안하고 우울한 일상을 이어간다.',
9,
16,
(select DIRECTOR_ID from Director where DIRECTOR_NAME='마이클 만'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='알 파치노'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='로버트 드 니로'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='발 킬머'),
'히트.jpg',
9.1,
170
);

INSERT INTO FILM(FILM_ID, FILM_TITLE,FILM_TITLE_ENG, FILM_CONTENT, GENRE_ID, MATERIAL_ID,DIRECTOR_ID,
ACTOR_ID1,ACTOR_ID2,ACTOR_ID3, FILM_POSTER, FILM_GRADE_NAVER, RUNNING_TIME) 
VALUES(
FILM_SEQ.nextval,
'러브레터',
'Love Letter',
'오늘에서야 다시 꺼내봅니다. 당신이 머문 곳에서…',
4,
13,
(select DIRECTOR_ID from Director where DIRECTOR_NAME='이와이 슌지'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='나카야마 미호'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='도요카와 에츠시'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='한 분샤쿠'),
'러브레터.jpg',
9.1,
117
);

INSERT INTO FILM(FILM_ID, FILM_TITLE,FILM_TITLE_ENG, FILM_CONTENT, GENRE_ID, MATERIAL_ID,DIRECTOR_ID,
ACTOR_ID1,ACTOR_ID2,ACTOR_ID3, FILM_POSTER, FILM_GRADE_NAVER, RUNNING_TIME) 
VALUES(
FILM_SEQ.nextval,
'혐오스런 마츠코의 일생',
'Memories Of Matsuko',
'마츠코야 울지마라 사랑이 있다! 눈물나게 아름다운 그 여자의 잔혹동화',
8,
21,
(select DIRECTOR_ID from Director where DIRECTOR_NAME='나카시마 테츠야'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='나카타니 미키'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='에이타'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='이세야 유스케'),
'혐오스런 마츠코의 일생.jpg',
9.1,
129
);

INSERT INTO FILM(FILM_ID, FILM_TITLE,FILM_TITLE_ENG, FILM_CONTENT, GENRE_ID, MATERIAL_ID,DIRECTOR_ID,
ACTOR_ID1,ACTOR_ID2,ACTOR_ID3, FILM_POSTER, FILM_GRADE_NAVER, RUNNING_TIME) 
VALUES(
FILM_SEQ.nextval,
'스피드',
'Speed',
'GET READY FOR RUSH HOUR!!',
9,
16,
(select DIRECTOR_ID from Director where DIRECTOR_NAME='쟝 드봉'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='키아누 리브스'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='데니스 호퍼'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='산드라 블록'),
'스피드.jpg',
9.1,
115
);

INSERT INTO FILM(FILM_ID, FILM_TITLE,FILM_TITLE_ENG, FILM_CONTENT, GENRE_ID, MATERIAL_ID,DIRECTOR_ID,
ACTOR_ID1,ACTOR_ID2,ACTOR_ID3, FILM_POSTER, FILM_GRADE_NAVER, RUNNING_TIME) 
VALUES(
FILM_SEQ.nextval,
'클레멘타인',
'Clementine 2004',
'트럼프가 극찬하고 오스카상을 수여하기에 오스카가 부끄러운 그 영화!! 아빠 일어나!',
9,
9,
(select DIRECTOR_ID from Director where DIRECTOR_NAME='김두영'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='이동준'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='김혜리'),
(select ACTOR_ID from ACTOR where ACTOR_NAME='스티븐 시걸'),
'클레멘타인.jpg',
9.3,
100
);