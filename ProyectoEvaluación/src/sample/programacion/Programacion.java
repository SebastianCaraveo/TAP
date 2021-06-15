package sample.programacion;

import com.jfoenix.controls.JFXTextArea;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.util.Callback;
import javafx.util.Duration;
import sample.Models.Conexion;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class Programacion {
    @FXML AnchorPane anchorPane;
    @FXML StackPane stackPane;
    @FXML JFXTextArea txtArea;
    @FXML TextField txtnombre, txtprecio, txtdescripcion, txtexistencia;
    @FXML TableView tabla;
    @FXML Button btncancelar, btninsertar;
    ObservableList<Fila>datosTabla= FXCollections.observableArrayList();
    TableColumn colId= new TableColumn("ID");
    TableColumn colN= new TableColumn("NAME");
    TableColumn colD= new TableColumn("DESCRIPTION");
    TableColumn colP= new TableColumn("PRICE");
    TableColumn colS= new TableColumn("STOCK");
    TableColumn colE= new TableColumn("  ");
    TableColumn colM= new TableColumn("  ");
    Fila filaEdit;
    Conexion conexion;
    Callback<TableColumn<Fila, String>, TableCell<Fila, String>> celdaeditar=new Callback<TableColumn<Fila, String>, TableCell<Fila, String>>() {
        @Override
        public TableCell<Fila, String> call(TableColumn<Fila, String> filaStringTableColumn) {
           TableCell<Fila, String> cell=new TableCell<Fila, String>(){
               Button btnE=new Button("Editar");

               @Override
               protected void updateItem(String item, boolean empty) {
                   if(empty){
                       setGraphic(null);
                       setText(null);
                   }else{
                       btnE.getStyleClass().add("btnEditar");
                       btnE.setOnAction(new EventHandler<ActionEvent>() {
                           @Override
                           public void handle(ActionEvent event) {
                               filaEdit=getTableView().getItems().get(getIndex());
                               txtnombre.setText(filaEdit.getName());
                               txtdescripcion.setText(filaEdit.getDescription());
                               txtprecio.setText(filaEdit.getPrice());
                               txtexistencia.setText(filaEdit.getStock());
                               btncancelar.setVisible(true);
                               btninsertar.setText("Actualizar");
                           }//llave evento eliminar
                       });
                       setGraphic(btnE);
                       setText(null);
                   }//else
               }
           };
           return cell;
        }
    };//celdaEditar

    Callback<TableColumn<Fila, String>, TableCell<Fila, String>> celdaeliminar=new Callback<TableColumn<Fila, String>, TableCell<Fila, String>>() {
        @Override
        public TableCell<Fila, String> call(TableColumn<Fila, String> filaStringTableColumn) {
            TableCell<Fila, String> cell=new TableCell<Fila, String>(){
                Button btnEliminar=new Button("Eliminar");

                @Override
                protected void updateItem(String item, boolean empty) {
                    if(empty){
                        setGraphic(null);
                        setText(null);
                    }else{
                        btnEliminar.getStyleClass().add("btnEliminar");
                        btnEliminar.setOnAction(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent event) {
                                Alert alert=new Alert(Alert.AlertType.CONFIRMATION);
                                alert.setTitle("Eliminar registro");
                               alert.setContentText("¿Desea eliminar este registro?");
                                Optional<ButtonType> resultado=alert.showAndWait();
                                if (resultado.get()==ButtonType.OK){
                                    Fila fila=getTableView().getItems().get(getIndex());
                                    conexion.insmodel("DELETE FROM products WHERE id="+fila.getId());
                                    try {
                                        recargar();
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                }
                            }//llave evento eliminar
                        });
                        setGraphic(btnEliminar);
                        setText(null);
                    }//else
                }
            };
            return cell;
        }
    };//celdaEliminar

    @FXML public void initialize() throws SQLException {
        conexion=new Conexion();
        colId.setMinWidth(90);
        colN.setMinWidth(100);
        colD.setMinWidth(200);
        colP.setMinWidth(100);
        colS.setMinWidth(100);
        colId.setCellValueFactory(new PropertyValueFactory<Fila, String >("id"));
        colN.setCellValueFactory(new PropertyValueFactory<Fila, String >("name"));
        colD.setCellValueFactory(new PropertyValueFactory<Fila, String >("description"));
        colP.setCellValueFactory(new PropertyValueFactory<Fila, String >("price"));
        colS.setCellValueFactory(new PropertyValueFactory<Fila, String >("stock"));
        colM.setCellFactory(celdaeditar);
        colE.setCellFactory(celdaeliminar);
        tabla.getColumns().addAll(colId,colN,colD,colP,colS, colM, colE);
        tabla.setItems(datosTabla);
        recargar();

    }

    public void recargar() throws SQLException {
        ResultSet res=conexion.Consulta("SELECT * FROM products ORDER BY id DESC");
        datosTabla.clear();
        if(res!=null){
            while (res.next()){
                datosTabla.add(new Fila(
                        res.getObject("id").toString(),
                        res.getObject("name").toString(),
                        res.getObject("description").toString(),
                        res.getObject("price").toString(),
                        res.getObject("stock").toString(),
                        res.getObject("image").toString()
                        ));
            }
        }
    }

    public void insertar(ActionEvent event) throws SQLException {
        if (btninsertar.getText().equals("Actualizar")){
            String n = txtnombre.getText();
            String d = txtdescripcion.getText();
            String p = txtprecio.getText();
            String e = txtexistencia.getText();
            conexion.insmodel("UPDATE products SET " +
                    "name='"+n+"'," +
                    "description='"+d+"'," +
                    "price='"+p+"'," +
                    "stock='"+e+"'" +
                    "WHERE id="+filaEdit.getId());
            btninsertar.setText("Insertar");
            txtnombre.setText("");txtdescripcion.setText("");txtprecio.setText("");txtexistencia.setText("");
            btncancelar.setVisible(false);
            recargar();
        }else {
            if (!txtnombre.getText().trim().equals("") && !txtdescripcion.getText().trim().equals("") &&
                    !txtprecio.getText().trim().equals("") && !txtexistencia.getText().trim().equals("")) {
                String n = txtnombre.getText();
                String d = txtdescripcion.getText();
                String p = txtprecio.getText();
                String e = txtexistencia.getText();
                conexion.insmodel("INSERT INTO products(name, description, price, stock, image) VALUES ('" + n + "', '" + d + "', " + p + ", " + e + ", 'default.jpg')");
                System.out.println("INSERT INTO products(name, description, price, stock, image) VALUES ('" + n + "', '" + d + "', " + p + ", " + e + ", 'default.jpg')");
                txtnombre.setText("");
                txtdescripcion.setText("");
                txtprecio.setText("");
                txtexistencia.setText("");
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("ALERTA");
                alert.setContentText("Registro agregado correctamente");
                alert.show();
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("ERROR");
                alert.setContentText("Favor de llenar todos los campos");
                alert.show();
            }
            try {
                recargar();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void regresar(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../principal/principal.fxml"));
        Scene scene=anchorPane.getScene();
        root.translateYProperty().set(scene.getWidth());
        stackPane.getChildren().add(root);
        Timeline timeline = new Timeline();
        KeyValue ky = new KeyValue(root.translateYProperty(), 0, Interpolator.EASE_BOTH);
        KeyFrame kf= new KeyFrame(Duration.seconds(0.5), ky);
        timeline.getKeyFrames().add(kf);
        timeline.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(javafx.event.ActionEvent event) {
                stackPane.getChildren().remove(anchorPane);
            }
        });
        timeline.play();
    }

    public void cancelar(ActionEvent event){
        if(filaEdit==null){
            btninsertar.setText("Insertar");
            txtnombre.setText("");txtdescripcion.setText("");txtprecio.setText("");txtexistencia.setText("");
            btncancelar.setVisible(false);
        }
    }
}
