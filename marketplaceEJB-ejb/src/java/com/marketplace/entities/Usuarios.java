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
@Table(name = "usuarios", catalog = "marketplace", schema = "")
@XmlRootElement
@NamedQueries({
  @NamedQuery(name = "Usuarios.findAll", query = "SELECT u FROM Usuarios u"),
  @NamedQuery(name = "Usuarios.findById", query = "SELECT u FROM Usuarios u WHERE u.id = :id"),
  @NamedQuery(name = "Usuarios.findByPrimerNombre", query = "SELECT u FROM Usuarios u WHERE u.primerNombre = :primerNombre"),
  @NamedQuery(name = "Usuarios.findBySegundoNombre", query = "SELECT u FROM Usuarios u WHERE u.segundoNombre = :segundoNombre"),
  @NamedQuery(name = "Usuarios.findByPrimerApellido", query = "SELECT u FROM Usuarios u WHERE u.primerApellido = :primerApellido"),
  @NamedQuery(name = "Usuarios.findBySegundoApellido", query = "SELECT u FROM Usuarios u WHERE u.segundoApellido = :segundoApellido"),
  @NamedQuery(name = "Usuarios.findByNombreComercial", query = "SELECT u FROM Usuarios u WHERE u.nombreComercial = :nombreComercial"),
  @NamedQuery(name = "Usuarios.findByNickname", query = "SELECT u FROM Usuarios u WHERE u.nickname = :nickname"),
  @NamedQuery(name = "Usuarios.findByContrasena", query = "SELECT u FROM Usuarios u WHERE u.contrasena = :contrasena"),
  @NamedQuery(name = "Usuarios.findByCorreo", query = "SELECT u FROM Usuarios u WHERE u.correo = :correo"),
  @NamedQuery(name = "Usuarios.findByIdPerfil", query = "SELECT u FROM Usuarios u WHERE u.idPerfil = :idPerfil"),
  @NamedQuery(name = "Usuarios.findByEstado", query = "SELECT u FROM Usuarios u WHERE u.estado = :estado")})
public class Usuarios implements Serializable {
  private static final long serialVersionUID = 1L;
  @Id
  @Basic(optional = false)
  @NotNull
  @Column(name = "id", nullable = false)
  private Integer id;
  @Size(max = 20)
  @Column(name = "primerNombre", length = 20)
  private String primerNombre;
  @Size(max = 20)
  @Column(name = "segundoNombre", length = 20)
  private String segundoNombre;
  @Size(max = 20)
  @Column(name = "primerApellido", length = 20)
  private String primerApellido;
  @Size(max = 20)
  @Column(name = "segundoApellido", length = 20)
  private String segundoApellido;
  @Size(max = 50)
  @Column(name = "nombreComercial", length = 50)
  private String nombreComercial;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 20)
  @Column(name = "nickname", nullable = false, length = 20)
  private String nickname;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 20)
  @Column(name = "contrasena", nullable = false, length = 20)
  private String contrasena;
  @Size(max = 30)
  @Column(name = "correo", length = 30)
  private String correo;
  @Column(name = "idPerfil")
  private Integer idPerfil;
  @Basic(optional = false)
  @NotNull
  @Column(name = "estado", nullable = false)
  private boolean estado;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "idProveedor", fetch = FetchType.LAZY)
  private List<Paquetes> paquetesList;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "idProveedor", fetch = FetchType.LAZY)
  private List<Preguntas> preguntasList;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUsuario", fetch = FetchType.LAZY)
  private List<Preguntas> preguntasList1;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUsuario", fetch = FetchType.LAZY)
  private List<Transacciones> transaccionesList;

  public Usuarios() {
  }

  public Usuarios(Integer id) {
    this.id = id;
  }

  public Usuarios(Integer id, String nickname, String contrasena, boolean estado) {
    this.id = id;
    this.nickname = nickname;
    this.contrasena = contrasena;
    this.estado = estado;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getPrimerNombre() {
    return primerNombre;
  }

  public void setPrimerNombre(String primerNombre) {
    this.primerNombre = primerNombre;
  }

  public String getSegundoNombre() {
    return segundoNombre;
  }

  public void setSegundoNombre(String segundoNombre) {
    this.segundoNombre = segundoNombre;
  }

  public String getPrimerApellido() {
    return primerApellido;
  }

  public void setPrimerApellido(String primerApellido) {
    this.primerApellido = primerApellido;
  }

  public String getSegundoApellido() {
    return segundoApellido;
  }

  public void setSegundoApellido(String segundoApellido) {
    this.segundoApellido = segundoApellido;
  }

  public String getNombreComercial() {
    return nombreComercial;
  }

  public void setNombreComercial(String nombreComercial) {
    this.nombreComercial = nombreComercial;
  }

  public String getNickname() {
    return nickname;
  }

  public void setNickname(String nickname) {
    this.nickname = nickname;
  }

  public String getContrasena() {
    return contrasena;
  }

  public void setContrasena(String contrasena) {
    this.contrasena = contrasena;
  }

  public String getCorreo() {
    return correo;
  }

  public void setCorreo(String correo) {
    this.correo = correo;
  }

  public Integer getIdPerfil() {
    return idPerfil;
  }

  public void setIdPerfil(Integer idPerfil) {
    this.idPerfil = idPerfil;
  }

  public boolean getEstado() {
    return estado;
  }

  public void setEstado(boolean estado) {
    this.estado = estado;
  }

  @XmlTransient
  public List<Paquetes> getPaquetesList() {
    return paquetesList;
  }

  public void setPaquetesList(List<Paquetes> paquetesList) {
    this.paquetesList = paquetesList;
  }

  @XmlTransient
  public List<Preguntas> getPreguntasList() {
    return preguntasList;
  }

  public void setPreguntasList(List<Preguntas> preguntasList) {
    this.preguntasList = preguntasList;
  }

  @XmlTransient
  public List<Preguntas> getPreguntasList1() {
    return preguntasList1;
  }

  public void setPreguntasList1(List<Preguntas> preguntasList1) {
    this.preguntasList1 = preguntasList1;
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
    if (!(object instanceof Usuarios)) {
      return false;
    }
    Usuarios other = (Usuarios) object;
    if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "com.marketplace.entities.Usuarios[ id=" + id + " ]";
  }
  
}
