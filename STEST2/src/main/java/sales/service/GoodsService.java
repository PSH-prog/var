package sales.service;

import java.util.HashMap;
import java.util.List;

import sales.vo.GoodsVO;


public interface GoodsService {
	List<GoodsVO> selectGoodsList() throws Exception;

	int insertGoods(HashMap<String, Object> param);

	int deleteGoods(HashMap<String, Object> map);
}