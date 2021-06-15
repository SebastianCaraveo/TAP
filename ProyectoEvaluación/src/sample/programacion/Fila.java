package sample.programacion;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Fila {
   /* public StringProperty id;
    public StringProperty name;
    public StringProperty description;
    public StringProperty price;
    public StringProperty stock;*/
   public String id;
    public String name;
    public String description;
    public String price;
    public String stock;

   /* public Fila(StringProperty id, StringProperty name, StringProperty description, StringProperty price, StringProperty stock) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.stock = stock;
    }*/

    public Fila(String id, String name, String description, String price, String stock, String image) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.stock = stock;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }
}
