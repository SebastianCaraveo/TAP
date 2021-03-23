package sample;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;

public class Controller {
    @FXML Canvas lienzo;
    GraphicsContext context;
    @FXML ColorPicker colorPicker;
    Color colorPincel=Color.BLACK;
    @FXML Slider slider;
    @FXML ComboBox comboOpciones;

    @FXML protected void initialize(){
        context=lienzo.getGraphicsContext2D();
       slider.valueProperty().addListener(new ChangeListener<Number>() {
           @Override
           public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
               pintarDibujos(t1.intValue());
           }
       });
        comboOpciones.getItems().addAll("Cuadricula","Ajedrez","Estrella","Estrella Doble","Curva","Estrella Tapiz");

        /*context.setFill(Color.BLUE);
        context.fillRect(10,20,100,50);
        context.setFill(Color.RED);
        context.strokeRect(200,150,200,100);
        context.strokeRect(400, 250,200,100);
        context.setFill(Color.GREEN);
        context.fillOval(375,375,50,50);
        context.strokeLine(50,50, lienzo.getWidth(), lienzo.getHeight());*/
       // ComboFormas.getItems().addAll("Cuadricula");
    }
    public void pintarDibujos(int valor){
        context.setFill(Color.WHITESMOKE);
        context.fillRect(0,0,lienzo.getWidth(),lienzo.getHeight());
        context.setFill(colorPincel);
        System.out.println(valor);

        if(comboOpciones.getSelectionModel().getSelectedIndex()==0){
            //Cuadricula
          for(int x=0;x<valor;x++){
                int division= (int) lienzo.getWidth()/valor;
                context.strokeLine(0,division*x,lienzo.getWidth(),division*x);
                context.strokeLine(division*x,0,division*x,lienzo.getHeight());
            }
        } else if(comboOpciones.getSelectionModel().getSelectedIndex()==1){
            //Ajedrez
            int espacio=2*valor;
            context.fillRect(0,0,lienzo.getWidth(), lienzo.getHeight());
            for(int x=0;x<lienzo.getWidth();x++){
                for(int y=0; y<=lienzo.getWidth(); y+=espacio){
                    context.clearRect(x,y,valor,valor);

                }


            }

            for(int x=valor; x<=lienzo.getWidth(); x+=espacio){
                for(int y=valor; y<=lienzo.getWidth(); y+=espacio){
                    context.clearRect(x,y,valor,valor);
                }
            }


        }else if(comboOpciones.getSelectionModel().getSelectedIndex()==2){
            //Estrella
            int mitadAncho=(int)lienzo.getWidth()/2;
            int mitadAlto=(int)lienzo.getHeight()/2;

            context.strokeLine(mitadAncho,0,mitadAncho,lienzo.getHeight());
            context.strokeLine(0,mitadAlto,lienzo.getWidth(),mitadAlto);

            int divisiones=mitadAlto/valor;
            for(int i=0;i<valor;i++){
                context.strokeLine(mitadAncho,divisiones*i,mitadAncho+(divisiones*i),mitadAlto);
                context.strokeLine(mitadAncho,lienzo.getWidth()-(divisiones*i),mitadAncho-(divisiones*i),mitadAlto);
                context.strokeLine(mitadAlto,divisiones*i,mitadAncho-(divisiones*i),mitadAncho);
                context.strokeLine(mitadAncho,lienzo.getWidth()-(divisiones*i),mitadAncho+(divisiones*i),mitadAlto);
            }
        }else if(comboOpciones.getSelectionModel().getSelectedIndex()==3){
            //Estrella Doble
            int mitadAncho=(int)lienzo.getWidth()/2;
            int mitadAlto=(int)lienzo.getHeight()/2;
            int mitadx2Ancho= mitadAncho+(mitadAncho/2);
            int mitadx2Alto=mitadAlto+(mitadAlto/2);

            context.strokeLine(mitadAncho,0,mitadAncho,lienzo.getHeight());
            context.strokeLine(0,mitadAlto,lienzo.getWidth(),mitadAlto);

            int divisiones=mitadAlto/valor;
            for(int i=0;i<valor;i++){
                context.strokeLine(mitadAncho,divisiones*i,mitadAncho+(divisiones*i),mitadAlto);
                context.strokeLine(mitadAncho,lienzo.getWidth()-(divisiones*i),mitadAncho-(divisiones*i),mitadAlto);
                context.strokeLine(mitadAlto,divisiones*i,mitadAncho-(divisiones*i),mitadAncho);
                context.strokeLine(mitadAncho,lienzo.getWidth()-(divisiones*i),mitadAncho+(divisiones*i),mitadAlto);
               // context.strokeLine(lienzo.getWidth(),lienzo.getHeight(),mitadx2Ancho+(divisiones*i),mitadAlto);
                context.strokeLine(mitadAlto+(divisiones*i),mitadAncho+(divisiones*i),lienzo.getHeight(),lienzo.getWidth());
               // context.strokeLine(mitadAncho,mitadAlto,lienzo.getHeight(),mitadx2Alto-(divisiones*i));
            }



        }
        else if(comboOpciones.getSelectionModel().getSelectedIndex()==4){
            //Curvas
            int divisiones=(int)lienzo.getWidth()/valor;
            for (int x=1;x<valor+1;x++){
                context.strokeLine(0,divisiones*x,divisiones*x,lienzo.getHeight());
                context.strokeLine(lienzo.getWidth(),divisiones*x,lienzo.getWidth()-(divisiones*x),lienzo.getHeight());
                context.strokeLine(0,lienzo.getWidth()-(divisiones*x),divisiones*x,0);
                context.strokeLine(lienzo.getWidth(),lienzo.getWidth()-(divisiones*x),lienzo.getWidth()-(divisiones*x),0);
            }
        }
        else if (comboOpciones.getSelectionModel().getSelectedIndex()==5){
            //Estrella Tapiz
        }

    }

    public void cambiarColor(ActionEvent event){
        colorPincel=colorPicker.getValue();
    }
    public void arrastrar(MouseEvent event){
        context.setFill(colorPincel);
        context.fillOval(event.getX(),event.getY(),10,10);
    }
    public void borrar(ActionEvent event){
       // context.setFill(Color.WHITESMOKE);
       // context.fillRect(0,0,lienzo.getWidth(),lienzo.getHeight());
        colorPincel=Color.WHITESMOKE;
    }



}
