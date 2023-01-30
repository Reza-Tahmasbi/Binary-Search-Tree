package binarytree.namespace;

import javafx.scene.effect.DropShadow;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import static binarytree.namespace.Main.root;
import static binarytree.namespace.Header.width;

// DRAWS THE BACKGROUND WHITE BOX
public class DrawBox {
    public static void drawBox(int x1, int y1, int y2) {
        Rectangle surface = new Rectangle(x1, y1, 40 + width, y2);
        surface.setFill(Color.rgb(61, 56, 94));
        root.getChildren().add(surface);
        DropShadow ds1 = new DropShadow();
        ds1.setOffsetY(1);
        ds1.setOffsetX(-1);
        ds1.setColor(Color.BLACK);
        surface.setStrokeWidth(1);
        surface.setStroke(Color.rgb(61, 56, 94));
        surface.setEffect(new GaussianBlur(2));
        surface.setEffect(ds1);
        surface.setCache(true);
        surface.setOpacity(0.3);
        surface.setArcWidth(15);
        surface.setArcHeight(15);
        surface.setFill(Color.WHITE);
    }
}
