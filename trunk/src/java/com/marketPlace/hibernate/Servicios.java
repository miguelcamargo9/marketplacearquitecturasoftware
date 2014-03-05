package com.marketPlace.hibernate;
// Generated 04-mar-2014 16:40:25 by Hibernate Tools 3.6.0


import java.util.HashSet;
import java.util.Set;

/**
 * Servicios generated by hbm2java
 */
public class Servicios  implements java.io.Serializable {


     private Integer id;
     private Categorias categorias;
     private String descripcion;
     private int idAdjunto;
     private long valor;
     private int estado;
     private Set<Transacciones> transaccioneses = new HashSet<Transacciones>(0);
     private Set<Paquetesdeservicios> paquetesdeservicioses = new HashSet<Paquetesdeservicios>(0);

    public Servicios() {
    }

	
    public Servicios(Categorias categorias, String descripcion, int idAdjunto, long valor, int estado) {
        this.categorias = categorias;
        this.descripcion = descripcion;
        this.idAdjunto = idAdjunto;
        this.valor = valor;
        this.estado = estado;
    }
    public Servicios(Categorias categorias, String descripcion, int idAdjunto, long valor, int estado, Set<Transacciones> transaccioneses, Set<Paquetesdeservicios> paquetesdeservicioses) {
       this.categorias = categorias;
       this.descripcion = descripcion;
       this.idAdjunto = idAdjunto;
       this.valor = valor;
       this.estado = estado;
       this.transaccioneses = transaccioneses;
       this.paquetesdeservicioses = paquetesdeservicioses;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public Categorias getCategorias() {
        return this.categorias;
    }
    
    public void setCategorias(Categorias categorias) {
        this.categorias = categorias;
    }
    public String getDescripcion() {
        return this.descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public int getIdAdjunto() {
        return this.idAdjunto;
    }
    
    public void setIdAdjunto(int idAdjunto) {
        this.idAdjunto = idAdjunto;
    }
    public long getValor() {
        return this.valor;
    }
    
    public void setValor(long valor) {
        this.valor = valor;
    }
    public int getEstado() {
        return this.estado;
    }
    
    public void setEstado(int estado) {
        this.estado = estado;
    }
    public Set<Transacciones> getTransaccioneses() {
        return this.transaccioneses;
    }
    
    public void setTransaccioneses(Set<Transacciones> transaccioneses) {
        this.transaccioneses = transaccioneses;
    }
    public Set<Paquetesdeservicios> getPaquetesdeservicioses() {
        return this.paquetesdeservicioses;
    }
    
    public void setPaquetesdeservicioses(Set<Paquetesdeservicios> paquetesdeservicioses) {
        this.paquetesdeservicioses = paquetesdeservicioses;
    }




}


