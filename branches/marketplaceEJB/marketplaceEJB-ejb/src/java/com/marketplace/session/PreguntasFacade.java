/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marketplace.session;

import com.marketplace.entities.Preguntas;
import com.marketplace.entities.Usuarios;
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
public class PreguntasFacade extends AbstractFacade<Preguntas> {

  @PersistenceContext(unitName = "marketplaceEJB-ejbPU")
  private EntityManager em;
  
  private List<Preguntas> listaPreguntas;
  UsuariosFacade usuariosFacade;
  @Override
  protected EntityManager getEntityManager() {
    return em;
  }

  public PreguntasFacade() {
    super(Preguntas.class);
  }

  public void buscarPreguntasSinResponder(boolean estado, Integer idProveedor) {
    Usuarios proveedor = null;
    proveedor = usuariosFacade.getBuscarIdUser(idProveedor);
    Query query = getEntityManager().createNamedQuery("Preguntas.findByEstadoProveedor");
    query.setParameter("estado", estado);
    query.setParameter("idProveedor", proveedor);
    listaPreguntas = query.getResultList();
  }
  
  public List<Preguntas> getListaPreguntas() {
    return listaPreguntas;
  }
}
