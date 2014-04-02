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
@Table(name = "archivos", catalog = "marketplace", schema = "")
@XmlRootElement
@NamedQueries({
  @NamedQuery(name = "Archivos.findAll", query = "SELECT a FROM Archivos a"),
  @NamedQuery(name = "Archivos.findById", query = "SELECT a FROM Archivos a WHERE a.id = :id"),
  @NamedQuery(name = "Archivos.findByTipo", query = "SELECT a FROM Archivos a WHERE a.tipo = :tipo"),
  @NamedQuery(name = "Archivos.findByRuta", query = "SELECT a FROM Archivos a WHERE a.ruta = :ruta")})
public class Archivos implements Serializable {
  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Basic(optional = false)
  @Column(name = "id", nullable = false)
  private Integer id;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 50)
  @Column(name = "tipo", nullable = false, length = 50)
  private String tipo;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 50)
  @Column(name = "ruta", nullable = false, length = 50)
  private String ruta;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "idArchivo", fetch = FetchType.LAZY)
  private List<Archivosadjuntos> archivosadjuntosList;

  public Archivos() {
  }

  public Archivos(Integer id) {
    this.id = id;
  }

  public Archivos(Integer id, String tipo, String ruta) {
    this.id = id;
    this.tipo = tipo;
    this.ruta = ruta;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getTipo() {
    return tipo;
  }

  public void setTipo(String tipo) {
    this.tipo = tipo;
  }

  public String getRuta() {
    return ruta;
  }

  public void setRuta(String ruta) {
    this.ruta = ruta;
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
    if (!(object instanceof Archivos)) {
      return false;
    }
    Archivos other = (Archivos) object;
    if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "com.marketplace.entities.Archivos[ id=" + id + " ]";
  }
  
}
