/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marketPlace.servlets;

import com.marketPlace.Dao.adjuntoDAO;
import com.marketPlace.hibernate.Adjuntos;
import com.marketPlace.hibernate.Archivos;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "adjuntosArchivosServlet", urlPatterns = {"/adjuntosArchivosServlet"})
public class adjuntosArchivosServlet extends HttpServlet {

  String error = "";
  Adjuntos adjunto;
  Archivos archivo;
  boolean bandera = true;

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
        HttpSession session = request.getSession(false);
        session.setAttribute("exito", "");
        session.setAttribute("error", "");
        if (session != null) {
          session.setAttribute("exito", "Se creo con exito la asociacion");
          response.sendRedirect("vistas/asociarArchivosAdjuntos.jsp");
        }
      } else {
        HttpSession session = request.getSession(false);
        if (session != null) {
          session.setAttribute("error", error);
          response.sendRedirect("vistas/asociarArchivosAdjuntos.jsp");
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
    String idadjuntos = request.getParameter("idAdjunto");
    String idarchivos = request.getParameter("idArchivo");
    if (idadjuntos.equals("")) {
      error += "Por favor seleccione un adjunto";
      bandera = false;
    } else if (idarchivos.equals("")) {
      error += "Por favor seleccione un archivo";
      bandera = false;
    } else {
      adjuntoDAO adjundao = new adjuntoDAO();
      adjundao.guardarAdjuntosArchivos(idadjuntos, idarchivos);
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
