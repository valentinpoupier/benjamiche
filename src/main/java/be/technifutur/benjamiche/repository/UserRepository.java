package be.technifutur.benjamiche.repository;

import be.technifutur.benjamiche.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    // @Query("SELECT u FROM User u WHERE u.username = :username")
    Optional<User> findByUsername(String username);

    boolean existsByUsername(String username);


}
