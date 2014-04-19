/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.marketplace.session;

import com.marketplace.entities.Paquetes;
import com.marketplace.entities.Paquetesdeservicios;
import com.marketplace.entities.Servicios;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Sebastian Rojas
 */
@Stateless
public class PaquetesdeserviciosFacade extends AbstractFacade<Paquetesdeservicios> {
  @EJB
  private ServiciosFacade serviciosFacade;
  @EJB
  private PaquetesFacade paquetesFacade;
  
  @PersistenceContext(unitName = "marketplaceEJB-ejbPU")
  private EntityManager em;
  

  @Override
  protected EntityManager getEntityManager() {
    return em;
  }

  public PaquetesdeserviciosFacade() {
    super(Paquetesdeservicios.class);
  }
  public void guardarPaquetedeServicios(String idPaquete, String idServicio) {
    Paquetes paquete = new Paquetes();
    Servicios servicio = new Servicios();
    Paquetesdeservicios paqueteServicio = new Paquetesdeservicios();
    paquete = paquetesFacade.getPaquetePorId(Integer.parseInt(idPaquete));
    servicio = serviciosFacade.getServicioPorId(Integer.parseInt(idServicio));
    paqueteServicio.setIdPaquete(paquete);
    paqueteServicio.setIdServicio(servicio);
    paqueteServicio.setEstado(true);
    em.persist(paqueteServicio);
  }
  
}
