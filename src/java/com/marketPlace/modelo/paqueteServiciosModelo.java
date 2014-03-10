/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marketPlace.modelo;

import com.marketPlace.Dao.paqueteDAO;
import com.marketPlace.Dao.servicioDAO;
import com.marketPlace.hibernate.Paquetes;
import com.marketPlace.hibernate.Servicios;
import java.util.ArrayList;

/**
 *
 * @author Sebastian Rojas
 */
public class paqueteServiciosModelo {

  String listaSeleccionPaquetes;
  String listaSeleccionServicios;
  ArrayList<Paquetes> listaPaquetes;
  ArrayList<Servicios> listaServicios;

  public void crearListaSeleccionPaquetes() {
    paqueteDAO paquetedao = new paqueteDAO();
    paquetedao.todoslosPaquetes();
    listaPaquetes = paquetedao.getListaPaquetes();
    listaSeleccionPaquetes = "<select name=\"idPaquete\">";
    listaSeleccionPaquetes += "<option value=\"\">[seleccione]</option>";
    for (Paquetes p : listaPaquetes) {
      listaSeleccionPaquetes += "<option value=\"" + p.getId() + "\">" + p.getDescripcion() + "</option>";
    }
    listaSeleccionPaquetes += "</select>";
  }

  public void crearListaSeleccionServicios() {
    servicioDAO serviciodao = new servicioDAO();
    serviciodao.todoslosServicios();
    listaServicios = serviciodao.getListaServicios();
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
}
