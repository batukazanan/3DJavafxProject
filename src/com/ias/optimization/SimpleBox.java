package com.ias.optimization;

public class SimpleBox {

    int width, height, depth;

    int x, y, z;


    public SimpleBox(int w, int h, int d) {
        this(w, h, d, 0, 0, 0);
    }

    public SimpleBox(int w, int h, int d, int x, int y, int z) {
        this.width = w;
        this.height = h;
        this.depth = d;
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public double getDepth() {
        return depth;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getZ() {
        return z;
    }

    public void setZ(int z) {
        this.z = z;
    }
}


