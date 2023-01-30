package binarytree.namespace;

import javafx.geometry.Insets;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import static binarytree.namespace.Main.*;

// "BINARY TREE" HEADER TEXT
public class Header extends StackPane {
    public static int width = 270;

    public static void drawHeader() {
        HBox hBox = new HBox(10);
        hBox.setTranslateX(-13);
        hBox.setTranslateY(4);
        Text text = new Text("Binary Search Tree");
        text.setFont(Font.font(font, 29));
        text.setFill(textColor);
        hBox.setPadding(new Insets(30, 5, 30, 20));
        hBox.getChildren().add(text);
        menuVBox.getChildren().add(hBox);
    }
}
