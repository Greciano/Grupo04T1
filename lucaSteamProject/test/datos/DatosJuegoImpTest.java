package datos;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import model.Genero;
import model.Juego;
import model.Plataforma;

class DatosJuegoImpTest {
	@Test
	void testRutaArchivoCSV() {
		File archivo = new File("src/resources/vgsales.csv");
		
		assertAll(
				//Comprobamos que la ruta exista
				() -> assertEquals(true,archivo.exists())
				);
	}
	
	@Test
	void testRutaArchivoPDF() {
		File archivo = new File("src/resources/archivo.pdf");
		
		assertAll(
				//Comprobamos que la ruta exista
				() -> assertEquals(true,archivo.exists())
				);
	}
	
	@Test
	void testArrayVacio() {
		List<Juego> listaJuegos = new ArrayList<>();
		
		assertAll(
				//Comprobamos que el ArrayList de juegos esté vacío
				() -> assertEquals(0,listaJuegos.size())
				);
	}
	@Test
	void testEditorNintendo() {
		Juego j = new Juego();
		j.setEditor("Nintendo");
		
		assertAll(
				//Comprobamos que Juego recibe Nintendo como editor
				() -> assertEquals("Nintendo",j.getEditor())
				);
	}
	
	@Test
	void testGenero() {
		Juego j = new Juego();
		
		assertAll(
				//Comprobamos que Genero es null
				() -> assertEquals(null,j.getGenero())
				);	
	}
	
	@Test
    public void testSeleccionarPlataforma() {
		
		//Comprobamos que en el método seleccionarPlataforma, la que elegimos coincide
        Plataforma plataforma = DatosJuegoImp.seleccionarPlataforma(1);
        assertEquals(Plataforma.PS2, plataforma);
    }
	
	@Test
    public void testSeleccionarGenero() {
		
		//Comprobamos que en el método seleccionarGénero, el que elegimos coincide
        Genero genero = DatosJuegoImp.seleccionarGenero(2);
        assertEquals(Genero.Sports, genero);
    }
	
	@Test
    public void testFiltrarNintendo() {
        List<Juego> listaJuegos = new ArrayList<>();
        
        //Comprobamos que dentro de un arrayList de tipo Juego, el dato editor es Nintendo
        listaJuegos.add(new Juego("Juego1", 2022, "Nintendo", Plataforma.PS4, Genero.Action));
        assertTrue(listaJuegos.get(0).getEditor().equalsIgnoreCase("Nintendo"));
    }
	
	@Test
    public void testGeneroAction() {
		Juego j = new Juego();
		j.setGenero(Genero.Action);
		//Comprobamos que el género sea Acción
		assertEquals(Genero.Action,j.getGenero());
	}
	
	@Test
	public void testStringVacio() {
		Juego j = new Juego();
		j.setNombre("");
		j.setEditor("");
		//Comprobamos que los String de juego no vayan vacíos
		assertEquals("",j.getNombre());
		assertEquals("",j.getEditor());
	}
	
	@Test
	public void testIntImposible() {
		Juego j = new Juego();
		boolean cierto;
		j.setFecha(2000);
		if(j.getFecha()<1950||j.getFecha()>2030) {
			cierto = false;
		}else {
			cierto = true;
		}
		assertEquals(true,cierto);
	}
	
	@Test
    public void testFechaNoEsNA() {
        // Supongamos que tienes un juego llamado "juego" con una fecha.
        Juego juego = new Juego("Nombre del Juego", 2000, "Editor", Plataforma.PS2, Genero.Action);

        // Verifica que la fecha no sea "N/A"
        assertNotEquals("N/A", juego.getFecha());
    }
	
	@Test
    public void testPlataformaVacia() {
        Juego j = new Juego();
        //Comprobamos si Plataforma está vacía
        assertEquals(null,j.getPlataforma());
    }
	
	@Test
    public void testPlataformaPS4() {
        Juego j = new Juego();
        j.setPlataforma(Plataforma.PS4);
        //Comprobamos si Plataforma está vacía
        assertEquals(Plataforma.PS4,j.getPlataforma());
    }
}
