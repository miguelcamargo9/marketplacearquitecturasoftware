/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marketPlace.modelo;

import com.marketPlace.Dao.categoriaDAO;
import com.marketPlace.hibernate.Categorias;
import java.util.ArrayList;

/**
 *
 * @author Sebastian Rojas
 */
public class serviciosModelo {

  String listaSelecciondeCategorias;
  ArrayList<Categorias> categoriasLista = new ArrayList<Categorias>();
  categoriaDAO categoriasdao = new categoriaDAO();

  public void crearListaSeleccionCategorias() {
    categoriasdao.getTodaslasCategorias();
    categoriasLista = categoriasdao.getListaCategorias();
    listaSelecciondeCategorias = "<select name=\"idCategoria\">";
    listaSelecciondeCategorias += "<option value=\"\">[seleccione]</option>";
    for (Categorias c : categoriasLista) {
      listaSelecciondeCategorias += "<option value=\"" + c.getId() + "\">" + c.getDescripcion() + "</option>";
    }
    listaSelecciondeCategorias += "</select>";
  }

  public String getListaSelecciondeCategorias() {
    return listaSelecciondeCategorias;
  }
  
}
