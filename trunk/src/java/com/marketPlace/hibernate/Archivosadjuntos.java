package com.marketPlace.hibernate;
// Generated 04-mar-2014 16:40:25 by Hibernate Tools 3.6.0



/**
 * Archivosadjuntos generated by hbm2java
 */
public class Archivosadjuntos  implements java.io.Serializable {


     private Integer id;
     private Archivos archivos;
     private Adjuntos adjuntos;

    public Archivosadjuntos() {
    }

    public Archivosadjuntos(Archivos archivos, Adjuntos adjuntos) {
       this.archivos = archivos;
       this.adjuntos = adjuntos;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public Archivos getArchivos() {
        return this.archivos;
    }
    
    public void setArchivos(Archivos archivos) {
        this.archivos = archivos;
    }
    public Adjuntos getAdjuntos() {
        return this.adjuntos;
    }
    
    public void setAdjuntos(Adjuntos adjuntos) {
        this.adjuntos = adjuntos;
    }




}


