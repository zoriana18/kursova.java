package com.example.kursova.commands;

import com.example.kursova.insurances.Insurance;
import com.example.kursova.insurances.Vehicle;
import com.example.kursova.insurances.House;
import com.example.kursova.insurances.Life;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Add {

    static Insurance newins ;

    public static void add(ArrayList<Insurance> insurances){
        Stage stage = new Stage();
        stage.setTitle("New insurance");
        stage.initModality(Modality.APPLICATION_MODAL);

        Label l1 = new Label("  Choose type of insurance:");
        l1.setPadding(new Insets(10));

        Button b_l = new Button("Life");
        Button b_v = new Button("  Vehicle  ");
        Button b_h = new Button("House");
        b_l.setPrefSize(100, 50);
        b_v.setPrefSize(100, 50);
        b_h.setPrefSize(100, 50);

        HBox hb2 = new HBox();
        hb2.setSpacing(40);
        hb2.getChildren().addAll(b_l, b_v, b_h);

        Button b_ok = new Button(" Back");
        b_ok.setPrefSize(50, 30);
        VBox vb_ok = new VBox();
        vb_ok.setAlignment(Pos.CENTER_RIGHT);
        vb_ok.getChildren().add(b_ok);

        Button b_p1 = new Button(" OK ");
        Button b_c1 = new Button(" OK");
        Button b_h1 = new Button(" OK ");

        TextField tf_p1 = new TextField();
        TextField tf_p2 = new TextField();
        TextField tf_p3 = new TextField();
        TextField tf_p4 = new TextField();
        TextField tf_c1 = new TextField();
        TextField tf_c2 = new TextField();
        TextField tf_c3 = new TextField();
        TextField tf_c5 = new TextField();
        TextField tf_h1 = new TextField();
        TextField tf_h2 = new TextField();
        TextField tf_h3 = new TextField();
        TextField tf_h4 = new TextField();

        ChoiceBox<String> choiceBox= new ChoiceBox<>();
        choiceBox.getItems().addAll("car", "bus", "motorcycle", "truck");

        BorderPane layout = new BorderPane();
        layout.setPadding(new Insets(20));
        layout.setTop(l1);
        layout.setCenter(hb2);
        layout.setBottom(vb_ok);


        b_l.setOnAction(e->{

            GridPane grid_p = new GridPane();
            grid_p.setPadding(new Insets(30,30, 30, 30));
            grid_p.setVgap(15);
            grid_p.setHgap(15);
            Label l_p1 = new Label("Enter number of contract");
            Label l_p2 = new Label("Enter age");
            Label l_p3 = new Label("Enter health level(1-3)");
            Label l_p4 = new Label("Enter term of contract");

            GridPane.setConstraints(l_p1, 0, 0);
            GridPane.setConstraints(tf_p1, 1, 0);
            GridPane.setConstraints(l_p2, 0, 1);
            GridPane.setConstraints(tf_p2, 1, 1);
            GridPane.setConstraints(l_p3, 0, 2);
            GridPane.setConstraints(tf_p3, 1, 2);
            GridPane.setConstraints(l_p4, 0, 3);
            GridPane.setConstraints(tf_p4, 1, 3);
            GridPane.setConstraints(b_p1, 1, 5);


            grid_p.getChildren().addAll(l_p1, tf_p1, l_p2, tf_p2,l_p3, tf_p3,l_p4, tf_p4, b_p1);
            Scene sc_p = new Scene(grid_p,350, 200);
            stage.setScene(sc_p);

        });
        b_v.setOnAction(e->{

            GridPane grid_c = new GridPane();
            grid_c.setPadding(new Insets(30,30, 30, 30));
            grid_c.setVgap(15);
            grid_c.setHgap(15);
            Label l_c1 = new Label("enter number of contract");
            Label l_c2 = new Label("enter price");
            Label l_c3 = new Label("enter motor volume");
            Label l_c4 = new Label("choose type");
            Label l_c5 = new Label("enter term of contract");
            choiceBox.setValue("car");

            GridPane.setConstraints(l_c1, 0, 0);
            GridPane.setConstraints(tf_c1, 1, 0);
            GridPane.setConstraints(l_c2, 0, 1);
            GridPane.setConstraints(tf_c2, 1, 1);
            GridPane.setConstraints(l_c3, 0, 2);
            GridPane.setConstraints(tf_c3, 1, 2);
            GridPane.setConstraints(l_c4,0,3);
            GridPane.setConstraints(choiceBox,1,3);
            GridPane.setConstraints(l_c5, 0, 4);
            GridPane.setConstraints(tf_c5, 1, 4);
            GridPane.setConstraints(b_c1, 1, 5);

            grid_c.getChildren().addAll(l_c1, tf_c1, l_c2, tf_c2,l_c3, tf_c3, l_c4, choiceBox, l_c5, tf_c5,b_c1);
            Scene sc_с = new Scene(grid_c,350, 200);
            stage.setScene(sc_с);

        });
        b_h.setOnAction(e->{

            GridPane grid_c = new GridPane();
            grid_c.setPadding(new Insets(30,30, 30, 30));
            grid_c.setVgap(15);
            grid_c.setHgap(15);
            Label l_h1 = new Label("Enter number of contract");
            Label l_h2 = new Label("Enter area");
            Label l_h3 = new Label("Enter house price");
            Label l_h4 = new Label("Enter term of contract");

            GridPane.setConstraints(l_h1, 0, 0);
            GridPane.setConstraints(tf_h1, 1, 0);
            GridPane.setConstraints(l_h2, 0, 1);
            GridPane.setConstraints(tf_h2, 1, 1);
            GridPane.setConstraints(l_h3, 0, 2);
            GridPane.setConstraints(tf_h3, 1, 2);
            GridPane.setConstraints(l_h4, 0, 3);
            GridPane.setConstraints(tf_h4, 1, 3);

            GridPane.setConstraints(b_h1, 1, 5);

            grid_c.getChildren().addAll(l_h1, tf_h1, l_h2, tf_h2,l_h3, tf_h3,l_h4, tf_h4, b_h1);
            Scene sc_с = new Scene(grid_c,350, 200);
            stage.setScene(sc_с);
        });

        b_ok.setOnAction(e->{
            stage.close();
        });


        Scene sc_main = new Scene(layout, 350,200);

        b_p1.setOnAction(e->{
            int number,age, health,termOfContract;
            number = CheckInput(tf_p1.getText());
            age = CheckInput(tf_p2.getText());
            health = CheckInput(tf_p3.getText());
            termOfContract =CheckInput(tf_p4.getText());
            if(number!=0 && age != 0 && health != 0 && termOfContract!=0){
                newins = new Life(number,age, health,termOfContract);
                insurances.add(newins);
                stage.setScene(sc_main);
                stage.show();
            }
        });

        b_c1.setOnAction(e->{
            String type_of_car;
            int number,motor_volume, price,termOfContract;
            number = CheckInput(tf_c1.getText());
            price = CheckInput(tf_c2.getText());
            motor_volume = CheckInput(tf_c3.getText());
            type_of_car = choiceBox.getValue();
            termOfContract = CheckInput(tf_c5.getText());
            if(number!=0 && motor_volume != 0 && price != 0 && termOfContract!=0 ) {
                newins = new Vehicle(number,type_of_car, motor_volume, price,termOfContract);
                insurances.add(newins);
                stage.setScene(sc_main);
                stage.show();
            }
        });

        b_h1.setOnAction(e->{

            int number,area, price, termOfContract;
            number = CheckInput(tf_h1.getText());
            area = CheckInput(tf_h2.getText());
            price =CheckInput(tf_h3.getText());
            termOfContract = CheckInput(tf_h4.getText());
            if(number!=0 && area != 0 && price != 0 && termOfContract!=0) {
                newins = new House(number,area, price,termOfContract);
                insurances.add(newins);
                stage.setScene(sc_main);
                stage.show();
            }
        });
        stage.setScene(sc_main);
        stage.showAndWait();
    }

    private static int CheckInput(String text){
        Stage st = new Stage();
        Button b_ok_ex = new Button("OK");;
        b_ok_ex.setOnAction(e -> st.close());

        try{
            int numb = Integer.parseInt(text);
            return numb;
        }catch (NumberFormatException ex){

            VBox vb = new VBox();
            vb.setPadding(new Insets(10));
            vb.setAlignment(Pos.CENTER);
            vb.setSpacing(10);
            Label l_ex = new Label(text + " is not a number");
            vb.getChildren().addAll(l_ex, b_ok_ex);

            Scene sc_ex = new Scene(vb,200, 100);
            st.setScene(sc_ex);
            st.showAndWait();

            return 0;
        }

    }
}