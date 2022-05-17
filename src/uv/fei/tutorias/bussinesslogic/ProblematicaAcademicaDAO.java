package uv.fei.tutorias.bussinesslogic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uv.fei.tutorias.dataaccess.DataBaseConnection;
import uv.fei.tutorias.domain.ProblematicaAcademica;
import org.apache.log4j.Logger;


public class ProblematicaAcademicaDAO implements IPoblematicaAcademicaDAO{
    
    final static Logger log = Logger.getLogger(HorarioDAO.class);
    
    @Override
    public List<ProblematicaAcademica> consultarTodasLasProblematicas() {
        ArrayList<ProblematicaAcademica> problematicasAcademicas= new ArrayList<>();
        DataBaseConnection dataBaseConnection = new DataBaseConnection();
        try(Connection connection=dataBaseConnection.getConnection()){
            String query="SELECT * FROM tutoriasproblematicasacademicas;";
            PreparedStatement statement=connection.prepareStatement(query);
            ResultSet resultSet=statement.executeQuery();
            if (!resultSet.next()){
                throw new SQLException("No se encontraron problematicas");
            }else{
                int idProblematicaAcademica;
                String descripcion;
                String solucion;
                int idDocentesEeProgramas;
                int idHorario;
                do {
                    idProblematicaAcademica = resultSet.getInt("IdProblemaAcademica");
                    descripcion = resultSet.getString("Descripcion");
                    solucion = resultSet.getString("Solucion");
                    idDocentesEeProgramas = resultSet.getInt("IdDocentesEEProgramas");
                    idHorario = resultSet.getInt("IdHorario");
                    ProblematicaAcademica problematicaAcademica = new ProblematicaAcademica();
                    problematicaAcademica.setIdProblematicaAcademica(idProblematicaAcademica);
                    problematicaAcademica.setDescripcion(descripcion);
                    problematicaAcademica.setSolucion(solucion);
                    problematicaAcademica.setIdDocenteEePrograma(idDocentesEeProgramas);
                    problematicaAcademica.setIdHorario(idHorario);
                    problematicasAcademicas.add(problematicaAcademica);
                }while (resultSet.next());
            }
        }catch (SQLException ex) {
            log.fatal(ex);
        }
        return problematicasAcademicas;
    }

    @Override
    public List<ProblematicaAcademica> consultarProblematicaPorId(int idProblematicaAcademicaBuscada) {
        ArrayList<ProblematicaAcademica> problematicasAcademicas= new ArrayList<>();
        DataBaseConnection dataBaseConnection = new DataBaseConnection();
        try(Connection connection=dataBaseConnection.getConnection()){
            String query="SELECT * FROM tutoriasproblematicasacademicas WHERE IdProblemaAcademica = ?";
            PreparedStatement statement=connection.prepareStatement(query);
            statement.setInt(1, idProblematicaAcademicaBuscada);
            ResultSet resultSet=statement.executeQuery();
            if (!resultSet.next()){
                throw new SQLException("No se encontraron problematicas");
            }else{
                int idProblematicaAcademica;
                String descripcion;
                String solucion;
                int idDocentesEeProgramas;
                int idHorario;
                do {
                    idProblematicaAcademica = resultSet.getInt("IdProblemaAcademica");
                    descripcion = resultSet.getString("Descripcion");
                    solucion = resultSet.getString("Solucion");
                    idDocentesEeProgramas = resultSet.getInt("IdDocentesEEProgramas");
                    idHorario = resultSet.getInt("IdHorario");
                    ProblematicaAcademica problematicaAcademica = new ProblematicaAcademica();
                    problematicaAcademica.setIdProblematicaAcademica(idProblematicaAcademica);
                    problematicaAcademica.setDescripcion(descripcion);
                    problematicaAcademica.setSolucion(solucion);
                    problematicaAcademica.setIdDocenteEePrograma(idDocentesEeProgramas);
                    problematicaAcademica.setIdHorario(idHorario);
                    problematicasAcademicas.add(problematicaAcademica);
                }while (resultSet.next());
            }
        }catch (SQLException ex) {
            log.fatal(ex);
        }
        return problematicasAcademicas;
    }

    @Override
    public int registrarProblematicaAcademica(ProblematicaAcademica problematicaAcademica) {
        DataBaseConnection dataBaseConnection = new DataBaseConnection();
        int filasInsertadas = 0;
        try(Connection connection=dataBaseConnection.getConnection()){
            String descripcion = problematicaAcademica.getDescripcion();
            String solucion = problematicaAcademica.getSolucion();
            int idDocenteEePrograma = problematicaAcademica.getIdDocenteEePrograma();
            int idHorario = problematicaAcademica.getIdHorario();
            String query =
                    "INSERT INTO tutoriasproblematicasacademicas (Descripcion, Solucion, IdDocentesEEProgramas, IdHorario) " +
                    "VALUES ( ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, descripcion);
            statement.setString(2, solucion);
            statement.setInt(3, idDocenteEePrograma);
            statement.setInt(4, idHorario);
            filasInsertadas = statement.executeUpdate();
            System.out.println(filasInsertadas + " Fila insertada ");
        } catch (SQLException ex) {
            log.fatal(ex);
        }
        return filasInsertadas;
    }

    @Override
    public int actualizarProblematica(ProblematicaAcademica problematicaAcademica) {
        DataBaseConnection dataBaseConnection = new DataBaseConnection();
        int filasActualizadas = 0;
        try(Connection connection=dataBaseConnection.getConnection()){
            int idProblematicaAcademica = problematicaAcademica.getIdProblematicaAcademica();
            String descripcion = problematicaAcademica.getDescripcion();
            String solucion = problematicaAcademica.getSolucion();
            int idDocenteEePrograma = problematicaAcademica.getIdDocenteEePrograma();
            int idHorario = problematicaAcademica.getIdHorario();
            String query;
            query = ("UPDATE tutoriasproblematicasacademicas SET Descripcion = ?, Solucion = ?, IdDocentesEEProgramas = ?, IdHorario = ? WHERE IdProblemaAcademica = ?");
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, descripcion);
            statement.setString(2, solucion);
            statement.setInt(3, idDocenteEePrograma);
            statement.setInt(4, idHorario);
            statement.setInt(5, idProblematicaAcademica);
            filasActualizadas = statement.executeUpdate();
            System.out.println(filasActualizadas + " filas modificadas");
        } catch (SQLException ex) {
            log.fatal(ex);
        }
        return filasActualizadas;
    }

    @Override
    public int eliminarProblematica(int idProblematicaAcademica) {
        DataBaseConnection dataBaseConnection = new DataBaseConnection();
        int filasEliminadas = 0;
        try(Connection connection=dataBaseConnection.getConnection()){
            String query = "DELETE FROM tutoriasproblematicasacademicas WHERE IdProblemaAcademica = ?";
            PreparedStatement statement=connection.prepareStatement(query);
            statement.setInt(1, idProblematicaAcademica);
            filasEliminadas = statement.executeUpdate();
            System.out.println(filasEliminadas + " Fila eiminada");
        } catch (SQLException ex) {
            log.fatal(ex);
        }
        return filasEliminadas;
    }
}
