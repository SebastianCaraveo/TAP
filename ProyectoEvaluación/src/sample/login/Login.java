package sample.login;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import sample.Main;

import java.io.IOException;


public class Login {
    @FXML JFXTextField txtUsuario;
    @FXML JFXPasswordField txtPassword;
    String[][] arrayUsuario=new String[2][3];
    @FXML protected void initialize() {
        arrayUsuario[0][0]="Sebas";arrayUsuario[0][1]="sebos";arrayUsuario[0][2]="1234";
        arrayUsuario[1][0]="Master";arrayUsuario[1][1]="Master 2.0";arrayUsuario[1][2]="1234";
    }
    public void cambiarPantalla(ActionEvent event) {
        ingresar();
    }
    public void enter(KeyEvent event){
        if(event.getCode() == KeyCode.ENTER){
            ingresar();
        }
    }
    public void ingresar() {
        String u=txtUsuario.getText();
        String p=txtPassword.getText();
        Busqueda busqueda= new Busqueda();
        int indice = busqueda.secuencial(arrayUsuario,u,p);
        if(indice>= 0){
            try {
                Main.nombreUsuario=arrayUsuario[indice][0];
                Parent root = FXMLLoader.load(getClass().getResource("../principal/principal.fxml"));
                Scene scene = new Scene(root);
                Main.stage.setScene(scene);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else {
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setContentText("Datos Incorrectos");
            alert.show();
        }
    }
}