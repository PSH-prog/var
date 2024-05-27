package users.service;

import java.util.HashMap;
import java.util.List;

import users.vo.UsersVO;

public interface UsersService {
	List<UsersVO> selectUsersList() throws Exception;
	
	int selectIdCheck(String id) throws Exception;

	int insertUsers(HashMap<String, Object> param);

	int deleteUsers(HashMap<String, Object> map);
}