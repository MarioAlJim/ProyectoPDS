package uv.fei.tutorias.domain;

import java.util.Objects;

public class Periodo {

        private int idPeriodo;
        private String fechaInicio;
        private String fechaFin;

    public int getIdPeriodo() {
        return idPeriodo;
    }

    public void setIdPeriodo(int idPeriodo) {
        this.idPeriodo = idPeriodo;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }
    
    /**
     *
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Periodo periodo= (Periodo) o;
        return idPeriodo == periodo.idPeriodo && Objects.equals(fechaInicio, periodo.fechaInicio) && Objects.equals(fechaFin, periodo.fechaFin);
    }

    
}
