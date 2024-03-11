package deneme;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;
import javafx.stage.Stage;

public class CubeViewer extends Application {
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;

    @Override
    public void start(Stage primaryStage) {
        // 3D küp oluşturma
        Box cube = new Box(30, 30, 30);
        cube.setTranslateX(WIDTH / 2);
        cube.setTranslateY(HEIGHT / 2);
        cube.setTranslateZ(0);

        // PhongMaterial kullanarak küpün rengini mavi yapma
        PhongMaterial blueMaterial = new PhongMaterial();
        blueMaterial.setDiffuseColor(Color.BLUE);
        cube.setMaterial(blueMaterial);

        // Kamera oluştur
        PerspectiveCamera camera = new PerspectiveCamera(true);
        camera.setTranslateZ(-100);


        // Grup oluştur ve küpü gruba ekleme
        Group root = new Group(cube);

        // Sahneyi oluştur ve kamerayı sahneye ekleme
        Scene scene = new Scene(root, WIDTH, HEIGHT, true);
        scene.setCamera(camera);

        // Klavye olaylarını dinleme
        scene.setOnKeyPressed(event -> handleKeyPress(event, cube));

        // Pencereyi ayarlama
        primaryStage.setTitle("3D Cube Viewer");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void handleKeyPress(KeyEvent event, Box cube) {
        switch (event.getCode()) {
            case LEFT:
                cube.setRotate(cube.getRotate() - 10);
                break;
            case RIGHT:
                cube.setRotate(cube.getRotate() + 10);
                break;
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
