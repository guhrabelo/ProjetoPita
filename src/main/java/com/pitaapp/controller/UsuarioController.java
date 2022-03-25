package com.pitaapp.controller;

import com.pitaapp.form.UsuarioAtualizarForm;
import com.pitaapp.model.UserLogin;
import com.pitaapp.model.Usuario;
import com.pitaapp.repository.UsuarioRepository;
import com.pitaapp.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuario")
@CrossOrigin(value = "*", allowedHeaders = "*")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;
    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping("/logar")
    public ResponseEntity<UserLogin> Autentication(@RequestBody Optional<UserLogin> user) {
        return usuarioService.Logar(user).map(resposta -> ResponseEntity.ok(resposta))
                .orElse(ResponseEntity.status(HttpStatus.UNAUTHORIZED).build());
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<Usuario> Post(@Valid @RequestBody Usuario user) {
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.CadastrarUsuario(user));
    }

    @PutMapping("/atualizar")
    public ResponseEntity<Usuario> putUsuario(@RequestBody UsuarioAtualizarForm usuarioUpdateForm, UriComponentsBuilder uriBuilder) {

        Usuario usuario = usuarioService.converterUserUpdateForm(usuarioUpdateForm);

        usuarioService.atualizarUsuario(usuario, usuarioUpdateForm);

        URI uri = uriBuilder.path("/usuario/atualizar").buildAndExpand(usuario.getIdUsuario()).toUri();

        return ResponseEntity.created(uri).body(usuario);

    }

    @GetMapping("/all")
    public ResponseEntity<List<Usuario>> all() {
        return ResponseEntity.ok(usuarioRepository.findAll());
    }

}
