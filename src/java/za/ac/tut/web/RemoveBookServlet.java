/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.tut.web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import za.ac.tut.model.bl.BookFacadeLocal;
import za.ac.tut.model.entity.Book;

/**
 *
 * @author sandi
 */
public class RemoveBookServlet extends HttpServlet {
@EJB 
    private BookFacadeLocal bfl;
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Long id = Long.parseLong(request.getParameter("id"));
        
        Book targetBook = bfl.find(id);
        
        Book book = createBook(id, targetBook);
        bfl.remove(book);
        
        request.getRequestDispatcher("remove_book_outcome.jsp").forward(request, response);

    }

    private Book createBook(Long id, Book targetBook) {
        Book book = new Book();
        book.setId(id);
        book.setTitle(targetBook.getTitle());
        return book;
    }

}
