<%-- 
    Document   : view_outcome
    Created on : 04 Apr 2025, 6:54:47 PM
    Author     : sandi
--%>

<%@page import="java.util.Date"%>
<%@page import="java.util.List"%>
<%@page import="za.ac.tut.model.entity.Book"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View All Books Page</title>
    </head>
    <body>
        <h1>View All Books</h1>
        <%
            List<Book> books = (List<Book>)request.getAttribute("books");
        %>
        <p>Below are the details of the books.</p>
        <table Border = "2">
            <th>No.</th>
            <th>Title</th>
            <th>Description</th>
            <th>ISBN</th>
            <th>ID</th>
            <th>Pages</th>
            <th>Price</th>
            <th>Illustrations?</th>
            <th>Creation date</th>
            
            <%
                for (int i = 0; i < books.size(); i++) {
                        Book book = books.get(i);
                        String title = book.getTitle();
                        String description = book.getDescription();
                        String isbn = book.getIsbn();
                        Long id = book.getId();
                        Integer pages = book.getNoOfPages();
                        Double price = book.getPrice();
                        Date creationDate = book.getCreationDate();
                        Boolean illustrations = book.getIllustrations();
                        %>
                        <tr>
                            <td><%=i+1%></td>
                            <td><%=title%></td>
                            <td><%=description%></td>
                            <td><%=isbn%></td>
                            <td><%=id%></td>
                            <td><%=pages%></td>
                            <td><%=price%></td>
                            <td><%=creationDate%></td>
                            <td><%=illustrations%></td>
                        </tr>
                        <%
                    }
            %>
        </table>
        <ul>
            <li><a href="menu.html">Menu Page</a></li>
            <li><a href="index.html">Home Page</a></li>
        </ul>
    </body>
</html>
