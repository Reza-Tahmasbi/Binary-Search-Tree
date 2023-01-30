package binarytree.namespace;

import javafx.scene.Parent;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Lighting;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;

import static binarytree.namespace.Main.*;

// SNOW PIECE
public class DotComponent extends Parent {
    public DotComponent(double posX, double posY) {
        int shadow = 19;
        Image img = new Image(path.toAbsolutePath() + "\\snow.png");
        ImageView imgView = new ImageView(img);
        imgView.setFitWidth(30);
        imgView.setFitHeight(30);
        imgView.setTranslateY(posY);
        imgView.setTranslateX(posX);

        DropShadow drop = new DropShadow(shadow, Color.WHITE);
        drop.setInput(new Lighting());
        imgView.setEffect(drop);
        getChildren().add(imgView);
    }
}
