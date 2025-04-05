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
public class ModifyBookServlet extends HttpServlet {
    @EJB 
    private BookFacadeLocal bfl;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Double price = Double.parseDouble(request.getParameter("price"));
        String description = request.getParameter("description");
        Integer pages = Integer.parseInt(request.getParameter("pages"));
        Long id = Long.parseLong(request.getParameter("id"));
        String isbn = request.getParameter("isbn");
        Boolean illustrations = Boolean.parseBoolean(request.getParameter("illustration"));
        
        Book book = bfl.find(id);
        book.setPrice(price);
        book.setDescription(description);
        book.setNoOfPages(pages);
        book.setIsbn(isbn);
        book.getIllustrations();
        bfl.edit(book);
        
        request.getRequestDispatcher("modify_book_outcome.jsp").forward(request, response);
    }
    

}
