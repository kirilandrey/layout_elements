package sample;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;

import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    Canvas canvas;
    GraphicsContext gc;
    public Button drawButton;
    public Button exitButton;
    public ChoiceBox lineWidthCB;
    public ChoiceBox rotateCB;
    public ColorPicker lineColorCP;
    public TextField leneLengthTF;
    public AnchorPane aPane;


    public void drawEvent(ActionEvent actionEvent) {
        int length = 150;
        gc = canvas.getGraphicsContext2D();
//        if (leneLengthTF.getText() == null){
//            Alert alert = new Alert(Alert.AlertType.ERROR, "ErOr!");
//        }else{
//            length = Integer.parseInt(leneLengthTF.getText());
//        }
        //int width = Integer.parseInt(lineWidthCB.getValue().toString());
        //int angle = Integer.parseInt(rotateCB.getValue().toString());
        Color color = lineColorCP.getValue();
        drawShapes(gc, 150, Color.BLACK, 5, 2);
        gc.setFill(Color.GREEN);
        gc.setStroke(Color.BLUE);
        gc.setLineWidth(5);
        gc.strokeLine(40, 10, 10, 40);
        gc.fillOval(10, 60, 30, 30);

    }

    private void drawShapes(GraphicsContext gc, int length, Color color, int width, int angle) {
        //gc.setFill(Color.GREEN);
        gc.setStroke(color);
        gc.setLineWidth(width);

        double[] xPoints = new double[6], yPoints = new double[6];

        for (int i = 0; i < 6; i++) {
            xPoints[i] = (100 + length * Math.cos(i * 2 * Math.PI / 6));
            yPoints[i] = (100 + length * Math.sin(i * 2 * Math.PI / 6));
        }

        System.out.println(Arrays.toString(xPoints));
        System.out.println(Arrays.toString(yPoints));

        gc.strokePolygon(xPoints, yPoints,  6);
        gc.rotate(angle);
        gc.strokePolygon(xPoints, yPoints,  6);
        gc.rotate(angle);
        gc.strokePolygon(xPoints, yPoints,  6);
        gc.rotate(angle);
        gc.strokePolygon(xPoints, yPoints,  6);
        gc.rotate(angle);
        gc.strokePolygon(xPoints, yPoints,  6);
        gc.rotate(angle);
        gc.strokePolygon(xPoints, yPoints,  6);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb){
        for (int i = 2; i < 8; i++) {
            lineWidthCB.getItems().add(i);
            rotateCB.getItems().add(i);
        }
//        lineWidthCB = new ChoiceBox(FXCollections.observableArrayList(
//                "1", "2", "3", "4", "5", "6", "7"
//        ));
//        rotateCB = new ChoiceBox(FXCollections.observableArrayList(
//                "2", "3", "4", "5", "6", "7"
//        ));
        System.out.println("lkjhgfdswe");
    }
}
