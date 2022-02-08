package bitcinema.mvc.model;

import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;

public class Mgr 
{
	private DAO dao;
	
	private static final Mgr instance = new Mgr();

	private Mgr() {
		dao = new DAO();
	}
	
	public static Mgr getInstance() {
		return instance;
	}

	public ArrayList<DTO> resultM(String header, String select_0, String select_1, String select_2){
		return dao.result(header, select_0, select_1, select_2);
	}
	
	public ArrayList<DTO> film_detailM(HttpServletRequest request){
		return dao.film_detail(request);
	}
	
	public ArrayList<DTO> reviewListM(HttpServletRequest request) {
		return dao.reviewList(request);
	}
	
	public boolean reviewInsertM(HttpServletRequest request){
		return dao.reviewInsert(request);
	}
	
	public boolean reviewDeleteM(HttpServletRequest request){
		return dao.reviewDelete(request);
	}
	
	public ArrayList<DTO> searchM(HttpServletRequest request) {
		return dao.search(request);
	}
	
	public int search_convertM(String film_title) {
		return dao.search_convert(film_title);
	}
	
	public ArrayList<DTO> curating_boardM(){
		return dao.curating_board();
	}
}