package com.todo.list.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.todo.list.entity.listaEntity;

@Repository
public interface listaRepository extends JpaRepository<listaEntity, Integer> {

}
