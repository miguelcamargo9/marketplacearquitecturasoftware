/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marketPlace.Dao;

import com.marketPlace.hibernate.Adjuntos;
import com.marketPlace.hibernate.Categorias;
import com.marketPlace.hibernate.HibernateUtil;
import com.marketPlace.hibernate.Servicios;
import org.hibernate.Session;

/**
 *
 * @author Sebastian Rojas
 */
public class servicioDAO {
  Session session = null;
  Categorias categoria;
  Adjuntos adjunto;
  

  public servicioDAO() {
    this.session = HibernateUtil.getSessionFactory().getCurrentSession();
  }
  
  public void guardarServicio(String idCategoria, String descripcion, int idAdjunto, int valor, int estado) {
    try {
      categoriaDAO categoriadao = new categoriaDAO();
      categoriadao.getCategoriaEspecifica(idCategoria);
      categoria = categoriadao.getCategoria();
      org.hibernate.Transaction tx = session.beginTransaction();
      Servicios servicio = new Servicios();
      servicio.setCategorias(categoria);
      servicio.setDescripcion(descripcion);
      servicio.setIdAdjunto(idAdjunto);
      servicio.setValor(valor);
      servicio.setEstado(estado);
      session.save(servicio);
      tx.commit();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  
  
}
