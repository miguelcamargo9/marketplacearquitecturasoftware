/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marketPlace.servlets;


import com.marketplace.entities.Perfiles;
import com.marketplace.entities.Usuarios;
import com.marketplace.session.UsuariosFacade;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Miguel
 */
@WebServlet(name = "registroServlet", urlPatterns = {"/registroServlet"})
public class registroServlet extends HttpServlet {

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
      if (bandera) {
        HttpSession session = request.getSession();
        session.setAttribute("mensaje", ""+usuario.getPrimerNombre()+" Tu solicitud ha sido creado con Exito!");
        session.setMaxInactiveInterval(1);
        response.sendRedirect("index.jsp");
      } else {
        HttpSession session = request.getSession();
        session.setAttribute("error", error);
        session.setMaxInactiveInterval(1);
        response.sendRedirect("vistas/registrarseVista.jsp");
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
    
    String idUsuario = request.getParameter("idUsuario");
    String nickname = request.getParameter("nickname");
    String primerNombre = request.getParameter("primerNombre");
    String segundoNombre = request.getParameter("segundoNombre");
    String primerApellido = request.getParameter("primerApellido");
    String segundoApellido = request.getParameter("segundoApellido");
    String passwordMd5 = request.getParameter("password");
    String passwordMd5C = request.getParameter("passwordC");
    String correo = request.getParameter("correo");
    UsuariosFacade usuarioFac = new UsuariosFacade();
    usuario = usuarioFac.getBuscarInfoUser(nickname);
    if (usuario == null && passwordMd5.equals(passwordMd5C)) {
      bandera = true;
      Perfiles miPerfil = new Perfiles(2,"Cliente",true);
      usuario = new Usuarios(Integer.parseInt(idUsuario),nickname,passwordMd5,false);
      usuario.setIdPerfil(2);
      usuario.setPrimerNombre(primerNombre);
      usuario.setPrimerApellido(primerApellido);
      usuario.setSegundoApellido(segundoApellido);
      usuario.setSegundoNombre(segundoNombre);
      usuario.setCorreo(correo);
      usuarioFac.setUsuario(this.usuario);
    } else {
      error += usuario != null ? "El usuario ya existe <br>" : "";
      error += idUsuario.equals("") ? "Por favor ingrese su Cedula <br>" : "";
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
