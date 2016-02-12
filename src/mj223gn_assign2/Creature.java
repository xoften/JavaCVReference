package mj223gn_assign2;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * Created by Michael Johansson(mj223gn) on 2016-02-11.
 */
public class Creature extends ImageView {

    private boolean hit = false;

    public Creature() {

        setImage(new Image(getClass().getResourceAsStream("shark.png")));
    }
    public boolean sharkGotHit() {

        this.setOnMouseClicked(e -> {
            hit = true;
        });
        boolean returnHit = hit;
        hit = false;
        return returnHit;
    }
}
