package com.luistriana.practicamodulo7.service;

import java.util.List;

import com.luistriana.practicamodulo7.model.Usuario;

/*
     * metodos crud
      @param
     */
public interface UsuarioService {

    // agregar un usuario
    Usuario agregarUsuario(Usuario usario);

    // eliminar un usuario
    void eliminarUsuario(Long id);

    // ver todos los usuarios
    List<Usuario> verTodosLosUsuarios();

    // actualiza Usuario

    Usuario actualizarUsuario(Long id, Usuario Usuario);

    // actualizar un usuario parcialmente
   // Usuario actualizarParcialmente(Long id, Usuario usuario);

    // buscar usuaario por id 
    Usuario buscarUsuarioId (Long id);
}
