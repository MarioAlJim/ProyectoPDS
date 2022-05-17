package uv.fei.tutorias.bussinesslogic;

import uv.fei.tutorias.domain.ProblematicaAcademica;
import java.util.List;

public interface IPoblematicaAcademicaDAO {

    public List<ProblematicaAcademica> consultarTodasLasProblematicas();

    public List<ProblematicaAcademica> consultarProblematicaPorId(int idProblematicaAcademicaBuscada);

    public int registrarProblematicaAcademica(ProblematicaAcademica problematicaAcademica);

    public int eliminarProblematica(int idProblematicaAcademica);

    public int actualizarProblematica(ProblematicaAcademica problematicaAcademica);

}
