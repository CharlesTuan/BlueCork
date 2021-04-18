package br.com.bluecork.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import br.com.bluecork.model.User;
import br.com.bluecork.repository.UserRepository;
  
@Service
public class MyUserDetailsService implements UserDetailsService {
  
    @Autowired
    private UserRepository userRepository; 
  
    public User buscaUsuarioSenha(String userName, String password){
        return userRepository.findByUserNameAndPassword(userName, password);
    }
  
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
    	User user = userRepository.findByUserName(userName);
    	
    	if (user == null) {
    		throw new UsernameNotFoundException("Não foi possível localizar o usuário.");
    	}
    	
        return new org.springframework.security.core.userdetails.User(user.getUserName(),user.getPassword(), new ArrayList<>());
    }  
      
}