/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marketPlace.modelo;

import com.marketplace.entities.Preguntas;
import com.marketplace.session.PreguntasFacade;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author Miguel
 */
public class preguntasModelo {
  PreguntasFacade preguntasFacade = lookupUsuariosFacadeBean();
  String listaSeleccionPreguntas;
  String listaSeleccionPreguntasEstado;
  List<Preguntas> listaPreguntas;

  public void crearListaPreguntasEstado(boolean estado, int idProveedor){
    preguntasFacade.buscarPreguntasSinResponder(estado, idProveedor);
    listaPreguntas = preguntasFacade.getListaPreguntas();
    listaSeleccionPreguntasEstado = "<select name=\"idPregunta\">";
    listaSeleccionPreguntasEstado += "<option value=\"\">[seleccione]</option>";
    for (Preguntas p : listaPreguntas) {
      listaSeleccionPreguntasEstado += "<option value=\"" + p.getId() + "\">" + p.getPregunta() +  "</option>";
    }
    listaSeleccionPreguntasEstado += "</select>";
  }

  public String getListaSeleccionPreguntasEstado() {
    return listaSeleccionPreguntasEstado;
  }

  private PreguntasFacade lookupUsuariosFacadeBean() {
    try {
      Context c = new InitialContext();
      return (PreguntasFacade) c.lookup("java:global/marketplaceEJB/marketplaceEJB-ejb/PreguntasFacade!com.marketplace.session.PreguntasFacade");
    } catch (NamingException ne) {
      Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
      throw new RuntimeException(ne);
    }
  }

}
