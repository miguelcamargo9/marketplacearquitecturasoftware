/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marketplace.session;

import com.marketplace.entities.Preguntas;
import com.marketplace.entities.Usuarios;
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
public class PreguntasFacade extends AbstractFacade<Preguntas> {

  @PersistenceContext(unitName = "marketplaceEJB-ejbPU")
  private EntityManager em;
  private Usuarios proveedor = new Usuarios();
  private List<Preguntas> listaPreguntas;
  private Preguntas pregunta = new Preguntas();
  @EJB
  UsuariosFacade usuariosFacade;
  @Override
  protected EntityManager getEntityManager() {
    return em;
  }

  public PreguntasFacade() {
    super(Preguntas.class);
  }

  public void buscarPreguntasSinResponder(boolean estado, Integer idProveedor) { 
    proveedor = usuariosFacade.getBuscarIdUser(idProveedor);
    Query query = getEntityManager().createNamedQuery("Preguntas.findByEstadoProveedor");
    query.setParameter("estado", estado);
    query.setParameter("idProveedor", proveedor);
    listaPreguntas = query.getResultList();
  }
  
  public List<Preguntas> getListaPreguntas() {
    return listaPreguntas;
  }
  
  public Preguntas getBuscarIdPregunta(int idPregunta) {
    Query query = getEntityManager().createNamedQuery("Preguntas.findById");
    query.setParameter("id", idPregunta);
    pregunta = (Preguntas) query.getSingleResult();
    return pregunta;
  }
  
  public void editarPregunta(Preguntas pregunta){
    this.edit(pregunta);
  } 
  public void guardarPregunta(Preguntas pregunta){
    this.create(pregunta);
  } 
  
}
