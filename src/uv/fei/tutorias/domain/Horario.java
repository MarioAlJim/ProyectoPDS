package uv.fei.tutorias.domain;

import java.util.Objects;

public class Horario {
    private int  idHorario;
    private String hora;
    private int idTutoria;
    private String matricula;

    public void setIdTutoria(int idTutoria) {
        this.idTutoria = idTutoria;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public void setIdHorario(int idHorario) {
        this.idHorario = idHorario;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public int getIdHorario() {
        return idHorario;
    }

    public String getHora() {
        return hora;
    }

    public int getIdTutoria() {
        return idTutoria;
    }

    public String getMatricula() {
        return matricula;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Horario horario = (Horario) o;
        return idTutoria == horario.idTutoria && Objects.equals(hora, horario.hora) && Objects.equals(matricula, horario.matricula);
    }

}
