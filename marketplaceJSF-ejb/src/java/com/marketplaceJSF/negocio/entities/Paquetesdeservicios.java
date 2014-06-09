/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.marketplaceJSF.negocio.entities;

import java.io.Serializable;
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
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Sebastian Rojas
 */
@Entity
@Table(name = "paquetesdeservicios", catalog = "marketplace", schema = "")
@XmlRootElement
@NamedQueries({
  @NamedQuery(name = "Paquetesdeservicios.findAll", query = "SELECT p FROM Paquetesdeservicios p"),
  @NamedQuery(name = "Paquetesdeservicios.findById", query = "SELECT p FROM Paquetesdeservicios p WHERE p.id = :id"),
  @NamedQuery(name = "Paquetesdeservicios.findByEstado", query = "SELECT p FROM Paquetesdeservicios p WHERE p.estado = :estado")})
public class Paquetesdeservicios implements Serializable {
  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Basic(optional = false)
  @Column(name = "id", nullable = false)
  private Integer id;
  @Basic(optional = false)
  @NotNull
  @Column(name = "estado", nullable = false)
  private boolean estado;
  @JoinColumn(name = "idServicio", referencedColumnName = "id", nullable = false)
  @ManyToOne(optional = false, fetch = FetchType.LAZY)
  private Servicios idServicio;
  @JoinColumn(name = "idPaquete", referencedColumnName = "id", nullable = false)
  @ManyToOne(optional = false, fetch = FetchType.LAZY)
  private Paquetes idPaquete;

  public Paquetesdeservicios() {
  }

  public Paquetesdeservicios(Integer id) {
    this.id = id;
  }

  public Paquetesdeservicios(Integer id, boolean estado) {
    this.id = id;
    this.estado = estado;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public boolean getEstado() {
    return estado;
  }

  public void setEstado(boolean estado) {
    this.estado = estado;
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

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (id != null ? id.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof Paquetesdeservicios)) {
      return false;
    }
    Paquetesdeservicios other = (Paquetesdeservicios) object;
    if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "com.marketplaceJSF.negocio.entities.Paquetesdeservicios[ id=" + id + " ]";
  }
  
}
