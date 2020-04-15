package com.example.newTest.repositories;

import com.example.newTest.entity.User_info;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface User_infoRepository extends JpaRepository<User_info, Integer> {

}
