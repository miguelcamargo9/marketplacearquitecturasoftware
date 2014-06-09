/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.marketplaceEJB.vista.session;

import com.marketplaceJSF.negocio.entities.Transacciones;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Sebastian Rojas
 */
@Stateless
public class TransaccionesFacade extends AbstractFacade<Transacciones> {
  @PersistenceContext(unitName = "marketplaceJSF-warPU")
  private EntityManager em;

  @Override
  protected EntityManager getEntityManager() {
    return em;
  }

  public TransaccionesFacade() {
    super(Transacciones.class);
  }
  
}
