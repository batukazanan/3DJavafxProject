package deneme;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;

public class TriadBox extends Application {

    private static final double SIZE = 300;
    private final Content content = Content.create(SIZE);

    private static final class Content {

        private static final double WIDTH = 3;
        private final Group group = new Group();
        private final Group cube = new Group();
        private final Group axes = new Group();
        private final Rotate rx = new Rotate(0, Rotate.X_AXIS);
        private final Rotate ry = new Rotate(0, Rotate.Y_AXIS);
        private final Rotate rz = new Rotate(0, Rotate.Z_AXIS);
        private final Box xAxis;
        private final Box yAxis;
        private final Box zAxis;
        private final Box box;

        private static Content create(double size) {
            Content c = new Content(size);
            c.cube.getChildren().add(c.box);
            c.cube.getTransforms().addAll(c.rz, c.ry, c.rx);
            c.axes.getChildren().addAll(c.xAxis, c.yAxis, c.zAxis);
            c.axes.setTranslateX(-size / 2);
            c.axes.setTranslateY(size / 2);
            c.group.getChildren().addAll(c.cube, c.axes);
            return c;
        }

        private Content(double size) {
            xAxis = createBox(size*2, WIDTH, WIDTH);
            yAxis = createBox(WIDTH, size*2, WIDTH);
            zAxis = createBox(WIDTH, WIDTH, size*2);
            double edge = 3 * SIZE / 4;
            box = new Box(edge, edge, edge);
            box.setMaterial(new PhongMaterial(Color.CORAL));
        }

        private Box createBox(double w, double h, double d) {
            Box b = new Box(w, h, d);
            b.setMaterial(new PhongMaterial(Color.AQUA));
            return b;
        }
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("JavaFX 3D");
        Scene scene = new Scene(content.group, SIZE * 2, SIZE * 2, true);
        primaryStage.setScene(scene);
        scene.setFill(Color.BLACK);
        scene.setOnMouseMoved((final MouseEvent e) -> {
            content.rx.setAngle(e.getSceneY() * 360 / scene.getHeight());
            content.ry.setAngle(e.getSceneX() * 360 / scene.getWidth());
        });
        PerspectiveCamera camera = new PerspectiveCamera(true);
        camera.setFarClip(SIZE * 6);
        camera.setTranslateZ(-3 * SIZE);
        scene.setCamera(camera);
        scene.setOnScroll((final ScrollEvent e) -> {
            camera.setTranslateZ(camera.getTranslateZ() + e.getDeltaY());
        });
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}