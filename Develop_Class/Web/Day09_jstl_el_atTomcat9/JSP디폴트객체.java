< JSP ����Ʈ ��ü (9��) > 

(1) ��ü�� ���� �������� �ʰ� ��ũ��Ʈ�� ��, 
    <%%> ���̿��� ��� ������ ��ü�� �ǹ� 

(2) ���� 
    <1> out ( JspWriter )

	<2> response ( HttpServletResponse )

	<3> request ( HttpServletRequest )

	<4> session ( HttpSession )

	<5> application ( ServletContext )

	<6> page ( Object )

	<7> pageContext ( PageContext )

	<8> config ( ServletConfig )

	    ����) web.xml 
	    <servlet>
		  <servlet-name>servletEx</servlet-name>
		  <jsp-file>/jspEx.jsp</jsp-file>
		  <init-param>
			  <param-name>adminId</param-name>
			  <param-value>admin</param-value>
		  </init-param>
	    </servlet>

        ���) jspEx.jsp
	    <%
	        String adminId = config.getInitParameter("adminId");
	    %>

	<9> exception  ( Throwable ) 