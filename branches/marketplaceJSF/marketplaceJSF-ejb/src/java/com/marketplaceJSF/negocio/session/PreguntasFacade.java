/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.marketplaceJSF.negocio.session;

import com.marketplaceJSF.negocio.entities.Preguntas;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Sebastian Rojas
 */
@Stateless
public class PreguntasFacade extends AbstractFacade<Preguntas> {
  @PersistenceContext(unitName = "marketplaceJSF-ejbPU")
  private EntityManager em;

  @Override
  protected EntityManager getEntityManager() {
    return em;
  }

  public PreguntasFacade() {
    super(Preguntas.class);
  }
  
}
