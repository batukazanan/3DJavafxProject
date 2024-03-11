package deneme;

import com.ias.optimization.SimpleBox;
import com.ias.optimization.TestDataProvider;
import javafx.application.Application;
import javafx.geometry.Point3D;
import javafx.scene.Camera;
import javafx.scene.Group;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Transform;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Rotation3D extends Application {

    private static final int WIDTH = 1400;
    private static final int HEIGHT = 800;


    @Override
    public void start(Stage primaryStage) throws Exception {

        SmartGroup group = new SmartGroup();

        ArrayList<SimpleBox> list = TestDataProvider.randomizeSizeAndLocation(4);

        for (int i=0;i<list.size();i++) {
            SimpleBox simpleBox= list.get(i);
            Box box = new Box(simpleBox.getWidth()*3, simpleBox.getHeight()*3, simpleBox.getDepth()*3);

            PhongMaterial material = new PhongMaterial();
            Color color = Color.YELLOW;
            if (i == 0) {
                color = Color.BLUE;
            }else if( i == 1) {
                color = Color.ORANGE;
            }else if(i == 2) {
                color = Color.GREEN;
            }
            material.setDiffuseColor(color);
            box.setMaterial(material);
            group.getChildren().add(box);
            box.translateXProperty().set(simpleBox.getWidth() +  i * 5);
        }


        Camera camera = new PerspectiveCamera();
        Scene scene = new Scene(group, WIDTH, HEIGHT);
        scene.setFill(Color.BLACK);
        scene.setCamera(camera);

        group.translateXProperty().set(WIDTH / 2);
        group.translateYProperty().set(HEIGHT / 2);
        group.translateZProperty().set(1200);


        primaryStage.addEventHandler(KeyEvent.KEY_PRESSED, event -> {
            switch (event.getCode()) {
                case W:
                    camera.translateZProperty().set(camera.getTranslateZ() + 10);
                    break;
                case S:
                    camera.translateZProperty().set(camera.getTranslateZ() - 10);
                    break;
                case X:
                    camera.translateXProperty().set(camera.getTranslateX() + 10);
                    break;
                case C:
                    camera.translateXProperty().set(camera.getTranslateX() - 10);
                    break;
                case Q:
                    System.out.println(camera.rotationAxisProperty().get());
                    camera.rotationAxisProperty().set(new Point3D(0,1,0));
                    camera.setRotate(camera.getRotate() +10);
                    System.out.println(camera.rotationAxisProperty().get());
                    break;
                case E:
                    camera.rotationAxisProperty().set(new Point3D(0,1,0));
                    camera.setRotate(camera.getRotate() -10);
                    break;

            }
        });

        primaryStage.setTitle("Java Coder");
        primaryStage.setScene(scene);
        primaryStage.show();


    }

    public static void main(String[] args) { launch(args);    }

     class SmartGroup extends Group {
        Rotate r;
        Transform t = new Rotate();

        void rotateByX(int ang) {
            r = new Rotate (ang, Rotate.X_AXIS);
            t = t.createConcatenation(r);
            this.getTransforms().clear();
            this.getTransforms().addAll(t);
        }

        void rotateByY(int ang) {
            r = new Rotate (ang, Rotate.Y_AXIS);
            t = t.createConcatenation(r);
            this.getTransforms().clear();
            this.getTransforms().addAll(t);
        }

    }

}