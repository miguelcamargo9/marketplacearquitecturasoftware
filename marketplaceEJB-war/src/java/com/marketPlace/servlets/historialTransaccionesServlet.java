/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marketPlace.servlets;

import com.marketplace.entities.Transacciones;
import com.marketplace.session.TransaccionesFacade;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.text.SimpleDateFormat;
import java.util.Date;
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
 * @author Sebastian Rojas
 */
@WebServlet(name = "historialTransaccionesServlet", urlPatterns = {"/historialTransaccionesServlet"})
public class historialTransaccionesServlet extends HttpServlet {

  @EJB
  private TransaccionesFacade transaccionesFacade;
  List<Transacciones> listaTransacciones;
  boolean bandera = true;
  String error = "";

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
          session.setAttribute("listaTransacciones", listaTransacciones);
          response.sendRedirect("vistas/listaTransacciones.jsp");
        }
      } else {
        HttpSession session = request.getSession();
        if (session != null) {
          session.setAttribute("error", error);
          response.sendRedirect("vistas/listaTransacciones.jsp");
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
    SimpleDateFormat formatoTexto = new SimpleDateFormat("yyyy-MM-dd");
    try {
      int idUsuario = Integer.parseInt(request.getParameter("idUsuario"));
      Date fechaInicial = formatoTexto.parse(request.getParameter("fechaInicial"));
      Date fechaFinal = formatoTexto.parse(request.getParameter("fechaFinal"));
      listaTransacciones = transaccionesFacade.listaTransaccionesPorRango(idUsuario, fechaInicial, fechaFinal);
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
