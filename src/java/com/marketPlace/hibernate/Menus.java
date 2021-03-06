package com.marketPlace.hibernate;
// Generated 04-mar-2014 16:40:25 by Hibernate Tools 3.6.0



/**
 * Menus generated by hbm2java
 */
public class Menus  implements java.io.Serializable {


     private int id;
     private Integer idPadre;
     private String descripcion;
     private String enlace;
     private boolean estado;

    public Menus() {
    }

	
    public Menus(int id, String descripcion, String enlace, boolean estado) {
        this.id = id;
        this.descripcion = descripcion;
        this.enlace = enlace;
        this.estado = estado;
    }
    public Menus(int id, Integer idPadre, String descripcion, String enlace, boolean estado) {
       this.id = id;
       this.idPadre = idPadre;
       this.descripcion = descripcion;
       this.enlace = enlace;
       this.estado = estado;
    }
   
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    public Integer getIdPadre() {
        return this.idPadre;
    }
    
    public void setIdPadre(Integer idPadre) {
        this.idPadre = idPadre;
    }
    public String getDescripcion() {
        return this.descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public String getEnlace() {
        return this.enlace;
    }
    
    public void setEnlace(String enlace) {
        this.enlace = enlace;
    }
    public boolean isEstado() {
        return this.estado;
    }
    
    public void setEstado(boolean estado) {
        this.estado = estado;
    }




}


