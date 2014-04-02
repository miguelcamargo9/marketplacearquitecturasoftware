/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.marketplace.session;

import com.marketplace.entities.Permisos;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Sebastian Rojas
 */
@Stateless
public class PermisosFacade extends AbstractFacade<Permisos> {
  @PersistenceContext(unitName = "marketplaceEJB-ejbPU")
  private EntityManager em;

  @Override
  protected EntityManager getEntityManager() {
    return em;
  }

  public PermisosFacade() {
    super(Permisos.class);
  }
  public Permisos getPerfilEspecifico(Integer id) {
    Permisos permiso = null;
    Query query = getEntityManager().createNamedQuery("Permisos.findById");
    query.setParameter("id", id);
    permiso = (Permisos) query.getSingleResult();
    return permiso;
  }
  
}
