package uv.fei.tutorias.bussinesslogic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uv.fei.tutorias.dataaccess.DataBaseConnection;
import uv.fei.tutorias.domain.Tutorado;
import org.apache.log4j.Logger;


public class TutoradoDAO implements ITutoradoDAO{
    
    final static Logger log = Logger.getLogger(TutoradoDAO.class);

    @Override
    public ArrayList<Tutorado> mostrarTodosLosTutoradosRegistrados(){
        ArrayList<Tutorado> tutorados = new ArrayList<>();
        DataBaseConnection dataBaseConnection = new DataBaseConnection();
        try(Connection connection=dataBaseConnection.getConnection()){
            String query="select * from tutorados;";
            PreparedStatement statement=connection.prepareStatement(query);
            ResultSet resultSet=statement.executeQuery();
            if (!resultSet.next()){
                throw new SQLException("No se encontraron tutorados");
            }else{
                String matricula;
                String nombre;
                String apellidoPaterno;
                String apellidoMaterno;
                String correo;
                do {
                    matricula = resultSet.getString("Matricula");
                    nombre = resultSet.getString("Nombre");
                    apellidoPaterno = resultSet.getString("ApellidoPaterno");
                    apellidoMaterno = resultSet.getString("ApellidoMaterno");
                    correo = resultSet.getString("Correo");
                    Tutorado tutoradoBuscado = new Tutorado();
                    tutoradoBuscado.setMatricula(matricula);
                    tutoradoBuscado.setNombre(nombre);
                    tutoradoBuscado.setApellidoPaterno(apellidoPaterno);
                    tutoradoBuscado.setApellidoMaterno(apellidoMaterno);
                    tutoradoBuscado.setCorreo(correo);
                    tutorados.add(tutoradoBuscado);
                }while (resultSet.next());
            }
        }catch (SQLException ex) {
            log.fatal(ex);
        }
        return tutorados;
    }

    @Override
    public ArrayList<Tutorado> buscarTutoradoPorMatricula(String matriculaBuscada){
        ArrayList<Tutorado> tutorados = new ArrayList<>();
        DataBaseConnection dataBaseConnection = new DataBaseConnection();
        try(Connection connection=dataBaseConnection.getConnection()){
            String query="Select * from tutorados where Matricula = ";
            PreparedStatement statement=connection.prepareStatement(query);
            statement.setString(1,"'" + matriculaBuscada + "'");
            ResultSet resultSet=statement.executeQuery();
            if (!resultSet.next()){
                throw new SQLException("No se encontraron tutorados");
            }else{
                String matricula;
                String nombre;
                String apellidoPaterno;
                String apellidoMaterno;
                String correo;
                do {
                    matricula = resultSet.getString("Matricula");
                    nombre = resultSet.getString("Nombre");
                    apellidoPaterno = resultSet.getString("ApellidoPaterno");
                    apellidoMaterno = resultSet.getString("ApellidoMaterno");
                    correo = resultSet.getString("Correo");
                    Tutorado tutoradoBuscado = new Tutorado();
                    tutoradoBuscado.setMatricula(matricula);
                    tutoradoBuscado.setNombre(nombre);
                    tutoradoBuscado.setApellidoPaterno(apellidoPaterno);
                    tutoradoBuscado.setApellidoMaterno(apellidoMaterno);
                    tutoradoBuscado.setCorreo(correo);
                    tutorados.add(tutoradoBuscado);
                }while (resultSet.next());
            }
        } catch (SQLException ex) {
            log.fatal(ex);
        }
        return tutorados;
    }

