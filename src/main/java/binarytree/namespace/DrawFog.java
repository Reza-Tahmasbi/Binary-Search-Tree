package binarytree.namespace;

import javafx.animation.*;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.util.Duration;

import java.util.ArrayList;

import static binarytree.namespace.DotMotion.rand;
import static binarytree.namespace.Main.*;

public class DrawFog extends Parent {

//    public static Timeline MenuTimeline2;
    public static ArrayList<Fog> fogArrayList = new ArrayList<>();
    Fog fog1 = new Fog(70,70);
    Fog fog2 = new Fog(150,150);
    Fog fog3 = new Fog(150,150);
    Fog fog4 = new Fog(100,100);
    Fog fog5 = new Fog(200,200);
    Fog fog6 = new Fog(100,100);
    Fog fog7 = new Fog(200,200);
    Fog fog8 = new Fog(100,100);
    Fog fog9 = new Fog(200,200);
    Fog fog10 = new Fog(200,200);
    Fog fog11 = new Fog(100,100);
    Fog fog12 = new Fog(200,200);
    Fog fog13 = new Fog(100,100);
    Fog fog14 = new Fog(200,200);
    Fog fog15 = new Fog(200,200);
    Fog fog16 = new Fog(200,200);
    public DrawFog(){
        fog1.getView().setTranslateY(-80);
        fog1.getView().setTranslateX(0);
        fog1.getView().setOpacity(0.7);

        fog2.getView().setTranslateY(-170);
        fog2.getView().setTranslateX(90);
        fog2.getView().setOpacity(0.8);

        fog3.getView().setTranslateY(-200);
        fog3.getView().setTranslateX(220);
        fog3.getView().setOpacity(0.7);

        fog4.getView().setTranslateY(-140);
        fog4.getView().setTranslateX(300);
        fog4.getView().setOpacity(0.5);

        fog5.getView().setTranslateY(-120);
        fog5.getView().setTranslateX(400);
        fog5.getView().setOpacity(0.5);

        fog6.getView().setTranslateY(-120);
        fog6.getView().setTranslateX(500);
        fog6.getView().setOpacity(0.5);

        fog7.getView().setTranslateY(-100);
        fog7.getView().setTranslateX(600);
        fog7.getView().setOpacity(0.5);

        fog8.getView().setTranslateY(-100);
        fog8.getView().setTranslateX(750);
        fog8.getView().setOpacity(0.7);

        fog9.getView().setTranslateY(-80);
        fog9.getView().setTranslateX(850);
        fog9.getView().setOpacity(0.7);

        fog10.getView().setTranslateY(-90);
        fog10.getView().setTranslateX(920);
        fog10.getView().setOpacity(0.6);

        fog11.getView().setTranslateY(-90);
        fog11.getView().setTranslateX(1050);
        fog11.getView().setOpacity(0.5);

        fog12.getView().setTranslateY(-100);
        fog12.getView().setTranslateX(1250);
        fog12.getView().setOpacity(0.6);

        fog13.getView().setTranslateY(-100);
        fog13.getView().setTranslateX(1450);
        fog13.getView().setOpacity(0.7);

        fog14.getView().setTranslateY(-90);
        fog14.getView().setTranslateX(1500);
        fog14.getView().setOpacity(0.8);

        fog15.getView().setTranslateY(-75);
        fog15.getView().setTranslateX(1700);
        fog15.getView().setOpacity(0.8);

        fog16.getView().setTranslateY(-67);
        fog16.getView().setTranslateX(1100);
        fog16.getView().setOpacity(0.8);

        motionRoot.getChildren().addAll(fog1.getView(),fog2.getView(),fog3.getView(),fog4.getView(),fog5.getView(),fog6.getView(),fog7.getView()
        ,fog8.getView(),fog9.getView(),fog10.getView(),fog11.getView(),fog12.getView(),fog13.getView(),fog14.getView(),fog15.getView(),fog16.getView());

        fogArrayList.add(fog1);fogArrayList.add(fog2);fogArrayList.add(fog3);fogArrayList.add(fog4);fogArrayList.add(fog5);fogArrayList.add(fog6);fogArrayList.add(fog7);fogArrayList.add(fog8);
        fogArrayList.add(fog9);fogArrayList.add(fog10);fogArrayList.add(fog11);fogArrayList.add(fog12);fogArrayList.add(fog13);fogArrayList.add(fog14);fogArrayList.add(fog15);fogArrayList.add(fog16);



    }


}
