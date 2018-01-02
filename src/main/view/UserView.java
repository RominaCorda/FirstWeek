package main.view;

import main.MainDispatcher;
import main.controller.Request;
import main.model.User;
import main.service.UserService;

import java.util.List;
import java.util.Scanner;

public class UserView implements View {
    private String mode;
    private UserService userService;
    private String role;
    private String username;
    private String password;

        public UserView()
        {
            this.userService= new UserService();
            this.mode="insert";
        }


    @Override
    public void showResults(Request request) {
        this.mode  = (String) request.get("mode");
        role=(String)request.get("role");
        username= (String)request.get("nomeUtente");
        password= (String)request.get("password");

    }

    @Override
    public void showOptions() {
        switch (mode){
            case "insert":
                Scanner scanner = new Scanner(System.in);
                System.out.println("-----Benvenuto nuovo utente-----");
                System.out.println("Compila i seguenti dati per la registrazione: ");
                System.out.print("USERNAME: ");
                 username=getInput();
                System.out.print("PASSWORD: ");
                password=getInput();
                role="local";
                userService.insertUser(new User(null,username,password,""));
                break;

            case "viewUser":
                List<User> users=userService.getAllUser();
                System.out.println("-----Lista utenti registrati-----");
                System.out.println();
                users.forEach(user->System.out.println(users));

                break;
        }
    }

    @Override
    public String getInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    @Override
    public void submit() {
        Request request = new Request();
        request.put("role", role);
        request.put("nomeUtente",username);
        request.put("password",password);
        MainDispatcher.getInstance().callAction("Home", "doControl", request);
    }
    }

