/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.marketplace.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Sebastian Rojas
 */
@Entity
@Table(name = "transacciones", catalog = "marketplace", schema = "")
@XmlRootElement
@NamedQueries({
  @NamedQuery(name = "Transacciones.findAll", query = "SELECT t FROM Transacciones t"),
  @NamedQuery(name = "Transacciones.findById", query = "SELECT t FROM Transacciones t WHERE t.id = :id"),
  @NamedQuery(name = "Transacciones.findByRangoId", query = "SELECT t FROM Transacciones t WHERE t.idUsuario = :idUsuario AND t.fechaTransaccion BETWEEN :inicial AND :final"),
  @NamedQuery(name = "Transacciones.findByFechaTransaccion", query = "SELECT t FROM Transacciones t WHERE t.fechaTransaccion = :fechaTransaccion")})
public class Transacciones implements Serializable {
  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Basic(optional = false)
  @Column(name = "id", nullable = false)
  private Integer id;
  @Basic(optional = false)
  @NotNull
  @Column(name = "fechaTransaccion", nullable = false)
  @Temporal(TemporalType.DATE)
  private Date fechaTransaccion;
  @JoinColumn(name = "idUsuario", referencedColumnName = "id", nullable = false)
  @ManyToOne(optional = false, fetch = FetchType.LAZY)
  private Usuarios idUsuario;
  @JoinColumn(name = "idServicio", referencedColumnName = "id")
  @ManyToOne(fetch = FetchType.LAZY)
  private Servicios idServicio;
  @JoinColumn(name = "idPaquete", referencedColumnName = "id")
  @ManyToOne(fetch = FetchType.LAZY)
  private Paquetes idPaquete;
  @JoinColumn(name = "idOferta", referencedColumnName = "id")
  @ManyToOne(fetch = FetchType.LAZY)
  private Ofertas idOferta;

  public Transacciones() {
  }

  public Transacciones(Integer id) {
    this.id = id;
  }

  public Transacciones(Integer id, Date fechaTransaccion) {
    this.id = id;
    this.fechaTransaccion = fechaTransaccion;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Date getFechaTransaccion() {
    return fechaTransaccion;
  }

  public void setFechaTransaccion(Date fechaTransaccion) {
    this.fechaTransaccion = fechaTransaccion;
  }

  public Usuarios getIdUsuario() {
    return idUsuario;
  }

  public void setIdUsuario(Usuarios idUsuario) {
    this.idUsuario = idUsuario;
  }

  public Servicios getIdServicio() {
    return idServicio;
  }

  public void setIdServicio(Servicios idServicio) {
    this.idServicio = idServicio;
  }

  public Paquetes getIdPaquete() {
    return idPaquete;
  }

  public void setIdPaquete(Paquetes idPaquete) {
    this.idPaquete = idPaquete;
  }

  public Ofertas getIdOferta() {
    return idOferta;
  }

  public void setIdOferta(Ofertas idOferta) {
    this.idOferta = idOferta;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (id != null ? id.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof Transacciones)) {
      return false;
    }
    Transacciones other = (Transacciones) object;
    if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "com.marketplace.entities.Transacciones[ id=" + id + " ]";
  }
  
}
