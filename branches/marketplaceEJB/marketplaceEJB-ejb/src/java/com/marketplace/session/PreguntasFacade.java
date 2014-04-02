/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.marketplace.session;

import com.marketplace.entities.Preguntas;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Sebastian Rojas
 */
@Stateless
public class PreguntasFacade extends AbstractFacade<Preguntas> {
  @PersistenceContext(unitName = "marketplaceEJB-ejbPU")
  private EntityManager em;

  @Override
  protected EntityManager getEntityManager() {
    return em;
  }

  public PreguntasFacade() {
    super(Preguntas.class);
  }
  
}
