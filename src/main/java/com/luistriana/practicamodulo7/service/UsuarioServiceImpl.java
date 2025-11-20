package com.luistriana.practicamodulo7.service;

import com.luistriana.practicamodulo7.exeption.UsuarioNoEncontradoException;
import com.luistriana.practicamodulo7.model.Usuario;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class UsuarioServiceImpl implements UsuarioService {
    private Set<Usuario> usuarios;

    public UsuarioServiceImpl(Usuario usuario) {
        this.usuarios = new HashSet<>();
    }

    @Override
    public Usuario agregarUsuario(Usuario usarioNuevo) {
        usuarios.add(usarioNuevo);
        return usarioNuevo;
    }

    @Override
    public void eliminarUsuario(Long id) {
        Usuario usuarioEliminar = buscarUsuarioId(id);
        usuarios.remove(usuarioEliminar);
    }

    @Override
    public List<Usuario> verTodosLosUsuarios() {
        return new ArrayList<>(usuarios);
    }

    @Override
    public Usuario actualizarUsuario(Long id, Usuario usuario) {
        // TODO MEJORAR ESTA ESTRUCTURA PARA RECIBIR MODELMAPER O MAPSTRUCTURE
        Usuario usuarioActual = buscarUsuarioId(id);
        usuarios.remove(usuarioActual);
        // MANTENEMOS EL ID ORGINAL
        usuario.setId(id);
        usuarios.add(usuario);
        return usuario;

    }

    /*
     * @Override
     * public Usuario actualizarParcialmente(Long id, Usuario usuario) {
     * // TODO Auto-generated method stub
     * throw new
     * UnsupportedOperationException("Unimplemented method 'actualizarParcialmente'"
     * );
     * }
     * // private final AtomicLong idGenerator = new AtomicLong(1);
     **/
    @Override
    public Usuario buscarUsuarioId(Long id) {
        return usuarios.stream().filter(usuario -> usuario.getId().equals(id))
                .findFirst()
                .orElseThrow(
                        () -> new UsuarioNoEncontradoException("el usuario con el id " + id + " no fue encotrado"));

    }

}
