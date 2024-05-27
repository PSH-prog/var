package HTML;

import org.springframework.stereotype.Controller;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;

public class htmlController extends HttpServlet{
	/*
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		process(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		process(req, resp);
	}
	
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
			default :
				urlNm = "/TEST/weatherList.jsp";
		}
		
		RequestDispatcher rd = req.getRequestDispatcher(urlNm);
		rd.forward(req, resp);
	}
	*/
}