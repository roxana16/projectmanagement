<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>demo login.jsp</title>
</head>
<body>
	<%@ page import="java.sql.*"%>
	<%@ page import="javax.sql.*"%>
	<%
	
	String usr = request.getParameter("username");
	String pwd = request.getParameter("password");
	
	Class.forName("com.mysql.jdbc.Driver"); 

Connection myConn = null;
PreparedStatement myStmt = null;
ResultSet resultSet = null;

//Login
int flag = 1;

try {
	

	myConn = DriverManager.getConnection("jdbc:mysql://localhost:3308/test", "root", "root");
	
	final StringBuilder query = new StringBuilder("select username, password from user where username = ? and password = ?");
	myStmt = (PreparedStatement) myConn.prepareStatement(query.toString());
	
	myStmt.setString(1, usr);
	myStmt.setString(2, pwd);

	resultSet = myStmt.executeQuery();
	if(resultSet.next()){
		
		response.sendRedirect("index_user.html");
		
	}
	else {
		
        out.println("Invalid username or password <a href='index.html'>Try again</a>");
  
    }

} catch (Exception e1) {
	e1.printStackTrace();
} 
%>
<a href="index_user.html"></a>
</body>
</html>