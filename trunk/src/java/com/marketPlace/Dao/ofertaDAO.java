/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marketPlace.Dao;

import com.marketPlace.hibernate.HibernateUtil;
import com.marketPlace.hibernate.Ofertas;
import com.marketPlace.hibernate.Paquetes;
import com.marketPlace.hibernate.Permisos;
import com.marketPlace.hibernate.Usuarios;
import java.util.ArrayList;
import java.util.Date;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Sebastian Rojas
 */
public class ofertaDAO {

  Session session = null;
  Paquetes paquete;
  Ofertas oferta;

  public ofertaDAO() {
    this.session = HibernateUtil.getSessionFactory().getCurrentSession();
  }

  public void guardarOferta(String descripcion, String idPaquete, Date fechaInicial, Date fechaFinal, int valor) {
   paqueteDAO paquetedao = new paqueteDAO();
   paquetedao.buscarPaquetePorId(idPaquete);
   paquete = paquetedao.getPaquete();
    try {
      org.hibernate.Transaction tx = session.beginTransaction();
      Ofertas oferta = new Ofertas();
      oferta.setDescripcion(descripcion);
      oferta.setPaquetes(paquete);
      oferta.setFechaInicial(fechaInicial);
      oferta.setFechaFinal(fechaFinal);
      oferta.setValor(valor);
      session.save(oferta);
      tx.commit();
    } catch (Exception e) {
      e.printStackTrace();
    }

  }
  
  public void getListarUsuarios(String condicion) {
    try {
      org.hibernate.Transaction tx = session.beginTransaction();
      Query q = session.createQuery("from Permisos as p where p.descripcion = '" + condicion + "'");
//      listaUsuarios = (ArrayList<Usuarios>) q1.list();

    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
