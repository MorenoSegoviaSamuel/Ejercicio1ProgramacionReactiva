package org.example.ejercicio1programacionreactiva;

public class Jugador extends Coordenadas {
    public Jugador(int x, int y) {
        super(x, y);
    }

    @Override
    public String toString() {
        return "JUGADOR (" + this.getX() + "," + this.getY() + ")";
    }

}
