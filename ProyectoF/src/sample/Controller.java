package sample;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import sample.Estructuras.Busquedas;

import java.io.IOException;

public class Controller {
    @FXML TextField txtUsuario;
    @FXML PasswordField txtContraseña;
    String[][] arrayUsuarios = new String[3][3];
    @FXML protected void initialize(){
        arrayUsuarios[0][0]="Edu";arrayUsuarios[0][1]="Admin";arrayUsuarios[0][2]="1234";
        arrayUsuarios[1][0]="Profesor";arrayUsuarios[1][1]="Admin2";arrayUsuarios[1][2]="1234";
        arrayUsuarios[2][0]="Tecnico";arrayUsuarios[2][1]="Empleado";arrayUsuarios[2][2]="1234";
    }
    public void login(javafx.event.ActionEvent event) {
        ingresar();
    }
    public void enter(KeyEvent event){
        if(event.getCode() == KeyCode.ENTER){
            ingresar();
        }
    }
    public void ingresar() {
        String u=txtUsuario.getText();
        String c=txtContraseña.getText();
        Busquedas busquedas= new Busquedas();
        int indice = busquedas.secuencial(arrayUsuarios,u,c);
        if(indice>= 0){
            try {
                Main.nombreUsuario=arrayUsuarios[indice][0];
                System.out.println("Bienvenido " + arrayUsuarios[indice][0]);
                Parent root = FXMLLoader.load(getClass().getResource("Cobro.fxml"));
                Scene scene = new Scene(root);
                Main.stage.setScene(scene);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else {
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setTitle("CENTER GAMES UwU");
            alert.setContentText("DATOS INVALIDOS");
            alert.show();
        }
    }
}
