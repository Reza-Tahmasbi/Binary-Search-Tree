package binarytree.namespace;

import java.util.Random;

import javafx.animation.AnimationTimer;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

// THIS  THE FOG(CLOUD) CLASS
public class Fog extends Parent {
    // PROPERTIES
    private final int width;
    private final int height;
    private final Pane fog;
    private final Random RNG = new Random();

    // CONSTRUCTOR
    public Fog(int width, int height) {
        this.width = width;
        this.height = height;
        this.fog = new Pane();
        Rectangle rect = new Rectangle(0, 0, width, height);
        rect.setFill(Color.rgb(0xe0, 0xe0, 0xe0));
        fog.getChildren().add(rect);
        for (int i = 0; i < 50; i++) {
            fog.getChildren().add(createFogElement());
        }

        fog.setEffect(new GaussianBlur((width + height) / 2.5));

    }

    private Circle createFogElement() {
        Circle circle = new Circle(RNG.nextInt(width - 50) + 25, RNG.nextInt(height - 50) + 25, 15 + RNG.nextInt(50));
        int shade = 0xcf + RNG.nextInt(0x20);
        circle.setFill(Color.rgb(shade, shade, shade));
        AnimationTimer anim = new AnimationTimer() {

            double xVel = RNG.nextDouble() * 40 - 20;
            double yVel = RNG.nextDouble() * 40 - 20;
            long lastUpdate = 0;

            @Override
            public void handle(long now) {
                if (lastUpdate > 0) {
                    double elapsedSeconds = (now - lastUpdate) / 1_000_000_000.0;
                    double x = circle.getCenterX();
                    double y = circle.getCenterY();
                    if (x + elapsedSeconds * xVel > width || x + elapsedSeconds * xVel < 0) {
                        xVel = -xVel;
                    }
                    if (y + elapsedSeconds * yVel > height || y + elapsedSeconds * yVel < 0) {
                        yVel = -yVel;
                    }
                    circle.setCenterX(x + elapsedSeconds * xVel);
                    circle.setCenterY(y + elapsedSeconds * yVel);
                }
                lastUpdate = now;
            }

        };
        anim.start();
        return circle;
    }

    public Node getView() {
        return fog;
    }
}