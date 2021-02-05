package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import sample.Estructuras.Busquedas;
import sample.Estructuras.Inventario;
import sample.Estructuras.Ordenamiento;

import java.io.IOException;

public class ControllerInv {
    @FXML TableView tabla;
    @FXML Label nombreUsuario;
    @FXML TextField numeroBus;
    TableColumn columnCodigo = new TableColumn("Código");
    TableColumn columnModelo = new TableColumn("Modelo");
    TableColumn columnCapacidad = new TableColumn("Capacidad");
    TableColumn columnCondicion = new TableColumn("Condicion");
    TableColumn columnPrecio = new TableColumn("Precio $");
    TableColumn columnUnidades = new TableColumn("Unidades");
    ObservableList<Inventario> listaInventarios = FXCollections.observableArrayList();
    Inventario[] arreglo = new Inventario[6];
    @FXML protected void  initialize(){
        nombreUsuario.setText(Main.nombreUsuario);
        arreglo[0] = new Inventario(101,"Xbox360", "500", "Usado",1500,26);
        arreglo[1] =new Inventario(102,"XboxOne", "1 TB", "Refabricado",3990,46);
        arreglo[2] =new Inventario(103,"SeriesS", "2 TB", "Nuevo",4550,111);
        arreglo[3] =new Inventario(104,"SeriesX", "2 TB", "Nuevo",8000,31);
        arreglo[4] =new Inventario(105,"Switch", "Expandible", "Nuevo",7560,410);
        arreglo[5] =new Inventario(106,"PS4", "1 TB", "Nuevo",4240,160);
        columnCodigo.setCellValueFactory(new PropertyValueFactory<Inventario,Integer>("codigo"));
        columnModelo.setCellValueFactory(new PropertyValueFactory<Inventario,String>("modelo"));
        columnCapacidad.setCellValueFactory(new PropertyValueFactory<Inventario,String>("capacidad"));
        columnCondicion.setCellValueFactory(new PropertyValueFactory<Inventario,String>("condicion"));
        columnPrecio.setCellValueFactory(new PropertyValueFactory<Inventario,Integer>("precio"));
        columnUnidades.setCellValueFactory(new PropertyValueFactory<Inventario,Integer>("unidades"));
        tabla.getColumns().addAll(columnCodigo,columnModelo,columnCapacidad,columnCondicion,columnPrecio,columnUnidades);
        tabla.setItems(listaInventarios);
        listaInventarios.add(arreglo[0]);
        listaInventarios.add(arreglo[1]);
        listaInventarios.add(arreglo[2]);
        listaInventarios.add(arreglo[3]);
        listaInventarios.add(arreglo[4]);
        listaInventarios.add(arreglo[5]);
    }
    public void regresar(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Cobro.fxml"));
        Scene scene = new Scene(root);
        Main.stage.setScene(scene);
    }
    public void burbuja(ActionEvent event){
        Ordenamiento ordenar = new Ordenamiento();
        Inventario[] ordenado = ordenar.burbujaPrecio(arreglo);
        listaInventarios.clear();
        listaInventarios.add(ordenado[0]);
        listaInventarios.add(ordenado[1]);
        listaInventarios.add(ordenado[2]);
        listaInventarios.add(ordenado[3]);
        listaInventarios.add(ordenado[4]);
        listaInventarios.add(ordenado[5]);
    }
    public void ShellSort(ActionEvent event){
        Ordenamiento ordenar = new Ordenamiento();
        Inventario[] ordenado = ordenar.ShellSortStoke(arreglo);
        listaInventarios.clear();
        listaInventarios.add(ordenado[0]);
        listaInventarios.add(ordenado[1]);
        listaInventarios.add(ordenado[2]);
        listaInventarios.add(ordenado[3]);
        listaInventarios.add(ordenado[4]);
        listaInventarios.add(ordenado[5]);
    }
    public void binario(ActionEvent event){
        Ordenamiento ordenar = new Ordenamiento();
        Busquedas busquedas = new Busquedas();
        int codB;
        try{
             codB = Integer.parseInt(numeroBus.getText());
            if(codB>=101 && codB<=106){
                codB = Integer.parseInt(numeroBus.getText());
                Inventario[] ordenado = ordenar.burbujaCodigo(arreglo);
                listaInventarios.clear();
                listaInventarios.add(ordenado[0]);
                listaInventarios.add(ordenado[1]);
                listaInventarios.add(ordenado[2]);
                listaInventarios.add(ordenado[3]);
                listaInventarios.add(ordenado[4]);
                listaInventarios.add(ordenado[5]);
                int buscado = busquedas.binario(arreglo, codB);
                Alert alert=new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Center Game UwU");
                alert.setContentText("El código buscado esta en la posicion " + buscado + " de la tabla");
                alert.show();
            }else {
                Alert alert=new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Center Game UwU");
                alert.setContentText("El código introducido no se encuentra en la tabla");
                alert.show();
            }
        } catch (NumberFormatException e) {
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Center Game UwU");
            alert.setContentText("No se ha introducido ningún código, favor de ingresar uno");
            alert.show();
        }
    }
    public void cerrarSesion (ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        Scene scene = new Scene(root);
        Main.stage.setScene(scene);
    }
}
