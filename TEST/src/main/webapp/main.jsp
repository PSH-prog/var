<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.ResultSet"%>
<%@ page import="java.sql.PreparedStatement"%>
<%@ page import="java.sql.DriverManager"%>
<%@ page import="java.sql.Connection"%>
<%@ page import="java.sql.Statement"%>
<%@ page import="oracle.jdbc.*"%>
<%@ page import="oracle.jdbc.pool.OracleDataSource"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import= "java.util.HashMap"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8"> <!-- 추가할부분 -->
	<meta name="viewport" content="width=device-width, initial-scale=1.0"> <!-- 추가할부분 -->
	<meta http-equiv="X-UA-Compatible" content="ie=edge"> <!-- 추가할부분 -->
<title></title>
<!-- 눈 효과 HTML -->
<link rel="stylesheet" href="css/snow.css">
<div style="position:fixed;z-index:1;">
	<style>
    	:root {
      		--snow-color: white;
    	}
    	.snow {
      		margin-top:0px;
      		position: fixed;
      		width: 10px;
      		height: 10px;
      		background: var(--snow-color);
      		border-radius: 50%;
    	}
  	</style>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script>
    	$(document).ready(function() {
      		var snowCount = 200; // ������ ���� 媛���瑜� �ㅼ��
      		for (var i = 0; i < snowCount; i++) {
        		$('<div class="snow"></div>').appendTo('body');
      		}
      		var snowElements = document.getElementsByClassName('snow');
      		for (var i = 0; i < snowElements.length; i++) {
        		var snowElement = snowElements[i];
        		snowElement.style.setProperty('--snow-color', "#FFFFFF");
      		}
    	});
	</script>
</div>
</head>
<!-- 메뉴 드롭 CSS -->
<body>
<div style='position:fixed;z-index:2;weight:100%;height:100%'>
	<style type="text/css">
      	* {
		  margin: 0;
		  padding: 0;
	    }
	    
	    ul li{
		  list-style: none;
		}
		
		a {
		  text-decoration: none;
		  color:grey;
		}
		
        #menu {
          font:bold 16px "malgun gothic";
          width:100px;
          height:50px;
          background: #ccc;
          line-height: 50px; 
          margin:0 auto;
          text-align: center;
          background-color:transparent;
        }
      
        #menu > ul > li {
          float:left;
          position:relative;
        }

        #menu > ul > li > ul {
          width:100px;
		  display:none;
		  position: absolute;
		  font-size:14px;
		  background: white;
        }
        
        #menu > ul > li:hover > ul {
		  display:block;
	    }

        #menu > ul > li > ul > li:hover {
		  background: black;
		  transition: ease 1s;
		}
		
		#menu > ul > li > ul> li > a {
		  color:black;
		}
        </style>
    <!-- 로그인 컨트롤러 UI -->
	<ul  style='list-style:none;margin-top:10px;margin-left:10px'>
		<%
			String id = null;
			id = request.getParameter("id");
		%>
		<c:set var="id" value="${id}"/>
		<c:choose>
			<c:when test="${id ne null}">
				<li><a href='loginmain.jsp' style='color:gray'>logout</a>
				</li>
					<div id='menu' style='margin:0'>
						<ul>
							<li><a href='#'><%=id%></a>
								<ul>
									<li><a href='/TEST/math.do?lnkDt=math' >Math</a></li>
									<li><a href='/TEST/board.do?lnkDt=board' >Board</a></li>
									<li><a href='SQL.html' >SQL</a></li>
									<li><a href='planet.html' >Planet</a></li>
									<li><a href='list.jsp' >List</a></li>
								</ul>
							</li>
						</ul>
					</div>
			</c:when>
			<c:otherwise>
				<li><a href='loginmain.jsp' style='color:gray;'>login</a>
				</li>
			</c:otherwise>
		</c:choose>
	</ul>
		<!-- 검색 창 UI -->
		<form style='margin-top:100px;border:2px solid white;width:600px;
              justify-content:center;margin-left:105%;width:600'>
			<input type='text' name='srch' id='srch' placeholder='SEARCH'
			   style="background-color:transparent;width:500px;height:50px;transform: translateY(-5%);border:none;outline:none;box-shadow:none;font-size:2em;'color:gray';">	
		<!-- 검색 창 JS -->
			<script type="text/javascript">
				function get(){
					var site = 'https://search.naver.com/search.naver?where=nexearch&sm=top_hty&fbm=0&ie=utf8&query=';
					var typped = document.getElementById('srch').value;
					var searchName = encodeURI(typped,"UTF-8");
					var result = site.concat(searchName);
					return result;}
			</script>
		<!-- 검색 버튼 UI -->
			<button type='button' class='navyBtn' 
				style="background-color:transparent;border:none;outline:none;box-shadow:none;"
				onClick="location.href=get()">
				<img src='/TEST/img/search_btn.png' width=41px height=41px style='transform:translateY(17%)'>
			</button>
		</form>
		<form style='margin-top:100px;width:100%;
              justify-content: center;margin-left:105%;width:600'>
		<!-- 날짜 HTML -->
		<table border='1' style=";margin-top:50px;border:1px solid white;margin-left:auto;margin-right:auto;">
		<!-- 날짜 JSP -->
		<%
		OracleDataSource ods;
		String src ="";
		ods = new OracleDataSource();
		ods.setURL("jdbc:oracle:thin:dst07/dst07@192.168.10.11:1521:DB19"); 
		Connection conn = ods.getConnection();
		//String query = "SELECT userid, passwd FROM login WHERE userid='"+userId+"' and passwd='"+userPw+"'";
		String query = "SELECT * FROM weather WHERE rownum < 6 ORDER BY tdate DESC";
		PreparedStatement pstmt = conn.prepareStatement(query);
		ResultSet rs = pstmt.executeQuery();
		String msg ="false";
		while(rs.next()){
			String date = rs.getString("tdate").trim();
			String time = rs.getString("time").trim();
			String weather = rs.getString("weather").trim();
			String temp = rs.getString("temp").trim();
			
			switch(weather) {
			case "비":
				src = "<img src='/TEST/img/rain_img.png' width='100' heigh='100'>";
				break;
			case "맑음":
				src = "<img src='/TEST/img/snn_img.png' width='100' heigh='100'>";
				break;
			case "눈":
				src = "<img src='/TEST/img/snn_img.png' width='100' heigh='100'>";
				break;
			case "흐림":
				src = "<img src='/TEST/img/cld_img.png' width='100' heigh='100'>";
				break;
			case "구름많음":
				src = "<img src='/TEST/img/mncld_img.png' width='100' heigh='100'>";
				break;
			default:
				src = rs.getString("weather");
				break;
			}
			out.print("<tr align='center' style='color:white;float:left'>");
			out.print("<td width=18% style='color:white'>"+src+"<br/>"+temp+" C"+"<br/>"+time+"시"+"<br/>"+date+"</td>");
			out.print("</tr>");
		}
		%>
		</table>
		</form>
</div>
</body>
</html>