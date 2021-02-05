package sample.Estructuras;

import javafx.beans.property.SimpleStringProperty;

public class Pedido {
    SimpleStringProperty tipo;
    SimpleStringProperty tamaño;
    SimpleStringProperty cantidad;
    SimpleStringProperty marca;

    public Pedido(String tipo,String tamaño, String cantidad, String marca) {
        this.tipo = new SimpleStringProperty(tipo);
        this.tamaño = new SimpleStringProperty(tamaño);
        this.cantidad = new SimpleStringProperty(cantidad);
        this.marca = new SimpleStringProperty(marca);
    }

    public String getTipo() {
        return tipo.get();
    }

    public SimpleStringProperty tipoProperty() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo.set(tipo);
    }

    public String getTamaño() {
        return tamaño.get();
    }

    public SimpleStringProperty tamañoProperty() {
        return tamaño;
    }

    public void setTamaño(String tamaño) {
        this.tamaño.set(tamaño);
    }

    public String getCantidad() {
        return cantidad.get();
    }

    public SimpleStringProperty cantidadProperty() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad.set(cantidad);
    }

    public String getMarca() {
        return marca.get();
    }

    public SimpleStringProperty marcaProperty() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca.set(marca);
    }
}
