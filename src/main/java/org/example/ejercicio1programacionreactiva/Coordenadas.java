package org.example.ejercicio1programacionreactiva;

public class Coordenadas {
    private int x;
    private int y;

    public Coordenadas(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void sumar1CoordX(int x) {
        this.x += x;
    }

    public void sumar1CoordY(int y) {
        this.y += y;
    }

    public int getDistance(Coordenadas position) {
        return Math.abs(position.x - x) + Math.abs(position.y-y);
    }

}
