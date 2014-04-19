/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marketplace.session;

import com.marketplace.entities.Archivos;
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
public class ArchivosFacade extends AbstractFacade<Archivos> {

  @PersistenceContext(unitName = "marketplaceEJB-ejbPU")
  private EntityManager em;

  @Override
  protected EntityManager getEntityManager() {
    return em;
  }

  public ArchivosFacade() {
    super(Archivos.class);
  }

  public void guardarArchivo(String tipo, String ruta) {
    Archivos archivo = new Archivos();
    archivo.setRuta(ruta);
    archivo.setTipo(tipo);
    em.persist(archivo);
  }

  public List<Archivos> getTodosLosArchivos() {
    Query query = getEntityManager().createNamedQuery("Archivos.findAll");
    List archivos = (List<Archivos>) query.getResultList();
    return archivos;
  }
  
  public Archivos getArchivoPorId(Integer id) {
    Archivos archivo = new Archivos();
    Query query = getEntityManager().createNamedQuery("Archivos.findById");
    query.setParameter("id", id);
    archivo = (Archivos) query.getSingleResult();
    return archivo;
  }

}
