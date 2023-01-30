module com.example.binarytree {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens binarytree.namespace to javafx.fxml;
    exports binarytree.namespace;
}