package uv.fei.tutorias.domain;

import java.util.Objects;

public class ProblematicaAcademica {
    private int idProblematicaAcademica;
    private String descripcion;
    private String solucion;
    private int idDocenteEePrograma;
    private int idHorario;

    public void setIdProblematicaAcademica(int idProblematicaAcademica) {
        this.idProblematicaAcademica = idProblematicaAcademica;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setSolucion(String solucion) {
        this.solucion = solucion;
    }

    public void setIdDocenteEePrograma(int idDocenteEePrograma) {
        this.idDocenteEePrograma = idDocenteEePrograma;
    }

    public void setIdHorario(int idHorario) {
        this.idHorario = idHorario;
    }

    public int getIdProblematicaAcademica() {
        return idProblematicaAcademica;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getSolucion() {
        return solucion;
    }

    public int getIdDocenteEePrograma() {
        return idDocenteEePrograma;
    }

    public int getIdHorario() {
        return idHorario;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProblematicaAcademica that = (ProblematicaAcademica) o;
        return idDocenteEePrograma == that.idDocenteEePrograma && idHorario == that.idHorario && Objects.equals(descripcion, that.descripcion) && Objects.equals(solucion, that.solucion);
    }

}
