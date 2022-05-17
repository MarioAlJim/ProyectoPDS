package uv.fei.tutorias.domain;

import java.util.Objects;

public class Usuario {
    private String cuentaUV;
    private String contrasenia;
    private String rol;

    public String getCuentaUV(){
        return cuentaUV;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public String getRol(){
        return rol;
    }

    public void setCuentaUV(String cuentaUV) {
        this.cuentaUV = cuentaUV;
    }

    public void setContrasenia(String contrasenia){
        this.contrasenia = contrasenia;
    }

    public void setRol(String rol){
        this.rol = rol;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return Objects.equals(cuentaUV, usuario.cuentaUV) && Objects.equals(contrasenia, usuario.contrasenia);
    }
}



