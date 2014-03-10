/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marketPlace.Dao;

import com.marketPlace.hibernate.Categorias;
import com.marketPlace.hibernate.HibernateUtil;
import java.util.ArrayList;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Sebastian Rojas
 */
public class categoriaDAO {

  Session session = null;
  ArrayList<Categorias> listaCategorias;
  Categorias categoria;

  public categoriaDAO() {
    this.session = HibernateUtil.getSessionFactory().getCurrentSession();
  }

  public void getTodaslasCategorias() {
    try {
      org.hibernate.Transaction tx = session.beginTransaction();
      Query q = session.createQuery("from Categorias");
      listaCategorias = (ArrayList<Categorias>) q.list();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public Categorias getCategoriaEspecifica(String id) {
    try {
      org.hibernate.Transaction tx = session.beginTransaction();
      Query q = session.createQuery("from Categorias as c where c.id= '" + id + "'");
      categoria = (Categorias) q.uniqueResult();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return categoria;
  }

  public ArrayList<Categorias> getListaCategorias() {
    return listaCategorias;
  }
}
