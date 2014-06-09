/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.marketplaceEJB.vista.session;

import com.marketplaceJSF.negocio.entities.Menus;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Sebastian Rojas
 */
@Stateless
public class MenusFacade extends AbstractFacade<Menus> {
  @PersistenceContext(unitName = "marketplaceJSF-warPU")
  private EntityManager em;

  @Override
  protected EntityManager getEntityManager() {
    return em;
  }

  public MenusFacade() {
    super(Menus.class);
  }
  
}
