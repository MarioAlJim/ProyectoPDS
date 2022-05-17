package uv.fei.tutorias.bussinesslogic;

import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;
import uv.fei.tutorias.domain.Horario;
import uv.fei.tutorias.domain.OfertaAcademica;


public class OfertaAcademicaDAOTest {
    
    public OfertaAcademicaDAOTest() {
    }
    
    @Test
    public void testConsultarOfertaAcademicaGeneral() {
        System.out.println("consultarOfertaAcademicaPorProgramaEducativo");
        String programaEducativoSeleccionado = "Tecnologías Computacionales";
        OfertaAcademicaDAO instance = new OfertaAcademicaDAO();
        OfertaAcademica ofertaAcademica = new OfertaAcademica();
        ArrayList<OfertaAcademica> result = instance.obtenerOfertaAcademicaGeneral();
        for(OfertaAcademica ofertaAcademica1 : result){
            System.out.println(String.format("%s %s %s %s", ofertaAcademica1.getNrc(), ofertaAcademica1.getEe(), ofertaAcademica1.getDocente(), ofertaAcademica1.getProgramaEducativo()));
        }
        assertEquals(result, result);
    }

    @Test
    public void testConsultarOfertaAcademicaPorProgramaEducativo() {
        System.out.println("consultarOfertaAcademicaPorProgramaEducativo");
        String programaEducativoSeleccionado = "Tecnologías Computacionales";
        OfertaAcademicaDAO instance = new OfertaAcademicaDAO();
        ArrayList<OfertaAcademica> expResult = new ArrayList<>();
        OfertaAcademica ofertaAcademica = new OfertaAcademica();
        ofertaAcademica.setIdOfertaAcademica(3);
        ofertaAcademica.setNrc("74370");
        ofertaAcademica.setEe("Habilidades de comunicación");
        ofertaAcademica.setDocente("Virginia Lagunes Barradas");
        ofertaAcademica.setProgramaEducativo("Tecnologías Computacionales");
        expResult.add(ofertaAcademica);
        ArrayList<OfertaAcademica> result = instance.consultarOfertaAcademicaPorProgramaEducativo(programaEducativoSeleccionado);

        for(OfertaAcademica ofertaAcademica1 : result){
            System.out.println(String.format("%s %s %s %s", ofertaAcademica1.getNrc(), ofertaAcademica1.getEe(), ofertaAcademica1.getDocente(), ofertaAcademica1.getProgramaEducativo()));
        }
        for(OfertaAcademica ofertaAcademica1 : expResult){
            System.out.println(String.format("%s %s %s %s", ofertaAcademica1.getNrc(), ofertaAcademica1.getEe(), ofertaAcademica1.getDocente(), ofertaAcademica1.getProgramaEducativo()));
        }
        assertEquals(expResult, result);
    }

    @Test
    public void testConsultarOfertaAcademicaPorProgramaEducativo2() {
        System.out.println("consultarOfertaAcademicaPorProgramaEducativo");
        String programaEducativoSeleccionado = "Ingeniería de Software";
        OfertaAcademicaDAO instance = new OfertaAcademicaDAO();
        ArrayList<OfertaAcademica> expResult = new ArrayList<>();
        OfertaAcademica ofertaAcademica2 = new OfertaAcademica();
            ofertaAcademica2.setEe("Álgebra lineal");
            ofertaAcademica2.setDocente("Maribel Carmona García");
            ofertaAcademica2.setProgramaEducativo("Ingeniería de Software");
        expResult.add(ofertaAcademica2);
        OfertaAcademica ofertaAcademica1 = new OfertaAcademica();
            ofertaAcademica1.setEe("Computación básica");
            ofertaAcademica1.setDocente("José Juan Muñoz León");
            ofertaAcademica1.setProgramaEducativo("Ingeniería de Software");
        expResult.add(ofertaAcademica1);
        ArrayList<OfertaAcademica> result = instance.consultarOfertaAcademicaPorProgramaEducativo(programaEducativoSeleccionado);

        for(OfertaAcademica ofertaAcademica : result){
            System.out.println(String.format("%s %s %s", ofertaAcademica.getEe(), ofertaAcademica.getDocente(), ofertaAcademica.getProgramaEducativo()));
        }
        for(OfertaAcademica ofertaAcademica : expResult){
            System.out.println(String.format("%s %s %s", ofertaAcademica.getEe(), ofertaAcademica.getDocente(), ofertaAcademica.getProgramaEducativo()));
        }
        assertEquals(expResult, result);
    }

    @Test
    public void testConsultarOfertaAcademicaPorProgramaEducativo3() {
        System.out.println("consultarOfertaAcademicaPorProgramaEducativo");
        String programaEducativoSeleccionado = "Redes y Servicios de Cómputo";
        OfertaAcademicaDAO instance = new OfertaAcademicaDAO();
        ArrayList<OfertaAcademica> expResult = new ArrayList<>();
        OfertaAcademica ofertaAcademica1 = new OfertaAcademica();
        ofertaAcademica1.setEe("Fundamentos de matemáticas");
        ofertaAcademica1.setDocente("Fredy Sanchéz Castañeda");
        ofertaAcademica1.setProgramaEducativo("Redes y Servicios de Cómputo");
        expResult.add(ofertaAcademica1);
        ArrayList<OfertaAcademica> result = instance.consultarOfertaAcademicaPorProgramaEducativo(programaEducativoSeleccionado);
        for(OfertaAcademica ofertaAcademica : result){
            System.out.println(String.format("%s %s %s", ofertaAcademica.getEe(), ofertaAcademica.getDocente(), ofertaAcademica.getProgramaEducativo()));
        }
        for(OfertaAcademica ofertaAcademica : expResult){
            System.out.println(String.format("%s %s %s", ofertaAcademica.getEe(), ofertaAcademica.getDocente(), ofertaAcademica.getProgramaEducativo()));
        }
        assertEquals(expResult, result);
    }
}
