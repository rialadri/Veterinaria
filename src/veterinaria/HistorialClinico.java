package veterinaria;

import java.util.ArrayList;
import java.util.List;

public class HistorialClinico {

        private Animal animal;
        private List<Visita> visitas;
        
        public HistorialClinico(Animal animal){
            this.animal = animal;
            this.visitas = new ArrayList<>();
        }
        
        public Animal getAnimal() {
                return animal;
        }

        public void setAnimal(Animal animal) {
                this.animal = animal;
        }

        public List<Visita> getVisitas() {
                return visitas;
        }

        public void setVisitas(List<Visita> visitas) {
                this.visitas = visitas;
        }

        public void addVisita(Visita visita) {
                visitas.add(visita);
        }
}