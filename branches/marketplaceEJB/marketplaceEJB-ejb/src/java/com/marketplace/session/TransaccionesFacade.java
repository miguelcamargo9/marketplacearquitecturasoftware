/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marketplace.session;

import com.marketplace.entities.Ofertas;
import com.marketplace.entities.Paquetes;
import com.marketplace.entities.Transacciones;
import com.marketplace.entities.Usuarios;
import java.util.Date;
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
public class TransaccionesFacade extends AbstractFacade<Transacciones> {

  @EJB
  private UsuariosFacade usuariosFacade;
  @EJB
  private OfertasFacade ofertasFacade;

  @PersistenceContext(unitName = "marketplaceEJB-ejbPU")
  private EntityManager em;

  @Override
  protected EntityManager getEntityManager() {
    return em;
  }

  public TransaccionesFacade() {
    super(Transacciones.class);
  }

  public void guardarTransaccionOferta(int idPaquete, int idUsuario) {
    Ofertas oferta = new Ofertas();
    Usuarios usuario = new Usuarios();
    java.util.Date fecha = new Date();
    Transacciones transaccion = new Transacciones();
    oferta = ofertasFacade.getOfertaPorId(idPaquete);
    usuario = usuariosFacade.getBuscarIdUser(idUsuario);
    transaccion.setFechaTransaccion(fecha);
    transaccion.setIdOferta(oferta);
    transaccion.setIdUsuario(usuario);
    em.persist(transaccion);
  }

  public List<Transacciones> listaTransaccionesPorRango(int idUsuario, Date fechaI, Date fechaF) {
    Query query = getEntityManager().createNamedQuery("Transacciones.findByRangoId");
    query.setParameter("idUsuario", idUsuario);
    query.setParameter("inicial", fechaI);
    query.setParameter("final", fechaF);
    List listaTransacciones = (List<Transacciones>) query.getResultList();
    return listaTransacciones;
  }

}
