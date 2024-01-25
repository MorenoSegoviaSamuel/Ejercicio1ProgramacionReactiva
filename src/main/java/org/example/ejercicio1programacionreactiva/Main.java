package org.example.ejercicio1programacionreactiva;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        /*
        -sc = Scanner para que el usuario pueda introducir los movimientos que vaya a realizar.
        -contadorPasos = Un contador para que al finalizar el juego pueda saberse el número de pasos
        que ha realizado el usuario sin que el enemigo le pille.
        -jugador = Objeto Jugador que representa al usuario. Empieza en una posición aleatoria de entre 0 y 29.
        -playerMoves = Una lista observable que contiene los movimientos del jugador.
        -enemigoA = Objeto Enemigo que representa un enemigo. Se declaran mediante el metodo crearEnemigo.
         */
        Scanner sc = new Scanner(System.in);
        int contadorPasos = 0;
        Jugador jugador;
        jugador = new Jugador(new Random().nextInt(30), new Random().nextInt(30));
        ObservableList<Coordenadas> playerMoves = FXCollections.observableArrayList();
        Enemigo enemigoA = crearEnemigo(jugador, playerMoves);

        /*
        Entra en un bucle While donde se compara la distancia entre el jugador y el enemigo, si es diferente de
        0 se ejecuta el bucle. Después se le pide al usuario que introduzca un movimiento y una vez introducido,
        mediante un switch se clasifica en W,D,S,A. Cada vez que el jugador se mueve se imprime su posición y se añade
        a la lista de movimientos del jugar (PlayerMoves)
         */
        System.out.println("Muevete usando W A D S");
        while (jugador.getDistance(enemigoA) != 0) {

            char movement = Character.toUpperCase(sc.next().charAt(0));
            switch (movement) {
                case 'W' -> {
                    jugador.sumar1CoordY(1);
                    System.out.println(jugador);
                    playerMoves.add(jugador);
                }
                case 'D' -> {
                    jugador.sumar1CoordX(1);
                    System.out.println(jugador);
                    playerMoves.add(jugador);
                }
                case 'S' -> {
                    jugador.sumar1CoordY(-1);
                    System.out.println(jugador);
                    playerMoves.add(jugador);
                }
                case 'A' -> {
                    jugador.sumar1CoordX(-1);
                    System.out.println(jugador);
                    playerMoves.add(jugador);
                }

                //Cuando añado una opción default el programa no finaliza bien. Pasa lo mismo si introduzco
                //más de un enemigo.

                //default -> {
                //    System.out.println("Has introducido una dirreción no valida.");
                //    System.out.println("Muevete usando W A D S");
                //}
            }

            /*
            Cuando el jugador y el enemigo estan en las mismas coordenadas, se acaba el juego imprimiendo
            un Game Over y los pasos realizados en total.
             */
            contadorPasos++;
            if (jugador.getDistance(enemigoA) == 0) {
                System.out.println(" GAME OVER! Pasos realizados en total: " + contadorPasos);
                return;
            }
        }
    }


    /*
    Metodo utilizado para crear un enemigo. Este metodo solicita un objeto Jugador y una lista
    observable que contiene los movimientos del jugador. El enemigo es creado en una posición aleatoria
    de entre 0 y 29. Si la distancia del jugador y el enemigo es menor a 5 se repite. Una vez salido del do-while
    se añade al enemigo a la lista de movimientos del jugador para que pueda reaccionar a sus movimientos. Y finalmnete
    devuelve un objeto enemigo
     */
    private static Enemigo crearEnemigo(Jugador jugador, ObservableList<Coordenadas> playerMoves) {
        Enemigo enemigo;
        do {
            enemigo = new Enemigo(new Random().nextInt(30), new Random().nextInt(30));
        } while (jugador.getDistance(enemigo) < 5);
        playerMoves.addListener(enemigo);
        return enemigo;
    }
}

