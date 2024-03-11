package deneme;

import javafx.application.Application;
import javafx.geometry.Point3D;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;
import javafx.scene.shape.Cylinder;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Translate;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {

        double setTranslate = 3;

        PhongMaterial redMaterial = new PhongMaterial();
        redMaterial.setDiffuseColor(Color.RED);
        Cylinder cylinderX = new Cylinder(1, 5);
        cylinderX.setMaterial(redMaterial);

        cylinderX.setRotationAxis(new Point3D(0,0,1));
        cylinderX.setRotate(90);

        cylinderX.translateXProperty().set(setTranslate);

        PhongMaterial blueMaterial = new PhongMaterial();
        blueMaterial.setDiffuseColor(Color.BLUE);
        Cylinder cylinderY = new Cylinder(1, 5);
        cylinderY.setMaterial(blueMaterial);

        cylinderY.setRotationAxis(new Point3D(0,1,0));
        cylinderY.setRotate(90);

        cylinderY.translateYProperty().set(- setTranslate);

        PhongMaterial greenMaterial = new PhongMaterial();
        greenMaterial.setDiffuseColor(Color.GREEN);
        Cylinder cylinderZ = new Cylinder(1,5);
        cylinderZ.setMaterial(greenMaterial);

        cylinderZ.setRotationAxis(new Point3D(1,0,0));
        cylinderZ.setRotate(90);

        cylinderZ.translateZProperty().set(-setTranslate);

        PhongMaterial material = new PhongMaterial();
        material.setDiffuseColor(Color.YELLOW);
        Box box = new Box(2,2,2);
        box.setMaterial(material);


        Group root = new Group();
        root.getChildren().addAll(cylinderX ,cylinderY,cylinderZ,box);

        PerspectiveCamera camera = new PerspectiveCamera(true);
        camera.setTranslateX(-3);
        camera.setTranslateY(-20);
        camera.setTranslateZ(-60);

        camera.getTransforms().addAll(new Rotate(-20, Rotate.X_AXIS) );


        Scene scene = new Scene(root, 600, 400, true);
        scene.setCamera(camera);
        scene.setFill(Color.LIGHTGRAY);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Javafx");
        primaryStage.show();
    }



    public static void main(String[] args) {
        launch(args);
    }
}
