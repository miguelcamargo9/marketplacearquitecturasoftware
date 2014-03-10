/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marketPlace.servlets;

import com.marketPlace.Dao.ofertaDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import sun.util.calendar.Gregorian;

/**
 *
 * @author Sebastian Rojas
 */
@WebServlet(name = "ofertaServlet", urlPatterns = {"/ofertaServlet"})
public class ofertaServlet extends HttpServlet {

  boolean bandera;
  String error = "";

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
          session.setAttribute("exito", "Se creo con exito la oferta");
          response.sendRedirect("vistas/crearOfertaServicio.jsp");
        }
      } else {
        HttpSession session = request.getSession();
        if (session != null) {
          session.setAttribute("error", error);
          response.sendRedirect("vistas/crearOfertaServicio.jsp");
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
    SimpleDateFormat formatoTexto = new SimpleDateFormat("yyyy-MM-dd");
    String descripcion = request.getParameter("descripcion");
    String idPaquete = request.getParameter("idPaquete");
    int valor = Integer.parseInt(request.getParameter("valor"));
    if (descripcion.equals("") || descripcion == null) {
      error += "Error falta la descripcion...<br>";
      bandera = false;
    } else if (idPaquete.equals("") || idPaquete == null) {
      error += "Error falta seleccionar un paquete...<br>";
      bandera = false;
    }
    try {
      Date fechaInicial = formatoTexto.parse(request.getParameter("fechaInicial"));
      Date fechaFinal = formatoTexto.parse(request.getParameter("fechaFinal"));
      ofertaDAO ofertadao = new ofertaDAO();
      ofertadao.guardarOferta(descripcion, idPaquete, fechaInicial, fechaFinal, valor);
    } catch (Exception e) {
      error += "Error en la fecha...";
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
