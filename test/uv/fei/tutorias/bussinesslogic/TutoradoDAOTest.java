package uv.fei.tutorias.bussinesslogic;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import uv.fei.tutorias.domain.Tutorado;

/**
 *
 * @author SILVERWOLF
 */
public class TutoradoDAOTest {
    
    public TutoradoDAOTest() {
    }


    @Test
    public void testBuscarTutoradoPorTutor() {
        System.out.println("buscarTutoradoPorTutor");
        TutoradoDAO instance = new TutoradoDAO();
        String cuentaUV = "ermeneses@uv.mx";
        ArrayList<Tutorado> result = instance.buscarTutoradoPorTutor(cuentaUV);
        for(Tutorado tutorado1 : result){
            System.out.println(String.format("%s %s", tutorado1.getMatricula(), tutorado1.getNombre()));
        }
        assertEquals(result, result);
    }
    
    @Test
    public void testBuscarTutoradoPorTutor2() {
        System.out.println("buscarTutoradoPorTutor");
        TutoradoDAO instance = new TutoradoDAO();
        String cuentaUV = "mmillan@uv.mx";
        ArrayList<Tutorado> result = instance.buscarTutoradoPorTutor(cuentaUV);
        for(Tutorado tutorado1 : result){
            System.out.println(String.format("%s %s", tutorado1.getMatricula(), tutorado1.getNombre()));
        }
        assertEquals(result, result);
    }
}
