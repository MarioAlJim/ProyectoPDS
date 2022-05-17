package uv.fei.tutorias.bussinesslogic;

import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;
import uv.fei.tutorias.domain.ProblematicaAcademica;

public class ProblematicaAcademicaDAOTest {
    
    public ProblematicaAcademicaDAOTest() {
    }

    @Test
    public void testConsultarProblematicaPorId() {
        System.out.println("Consultar problematica por id");
        ProblematicaAcademicaDAO problematicaAcademicaDAO = new ProblematicaAcademicaDAO();
        ArrayList<ProblematicaAcademica> problematicasEsperadas = new ArrayList<>();
        ProblematicaAcademica problematicaEsperada = new ProblematicaAcademica();
        problematicaEsperada.setIdProblematicaAcademica(1);
        problematicaEsperada.setDescripcion("El maestro falta a clases");
        problematicaEsperada.setSolucion("Hablar con el maestro acerca del porqué falta");
        problematicaEsperada.setIdDocenteEePrograma(3);
        problematicaEsperada.setIdHorario(3);
        problematicasEsperadas.add(problematicaEsperada);
        ArrayList<ProblematicaAcademica> problematicasAcademicas =
                (ArrayList<ProblematicaAcademica>) problematicaAcademicaDAO.consultarProblematicaPorId(1);
        for(ProblematicaAcademica problematicaAcademica : problematicasAcademicas){
            System.out.println(String.format("Id: %s, Descripcion: %s, Solucion: %s, Experiencia: %s, Horario: %s", problematicaAcademica.getIdProblematicaAcademica(), problematicaAcademica.getDescripcion(),
                    problematicaAcademica.getSolucion(), problematicaAcademica.getIdDocenteEePrograma(), problematicaAcademica.getIdHorario()));
        }
        for(ProblematicaAcademica problematicaAcademica  : problematicasEsperadas){
            System.out.println(String.format("Id: %s, Descripcion: %s, Solucion: %s, Experiencia: %s, Horario: %s", problematicaAcademica.getIdProblematicaAcademica(), problematicaAcademica.getDescripcion(),
                    problematicaAcademica.getSolucion(), problematicaAcademica.getIdDocenteEePrograma(), problematicaAcademica.getIdHorario()));
        }
        assertEquals("", problematicasEsperadas, problematicasAcademicas);
    }

    @Test
    public void testRegistrarProblematicaAcademica() {
        System.out.println("registrarProblematicaAcademica");
        ProblematicaAcademica problematicaAcademica = new ProblematicaAcademica();
        problematicaAcademica.setDescripcion("El profesor no explica las tareas");
        problematicaAcademica.setSolucion("");
        problematicaAcademica.setIdDocenteEePrograma(1);
        problematicaAcademica.setIdHorario(4);
        ProblematicaAcademicaDAO instance = new ProblematicaAcademicaDAO();
        instance.registrarProblematicaAcademica(problematicaAcademica);

        ProblematicaAcademicaDAO problematicaAcademicaDAO = new ProblematicaAcademicaDAO();
        ArrayList<ProblematicaAcademica> problematicasEsperadas = new ArrayList<>();
        ArrayList<ProblematicaAcademica> problematicasAcademicas =
                (ArrayList<ProblematicaAcademica>) problematicaAcademicaDAO.consultarProblematicaPorId(16);
        ProblematicaAcademica problematicaEsperada = new ProblematicaAcademica();
        problematicaEsperada.setIdProblematicaAcademica(16);
        problematicaEsperada.setDescripcion("El profesor no explica las tareas");
        problematicaEsperada.setSolucion("");
        problematicaEsperada.setIdDocenteEePrograma(1);
        problematicaEsperada.setIdHorario(4);
        problematicasEsperadas.add(problematicaEsperada);
        assertEquals("", problematicasEsperadas, problematicasAcademicas);
    }

    @Test
    public void testActualizarProblematica() {
        System.out.println("actualizar problematica");
        ProblematicaAcademica problematicaAcademica = new ProblematicaAcademica();
        problematicaAcademica.setIdProblematicaAcademica(7);
        problematicaAcademica.setDescripcion("El profesor no porporcionó la rubrica del proyecto");
        problematicaAcademica.setSolucion("");
        problematicaAcademica.setIdDocenteEePrograma(3);
        problematicaAcademica.setIdHorario(3);
        ProblematicaAcademicaDAO problematicaAcademicaDAO = new ProblematicaAcademicaDAO();
        problematicaAcademicaDAO.actualizarProblematica(problematicaAcademica);

        ArrayList<ProblematicaAcademica> problematicasEsperadas = new ArrayList<>();
        ArrayList<ProblematicaAcademica> problematicasAcademicas =
                (ArrayList<ProblematicaAcademica>) problematicaAcademicaDAO.consultarProblematicaPorId(7);
        problematicasEsperadas.add(problematicaAcademica);
        assertEquals("", problematicasEsperadas, problematicasAcademicas);
    }

    @Test
    public void testEliminarProblematica() {
        System.out.println("eliminarProblematica");
        int idProblematicaAcademica = 15;
        ProblematicaAcademicaDAO instance = new ProblematicaAcademicaDAO();
        int expResult = 1;
        int result = instance.eliminarProblematica(idProblematicaAcademica);
        assertEquals(expResult, result);
    }
    
}
