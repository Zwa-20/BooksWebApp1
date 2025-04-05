<%-- 
    Document   : records_count_outcome
    Created on : 04 Apr 2025, 6:27:59 PM
    Author     : sandi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Records Count Outcome Page</title>
    </head>
    <body>
        <h1>Records Count Outcome</h1>
        <%
            Integer cnt = (Integer)request.getAttribute("cnt");
        %>
        <p>There are <b><%=cnt%></b> books stored in the database.</p>
        <ul>
            <li><a href="menu.html">Menu Page</a></li>
            <li><a href="index.html">Home Page</a></li>
        </ul>
    </body>
</html>