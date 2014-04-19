/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marketplace.session;

import com.marketplace.entities.Adjuntos;
import com.marketplace.entities.Archivos;
import com.marketplace.entities.Archivosadjuntos;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Sebastian Rojas
 */
@Stateless
public class ArchivosadjuntosFacade extends AbstractFacade<Archivosadjuntos> {

  @EJB
  private ArchivosFacade archivosFacade;
  @EJB
  private AdjuntosFacade adjuntosFacade;

  @PersistenceContext(unitName = "marketplaceEJB-ejbPU")
  private EntityManager em;

  @Override
  protected EntityManager getEntityManager() {
    return em;
  }

  public ArchivosadjuntosFacade() {
    super(Archivosadjuntos.class);
  }

  public void guardarAdjuntosArchivos(String idadjunto, String idarchivo) {
    Adjuntos adjunto = new Adjuntos();
    Archivos archivo = new Archivos();
    Archivosadjuntos archivoadjunto = new Archivosadjuntos();
    adjunto = adjuntosFacade.getAdjuntoPorId(Integer.parseInt(idadjunto));
    archivo = archivosFacade.getArchivoPorId(Integer.parseInt(idarchivo));
    archivoadjunto.setIdAdjunto(adjunto);
    archivoadjunto.setIdArchivo(archivo);
    em.persist(archivoadjunto);
  }

}
