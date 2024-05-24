package users.service;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import users.vo.UsersVO;

@Service
public class UsersServiceImpl implements UsersService {

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	@Transactional
	public List<UsersVO> selectUsersList() throws Exception {
		return sqlSessionTemplate.selectList("selectUsersList");
	}
	
	@Transactional
	public int insertUsers(HashMap<String, Object> map) {
		return sqlSessionTemplate.insert("insertUsers", map);
	}
	
	@Transactional
	public int deleteUsers(HashMap<String, Object> map) {
		return sqlSessionTemplate.delete("users.deleteUsers",map);
	}
	
	@Transactional
	public int selectIdCheck(UsersVO vo) throws Exception {
		return sqlSessionTemplate.selectOne("UsersSQL.selectIdCheck" ,vo);
	}
	
	public SqlSessionTemplate getSqlSessionTemplate() {
		return sqlSessionTemplate;
	}

	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}
}