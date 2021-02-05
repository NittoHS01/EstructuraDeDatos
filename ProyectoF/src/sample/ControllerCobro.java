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
import sample.Estructuras.ItemPedido;
import sample.Estructuras.Pedido;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ControllerCobro {
    @FXML ComboBox comboTipo, comboTamaño, comboMarca;
    @FXML TextField txtCantidad, txtNombre;
    @FXML Label nombrePedido, nombreClinte, nombreUsuario;
    @FXML TableView tabla;
    LinkedList<String> listaTipo = new LinkedList<>();
    LinkedList<String> listaTamaño = new LinkedList<>();
    LinkedList<String> listaMarca = new LinkedList<>();
    TableColumn columnTipo = new TableColumn("Tipo");
    TableColumn columnTamaño = new TableColumn("Tamaño");
    TableColumn columnCatidad = new TableColumn("Cantidad");
    TableColumn columnMarca = new TableColumn("Condicion");
    ObservableList<Pedido> listPedidos = FXCollections.observableArrayList();
    Queue<ItemPedido> cola=new LinkedList<>();
    Stack<ItemPedido> pila = new Stack<>();
    @FXML protected void  initialize(){
        nombreUsuario.setText(Main.nombreUsuario);
        columnTipo.setCellValueFactory(new PropertyValueFactory<Pedido,String>("tipo"));
        columnTamaño.setCellValueFactory(new PropertyValueFactory<Pedido,String>("tamaño"));
        columnCatidad.setCellValueFactory(new PropertyValueFactory<Pedido,String>("cantidad"));
        columnMarca.setCellValueFactory(new PropertyValueFactory<Pedido,String>("Condicion"));

        tabla.getColumns().addAll(columnTipo,columnTamaño,columnCatidad,columnMarca);
        tabla.setItems(listPedidos);
        listaTipo.add("Xbox360");
        listaTipo.add("XboxOne");
        listaTipo.add("Series S");
        listaTipo.add("Series X");
        listaTipo.add("Switch");
        listaTipo.add("PS4");
        listaTipo.add("PS5");
        listaTamaño.add("512 GB");
        listaTamaño.add("1TB");
        listaTamaño.add("2 TB");
        listaTamaño.add("Memoria Expandible");
        listaTamaño.add("sin expancion");
        listaMarca.add("Nuevo");
        listaMarca.add("SemiNuevo");
        listaMarca.add("Usado");
        listaMarca.add("Restaurado");

        for (int i=0; i<listaTipo.size(); i++) comboTipo.getItems().add(listaTipo.get(i));
        for (int i=0; i<listaTamaño.size(); i++) comboTamaño.getItems().add(listaTamaño.get(i));
        for (int i=0; i<listaMarca.size(); i++) comboMarca.getItems().add(listaMarca.get(i));
    }
    public void insertarPedido(ActionEvent event){
        try {
            String ta=comboTipo.getSelectionModel().getSelectedItem().toString();
            String ti=comboTamaño.getSelectionModel().getSelectedItem().toString();
            String c=txtCantidad.getText();
            String m=comboMarca.getSelectionModel().getSelectedItem().toString();
            if(c.equals("")){
                Alert alert=new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Center Game UwU");
                alert.setContentText("INSERTE DATOS VALIDOS");
                alert.show();
            }else {
                listPedidos.add(new Pedido(ta, ti, c, m));
                tabla.setDisable(false);
                txtCantidad.setText("");
            }
        } catch (Exception e) {
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Center Game UwU");
            alert.setContentText("INSERTE DATOS VALIDOS");
            alert.show();
        }
    }
    public void guardarPedido(ActionEvent event){
        String n=txtNombre.getText();
        if (n.equals("")){
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Center Game UwU");
            alert.setContentText("INSERTE NOMBRE");
            alert.show();
        }else if (tabla.isDisable()==true){
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Center Game UwU");
            alert.setContentText("NO SE ENCUENTRAN DATOS EN LA TABLA");
            alert.show();
        }else {
            String[][] items = new String[listPedidos.size()][4];
            for (int i=0; i<items.length; i++){
                items[i][0]=listPedidos.get(i).getTipo();
                items[i][1]=listPedidos.get(i).getTamaño();
                items[i][2]=listPedidos.get(i).getCantidad();
                items[i][3]=listPedidos.get(i).getMarca();
            }
            ItemPedido pedido = new ItemPedido(items,txtNombre.getText());
            cola.add(pedido);
            pila.add(pedido);
            listPedidos.clear();
            txtNombre.setText("");
            tabla.setDisable(true);
        }
    }
    public void finalizar(ActionEvent event){
        try {
            ItemPedido pedido = cola.poll();
            nombrePedido.setText(pedido.getNombre());
            String[][] datos = pedido.getDatos();
            listPedidos.clear();
            for (int i=0; i<datos.length; i++){
                System.out.println(datos[i][0]);
                System.out.println(datos[i][1]);
                System.out.println(datos[i][2]);
                System.out.println(datos[i][3]);
                System.out.println();
            }
        } catch (Exception e) {
            Alert alert=new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Center Game UwU");
            alert.setContentText("No se encuentran pedidos");
            alert.show();
        }
    }
    public void status(ActionEvent event){
        try {
            ItemPedido pedido = pila.pop();
            System.out.println(pedido.getNombre());
            nombreClinte.setText(pedido.getNombre());
            String[][] datos = pedido.getDatos();
            for (int i=0; i<datos.length; i++) {
                System.out.println(datos[i][0]);
                System.out.println(datos[i][1]);
                System.out.println(datos[i][2]);
                System.out.println(datos[i][3]);
                System.out.println();
                listPedidos.add(new Pedido(datos[i][0], datos[i][1], datos[i][2], datos[i][3]));
                tabla.setDisable(false);
            }
        } catch (Exception e) {
            Alert alert=new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Center Game UwU");
            alert.setContentText("No se encuentran clientes");
            alert.show();
        }

    }
    public void limpiarTabla(ActionEvent event){
        listPedidos.clear();
    }
    public void abrirInventario(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("inventario.fxml"));
        Scene scene = new Scene(root);
        Main.stage.setScene(scene);
    }
    public void cerrarSesion (ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        Scene scene = new Scene(root);
        Main.stage.setScene(scene);
    }
}
