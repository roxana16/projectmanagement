<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%> 
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>demo Registration</title>
</head>
<body>
<%@ page import ="java.sql.*" %>
<%@ page import ="javax.sql.*" %>
<%

String user=request.getParameter("username");  
String pwd=request.getParameter("password"); 
String fname=request.getParameter("fname"); 
String lname=request.getParameter("lname"); 
String email=request.getParameter("email"); 

Class.forName("com.mysql.jdbc.Driver"); 

Connection myConn = null;
PreparedStatement myStmt = null;
ResultSet resultSet = null;


try {
	
	myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestionar", "root", "sqlroot"); 
	 
String query = "insert into usert (id, username, password, fname, lname, email) values(null, ?, ?, ?, ?, ?)";
myStmt = (PreparedStatement) myConn.prepareStatement(query.toString());


	myStmt.setString(1, user);
	myStmt.setString(2, pwd);
	myStmt.setString(3, fname);
	myStmt.setString(4, lname);
	myStmt.setString(5, email);

int result = myStmt.executeUpdate();

System.out.println("Hello my new friend! "+user);

} catch (Exception exc) {
	exc.printStackTrace();

} finally {
	if (resultSet != null) {
		try {
			resultSet.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	if (myStmt != null) {
		try {
			myStmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	if (myConn != null) {
		try {
			myConn.close();
		} catch (SQLException e) {
			e.printStackTrace();
			}
		}
	}



%>
<a href ="Login.html">Login</a><br/><br/>
<a href="index.html">Home</a>
</body>
</html>