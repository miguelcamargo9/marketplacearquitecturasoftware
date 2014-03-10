/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marketPlace.Dao;

import com.marketPlace.hibernate.HibernateUtil;
import com.marketPlace.hibernate.Paquetes;
import com.marketPlace.hibernate.Paquetesdeservicios;
import com.marketPlace.hibernate.Servicios;
import org.hibernate.Session;

/**
 *
 * @author Sebastian Rojas
 */
public class paqueteServicioDAO {
  Paquetes paquete;
  Servicios servicio;
  Session session = null;
   public paqueteServicioDAO() {
    this.session = HibernateUtil.getSessionFactory().getCurrentSession();
  }
   public void guardarPaquetedeServicios(String idPaquete, String idServicio) {
     paqueteDAO paquetesdao = new paqueteDAO();
     servicioDAO serviciodao = new servicioDAO();
     paquetesdao.buscarPaquetePorId(idPaquete);
     serviciodao.buscarServicioPorId(idServicio);
     paquete = paquetesdao.getPaquete();
     servicio = serviciodao.getServicio();
     try {
       org.hibernate.Transaction tx = session.beginTransaction();
       Paquetesdeservicios paqueteservicios = new Paquetesdeservicios();
       paqueteservicios.setPaquetes(paquete);
       paqueteservicios.setServicios(servicio);
       paqueteservicios.setEstado(true);
       session.save(paqueteservicios);
       tx.commit();
     } catch (Exception e) {
       e.printStackTrace();
     }
   }
}
