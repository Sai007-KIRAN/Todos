/*
 * You can use the following import statements
 * 
 * import org.springframework.web.bind.annotation.*;
 * import java.util.*;
 * 
 */

// Write your code here
package com.example.todo;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;

import java.util.*;
import com.example.todo.TodoService;

@RestController
class TodoController {
    TodoService service = new TodoService();

    @GetMapping("/todos")
    public ArrayList<Todo> getTodos() {
        return service.getTodos();
    }

    @GetMapping("/todos/{todoId}")
    public Todo gettingTo(@PathVariable("todoId") int id) {
        return service.gettingTo(id);
    }

    @PostMapping("/todos")
    public Todo addTodo(@RequestBody Todo toos) {
        return service.addTodo(toos);
    }

    @PutMapping("/todos/{todoId}")
    Todo updateTodo(@PathVariable("todoId") int id, @RequestBody Todo toos) {
        return service.updateTodo(id, toos);
    }

    @DeleteMapping("/todos/{todoId}")
    void deleteTodo(@PathVariable("todoId") int id) {
        service.deleteTodo(id);
    }

}