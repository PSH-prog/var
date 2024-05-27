package goodsTst;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import goodsTst.GoodsService;
import goodsTst.GoodsVO;

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
