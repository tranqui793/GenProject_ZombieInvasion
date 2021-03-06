package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;

public class RectangleZombi extends Rectangle {

    public Texture zombiImage;

    private static int nextId = 0;
    private int id;
    private int nbShot = 0;
    public int nbRebound=0;
    public float dx = MathUtils.random(0, 2) - 1;
    public float dy = MathUtils.random(0, 2) - 1;


    public RectangleZombi() {
        super(MathUtils.random(0, 640- 30), MathUtils.random(0, 480 - 30), 30, 30);

        zombiImage= new Texture("core/src/resources/zombi1.png");

        id = nextId++;

        while (dx == 0 && dy == 0) {
            dx = MathUtils.random(0, 2) - 1;
            dy = MathUtils.random(0, 2) - 1;
        }

    }

    public void updatePosition(){

    }

    public int getId() {
        return id;
    }

    public int getNbShot() {
        return nbShot;
    }

    public int getShot(){
        return ++nbShot;
    }

    public void move() {
        if (this.x < 0){
            this.dx *= -1;nbRebound++;
            this.zombiImage=new Texture("core/src/resources/zombi1.png");
        }
        if (this.x > 640 - 30) {
            this.dx *= -1;nbRebound++;
            this.zombiImage=new Texture("core/src/resources/zombi3.png");

        }
        if (this.y < 0){
            this.dy *= -1;nbRebound++;
            this.zombiImage=new Texture("core/src/resources/zombi4.png");}
        if (this.y > 480 - 30) {
            this.dy *= -1;nbRebound++;
            this.zombiImage=new Texture("core/src/resources/zombi2.png");
        }
    }

}
