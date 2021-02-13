package repository;

import entity.TodoList;

public class TodoListRepositoryImpl implements TodoListRepository {

    private TodoList[] todoLists = new TodoList[10];

    @Override
    public TodoList[] getAll() {
        return todoLists;
    }

    @Override
    public void add(TodoList todoList) {
        if (todoLists[(todoLists.length - 1)] != null){
            TodoList[] tmpTodoList = todoLists;
            todoLists = new TodoList[tmpTodoList.length * 2];
            System.arraycopy(tmpTodoList, 0, todoLists, 0, tmpTodoList.length);
        }

        for (int i = 0; i < todoLists.length; i++) {
            if (todoLists[i] == null) {
                todoLists[i] = todoList;
                break;
            }
        }
    }

    @Override
    public Boolean delete(Integer number) {
        if (number >= todoLists.length || number < 0) {
            return false;
        }else if (todoLists[number] == null) {
            return false;
        }else {
            for (int i = number; i < (todoLists.length - 1); i++) {
                if (todoLists[i] != null) {
                    todoLists[i] = todoLists[i+1];
                }else {
                    break;
                }
            }

            return  true;
        }
    }
}
