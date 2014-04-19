/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.marketplace.session;

import com.marketplace.entities.Categorias;
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
public class CategoriasFacade extends AbstractFacade<Categorias> {
  @PersistenceContext(unitName = "marketplaceEJB-ejbPU")
  private EntityManager em;

  @Override
  protected EntityManager getEntityManager() {
    return em;
  }

  public CategoriasFacade() {
    super(Categorias.class);
  }
  
  public void guardarCategoria(String descripcion) {
     Categorias categoria = new Categorias();
     categoria.setDescripcion(descripcion);
     em.persist(categoria);
  }
  public List<Categorias> getTodaslasCategorias(){
    Query query = getEntityManager().createNamedQuery("Categorias.findAll");
    List listaCategorias = (List<Categorias>) query.getResultList();
    return listaCategorias;
  }
  
  public Categorias getCategoriaPorId(Integer id) {
    Categorias categoria = new Categorias();
    Query query = getEntityManager().createNamedQuery("Categorias.findById");
    query.setParameter("id", id);
    categoria = (Categorias) query.getSingleResult();
    return categoria;
  }
}
