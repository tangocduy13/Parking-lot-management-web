/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dal.accountDAO;
import dal.cateDAO;
import dal.orderDAO;
import dal.productDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Account;
import model.Category;
import model.Order;
import model.Product;

/**
 *
 * @author TIEN HUY
 */
@WebServlet(name = "loadProduct", urlPatterns = {"/loadProduct"})
public class loadProduct extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
  
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
              response.setContentType("text/html;charset=UTF-8");
              request.setCharacterEncoding("UTF-8");
         productDAO pDAO = new productDAO();
        cateDAO cDAO = new cateDAO();
        accountDAO aDAO = new accountDAO();
        orderDAO oDAO = new orderDAO();
        List<Product> listAll = pDAO.getAllProduct();
        request.setAttribute("listP", listAll);
        List<Category> listC = cDAO.getAllCategory();
        request.setAttribute("listC", listC);
        List<Account> listA = aDAO.getAllAccount();
        request.setAttribute("listA", listA);
        List<Order> listO = oDAO.getAllOrder();
        request.setAttribute("listO", listO);
       int pid = Integer.parseInt(request.getParameter("pid"));
         
        Product p = pDAO.getProductByID(pid);
       

        request.setAttribute("detail", p);
        
        request.getRequestDispatcher("edit.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
