/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.marketPlace.servlets;

import com.marketplace.entities.Usuarios;
import com.marketplace.session.UsuariosFacade;
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
@WebServlet(name = "loginServlet", urlPatterns = {"/loginServlet"})
public class loginServlet extends HttpServlet {
  @EJB
  private UsuariosFacade usuariosFacade;
  Usuarios usuario;
  private boolean bandera;
  private String error = "";
  
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
      if (bandera) {
        HttpSession session = request.getSession();
        session.setAttribute("usuario", usuario.getPrimerNombre());
        session.setAttribute("apellido", usuario.getPrimerApellido());
        session.setAttribute("perfil", "" + usuario.getIdPerfil());
        session.setAttribute("idUsuario", "" + usuario.getId());
        session.setMaxInactiveInterval(30 * 60);
        response.sendRedirect("menu.jsp");
      } else {
        HttpSession session = request.getSession();
        session.setAttribute("error", "");
        session.setAttribute("error", error);
        session.setMaxInactiveInterval(1);
        response.sendRedirect("index.jsp");
      }
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
    String nickname = request.getParameter("nickname");
    String passwordMd5 = request.getParameter("password");
    usuario = usuariosFacade.getBuscarInfoUser(nickname);
    if (usuario != null && usuario.getContrasena().equals(passwordMd5)) {
      bandera = true;
    } else {
      error = "";
      error += usuario == null ? "El usuario no existe <br>" : "";
      error += nickname.equals("") ? "Por favor ingrese su nickname <br>" : "";
      error += passwordMd5.equals("") ? "Por favor ingrese su contraseña <br>" : "";
      error += !usuario.getContrasena().equals(passwordMd5) ? "Contraseña erronea <br>" : "";
      bandera = false;
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
