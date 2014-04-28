/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marketPlace.modelo;

import com.marketplace.entities.Ofertas;
import com.marketplace.session.OfertasFacade;
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
public class ofertasModelo {

  OfertasFacade ofertasFacade = lookupOfertasFacadeBean();
  List<Ofertas> listaOfertas;

  public ofertasModelo() {
  }

  public String crearGrillaOfertas() {
    String grilla = "";
    for (Ofertas oferta : listaOfertas) {
      grilla +="<div class=\"col-sm-4 col-lg-4 col-md-4\">\n" +
"                        <div class=\"thumbnail\">\n" +
"                            <div class=\"caption\">\n" +
"                                <h4 class=\"pull-right\">"+oferta.getValor()+"</h4>\n" +
"                                <h4><a href=\"#\">"+oferta.getDescripcion()+"</a>\n" +
"                                </h4>\n" +
"                                <p><input type=\"radio\" name=\"oferta\" value=\""+oferta.getId()+"\">Comprar</p>\n" +
"                            </div>\n" +
"                        </div>\n" +
"                    </div>";
    }
    return grilla;
  }

  public void setListaInicialOfertas() {
    listaOfertas = ofertasFacade.getListadeOfertas();
  }

  public void setListaOfertaPorDescripcion(String descripcion) {
    listaOfertas = ofertasFacade.getOfertasPorDescripcion(descripcion);
  }
  
  

  private OfertasFacade lookupOfertasFacadeBean() {
    try {
      Context c = new InitialContext();
      return (OfertasFacade) c.lookup("java:global/marketplaceEJB/marketplaceEJB-ejb/OfertasFacade!com.marketplace.session.OfertasFacade");
    } catch (NamingException ne) {
      Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
      throw new RuntimeException(ne);
    }
  }

}
