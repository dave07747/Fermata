package com.lrnplex.fermata;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

/**
 * Created by David on 7/8/2016.
 */
public class ArcControl {
    public List<Arc> arcs = new ArrayList<>();
    private Random random;
    private final int arcAmount = 3;

    double arcMove = 1.4;


    public ArcControl(){
        random = new Random();
        arcs.add(new Arc(10, 50 + random.nextInt(10), random.nextInt(arcAmount)));                               //(7 - random.nextInt(2))
        arcs.add(new Arc(90, 50 + random.nextInt(10),  random.nextInt(arcAmount))); //(70+ random.nextInt(10))
        arcs.add(new Arc(175, 50 + random.nextInt(10),  random.nextInt(arcAmount))); //(100+ random.nextInt(10))
    }

    // Adds an arc to arclist
    public void addArc(){
        int arcType =  random.nextInt(arcAmount) + 1;
        int waitDist = 0;
        switch (arcType){   //+40
            case 1:
                waitDist = 158 - 35;
            case 2:
                waitDist = 125 - 35;
            case 3:
                waitDist = 170 - 35;
            default:
                waitDist = 158 - 35;
        }
        arcs.add(new Arc(50 + waitDist, 50+ random.nextInt(10), arcType)); //+ random.nextInt(20)
        //Log.d("Arcs", "addArc: Added arc: " + arcs.size());
    }

    // Checks if there are less than three arcs on screen
    public boolean checkLastArc(){
        int len = arcs.size();
        //Log.d("arcs", "checkArc: " + arcs.size());
        return len < 3;
    }

    // Checks if arc is off screen, removes if yes
    public void checkArc(){
        Iterator<Arc> iterator = arcs.iterator();
        while(iterator.hasNext()){
            Arc arc = iterator.next();
            if(arc.getX() < -555) {
                iterator.remove();
            }
        }
    }


    /**
     * Checks the position the ball, returns y coordinate
     * @return the point of the arc at x = 200
     */
    public double ballCheck(){
        for (Arc arc : arcs) {
            if (arc.getX() <= 250 && arc.getX() >= 170 -arc.getLength()+35) { //&& arc.getX () <= 200 + arc.getWidth()) {
                //Log.d("Arc get x", "ballCheck: " + arc.getY());
                return  arc.getYPoint();
            }
        }
        return 840;
    }

    public boolean scoreArc(){
        for(Arc arc : arcs){
            if(arc.getX() <= 150 && !arc.getScore()){
                arc.setScore();
                return true;
            }
        }
        return false;
    }

    // Moves arcs over
    public void moveArc(){
        for (Arc arc : arcs) {
            arc.moveArc(arcMove);
            arc.iterator ++;
        }
    }
}
