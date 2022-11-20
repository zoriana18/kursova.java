package com.example.kursova.commands;

import com.example.kursova.insurances.Insurance;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Show {

    public static void show(ArrayList<Insurance> insurances){
        Stage stage = new Stage();
        stage.setTitle("List of insurances");

        Button ok = new Button(" OK ");
        ok.setAlignment(Pos.CENTER);
        ok.setPrefSize(80, 30);
        ok.setPadding(new Insets(10));
        HBox hb = new HBox();

        hb.getChildren().add(ok);

        TableView<Insurance> table = CreateTable(insurances);

        VBox root = new VBox(table, ok);
        root.setAlignment(Pos.CENTER);
        root.setSpacing(10);
        Scene scene = new Scene(root, 550, 500);

        stage.setScene(scene);
        stage.show();

        ok.setOnAction(e->stage.close());

    }

    public static TableView<Insurance> CreateTable(ArrayList<Insurance> insurances){
        ObservableList<Insurance> data = FXCollections.observableArrayList();

        for(Insurance insurance: insurances)
            data.add(insurance);

        TableView<Insurance> table = new TableView<Insurance>(data);
        table.setPrefWidth(400);
        table.setPrefHeight(340);

        TableColumn<Insurance, String> typeColumn = new TableColumn<>("Type");
        typeColumn.setCellValueFactory(new PropertyValueFactory<Insurance, String>("insuranceType"));
        typeColumn.setMinWidth(75);
        table.getColumns().add(typeColumn);

        TableColumn<Insurance, String> numberColumn = new TableColumn<>("Number");
        numberColumn.setCellValueFactory(new PropertyValueFactory<Insurance, String>("number"));
        numberColumn.setMinWidth(75);
        table.getColumns().add(numberColumn);


        TableColumn<Insurance, Double> riskColumn = new TableColumn<Insurance, Double>("Risk");
        riskColumn.setCellValueFactory(new PropertyValueFactory<Insurance, Double>("riskLevel"));
        riskColumn.setMaxWidth(75);
        table.getColumns().add(riskColumn);

        TableColumn<Insurance, Integer> priceColumn = new TableColumn<Insurance, Integer>("Contribution");
        priceColumn.setCellValueFactory(new PropertyValueFactory<Insurance, Integer>("contribution"));
        priceColumn.setMinWidth(75);
        table.getColumns().add(priceColumn);


        TableColumn<Insurance, Integer> paymentColumn = new TableColumn<Insurance, Integer>("Payment");
        paymentColumn.setCellValueFactory(new PropertyValueFactory<Insurance, Integer>("payment"));
        paymentColumn.setMinWidth(100);
        table.getColumns().add(paymentColumn);

        TableColumn<Insurance, Integer> termColumn = new TableColumn<Insurance, Integer>("Term");
        termColumn.setCellValueFactory(new PropertyValueFactory<Insurance, Integer>("termOfContract"));
        termColumn.setMinWidth(100);
        table.getColumns().add(termColumn);

        return table;
    }

}




