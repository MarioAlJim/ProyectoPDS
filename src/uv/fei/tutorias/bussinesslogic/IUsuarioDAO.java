package uv.fei.tutorias.bussinesslogic;

import uv.fei.tutorias.domain.Usuario;

public interface IUsuarioDAO {

    public Usuario recuperarSesion(String cuentauv, String contrasena);


}
