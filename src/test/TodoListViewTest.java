package test;

import service.TodoListService;
import service.TodoListServiceImpl;
import view.TodoListView;

public class TodoListViewTest {

    private static TodoListService todoListService = new TodoListServiceImpl();
    private static TodoListView todoListView = new TodoListView(todoListService);

    public static void main(String[] args) {
        deleteTest();
        todoListView.show();
    }

    public static void showTest() {
        todoListService.addTodoList("Satu");
        todoListService.addTodoList("Dua");
        todoListService.addTodoList("tiga");

        todoListView.show();
    }

    public static void addTest() {
        todoListView.add();
    }

    public static void deleteTest() {
        todoListService.addTodoList("Satu");
        todoListService.addTodoList("Dua");
        todoListService.addTodoList("tiga");

        todoListView.delete();
    }
}
