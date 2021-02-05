package sample.Estructuras;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Inventario {
    SimpleIntegerProperty codigo;
    SimpleStringProperty modelo;
    SimpleStringProperty capacidad;
    SimpleStringProperty condicion;
    SimpleIntegerProperty precio;
    SimpleIntegerProperty unidades;

    public Inventario(int codigo, String modelo, String capacidad, String condicion, int precio, int unidades) {
        this.codigo = new SimpleIntegerProperty(codigo);
        this.modelo = new SimpleStringProperty(modelo);
        this.capacidad = new SimpleStringProperty(capacidad);
        this.condicion = new SimpleStringProperty(condicion);
        this.precio = new SimpleIntegerProperty(precio);
        this.unidades = new SimpleIntegerProperty(unidades);
    }

    public int getCodigo() {
        return codigo.get();
    }

    public SimpleIntegerProperty codigoProperty() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo.set(codigo);
    }

    public String getModelo() {
        return modelo.get();
    }

    public SimpleStringProperty modeloProperty() {
        return modelo;
    }

    public void setModelo(String marca) {
        this.modelo.set(marca);
    }

    public String getCapacidad() {
        return capacidad.get();
    }

    public SimpleStringProperty capacidadProperty() {
        return capacidad;
    }

    public void setCapacidad(String capacidad) {
        this.capacidad.set(capacidad);
    }

    public String getCondicion() {
        return condicion.get();
    }

    public SimpleStringProperty CondicionProperty() {
        return condicion;
    }

    public void setCondicion(String condicion) {
        this.condicion.set(condicion);
    }

    public int getPrecio() {
        return precio.get();
    }

    public SimpleIntegerProperty precioProperty() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio.set(precio);
    }

    public int getUnidades() {
        return unidades.get();
    }

    public SimpleIntegerProperty unidadesProperty() {
        return unidades;
    }

    public void setUnidades(int unidades) {
        this.unidades.set(unidades);
    }
}