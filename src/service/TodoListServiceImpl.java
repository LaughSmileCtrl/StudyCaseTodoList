package service;

import entity.TodoList;
import repository.TodoListRepositoryImpl;

public class TodoListServiceImpl implements TodoListService {

    TodoListRepositoryImpl todoListRepository;

    public TodoListServiceImpl() {
        this.todoListRepository = new TodoListRepositoryImpl();
    }

    @Override
    public void showTodoList() {
        TodoList[] model = todoListRepository.getAll();


        System.out.println("TODO List : ");
        for (int i = 0; i < model.length; i++) {
            int number = i+1;
            if(model[i] != null) {
                System.out.println(number + ". " + model[i].getTodo());
            }else {
                break;
            }
        }
    }

    @Override
    public void addTodoList(String todo) {
        TodoList todoList = new TodoList(todo);
        todoListRepository.add(todoList);
    }

    @Override
    public Boolean deleteTodoList(Integer number) {
        Boolean isDeleted = todoListRepository.delete((number - 1));
        return isDeleted;
    }
}
