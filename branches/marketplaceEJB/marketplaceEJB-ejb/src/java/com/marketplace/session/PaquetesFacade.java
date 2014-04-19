/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.marketplace.session;

import com.marketplace.entities.Paquetes;
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
public class PaquetesFacade extends AbstractFacade<Paquetes> {
  @EJB
  private UsuariosFacade usuariosFacade;
  @PersistenceContext(unitName = "marketplaceEJB-ejbPU")
  private EntityManager em;
  

  @Override
  protected EntityManager getEntityManager() {
    return em;
  }

  public PaquetesFacade() {
    super(Paquetes.class);
  }
  public void guardarPaquete(int idProveedor, String descripcion, String valor) {
    Usuarios usuario = new Usuarios();
   Paquetes paquete = new Paquetes();
    usuario = usuariosFacade.getBuscarIdUser(idProveedor);
    paquete.setIdProveedor(usuario);
    paquete.setDescripcion(descripcion);
    paquete.setValor((double) Integer.parseInt(valor));
    paquete.setEstado(true);
    em.persist(paquete);
  }
  public List<Paquetes> getListaPaquetes() {
    Query query = getEntityManager().createNamedQuery("Paquetes.findAll");
    List listaPaquetes = (List<Paquetes>) query.getResultList();
    return listaPaquetes;
  }
  
  public Paquetes getPaquetePorId(Integer id) {
    Paquetes paquete = new Paquetes();
    Query query = getEntityManager().createNamedQuery("Paquetes.findById");
    query.setParameter("id", id);
    paquete = (Paquetes) query.getSingleResult();
    return paquete;
  }
}
