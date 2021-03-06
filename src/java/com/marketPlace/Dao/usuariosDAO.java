/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marketPlace.Dao;

import com.marketPlace.hibernate.HibernateUtil;
import com.marketPlace.hibernate.Permisos;
import com.marketPlace.hibernate.Usuarios;
import java.util.ArrayList;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author open12
 */
public class usuariosDAO {

  Session session = null;
  private Usuarios usuario;
  private Permisos permiso;
  private ArrayList<Usuarios> listaUsuarios = new ArrayList<Usuarios>();

  public usuariosDAO() {
    this.session = HibernateUtil.getSessionFactory().getCurrentSession();
  }

  public void getBuscarInfoUser(String nickname) {
    try {
      org.hibernate.Transaction tx = session.beginTransaction();
      Query q = session.createQuery("from Usuarios as u where u.nickname = '" + nickname + "'");
      usuario = (Usuarios) q.uniqueResult();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  
  public void getBuscarIdUser(int cedula) {
    try {
      org.hibernate.Transaction tx = session.beginTransaction();
      Query q = session.createQuery("from Usuarios as u where u.id = " + cedula + "");
      usuario = (Usuarios) q.uniqueResult();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
 
  public void getBuscarUserByIdNick(String nickname, int idUsuario) {
    try {
      org.hibernate.Transaction tx = session.beginTransaction();
      Query q = session.createQuery("from Usuarios as u where u.nickname = '" + nickname + "' or u.id = "+ idUsuario +"");
      usuario = (Usuarios) q.uniqueResult();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  
  public void setInfoUser(Usuarios usuario) {
    try {
      org.hibernate.Transaction tx = session.beginTransaction();
      session.save(usuario);
      tx.commit();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public void getListarUsuarios(String descripcion) {
    try {
      org.hibernate.Transaction tx = session.beginTransaction();
      Query q = session.createQuery("from Permisos as p where p.descripcion = '" + descripcion + "'");
      permiso = (Permisos) q.uniqueResult();
      Query q1 = session.createQuery("from Usuarios as u where u.Perfiles = " + permiso);
      listaUsuarios = (ArrayList<Usuarios>) q1.list();

    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  
  public void buscarUsuariosconSolicitudes(boolean estado) {
    try {
      org.hibernate.Transaction tx = session.beginTransaction();
      Query q = session.createQuery("from Usuarios as u where u.estado = " + estado);
      listaUsuarios = (ArrayList<Usuarios>) q.list();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  
  public void actualizarInformacionUsuario(int idUsuario) {
    getBuscarIdUser(idUsuario);
    usuario.setEstado(true);
    try {
      org.hibernate.Transaction tx = session.beginTransaction();
      session.update(usuario);
      tx.commit();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public ArrayList<Usuarios> getListaUsuarios() {
    return listaUsuarios;
  }

  public Usuarios getUsuario() {
    return usuario;
  }
}
