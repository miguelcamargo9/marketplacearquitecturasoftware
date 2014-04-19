/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marketPlace.servlets;

import com.marketplace.session.PaquetesFacade;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "paqueteServlet", urlPatterns = {"/paqueteServlet"})
public class paqueteServlet extends HttpServlet {
  @EJB
  private PaquetesFacade paquetesFacade;

  boolean bandera = true;
  String error;

  /**
   * Processes requests for both HTTP
   * <code>GET</code> and
   * <code>POST</code> methods.
   *
   * @param request servlet request
   * @param response servlet response
   * @throws ServletException if a servlet-specific error occurs
   * @throws IOException if an I/O error occurs
   */
  protected void processRequest(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    try {
      if (bandera) {
        HttpSession session = request.getSession();
        session.setAttribute("exito", "");
        session.setAttribute("error", "");
        if (session != null) {
          session.setAttribute("exito", "Se creo con exito el paquete");
          response.sendRedirect("vistas/crearPaquetes.jsp");
        }
      } else {
        HttpSession session = request.getSession();
        if (session != null) {
          session.setAttribute("error", error);
          response.sendRedirect("vistas/crearPaquetes.jsp");
        }
      }
    } finally {
      out.close();
    }
  }

  // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
  /**
   * Handles the HTTP
   * <code>GET</code> method.
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
   * Handles the HTTP
   * <code>POST</code> method.
   *
   * @param request servlet request
   * @param response servlet response
   * @throws ServletException if a servlet-specific error occurs
   * @throws IOException if an I/O error occurs
   */
  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    int idProveedor = Integer.parseInt(request.getParameter("idProveedor"));
    String descripcion = request.getParameter("descripcion");
    String valor = request.getParameter("valor");
    if (idProveedor == 0) {
      error += "Error no llego el id de usuario...<br>";
    } else if (descripcion.equals("") || descripcion == null) {
      error += "Error no se diligencio la descripcion...<br>";
    } else if (valor.equals("") || valor == null) {
      error += "Error no se diligencio el valor...<br>";
    } else {
      paquetesFacade.guardarPaquete(idProveedor, descripcion, valor);
      processRequest(request, response);
      
    }
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
