package binarytree.namespace;

import javafx.animation.*;
import javafx.scene.Node;
import javafx.util.Duration;

import java.util.Random;

import static binarytree.namespace.DrawFog.fogArrayList;
import static binarytree.namespace.Main.*;

// THE MOTIONS DEFINED HERE
// THIS CODE LOOKS WEIRD, BUT IT'S ON PURPOSE
public class DotMotion {
    public static Timeline MenuTimeline; // A TIMELINE TO IMPLEMENT MOTION
    private static double posX = 0; // DEFAULT STARTING X VALUE
    private static byte count = 0; // A VARIABLE TO ADJUST THE RAIN
    private static int counter = 0; // COUNTER...
    private static double duration = 5; // DURATION OF SOME TRANSITIONS
    private static final double duration2 = 5; //  DURATION OF SOME TRANSITIONS
    private static Node fogView = null; // A FOG OBJECT
    private static int index = 0; // A RANDOM NUMBER WILL BE ASSIGNED TO IT

    static Random rand = new Random(); // RANDOM IS USED TO GENERATE RANDOM Y

    // METEOR-RAIN CONSTRUCTOR
    public static void dotRain() {
        // ASSIGN THE TIMELINE
        MenuTimeline = new Timeline();
        MenuTimeline.setCycleCount(Timeline.INDEFINITE);
        MenuTimeline.getKeyFrames().add(
                new KeyFrame(Duration.seconds(0.4),
                        event -> {
                            // ClOUD MOTION
                            index = rand.nextInt(16);
                            fogView = fogArrayList.get(index).getView();
                            index = rand.nextInt(16);
                            fogView = fogArrayList.get(index).getView();
                            fogMotion(fogView, duration2);
                            // DOT FALLING MOTION
                            count++;
                            counter++;
                            if (counter >= 35) {
                                if (counter < 40) {
                                    for (int i = 0; i < 5; i++) {
                                        index = rand.nextInt(16);
                                        fogView = fogArrayList.get(index).getView();
                                        fogMotion(fogView, 0.05);
                                    }
                                }
                                duration = 3;
                                posX = rand.nextInt(((int) screenWidth) + 1) - 200;
                                DotComponent dotComponent2 = new DotComponent(posX, -30);
                                motionRoot.getChildren().add(dotComponent2);
                                Action(dotComponent2, duration);

                                posX = rand.nextInt(((int) screenWidth) + 1) - 200;
                                DotComponent dotComponent3 = new DotComponent(posX, -30);
                                motionRoot.getChildren().add(dotComponent3);
                                Action(dotComponent3, duration);
                            }
                            if (counter >= 50)
                                duration = 5;
                            posX = rand.nextInt(((int) screenWidth) + 1) - 200;
                            DotComponent dotComponent = new DotComponent(posX, -30);
                            motionRoot.getChildren().add(dotComponent);
                            Action(dotComponent, duration);
                            if (count == 3) {
                                posX = rand.nextInt(((int) screenWidth) + 1) - 200;
                                DotComponent dotComponent2 = new DotComponent(posX, -30);
                                motionRoot.getChildren().add(dotComponent2);
                                Action(dotComponent2, duration);
                            }
                            if (count == 5) {
                                for (int i = 0; i < 2; i++) {
                                    posX = rand.nextInt(((int) screenWidth) + 1) - 200;
                                    DotComponent dotComponent2 = new DotComponent(posX, -30);
                                    motionRoot.getChildren().add(dotComponent2);
                                    Action(dotComponent2, duration);
                                }
                                count = 0;
                            }
                        }));
        MenuTimeline.playFromStart();
    }

    // METEOR FALLING TRANSITION
    private static void Action(DotComponent dotComponent, double duration) {
        FadeTransition ftIn = new FadeTransition(Duration.seconds(0.5));
        ftIn.setFromValue(0);
        ftIn.setToValue(0.6);
        ftIn.setAutoReverse(true);
        ScaleTransition tt1 = new ScaleTransition(Duration.seconds(2.5));
        tt1.setFromX(0.7);
        tt1.setToX(1);
        tt1.setFromY(0.5);
        tt1.setToY(1);
        TranslateTransition tt = new TranslateTransition(Duration.seconds(duration), dotComponent);
        tt.setToX(dotComponent.getTranslateX() + screenHeight + 300);
        tt.setToY(dotComponent.getTranslateY() + screenHeight + 1200);
        tt.play();
        tt.setOnFinished(evt -> {
            motionRoot.getChildren().remove(dotComponent);
        });
        SequentialTransition seqT2 = new SequentialTransition(dotComponent, ftIn, tt1, tt);
        seqT2.setCycleCount(1);
        seqT2.play();
    }

    // FOG MOTION
    private static void fogMotion(Node fogView, double duration2) {
        FadeTransition ftOut = new FadeTransition(Duration.seconds(duration2));
        ftOut.setFromValue(0.8);
        ftOut.setToValue(0.6);
        ftOut.setAutoReverse(true);

        FadeTransition ftIn = new FadeTransition(Duration.seconds(duration2));
        ftIn.setFromValue(0.3);
        ftIn.setToValue(0.8);
        ftIn.setAutoReverse(true);

        TranslateTransition tMove = new TranslateTransition(Duration.seconds(2), fogView);
        tMove.setToX(fogView.getTranslateX() + 30);
//        tMove.setToY(fogView.getTranslateY() + screenHeight + 900);
//        tMove.play();

        TranslateTransition tBack = new TranslateTransition(Duration.seconds(2), fogView);
        tBack.setToX(fogView.getTranslateX() - 30);
//        tBack.setToY(fogView.getTranslateY() + screenHeight + 900);
//        tBack.play();

        SequentialTransition seqT2 = new SequentialTransition(fogView, ftOut, tMove, ftIn, tBack);
        seqT2.setCycleCount(1);
        seqT2.play();
    }
}
