package veterinaria;

public class Veterinario extends Personal {
    
    private HistorialClinico historialClinico;

    public Veterinario(int i, String juanPerez, String especialistaEnPerros) {
    }
    
    public Veterinario(String nombre, String especialidad, int añosExperiencia, HistorialClinico historialClinico){
        this.setNombre(nombre);
        this.setEspecialidad(especialidad);
        this.setAñosExperiencia(añosExperiencia);
        this.setHistorialClinico(historialClinico);
    }
    
    
    public HistorialClinico getHistorialClinico(){
        return historialClinico;
    }
    
    public void setHistorialClinico(HistorialClinico historialClinico){
        this.historialClinico=historialClinico;
    }

    public int getId() {
        return 0;
    }
}
