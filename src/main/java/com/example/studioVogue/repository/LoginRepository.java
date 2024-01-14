package com.example.studioVogue.repository;

import com.example.studioVogue.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginRepository extends JpaRepository<Users,Long> {
}
