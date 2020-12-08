package calculate;


import javafx.application.Application;
import javafx.concurrent.Task;

import java.util.ArrayList;

public class KochTask extends Task implements Runnable {

    private KochFractal kochFractal;
    private KochEnum kochEnum;
    private KochManager kochManager;
    private ArrayList<Edge> edges;
    private int nxt;

    public KochTask(KochEnum kochEnum, KochFractal fractal, KochManager kochManager, int nxt) {
        this.kochFractal = fractal;
        this.kochEnum = kochEnum;
        this.kochManager = kochManager;
        this.edges = new ArrayList<>();
        this.nxt = nxt;
    }

    public ArrayList<Edge> getEdges() {
        return edges;
    }
    public void setEdges(ArrayList<Edge> edges) {
        this.edges = edges;
    }

    @Override
    public void run() {

        switch (kochEnum){
            case LEFT:
                kochFractal.setLevel(nxt);
                kochFractal.generateLeftEdge();
            break;
            case BOTTOM:
                kochFractal.setLevel(nxt);
                kochFractal.generateBottomEdge();
            break;
            case RIGHT:
                kochFractal.setLevel(nxt);
                kochFractal.generateRightEdge();
            break;
        }
        edges = kochFractal.getEdges();
        kochManager.increaseCount();

    }

    @Override
    protected Object call() throws Exception {
        return null;
    }
}
