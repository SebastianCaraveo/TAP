package sample.principal;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.util.Duration;
import sample.Main;

import java.io.IOException;

public class Principal {
    @FXML AnchorPane anchorPane;
    @FXML StackPane stackPane;
    @FXML Button prog, inform, seguridad, ajustes, profile;
    @FXML Label lblName;


    @FXML protected void initialize(){
        lblName.setText(Main.nombreUsuario);
    }

    public void config(ActionEvent event) throws IOException {
        Parent root= FXMLLoader.load(getClass().getResource("../config/config.fxml"));
        Scene scene=anchorPane.getScene();
        root.translateYProperty().set(scene.getHeight());
        stackPane.getChildren().add(root);
        Timeline timeline=new Timeline();
        KeyValue kv=new KeyValue(root.translateYProperty(), 0, Interpolator.EASE_IN);
        KeyFrame kf=new KeyFrame(Duration.seconds(0.5),kv);
        timeline.getKeyFrames().add(kf);
        timeline.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                stackPane.getChildren().remove(anchorPane);
            }
        });
        timeline.play();
    }

    public void security(ActionEvent event) throws IOException {
        Parent root= FXMLLoader.load(getClass().getResource("../segur/segur.fxml"));
        Scene scene=anchorPane.getScene();
        root.translateYProperty().set(scene.getHeight());
        stackPane.getChildren().add(root);
        Timeline timeline=new Timeline();
        KeyValue kv=new KeyValue(root.translateYProperty(), 0, Interpolator.EASE_OUT);
        KeyFrame kf=new KeyFrame(Duration.seconds(0.5),kv);
        timeline.getKeyFrames().add(kf);
        timeline.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                stackPane.getChildren().remove(anchorPane);
            }
        });
        timeline.play();
    }

    public void programac(ActionEvent event) throws IOException {
        Parent root= FXMLLoader.load(getClass().getResource("../programacion/programacion.fxml"));
        Scene scene=anchorPane.getScene();
        root.translateYProperty().set(scene.getHeight());
        stackPane.getChildren().add(root);
        Timeline timeline=new Timeline();
        KeyValue kv=new KeyValue(root.translateYProperty(), 0, Interpolator.EASE_OUT);
        KeyFrame kf=new KeyFrame(Duration.seconds(0.5),kv);
        timeline.getKeyFrames().add(kf);
        timeline.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                stackPane.getChildren().remove(anchorPane);
            }
        });
        timeline.play();
    }

    public void informatic(ActionEvent event) throws IOException {
        Parent root= FXMLLoader.load(getClass().getResource("../segur/segur.fxml"));
        Scene scene=anchorPane.getScene();
        root.translateYProperty().set(scene.getHeight());
        stackPane.getChildren().add(root);
        Timeline timeline=new Timeline();
        KeyValue kv=new KeyValue(root.translateYProperty(), 0, Interpolator.EASE_OUT);
        KeyFrame kf=new KeyFrame(Duration.seconds(0.5),kv);
        timeline.getKeyFrames().add(kf);
        timeline.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                stackPane.getChildren().remove(anchorPane);
            }
        });
        timeline.play();
    }

    public void registros(ActionEvent event){
        JFXDialogLayout content =new JFXDialogLayout();
        content.setHeading(new Text("Registro"));
        content.setBody(new Text("Aquí se guardaran registros de los dias que se conecto, la hora"));
        JFXDialog dialog=new JFXDialog(stackPane,content, JFXDialog.DialogTransition.CENTER);
        JFXButton button=new JFXButton("Okay");
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                dialog.close();
            }
        });
        content.setActions(button);
        dialog.show();
    }

    public void guardarR(ActionEvent event){
        JFXDialogLayout content =new JFXDialogLayout();
        content.setHeading(new Text("Registro"));
        content.setBody(new Text("Con esto se guardarán registros de los días que se registré junto con la  la hora"));
        JFXDialog dialog=new JFXDialog(stackPane,content, JFXDialog.DialogTransition.CENTER);
        JFXButton button=new JFXButton("Okay");
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                dialog.close();
            }
        });
        content.setActions(button);
        dialog.show();
    }

    public void salir(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../login/login.fxml"));
        Scene scene = new Scene(root);
        Main.stage.setScene(scene);
    }
}

