package main.view;
import main.MainDispatcher;
import main.controller.Request;
import main.model.Gomma;
import main.service.GommaService;

import java.util.List;
import java.util.Scanner;

public class GommaView implements View {

    private GommaService gommaService;
    private String mode;
    private String role;
    private String nomeUtente;
    private String password;

  public GommaView() {
      this.gommaService = new GommaService();
      this.mode = "all";
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
        switch (mode) {
            case "all":
                List<Gomma> gomme = gommaService.getAllGomme();
                System.out.println("----- Pneumatici disponibili -----");
                System.out.println();
                gomme.forEach(gomma -> System.out.println(gomma));
                break;
            case "insert":
                Scanner scanner = new Scanner(System.in);
                System.out.println("Inserisci dati del nuovo pneumatico:");
                System.out.println("Modello:");
                String model = getInput();
                System.out.println("Produttore:");
                String manufacturer = getInput();
                System.out.println("Prezzo:");
                double price = Double.parseDouble(getInput());
                System.out.println("Larghezza:");
                double width = Double.parseDouble(getInput());
                System.out.println("Altezza:");
                double height = Double.parseDouble(getInput());
                System.out.println("Diametro:");
                double diameter = Double.parseDouble(getInput());
                System.out.println("Carico:");
                double weight = Double.parseDouble(getInput());
                System.out.println("Velocita:");
                String speed = getInput();
                System.out.println("Stagioni:");
                String season = getInput();
                System.out.println("Tipo di veicolo:");
                String typeVehicle = getInput();
                int quantity=0;
                do
                {
                    System.out.println("Quantità:");
                    quantity = Integer.parseInt(getInput());
                }while(quantity<0);
                gommaService.insertGomma(new Gomma(null,model,manufacturer,price, width, height, diameter, weight, speed, season, typeVehicle,quantity));
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
