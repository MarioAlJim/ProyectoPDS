package uv.fei.tutorias.bussinesslogic;

import java.util.List;
import uv.fei.tutorias.domain.SesionTutoria;

public interface ISesiónTutoria {

public List<SesionTutoria> consultarTodasLasSesionesDeTutoria();

public int registrarSesionTutoria(SesionTutoria fechaSesionTutoria);

public int eliminarSesionTutoriaPorId(int idTutoria);
    
}
