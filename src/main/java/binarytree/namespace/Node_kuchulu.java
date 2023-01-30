package binarytree.namespace;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

// Kuchulu means "small", THIS IS THE NODE CLASS
public class Node_kuchulu {
    public int data;
    public int index;
    public Node_kuchulu left, right = null;
    public Circle circle = new Circle(500, 300, 25);

    // CONSTRUCTOR
    public Node_kuchulu(int data, int nodeIndex) {
        this.circle.setFill(Color.RED);
        this.data = data;
        this.index = nodeIndex;
    }
}

