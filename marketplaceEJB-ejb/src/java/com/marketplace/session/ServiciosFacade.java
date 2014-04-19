/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.marketplace.session;

import com.marketplace.entities.Adjuntos;
import com.marketplace.entities.Categorias;
import com.marketplace.entities.Servicios;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Sebastian Rojas
 */
@Stateless
public class ServiciosFacade extends AbstractFacade<Servicios> {
  @EJB
  private AdjuntosFacade adjuntosFacade;
  @EJB
  private CategoriasFacade categoriasFacade;
  
  @PersistenceContext(unitName = "marketplaceEJB-ejbPU")
  private EntityManager em;

  @Override
  protected EntityManager getEntityManager() {
    return em;
  }

  public ServiciosFacade() {
    super(Servicios.class);
  }
  
  public void guardarServicio(String idCategoria, String descripcion, int idAdjunto, int valor, int estado) {
    Categorias categoria = new Categorias();
    Servicios servicio = new Servicios();
    Adjuntos adjunto = new Adjuntos();
    categoria = categoriasFacade.getCategoriaPorId(Integer.parseInt(idCategoria));
    adjunto = adjuntosFacade.getAdjuntoPorId(idAdjunto);
    servicio.setIdCategoria(categoria);
    servicio.setDescripcion(descripcion);
    servicio.setIdAdjunto(adjunto);
    servicio.setValor(valor);
    servicio.setEstado(estado);
    em.persist(servicio);
  }
  public List<Servicios> getListaServicios() {
    Query query = getEntityManager().createNamedQuery("Servicios.findAll");
    List listaServicios = (List<Servicios>) query.getResultList();
    return listaServicios;
  }
  
  public Servicios getServicioPorId(Integer id) {
    Servicios servicio = new Servicios();
    Query query = getEntityManager().createNamedQuery("Servicios.findById");
    query.setParameter("id", id);
    servicio = (Servicios) query.getSingleResult();
    return servicio;
  }
}
