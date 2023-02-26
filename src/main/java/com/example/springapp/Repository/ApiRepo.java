package com.example.springapp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Repository;

import com.example.springapp.Model.ApiModel;



//@Repository
public interface ApiRepo extends JpaRepository<ApiModel, Integer> {

}
