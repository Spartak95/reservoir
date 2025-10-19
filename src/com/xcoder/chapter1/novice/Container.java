package com.xcoder.chapter1.novice;

public class Container {
    Container[] g;
    int n;
    double x;

    public Container() {
        g = new Container[1000];
        g[0] = this;
        n = 1;
        x = 0;
    }

    public double getAmount() {
        return x;
    }

    public void addWater(double x) {
        double y = x / n;
        for (int i = 0; i < n; i++) {
            g[i].x = g[i].x + y;
        }
    }

    public void connectTo(Container c) {
        double z = (x * n + c.x * c.n) / (n + c.n);

        for (int i = 0; i < n; i++) { // for each container g[i] in the first group
            for (int j = 0; j < c.n; j++) {
                g[i].g[n + j] = c.g[j]; // add a second to a group of firsts
                c.g[j].g[c.n + i] = g[i]; // add first to a group of seconds
            }
        }

        n += c.n;

        for (int i = 0; i < n; i++) {
            g[i].n = n;
            g[i].x = z;
        }
    }
}
