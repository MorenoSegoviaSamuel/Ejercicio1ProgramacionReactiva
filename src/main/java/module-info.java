module org.example.ejercicio1programacionreactiva {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.ejercicio1programacionreactiva to javafx.fxml;
    exports org.example.ejercicio1programacionreactiva;
}