/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.marketplace.session;

import com.marketplace.entities.Perfiles;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Sebastian Rojas
 */
@Stateless
public class PerfilesFacade extends AbstractFacade<Perfiles> {
  @PersistenceContext(unitName = "marketplaceEJB-ejbPU")
  private EntityManager em;

  @Override
  protected EntityManager getEntityManager() {
    return em;
  }

  public PerfilesFacade() {
    super(Perfiles.class);
  }
  
  public Perfiles getPerfilPorDescripcion(String descripcion) {
    Perfiles perfiles = null;
    Query query = getEntityManager().createNamedQuery("Perfiles.findByDescripcion");
    query.setParameter("descripcion", descripcion);
    perfiles = (Perfiles) query.getSingleResult();
    return perfiles;
  }
  
}
