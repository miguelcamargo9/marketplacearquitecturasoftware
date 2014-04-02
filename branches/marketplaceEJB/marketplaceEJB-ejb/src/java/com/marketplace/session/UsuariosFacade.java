/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.marketplace.session;

import com.marketplace.entities.Usuarios;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Sebastian Rojas
 */
@Stateless
public class UsuariosFacade extends AbstractFacade<Usuarios> {
  @PersistenceContext(unitName = "marketplaceEJB-ejbPU")
  private EntityManager em;

  @Override
  protected EntityManager getEntityManager() {
    return em;
  }

  public UsuariosFacade() {
    super(Usuarios.class);
  }
  public Usuarios getBuscarInfoUser(String nickname) {
    Usuarios usuario = null;
    Query query = getEntityManager().createNamedQuery("Usuarios.findByNickname");
    query.setParameter("nickname", nickname);
    usuario = (Usuarios) query.getSingleResult();
    return usuario;
  }
  
}
