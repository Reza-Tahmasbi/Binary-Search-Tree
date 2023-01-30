package binarytree.namespace;

import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import static binarytree.namespace.BinaryTree.getTreeRootFromComboBox;
import static binarytree.namespace.BinaryTree.searchBST;
import static binarytree.namespace.Main.*;
import static binarytree.namespace.BtnStyle.BtnStyle;

// THE CLASS WHERE SEARCH PANEL IS DRAWN
public class PanelSearch {
    public static void drawSearchPanel() {
        VBox searchVBox = new VBox(9);
        HBox SearchHBox = new HBox(5);
        // LABELS
        Text textSearch = new Text("Search");
        textSearch.setFill(textColor);
        textSearch.setFont(Font.font(font, 17));
        // TEXT-FIELD
        TextField dataTextField = new TextField();
        dataTextField.setMinWidth(100);
        dataTextField.setFont(Font.font("Drawing-Rainbow.ttf"));
        dataTextField.setPrefWidth(60);
        dataTextField.setPromptText("Data");
        dataTextField.setCursor(Cursor.TEXT);
        // COMMAND-BTN
        Button searchBtn = new Button("Search");
        searchBtn.setOnMouseClicked(event -> {
            textArea.setText(searchBST(getTreeRootFromComboBox(), Integer.parseInt(dataTextField.getText())));
//            drawTreeButton.fire();
            PanelMessage.messageBoxMotion();
        });
        //(BtnStylesearchBtn);
        SearchHBox.getChildren().addAll(dataTextField, searchBtn);
        searchVBox.getChildren().addAll(textSearch, SearchHBox);
        menuVBox.getChildren().add(searchVBox);

    }
}
