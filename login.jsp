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
	

	myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestionar", "root", "sqlroot");
	
	final StringBuilder query = new StringBuilder("select username, password from usert where username = ? and password = ?");
	myStmt = (PreparedStatement) myConn.prepareStatement(query.toString());
	
	myStmt.setString(1, usr);
	myStmt.setString(2, pwd);

	resultSet = myStmt.executeQuery();
	resultSet.first();
	
       if(resultSet.getString(1).equals(usr) && resultSet.getString(2).equals(pwd)){
    	   System.out.println("Welcome my friend! ~"+usr+"~");

       }
	

} catch (Exception e1) {
	e1.printStackTrace();
} 
%>
<a href="index.html">Home</a>
</body>
</html>