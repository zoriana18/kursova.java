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
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.Modality;

import java.util.ArrayList;

public class Derivative {

    public static void createDerivative(ArrayList<Insurance> insurances) {
        Stage stage = new Stage();
        stage.setTitle("Derivative");
        stage.initModality(Modality.APPLICATION_MODAL);
        VBox vBox = new VBox(10);
        vBox.setPadding(new Insets(20));
        vBox.setAlignment(Pos.CENTER);

        Label l = new Label("Derivative is created!");

        Button b_show = new Button("      Show the list     ");
        Button b_sort = new Button("Sort by descending risk level");
        Button b_contribution = new Button("Calculate total contribution");
        Button b_find = new Button("Find by parameters ");
        b_sort.setPrefSize(200, 50);
        b_show.setPrefSize(200, 50);
        b_find.setPrefSize(200, 50);
        b_contribution.setPrefSize(200, 50);


        Button b_pr_ok = new Button(" OK ");
        Button b_sort_ok = new Button("OK");
        Stage st_pr = new Stage();
        Stage st_sort = new Stage();

        vBox.getChildren().addAll(l, b_show, b_find, b_contribution, b_sort);


        b_show.setOnAction(e->Show.show(insurances));

        b_sort.setOnAction(e -> {
            Sort(insurances);

            VBox vBox_sort = new VBox();
            vBox_sort.setSpacing(20);
            vBox_sort.setPadding(new Insets(18));
            vBox_sort.setAlignment(Pos.CENTER);

            Label l_sort = new Label("Insurances are sorted");

            vBox_sort.getChildren().addAll(l_sort, b_sort_ok);
            Scene sc_sort = new Scene(vBox_sort, 150, 100);
            st_sort.setScene(sc_sort);
            st_sort.showAndWait();
        });
        b_sort_ok.setOnAction(e2->st_sort.close());


        b_find.setOnAction(e ->{
            Stage stage_find = new Stage();
            stage_find.setTitle("Finding by parameters");
     //       stage_find.initModality(Modality.APPLICATION_MODAL);

            VBox vBox_find = new VBox();
            vBox_find.setSpacing(17);
            vBox_find.setPadding(new Insets(14));

            HBox hBox = new HBox();
            hBox.setSpacing(45);
            hBox.setAlignment(Pos.CENTER);

            Label l1 = new Label("Choose type of insurance:");
            l1.setPadding(new Insets(10));

            TextField tf_min_1 = new TextField();
            TextField tf_max_1 = new TextField();
            TextField tf_min_2 = new TextField();
            TextField tf_max_2 = new TextField();
            TextField tf_min_3 = new TextField();
            TextField tf_max_3 = new TextField();
            HBox hBox_1 = new HBox();
            HBox hBox_2 = new HBox();
            HBox hBox_3 = new HBox();
            hBox_1.getChildren().addAll(tf_min_1, tf_max_1);
            hBox_2.getChildren().addAll(tf_min_2, tf_max_2);
            hBox_3.getChildren().addAll(tf_min_3, tf_max_3);

            Button b_l = new Button("    Life   ");
            Button b_v = new Button("  Vehicle  ");
            Button b_h = new Button("    House  ");
            Button ok = new Button(" Find ");
            VBox vbok = new VBox();
            vbok.getChildren().add(ok);
            vbok.setAlignment(Pos.CENTER);

            hBox.getChildren().addAll(b_l, b_v, b_h);
            vBox_find.getChildren().addAll(l1, hBox);

            b_l.setOnAction(ev->{
                tf_min_1.setPromptText("min age");
                tf_max_1.setPromptText("max age");
                tf_min_2.setPromptText("min term");
                tf_max_2.setPromptText("max term");
                tf_min_3.setPromptText("min contribution");
                tf_max_3.setPromptText("max contribution");
                vBox_find.getChildren().addAll(hBox_1,hBox_2,hBox_3, vbok);
                ok.setOnAction(eok->{
                    FindL(insurances, Integer.parseInt(tf_min_1.getText()), Integer.parseInt(tf_max_1.getText()),Integer.parseInt(tf_min_2.getText()),Integer.parseInt(tf_max_2.getText()),Integer.parseInt(tf_min_3.getText()),Integer.parseInt(tf_max_3.getText()));
                    stage_find.close();
                });
            });

            b_v.setOnAction(ev->{
                tf_min_1.setPromptText("min motor volume");
                tf_max_1.setPromptText("max motor volume");
                tf_min_2.setPromptText("min price");
                tf_max_2.setPromptText("max price");
                tf_min_3.setPromptText("min term");
                tf_max_3.setPromptText("max term");
                vBox_find.getChildren().addAll(hBox_1,hBox_2,hBox_3, vbok);
                ok.setOnAction(eok->{
                    FindV(insurances, Integer.parseInt(tf_min_1.getText()), Integer.parseInt(tf_max_1.getText()),
                            Integer.parseInt(tf_min_2.getText()), Integer.parseInt(tf_max_2.getText()),Integer.parseInt(tf_min_3.getText()), Integer.parseInt(tf_max_3.getText()));
                    stage_find.close();
                });
            });

            b_h.setOnAction(ev->{
                tf_min_1.setPromptText("min area");
                tf_max_1.setPromptText("max area");
                tf_min_2.setPromptText("min price");
                tf_max_2.setPromptText("max price");
                tf_min_3.setPromptText("min term");
                tf_max_3.setPromptText("max term");
                vBox_find.getChildren().addAll(hBox_1, hBox_2,hBox_3 ,vbok);
                ok.setOnAction(eok->{
                    FindH(insurances, Integer.parseInt(tf_min_1.getText()), Integer.parseInt(tf_max_1.getText()),
                            Integer.parseInt(tf_min_2.getText()), Integer.parseInt(tf_max_2.getText()),Integer.parseInt(tf_min_3.getText()), Integer.parseInt(tf_max_3.getText()));
                    stage_find.close();
                });
            });

            Scene sc_sort = new Scene(vBox_find, 350, 300);
            stage_find.setScene(sc_sort);
            stage_find.showAndWait();
        });

        b_contribution.setOnAction(e ->{
            int tot_c = CalculateTotalContribution(insurances);

            VBox vBox_pr = new VBox();
            vBox_pr.setSpacing(20);
            vBox_pr.setPadding(new Insets(18));
            vBox_pr.setAlignment(Pos.CENTER);

            Label l_pr = new Label("The total contribution is " + tot_c);

            vBox_pr.getChildren().addAll(l_pr, b_pr_ok);
            Scene sc_tot_pr = new Scene(vBox_pr, 300, 250);
            st_pr.setScene(sc_tot_pr);
            st_pr.showAndWait();
        });
        b_pr_ok.setOnAction(e -> st_pr.close());

        Scene sc = new Scene(vBox, 350, 300);
        stage.setScene(sc);
        stage.showAndWait();
    }

