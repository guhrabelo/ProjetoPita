package com.pitaapp.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.pitaapp.model.UserLogin;
import com.pitaapp.model.Usuario;
import com.pitaapp.model.UsuarioAtualizarForm;
import com.pitaapp.repository.UsuarioRepository;
import com.pitaapp.service.UsuarioService;

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
	public ResponseEntity<Usuario> putUsuario(@RequestBody UsuarioAtualizarForm usuarioForm,  UriComponentsBuilder uriBuilder) {

		Usuario usuario = usuarioForm.converter(usuarioRepository);

		usuarioService.atualizarUsuario(usuario, usuarioForm);

		URI uri = uriBuilder.path("/usuario/atualizar").buildAndExpand(usuario.getIdUsuario()).toUri();

		return ResponseEntity.created(uri).body(usuario);

	}

	@GetMapping("/all")
	public ResponseEntity<List<Usuario>> all() {
		return ResponseEntity.ok(usuarioRepository.findAll());
	}

}
