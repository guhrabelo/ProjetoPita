package com.pitaapp.service;

import com.pitaapp.model.Agendamento;
import com.pitaapp.model.Usuario;
import com.pitaapp.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AgendamentoService {

    @Autowired
    UsuarioRepository usuarioRepository;
    @Autowired
    UsuarioService userService;

    public List<Agendamento> findByUser(int idUser /*receber o agendamento como parametro tbm*/) {
        Usuario usuario = new Usuario();

        Optional<Usuario> user = usuarioRepository.findById(idUser);

        usuario = user.get();
        System.out.println(usuario.getAgendamento());

        return usuario.getAgendamento();


    }

}
