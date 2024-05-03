package veterinaria;

public class PersonalAdministrativo extends Personal{

    public PersonalAdministrativo(int i, String pedroGonzalez, String auxiliar) {
    }
    
    public PersonalAdministrativo(String nombre, String especialidad, int añosExperiencia){
        this.setNombre(nombre);
        this.setEspecialidad(especialidad);
        this.setAñosExperiencia(añosExperiencia);
    }

    public int getId() {
        return 0;
    }
}
