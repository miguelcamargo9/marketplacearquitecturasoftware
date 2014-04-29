/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marketplace.session;

import com.marketplace.entities.Perfiles;
import com.marketplace.entities.Usuarios;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Sebastian Rojas
 */
@Stateless
public class UsuariosFacade extends AbstractFacade<Usuarios> {
  @EJB
  private PerfilesFacade perfilesFacade;

  @PersistenceContext(unitName = "marketplaceEJB-ejbPU")
  private EntityManager em;
  
  private List<Usuarios> listaUsuarios;
  private Usuarios usuario = new Usuarios();

  @Override
  protected EntityManager getEntityManager() {
    return em;
  }

  public UsuariosFacade() {
    super(Usuarios.class);
  }

  public Usuarios getBuscarInfoUser(String nickname) {
    Usuarios usuario = null;
    Query query = null;
    try {
      query = getEntityManager().createNamedQuery("Usuarios.findByNickname");
      query.setParameter("nickname", nickname);
      usuario = (Usuarios) query.getSingleResult();
    } catch (javax.persistence.NoResultException e) {
      return usuario;
    } catch (NullPointerException e) {
      return usuario;
    }
    return usuario;
  }

  public Usuarios getBuscarIdUser(int cedula) {
    Query query = getEntityManager().createNamedQuery("Usuarios.findById");
    query.setParameter("id", cedula);
    usuario = (Usuarios) query.getSingleResult();
    return usuario;
  }

  public void actualizarInformacionUsuario(int idUsuario) {
    Usuarios usuario = null;
    usuario = getBuscarIdUser(idUsuario);
    usuario.setEstado(true);
    this.edit(usuario);
  }

  public void getListarUsuarios(String descripcion) {
    Perfiles perfil = null;
    perfil = perfilesFacade.getPerfilPorDescripcion(descripcion);
    Query query = getEntityManager().createNamedQuery("Usuarios.findByIdPerfil");
    query.setParameter("idPerfil", perfil.getId());
    List usuariosListado = (List<Usuarios>) query.getResultList();
    listaUsuarios = usuariosListado;
  }

  public void buscarUsuariosconSolicitudes(boolean estado) {
    Query query = getEntityManager().createNamedQuery("Usuarios.findByEstado");
    query.setParameter("estado", estado);
    listaUsuarios = query.getResultList();
  }
  
  public void buscarListaProveedores(String descripcion) {
    Query query = getEntityManager().createNamedQuery("Usuarios.findByDescripcionProveedor");
    query.setParameter("nombreComercial", descripcion);
    listaUsuarios = query.getResultList();
  }

  public List<Usuarios> getListaUsuarios() {
    return listaUsuarios;
  }

  public void setUsuario(Usuarios usuario) {
    em.persist(usuario);
  }

}
