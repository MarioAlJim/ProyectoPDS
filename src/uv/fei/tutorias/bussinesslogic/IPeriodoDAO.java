package uv.fei.tutorias.bussinesslogic;

import java.util.ArrayList;
import java.util.List;
import uv.fei.tutorias.domain.Periodo;


public interface IPeriodoDAO {
    
    public List<Periodo> consultarPeriodoTodosLosPeriodos();
    
    public List<Periodo> consultarPeriodoPorId(int idPeriodoBuscado);
    
    public int registrarPeriodo(Periodo periodo);

    public int eliminarPeriodoId(int idPeriodo);

    public int actualizarPeriodo(Periodo periodo);
}
