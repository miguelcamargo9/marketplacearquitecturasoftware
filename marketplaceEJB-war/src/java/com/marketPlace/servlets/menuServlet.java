/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.marketPlace.servlets;

import com.google.gson.Gson;
import com.marketPlace.Vo.opciondeMenu;
import com.marketplace.entities.Menus;
import com.marketplace.entities.Permisos;
import com.marketplace.session.MenusFacade;
import com.marketplace.session.PermisosFacade;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
@WebServlet(name = "menuServlet", urlPatterns = {"/menuServlet"})
public class menuServlet extends HttpServlet {
  @EJB
  private MenusFacade menusFacade;
  @EJB
  private PermisosFacade permisosFacade;
  
  
  
private ArrayList<Menus> menuEncontrado = new ArrayList<Menus>();
  private ArrayList<opciondeMenu> opcionesMenu = new ArrayList<opciondeMenu>();

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
      String json = "";
      json = new Gson().toJson(opcionesMenu);
      response.setContentType("application/json");
      response.setCharacterEncoding("UTF-8");
      response.getWriter().write(json);
      opcionesMenu.clear();
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
    Integer perfil;
    Permisos permiso = null;
    perfil = Integer.parseInt(request.getParameter("perfil"));
    permiso = permisosFacade.getPerfilEspecifico(perfil);
    menuEncontrado = menusFacade.getMenuPerfil(permiso);
    opciondeMenu objetoOpcionMenu = new opciondeMenu();
     for (Menus opcion : menuEncontrado) {
      String padre = opcion.getIdPadre() == null ? "#" : "" + opcion.getIdPadre();
      objetoOpcionMenu.setId("" + opcion.getId());
      objetoOpcionMenu.setParent("" + padre);
      objetoOpcionMenu.setText("<a onclick=\"javascript:f_link('" + opcion.getEnlace() + "')\"> " + opcion.getDescripcion() + "</a>");
      opcionesMenu.add(objetoOpcionMenu);
      objetoOpcionMenu = new opciondeMenu();
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
