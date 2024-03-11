package cubes;

import javafx.scene.PerspectiveCamera;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Translate;

public class RotatableCamera extends PerspectiveCamera {

    private Rotate cameraYRotate;
    private Rotate cameraXRotate;
    private Translate cameraTranslate;

    public RotatableCamera() {
        super(true);
        cameraXRotate = new Rotate(0, Rotate.Y_AXIS);
        cameraYRotate = new Rotate(0, Rotate.X_AXIS);
        cameraTranslate = new Translate(0, 0, 0);
        this.getTransforms().addAll(
                cameraXRotate,
                cameraYRotate,
                cameraTranslate,
                new Rotate(-20, Rotate.X_AXIS),
                new Translate(0, 0, -50)
        );

    }

    public Rotate getCameraYRotate() {

        return cameraYRotate;

    }

    public Rotate getCameraXRotate() {

        return cameraXRotate;

    }

    public Translate getCameraTranslate() {

        return cameraTranslate;

    }

}
