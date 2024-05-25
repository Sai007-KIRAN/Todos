/*
 * You can use the following import statements
 * 
 * import org.springframework.web.server.ResponseStatusException;
 * import org.springframework.http.HttpStatus;
 * 
 */

package com.example.todo;

import com.example.todo.Todo;
import com.example.todo.TodoRepository;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;
import java.util.*;

// Do not modify the below code

public class TodoService implements TodoRepository {

    private static HashMap<Integer, Todo> todoList = new HashMap<>();
    int unique = 6;

    public TodoService() {
        todoList.put(1, new Todo(1, "Watch Movie", "LOW", "TO DO"));
        todoList.put(2, new Todo(2, "Finish Project", "HIGH", "IN PROGRESS"));
        todoList.put(3, new Todo(3, "Buy Groceries", "MEDIUM", "TO DO"));
        todoList.put(4, new Todo(4, "Learning from NxtWave", "HIGH", "IN PROGRESS"));
        todoList.put(5, new Todo(5, "Go for a Run", "MEDIUM", "DONE"));

    }

    // Do not modify the above code

    // Write your code here
    @Override
    public ArrayList<Todo> getTodos() {

        Collection<Todo> todo = todoList.values();
        ArrayList<Todo> gettingTodo = new ArrayList<>(todo);
        return gettingTodo;
    }

    @Override
    public Todo gettingTo(int id) {
        Todo each = todoList.get(id);
        if (each == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return each;
    }

    @Override

    public Todo addTodo(Todo toos) {
        toos.setId(unique);
        todoList.put(unique, toos);
        unique += 1;
        return toos;
    }

    @Override
    public Todo updateTodo(int id, Todo toos) {
        Todo existing = todoList.get(id);
        if (existing == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        if (existing.getTodo() != null) {
            existing.setTodo(toos.getTodo());
        }
        if (existing.getPriority() != null) {
            existing.setPriority(toos.getPriority());
        }
        if (existing.getStatus() != null) {
            existing.setStatus(toos.getStatus());
        }
        return existing;
    }

    @Override
    public void deleteTodo(int id) {
        Todo deleting = todoList.get(id);
        if (deleting == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        } else {
            todoList.remove(id);
            throw new ResponseStatusException(HttpStatus.NO_CONTENT);
        }
    }
}
