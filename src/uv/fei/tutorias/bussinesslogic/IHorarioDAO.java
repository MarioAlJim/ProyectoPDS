package uv.fei.tutorias.bussinesslogic;

import uv.fei.tutorias.domain.Horario;
import java.util.List;

public interface IHorarioDAO {
    public List<Horario> consultarTodosLosHorarios();

    public List<Horario> consultarHorarioporId(int idHorario);

    public int registrarHorario(Horario horario);

    public int actualizarHorario(Horario horario);

    public int eliminarHorario(int idHorario);

}

