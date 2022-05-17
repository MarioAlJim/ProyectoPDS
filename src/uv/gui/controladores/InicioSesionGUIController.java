
package uv.gui.controladores;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import uv.fei.tutorias.domain.Usuario;
import uv.fei.tutorias.bussinesslogic.UsuarioDAO;
import javax.swing.*;

public class InicioSesionGUIController implements Initializable {

    @FXML
    private PasswordField lblContrasenia;
    @FXML
    private TextField lblUsuario;
    @FXML
    private Button btnIniciarSesion;
    @FXML
    private Label txtContrasena;
    @FXML
    private Label txtUsuario;
    @FXML
    private Label txtTitulo;


    private void validarUsuarioBD(String cuentaUV, String contrasena){
        UsuarioDAO userDAO = new UsuarioDAO();
        Usuario usuarioEntrada = new Usuario();
        usuarioEntrada.setContrasenia(contrasena);
        usuarioEntrada.setCuentaUV(cuentaUV);
        Usuario usuarioRecuperado = userDAO.recuperarSesion(cuentaUV, contrasena);
        if(usuarioRecuperado.equals(usuarioEntrada)){
            JOptionPane.showMessageDialog(null, "Usuario encontrado");
        }else {
            JOptionPane.showMessageDialog(null, "Usuario no encontrado");
            lblContrasenia.setText("");
            lblUsuario.setText("");
        }
    }
    
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    

    @FXML
    private void iniciarSesion(ActionEvent event) {
        String cuentaUV = lblUsuario.getText();
        String contrasena = lblContrasenia.getText();

        if(cuentaUV.isEmpty()){

        }else if(contrasena.isEmpty()){

        }else {
            validarUsuarioBD(cuentaUV, contrasena);
        }
    }
    
}
