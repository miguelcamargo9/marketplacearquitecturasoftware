/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.marketplaceJSF.negocio.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Sebastian Rojas
 */
@Entity
@Table(name = "paquetes", catalog = "marketplace", schema = "")
@XmlRootElement
@NamedQueries({
  @NamedQuery(name = "Paquetes.findAll", query = "SELECT p FROM Paquetes p"),
  @NamedQuery(name = "Paquetes.findById", query = "SELECT p FROM Paquetes p WHERE p.id = :id"),
  @NamedQuery(name = "Paquetes.findByDescripcion", query = "SELECT p FROM Paquetes p WHERE p.descripcion = :descripcion"),
  @NamedQuery(name = "Paquetes.findByValor", query = "SELECT p FROM Paquetes p WHERE p.valor = :valor"),
  @NamedQuery(name = "Paquetes.findByEstado", query = "SELECT p FROM Paquetes p WHERE p.estado = :estado")})
public class Paquetes implements Serializable {
  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Basic(optional = false)
  @Column(name = "id", nullable = false)
  private Integer id;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 50)
  @Column(name = "descripcion", nullable = false, length = 50)
  private String descripcion;
  @Basic(optional = false)
  @NotNull
  @Column(name = "valor", nullable = false)
  private double valor;
  @Basic(optional = false)
  @NotNull
  @Column(name = "estado", nullable = false)
  private boolean estado;
  @JoinColumn(name = "idProveedor", referencedColumnName = "id", nullable = false)
  @ManyToOne(optional = false, fetch = FetchType.LAZY)
  private Usuarios idProveedor;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPaquete", fetch = FetchType.LAZY)
  private List<Ofertas> ofertasList;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPaquete", fetch = FetchType.LAZY)
  private List<Paquetesdeservicios> paquetesdeserviciosList;
  @OneToMany(mappedBy = "idPaquete", fetch = FetchType.LAZY)
  private List<Transacciones> transaccionesList;

  public Paquetes() {
  }

  public Paquetes(Integer id) {
    this.id = id;
  }

  public Paquetes(Integer id, String descripcion, double valor, boolean estado) {
    this.id = id;
    this.descripcion = descripcion;
    this.valor = valor;
    this.estado = estado;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getDescripcion() {
    return descripcion;
  }

  public void setDescripcion(String descripcion) {
    this.descripcion = descripcion;
  }

  public double getValor() {
    return valor;
  }

  public void setValor(double valor) {
    this.valor = valor;
  }

  public boolean getEstado() {
    return estado;
  }

  public void setEstado(boolean estado) {
    this.estado = estado;
  }

  public Usuarios getIdProveedor() {
    return idProveedor;
  }

  public void setIdProveedor(Usuarios idProveedor) {
    this.idProveedor = idProveedor;
  }

  @XmlTransient
  public List<Ofertas> getOfertasList() {
    return ofertasList;
  }

  public void setOfertasList(List<Ofertas> ofertasList) {
    this.ofertasList = ofertasList;
  }

  @XmlTransient
  public List<Paquetesdeservicios> getPaquetesdeserviciosList() {
    return paquetesdeserviciosList;
  }

  public void setPaquetesdeserviciosList(List<Paquetesdeservicios> paquetesdeserviciosList) {
    this.paquetesdeserviciosList = paquetesdeserviciosList;
  }

  @XmlTransient
  public List<Transacciones> getTransaccionesList() {
    return transaccionesList;
  }

  public void setTransaccionesList(List<Transacciones> transaccionesList) {
    this.transaccionesList = transaccionesList;
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
    if (!(object instanceof Paquetes)) {
      return false;
    }
    Paquetes other = (Paquetes) object;
    if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "com.marketplaceJSF.negocio.entities.Paquetes[ id=" + id + " ]";
  }
  
}
