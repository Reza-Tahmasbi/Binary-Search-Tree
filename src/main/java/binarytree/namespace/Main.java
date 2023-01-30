package binarytree.namespace;
/*
   Binary Search Tree, Data Structure Project
   Java OpenJDK version 17.0.2
   UI implemented by javafx
   Created by REZA TAHMASBI BIRGANI
   2023/01/01
*/

import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.ImageCursor;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Screen;
import javafx.stage.Stage;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Main extends Application {
    public static ArrayList<BinaryTree> binaryTreeArrayList = new ArrayList<>(); // TREES ARE STORED RIGHT HERE!
    public static Group motionRoot = new Group(); // ALL THE MOTIONS ARE ADDED ON THIS ROOT
    public static Group root = new Group(); // MAIN ROOT
    public static Group rootTrees = new Group(); // TREE IS SHOWN ON THIS ROOT
    public static Path path = Paths.get("src"); // INCLUDES THE PATH OF SRC FOLDER
    public static TextArea textArea = new TextArea("Message here"); // MESSAGE BOX
    public static String globString = ""; // A GLOBAL STRING VARIABLE TO STORE ALL MESSAGES
    static Rectangle2D screenBounds = Screen.getPrimary().getBounds(); // RETURNS WITH AND HEIGHT OF SCREEN
    public static double screenWidth = screenBounds.getWidth(); // SCREEN-WIDTH
    public static double screenHeight = screenBounds.getHeight(); // SCREEN-HEIGHT
    public static VBox menuVBox = new VBox(13); // INCLUDES ALL THE TEXT-FIELDS, LABELS, COMBO-BOXES, BUTTONS
    public static String font = "Harrington"; // FONT
    public static Color textColor = Color.rgb(35, 21, 130); // COLOR

    @Override
    public void start(Stage stage) {
        // SET THE SCENE
        Scene scene = new Scene(motionRoot, screenWidth - 10, screenHeight - 30);
        stage.setTitle("Binary Tree");
        stage.setScene(scene);
        stage.setResizable(false);
        // MENU POSITION
        menuVBox.setTranslateX(60);
        menuVBox.setTranslateY(7);

        //BACKGROUND IMAGE
        Image img = new Image(path.toAbsolutePath() + "\\BgImage003.png");
        ImageView imgView = new ImageView(img);
        imgView.setFitWidth(screenWidth - 10);
        imgView.setFitHeight(screenHeight - 30);
        motionRoot.getChildren().add(imgView);
        motionRoot.getChildren().add(root);

        // MOUSE POINTER CURSOR
        Image cursorImg = new Image(path.toAbsolutePath() + "\\pointer.png");
        scene.setCursor(new ImageCursor(cursorImg));

        // MOUSE TEXTFIELD CURSOR
        Image cursorImg2 = new Image(path.toAbsolutePath() + "\\text.png");
        textArea.setCursor(new ImageCursor(cursorImg2));

        // ALL DRAW FUNCTIONS ARE CALLED HERE
        Header.drawHeader();
        DrawTree.drawBorders();
        DrawBox.drawBox(40, 20, 620);
        PanelInsertTree.drawInsertTreePanel();
        PanelInsertNode.drawInsertPanel();
        PanelCommandTraverse.drawCommandComboBox();
        PanelIdentical.drawIdenticalPanel();
        PanelSearch.drawSearchPanel();
        PanelMessage.drawMessagePanel(-305, 660);
        DrawTree.drawTreeShowBtn();
        DrawFog drawFog = new DrawFog(); // IDK WHY I WROTE IT LIKE THAT BUT, I DON'T WANNA CHANGE IT :)

//        scene.getStylesheets().add(path.toAbsolutePath() + "\\BtnStyling.css"); // CSS FILE

        root.getChildren().add(menuVBox);
        // STARTS THE METEOR RAIN MOTION(TIMELINE)
        DotMotion.dotRain();
        stage.show();
    }

    public static void main(String[] args) {
        // PLAYS THE BACKGROUND MUSIC
        File audioFile = new File(path.toAbsolutePath() + "\\Comp 1.wav");
        try {
            Clip clip = AudioSystem.getClip();
            AudioInputStream audioInput = AudioSystem.getAudioInputStream(audioFile);
            clip.open(audioInput);
            clip.start();
            clip.loop(Clip.LOOP_CONTINUOUSLY);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
        launch();
    }
}