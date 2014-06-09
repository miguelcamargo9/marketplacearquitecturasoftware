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
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
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
@Table(name = "preguntas", catalog = "marketplace", schema = "")
@XmlRootElement
@NamedQueries({
  @NamedQuery(name = "Preguntas.findAll", query = "SELECT p FROM Preguntas p"),
  @NamedQuery(name = "Preguntas.findById", query = "SELECT p FROM Preguntas p WHERE p.id = :id"),
  @NamedQuery(name = "Preguntas.findByEstado", query = "SELECT p FROM Preguntas p WHERE p.estado = :estado")})
public class Preguntas implements Serializable {
  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Basic(optional = false)
  @Column(name = "id", nullable = false)
  private Integer id;
  @Basic(optional = false)
  @NotNull
  @Lob
  @Size(min = 1, max = 65535)
  @Column(name = "pregunta", nullable = false, length = 65535)
  private String pregunta;
  @Basic(optional = false)
  @NotNull
  @Lob
  @Size(min = 1, max = 65535)
  @Column(name = "respuesta", nullable = false, length = 65535)
  private String respuesta;
  @Basic(optional = false)
  @NotNull
  @Column(name = "estado", nullable = false)
  private boolean estado;
  @JoinColumn(name = "idProveedor", referencedColumnName = "id", nullable = false)
  @ManyToOne(optional = false, fetch = FetchType.LAZY)
  private Usuarios idProveedor;
  @JoinColumn(name = "idUsuario", referencedColumnName = "id", nullable = false)
  @ManyToOne(optional = false, fetch = FetchType.LAZY)
  private Usuarios idUsuario;

  public Preguntas() {
  }

  public Preguntas(Integer id) {
    this.id = id;
  }

  public Preguntas(Integer id, String pregunta, String respuesta, boolean estado) {
    this.id = id;
    this.pregunta = pregunta;
    this.respuesta = respuesta;
    this.estado = estado;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getPregunta() {
    return pregunta;
  }

  public void setPregunta(String pregunta) {
    this.pregunta = pregunta;
  }

  public String getRespuesta() {
    return respuesta;
  }

  public void setRespuesta(String respuesta) {
    this.respuesta = respuesta;
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

  public Usuarios getIdUsuario() {
    return idUsuario;
  }

  public void setIdUsuario(Usuarios idUsuario) {
    this.idUsuario = idUsuario;
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
    if (!(object instanceof Preguntas)) {
      return false;
    }
    Preguntas other = (Preguntas) object;
    if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "com.marketplaceJSF.negocio.entities.Preguntas[ id=" + id + " ]";
  }
  
}
