package main.view;

import main.MainDispatcher;
import main.controller.Request;

import java.util.Scanner;

public class HomeView implements View {

    private int choice;
    private String role;
    private String nomeUtente;
    private String password;


    public void showResults(Request request) {
        if(request!= null)
        {
            role=(String)request.get("role");
            nomeUtente=(String) request.get("nomeUtente");
            password=(String) request.get("password");
        }

    }


    public void showOptions() {
        System.out.println("Benvenuto in WheelsStore");
        System.out.println("");
        System.out.println("");
        if(role.equals("admin"))
        {

            System.out.println("-------MENU ADMIN-------");
            System.out.println("");
            System.out.println("Benvenuto admin "+nomeUtente);
            System.out.println("Azioni disponibili:");
            System.out.println("1) Inserisci nuovo pnematico");
            System.out.println("2) Inserisci veicolo");
            System.out.println("3) Visualizza pneumatici disponibili");
            System.out.println("4) Visualizza utenti registrati");
            System.out.println("5) Visualizza Veicoli");
            System.out.println("6) Logout");
            this.choice = Integer.parseInt(getInput());}
        else
            if (role.equals("local"))
            {
                System.out.println("-------MENU USER-------");
                System.out.println("Benvenuto utente "+ nomeUtente);
                System.out.println("Azioni disponibili:");
                System.out.println("1) Visualizza pneumatici disponibili");
                System.out.println("2) Logout");
                this.choice = Integer.parseInt(getInput());
           }
    }

    public void submit() {
        if (role.equals("admin")) {
            if (choice < 1 || choice > 6) {
                Request request = new Request();
                request.put("role", role);
                request.put("nomeUtente", nomeUtente);
                request.put("password", password);
                MainDispatcher.getInstance().callAction("Home", "doControl", request);
            }  if (choice == 6)
                MainDispatcher.getInstance().callAction("Login", "doControl", null);
            if (choice==4) {
                Request request = new Request();
                request.put("choice", choice);
                request.put("role", role);
                request.put("nomeUtente", nomeUtente);
                request.put("password", password);
                MainDispatcher.getInstance().callAction("User","doControl",request);

            }
            if(choice==2 || choice==5){
                Request request = new Request();
                request.put("choice", choice);
                request.put("role", role);
                request.put("nomeUtente", nomeUtente);
                request.put("password", password);
                MainDispatcher.getInstance().callAction("Vehicle","doControl",request);
            }
            else  {
                Request request = new Request();
                request.put("choice", choice);
                request.put("role", role);
                request.put("nomeUtente", nomeUtente);
                request.put("password", password);
                MainDispatcher.getInstance().callAction("Gomma", "doControl", request);

            }
        }  if (role.equals("local")) {
            if (choice < 1 || choice > 2) {
                Request request = new Request();
                request.put("role", role);
                request.put("nomeUtente", nomeUtente);
                request.put("password", password);
                MainDispatcher.getInstance().callAction("Home", "doControl", request);

            }  if (choice == 2)
            {
                MainDispatcher.getInstance().callAction("Login", "doControl", null);
            }

            else {
                Request request = new Request();
                request.put("choice", choice);
                request.put("role", role);
                request.put("nomeUtente", nomeUtente);
                request.put("password", password);
                MainDispatcher.getInstance().callAction("Gomma", "doControl", request);
            }
        }
    }


    public String getInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }


}
