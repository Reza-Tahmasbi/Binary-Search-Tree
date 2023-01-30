package binarytree.namespace;

import javafx.animation.FadeTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.TranslateTransition;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.util.Duration;

import static binarytree.namespace.Main.*;

// THE CLASS WHERE MESSAGE PANEL IS DRAWN
public class PanelMessage {
    private static final VBox messageVBox = new VBox(10);

    public static void drawMessagePanel(int x, int y) {

        messageVBox.setTranslateY(y);
        messageVBox.setTranslateX(x);
        textArea.setFont(Font.font("B Arabic Style Regular", 23));
        textArea.setMaxWidth(305);
        textArea.setMaxHeight(100);
        textArea.setOpacity(0.6);
        textArea.setEditable(false);
        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setContent(textArea);
        scrollPane.setFitToWidth(true);
        scrollPane.setMaxWidth(200);
        scrollPane.setMaxHeight(100);
        messageVBox.getChildren().addAll(textArea);
        root.getChildren().add(messageVBox);
    }

    public static void messageBoxMotion() {
        TranslateTransition tIn = new TranslateTransition(Duration.seconds(0.3), messageVBox);
        tIn.setToX(45);

        TranslateTransition tBack = new TranslateTransition(Duration.seconds(0.3), messageVBox);
        tBack.setToX(-305);

        FadeTransition ftStay = new FadeTransition(Duration.seconds(1.8));
        ftStay.setFromValue(0.6);
        ftStay.setToValue(0.6);
        ftStay.setAutoReverse(true);

        SequentialTransition seqT2 = new SequentialTransition(messageVBox, tIn, ftStay, tBack);
        seqT2.setCycleCount(1);
        seqT2.play();
    }
}
