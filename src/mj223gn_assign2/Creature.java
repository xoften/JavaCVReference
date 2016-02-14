package mj223gn_assign2;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * Creature class where we extend imageview and sets an image to it.
 * we also have the method to check i creature got hit.
 * Created by Michael Johansson(mj223gn) on 2016-02-11.
 */
public class Creature extends ImageView {

    private boolean hit = false;

    public Creature() {

        setImage(new Image(getClass().getResourceAsStream("shark.png")));
    }
    public boolean creatureGotHit() {

        //if this creature is hit change boolean value to true.
        this.setOnMouseClicked(e -> {
            hit = true;
        });
        boolean returnHit = hit;
        hit = false;
        return returnHit;
    }
}
