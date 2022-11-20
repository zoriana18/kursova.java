module com.example.kursova {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires eu.hansolo.tilesfx;
    requires javafx.graphics;
    requires java.sql;
    requires org.junit.jupiter.api;


    opens com.example.kursova.insurances to javafx.base;

    opens com.example.kursova to javafx.fxml;
    exports com.example.kursova;
}