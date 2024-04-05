package com.tcs.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tcs.domain.UserEntity;

public interface UserEntityRepo  extends JpaRepository<UserEntity, String>{

}
