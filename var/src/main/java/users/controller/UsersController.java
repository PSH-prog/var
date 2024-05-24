package users.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import users.service.UsersService;
import users.vo.UsersVO;

@Controller
public class UsersController {
	
	@Autowired
	UsersService service;
	
	HashMap<String, Object> param = new HashMap<String, Object>();
	
	//회원가입 아이디 중복 확인
//	@ResponseBody
//	@RequestMapping(value = "/idChk", method = RequestMethod.GET)
//	public ModelAndView idCheck(@RequestParam("userId") String userId) throws Exception{
//		
//		System.out.println("userId");
//		
//		ModelAndView mv = new ModelAndView();
//		UsersVO vo = new UsersVO();
//		
//		int idChkStt = service.selectIdCheck(vo);
//		
//		mv.addObject("idChkStt",idChkStt);
//		mv.setViewName("idChkStt");
//		return mv;
//	}
	
	//유저 리스트출력
	@RequestMapping(value = "/userList")
//	public String list(ModelMap model) throws Exception{
	public ModelAndView list() throws Exception{
		
		ModelAndView mv = new ModelAndView();
		List<UsersVO> userList = service.selectUsersList();
		mv.addObject("userList",userList);
//		model.addAttribute("list", list); //		"/WEB-INF/views/list.jsp"
//		return "list";
		mv.setViewName("userList");
		return mv;
	}
	//회원가입 페이지 이동
	@RequestMapping(value = "/join", method = RequestMethod.GET)
	public void getRegister() throws Exception{
	}
	//유저 회원가입
	@RequestMapping(value = "/join.do", method = RequestMethod.POST)
	public String postRegister(@RequestParam("userId") String userId,
			@RequestParam("userPass") String userPass,
			@RequestParam("userAddr") String userAddr,
			@RequestParam("userName") String userName,
			@RequestParam("userCall") int userCall,ModelMap model) throws Exception {

		param.put("user_id", userId);
		param.put("passwd", userPass);
		param.put("address", userAddr);
		param.put("name", userName);
		param.put("phonenum", userCall);
		param.put("grade_no", 1);
		param.put("gname", "일반");
		
		System.out.println(userName);
		int cntInsert = service.insertUsers(param);
		System.out.println(cntInsert);
		
		return "/join";
	}
	//메뉴 이동
	@RequestMapping(path = "/main.jsp", method = RequestMethod.GET)
	public String list(Model model , HttpServletRequest req) {
		String webIdStt = req.getParameter("lnkDt");
		System.out.println(webIdStt);
		String send = "";
		
		switch(webIdStt) {
		
			case "userList" :
				send = "/" +webIdStt;
			break;
	
			case "join" :
				send = "/" +webIdStt;
			break;
			
		}
		return send;
	}
	
}