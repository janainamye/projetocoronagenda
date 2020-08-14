package br.gama.projagenda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.gama.projagenda.dao.UsuarioDAO;
import br.gama.projagenda.model.Usuario;

@RestController
@CrossOrigin(origins = "*")
public class UsuarioController {

	@Autowired
	private UsuarioDAO dao;

	@PostMapping("/login")
	public ResponseEntity<Usuario> login(@RequestBody Usuario user) {
		Usuario userFinded = dao.findByEmailOrRacf(user.getEmail(), user.getRacf());

		if (userFinded != null) {
			if (user.getSenha().equals(userFinded.getSenha())) {
                userFinded.setSenha("*******");
				return ResponseEntity.ok(userFinded);
			}
		}
		return ResponseEntity.status(404).build(); // usuário não existe
	}

}
