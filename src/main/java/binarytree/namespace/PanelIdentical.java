package binarytree.namespace;

import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import static binarytree.namespace.BinaryTree.isIdentical;
import static binarytree.namespace.Main.*;
import static binarytree.namespace.BtnStyle.BtnStyle;
import static binarytree.namespace.PanelInsertTree.comboBox1;

// THE CLASS WHERE IDENTICAL PANEL IS DRAWN
public class PanelIdentical {
    public static ComboBox<String> comboBox2 = new ComboBox<>();

    public static void drawIdenticalPanel() {
        {
            VBox vBox = new VBox(4);
            HBox hBox = new HBox(8);
            // LABELS
            Text textTree = new Text("Compare Trees");
            textTree.setFill(textColor);
            textTree.setFont(Font.font(font, 17));
            TextField treeTwoTextField = new TextField();
            TextField treeOneTextField = new TextField();
            treeOneTextField.setFont(Font.font("Drawing-Rainbow.ttf"));
            treeOneTextField.setMinWidth(70);
            treeOneTextField.setPrefWidth(60);
            treeOneTextField.setPromptText("root data");
            treeOneTextField.setCursor(Cursor.TEXT);
            treeTwoTextField.setFont(Font.font("Drawing-Rainbow.ttf"));
            treeTwoTextField.setMinWidth(70);
            treeTwoTextField.setPrefWidth(60);
            treeTwoTextField.setPromptText("root data");
            treeTwoTextField.setCursor(Cursor.TEXT);
            // COMMAND-BTN
            Button compareButton = new Button("Compare");
            compareButton.setOnMouseClicked(event -> {
                Node_kuchulu tree1Root = null;
                Node_kuchulu tree2Root = null;
                int temp = 0;
                if (!comboBox2.getValue().equals("") && !comboBox1.getValue().equals("")) {
                    for (BinaryTree item : binaryTreeArrayList) {
                        if (comboBox2.getValue().equals(item.getName())) {
                            tree1Root = item.getTreeRoot();
                        }
                    }
                    for (BinaryTree item : binaryTreeArrayList) {
                        if (comboBox1.getValue().equals(item.getName())) {
                            tree2Root = item.getTreeRoot();
                        }
                    }
                    if (comboBox2.getValue().equals(comboBox1.getValue()))
                        textArea.setText("Trees can not be the same");
                    else {
                        if (tree2Root != null && tree1Root != null) {
                            System.out.println(tree1Root.data);
                            System.out.println(tree2Root.data);
                            temp = isIdentical(tree1Root, tree2Root);

                        }
                        if (temp == 1)
                            textArea.setText("Trees are identical");
                        else
                            textArea.setText("Not identical");
                    }
                }
                PanelMessage.messageBoxMotion();
            });
            //BtnStyle(compareButton);
            hBox.getChildren().addAll(comboBox2, compareButton);
            vBox.getChildren().addAll(textTree, hBox);
            menuVBox.getChildren().add(vBox);

        }
    }
}
