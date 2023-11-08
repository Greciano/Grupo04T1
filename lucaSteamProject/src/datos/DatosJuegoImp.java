package datos;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import model.Juego;
import utilidades.LeerTeclado;

public class DatosJuegoImp implements IDatosJuego {
	
    private List<Juego> juegos = new ArrayList<>();


    public List<Juego> getJuego() {
        return juegos;
    }

    public void setJuego(List<Juego> juego) {
        this.juegos = juego;
    }

    public void addJuego(Juego e) {
    	juegos.add(e);
    }
   

 }


