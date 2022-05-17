package uv.fei.tutorias.bussinesslogic;

import uv.fei.tutorias.dataaccess.DataBaseConnection;
import uv.fei.tutorias.domain.Periodo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;



public class PeriodoDAO implements IPeriodoDAO {

    final static Logger log = Logger.getLogger(PeriodoDAO.class);
    
    @Override
    public List<Periodo> consultarPeriodoTodosLosPeriodos() {
        ArrayList<Periodo> periodos= new ArrayList<>();
        DataBaseConnection dataBaseConnection = new DataBaseConnection();
        try(Connection connection=dataBaseConnection.getConnection()){
            String query="SELECT * FROM periodo;";
            PreparedStatement statement=connection.prepareStatement(query);
            ResultSet resultSet=statement.executeQuery();
            if (!resultSet.next()){
                throw new SQLException("No se encontraron periodos");
            }else{
                int  idPeriodo;
                String fechaInicio;
                String fechaFin;
                do {
                    idPeriodo = resultSet.getInt("IdPeriodo");
                    fechaInicio = resultSet.getString("FechaInicio");
                    fechaFin = resultSet.getString("FechaFin");
                    Periodo periodo = new Periodo();
                    periodo.setFechaInicio(fechaInicio);
                    periodo.setFechaFin(fechaFin);
                    periodos.add(periodo);
                }while (resultSet.next());
            }
        }catch (SQLException ex) {
           log.fatal(ex);
        }
        return periodos;
    }

    @Override
    public int registrarPeriodo(Periodo periodo) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int eliminarPeriodoId(int idPeriodo) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int actualizarPeriodo(Periodo periodo) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Periodo> consultarPeriodoPorId(int idPeriodoBuscado) {
        ArrayList<Periodo> periodos= new ArrayList<>();
        DataBaseConnection dataBaseConnection = new DataBaseConnection();
        try(Connection connection=dataBaseConnection.getConnection()){
            String query="SELECT * FROM periodo WHERE IdPeriodo = ?";
            PreparedStatement statement=connection.prepareStatement(query);
            statement.setInt(1, idPeriodoBuscado);
            ResultSet resultSet=statement.executeQuery();
            if (!resultSet.next()){
                throw new SQLException("No se encontraron periodos");
            }else{
                int idPeriodo;
                String fechaInicio;
                String fechaFin;
                do {
                    idPeriodo = resultSet.getInt("IdPeriodo");
                    fechaInicio = resultSet.getString("FechaInicio");
                    fechaFin = resultSet.getString("FechaFin");
                    Periodo periodo = new Periodo();
                    periodo.setIdPeriodo(idPeriodo);
                    periodo.setFechaInicio(fechaInicio);
                    periodo.setFechaFin(fechaFin);
                    periodos.add(periodo);
                }while (resultSet.next());
            }
        }catch (SQLException ex) {
            log.fatal(ex);
            System.out.println("Código de Error: " + ex.getErrorCode() + "\n" +
                        "SLQState: " + ex.getSQLState() + "\n" +
                        "Mensaje: " + ex.getMessage() + "\n");
            Throwable t = ex.getCause();
                System.out.println("Causa: " + t + "\n");
        }
        return periodos;
    }

    
    
}
