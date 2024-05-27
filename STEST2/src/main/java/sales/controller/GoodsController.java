package sales.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import sales.service.GoodsService;
import sales.vo.GoodsVO;

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
	/*
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		process(req, resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		process(req, resp);
	}
	*/
	
	@RequestMapping(path = "/main.jsp", method = RequestMethod.GET)
	public String doD(Model model) {
		return "/list";
	}
	/*
	public void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String lnkNm = "";
	    lnkNm = req.getParameter("lnkDt");
		String urlNm = "";
		
		switch(lnkNm) {
			case "math":
				urlNm = "/WEB-INF/HTML/math.html";
				break;
			case "board":
				urlNm = "/WEB-INF/HTML/board.html";
				break;
			case "list":
				urlNm = "/WEB-INF/list.jsp";
				break;
			default :
				urlNm = "/TEST/weatherList.jsp";
				break;
		}
		
		RequestDispatcher rd = req.getRequestDispatcher(urlNm);
		rd.forward(req, resp);
	}*/
}