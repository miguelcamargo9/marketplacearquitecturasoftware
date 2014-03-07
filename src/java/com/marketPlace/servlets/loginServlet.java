/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marketPlace.servlets;

import com.marketPlace.Dao.usuariosDAO;
import com.marketPlace.hibernate.Usuarios;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.MessageDigest;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author open12
 */
@WebServlet(name = "loginServlet", urlPatterns = {"/loginServlet"})
public class loginServlet extends HttpServlet {

  Usuarios usuario;
  private boolean bandera;
  private String error = "";

  /**
   * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
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
        session.setAttribute("usuario", usuario.getPrimerNombre());
        session.setAttribute("apellido", usuario.getPrimerApellido());
        session.setAttribute("perfil", "" + usuario.getPerfiles().getId());
        session.setAttribute("accion", "cargardatos");
        session.setMaxInactiveInterval(30 * 60);
        response.sendRedirect("menu.jsp");
      } else {
        HttpSession session = request.getSession();
        session.setAttribute("error", error);
        session.setMaxInactiveInterval(1);
        Cookie usuarioLogeado = new Cookie("error", error);
        usuarioLogeado.setMaxAge(30);
        response.addCookie(usuarioLogeado);
        response.sendRedirect("error.jsp");
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
    String nickname = request.getParameter("nickname");
    String passwordMd5 = request.getParameter("password");
    usuariosDAO usuariodao = new usuariosDAO();
    usuariodao.getBuscarInfoUser(nickname);
    usuario = usuariodao.getUsuario();
    if (usuario != null && usuario.getContrasena().equals(passwordMd5)) {
      bandera = true;
    } else {
      error += usuario == null ? "El usuario no existe <br>" : "";
      error += nickname.equals("") ? "Por favor ingrese su nickname <br>" : "";
      error += passwordMd5.equals("") ? "Por favor ingrese su contraseña <br>" : "";
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

  public String getMD5(String cadena) throws Exception {
    MessageDigest md = MessageDigest.getInstance("MD5");
    byte[] b = md.digest(cadena.getBytes());

    int size = b.length;
    StringBuilder h = new StringBuilder(size);
    for (int i = 0; i < size; i++) {

      int u = b[i] & 255;

      if (u < 16) {
        h.append("0").append(Integer.toHexString(u));
      } else {
        h.append(Integer.toHexString(u));
      }
    }
    return h.toString();
  }

}
