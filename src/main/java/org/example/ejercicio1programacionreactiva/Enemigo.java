package org.example.ejercicio1programacionreactiva;

import javafx.collections.ListChangeListener;

public class Enemigo implements ListChangeListener<String> {

    @Override
    public void onChanged(Change<? extends String> change) {
        while (change.next()){
            if (change.wasAdded()){
                System.out.println("Hola");
            } else if (change.wasRemoved()) {
                System.out.println("Adios");
            }
        }
    }
}
