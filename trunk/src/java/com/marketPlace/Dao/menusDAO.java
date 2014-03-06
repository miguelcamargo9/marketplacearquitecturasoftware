/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marketPlace.Dao;

import com.marketPlace.hibernate.HibernateUtil;
import com.marketPlace.hibernate.Menus;
import com.marketPlace.hibernate.Permisos;
import java.util.ArrayList;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author open12
 */
public class menusDAO {

  Session session = null;
  ArrayList<Menus> menuUsuario;
  Permisos permiso;

  public menusDAO() {
    this.session = HibernateUtil.getSessionFactory().getCurrentSession();
  }

  public void getInfoPerfil(Integer idPerfil) {
    try {
      org.hibernate.Transaction tx = session.beginTransaction();
      Query q = session.createQuery("from Permisos as p where p.id = " + idPerfil);
      permiso = (Permisos) q.uniqueResult();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public void getMenuPerfil() {
    try {
      String opciones;
      opciones = permiso.getOpciones();
      org.hibernate.Transaction tx = session.beginTransaction();
      Query q = session.createQuery("from Menus as m where m.id in (" + opciones + ")");
      menuUsuario = (ArrayList<Menus>) q.list();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public ArrayList<Menus> getMenuUsuario() {
    return menuUsuario;
  }

}
