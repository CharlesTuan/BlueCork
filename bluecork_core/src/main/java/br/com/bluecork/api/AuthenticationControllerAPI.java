package br.com.bluecork.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.bluecork.model.User;
import br.com.bluecork.security.JWTUtil;
import br.com.bluecork.service.MyUserDetailsService;
import br.com.bluecork.service.UserService;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthenticationControllerAPI {

	@Autowired
	private MyUserDetailsService serviceMyUserDetail;
	@Autowired
	private JWTUtil serviceJWT;
	@Autowired
	private UserService userService;

	@PostMapping("/signin")
	public ResponseEntity signin(@RequestBody User user) {
		User userValidated = serviceMyUserDetail.buscaUsuarioSenha(user.getUserName(), user.getPassword());
		UserDetails userDetails = serviceMyUserDetail.loadUserByUsername(userValidated.getUserName());
		String token = serviceJWT.generateToken(userDetails);
		return ResponseEntity.ok(token);
	}

	@PostMapping("/signup")
	public ResponseEntity signup(@RequestBody User user) {
		User userValidated = userService.save(user);
		UserDetails userDetails = serviceMyUserDetail.loadUserByUsername(userValidated.getUserName());
		String token = serviceJWT.generateToken(userDetails);
		return ResponseEntity.ok(token);
	}
}