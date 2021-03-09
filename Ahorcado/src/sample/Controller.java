package sample;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;

import java.util.Random;

public class Controller {
    @FXML
    AnchorPane padre;
    @FXML
    HBox contenedor;
    String[] palabras = {"PELOTA", "LIBRO", "CUCHARA", "SALSA", "CHICARRON", "MOUSE"};

    @FXML
    protected void initialize() {

        Random random = new Random();
        int aleatorio = random.nextInt(6);
        String palabra = palabras[aleatorio];
        System.out.println(palabra);
        int ayuda = 1;
        pintarcuerpo();
        for (int x = 0; x < palabra.length(); x++) {
            TextField txt1 = new TextField();
            txt1.setPrefHeight(50);
            txt1.setPrefWidth(50);
            contenedor.getChildren().add(txt1);
        }
    }

    public void pintarcuerpo() {
        ImageView cabeza = new ImageView(new Image("sample/img/cabeza.png"));
        cabeza.setFitWidth(70);
        cabeza.setFitHeight(70);
        cabeza.setLayoutX(200);
        cabeza.setLayoutY(200);
        ImageView cuerpo = new ImageView(new Image("sample/img/cuerpo.png"));
        cuerpo.setFitWidth(70);
        cuerpo.setFitHeight(70);
        cuerpo.setLayoutX(195);
        cuerpo.setLayoutY(260);
        ImageView bi = new ImageView(new Image("sample/img/izq.png"));
        bi.setFitWidth(70);
        bi.setFitHeight(70);
        bi.setLayoutX(180);
        bi.setLayoutY(320);
        ImageView bii = new ImageView(new Image("sample/img/izq.png"));
        bii.setFitWidth(70);
        bii.setFitHeight(70);
        bii.setLayoutX(180);
        bii.setLayoutY(285);
        ImageView bd = new ImageView(new Image("sample/img/der.png"));
        bd.setFitWidth(70);
        bd.setFitHeight(70);
        bd.setLayoutX(220);
        bd.setLayoutY(320);
        ImageView bdd = new ImageView(new Image("sample/img/der.png"));
        bdd.setFitWidth(70);
        bdd.setFitHeight(70);
        bdd.setLayoutX(220);
        bdd.setLayoutY(285);
        padre.getChildren().addAll(cabeza,cuerpo,bi,bii,bd,bdd);
    }
}
