package com.example.demo2;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
 interface StudentsDAO extends JpaRepository<StudentDTO, Integer> {	

}


