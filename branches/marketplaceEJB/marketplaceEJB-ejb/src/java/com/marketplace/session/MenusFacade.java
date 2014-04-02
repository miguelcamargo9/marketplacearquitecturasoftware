/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marketplace.session;

import com.marketplace.entities.Menus;
import com.marketplace.entities.Permisos;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Sebastian Rojas
 */
@Stateless
public class MenusFacade extends AbstractFacade<Menus> {

  @PersistenceContext(unitName = "marketplaceEJB-ejbPU")
  private EntityManager em;

  @Override
  protected EntityManager getEntityManager() {
    return em;
  }

  public MenusFacade() {
    super(Menus.class);
  }

  public ArrayList<Menus> getMenuPerfil(Permisos permiso) {
    ArrayList<Menus> menuUsuario = new ArrayList<>();
    List<String> opciones = Arrays.asList(permiso.getOpciones().split("\\,"));
    for (String a : opciones) {
      Menus opcion;
      Query query = getEntityManager().createNamedQuery("Menus.findById");
      query.setParameter("id", Integer.parseInt(a));
      opcion = (Menus) query.getSingleResult();
      menuUsuario.add(opcion);
    }
    return menuUsuario;
  }

}
