/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marketPlace.servlets;

import com.google.gson.Gson;
import com.marketPlace.modelo.ofertasModelo;
import com.marketplace.entities.Ofertas;
import com.marketplace.session.OfertasFacade;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Sebastian Rojas
 */
@WebServlet(name = "buscarOfertaServlet", urlPatterns = {"/buscarOfertaServlet"})
public class buscarOfertaServlet extends HttpServlet {

  @EJB
  private OfertasFacade ofertasFacade;
  List<Ofertas> ofertasLista;
  ofertasModelo ofertamodelo;
  String grilla = "";

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
     for (Ofertas oferta : ofertasLista) {
      grilla += "<div class=\"col-sm-4 col-lg-4 col-md-4\">\n"
              + "                        <div class=\"thumbnail\">\n"
              + "                            <div class=\"caption\">\n"
              + "                                <h4 class=\"pull-right\">" + oferta.getValor() + "</h4>\n"
              + "                                <h4><a href=\"#\">" + oferta.getDescripcion() + "</a>\n"
              + "                                </h4>\n"
              + "                                <p><input type=\"radio\" name=\"oferta\" value=\"" + oferta.getId() + "\">Comprar</p>\n"
              + "                            </div>\n"
              + "                        </div>\n"
              + "                    </div>";
    }
      response.getWriter().write(grilla);
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
    String descripcion = request.getParameter("descripcion");
    ofertasLista = ofertasFacade.getOfertasPorDescripcion(descripcion);
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
