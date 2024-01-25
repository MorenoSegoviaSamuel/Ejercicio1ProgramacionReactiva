package org.example.ejercicio1programacionreactiva;

import javafx.collections.ListChangeListener;


/*
-Clase enemigo que extiende de la clase coordenadas para poder utilizar el constructor de coordeanas.
-Implementa un Listener de Coordenadas. Cuando la clase coordenanas realiza algun cambio lo
escucha la esta clase.
 */
public class Enemigo extends Coordenadas implements ListChangeListener<Coordenadas> {
    public Enemigo(int x, int y) {
        super(x, y);
    }

    /*
     Metodo que se ejecuta cuando la lista de movimientos del jugador cambia.
     -Coordenadas player : Obtiene la posición del jugador (el último movimiento añadido a la lista).
     -distancia = this.getDistance(player); : Calcula la distancia entre el enemigo y el jugador.
     -m : Contador de movimientos que puede realizar el enemigo.
     */
    @Override
    public void onChanged(Change<? extends Coordenadas> change) {
        while (change.next()) {
            Coordenadas player = change.getAddedSubList().get(0);
            int distancia = this.getDistance(player);
            int m = 0;

            while (m < 2) {

                /*
                En el bucle se realizan 4 comprobaciones. Todas son iguales asi que explicaré solamente la primera
                -this.sumar1CoordX(1) : Se mueve una posición a la derecha.
                -Se calcula la distancia del enemigo y el jugador, si se ha podido acercar, se añade un movimiento a m,
                de lo contrario, si se a alejado se deshace el movimiento.
                -Esto se repite 3 veces más para los movimientos hacia arriba, abajo e izquierda.
                -Al salir del bucle imprime por pantalla las coordenadas del enemigo, utilizando el metodo ToString.
                 */

                this.sumar1CoordX(1);
                if (this.getDistance(player) >= distancia) {
                    this.sumar1CoordX(-1);
                } else {
                    m++;
                }

                this.sumar1CoordX(-1);
                if (this.getDistance(player) >= distancia) {
                    this.sumar1CoordX(1);
                } else {
                    m++;
                }

                this.sumar1CoordY(1);
                if (this.getDistance(player) >= distancia) {
                    this.sumar1CoordY(-1);
                } else {
                    m++;
                }

                this.sumar1CoordY(-1);
                if (this.getDistance(player) >= distancia) {
                    this.sumar1CoordY(1);
                } else {
                    m++;
                }
            }
            System.out.println(this);
        }
    }

    @Override
    public String toString() {
        return "ENEMIGO (" + this.getX() + "," + this.getY() + ")";
    }
}