/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.marketplace.entities;

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
@Table(name = "adjuntos", catalog = "marketplace", schema = "")
@XmlRootElement
@NamedQueries({
  @NamedQuery(name = "Adjuntos.findAll", query = "SELECT a FROM Adjuntos a"),
  @NamedQuery(name = "Adjuntos.findById", query = "SELECT a FROM Adjuntos a WHERE a.id = :id"),
  @NamedQuery(name = "Adjuntos.findByDescripcion", query = "SELECT a FROM Adjuntos a WHERE a.descripcion = :descripcion")})
public class Adjuntos implements Serializable {
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
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "idAdjunto", fetch = FetchType.LAZY)
  private List<Servicios> serviciosList;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "idAdjunto", fetch = FetchType.LAZY)
  private List<Archivosadjuntos> archivosadjuntosList;

  public Adjuntos() {
  }

  public Adjuntos(Integer id) {
    this.id = id;
  }

  public Adjuntos(Integer id, String descripcion) {
    this.id = id;
    this.descripcion = descripcion;
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

  @XmlTransient
  public List<Servicios> getServiciosList() {
    return serviciosList;
  }

  public void setServiciosList(List<Servicios> serviciosList) {
    this.serviciosList = serviciosList;
  }

  @XmlTransient
  public List<Archivosadjuntos> getArchivosadjuntosList() {
    return archivosadjuntosList;
  }

  public void setArchivosadjuntosList(List<Archivosadjuntos> archivosadjuntosList) {
    this.archivosadjuntosList = archivosadjuntosList;
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
    if (!(object instanceof Adjuntos)) {
      return false;
    }
    Adjuntos other = (Adjuntos) object;
    if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "com.marketplace.entities.Adjuntos[ id=" + id + " ]";
  }
  
}
