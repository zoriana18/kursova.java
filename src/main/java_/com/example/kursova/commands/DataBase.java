package com.example.kursova.commands;

import com.example.kursova.insurances.Vehicle;
import com.example.kursova.insurances.House;
import com.example.kursova.insurances.Insurance;
import com.example.kursova.insurances.Life;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.sql.*;
import java.util.ArrayList;

public class DataBase {

    public static void Connect(ArrayList<Insurance> insurances) {

        String url = "jdbc:sqlserver://localhost\\MSSQLSERVER:1433;database=Insurances;user=user_zk;password=11111";
        Label l;
        Stage stage = new Stage();
        stage.setTitle("BD");
        Button ok = new Button(" ok ");

        VBox vBox = new VBox();
        vBox.setSpacing(20);
        vBox.setPadding(new Insets(18));
        vBox.setAlignment(Pos.CENTER);

        try (Connection connection = DriverManager.getConnection(url)){
            try(Statement st = connection.createStatement()) {
                try (ResultSet resultSet1 = st.executeQuery("select * from Life")) {

                    while (resultSet1.next()) {
                        Life p = new Life(resultSet1.getInt("number"),resultSet1.getInt("age"), resultSet1.getInt("health"),resultSet1.getInt("term"));
                        insurances.add(p);
                    }

                    try (ResultSet resultSet2 = st.executeQuery("select * from Vehicle")) {

                        while (resultSet2.next()) {
                            Vehicle c = new Vehicle(resultSet2.getInt("number"),resultSet2.getString("type_of_vehicle"), resultSet2.getInt("vehicle_price"), resultSet2.getInt("motor_volume"),resultSet2.getInt("term"));
                            insurances.add(c);
                        }

                        try (ResultSet resultSet3 = st.executeQuery("select * from House")) {
                            while (resultSet3.next()) {
                                House h = new House(resultSet3.getInt("number"),resultSet3.getInt("area"), resultSet3.getInt("house_price"),resultSet3.getInt("term"));
                                insurances.add(h);
                            }
                        }
                    }
                }
            }
            l = new Label("Completed successfully!");

        } catch (SQLException e) {
            e.printStackTrace();
            l = new Label("Error");
        }

        ok.setOnAction(e->stage.close());

        vBox.getChildren().addAll(l, ok);
        Scene sc_sort = new Scene(vBox, 200, 100);
        stage.setScene(sc_sort);
        stage.showAndWait();
    }
}
