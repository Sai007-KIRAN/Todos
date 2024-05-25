// Write your code here

package com.example.todo;

import java.util.*;

public interface TodoRepository {

    ArrayList<Todo> getTodos();

    Todo gettingTo(int id);

    Todo addTodo(Todo toos);

    Todo updateTodo(int id, Todo toos);

    void deleteTodo(int id);
}