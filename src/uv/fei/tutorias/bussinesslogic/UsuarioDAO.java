package uv.fei.tutorias.bussinesslogic;

import org.apache.log4j.Logger;
import uv.fei.tutorias.dataaccess.DataBaseConnection;
import uv.fei.tutorias.domain.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.apache.log4j.Logger;

public class UsuarioDAO implements IUsuarioDAO{

    final static Logger log = Logger.getLogger(SesionTutoriaDAO.class);

    @Override
    public Usuario recuperarSesion(String cuentauv, String contrasena) {
        Usuario usuario = new Usuario();
        DataBaseConnection dataBaseConnection = new DataBaseConnection();
        try(Connection connection=dataBaseConnection.getConnection()){
            String query= ("SELECT U.cuentauv, U.contrasena, R.Descripcion FROM usuarios U " +
            "inner join usuariosroles UR on UR.CuentaUV = U.cuentauv " +
            " inner join roles R on R.IdRol = UR.IdRol " +
            "where U.cuentauv = ? and U.contrasena = ? ");
            PreparedStatement statement=connection.prepareStatement(query);
            statement.setString(1, cuentauv);
            statement.setString(2, contrasena);
            ResultSet resultSet=statement.executeQuery();
            if (!resultSet.next()){
                throw new SQLException("No se encontraron datos");
            }else {
                String cuentaUv = resultSet.getString("cuentaUV");
                String contrasenia = resultSet.getString("contrasena");
                String rol = resultSet.getString("descripcion");
                usuario.setCuentaUV(cuentaUv);
                usuario.setContrasenia(contrasenia);
                usuario.setRol(rol);
            }
        }catch (SQLException ex) {
            log.fatal(ex);
        }
        return usuario;
    }
}
