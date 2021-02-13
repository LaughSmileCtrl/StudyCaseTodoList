package test;

import repository.TodoListRepository;
import repository.TodoListRepositoryImpl;
import service.TodoListService;
import service.TodoListServiceImpl;


public class TodoListServiceTest {

    private static TodoListService todoListService = new TodoListServiceImpl();

    public static void main(String[] args) {
        testDeleteTodoList();
        todoListService.showTodoList();
    }

    public static void testShowTodoList() {
        todoListService.showTodoList();
    }

    public static void testAddTodoList() {
        for (int i = 0; i < 3; i++) {
            todoListService.addTodoList("Ini adalah kelas tes");
            todoListService.addTodoList("dan ini tetap kelas tes");
            todoListService.addTodoList("kemudian ini masih tetap kelas tes");

        }
    }

    public static void testDeleteTodoList() {
        todoListService.addTodoList("Satu");
        todoListService.addTodoList("Dua");
        todoListService.addTodoList("Tiga");
        todoListService.addTodoList("Empat");

        System.out.println(todoListService.deleteTodoList(2));
        System.out.println(todoListService.deleteTodoList(4));
    }
}
