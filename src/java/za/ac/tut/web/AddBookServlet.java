/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.tut.web;

import java.io.IOException;
import java.util.Date;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import za.ac.tut.model.entity.Book;  // Correct import for your Book entity
import za.ac.tut.model.bl.BookFacadeLocal;

public class AddBookServlet extends HttpServlet {
    @EJB 
    private BookFacadeLocal bfl;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String title = request.getParameter("title");
        Double price = Double.parseDouble(request.getParameter("price"));
        String description = request.getParameter("description");
        String isbn = request.getParameter("isbn");
        Integer pages = Integer.parseInt(request.getParameter("pages"));
        Boolean illustration = Boolean.parseBoolean(request.getParameter("illustration"));
        
        // Create the Book object using the method below
        Book book = createBook(title, price, description, isbn, pages, illustration);
        bfl.create(book);  // Call the EJB method to persist the book
        
        // Forward to the next page after the book is created
        request.getRequestDispatcher("add_outcome.jsp").forward(request, response);
    }

    // Method to create and return a Book entity
    private Book createBook(String title, Double price, String description, String isbn, Integer pages, Boolean illustration) {
        Book book = new Book();
        book.setTitle(title);
        book.setPrice(price);
        book.setDescription(description);
        book.setIsbn(isbn);
        book.setNoOfPages(pages);
        book.setIllustrations(illustration);
        book.setCreationDate(new Date());
        return book;
    }
}

