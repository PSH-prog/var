package goodsTst;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class GoodsController {
	
	@Autowired
	GoodsService service;
	
	@RequestMapping(value = "/list")
//	public String list(ModelMap model) throws Exception{
	public ModelAndView list() throws Exception{
		
		ModelAndView mv = new ModelAndView();
		
		List<GoodsVO> list = service.selectGoodsList();
		System.out.println(list);
		mv.addObject("list",list);
//		model.addAttribute("list", list); //		"/WEB-INF/views/list.jsp"
//		return "list";
		mv.setViewName("list");
		return mv;

	}
}