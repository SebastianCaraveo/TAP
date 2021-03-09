package sample;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;

import java.util.Random;

public class Controller {
    @FXML AnchorPane padre;
    @FXML HBox contenedor;
    String[] palabras = {"PELOTA", "LIBRO", "CUCHARA", "SALSA", "CHICARRON", "MOUSE"};
    TextField[]arrayTxt=null;
    int fallos=1;
    @FXML
    protected void initialize() {

        Random random = new Random();
        int aleatorio = random.nextInt(6);
        String palabra = palabras[aleatorio].toLowerCase();
        System.out.println(palabra);
        arrayTxt=new TextField[palabra.length()];
        int ayuda = 1;
        for (int x = 0; x < palabra.length(); x++) {
            arrayTxt[x] = new TextField();
            arrayTxt[x].setPrefHeight(50);
            arrayTxt[x].setPrefWidth(50);
            arrayTxt[x].setId("txt-"+x+"-"+palabra.charAt(x));
            arrayTxt[x].setOnKeyReleased(new EventHandler<KeyEvent>() {
                @Override
                public void handle(KeyEvent event) {

                        TextField textf = (TextField) event.getTarget();
                        String[] nombre = textf.getId().split("-");
                        if (nombre[2].equals(textf.getText().toLowerCase())) {
                            System.out.println("CORRECTOOOO CRUCK" + textf.getId());
                            textf.setDisable(true);
                        } else {
                            System.out.println("QUE MANCOOOOO"+textf.getId());
                            textf.setText("");
                            pintarcuerpo();
                            fallos=+1;

                        }
                   // System.out.println(nombre[1])
                }
            });
            contenedor.getChildren().add(arrayTxt[x]);
        }
    }

    public void pintarcuerpo() {


            ImageView cabeza = new ImageView(new Image("sample/img/cabeza.png"));
            cabeza.setFitWidth(70);
            cabeza.setFitHeight(70);
            cabeza.setLayoutX(200);
            cabeza.setLayoutY(200);
            padre.getChildren().add(cabeza);

            ImageView cuerpo = new ImageView(new Image("sample/img/cuerpo.png"));
            cuerpo.setFitWidth(70);
            cuerpo.setFitHeight(70);
            cuerpo.setLayoutX(195);
            cuerpo.setLayoutY(260);
            padre.getChildren().addAll(cuerpo);

            ImageView bi = new ImageView(new Image("sample/img/izq.png"));
            bi.setFitWidth(70);
            bi.setFitHeight(70);
            bi.setLayoutX(180);
            bi.setLayoutY(320);
            padre.getChildren().add(bi);

            ImageView bii = new ImageView(new Image("sample/img/izq.png"));
            bii.setFitWidth(70);
            bii.setFitHeight(70);
            bii.setLayoutX(180);
            bii.setLayoutY(285);
            padre.getChildren().add(bii);

            ImageView bd = new ImageView(new Image("sample/img/der.png"));
            bd.setFitWidth(70);
            bd.setFitHeight(70);
            bd.setLayoutX(220);
            bd.setLayoutY(320);
            padre.getChildren().add(bd);

            ImageView bdd = new ImageView(new Image("sample/img/der.png"));
            bdd.setFitWidth(70);
            bdd.setFitHeight(70);
            bdd.setLayoutX(220);
            bdd.setLayoutY(285);
            padre.getChildren().add(bdd);

        }
        }

    

