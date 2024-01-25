package com.Gomes.pizzaria.repositories;

import com.Gomes.pizzaria.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface userRepository extends JpaRepository<User, Long> {
}
