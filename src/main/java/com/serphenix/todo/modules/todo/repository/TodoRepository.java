package com.serphenix.todo.modules.todo.repository;

import com.serphenix.todo.modules.todo.entity.Todos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository extends JpaRepository<Todos, Integer> {
}
