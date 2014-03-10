/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marketPlace.servlets;

import com.marketPlace.Dao.usuariosDAO;
import com.marketPlace.hibernate.Perfiles;
import com.marketPlace.hibernate.Usuarios;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Sebastian Rojas
 */
@WebServlet(name = "proveedorServlet", urlPatterns = {"/proveedorServlet"})
public class proveedorServlet extends HttpServlet {

  Usuarios usuario;
  private boolean bandera;
  private String error = "";
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
      /* TODO output your page here. You may use following sample code. */
      out.println("<html>");
      out.println("<head>");
      out.println("<title>Servlet proveedorServlet</title>");      
      out.println("</head>");
      out.println("<body>");
      out.println("<h1>Servlet proveedorServlet at " + request.getContextPath() + "</h1>");
      out.println("</body>");
      out.println("</html>");
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
    String nitProveedor = request.getParameter("nitProveedor");
    String nickname = request.getParameter("nickname");
    String razonSocial = request.getParameter("razonSocial");
    String tipoEmpresa = request.getParameter("tipoEmpresa");
    String passwordMd5 = request.getParameter("password");
    String passwordMd5C = request.getParameter("passwordC");
    String correo = request.getParameter("correo");
    usuariosDAO usuariodao = new usuariosDAO();
    usuariodao.getBuscarInfoUser(nickname);
    
    if (usuario == null && passwordMd5.equals(passwordMd5C)) {
      bandera = true;
      Perfiles miPerfil = new Perfiles(2,"Proveedor",true);
      usuario = new Usuarios(Integer.parseInt(nitProveedor),miPerfil,razonSocial,tipoEmpresa,passwordMd5,nickname,correo,false);
      usuariodao.setInfoUser(usuario);
    } else {
      error += usuario != null ? "El usuario ya existe <br>" : "";
      error += nitProveedor.equals("") ? "Por favor ingrese su Cedula <br>" : "";
      error += nickname.equals("") ? "Por favor ingrese su nickname <br>" : "";
      error += passwordMd5.equals("") ? "Por favor ingrese su contraseña <br>" : "";
      error += !passwordMd5.equals(passwordMd5C) ? "Las contraseñas no coinciden Verifique <br>" : "";
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
