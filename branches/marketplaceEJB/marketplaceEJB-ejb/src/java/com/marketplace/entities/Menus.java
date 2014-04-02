/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.marketplace.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Sebastian Rojas
 */
@Entity
@Table(name = "menus", catalog = "marketplace", schema = "")
@XmlRootElement
@NamedQueries({
  @NamedQuery(name = "Menus.findAll", query = "SELECT m FROM Menus m"),
  @NamedQuery(name = "Menus.findById", query = "SELECT m FROM Menus m WHERE m.id = :id"),
  @NamedQuery(name = "Menus.findByIdPadre", query = "SELECT m FROM Menus m WHERE m.idPadre = :idPadre"),
  @NamedQuery(name = "Menus.findByDescripcion", query = "SELECT m FROM Menus m WHERE m.descripcion = :descripcion"),
  @NamedQuery(name = "Menus.findByEnlace", query = "SELECT m FROM Menus m WHERE m.enlace = :enlace"),
  @NamedQuery(name = "Menus.findByEstado", query = "SELECT m FROM Menus m WHERE m.estado = :estado")})
public class Menus implements Serializable {
  private static final long serialVersionUID = 1L;
  @Id
  @Basic(optional = false)
  @NotNull
  @Column(name = "id", nullable = false)
  private Integer id;
  @Column(name = "idPadre")
  private Integer idPadre;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 50)
  @Column(name = "descripcion", nullable = false, length = 50)
  private String descripcion;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 50)
  @Column(name = "enlace", nullable = false, length = 50)
  private String enlace;
  @Basic(optional = false)
  @NotNull
  @Column(name = "estado", nullable = false)
  private boolean estado;

  public Menus() {
  }

  public Menus(Integer id) {
    this.id = id;
  }

  public Menus(Integer id, String descripcion, String enlace, boolean estado) {
    this.id = id;
    this.descripcion = descripcion;
    this.enlace = enlace;
    this.estado = estado;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getIdPadre() {
    return idPadre;
  }

  public void setIdPadre(Integer idPadre) {
    this.idPadre = idPadre;
  }

  public String getDescripcion() {
    return descripcion;
  }

  public void setDescripcion(String descripcion) {
    this.descripcion = descripcion;
  }

  public String getEnlace() {
    return enlace;
  }

  public void setEnlace(String enlace) {
    this.enlace = enlace;
  }

  public boolean getEstado() {
    return estado;
  }

  public void setEstado(boolean estado) {
    this.estado = estado;
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
    if (!(object instanceof Menus)) {
      return false;
    }
    Menus other = (Menus) object;
    if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "com.marketplace.entities.Menus[ id=" + id + " ]";
  }
  
}
