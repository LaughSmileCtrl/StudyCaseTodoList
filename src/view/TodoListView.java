package view;

import service.TodoListService;
import service.TodoListServiceImpl;

import java.util.Scanner;

public class TodoListView {

    private TodoListService todoListService;

    public TodoListView(TodoListService todoListService) {

        this.todoListService = todoListService;
    }

    private String userInput(String lable) {
        System.out.print(lable + ": ");
        Scanner terminalIn = new Scanner(System.in);
        String strUserInput = terminalIn.nextLine();
        return strUserInput;
    }

    public void show() {
        while (true) {

            todoListService.showTodoList();

            System.out.println("MENU");
            System.out.println("1. Tambah todo");
            System.out.println("2. menghapus todo");
            System.out.println("x. exit");

            String choise = userInput("Pilihan menu");

            if(choise.equals("x")) {
                break;
            }else if(choise.equals("1")){
                add();
            }else if(choise.equals("2")) {
                delete();
            }else {
                System.out.println("PILIHAN TIDAK TERDEFINISI");
            }
        }
    }

    public void add() {
        System.out.println("Menambah TODO");
        String insertTodo = userInput("TODO baru (x jika ingin cancel)");

        if(insertTodo.equals("x")) {
            return;
        }else {
            todoListService.addTodoList(insertTodo);
        }
    }

    public void delete() {
        System.out.println("Menghapus TODO");
        String todoNumStr = userInput("Nomor TODO (x jika ingin cancel)");

        if (todoNumStr.equals("x")) {
            return;
        } else {
            Integer todoNumInt = Integer.parseInt(todoNumStr);
            boolean isSuccess = todoListService.deleteTodoList(todoNumInt);

            if(isSuccess) {
                System.out.println("Berhasil meghapus todo ke " + todoNumStr);
            } else {
                System.out.println("Gagal menghapus todo");
            }
        }
    }
}
