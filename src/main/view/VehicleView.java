package main.view;

import main.MainDispatcher;
import main.controller.Request;
import main.model.Gomma;
import main.model.Vehicle;
import main.service.GommaService;
import main.service.VehicleService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;

public class VehicleView implements View {
    private String mode;
    private VehicleService vehicleService;
    private String role;
    private String nomeUtente;
    private String password;
    private GommaService gommaService=new GommaService();


    public VehicleView(){
        this.vehicleService=new VehicleService();
        this.mode="insert";

    }
    @Override
    public void showResults(Request request) {
        this.mode  = (String) request.get("mode");
        role=(String)request.get("role");
        nomeUtente= (String)request.get("nomeUtente");
        password= (String)request.get("password");

    }

    @Override
    public void showOptions() {
        switch(mode){
            case "insert":
                        System.out.print("Inserisci il Brand: ");
                        String brand=getInput();
                        System.out.print("Inserisci il modello: ");
                        String model=getInput();
                        System.out.print("Inserisci tipo alimentazione: ");
                        String power=getInput();
                        vehicleService.insertVehicle(new Vehicle(null,brand,model,power));
                        break;
            case "all":
                List <Vehicle> vehicles=vehicleService.getAllVehicle();
                System.out.println("-----VEICOLI DISPONIBILI-----");
                System.out.println();
                vehicles.forEach(vehicle -> System.out.println(vehicle));
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
        request.put("nomeUtente", nomeUtente);
        request.put("password", password);
        MainDispatcher.getInstance().callAction("Home", "doControl", request);

    }
}
