package veterinaria;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AppClinicaVeterinaria {

    private static AppClinicaVeterinaria clinica;
    private final List<Animal> animales;
    private final List<Veterinario> veterinarios;
    private final List<PersonalAdministrativo> personalAdministrativo;
    private Scanner sc;

    public static void main(String[] args) {
        clinica = new AppClinicaVeterinaria();
        clinica.menu();
    }

    public AppClinicaVeterinaria() {
        this.animales = new ArrayList<>();
        this.veterinarios = new ArrayList<>();
        this.personalAdministrativo = new ArrayList<>();
        this.sc = new Scanner(System.in);
    }

    public List<Animal> getAnimales() {
        return animales;
    }

    public List<Veterinario> getVeterinarios() {
        return veterinarios;
    }

    public List<PersonalAdministrativo> getPersonalAdministrativo() {
        return personalAdministrativo;
    }

    void agregarAnimal(Animal animal) {
        animales.add(animal);
    }

    void agregarVeterinario(Veterinario veterinario) {
        veterinarios.add(veterinario);
    }

    void agregarPersonalAdministrativo(PersonalAdministrativo personal) {
        personalAdministrativo.add(personal);
    }

    private void eliminarAnimal(Animal animal) {
        animales.remove(animal);
    }

    private void eliminarPersonal(Personal p){
        if(p instanceof Veterinario){
            veterinarios.remove((Veterinario)p);
        } else if(p instanceof PersonalAdministrativo){
            personalAdministrativo.remove((PersonalAdministrativo)p);
        }
    }

    private Animal buscarAnimalPorId(int id) {
        for (Animal animal : animales) {
            if (animal.getId() == id) {
                return animal;
            }
        }
        return null;
    }

    private Personal buscarPersonalPorId(int id){
        System.out.println("¿Estás buscando Personal Administrativo o Veterinario? Elige 1 o 2");
        Personal p = null;
        int aux = sc.nextInt();
        sc.nextLine(); // Limpiar el buffer
        if(aux==1){
            for (PersonalAdministrativo personal : personalAdministrativo) {
                if (personal.getId() == id) {
                    p = personal;
                    break;
                }
            }
        } else if(aux==2){
            for (Veterinario veterinario : veterinarios) {
                if (veterinario.getId() == id) {
                    p = veterinario;
                    break;
                }
            }
        } else {
            System.out.println("Valor introducido incorrecto, vuelva a intentarlo.");
            p = buscarPersonalPorId(id);
        }
        return p;
    }

    private void modificarAnimalPorId(int id){
        Animal animal = buscarAnimalPorId(id);
        String aux1="";
        System.out.println("¿Qué atributo quieres modificar?\n 1.Nombre\n 2.Especie\n 3.Raza\n 4.Edad\n 5.HistorialClinico\n");
        int aux2 = sc.nextInt();
        sc.nextLine(); // Limpiar el buffer
        switch(aux2){
            case 1:
                System.out.println("Escriba el nuevo nombre: ");
                aux1 = sc.nextLine();
                animal.setNombre(aux1);
                break;
            case 2:
                System.out.println("Escriba la nueva especie: ");
                aux1 = sc.nextLine();
                animal.setEspecie(aux1);
                break;
            case 3:
                System.out.println("Escriba la nueva raza: ");
                aux1 = sc.nextLine();
                animal.setRaza(aux1);
                break;
            case 4:
                System.out.println("Escriba la nueva edad: ");
                aux2 = sc.nextInt();
                animal.setEdad(aux2);
                break;
        }
    }

    private void modificarPersonalPorId(int id){
        Personal p = buscarPersonalPorId(id);
        String aux1="";
        System.out.println("¿Qué atributo quieres modificar?\n 1.Nombre\n 2.Especialidad\n 3.Años Experiencia\n ");
        int aux2 = sc.nextInt();
        sc.nextLine(); // Limpiar el buffer
        switch(aux2){
            case 1:
                System.out.println("Escriba el nuevo nombre: ");
                aux1 = sc.nextLine();
                p.setNombre(aux1);
                break;
            case 2:
                System.out.println("Escriba la nueva especialidad: ");
                aux1 = sc.nextLine();
                p.setEspecialidad(aux1);
                break;
            case 3:
                System.out.println("Escriba el nuevo valor: ");
                aux2 = sc.nextInt();
                p.setAñosExperiencia(aux2);
                break;
        }
    }

    private void consultarHistorialClinicoPorId(int id){
        Animal animal = buscarAnimalPorId(id);
        int aux = 0;
        for(Visita i : animal.getHistorialClinico().getVisitas()){
            aux++;
            System.out.println("Visita num." + aux + " - Día: " + i.getFecha().toString() + " - Veterinario: "+i.getVeterinario().getNombre() + "\n - Motivo: "+i.getMotivoVisita()+" - Diagnóstico: "+i.getDiagnostico()+"\n - Tratamiento: "+i.getTratamiento()+"\n");
        }
    }

    private void registrarHistorialClinicoPorId(int id){
        Animal animal = buscarAnimalPorId(id);
        HistorialClinico historial = new HistorialClinico(animal);
        animal.setHistorialClinico(historial);
    }

    private void asignarPersonalAnimalPorId(int p, int a){
        Animal animal = buscarAnimalPorId(a);
        animal.setpAssignado(buscarPersonalPorId(p));
    }

    public void menu(){
        while(true) {
            System.out.println("1. Crear un animal");
            System.out.println("2. Modificar un animal");
            System.out.println("3. Eliminar un animal");
            System.out.println("4. Registrar Historial Médico de un animal");
            System.out.println("5. Consultar Historial Médico de un animal");
            System.out.println("6. Crear Personal Administrativo/Veterinario");
            System.out.println("7. Modificar Personal Administrativo/Veterinario");
            System.out.println("8. Eliminar Personal Administrativo/Veterinario");
            System.out.println("9. Asignar Veterinario/Personal Administrativo a un animal");
            System.out.println("0. Salir");
            int aux = sc.nextInt();
            sc.nextLine(); // Limpiar el buffer
            if(aux==0){
                break;
            }
            int id;
            String aux1;
            String aux2;
            String aux3;
            int aux4;
            switch (aux) {
                case 1:
                    System.out.println("Introduzca el nombre del animal: ");
                    aux1 = sc.nextLine();
                    System.out.println("Introduzca la especie del animal: ");
                    aux2 = sc.nextLine();
                    System.out.println("Introduzca la raza del animal: ");
                    aux3 = sc.nextLine();
                    System.out.println("Introduzca la edad del animal: ");
                    aux4 = sc.nextInt();
                    Animal animal = new Animal(aux1, aux2, aux3, aux4, null, null);
                    agregarAnimal(animal);
                    System.out.println("Animal creado con éxito!");
                    break;
                case 2:
                    System.out.println("Introduzca el id del animal a modificar: ");
                    id = sc.nextInt();
                    modificarAnimalPorId(id);
                    System.out.println("ID modificado con éxito!");
                    break;
                case 3:
                    System.out.println("Introduzca el id del animal a eliminar: ");
                    id = sc.nextInt();
                    eliminarAnimal(buscarAnimalPorId(id));
                    System.out.println("ID eliminado con éxito!");
                    break;
                case 4:
                    System.out.println("Introduzca el id del animal a registrar: ");
                    id = sc.nextInt();
                    registrarHistorialClinicoPorId(id);
                    System.out.println("ID registrado con éxito!");
                    break;
                case 5:
                    System.out.println("Introduzca el id del animal a consultar: ");
                    id = sc.nextInt();
                    consultarHistorialClinicoPorId(id);
                    break;
                case 6:
                    System.out.println("¿Quieres crear Personal Administrativo o Veterinario? Elige 1 o 2");
                    int tmp = sc.nextInt();
                    sc.nextLine(); // Limpiar el buffer
                    if (tmp == 1) {
                        System.out.println("Introduzca el nombre del nuevo: ");
                        aux1 = sc.nextLine();
                        System.out.println("Introduzca la especialidad del nuevo: ");
                        aux2 = sc.nextLine();
                        System.out.println("Introduzca los años de experiencia del nuevo: ");
                        aux4 = sc.nextInt();
                        Personal pa = new PersonalAdministrativo(aux1, aux2, aux4);
                        agregarPersonalAdministrativo((PersonalAdministrativo) pa);
                        System.out.println("Administrativo creado con éxito!");
                    } else if (tmp == 2) {
                        System.out.println("Introduzca el nombre del nuevo: ");
                        aux1 = sc.nextLine();
                        System.out.println("Introduzca la especialidad del nuevo: ");
                        aux2 = sc.nextLine();
                        System.out.println("Introduzca los años de experiencia del nuevo: ");
                        aux4 = sc.nextInt();
                        Personal v = new Veterinario(aux1, aux2, aux4, null);
                        agregarVeterinario((Veterinario) v);
                        System.out.println("Veterinario creado con éxito!");
                    } else {
                        System.out.println("Valor introducido incorrecto, vuelva a intentarlo.");
                    }
                    break;
                case 7:
                    System.out.println("Introduzca el id del Personal Administrativo/Veterinario a modificar: ");
                    id = sc.nextInt();
                    modificarPersonalPorId(id);
                    System.out.println("ID modificado con éxito!");
                    break;
                case 8:
                    System.out.println("Introduzca el id del Personal Administrativo/Veterinario a eliminar: ");
                    id = sc.nextInt();
                    eliminarPersonal(buscarPersonalPorId(id));
                    System.out.println("ID de personal eliminado con éxito!");
                    break;
                case 9:
                    System.out.println("Introduzca el id del Personal Administrativo/Veterinario a asignar: ");
                    int p = sc.nextInt();
                    System.out.println("Introduzca el id del animal a asignar: ");
                    int a = sc.nextInt();
                    asignarPersonalAnimalPorId(p, a);
                    System.out.println("ID asignado al personal!");
                    break;
                default:
                    System.out.println("Opción inválida, por favor, elija nuevamente.");
                    break;
            }
        }
    }
}
