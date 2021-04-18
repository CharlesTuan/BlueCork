package br.com.bluecork.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.bluecork.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUser(String user);
    User findByUserAndPassword(String user,String password);
}