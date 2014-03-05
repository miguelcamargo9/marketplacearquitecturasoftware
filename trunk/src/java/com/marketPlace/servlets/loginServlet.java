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
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author open12
 */
@WebServlet(name = "loginServlet", urlPatterns = {"/loginServlet"})
public class loginServlet extends HttpServlet {

  Usuarios usuario;
  private boolean bandera;

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
        /* TODO output your page here. You may use following sample code. */
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet loginServlet</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Hola " + usuario.getPrimerNombre() + "</h1>");
        out.println("</body>");
        out.println("</html>");
      } else {
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet loginServlet</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Hola  ocurrio un error</h1>");
        out.println("</body>");
        out.println("</html>");
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
