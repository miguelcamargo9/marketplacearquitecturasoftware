/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marketPlace.Dao;

import com.marketPlace.hibernate.Adjuntos;
import com.marketPlace.hibernate.Categorias;
import com.marketPlace.hibernate.HibernateUtil;
import com.marketPlace.hibernate.Paquetes;
import com.marketPlace.hibernate.Servicios;
import java.util.ArrayList;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Sebastian Rojas
 */
public class servicioDAO {

  Session session = null;
  Categorias categoria;
  Adjuntos adjunto;
  ArrayList<Servicios> listaServicios;
  Servicios servicio;

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

  public void todoslosServicios() {
    try {
      org.hibernate.Transaction tx = session.beginTransaction();
      Query q = session.createQuery("from Servicios");
      listaServicios = (ArrayList<Servicios>) q.list();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  
  public void buscarServicioPorId(String idServicio) {
    try {
      org.hibernate.Transaction tx = session.beginTransaction();
      Query q = session.createQuery("from Servicios as s where s.id = '" + idServicio + "'");
      servicio = (Servicios) q.uniqueResult();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public ArrayList<Servicios> getListaServicios() {
    return listaServicios;
  }

  public Servicios getServicio() {
    return servicio;
  }
  
}
