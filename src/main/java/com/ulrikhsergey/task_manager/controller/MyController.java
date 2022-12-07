package com.ulrikhsergey.task_manager.controller;


import com.ulrikhsergey.task_manager.dao.TaskRepository;
import com.ulrikhsergey.task_manager.entity.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MyController {
    @Autowired
    private TaskRepository taskRepository;

    @GetMapping
    public String indexPage (Model model){
        model.addAttribute("items",taskRepository.findAll());
        model.addAttribute("item", new Task());
        return "index";
    }

    @PostMapping
    public String newTask (Task task){
        taskRepository.save(task);

        return "redirect:/";
    }
    @DeleteMapping("/{id}")
    public String deleteTask (@PathVariable ("id") int id){
        taskRepository.deleteById(id);
        return "redirect:/";
    }
}
