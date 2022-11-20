package com.example.kursova;

import com.example.kursova.commands.*;
import com.example.kursova.insurances.Insurance;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

public class Main extends Application {
    Button b_start, b_add, b_del, b_show, b_der, b_bd, b_ex;
    ArrayList<Insurance> insurances = new ArrayList<>();
    public static void main(String[] args) {

        launch();
    }

    @Override
    public void start(Stage stage) throws IOException {

        stage.setTitle("Insurance Company 'Phoenix'");

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(300,300, 300, 300));
        grid.setVgap(15);
        grid.setHgap(15);
        grid.setAlignment(Pos.CENTER);


        Image image = new Image(new FileInputStream("src\\main\\resources\\com\\example\\kursova\\phoenix.jpg"));
        ImageView imageView = new ImageView(image);

        imageView.setFitHeight(300);
        imageView.setFitWidth(500);

        imageView.setPreserveRatio(true);
        VBox vBox = new VBox();
        vBox.setPadding(new Insets(20));
        vBox.setSpacing(10);
        vBox.setAlignment(Pos.CENTER);

        b_start = new Button(" Start ");
        b_start.setPrefSize(200, 40);
        b_add = new Button("  Add new insurance ");
        b_add.setPrefSize(200, 50);
        b_del = new Button("Delete the insurance ");
        b_del.setPrefSize(200, 50);
        b_show = new Button("       Show all insurances       ");
        b_show.setPrefSize(200, 50);
        b_der = new Button("  Create a derivative  ");
        b_der.setPrefSize(200, 50);
        b_bd = new Button("   Get data from DataBase   ");
        b_bd.setPrefSize(200, 50);
        b_ex = new Button("Exit");
        b_ex.setPrefSize(200, 50);


        vBox.getChildren().addAll(imageView, b_start);


        GridPane.setConstraints(b_add, 1, 0);
        GridPane.setConstraints(b_del, 2, 0);
        GridPane.setConstraints(b_show, 3, 0);
        GridPane.setConstraints(b_der, 1, 1);
        GridPane.setConstraints(b_bd,2, 1);
        GridPane.setConstraints(b_ex, 3, 1);
        grid.setPadding(new Insets(30));
        grid.getChildren().addAll(b_add,b_del, b_show, b_der, b_bd, b_ex);

        b_add.setOnAction(e-> Add.add(insurances));
        b_show.setOnAction(e-> Show.show(insurances));
        b_del.setOnAction(e-> Delete.delete(insurances));
        b_der.setOnAction(e-> Derivative.createDerivative(insurances));
        b_bd.setOnAction(e-> DataBase.Connect(insurances));
        b_ex.setOnAction(e->stage.close());

        Scene scene_main = new Scene(vBox, 600, 400);
        Scene sc1 = new Scene(grid, 600, 400);
        b_start.setOnAction(e->stage.setScene(sc1));
        stage.setScene(scene_main);
        stage.show();
    }

}