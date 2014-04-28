/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marketPlace.modelo;

import com.marketplace.entities.Adjuntos;
import com.marketplace.entities.Archivos;
import com.marketplace.session.AdjuntosFacade;
import com.marketplace.session.ArchivosFacade;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author Sebastian Rojas
 */
public class archivosAdjuntosModelo {
  ArchivosFacade archivosFacade = lookupArchivosFacadeBean();
  AdjuntosFacade adjuntosFacade = lookupAdjuntosFacadeBean();
  
  
  String listaSeleccionAdjuntos;
  String listaSeleccionArchivos;
  List<Adjuntos> adjuntosLista;
  List<Archivos> archivosLista;
  
  
  public void crearListaTodosLosAdjuntos() {
    adjuntosLista = adjuntosFacade.getTodosLosAdjuntos();
    listaSeleccionAdjuntos = "<select name=\"idAdjunto\">";
    listaSeleccionAdjuntos += "<option value=\"\">[seleccione]</option>";
    for (Adjuntos a : adjuntosLista) {
      listaSeleccionAdjuntos += "<option value=\"" + a.getId() + "\">" + a.getDescripcion() + "</option>";
    }
    listaSeleccionAdjuntos += "</select>";
  }

  public void crearListaTodosLosArchivos() {
    archivosLista = archivosFacade.getTodosLosArchivos();
    listaSeleccionArchivos = "<select name=\"idArchivo\">";
    listaSeleccionArchivos += "<option value=\"\">[seleccione]</option>";
    
    for (Archivos a : archivosLista) {
      String[] nombreArchivo;
      nombreArchivo = a.getRuta().split("/");
      listaSeleccionArchivos += "<option value=\"" + a.getId() + "\">" + nombreArchivo[1] + "</option>";
    }
    listaSeleccionArchivos += "</select>";
  }

  public String getListaSeleccionAdjuntos() {
    return listaSeleccionAdjuntos;
  }

  public String getListaSeleccionArchivos() {
    return listaSeleccionArchivos;
  }

  private AdjuntosFacade lookupAdjuntosFacadeBean() {
    try {
      Context c = new InitialContext();
      return (AdjuntosFacade) c.lookup("java:global/marketplaceEJB/marketplaceEJB-ejb/AdjuntosFacade!com.marketplace.session.AdjuntosFacade");
    } catch (NamingException ne) {
      Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
      throw new RuntimeException(ne);
    }
  }

  private ArchivosFacade lookupArchivosFacadeBean() {
    try {
      Context c = new InitialContext();
      return (ArchivosFacade) c.lookup("java:global/marketplaceEJB/marketplaceEJB-ejb/ArchivosFacade!com.marketplace.session.ArchivosFacade");
    } catch (NamingException ne) {
      Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
      throw new RuntimeException(ne);
    }
  }
  
}
