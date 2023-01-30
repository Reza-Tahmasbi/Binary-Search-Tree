package binarytree.namespace;

import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.ImageCursor;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.effect.Glow;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

import static binarytree.namespace.BinaryTree.getTreeHeight;
import static binarytree.namespace.BinaryTree.getTreeRootFromComboBox;
import static binarytree.namespace.Main.*;

public class DrawTree extends StackPane {
    private static final File audioFile = new File(path.toAbsolutePath() + "\\click2.wav"); // Line captured audio
    public static final Button drawTreeButton = new Button(" Show ");
    public static ScrollPane scroll = new ScrollPane();
    public static Rectangle surface = new Rectangle(400, 20, 1500, 1000);

    public static void drawTreeShowBtn() {
        drawTreeButton.setOnAction(event -> {
            int pixel = 200;
            // COULD BE BETTER...
            switch (getTreeHeight(getTreeRootFromComboBox())) {
                case 1 -> pixel += 60;
                case 2 -> pixel += 65;
                case 3 -> pixel += 70;
                case 4 -> pixel += 75;
                case 5 -> pixel += 80;
                case 6 -> pixel += 85;
                case 7 -> pixel += 90;
                case 8 -> pixel += 95;
                case 9 -> pixel += 100;
                case 10 -> pixel += 105;
                case 11 -> pixel += 106;
                case 12 -> pixel += 107;
                case 13 -> pixel += 108;
                case 14 -> pixel += 109;
                case 15 -> pixel += 110;
                default -> pixel += 200;
            }
            menuVBox.getChildren().remove(rootTrees);
            rootTrees.getChildren().clear();
            rootTrees = new Group();
            drawNode(1150, 90, 1150, 90, getTreeRootFromComboBox(), 25, 18, pixel);
            scroll.setContent(rootTrees);
            try {
                // PLAYS THE AUDIO
                Clip clip = AudioSystem.getClip();
                AudioInputStream audioInput = AudioSystem.getAudioInputStream(audioFile);
                clip.open(audioInput);
                clip.start();
                clip.loop(0);
            } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
                e.printStackTrace();
            }
        });
        drawTreeButton.setTranslateX(185);
        drawTreeButton.setTranslateY(144);
        root.getChildren().add(drawTreeButton);
    }

    // DRAWS THE SCROLL PANE
    public static void drawBorders() {
        surface.setFill(Color.rgb(84, 77, 94));
        DropShadow ds1 = new DropShadow();
        ds1.setOffsetY(1);
        ds1.setOffsetX(-1);
        ds1.setColor(Color.BLACK);
        surface.setEffect(new GaussianBlur(2));
        scroll.setPrefSize(1500, 1000);
        surface.setStroke(Color.BLACK);
        surface.setStrokeWidth(1);
        surface.setCache(true);
        surface.setOpacity(0.4);
        surface.setArcWidth(15);
        surface.setArcHeight(15);
        scroll.setTranslateX(400);
        scroll.setTranslateY(20);
        scroll.setOpacity(0.85);
        surface.setEffect(ds1);
        scroll.setStyle("-fx-background : #344b8a");
        root.getChildren().add(scroll);
//        DropShadow ds1 = new DropShadow();
//        ds1.setOffsetY(1);
//        ds1.setOffsetX(-1);
//        ds1.setColor(Color.BLACK);
//        scroll.setEffect(new GaussianBlur(2));
//        scroll.setEffect(ds1);
//        scroll.setCache(true);
    }

    // DRAWS THE HOLE TREE BY GETTING ROOT
    public static void drawNode(double x1, double y1, double x, double y, Node_kuchulu temp, int radius, double fontSize, int pixel) {
        // LINE
        Line line = new Line(x1, y1 + 20, x, y);
        line.setStrokeWidth(1.5);
        line.setStroke(Color.WHITE);
        line.setOpacity(0.9);
        rootTrees.getChildren().add(line);
        // CIRCLE
        Circle circle = new Circle(x, y, radius, Color.rgb(61, 56, 94));
        circle.setStroke(Color.WHITE);
        circle.setCursor(Cursor.HAND);
        circle.setOpacity(0.96);
        circle.setStrokeWidth(1);
        rootTrees.getChildren().add(circle);
        // TEXT
        Text text = new Text(x - 10, y + 3, String.valueOf(temp.data));
        text.setFont(Font.font("B Arabic Style Regular", fontSize));
        text.setFill(Color.WHITE);
        text.setCursor(Cursor.HAND);
        rootTrees.getChildren().add(text);
        // TRANSITION CIRCLE
        Circle circle2 = new Circle(x, y, radius, Color.WHITE);
        circle2.setStroke(Color.WHITE);
        circle2.setCursor(Cursor.HAND);
        circle2.setOpacity(0.0);
        circle2.setStrokeWidth(1);
        Image cursorImg = new Image(path.toAbsolutePath() + "\\click2.png");
        circle2.setCursor(new ImageCursor(cursorImg));
        rootTrees.getChildren().add(circle2);
        circleTransition(circle, circle2);

        if (temp.left != null)
            drawNode(x, y, x - pixel, y + 130, temp.left, radius, fontSize - 0.4, pixel / 2);
        if (temp.right != null)
            drawNode(x, y, x + pixel, y + 130, temp.right, radius, fontSize - 0.4, pixel / 2);

    }

    // A LITTLE TRANSITION ON NODES' MOUSE HOVER
    public static void circleTransition(Circle circle, Circle circle2) {
        // MOUSE ENTERED TRANSITION
//        ScaleTransition trans = new ScaleTransition(Duration.seconds(0.3), circle);
//        trans.setFromX(1.0);
//        trans.setToX(1.00);
//        trans.setFromY(1.0);
//        trans.setToY(1.00);
//        trans.setAutoReverse(true);
//        trans.play();
        // MOUSE EXITED TRANSITION
//        ScaleTransition transBackward = new ScaleTransition(Duration.seconds(0.3), circle);
//        transBackward.setFromX(1.01);
//        transBackward.setToX(1);
//        transBackward.setFromY(1.01);
//        transBackward.setToY(1);
//        transBackward.setAutoReverse(true);
//        transBackward.play();
        // SET UP A SCALE TRANSITION FOR THE CIRCLE
        DropShadow drop = new DropShadow(10, Color.WHITE);
        drop.setInput(new Glow());
        circle2.setOnMouseEntered(event -> {
            circle.setEffect(drop);
//            trans.play();
        });
        circle2.setOnMouseExited(event -> {
            circle.setEffect(null);
//            transBackward.play();
        });

    }
}
