package veterinaria;


public class Animal {
    
    private int id=0;
    private String nombre;
    private String especie;
    private String raza;
    private int edad;
    private Personal pAssignado;
    private HistorialClinico historialClinico;
    
    public Animal(String nombre, String especie, String raza, int edad, HistorialClinico historialClinico, Personal pAssignado){
        id++;
        this.nombre=nombre;
        this.especie=especie;
        this.raza=raza;
        this.edad=edad;
        this.historialClinico=historialClinico;
        this.pAssignado=pAssignado;
    }

    public Personal getpAssignado() {
        return pAssignado;
    }

    public void setpAssignado(Personal pAssignado) {
        this.pAssignado = pAssignado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public HistorialClinico getHistorialClinico() {
        return historialClinico;
    }

    public void setHistorialClinico(HistorialClinico historialClinico) {
        this.historialClinico = historialClinico;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}


