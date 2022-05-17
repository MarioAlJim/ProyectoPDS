package uv.fei.tutorias.bussinesslogic;

import uv.fei.tutorias.dataaccess.DataBaseConnection;
import uv.fei.tutorias.domain.OfertaAcademica;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import org.apache.log4j.Logger;

public class OfertaAcademicaDAO implements IOfertaAcademicaDAO{
    
    final static Logger log = Logger.getLogger(OfertaAcademicaDAO.class);

    @Override
    public ArrayList<OfertaAcademica> obtenerOfertaAcademicaGeneral() {
        ArrayList<OfertaAcademica> ofertaAcademicas= new ArrayList<>();
        DataBaseConnection dataBaseConnection = new DataBaseConnection();
        try(Connection connection=dataBaseConnection.getConnection()){
            String query=
                    ("SELECT ee.NRC NRC, deep.IdDocenteEEPrograma, ee.Nombre Experiencia, CONCAT_WS(' ', d.Nombre, d.ApellidoPaterno, d.APellidoMaterno) Docente, pe.Nombre Programa FROM docenteseeprogramas deep " +
                        "right join experienciaseducativas ee on ee.NRC = deep.NRC " +
                        "right join docentes d on d.NumPersonal = deep.NumPersonal " +
                        "inner join programaseducativos pe on pe.IdProgramaEducativo = deep.IdProgramaEducativo");
            PreparedStatement statement=connection.prepareStatement(query);
            ResultSet resultSet=statement.executeQuery();
            if (!resultSet.next()){
                throw new SQLException("No se encontraron datos");
            }else{
                int idOfertaAcademica;
                String nrc;
                String ee;
                String docente;
                String programaEducativo;
                do {
                    nrc = resultSet.getString("NRC");
                    idOfertaAcademica = resultSet.getInt("IdDocenteEEPrograma");
                    ee = resultSet.getString("Experiencia");
                    docente = resultSet.getString("Docente");
                    programaEducativo = resultSet.getString("Programa");
                    OfertaAcademica ofertaAcademica = new OfertaAcademica();
                    ofertaAcademica.setNrc(nrc);
                    ofertaAcademica.setIdOfertaAcademica(idOfertaAcademica);
                    ofertaAcademica.setEe(ee);
                    ofertaAcademica.setDocente(docente);
                    ofertaAcademica.setProgramaEducativo(programaEducativo);
                    ofertaAcademicas.add(ofertaAcademica);
                }while (resultSet.next());
            }
        }catch (SQLException ex) {
            log.fatal(ex);
        }
        return ofertaAcademicas;
    }

    @Override
    public ArrayList<OfertaAcademica> consultarOfertaAcademicaPorProgramaEducativo(String programaEducativoSeleccionado) {
        ArrayList<OfertaAcademica> ofertaAcademicas= new ArrayList<>();
        DataBaseConnection dataBaseConnection = new DataBaseConnection();
        try(Connection connection=dataBaseConnection.getConnection()){
            String query=
                    ("SELECT ee.NRC NRC, deep.IdDocenteEEPrograma, ee.Nombre Experiencia, CONCAT_WS(' ', d.Nombre, d.ApellidoPaterno, d.APellidoMaterno) Docente, pe.Nombre Programa " +
                            "FROM docenteseeprogramas deep " +
                            "right join experienciaseducativas ee on ee.NRC = deep.NRC " +
                            "right join docentes d on d.NumPersonal = deep.NumPersonal " +
                            "inner join programaseducativos pe on pe.IdProgramaEducativo = deep.IdProgramaEducativo " +
                            "Where pe.Nombre = ?");
            PreparedStatement statement=connection.prepareStatement(query);
            statement.setString(1, programaEducativoSeleccionado);
            ResultSet resultSet=statement.executeQuery();
            if (!resultSet.next()){
                throw new SQLException("No se encontraron datos");
            }else{
                int idOfertaAcademica;
                String ee;
                String docente;
                String programaEducativo;
                String nrc;
                do {
                    nrc = resultSet.getString("NRC");
                    idOfertaAcademica = resultSet.getInt("IdDocenteEEPrograma");
                    ee = resultSet.getString("Experiencia");
                    docente = resultSet.getString("Docente");
                    programaEducativo = resultSet.getString("Programa");
                    OfertaAcademica ofertaAcademica = new OfertaAcademica();
                    ofertaAcademica.setNrc(nrc);
                    ofertaAcademica.setIdOfertaAcademica(idOfertaAcademica);
                    ofertaAcademica.setEe(ee);
                    ofertaAcademica.setDocente(docente);
                    ofertaAcademica.setProgramaEducativo(programaEducativo);
                    ofertaAcademicas.add(ofertaAcademica);
                }while (resultSet.next());
            }
        }catch (SQLException ex) {
            log.fatal(ex);
        }
        return ofertaAcademicas;
    }
}
