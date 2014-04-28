/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marketPlace.modelo;


import com.marketplace.entities.Categorias;
import com.marketplace.session.CategoriasFacade;
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
public class serviciosModelo {
  CategoriasFacade categoriasFacade = lookupCategoriasFacadeBean();

  String listaSelecciondeCategorias;
  List<Categorias> categoriasLista;

  public void crearListaSeleccionCategorias() {
    
    categoriasLista = categoriasFacade.getTodaslasCategorias();
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

  private CategoriasFacade lookupCategoriasFacadeBean() {
    try {
      Context c = new InitialContext();
      return (CategoriasFacade) c.lookup("java:global/marketplaceEJB/marketplaceEJB-ejb/CategoriasFacade!com.marketplace.session.CategoriasFacade");
    } catch (NamingException ne) {
      Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
      throw new RuntimeException(ne);
    }
  }
  
}
