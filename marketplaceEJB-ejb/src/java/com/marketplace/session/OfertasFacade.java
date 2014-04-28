/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marketplace.session;

import com.marketplace.entities.Ofertas;
import com.marketplace.entities.Paquetes;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
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
public class OfertasFacade extends AbstractFacade<Ofertas> {

  @EJB
  private PaquetesFacade paquetesFacade;
  @PersistenceContext(unitName = "marketplaceEJB-ejbPU")
  private EntityManager em;

  @Override
  protected EntityManager getEntityManager() {
    return em;
  }

  public OfertasFacade() {
    super(Ofertas.class);
  }

  public void guardarOferta(String descripcion, String idPaquete, Date fechaInicial, Date fechaFinal, int valor) {
    Paquetes paquete = new Paquetes();
    Ofertas oferta = new Ofertas();
    paquete = paquetesFacade.getPaquetePorId(Integer.parseInt(idPaquete));
    oferta.setIdPaquete(paquete);
    oferta.setDescripcion(descripcion);
    oferta.setFechaFinal(fechaFinal);
    oferta.setFechaInicial(fechaInicial);
    oferta.setValor(valor);
    em.persist(oferta);
  }

  public List<Ofertas> getListadeOfertas() {
    java.util.Date fecha = new Date();
    Query query = getEntityManager().createNamedQuery("Ofertas.findByFecha");
    query.setParameter("fecha", fecha);
    return query.getResultList();
  }

  public Ofertas getOfertaPorId(int idOferta) {
    Ofertas oferta = new Ofertas();
    Query query = getEntityManager().createNamedQuery("Ofertas.findById");
    query.setParameter("id", idOferta);
    return oferta = (Ofertas) query.getSingleResult();
  }

  public List<Ofertas> getOfertasPorDescripcion(String descripcion) {
    java.util.Date fecha = new Date();
    Query query = getEntityManager().createNamedQuery("Ofertas.findByFechaDescripcion");
    query.setParameter("fecha", fecha);
    query.setParameter("descripcion", descripcion);
    List ofertas = (List<Ofertas>) query.getResultList();
    return ofertas;
  }

}
