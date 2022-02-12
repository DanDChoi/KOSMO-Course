create table GROUPTAB(
   GSEQ number constraint GROUPTAB_PK primary key,
   GR_LOC nvarchar2(30),
   GR_NAME nvarchar2(40),
   GR_INTRO nvarchar2(2000),
   GR_INTEREST nvarchar2(40),
   GR_LIMIT number,
   GR_RDATE date,
   MNUM number,
   GT_NAME
   GT_DATE
   GT_TIME
   GT_PLACE
   GT_PRICE
   GT_LIMIT
);
create sequence GROUPTAB_SEQ increment by 1 start with 1 nocache;

insert into GROUPTAB values(GROUPTAB_SEQ.nextval, '서울시 금천구', '코딩해요~', '같이 코딩하면서 즐겨요!', 'IT', 50, SYSDATE, 1);
insert into GROUPTAB values(GROUPTAB_SEQ.nextval, '서울시 관악구', '행축 (행복축구 하실 분)', '축구하면서 친목쌓고 노실 분들 오세요~', '스포츠', 30, SYSDATE, 2);
insert into GROUPTAB values(GROUPTAB_SEQ.nextval, '경기도 광명시', '맛집탐방', '동네 숨은 맛집 같이 찾으실 분들 ㄱㄱ', '사교', 50, SYSDATE, 3);

create table GATHERING(
   GT_SEQ number constraint GATHERING_PK primary key,
   GT_NAME nvarchar2(40),
   GT_DATE nvarchar2(20),
   TIME nvarchar2(40),
   GT_PLACE nvarchar2(40),
   PRICE nvarchar2(20),
   GT_LIMIT number
     );

create sequence GATHERING_SEQ increment by 1 start with 1 nocache;



UPDATE GATHERING SET GT_NAME=?, GT_DATE=?, TIME=?, GT_PLACE=?, PRICE=?, GT_LIMIT=? WHERE SEQ=?

SELECT * FROM GATHERING WHERE SEQ=?



private void gatheringUpdate(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException {
	GatheringService service = GatheringService.getInstance();
	long seq = Long.parseLong(mr.getParameter("seq"));

	String gt_name = request.getParameter("gt_name");
	String gt_date = request.getParameter("gt_date");
	String time = request.getParameter("time");
	String gt_place = request.getParameter("gt_place");
	String price = request.getParameter("price");

	Gathering dto = new Gathering(-1, gt_name, gt_date, time, gt_place, price, gt_limit);
	boolean gt_update = service.gatheringUpdateS(dto);
	request.setAttribute("gt_update", gt_update);
	
	String view = "groupInsert.jsp";
	RequestDispatcher rd = request.getRequestDispatcher(view);
	rd.forward(request, response);
	}

private long getSeq(HttpServletRequest request) {
long seq = -1;
String seqStr = request.getParameter("gt_seq");
if(seqStr != null) {
	seqStr = seqStr.trim();
	if(seqStr.length() != 0) {
		try {
			seq = Long.parseLong(seqStr);
			return seq;
		}catch(NumberFormatException ne) {
		}
	}
}
return seq;
}