    private static int CalculateTotalContribution(ArrayList<Insurance> ins){
        int total_contribution = 0;
        for (Insurance insurance : ins) {
            total_contribution += insurance.getContribution();
        }
       return total_contribution;
    }

    private static void Sort(ArrayList<Insurance> ins){
        for (int i = 0; i < ins.size()-1; i++)
            for (int j = 0; j < ins.size()-i-1; j++) {
                if (ins.get(j).getRiskLevel() < ins.get(j + 1).getRiskLevel()) {
                    ins.add(j, ins.get(j+1));
                    ins.remove(j+2);
                }
            }
    }


    private static void FindL(ArrayList<Insurance> ins, int min_age, int max_age,int min_term, int max_term, int min_contribution,int max_contribution) {
        ArrayList<Insurance> found = new ArrayList<>();
                for (Insurance insurance : ins)
                    if(insurance instanceof Life &&
                            ((Life) insurance).getAge() > min_age &&
                            ((Life) insurance).getAge() < max_age &&
                            ((Life) insurance).getTermOfContract() >min_term &&
                            ((Life) insurance).getTermOfContract()<max_term &&
                            ((Life) insurance).getContribution() > min_contribution &&
                            ((Life) insurance).getContribution()<max_contribution
                    )
                        found.add(insurance);
                Show.show(found);
    }

    private static void FindV(ArrayList<Insurance> ins, int min_mvol, int max_mvol, int min_price, int max_price,int min_term,int max_term) {
        ArrayList<Insurance> found = new ArrayList<>();
                for (Insurance insurance : ins)
                    if(insurance instanceof Vehicle &&
                            ((Vehicle) insurance).getMotorVolume() > min_mvol &&
                            ((Vehicle) insurance).getMotorVolume() < max_mvol &&
                            insurance.getContribution() > min_price && insurance.getContribution() < max_price &&
                            ((Vehicle) insurance).getTermOfContract() > min_term &&
                            ((Vehicle) insurance).getTermOfContract() < max_term
                    )
        found.add(insurance);
        Show.show(found);
    }

    private static void FindH(ArrayList<Insurance> ins, int min_area, int max_area, int min_price, int max_price,int min_term, int max_term) {
        ArrayList<Insurance> found = new ArrayList<>();
        for (Insurance insurance : ins)
                    if(insurance instanceof House &&
                            ((House) insurance).getArea() > min_area &&
                            ((House) insurance).getArea() < max_area &&
                            ((House) insurance).getHousePrice() > min_price &&
                            ((House) insurance).getHousePrice() < max_price &&
                            ((House) insurance).getTermOfContract() > min_term &&
                            ((House) insurance).getTermOfContract() < max_term)
        found.add(insurance);
        Show.show(found);

    }
}

