package sample;
import Pez.Pez;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;


public class Controller {
    @FXML ComboBox comboBox;
    @FXML TextField txtArreglo;
    @FXML ListView lista;
    @FXML
    public void initialize() {
        ObservableList<String> list = FXCollections.observableArrayList("Carpa", "Sardina", "Atun", "Salmon");
        comboBox.setItems(list);
    }


    Pez[] arreglo = new Pez[5];
    int conta=0;

    public void insertar(ActionEvent event){
        if(conta<5) {
            try {
                String Tipo = comboBox.getValue().toString();
                int Num = Integer.parseInt(txtArreglo.getText());
                if(Num>0 || Tipo== null){
                    arreglo[conta] = new Pez(Tipo,Num);
                    conta++;
                    txtArreglo.setText("");
                }else {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setContentText("Valor no valido(Ingrese otro valor)");
                    alert.show();
                }

            }catch (Exception error){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setContentText("Inserte un valor valido(Numero)");
                alert.show();
            }
        }else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Alerta");
            alert.setContentText("Su arreglo ya esta lleno");
            alert.show();
        }
    }

    //Boton procesar
    public void procesar(ActionEvent event){
        for (int x=0;x<conta;x++){
            lista.getItems().add("Pescado " + arreglo[x].getTipo_pez() + " nacen " +
                    arreglo[x].getnacimiento() + " por crias y " + arreglo[x].peces_por_ano() +" por cada año");
        }
    }


}
