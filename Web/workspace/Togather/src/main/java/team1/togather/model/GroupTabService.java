package team1.togather.model;

import java.util.ArrayList;

import team1.togather.domain.Gathering;
import team1.togather.domain.GroupTab;

public class GroupTabService {
	private GroupTabDAO dao;
	
	private static final GroupTabService instance = new GroupTabService();
	
	private GroupTabService() {
		dao = new GroupTabDAO();
	}
	public static GroupTabService getInstance() {
		return instance;
	}
	
	public ArrayList<GroupTab> groupListS(){
		return dao.groupList();
	}
	public ArrayList<GroupTab> groupInfoS(long gSeq){
		return dao.groupInfo(gSeq);
	}
	public boolean groupInsertS(GroupTab dto) {
		return dao.groupInsert(dto);
	}
	public ArrayList<GroupTab> groupGetUpdateS(long gSeq){
		return dao.groupGetUpdate(gSeq);
	}
	public void groupUpdateS(GroupTab dto) {
		dao.groupUpdate(dto);
	}
	public boolean gatheringInsertS(Gathering dto) {
		return dao.gatheringInsert(dto);
	}
	public ArrayList<Gathering> gatheringListS(long gSeq){
		return dao.gatheringList(gSeq);
	}
}
