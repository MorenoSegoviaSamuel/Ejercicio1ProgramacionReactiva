package org.example.ejercicio1programacionreactiva;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Main {

    public static void main(String[] args) {
        ObservableList<String> jugador = FXCollections.observableArrayList();
        Enemigo enemy = new Enemigo();
        jugador.addListener(enemy);

    }
}
