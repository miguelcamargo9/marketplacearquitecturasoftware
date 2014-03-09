/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marketPlace.modelo;

import com.marketPlace.Dao.adjuntoDAO;
import com.marketPlace.hibernate.Adjuntos;
import com.marketPlace.hibernate.Archivos;
import java.util.ArrayList;

/**
 *
 * @author Sebastian Rojas
 */
public class archivosAdjuntosModelo {
  
  String listaSeleccionAdjuntos;
  String listaSeleccionArchivos;
  ArrayList<Adjuntos> adjuntosLista = new ArrayList<Adjuntos>();
  ArrayList<Archivos> archivosLista = new ArrayList<Archivos>();
  adjuntoDAO adjdao = new adjuntoDAO();
  
  public void crearListaTodosLosAdjuntos() {
    adjdao.getTodosLosAdjuntos();
    adjuntosLista = adjdao.getListaAdjuntos();
    listaSeleccionAdjuntos = "<select name=\"idAdjunto\">";
    listaSeleccionAdjuntos += "<option value=\"\">[seleccione]</option>";
    for (Adjuntos a : adjuntosLista) {
      listaSeleccionAdjuntos += "<option value=\"" + a.getId() + "\">" + a.getDescripcion() + "</option>";
    }
    listaSeleccionAdjuntos += "</select>";
  }

  public void crearListaTodosLosArchivos() {
    adjdao.getTodosLosArchivos();
    archivosLista = adjdao.getListaArchivos();
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
  
}
