package binarytree.namespace;

import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import static binarytree.namespace.BinaryTree.*;
import static binarytree.namespace.BtnStyle.BtnStyle;
import static binarytree.namespace.Main.*;

// THE CLASS WHERE COMMAND/TRAVERSE PANEL IS DRAWN,AND DEFINED
public class PanelCommandTraverse {
    public static void drawCommandComboBox() {
        VBox commandVBox = new VBox(10);
        ComboBox<String> comboBox1 = new ComboBox<>();
        ComboBox<String> comboBox2 = new ComboBox<>();
        comboBox1.getItems().addAll("Preorder", "Inorder", "Postorder", "level-order");
        comboBox2.getItems().addAll("Max value", "Min value", "Node amount", "Height value", "is Complete?", "Is full Tree?", "Leaves amount");
        HBox hBox1 = new HBox(10);
        HBox hBox2 = new HBox(10);
        // LABELS
        Text textTraverse = new Text("Traverse:");
        textTraverse.setFill(textColor);
        textTraverse.setFont(Font.font(font, 17));
        Text textCommands = new Text("Command:");
        textCommands.setFill(textColor);
        textCommands.setFont(Font.font(font, 17));
        // COMMAND-BTN
        Button applyBtn = new Button("Apply");
        applyBtn.setOnMouseClicked(event -> {
            globString = "";
            switch (comboBox2.getValue()) {
                // CALLS THE PROPER FUNCTION
                case "Height value" -> textArea.setText(Integer.toString(getTreeHeight(getTreeRootFromComboBox()) - 1));
                case "Max value" -> textArea.setText(Integer.toString(findMax(getTreeRootFromComboBox())));
                case "Min value" -> textArea.setText(Integer.toString(findMin(getTreeRootFromComboBox())));
                case "is Complete?" -> textArea.setText(Boolean.toString(isCompleteBST(getTreeRootFromComboBox())));
                case "Is full Tree?" -> textArea.setText(Boolean.toString(isFullTree(getTreeRootFromComboBox())));
                case "Leaves amount" -> textArea.setText(Integer.toString(getLeavesAmount(getTreeRootFromComboBox())));
                case "Node amount" -> textArea.setText(Integer.toString(getTreeFromComboBox().nodeAmount));

            }
            PanelMessage.messageBoxMotion();
        });
        //buttonStyling(applyBtn);
        Button traverseBtn = new Button("Show");
        traverseBtn.setOnMouseClicked(event -> {
            globString = "";
            switch (comboBox1.getValue()) {
                // CALLS THE PROPER FUNCTION
                case "Postorder" -> BinaryTree.postOrder(getTreeRootFromComboBox());
                case "Inorder" -> BinaryTree.inorder(getTreeRootFromComboBox());
                case "Preorder" -> BinaryTree.preOrder(getTreeRootFromComboBox());
                case "level-order" -> BinaryTree.levelOrder(getTreeRootFromComboBox());
            }
            textArea.setText(globString);
            PanelMessage.messageBoxMotion();
        });
        //buttonStyling(traverseBtn);
        hBox1.getChildren().addAll(comboBox1, traverseBtn);
        hBox2.getChildren().addAll(comboBox2, applyBtn);
        comboBox2.setPromptText("Action");
        comboBox1.setPromptText("Action");
        commandVBox.getChildren().addAll(textTraverse, hBox1, textCommands, hBox2);
        menuVBox.getChildren().add(commandVBox);
    }
}
