package main.dao;

import main.ConnectionSingleton;
import main.controller.GestoreEccezioni;
import main.model.Vehicle;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VehicleDAO {
    public VehicleDAO(){}

    public List<Vehicle> getAllVehicle() {
        List<Vehicle> veicolo = new ArrayList<>();
        Connection connection = ConnectionSingleton.getInstance();
        String queryVehicleAll = "SELECT * FROM vehicle";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(queryVehicleAll);
            while (resultSet.next()) {
                int idVehicle = resultSet.getInt("idVehicle");
                String brand = resultSet.getString("brand");
                String model = resultSet.getString("model");
                String power = resultSet.getString("power");
                veicolo.add(new Vehicle(idVehicle, brand, model, power));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return veicolo;
    }
    public boolean insertVehicle(Vehicle vehicle){
        Connection connection=ConnectionSingleton.getInstance();
        String queryinsertVehicle="INSERT INTO vehicle (idVehicle,brand,model,power) values(null,?,?,?)";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(queryinsertVehicle);
            preparedStatement.setString(1,vehicle.getBrand());
            preparedStatement.setString(2,vehicle.getModel());
            preparedStatement.setString(3,vehicle.getPower());
            return preparedStatement.execute();

        } catch (SQLException e) {
            GestoreEccezioni.getInstance().gestisciEccezione(e);
            return false;
        }
    }


}
