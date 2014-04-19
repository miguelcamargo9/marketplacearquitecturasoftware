/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marketplace.session;

import com.marketplace.entities.Adjuntos;
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
public class AdjuntosFacade extends AbstractFacade<Adjuntos> {

  @PersistenceContext(unitName = "marketplaceEJB-ejbPU")
  private EntityManager em;

  @Override
  protected EntityManager getEntityManager() {
    return em;
  }

  public AdjuntosFacade() {
    super(Adjuntos.class);
  }

  public void crearAdjunto(String descripcion) {
    Adjuntos adjunto = new Adjuntos();
    adjunto.setDescripcion(descripcion);
    em.persist(adjunto);
  }

  public List<Adjuntos> getTodosLosAdjuntos() {
    Query query = getEntityManager().createNamedQuery("Adjuntos.findAll");
    List adjuntos = (List<Adjuntos>) query.getResultList();
    return adjuntos;
  }

  public Adjuntos getAdjuntoPorId(Integer id) {
    Adjuntos adjunto = new Adjuntos();
    Query query = getEntityManager().createNamedQuery("Adjuntos.findById");
    query.setParameter("id", id);
    adjunto = (Adjuntos) query.getSingleResult();
    return adjunto;
  }

}
