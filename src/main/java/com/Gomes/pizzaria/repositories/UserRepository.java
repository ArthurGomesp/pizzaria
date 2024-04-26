package com.Gomes.pizzaria.repositories;

import com.Gomes.pizzaria.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
