<%@ page contentType="text/html;charset=utf8" session="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>Title</title>
		<script type="text/javascript" language="javascript" 
		     src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
		<script type="text/javascript">
             $(function(){	
            	 $("#na").focus();
            	 //로직!! 
            	 $("#btn").on("click", function(){
            		 //alert("클릭됨");
            		 //console.log("클릭됨!!");
            		/* $.ajax({
            			 url: "create.json",
            			 type: "post",
            			 data: {name:$("#na").val(), addr:$("#ad").val()},
            			 success: function(data){
            				 alert("입력성공 : " + data);
            			 },
            			 error: function(error){
            				 alert("입력실패 : " + error);
            			 }
            		 });*/
            		 var jsObj = {name:$("#na").val(), addr:$("#ad").val()}
            		 var jsonData = JSON.stringify(jsObj);
            		 $.ajax({
            			 url: "create.json",
            			 type: "post",
            			 contentType: "application/json;charset=utf-8",
            			 data: jsonData,
            			 success: function(data){
            				 alert("입력성공 : " + data);
            			 },
            			 error: function(error){
            				 alert("입력실패 : " + error);
            			 }
            		 });
            	 });
             });
		</script>
	</head>

	<body>
	  <center>
	   <h1>
			Rest Address Create
	   </h1>
	      이름: <input id="na"><br/>
	      주소: <input id="ad"><br/>
	   <input type="button" value="주소록 추가" id="btn"><br/><br/> 
	  </center>
	</body>
</html>