    @Override
    public ArrayList<Tutorado> buscarTutoradoPorTutor(String cuentaUV) {
        ArrayList<Tutorado> tutorados = new ArrayList<>();
        DataBaseConnection dataBaseConnection = new DataBaseConnection();
        try(Connection connection=dataBaseConnection.getConnection()){
            String query=
                   "SELECT tutorados.Matricula, tutorados.Nombre, tutorados.ApellidoPaterno, tutorados.ApellidoMaterno FROM tutorados " +
                    "inner join tutorestutorados on tutorestutorados.Matricula = tutorados.Matricula " +
                    "where tutorestutorados.CuentaUV = ?";
            PreparedStatement statement=connection.prepareStatement(query);
            statement.setString(1, cuentaUV);
            ResultSet resultSet=statement.executeQuery();
            if (!resultSet.next()){
                throw new SQLException("No se encontraron tutorados");
            }else{
                String matricula;
                String nombre;
                String apellidoPaterno;
                String apellidoMaterno;
                do {
                    matricula = resultSet.getString("Matricula");
                    nombre = resultSet.getString("Nombre");
                    apellidoPaterno = resultSet.getString("ApellidoPaterno");
                    apellidoMaterno = resultSet.getString("ApellidoMaterno");
                    Tutorado tutoradoBuscado = new Tutorado();
                    tutoradoBuscado.setMatricula(matricula);
                    tutoradoBuscado.setNombre(nombre);
                    tutoradoBuscado.setApellidoPaterno(apellidoPaterno);
                    tutoradoBuscado.setApellidoMaterno(apellidoMaterno);
                    tutorados.add(tutoradoBuscado);
                }while (resultSet.next());
            }
        } catch (SQLException ex) {
            log.fatal(ex);
        }
        return tutorados;
    }

    @Override
    public void registrarTutorado(Tutorado tutorado){ //inseguro
        DataBaseConnection dataBaseConnection = new DataBaseConnection();
        try(Connection connection=dataBaseConnection.getConnection()){  
            String matricula = tutorado.getMatricula();
            String nombre = tutorado.getNombre();
            String apellidoPaterno = tutorado.getApellidoPaterno();
            String apellidoMaterno = tutorado.getApellidoMaterno();
            String correo = tutorado.getCorreo();
            String query = "INSERT INTO tutorados VALUES (?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, matricula);
            statement.setString(2, nombre);
            statement.setString(3, apellidoPaterno);
            statement.setString(4, apellidoMaterno);
            statement.setString(5, correo);
            int filasInsertadas = statement.executeUpdate();
            System.out.println(filasInsertadas + " Fila insertada ");
        } catch (SQLException ex) {
            log.fatal(ex);
        }
    }
    
    @Override
    public void eliminarTutoradoPorMatricula(String matriculaEliminada){ //inseguro
        DataBaseConnection dataBaseConnection = new DataBaseConnection();
        try(Connection connection=dataBaseConnection.getConnection()){
            String query = "DELETE FROM tutorados WHERE Matricula = '" + matriculaEliminada + "'";
            PreparedStatement statement=connection.prepareStatement(query);
            int filasEliminadas = statement.executeUpdate();
            System.out.println(filasEliminadas + " fila eiminada");
        } catch (SQLException ex) {
            log.fatal(ex);
        }
    }

    @Override
    public void actualizarTutorado(Tutorado tutorado){
        DataBaseConnection dataBaseConnection = new DataBaseConnection();
        try(Connection connection=dataBaseConnection.getConnection()){ 
            String matricula = tutorado.getMatricula();
            String nombre = tutorado.getNombre();
            String apellidoPaterno = tutorado.getApellidoPaterno();
            String apellidoMaterno = tutorado.getApellidoMaterno();
            String correo = tutorado.getCorreo();
            String query = ("UPDATE tutorados SET Matricula =  ?, Nombre = ?, ApellidoPaterno = ?, ApellidoMaterno = ?, Correo = ? " +
                    "WHERE Matricula = ?" );
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, matricula);
            statement.setString(2, nombre);
            statement.setString(3, apellidoPaterno);
            statement.setString(4, apellidoMaterno);
            statement.setString(5, correo);
            statement.setString(6, matricula);
            int filasActualizadas = statement.executeUpdate();
            System.out.println(filasActualizadas + " filas actualizadas");
        } catch (SQLException ex) {
            log.fatal(ex);
        } 
    }
    
}
