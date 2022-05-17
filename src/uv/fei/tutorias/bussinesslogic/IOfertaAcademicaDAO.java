package uv.fei.tutorias.bussinesslogic;

import uv.fei.tutorias.domain.Horario;
import uv.fei.tutorias.domain.OfertaAcademica;

import java.util.List;

public interface IOfertaAcademicaDAO {

    public List<OfertaAcademica> obtenerOfertaAcademicaGeneral();

    public List<OfertaAcademica> consultarOfertaAcademicaPorProgramaEducativo(String programaEducativo);

    /*public int registrarOfertaAcademica(OfertaAcademica ofertaAcademica);*/

}
