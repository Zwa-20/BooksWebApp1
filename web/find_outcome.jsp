<%-- 
    Document   : find_outcome
    Created on : 04 Apr 2025, 6:41:44 PM
    Author     : sandi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@page import="java.util.Date"%>
<%@page import="za.ac.tut.model.entity.Book"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Modify Book Page</title>
    </head>
    <body>
        <h1>Modify book</h1>
        <%
            Book book = (Book)request.getAttribute("book");
            String title = book.getTitle();
            String description = book.getDescription();
            String isbn = book.getIsbn();
            Long id = book.getId();
            Integer pages = book.getNoOfPages();
            Double price = book.getPrice();
            Date creationDate = book.getCreationDate();
            Boolean illustrations = book.getIllustrations();
            
        %>
        <p>Below are the book details:</p>
         
            <table>
                <tr>
                    <td><input type="hidden" name="id" value="<%= id %>" /></td>
                </tr>
                <tr>
                    <td>Title</td>
                    <td><input type="text" value="<%=title%>" name="title" disabled=""/></td>
                </tr>
                <tr>
                    <td>Price</td>
                    <td><input type="text" value="<%=price%>" name="price"/></td>
                </tr>
                <tr>
                    <td>Description</td>
                    <td><input type="text" value="<%=description%>" name="description"/></td>
                </tr>
                <tr>
                    <td>ISBN</td>
                    <td><input type="text" value="<%=isbn%>" name="isbn"/></td>
                </tr>
                <tr>
                    <td>Number of pages</td>
                    <td><input type="text" value="<%=pages%>" name="pages" /></td>
                </tr>
                <tr>
                    <td>Has illustrations?</td>
                    <td>
                        <select name="illustration">
                            <option value="true" <%=book.getIllustrations()? "selected" : "" %>>Yes</option>
                            <option value="false" <%=book.getIllustrations()? "selected" : "" %>>No</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>Creation date</td>
                    <td><input type="text" value="<%=creationDate%>" name="creationDate" /></td>
                </tr>
            </table>
             <ul>
            <li><a href="menu.html">Menu Page</a></li>
            <li><a href="index.html">Home Page</a></li>
        </ul>
    </body>
</html>
