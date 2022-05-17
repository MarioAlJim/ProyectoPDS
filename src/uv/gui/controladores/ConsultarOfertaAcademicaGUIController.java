package uv.gui.controladores;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import uv.fei.tutorias.bussinesslogic.ProgramaEducativoDAO;
import uv.fei.tutorias.domain.OfertaAcademica;
import uv.fei.tutorias.bussinesslogic.OfertaAcademicaDAO;
import uv.fei.tutorias.domain.ProgramaEducativo;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;


public class ConsultarOfertaAcademicaGUIController implements Initializable {

    @FXML
    private TableView<OfertaAcademica> tblOfertaAcademica;
    @FXML
    private TableColumn colNRC;
    @FXML
    private TableColumn colExperiencia;
    @FXML
    private TableColumn colDocente;
    @FXML
    private TableColumn colProgramaEducativo;
    @FXML
    private Button btnCerrarVentana;
    @FXML
    private ChoiceBox cbbSeleccionProgramaEducativo;

    ObservableList<String> opcionesCombo;
    /**
     * Initializes the controller class.
    */

    private void inicializarTablaOfertaAcademica() {
        colNRC.setCellValueFactory(new PropertyValueFactory <OfertaAcademica, String>("nrc"));
        colExperiencia.setCellValueFactory(new PropertyValueFactory <OfertaAcademica, String>("ee"));
        colDocente.setCellValueFactory(new PropertyValueFactory <OfertaAcademica, String>("docente"));
        colProgramaEducativo.setCellValueFactory(new PropertyValueFactory <OfertaAcademica, String>("programaEducativo"));

        OfertaAcademicaDAO ofertasAcacemicasdao = new OfertaAcademicaDAO();
        ArrayList<OfertaAcademica> ofertasAcacemicas;
        ofertasAcacemicas = ofertasAcacemicasdao.obtenerOfertaAcademicaGeneral();

        ObservableList<OfertaAcademica> ofertaAcademicaTabla = FXCollections.observableArrayList();
        for (OfertaAcademica ofertaAcademica1 : ofertasAcacemicas) {
            ofertaAcademicaTabla.add(ofertaAcademica1);
        }
        
        tblOfertaAcademica.setItems(ofertaAcademicaTabla);
    }
    
    private void actualizarPorOferta (){
        opcionesCombo = FXCollections.observableArrayList();
        ProgramaEducativoDAO programaEducativoDAO = new ProgramaEducativoDAO();
        ArrayList<ProgramaEducativo> programasEducativos = programaEducativoDAO.consultarTodosLosProgramasEducativos();

        opcionesCombo.add("Vista general");
        for(ProgramaEducativo programaEducativo : programasEducativos){
            opcionesCombo.add(programaEducativo.getNombre());
        }
        cbbSeleccionProgramaEducativo.setItems(opcionesCombo);
        cbbSeleccionProgramaEducativo.getSelectionModel().select(0);

        cbbSeleccionProgramaEducativo.valueProperty().addListener(new ChangeListener<String>(){

            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                colNRC.setCellValueFactory(new PropertyValueFactory <OfertaAcademica, String>("nrc"));
                colExperiencia.setCellValueFactory(new PropertyValueFactory <OfertaAcademica, String>("ee"));
                colDocente.setCellValueFactory(new PropertyValueFactory <OfertaAcademica, String>("docente"));
                colProgramaEducativo.setCellValueFactory(new PropertyValueFactory <OfertaAcademica, String>("programaEducativo"));
                ObservableList<OfertaAcademica> ofertaAcademicaTabla = FXCollections.observableArrayList();
                OfertaAcademicaDAO ofertasAcacemicasdao = new OfertaAcademicaDAO();
                ArrayList<OfertaAcademica> ofertasAcacemicas = new ArrayList<>();

                if(newValue == "Vista general"){
                    ofertasAcacemicas = ofertasAcacemicasdao.obtenerOfertaAcademicaGeneral();
                    for (OfertaAcademica ofertaAcademica1 : ofertasAcacemicas) {
                        ofertaAcademicaTabla.add(ofertaAcademica1);
                    }
                }else {
                    ofertasAcacemicas = ofertasAcacemicasdao.consultarOfertaAcademicaPorProgramaEducativo(newValue);
                    for (OfertaAcademica ofertaAcademica1 : ofertasAcacemicas) {
                        ofertaAcademicaTabla.add(ofertaAcademica1);
                    }
                }
                tblOfertaAcademica.setItems(ofertaAcademicaTabla);

            }

        });
    }

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.inicializarTablaOfertaAcademica();
        this.actualizarPorOferta();
    }

    @FXML
    private void cerrarVentana(ActionEvent event) {

    }
    
}
