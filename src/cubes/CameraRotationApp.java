package cubes;

import com.ias.optimization.SimpleBox;
import com.ias.optimization.TestDataProvider;
import javafx.application.Application;
import javafx.geometry.Point3D;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.*;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;
import javafx.scene.shape.Cylinder;
import javafx.stage.Stage;
import javafx.scene.text.*;

//import javax.xml.soap.Text;
import java.util.ArrayList;
import java.util.Random;

public class CameraRotationApp extends Application {

    private Parent prepareMainScene() throws Exception {

        Group parentGroup = new Group();
        RotatableCamera rotatableCamera1 = new RotatableCamera();
        RotatableCamera rotatableCamera2 = new RotatableCamera();

        SubScene subScene = prepareSubScene(rotatableCamera1);
        parentGroup.getChildren().add(subScene);
        parentGroup.getChildren().add(prepareMapScene(rotatableCamera2));

        initializeCameraKeyListener(subScene, rotatableCamera1, rotatableCamera2);

        return parentGroup;
    }

    private SubScene prepareSubScene(RotatableCamera camera) {

        Group root = new Group();

        boxProducer(root);

        SubScene subScene = new SubScene(
                root,
                1500, 990,
                true,
                SceneAntialiasing.BALANCED
        );

        subScene.setFill(Color.FLORALWHITE);
        subScene.setCamera(camera);
        subScene.setFocusTraversable(true);

        return subScene;
    }

    private SubScene prepareMapScene(RotatableCamera camera) throws Exception {

        Group mapGroup = new Group();

        SubScene mapScene = new SubScene(
                mapGroup,
                200, 200,
                true,
                SceneAntialiasing.BALANCED
        );

        mapCylinderProducer(mapGroup);

        mapScene.setFill(Color.LIGHTGRAY);
        mapScene.setCamera(camera);
        mapScene.setFocusTraversable(true); // Enable focus for handling key events
        mapGroup.getChildren().add(mapScene);


        return mapScene;
    }

    private void initializeCameraKeyListener(SubScene subScene, RotatableCamera camera1, RotatableCamera camera2) {

        // Add keyboard event handling for camera rotation
        double deltaMovement = 5.0;

        subScene.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.LEFT) {
                camera1.getCameraXRotate().setAngle(camera1.getCameraXRotate().getAngle() - deltaMovement);
                camera2.getCameraXRotate().setAngle(camera2.getCameraXRotate().getAngle() - deltaMovement);
            } else if (event.getCode() == KeyCode.RIGHT) {
                camera1.getCameraXRotate().setAngle(camera1.getCameraXRotate().getAngle() + deltaMovement);
                camera2.getCameraXRotate().setAngle(camera2.getCameraXRotate().getAngle() + deltaMovement);
            } else if (event.getCode() == KeyCode.UP) {
                camera1.getCameraYRotate().setAngle(camera1.getCameraYRotate().getAngle() - deltaMovement);
                camera2.getCameraYRotate().setAngle(camera2.getCameraYRotate().getAngle() - deltaMovement);
            } else if (event.getCode() == KeyCode.DOWN) {
                camera1.getCameraYRotate().setAngle(camera1.getCameraYRotate().getAngle() + deltaMovement);
                camera2.getCameraYRotate().setAngle(camera2.getCameraYRotate().getAngle() + deltaMovement);
            } else if (event.getCode() == KeyCode.W) {
                camera1.getCameraTranslate().setZ(camera1.getCameraTranslate().getZ() + deltaMovement);
            } else if (event.getCode() == KeyCode.S) {
                camera1.getCameraTranslate().setZ(camera1.getCameraTranslate().getZ() - deltaMovement);
            } else if (event.getCode() == KeyCode.A) {
                camera1.getCameraTranslate().setX(camera1.getCameraTranslate().getX() - deltaMovement);
            } else if (event.getCode() == KeyCode.D) {
                camera1.getCameraTranslate().setX(camera1.getCameraTranslate().getX() + deltaMovement);
            } else if (event.getCode() == KeyCode.CONTROL) {
                camera1.getCameraTranslate().setY(camera1.getCameraTranslate().getY() + deltaMovement);
            } else if (event.getCode() == KeyCode.SPACE) {
                camera1.getCameraTranslate().setY(camera1.getCameraTranslate().getY() - deltaMovement);
            }
        });
    }

    private void boxProducer(Group root) {
        ArrayList<SimpleBox> list = TestDataProvider.randomizeSizeAndLocation(4);

        double xOffset = 0;

        Random r = new Random();
        for (int i = 0; i < list.size(); i++) {
            SimpleBox simpleBox = list.get(i);
            Box box = new Box(simpleBox.getWidth(), simpleBox.getHeight(), simpleBox.getDepth());

            Color color = new Color(r.nextDouble(), r.nextDouble(), r.nextDouble(), 1f);
            PhongMaterial material = new PhongMaterial();
            material.setDiffuseColor(color);
            box.setMaterial(material);
            box.translateXProperty().set(xOffset + box.getWidth() / 2);
            xOffset += box.getWidth();

            box.translateYProperty().set(box.getHeight() / 2 * -1);
            box.translateZProperty().set(box.getDepth() / 2 * -1);

            root.getChildren().add(box);
        }
    }


    private void mapCylinderProducer(Group mapGroup) {

        double setTranslate = 3;

        PhongMaterial redMaterial = new PhongMaterial();
        redMaterial.setDiffuseColor(Color.RED);
        Cylinder cylinderX = new Cylinder(0.5, 7);
        cylinderX.setMaterial(redMaterial);

        cylinderX.setRotationAxis(new Point3D(0, 0, 1));
        cylinderX.setRotate(90);

        cylinderX.translateXProperty().set(setTranslate);

        PhongMaterial blueMaterial = new PhongMaterial();
        blueMaterial.setDiffuseColor(Color.BLUE);
        Cylinder cylinderY = new Cylinder(0.5, 7);
        cylinderY.setMaterial(blueMaterial);

        cylinderY.setRotationAxis(new Point3D(0, 1, 0));
        cylinderY.setRotate(90);

        cylinderY.translateYProperty().set(-setTranslate);

        PhongMaterial greenMaterial = new PhongMaterial();
        greenMaterial.setDiffuseColor(Color.GREEN);
        Cylinder cylinderZ = new Cylinder(0.5, 7);
        cylinderZ.setMaterial(greenMaterial);

        cylinderZ.setRotationAxis(new Point3D(1, 0, 0));
        cylinderZ.setRotate(90);

        cylinderZ.translateZProperty().set(-setTranslate);

        PhongMaterial material = new PhongMaterial();
        material.setDiffuseColor(Color.WHITE);
        Box originBox = new Box(4, 4, 4);
        originBox.setMaterial(material);


        mapGroup.getChildren().addAll(cylinderX, cylinderY, cylinderZ, originBox);

    }


    @Override
    public void start(Stage stage) throws Exception {
        stage.setResizable(false);
        Scene scene = new Scene(prepareMainScene());
        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}