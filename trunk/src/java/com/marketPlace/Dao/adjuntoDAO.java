/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marketPlace.Dao;

import com.marketPlace.hibernate.Adjuntos;
import com.marketPlace.hibernate.Archivos;
import com.marketPlace.hibernate.Archivosadjuntos;
import com.marketPlace.hibernate.HibernateUtil;
import com.marketPlace.hibernate.Usuarios;
import java.util.ArrayList;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Sebastian Rojas
 */
public class adjuntoDAO {

  Session session = null;
  Adjuntos adjunto;
  Archivos archivo;
  ArrayList<Adjuntos> listaAdjuntos;
  ArrayList<Archivos> listaArchivos;

  public adjuntoDAO() {
    this.session = HibernateUtil.getSessionFactory().getCurrentSession();
  }

  public void crearAdjunto(String descripcion) {
    try {
      org.hibernate.Transaction tx = session.beginTransaction();
      Adjuntos adjunto = new Adjuntos();
      adjunto.setDescripcion(descripcion);
      session.save(adjunto);
      tx.commit();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public void guardarArchivo(String tipo, String ruta) {
    try {
      org.hibernate.Transaction tx = session.beginTransaction();
      Archivos archivo = new Archivos();
      archivo.setTipo(tipo);
      archivo.setRuta(ruta);
      session.save(archivo);
      tx.commit();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public void getTodosLosAdjuntos() {
    try {
      org.hibernate.Transaction tx = session.beginTransaction();
      Query q = session.createQuery("from Adjuntos");
      listaAdjuntos = (ArrayList<Adjuntos>) q.list();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public void getTodosLosArchivos() {
    try {
      org.hibernate.Transaction tx = session.beginTransaction();
      Query q = session.createQuery("from Archivos");
      listaArchivos = (ArrayList<Archivos>) q.list();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public void guardarAdjuntosArchivos(String idadjunto,String idarchivo) {
    try {
      buscarAdjuntos(idadjunto);
      buscarArchivos(idarchivo);
      org.hibernate.Transaction tx = session.beginTransaction();
      Archivosadjuntos archivosadjuntos = new Archivosadjuntos();
      archivosadjuntos.setAdjuntos(adjunto);
      archivosadjuntos.setArchivos(archivo);
      session.save(archivosadjuntos);
      tx.commit();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  
  public void buscarAdjuntos(String id){
    try {
      org.hibernate.Transaction tx = session.beginTransaction();
      Query q = session.createQuery("from Adjuntos as a where a.id = '" + id + "'");
      adjunto = (Adjuntos) q.uniqueResult();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  public void buscarArchivos(String id){
    try {
      org.hibernate.Transaction tx = session.beginTransaction();
      Query q = session.createQuery("from Archivos as a where a.id = '" + id + "'");
      archivo = (Archivos) q.uniqueResult();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public ArrayList<Adjuntos> getListaAdjuntos() {
    return listaAdjuntos;
  }

  public ArrayList<Archivos> getListaArchivos() {
    return listaArchivos;
  }

  public Adjuntos getAdjunto() {
    return adjunto;
  }

  public Archivos getArchivo() {
    return archivo;
  }
}
