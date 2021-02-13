package main;

import service.TodoListServiceImpl;
import view.TodoListView;

public class TodoListApp {

    private static TodoListView todoListView = new TodoListView(new TodoListServiceImpl());

    public static void main(String[] args) {
        todoListView.show();
    }
}
