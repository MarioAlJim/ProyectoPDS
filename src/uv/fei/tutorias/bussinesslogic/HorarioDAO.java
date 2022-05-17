package uv.fei.tutorias.bussinesslogic;

import uv.fei.tutorias.dataaccess.DataBaseConnection;
import uv.fei.tutorias.domain.Horario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;

public class HorarioDAO implements IHorarioDAO{

    final static Logger log = Logger.getLogger(HorarioDAO.class);

    @Override
    public List<Horario> consultarTodosLosHorarios() {
        ArrayList<Horario> horarios= new ArrayList<>();
        DataBaseConnection dataBaseConnection = new DataBaseConnection();
        try(Connection connection=dataBaseConnection.getConnection()){
            String query="SELECT * FROM horarios;";
            PreparedStatement statement=connection.prepareStatement(query);
            ResultSet resultSet=statement.executeQuery();
            if (!resultSet.next()){
                throw new SQLException("No se encontraron horarios");
            }else{
                int  idHorario;
                String hora;
                int idTutoria;
                String matricula;
                do {
                    idHorario = resultSet.getInt("IdHorario");
                    hora = resultSet.getString("HoraInicio");
                    idTutoria = resultSet.getInt("Idtutoria");
                    matricula = resultSet.getString("Matricula");
                    Horario horario = new Horario();
                    horario.setIdHorario(idHorario);
                    horario.setHora(hora);
                    horario.setIdTutoria(idTutoria);
                    horario.setMatricula(matricula);
                    horarios.add(horario);
                }while (resultSet.next());
            }
        }catch (SQLException ex) {
           log.fatal(ex);
        }
        return horarios;
    }

    @Override
    public List<Horario> consultarHorarioporId(int idHorarioBuscado) {
        ArrayList<Horario> horarios= new ArrayList<>();
        DataBaseConnection dataBaseConnection = new DataBaseConnection();
        try(Connection connection=dataBaseConnection.getConnection()){
            String query="SELECT * FROM horario WHERE IdHorario = ?";
            PreparedStatement statement=connection.prepareStatement(query);
            statement.setInt(1, idHorarioBuscado);
            ResultSet resultSet=statement.executeQuery();
            if (!resultSet.next()){
                throw new SQLException("No se encontraron horarios");
            }else{
                int idHorario;
                String hora;
                int idTutoria;
                String matricula;
                do {
                    idHorario = resultSet.getInt("IdHorario");
                    hora = resultSet.getString("HoraInicio");
                    idTutoria = resultSet.getInt("Idtutoria");
                    matricula = resultSet.getString("Matricula");
                    Horario horario = new Horario();
                    horario.setIdHorario(idHorario);
                    horario.setHora(hora);
                    horario.setIdTutoria(idTutoria);
                    horario.setMatricula(matricula);
                    horarios.add(horario);
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
        return horarios;
    }

    @Override
    public int registrarHorario(Horario horario) {
        DataBaseConnection dataBaseConnection = new DataBaseConnection();
        int filasInsertadas = 0;
        try(Connection connection=dataBaseConnection.getConnection()){
            String hora = horario.getHora();
            int idTutoria = horario.getIdTutoria();
            String matricula = horario.getMatricula();
            String query = "INSERT INTO horario (HoraInicio, IdTutoria, Matricula) VALUES (?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, hora);
            statement.setInt(2, idTutoria);
            statement.setString(3, matricula);
            filasInsertadas = statement.executeUpdate();
        } catch (SQLException ex) {
            log.error(ex);
        }
        return filasInsertadas;
    }

    @Override
    public int actualizarHorario(Horario horario) {
        DataBaseConnection dataBaseConnection = new DataBaseConnection();
        int filasActualizadas = 0;
        try(Connection connection=dataBaseConnection.getConnection()){
            int idHorario = horario.getIdHorario();
            String hora = horario.getHora();
            int idTutoria = horario.getIdTutoria();
            String matricula = horario.getMatricula();
            String query =
                    ("UPDATE horario SET HoraInicio = ?, IdTutoria = ?, Matricula = ? WHERE IdHorario = ?");
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, hora);
            statement.setInt(2, idTutoria);
            statement.setString(3, matricula);
            statement.setInt(4, idHorario);
            filasActualizadas = statement.executeUpdate();
            System.out.println(filasActualizadas + " filas modificadas");
        } catch (SQLException ex) {
            log.fatal(ex);
        }
        return filasActualizadas;
    }

    @Override
    public int eliminarHorario(int idHorario) {
        DataBaseConnection dataBaseConnection = new DataBaseConnection();
        int filasEliminadas = 0;
        try(Connection connection=dataBaseConnection.getConnection()){
            String query = "DELETE FROM horario WHERE IdHorario = ?";
            PreparedStatement statement=connection.prepareStatement(query);
            statement.setInt(1, idHorario);
            filasEliminadas = statement.executeUpdate();
            System.out.println(filasEliminadas + " Fila eiminada");
        } catch (SQLException ex) {
            log.error(ex);
        }
        return filasEliminadas;
    }
}
