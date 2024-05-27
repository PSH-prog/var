package goodsTst;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TestMain {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		/*
		Scanner in = new Scanner(System.in);
		
		System.out.printf("1. SELECT \n2. INSERT\n3. DELETE\n INSERT NUMBER : ");
		String snum = in.nextLine();
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("/goodsTst/root-context.xml");
		GoodsService service = (GoodsService)ctx.getBean("goodsServiceImpl");
		
		List<GoodsVO> list = service.selectGoodsList();
		HashMap<String, Object> param = new HashMap<String, Object>();
		HashMap<String, Object> dparam = new HashMap<String, Object>();
		
		String gcode = "";
		String gname = "";
		String gprice = "";
		String gtotal = "";
		
		switch(snum) {
			case "1":
				for (GoodsVO GoodsVO : list) {
					System.out.println(GoodsVO);
				}
				break;
				
			case "2":
				System.out.print("GOODS CODE :");
				gcode = in.nextLine();
				System.out.print("GOODS NAME :");
				gname = in.nextLine();
				System.out.print("GOODS PRICE :");
				gprice = in.nextLine();
				System.out.print("GOODS COUNT :");
				gtotal = in.nextLine();
				
				param.put("gcode", gcode);
				param.put("gname", gname);
				param.put("gprice", gprice);
				param.put("gtotal", gtotal);
				
				int cntInsert = service.insertGoods(param);
				System.out.println(cntInsert);
				
				break;
				
			case "3":
				System.out.print("GOODS CODE :");
				gcode = in.nextLine();
				
				dparam.put("gcode", gcode);
				
				int cntDelete = service.deleteGoods(dparam);
				System.out.println(cntDelete);
				break;
		} //https://velog.io/@jang_tissue/Mybatis-%ED%99%9C%EC%9A%A9-jsp-%ED%8E%98%EC%9D%B4%EC%A7%80-%ED%9A%8C%EC%9B%90%EA%B0%80%EC%9E%85

		*/
	}
}