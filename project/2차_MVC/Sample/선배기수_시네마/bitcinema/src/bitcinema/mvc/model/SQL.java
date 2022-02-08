package bitcinema.mvc.model;

class SQL
{
	// Search
	final static String SEARCH_FILM = "select FILM_ID, FILM_TITLE from FILM where FILM_TITLE like ?";
	
	// Signin & Signup
	final static String EMAIL_CHECK = "select EMAIL from MEMBER";
	final static String PW_CHECK = "select PWD from MEMBER where EMAIL = ?";
	final static String SIGNUP = "insert into MEMBER values(?, ?, ?, SYSDATE, 0)";
	
	// Select
	final static String GENRE_LIST = "select * from GENRE";
	final static String DIRECTOR_LIST = "select * from DIRECTOR";
	final static String ACTOR_LIST = "select * from ACTOR";
	final static String MATERIAL_LIST = "select * from MATERIAL";
	
	// Main
	final static String SELECT_GENRE = "select * from(select * from FILM where GENRE_ID = ? or GENRE_ID = ? or GENRE_ID = ? order by DBMS_RANDOM.RANDOM()) where ROWNUM <= 3";
	final static String SELECT_DIRECTOR = "select * from(select * from FILM where DIRECTOR_ID = ? or DIRECTOR_ID = ? or DIRECTOR_ID = ? order by DBMS_RANDOM.RANDOM()) where ROWNUM <= 3";
	final static String SELECT_ACTOR = "select * from(select * from FILM where ((ACTOR_ID1 = ? or ACTOR_ID1 = ? or ACTOR_ID1 = ?) or (ACTOR_ID2 = ? or ACTOR_ID2 = ? or ACTOR_ID2 = ?) or (ACTOR_ID3 = ? or ACTOR_ID3 = ? or ACTOR_ID3 = ?)) order by DBMS_RANDOM.RANDOM()) where ROWNUM <= 3";
	final static String SELECT_MATERIALS = "select * from(select * from FILM where MATERIAL_ID = ? or MATERIAL_ID = ? or MATERIAL_ID = ? order by DBMS_RANDOM.RANDOM()) where ROWNUM <= 3";

	// Film detail
	final static String FILM_DETAIL = "select * from FILM where FILM_ID = ?";
	final static String FILM_DETAIL_DIRECTOR = "select * from DIRECTOR where DIRECTOR_NAME = ?";
	final static String FILM_DETAIL_ACTOR = "select * from ACTOR where ACTOR_NAME = ?";
	
	// Review List
	final static String REVIEW_LIST = "select * from FILM_REVIEW where FILM_ID = ? order by WRITEDATE desc";
	final static String REVIEW_INSERT = "insert into FILM_REVIEW values(?, ?, ?, SYSDATE, ?)";
	final static String REVIEW_DELETE = "delete FILM_REVIEW where FILM_ID = ? and REVIEW_WRITER = ?";
	
	// AVG BIT Grade
	final static String AVG_GRADE_BIT = "select AVG(REVIEW_GRADE) FILM_GRADE_BIT from FILM_REVIEW where FILM_ID = ?";
	
	// Search
	final static String SEARCH_FILM_TITLE = "select FILM_TITLE from FILM where FILM_TITLE like ?";
	final static String SEARCH_CONVERT = "select FILM_ID from FILM where FILM_TITLE = ?";
	
	// Curating board
	final static String CURATING_BOARD = "select * from CURATING_BOARD";
}