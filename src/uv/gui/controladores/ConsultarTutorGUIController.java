package uv.gui.controladores;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import uv.fei.tutorias.bussinesslogic.TutoradoDAO;
import uv.fei.tutorias.bussinesslogic.TutorDAO;
import uv.fei.tutorias.domain.OfertaAcademica;
import uv.fei.tutorias.domain.Tutorado;
import uv.fei.tutorias.domain.Tutor;
import javafx.collections.ListChangeListener;
import javafx.event.ActionEvent;


public class ConsultarTutorGUIController implements Initializable {

    @FXML
    private TableView<Tutor> tblTutores;
    @FXML
    private TableColumn colNumTutor;
    @FXML
    private TableColumn colNombre;
    @FXML
    private TableColumn colApellidoPaterno;
    @FXML
    private TableColumn colApellidoMaterno;
    @FXML
    private Button btnCerrarVentana;
    @FXML
    private Label lblNombre;
    @FXML
    private Label lblCorreo;
    @FXML
    private Label lblCuenta;
    @FXML
    private Label idTitulo;
    @FXML
    private TableView<Tutorado> tblTutorados;
    @FXML
    private Button btnCerrarTutor;
    @FXML
    private TableColumn colNombreTutorado;
    @FXML
    private TableColumn colApellidoPaternoTutorado;
    @FXML
    private TableColumn colApellidoMaternoTutorado;
    @FXML
    private TableColumn colMatriculaTutorado;


    private void inicializarTablaTutores() {
        colNombre.setCellValueFactory(new PropertyValueFactory <OfertaAcademica, String>("nombre"));
        colApellidoPaterno.setCellValueFactory(new PropertyValueFactory <OfertaAcademica, String>("apellidoPaterno"));
        colApellidoMaterno.setCellValueFactory(new PropertyValueFactory <OfertaAcademica, String>("apellidoMaterno"));

        TutorDAO tutorDAO = new TutorDAO();
        ArrayList<Tutor> tutores = new ArrayList<>();
        tutores = tutorDAO.consultarTodoslosTutores();

        ObservableList<Tutor> tutoresObservableList = FXCollections.observableArrayList();
        for (Tutor tutores1 : tutores) {
            tutoresObservableList.add(tutores1);
        }

        tblTutores.setItems(tutoresObservableList);
    }


    private final ListChangeListener<Tutor> selectorTablaTutores = new ListChangeListener<Tutor>() {
                @Override
                public void onChanged(ListChangeListener.Change<? extends Tutor> c) {
                    mostrarDatosTutor();
                }
            };
    public Tutor getTablaTutorSeleccionado() {
        if (tblTutores != null) {
            List<Tutor> tabla = tblTutores.getSelectionModel().getSelectedItems();
            if (tabla.size() == 1) {
                final Tutor tutorSeleccionado = tabla.get(0);
                return tutorSeleccionado;
            }
        }
        return null;
    }
    private void mostrarDatosTutor() {
        final Tutor tutor = getTablaTutorSeleccionado();

        colMatriculaTutorado.setCellValueFactory(new PropertyValueFactory <Tutorado, String>("matricula"));
        colNombreTutorado.setCellValueFactory(new PropertyValueFactory <Tutorado, String>("nombre"));
        colApellidoPaternoTutorado.setCellValueFactory(new PropertyValueFactory <Tutorado, String>("apellidoPaterno"));
        colApellidoMaternoTutorado.setCellValueFactory(new PropertyValueFactory <Tutorado, String>("apellidoMaterno"));

        if (tutor != null) {
            String nombre = (tutor.getNombre() + " " + tutor.getApellidoPaterno() + " " + tutor.getApellidoMaterno());
            lblNombre.setText(nombre);
            lblCorreo.setText(tutor.getCorreo());
            lblCuenta.setText(tutor.getCuentaUV());

            TutoradoDAO tutoradoDAO = new TutoradoDAO();
            ArrayList<Tutorado> tutoradosdeTutor;
            tutoradosdeTutor = tutoradoDAO.buscarTutoradoPorTutor(tutor.getCuentaUV());

            ObservableList<Tutorado> tutoradosObservableList = FXCollections.observableArrayList();
            for (Tutorado tutorado1 : tutoradosdeTutor) {
                tutoradosObservableList.add(tutorado1);
            }

            tblTutorados.setVisible(true);
            tblTutorados.setItems(tutoradosObservableList);
            lblNombre.setVisible(true);
            lblCorreo.setVisible(true);
            lblCuenta.setVisible(true);
            btnCerrarTutor.setVisible(true);

            tblTutores.setVisible(false);
            idTitulo.setVisible(false);
            btnCerrarVentana.setVisible(false);
        }
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.inicializarTablaTutores();

        final ObservableList<Tutor> tablaTutorSeleccioando = tblTutores.getSelectionModel().getSelectedItems();
        tablaTutorSeleccioando.addListener(selectorTablaTutores);
    }    

    @FXML
    private void cerrarInformacionTutor(ActionEvent event) {
        tblTutorados.setVisible(false);
        lblNombre.setVisible(false);
        lblCorreo.setVisible(false);
        lblCuenta.setVisible(false);
        btnCerrarTutor.setVisible(false);

        tblTutores.setVisible(true);
        idTitulo.setVisible(true);
        btnCerrarVentana.setVisible(true);

    }
}
