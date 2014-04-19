/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marketPlace.servlets;

import com.marketplace.session.ArchivosFacade;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

/**
 *
 * @author Sebastian Rojas
 */
@WebServlet(name = "subidaServlet", urlPatterns = {"/subidaServlet"})
@MultipartConfig
public class subidaServlet extends HttpServlet {
  @EJB
  private ArchivosFacade archivosFacade;
  private final static Logger LOGGER = Logger.getLogger(subidaServlet.class.getCanonicalName());
  boolean bandera = true;
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
        HttpSession session = request.getSession(false);
        session.setAttribute("exito", "");
        session.setAttribute("error", "");
        if (session != null) {
          session.setAttribute("exito", "Se subio con exito el archivo");
          response.sendRedirect("vistas/subidaArchivos.jsp");
        }
      } else {
        HttpSession session = request.getSession(false);
        if (session != null) {
          session.setAttribute("error", error);
          response.sendRedirect("vistas/subidaArchivos.jsp");
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
    // Create path components to save the file
    String path = "C:\\Users\\Sebastian Rojas\\Documents\\NetBeansProjects\\marketPlace\\trunk\\web\\archivos";
    Part filePart = request.getPart("archivo");
    String fileName = getFileName(filePart);
    String ruta;
    String[] nombreArchivo;
    nombreArchivo = fileName.split("\\.");
    String tipoArchivo = nombreArchivo[1];
    ruta = "archivos/" + fileName;
    archivosFacade.guardarArchivo(tipoArchivo, ruta);
    OutputStream out = null;
    InputStream filecontent = null;
    final PrintWriter writer = response.getWriter();
    try {
      out = new FileOutputStream(new File(path + File.separator + fileName));
      filecontent = filePart.getInputStream();
      int read = 0;
      final byte[] bytes = new byte[1024];
      while ((read = filecontent.read(bytes)) != -1) {
        out.write(bytes, 0, read);
      }
      processRequest(request, response);
    } catch (FileNotFoundException fne) {
      bandera = false;
      error += "Ocurrio el error: " + fne.getMessage();
    }
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

  private String getFileName(final Part part) {
    final String partHeader = part.getHeader("content-disposition");
    LOGGER.log(Level.INFO, "Part Header = {0}", partHeader);
    for (String content : part.getHeader("content-disposition").split(";")) {
      if (content.trim().startsWith("filename")) {
        return content.substring(
                content.indexOf('=') + 1).trim().replace("\"", "");
      }
    }
    return null;
  }
}
