<%@ page contentType="text/html;charset=utf-8"%>


<body style="text-align:center">
<h1>서블릿의 lifeCycle</h1>
<p>
    새로고침 해보세요
</p>
<%! 
    String str = "멤버";
    public void jspInit(){
        System.out.println("jspInit()");
    }
    public void jspDestroy(){
        System.out.println("jspDestroy()");  
    }
    
%>
<%
    System.out.println("_jpsService()");
%>

</body>