package Configuracion;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import vistas.DialogMensaje;

public class ArchivoIni {
    
    private String ruta = "C:\\ProgramData\\EnfermeriaUnidadComputo\\config.ini";
    private Properties propiedad;

    public static ArchivoIni ini = null;
    
    public static ArchivoIni getArchivoIni(){
        if(ini == null){
            ini = new ArchivoIni();
        }
        return ini;
    }
    
    public ArchivoIni() {
        this.propiedad = new Properties();
        leerArchivoIni();
    }

    public void leerArchivoIni(){
        try {
            this.propiedad.load(new FileInputStream(this.ruta));
        } catch (IOException ex) {
            DialogMensaje.Error(null,"Falta el archivo config.ini <br> "+this.ruta);
        }
    }
    
    public String leerPropiedad(String p){
         return this.propiedad.getProperty(p);
    }
    
    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    public Properties getPropiedad() {
        return propiedad;
    }

    public void setPropiedad(Properties propiedad) {
        this.propiedad = propiedad;
    }
  
}
