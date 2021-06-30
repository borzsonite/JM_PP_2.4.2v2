package edu.segeyrozhkov.crud.app.repository;

import edu.segeyrozhkov.crud.app.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

    public interface UserRepository extends JpaRepository<User, Integer> {
}
