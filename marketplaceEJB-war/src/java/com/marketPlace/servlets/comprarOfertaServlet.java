/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marketPlace.servlets;

import com.marketplace.session.TransaccionesFacade;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Sebastian Rojas
 */
@WebServlet(name = "comprarOfertaServlet", urlPatterns = {"/comprarOfertaServlet"})
public class comprarOfertaServlet extends HttpServlet {
  @EJB
  private TransaccionesFacade transaccionesFacade;
  String error = "";
  boolean bandera = true;

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
    try {
      if (bandera) {
        HttpSession session = request.getSession(false);
        session.setAttribute("exito", "");
        session.setAttribute("error", "");
        if (session != null) {
          session.setAttribute("exito", "Se Realizo la compra");
          response.sendRedirect("comprarOfertas.jsp");
        }
      } else {
        HttpSession session = request.getSession(false);
        if (session != null) {
          session.setAttribute("error", error);
          response.sendRedirect("comprarOfertas.jsp");
        }
      }
    } finally {
      out.close();
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
    processRequest(request, response);
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
    if (request.getParameter("oferta").equals("")) {
      error += "Por favor seleccione una oferta";
    }
    if (request.getParameter("idUsuario").equals("0")) {
      error += "Por verifique su sesion";
    }
    if (bandera) {
      int idOferta = Integer.parseInt(request.getParameter("oferta"));
      int idUsuario = Integer.parseInt(request.getParameter("idUsuario"));
      transaccionesFacade.guardarTransaccionOferta(idOferta, idUsuario);
    }
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
