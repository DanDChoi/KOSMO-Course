package team1.togather.model;

import java.util.ArrayList;

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
	public boolean groupCreateS(GroupTab dto) {
		return dao.groupCreate(dto);
	}
}
