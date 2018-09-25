package com.aaquib.gameoflife.model;

public class Cell {

    public enum State {
        ALIVE, DEAD
    }

    private int row;
    private int column;
    private State state;

    public Cell(int row, int column, State state) {
        this.row = row;
        this.column = column;
        this.state = state;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
}
