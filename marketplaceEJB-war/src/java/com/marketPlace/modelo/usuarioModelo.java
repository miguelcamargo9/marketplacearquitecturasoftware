/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marketPlace.modelo;

import com.marketplace.entities.Usuarios;
import com.marketplace.session.UsuariosFacade;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 * ""
 *
 * @author open12
 */
public class usuarioModelo {
  UsuariosFacade usuariosFacade = lookupUsuariosFacadeBean();
  String listaSeleccionUsuario;
  String listaSeleccionUsuarioEstado;
  List<Usuarios> listaUsuarios;

  public void crearListaUsuarios() {
//    userdao.getListarUsuarios("Usuario");
    usuariosFacade.getListarUsuarios("Usuario");
    
    listaUsuarios = usuariosFacade.getListaUsuarios();
    listaSeleccionUsuario = "<select name=\"idUsuario\">";
    listaSeleccionUsuario += "<option value=\"\">[seleccione]</option>";
    for (Usuarios u : listaUsuarios) {
      listaSeleccionUsuario += "<option value=\"" + u.getId() + "\">" + u.getPrimerNombre() + " " + u.getPrimerApellido() + "</option>";
    }
    listaSeleccionUsuario += "</select>";
  }
  public void crearListaUsuariosEstado(boolean estado){
    usuariosFacade.buscarUsuariosconSolicitudes(estado);
    listaUsuarios = usuariosFacade.getListaUsuarios();
    listaSeleccionUsuario = "<select name=\"idUsuario\">";
    listaSeleccionUsuario += "<option value=\"\">[seleccione]</option>";
    for (Usuarios u : listaUsuarios) {
      listaSeleccionUsuario += "<option value=\"" + u.getId() + "\">" + u.getPrimerNombre() + " " + u.getPrimerApellido() + "</option>";
    }
    listaSeleccionUsuario += "</select>";
  }

  public String getListaSeleccionUsuario() {
    return listaSeleccionUsuario;
  }

  private UsuariosFacade lookupUsuariosFacadeBean() {
    try {
      Context c = new InitialContext();
      return (UsuariosFacade) c.lookup("java:global/marketplaceEJB/marketplaceEJB-ejb/UsuariosFacade!com.marketplace.session.UsuariosFacade");
    } catch (NamingException ne) {
      Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
      throw new RuntimeException(ne);
    }
  }

}
