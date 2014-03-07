/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marketPlace.modelo;

import com.marketPlace.Dao.usuariosDAO;
import com.marketPlace.hibernate.Usuarios;
import java.util.ArrayList;

/**
 * ""
 *
 * @author open12
 */
public class usuarioModelo {

  String listaSeleccionUsuario;
  usuariosDAO userdao = new usuariosDAO();
  ArrayList<Usuarios> listaUsuarios = new ArrayList<Usuarios>();

  public void crearListaUsuarios() {
    userdao.getListarUsuarios("Usuario");
    listaUsuarios = userdao.getListaUsuarios();
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

}
