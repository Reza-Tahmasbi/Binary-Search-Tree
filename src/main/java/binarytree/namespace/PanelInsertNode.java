package binarytree.namespace;

import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import static binarytree.namespace.BinaryTree.*;
import static binarytree.namespace.DrawTree.drawTreeButton;
import static binarytree.namespace.Main.*;
import static binarytree.namespace.BtnStyle.BtnStyle;
// THE CLASS WHERE INSERT NODE PANEL IS DRAWN
public class PanelInsertNode {
    public static void drawInsertPanel() {
        VBox insertVBox = new VBox(9);
        HBox inorderInsertHBox = new HBox(5);
        HBox IndexInsertHBox = new HBox(5);
        // LABELS
        Text textInsert = new Text("Insert");
        textInsert.setFill(textColor);
        textInsert.setFont(Font.font(font, 17));
        // TEXT-FIELD
        TextField dataTextField1 = new TextField();
        dataTextField1.setFont(Font.font("Drawing-Rainbow.ttf"));
        dataTextField1.setPrefWidth(60);
        dataTextField1.setPromptText("Data");
        dataTextField1.setCursor(Cursor.TEXT);
        // COMMAND-BTN
        Button inorderInsertBtn = new Button("Add");
        inorderInsertBtn.setOnMouseClicked(event -> {
            insertNode(getTreeRootFromComboBox(), Integer.parseInt(dataTextField1.getText()));
            textArea.setText("Node added");
            drawTreeButton.fire();
            PanelMessage.messageBoxMotion();
        });
        //buttonStyling(inorderInsertBtn);
        inorderInsertHBox.getChildren().addAll(dataTextField1, inorderInsertBtn);
        insertVBox.getChildren().addAll(textInsert, inorderInsertHBox, IndexInsertHBox);
        menuVBox.getChildren().add(insertVBox);

    }
}
