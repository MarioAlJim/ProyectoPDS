package uv.fei.tutorias.domain;

public class SesionTutoria {
    private int  idSesionTutoria;
    private int numTutoria;
    private String fechaTutoria;
    private String FechaCierreReportes;
    private int idPeriodo;

    public int getIdSesionTutoria() {
        return idSesionTutoria;
    }

    public void setIdSesionTutoria(int idSesionTutoria) {
        this.idSesionTutoria = idSesionTutoria;
    }

    public int getNumTutoria() {
        return numTutoria;
    }

    public void setNumTutoria(int numTutoria) {
        this.numTutoria = numTutoria;
    }

    public String getFechaTutoria() {
        return fechaTutoria;
    }

    public void setFechaTutoria(String fechaTutoria) {
        this.fechaTutoria = fechaTutoria;
    }

    public String getFechaCierreReportes() {
        return FechaCierreReportes;
    }

    public void setFechaCierreReportes(String FechaCierreReportes) {
        this.FechaCierreReportes = FechaCierreReportes;
    }

    public int getIdPeriodo() {
        return idPeriodo;
    }

    public void setIdPeriodo(int idPeriodo) {
        this.idPeriodo = idPeriodo;
    }

    
}
