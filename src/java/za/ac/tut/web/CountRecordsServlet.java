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

/**
 *
 * @author sandi
 */
public class CountRecordsServlet extends HttpServlet {
 @EJB 
    private BookFacadeLocal bfl;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Integer cnt = bfl.count();
        request.setAttribute("cnt", cnt);
        
        request.getRequestDispatcher("records_count_outcome.jsp").forward(request, response);
    }

}
