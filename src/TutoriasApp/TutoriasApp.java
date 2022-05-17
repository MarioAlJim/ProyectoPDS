package TutoriasApp;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class TutoriasApp extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        //Parent root = FXMLLoader.load(getClass().getResource("/uv/gui/interfaces/RegistrarTutorAcademicoGUI.fxml"));
        //Parent root = FXMLLoader.load(getClass().getResource("/uv/gui/interfaces/ConsultarOfertaAcademicaGUI.fxml"));
        //Parent root = FXMLLoader.load(getClass().getResource("/uv/gui/interfaces/ConsultarTutorGUI.fxml"));
        Parent root = FXMLLoader.load(getClass().getResource("/uv/gui/interfaces/inicioSesionGUI.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}