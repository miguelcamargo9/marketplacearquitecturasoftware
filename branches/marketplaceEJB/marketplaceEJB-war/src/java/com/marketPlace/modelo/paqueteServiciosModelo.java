/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marketPlace.modelo;

import com.marketplace.entities.Paquetes;
import com.marketplace.entities.Servicios;
import com.marketplace.session.PaquetesFacade;
import com.marketplace.session.ServiciosFacade;
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
public class paqueteServiciosModelo {
  ServiciosFacade serviciosFacade = lookupServiciosFacadeBean();
  PaquetesFacade paquetesFacade = lookupPaquetesFacadeBean();

  String listaSeleccionPaquetes;
  String listaSeleccionServicios;
  List<Paquetes> listaPaquetes;
  List<Servicios> listaServicios;

  public void crearListaSeleccionPaquetes() {
    listaPaquetes = paquetesFacade.getListaPaquetes();
    listaSeleccionPaquetes = "<select name=\"idPaquete\">";
    listaSeleccionPaquetes += "<option value=\"\">[seleccione]</option>";
    for (Paquetes p : listaPaquetes) {
      listaSeleccionPaquetes += "<option value=\"" + p.getId() + "\">" + p.getDescripcion() + "</option>";
    }
    
    listaSeleccionPaquetes += "</select>";
  }

  public void crearListaSeleccionServicios() {
    listaServicios = serviciosFacade.getListaServicios();
    listaSeleccionServicios = "<select name=\"idServicio\">";
    listaSeleccionServicios += "<option value=\"\">[seleccione]</option>";
    for (Servicios s : listaServicios) {
      listaSeleccionServicios += "<option value=\"" + s.getId() + "\">" + s.getDescripcion() + "</option>";
    }
    listaSeleccionServicios += "</select>";
  }

  public String getListaSeleccionPaquetes() {
    return listaSeleccionPaquetes;
  }

  public String getListaSeleccionServicios() {
    return listaSeleccionServicios;
  }

  private PaquetesFacade lookupPaquetesFacadeBean() {
    try {
      Context c = new InitialContext();
      return (PaquetesFacade) c.lookup("java:global/marketplaceEJB/marketplaceEJB-ejb/PaquetesFacade!com.marketplace.session.PaquetesFacade");
    } catch (NamingException ne) {
      Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
      throw new RuntimeException(ne);
    }
  }

  private ServiciosFacade lookupServiciosFacadeBean() {
    try {
      Context c = new InitialContext();
      return (ServiciosFacade) c.lookup("java:global/marketplaceEJB/marketplaceEJB-ejb/ServiciosFacade!com.marketplace.session.ServiciosFacade");
    } catch (NamingException ne) {
      Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
      throw new RuntimeException(ne);
    }
  }
}
