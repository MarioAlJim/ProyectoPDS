/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package uv.fei.tutorias.bussinesslogic;

import org.junit.Test;
import static org.junit.Assert.*;
import uv.fei.tutorias.domain.Usuario;

/**
 *
 * @author SILVERWOLF
 */
public class UsuarioDAOTest {
    
    public UsuarioDAOTest() {
    }

    @Test
    public void testRecuperarSesion() {
        System.out.println("recuperarSesion");
        String cuentauv = "arivera";
        String contrasena = "234";
        UsuarioDAO instance = new UsuarioDAO();
        Usuario expResult = null;
        Usuario result = instance.recuperarSesion(cuentauv, contrasena);
        System.out.println(result.getCuentaUV() + " " + " " + result.getContrasenia());
        assertEquals(expResult, result);
    }
    
}
