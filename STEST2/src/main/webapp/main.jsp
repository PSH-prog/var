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
</head>
<!-- 메뉴 드롭 CSS -->
<body>
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
									<li><a href='/STEST2/math.do?lnkDt=math' >Math</a></li>
									<li><a href='/STEST2/board.do?lnkDt=board' >Board</a></li>
									<li><a href='SQL.html' >SQL</a></li>
									<li><a href='/STEST2/planet.html' >Planet</a></li>
									<li><a href='/STEST2/list' >List</a></li>
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

</body>
</html>