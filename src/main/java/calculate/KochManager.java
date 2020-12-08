/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package calculate;

import java.util.ArrayList;
import fun3kochfractalfx.FUN3KochFractalFX;
import timeutil.TimeStamp;

/**
 *
 * @author Nico Kuijpers
 * Modified for FUN3 by Gertjan Schouten
 */
public class KochManager {
    
    private KochFractal koch;
    private ArrayList<Edge> edges;
    private FUN3KochFractalFX application;
    private TimeStamp tsCalc;
    private TimeStamp tsDraw;

    private int count = 0;

    KochTask leftKochTask;
    KochTask bottomKochTask;
    KochTask rightKochTask;

    Thread leftThread;
    Thread bottomThread;
    Thread rightThread;

    public KochManager(FUN3KochFractalFX application) {
        this.edges = new ArrayList<Edge>();
        this.koch = new KochFractal(this);
        this.application = application;
        this.tsCalc = new TimeStamp();
        this.tsDraw = new TimeStamp();
        this.count = 0;
    }
    
    public void changeLevel(int nxt) throws InterruptedException {
        edges.clear();
        //koch.setLevel(nxt);
        tsCalc.init();
        tsCalc.setBegin("Begin calculating");

        leftKochTask = new KochTask(KochEnum.LEFT, new KochFractal(this) , this, nxt);
        bottomKochTask = new KochTask(KochEnum.BOTTOM, new KochFractal(this),this, nxt);
        rightKochTask = new KochTask(KochEnum.RIGHT, new KochFractal(this),this, nxt);

        leftThread = new Thread(leftKochTask);
        bottomThread = new Thread(bottomKochTask);
        rightThread = new Thread(rightKochTask);

        leftThread.start();
        bottomThread.start();
        rightThread.start();

        //tsCalc.setEnd("End calculating");

        application.setTextNrEdges("" + koch.getNrOfEdges());
        application.setTextCalc(tsCalc.toString());


        leftThread.interrupt();
        bottomThread.interrupt();
        rightThread.interrupt();
    }
    
    public void drawEdges() {
        tsDraw.init();
        tsDraw.setBegin("Begin drawing");
        application.clearKochPanel();
        for (Edge e : edges) {
            application.drawEdge(e);
        }
        tsDraw.setEnd("End drawing");
        application.setTextDraw(tsDraw.toString());
    }
    
    public synchronized void addEdge(Edge e) {
        edges.add(e);
    }

    public synchronized void increaseCount(){
        count++;
        if(count == 3){

            edges.addAll(leftKochTask.getEdges());
            edges.addAll(bottomKochTask.getEdges());
            edges.addAll(rightKochTask.getEdges());

            tsCalc.setEnd("End calculating");
            application.requestDrawEdges();

            count = 0;
        }
    }
}
