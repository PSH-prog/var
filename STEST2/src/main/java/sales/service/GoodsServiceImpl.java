package sales.service;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sales.vo.GoodsVO;

@Service
public class GoodsServiceImpl implements GoodsService {

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	@Transactional
	public List<GoodsVO> selectGoodsList() throws Exception {
		return sqlSessionTemplate.selectList("selectGoodsList");
	}
	
	@Transactional
	public int insertGoods(HashMap<String, Object> map) {
		return sqlSessionTemplate.insert("goods.insertGoods", map);
	}
	
	@Transactional
	public int deleteGoods(HashMap<String, Object> map) {
		return sqlSessionTemplate.delete("goods.deleteGoods",map);
	}
	
	public SqlSessionTemplate getSqlSessionTemplate() {
		return sqlSessionTemplate;
	}

	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}
}
