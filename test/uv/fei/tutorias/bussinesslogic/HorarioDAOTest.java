package uv.fei.tutorias.bussinesslogic;

import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;
import uv.fei.tutorias.domain.Horario;


public class HorarioDAOTest {
    
    public HorarioDAOTest() {
    }

    @Test
    public void testConsultarHorarioporId() {
        System.out.println("consultarHorarioporId");
        int idHorarioBuscado = 4;
        HorarioDAO horarioDAO = new HorarioDAO();
        ArrayList<Horario> expResult = new ArrayList<>();
        Horario horarioEsperado = new Horario();
        horarioEsperado.setIdHorario(4);
        horarioEsperado.setHora("2002-03-09 09:00:00.0");
        horarioEsperado.setIdTutoria(3);
        horarioEsperado.setMatricula("S20015736");
        expResult.add(horarioEsperado);
        ArrayList<Horario> result = (ArrayList<Horario>) horarioDAO.consultarHorarioporId(idHorarioBuscado);
        for(Horario horario : result){
            System.out.println(String.format("%s %s %s", horario.getHora(), horario.getIdTutoria(), horario.getMatricula()));
        }
        for(Horario horario : expResult){
            System.out.println(String.format("%s %s %s", horario.getHora(), horario.getIdTutoria(), horario.getMatricula()));
        }
        assertEquals("", expResult, result);
    }

    @Test
    public void testRegistrarHorario() {
        System.out.println("registrarHorario");
        HorarioDAO horarioDAO = new HorarioDAO();
        Horario horarionuevo = new Horario();
        horarionuevo.setHora("2022-03-09 09:45:00.0");
        horarionuevo.setIdTutoria(3);
        horarionuevo.setMatricula("s20015742");
        horarioDAO.registrarHorario(horarionuevo);

        int idHorarioBuscado = 9;
        ArrayList<Horario> expResult = new ArrayList<>();
        Horario horarioEsperado = new Horario();
        horarioEsperado.setIdHorario(9);
        horarioEsperado.setHora("2022-03-09 09:45:00.0");
        horarioEsperado.setIdTutoria(3);
        horarioEsperado.setMatricula("s20015742");
        expResult.add(horarioEsperado);
        ArrayList<Horario> result = (ArrayList<Horario>) horarioDAO.consultarHorarioporId(idHorarioBuscado);
        assertEquals(expResult, result);
    }

    @Test
    public void testActualizarHorario() {
        HorarioDAO horarioDAO = new HorarioDAO();
        Horario horarioactualizado = new Horario();
        horarioactualizado.setIdHorario(9);
        horarioactualizado.setHora("2022-03-09 10:30:00.0");
        horarioactualizado.setIdTutoria(3);
        horarioactualizado.setMatricula("s20015742");
        horarioDAO.actualizarHorario(horarioactualizado);

        int idHorarioBuscado = 9;
        ArrayList<Horario> expResult = new ArrayList<>();
        expResult.add(horarioactualizado);
        ArrayList<Horario> result = (ArrayList<Horario>) horarioDAO.consultarHorarioporId(idHorarioBuscado);
        for(Horario horario : result){
            System.out.println(String.format("%s %s %s", horario.getHora(), horario.getIdTutoria(), horario.getMatricula()));
        }
        for(Horario horario : expResult){
            System.out.println(String.format("%s %s %s", horario.getHora(), horario.getIdTutoria(), horario.getMatricula()));
        }
        assertEquals(expResult, result);
    }

    @Test
    public void testEliminarHorario() {
        System.out.println("eliminarHorario");
        int idHorario = 6;
        HorarioDAO instance = new HorarioDAO();
        int expResult = 1;
        int result = instance.eliminarHorario(idHorario);
        assertEquals(expResult, result);
    }
    
}
