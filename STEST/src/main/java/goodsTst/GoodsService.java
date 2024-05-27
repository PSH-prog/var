package goodsTst;

import java.util.HashMap;
import java.util.List;

public interface GoodsService {
	List<GoodsVO> selectGoodsList() throws Exception;

	int insertGoods(HashMap<String, Object> param);

	int deleteGoods(HashMap<String, Object> map);
}