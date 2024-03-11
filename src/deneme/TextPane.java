package deneme;

import javafx.geometry.Orientation;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextBoundsType;
import javafx.stage.Stage;

public class TextPane extends Region {
    private final Text text ;
    public TextPane(Text text) {
        this.text = text ;
        getChildren().add(text);
    }

    @Override
    protected void layoutChildren() {
        adjustFontSize(getHeight());
        text.setY(getHeight());
        text.setX(0);
    }

    private void adjustFontSize(double height) {
        double textHeight = text.getBoundsInLocal().getHeight();
        if (Math.abs(height - textHeight) > 1) {
            Font currentFont = text.getFont() ;
            double fontSize = currentFont.getSize() ;
            text.setFont(Font.font(currentFont.getFamily(), height * fontSize / textHeight));
        }
    }

    @Override
    protected double computePrefWidth(double height) {
        adjustFontSize(height);
        return text.getBoundsInLocal().getWidth();
    }

    @Override
    public Orientation getContentBias() {
        return Orientation.VERTICAL;
    }
}

