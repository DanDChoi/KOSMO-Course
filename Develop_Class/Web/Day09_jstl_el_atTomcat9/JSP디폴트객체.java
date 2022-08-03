< JSP 디폴트 객체 (9개) > 

(1) 객체를 따로 생성하지 않고 스크립트렛 즉, 
    <%%> 사이에서 사용 가능한 객체를 의미 

(2) 종류 
    <1> out ( JspWriter )

	<2> response ( HttpServletResponse )

	<3> request ( HttpServletRequest )

	<4> session ( HttpSession )

	<5> application ( ServletContext )

	<6> page ( Object )

	<7> pageContext ( PageContext )

	<8> config ( ServletConfig )

	    정의) web.xml 
	    <servlet>
		  <servlet-name>servletEx</servlet-name>
		  <jsp-file>/jspEx.jsp</jsp-file>
		  <init-param>
			  <param-name>adminId</param-name>
			  <param-value>admin</param-value>
		  </init-param>
	    </servlet>

        사용) jspEx.jsp
	    <%
	        String adminId = config.getInitParameter("adminId");
	    %>

	<9> exception  ( Throwable ) 