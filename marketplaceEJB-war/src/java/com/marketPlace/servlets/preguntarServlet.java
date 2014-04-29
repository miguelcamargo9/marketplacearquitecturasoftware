/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marketPlace.servlets;

import com.marketplace.entities.Preguntas;
import com.marketplace.entities.Usuarios;
import com.marketplace.session.PreguntasFacade;
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
 * @author Miguel
 */
@WebServlet(name = "preguntarServlet", urlPatterns = {"/preguntarServlet"})
public class preguntarServlet extends HttpServlet {
  @EJB
  private UsuariosFacade usuariosFacade;

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
  @EJB
  private PreguntasFacade preguntasFacade;
  private boolean bandera = true;
  private String error = "";
  
  protected void processRequest(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    try {
      if (bandera) {
        HttpSession session = request.getSession();
        session.setAttribute("mensaje"," Pregunta creada con Exito!");
        response.sendRedirect("vistas/preguntarFAQ.jsp");
      } else {
        HttpSession session = request.getSession();
        session.setAttribute("error", error);
        response.sendRedirect("vistas/preguntarFAQ.jsp");
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
    int idProveedor = Integer.parseInt(request.getParameter("idUsuario"));
    int idUsuario = Integer.parseInt(request.getParameter("idusuarioPre"));
    String miPregunta = request.getParameter("preguntasFAQ");
    if(miPregunta != null){
      Preguntas pregunta = new Preguntas();
      Usuarios miProvedor = new Usuarios();
      Usuarios miUsuario = new Usuarios();
      miProvedor = usuariosFacade.getBuscarIdUser(idProveedor);
      miUsuario = usuariosFacade.getBuscarIdUser(idUsuario);
      bandera = true;
      pregunta.setPregunta(miPregunta);
      pregunta.setRespuesta(" ");
      pregunta.setIdProveedor(miProvedor);
      pregunta.setIdUsuario(miUsuario);
      pregunta.setEstado(true);
      preguntasFacade.guardarPregunta(pregunta);
    }
    else{
      bandera = false;
      error += "Error al Responder la Pregunta";
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
