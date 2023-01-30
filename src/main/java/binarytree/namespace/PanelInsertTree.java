package binarytree.namespace;

import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

import static binarytree.namespace.DrawTree.drawTreeButton;
import static binarytree.namespace.BtnStyle.BtnStyle;
import static binarytree.namespace.Main.*;
import static binarytree.namespace.PanelIdentical.comboBox2;

// THE CLASS WHERE TREE IS DRAWN
public class PanelInsertTree {
    private static final File audioFile = new File(path.toAbsolutePath() + "\\click.wav"); // Line captured audio
    //private static final File audioFile2 = new File(path.toAbsolutePath() + "\\heaven.wav"); // Line captured audio
    public static ComboBox<String> comboBox1 = new ComboBox<>();

    public static void drawInsertTreePanel() {
        VBox treePanelVBox = new VBox(9);
        HBox selectTreeHBox = new HBox(6);
        HBox createTreeHBox = new HBox(6);
        HBox removeTreeHBox = new HBox(6);
        // LABELS
        Text textTree = new Text("Trees' Panel:");
        textTree.setFill(textColor);
        textTree.setFont(Font.font(font, 17));
        Text removeCurrentTree = new Text("Remove Current Tree");
        removeCurrentTree.setFill(textColor);
        removeCurrentTree.setFont(Font.font(font, 17));
        TextField rootDataTextField = new TextField();
        rootDataTextField.setFont(Font.font("Drawing-Rainbow.ttf"));
        rootDataTextField.setMinWidth(100);
        rootDataTextField.setPrefWidth(60);
        rootDataTextField.setPromptText("root data");
        rootDataTextField.setCursor(Cursor.TEXT);
        // COMMAND-BTN
        Button createTreeBtn = new Button("Create");
        createTreeBtn.setOnMouseClicked(event -> {
            if (!rootDataTextField.getText().equals("")) {
                Node_kuchulu rootKuchulu = new Node_kuchulu(Integer.parseInt(rootDataTextField.getText()), 0);
                BinaryTree temp = new BinaryTree(rootKuchulu);
                binaryTreeArrayList.add(temp);
                comboBox1.setValue(temp.getName());
                comboBox2.setValue(temp.getName());
                comboBox2.getItems().add(temp.getName());
                drawTreeButton.fire();
                textArea.setText("Tree is created successfully");
            } else {
                textArea.setText("Root data is null");
            }
            try {
                // PLAYS THE CAPTURED AUDIO
                Clip clip = AudioSystem.getClip();
                AudioInputStream audioInput = AudioSystem.getAudioInputStream(audioFile);
                clip.open(audioInput);
                clip.start();
                clip.loop(0);
//                Clip clip2 = AudioSystem.getClip();
//                AudioInputStream audioInput2 = AudioSystem.getAudioInputStream(audioFile2);
//                clip2.open(audioInput2);
//                clip2.start();
//                clip2.loop(0);
            } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
                e.printStackTrace();
            }
            PanelMessage.messageBoxMotion();
        });
        //BtnStyle(createTreeBtn);
        Button burnTreeBtn = new Button(" Burn ");
        burnTreeBtn.setOnMouseClicked(event -> {
            if (comboBox1.getValue() == null)
                textArea.setText("No tree to burn :(");
            else {
                for (BinaryTree item : binaryTreeArrayList) {
                    if (comboBox1.getValue().equals(item.getName())) {
                        comboBox1.getItems().remove(item.getName());
                        comboBox2.getItems().remove(item.getName());
                        binaryTreeArrayList.remove(item);
                        textArea.setText("Tree is Burned ;)");
                        rootTrees.getChildren().clear();
                        break;
                    }
                }
            }
            PanelMessage.messageBoxMotion();

        });
        //BtnStyle(burnTreeBtn);
        // COMBO-BOX
        comboBox1.setPromptText("Select Tree");
        comboBox2.setPromptText("Select Tree");
        menuVBox.getChildren().add(comboBox1);
        Rectangle fullPageRec = new Rectangle(screenWidth, screenHeight);
        fullPageRec.setFill(Color.BLACK);
        fullPageRec.setOpacity(0.75);
        // ADDS ALL TO THE MENU
        createTreeHBox.getChildren().addAll(rootDataTextField, createTreeBtn);
        removeTreeHBox.getChildren().addAll(removeCurrentTree, burnTreeBtn);
        treePanelVBox.getChildren().addAll(textTree, comboBox1, selectTreeHBox, createTreeHBox, removeTreeHBox);
        menuVBox.getChildren().add(treePanelVBox);
    }
}
