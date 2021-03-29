package sample.segur;
//646165 color gris
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
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

public class Segur {
    @FXML AnchorPane anchorPane;
    @FXML StackPane stackePane;

    public void regresar(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../principal/principal.fxml"));
        Scene scene = anchorPane.getScene();
        root.translateYProperty().set(scene.getWidth());
        stackePane.getChildren().add(root);
        Timeline timeline = new Timeline();
        KeyValue ky = new KeyValue(root.translateYProperty(), 0, Interpolator.EASE_IN);
        KeyFrame kf = new KeyFrame(Duration.seconds(0.5), ky);
        timeline.getKeyFrames().add(kf);
        timeline.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(javafx.event.ActionEvent event) {
                stackePane.getChildren().remove(anchorPane);
            }
        });
        timeline.play();
    }

    public void loadDialog(ActionEvent event){
        JFXDialogLayout content =new JFXDialogLayout();
        content.setHeading(new Text("Medidas de Seguridad Informática"));
        content.setBody(new Text("* Controles de acceso a los datos más estrictos \n"
                + "* Realizar copias de seguridad \n"
                + "* Utilizar contraseñas seguras \n"
                + "* Proteger el correo electrónico \n"
                + "* Contratar un software integral de seguridad \n"
                + "* Utilizar software DLP \n"
                + "* Trabajar en la nube \n"
                + "* Involucrar a toda la empresa en la seguridad \n"
                + "* Monitorización continua y respuesta inmediata"));
        JFXDialog dialog=new JFXDialog(stackePane,content, JFXDialog.DialogTransition.CENTER);
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

    public void loadDialog2(ActionEvent event){
        JFXDialogLayout content =new JFXDialogLayout();
        content.setHeading(new Text("Medidas de Seguridad ante Covid-19"));
        content.setBody(new Text("* Uso estricto de cubrebocas \n"
                + "* Mantener una distancia de por lo menos 1.5 metros \n"
                + "* Aplicarse gel antibacterial a todo lugar que entre \n"
                + "* Lavarse las manos con frecencua por 20 segundos. \n"
                + "* Si esta enfermo o siente que esta por enfermarse, no salga de casa \n"
                + "* Estornudar o toser cubriendose la boca con el antebrazo \n"
                + "* No saludar de mano \n"
                + "* Mantener limpio su hogar, aula de trabajo, etc. \n"));
        JFXDialog dialog=new JFXDialog(stackePane,content, JFXDialog.DialogTransition.CENTER);
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

    public void loadDialog3(ActionEvent event){
        JFXDialogLayout content =new JFXDialogLayout();
        content.setHeading(new Text("Medidas de Seguridad para Trabajo en computadora"));
        content.setBody(new Text("* Establece horas de trabajo \n"
                + "* Mantener tus articulos electrónicos y aulas de trabajo limpios \n"
                + "* Revisar instalaciones eléctricas  \n"
                + "* Mantener una iluminaicón adecuada \n"
                + "* Evitar tener bebidas enseguida del equipo \n"
                + "* Hacer ejercicio, o tener algun hobbie \n"
                + "* Mantener buena postura en el asiento \n"
                + "* Tener un angulo adecuado de la pantalla \n"));
        JFXDialog dialog=new JFXDialog(stackePane,content, JFXDialog.DialogTransition.CENTER);
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
}

