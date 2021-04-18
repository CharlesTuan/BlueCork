package br.com.bluecork.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.bluecork.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    public User findByUserName(String userName);
    public User findByUserNameAndPassword(String userName,String password);
}