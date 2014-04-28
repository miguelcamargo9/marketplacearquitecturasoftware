/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marketPlace.servlets;

import com.marketplace.entities.Perfiles;
import com.marketplace.entities.Usuarios;
import com.marketplace.session.PerfilesFacade;
import com.marketplace.session.UsuariosFacade;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author eherrera
 */
@WebServlet(name = "busquedaProveedorServlet", urlPatterns = {"/busquedaProveedorServlet"})
public class busquedaProveedorServlet extends HttpServlet {

  @EJB
  private UsuariosFacade usuariosFacade;
  List<Usuarios> listaProveedores;
  boolean bandera = true;
  String error;

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
        HttpSession session = request.getSession();
        if (session != null) {
          session.setAttribute("listaProveedores", listaProveedores);
          response.sendRedirect("vistas/listaProveedores.jsp");
        }
      } else {
        HttpSession session = request.getSession();
        if (session != null) {
          session.setAttribute("error", error);
          response.sendRedirect("vistas/listaProveedores.jsp");
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
    String descripcion = request.getParameter("nombre");
    if (!descripcion.equals("") || !descripcion.equals(null)) {
      usuariosFacade.buscarListaProveedores(descripcion);
      listaProveedores = usuariosFacade.getListaUsuarios();
    } else {
   
      error = "No ingreso un proveedor";
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
