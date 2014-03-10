/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marketPlace.Dao;

import com.marketPlace.hibernate.HibernateUtil;
import com.marketPlace.hibernate.Paquetes;
import com.marketPlace.hibernate.Servicios;
import com.marketPlace.hibernate.Usuarios;
import java.util.ArrayList;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Sebastian Rojas
 */
public class paqueteDAO {

  Usuarios usuario;
  Session session = null;
  ArrayList<Paquetes> listaPaquetes;
  Paquetes paquete;

  public paqueteDAO() {
    this.session = HibernateUtil.getSessionFactory().getCurrentSession();
  }

  public void guardarPaquete(int idProveedor, String descripcion, String valor) {
    usuariosDAO usuariodao = new usuariosDAO();
    usuariodao.getBuscarIdUser(idProveedor);
    usuario = usuariodao.getUsuario();
    Paquetes paquetes = new Paquetes();
    paquetes.setUsuarios(usuario);
    paquetes.setDescripcion(descripcion);
    paquetes.setValor(Double.parseDouble(valor));
    paquetes.setEstado(true);
    try {
      org.hibernate.Transaction tx = session.beginTransaction();
      session.save(paquetes);
      tx.commit();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public void buscarPaquetePorId(String idPaquete) {
    try {
      org.hibernate.Transaction tx = session.beginTransaction();
      Query q = session.createQuery("from Paquetes as p where p.id = '" + idPaquete + "'");
      paquete = (Paquetes) q.uniqueResult();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public void todoslosPaquetes() {
    try {
      org.hibernate.Transaction tx = session.beginTransaction();
      Query q = session.createQuery("from Paquetes");
      listaPaquetes = (ArrayList<Paquetes>) q.list();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public ArrayList<Paquetes> getListaPaquetes() {
    return listaPaquetes;
  }

  public Paquetes getPaquete() {
    return paquete;
  }
  
}
