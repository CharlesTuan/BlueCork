package br.com.bluecork.service;

import org.springframework.stereotype.Service;

import br.com.bluecork.model.User;

@Service
public interface UserService {
	User save(User user);
}