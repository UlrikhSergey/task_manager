package com.ulrikhsergey.task_manager.dao;


import com.ulrikhsergey.task_manager.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task,Integer> {
}
