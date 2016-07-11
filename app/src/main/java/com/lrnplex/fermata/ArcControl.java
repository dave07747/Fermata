package com.lrnplex.fermata;

import android.util.Log;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

/**
 * Created by David on 7/8/2016.
 */
public class ArcControl {
    public List<Arc> arcs = new ArrayList<Arc>();
    private Random random;
    private int chooser = 0;

    public ArcControl(){
        random = new Random();
        arcs.add(new Arc(10, random.nextInt(10),  60 + random.nextInt(10), 70, 25, 130, chooser));                               //(7 - random.nextInt(2))
        incChooser();
        arcs.add(new Arc(90, random.nextInt(10), 60+ random.nextInt(10), 70, 25, 130,chooser)); //(70+ random.nextInt(10))
        incChooser();
        arcs.add(new Arc(175, random.nextInt(10), 60+ random.nextInt(10), 70, 25, 130, chooser)); //(100+ random.nextInt(10))
        incChooser();
    }

    public void addArc(){
        arcs.add(new Arc(165+ random.nextInt(20), 10+ random.nextInt(10),  60+ random.nextInt(30), 70, 25, 130, chooser));
        incChooser();
        //Log.d("Arcs", "addArc: Added arc: " + arcs.size());
    }
    public boolean checkLastArc(){
        int len = arcs.size();
        //Log.d("arcs", "checkArc: " + arcs.size());
        if(len < 3)
            return true;
        return false;
    }

    public void checkArc(){
        Iterator<Arc> iterator = arcs.iterator();
        while(iterator.hasNext()){
            Arc arc = iterator.next();
            if(arc.getX() < -100) {
                iterator.remove();
            }
        }
    }

    public int ballCheck(){
        Iterator<Arc> iterator = arcs.iterator();
        while(iterator.hasNext()){
            Arc arc = iterator.next();
            if(arc.getX() >= 200 && arc.getX () <= 200 + arc.getWidth()) {
                Log.d("Arc get x", "ballCheck: " + arc.getY());
                return (int)arc.getY();
            }
        }
        return 840;
    }

    public void moveArc(){
        Iterator<Arc> iterator = arcs.iterator();
        while(iterator.hasNext()){
            Arc arc = iterator.next();
            arc.moveArc();
            arc.setColor();
        }
    }

    private void incChooser(){
        chooser++;
        if(chooser == 3)
            chooser = 0;
    }
}
