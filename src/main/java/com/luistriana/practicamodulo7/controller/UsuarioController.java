package com.luistriana.practicamodulo7.controller;

import com.luistriana.practicamodulo7.model.Usuario;
import com.luistriana.practicamodulo7.service.UsuarioService;
import com.luistriana.practicamodulo7.service.UsuarioServiceImpl;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    private UsuarioService service;

    public UsuarioController(UsuarioService service) {
        this.service = service;
    }

    // agregar un usuario
    @PostMapping
    public ResponseEntity<Usuario> postMethodName(@RequestBody Usuario usuario) {
        Usuario creado = service.agregarUsuario(usuario);

        return ResponseEntity.status(HttpStatus.CREATED).body(creado);

    }

    // ver todos los usuarios
    @GetMapping
    public ResponseEntity<List<Usuario>> verTodosLosUsuarios() {
        List<Usuario> verUsuarios = service.verTodosLosUsuarios();
        return ResponseEntity.ok(verUsuarios);

    }

    // actualizar Usuario
    @PutMapping("/{id}")
    public ResponseEntity<Usuario> actualizarUsaurio(@PathVariable Long id, @RequestBody Usuario usuario) {
        // TODO: process PUT request
        Usuario usuarioActualizado = service.actualizarUsuario(id, usuario);

        return ResponseEntity.ok(usuarioActualizado);


    }

    // eliminar un usuario

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarUsuario(@PathVariable Long id) {

        service.eliminarUsuario(id);

        return ResponseEntity.noContent().build();

    }

    // buscar usario por id

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> buscarUsuarioId(@PathVariable Long id) {
        Usuario usuario = service.buscarUsuarioId(id);

        return ResponseEntity.ok(usuario);
    }

}
