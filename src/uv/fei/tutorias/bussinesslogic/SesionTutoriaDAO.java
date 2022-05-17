package uv.fei.tutorias.bussinesslogic;

import uv.fei.tutorias.dataaccess.DataBaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import uv.fei.tutorias.domain.SesionTutoria;

public class SesionTutoriaDAO {

    final static Logger log = Logger.getLogger(SesionTutoriaDAO.class);


    public List<SesionTutoria> consultarTodasLasSesionesDeTutoria() {
        ArrayList<SesionTutoria> sesionesTutorias= new ArrayList<>();
        DataBaseConnection dataBaseConnection = new DataBaseConnection();
        try(Connection connection=dataBaseConnection.getConnection()){
            String query="SELECT * FROM tutorias;";
            PreparedStatement statement=connection.prepareStatement(query);
            ResultSet resultSet=statement.executeQuery();
            if (!resultSet.next()){
                throw new SQLException("No se encontraron tutorias registradas");
            }else{
                int  idSesionTutoria;
                int numTutoria;
                String fechaTutoria;
                String FechaCierreReportes;
                int idPeriodo;
                do {
                    idSesionTutoria = resultSet.getInt("IdTutoria");
                    numTutoria = resultSet.getInt("numTutoria");
                    fechaTutoria = resultSet.getString("FechaTutoria");
                    FechaCierreReportes = resultSet.getString("FechaCierreReportes");
                    idPeriodo = resultSet.getInt("idPeriodo");
                    SesionTutoria sesionTutoria = new SesionTutoria();
                    sesionTutoria.setIdSesionTutoria(idSesionTutoria);
                    sesionTutoria.setNumTutoria(numTutoria);
                    sesionTutoria.setFechaTutoria(fechaTutoria);
                    sesionTutoria.setFechaCierreReportes(FechaCierreReportes);
                    sesionTutoria.setIdPeriodo(idPeriodo);
                    
                }while (resultSet.next());
            }
        }catch (SQLException ex) {
           log.fatal(ex);
        }
        return sesionesTutorias;
    }
   
    public int eliminarSesionTutoriaPorId(int idTutoria) {
        DataBaseConnection dataBaseConnection = new DataBaseConnection();
        int filasEliminadas = 0;
        try(Connection connection=dataBaseConnection.getConnection()){
            String query = "DELETE FROM tutorias WHERE IdTutoria = ?";
            PreparedStatement statement=connection.prepareStatement(query);
            statement.setInt(1, idTutoria);
            filasEliminadas = statement.executeUpdate();
            System.out.println(filasEliminadas + " Fila eliminada");
        } catch (SQLException ex) {
            log.error(ex);
        }
        return filasEliminadas;
    }
    
}
