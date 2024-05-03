package veterinaria;

import java.util.Date;
public class Visita {
    private Date fecha;
    private Veterinario veterinario;
    private String motivoVisita;
    private String diagnostico;
    private String tratamiento;
    
    public Visita(Date fecha, Veterinario veterinario, String motivoVisita, String diagnostico, String tratamiento){
        this.fecha=fecha;
        this.veterinario=veterinario;
        this.motivoVisita=motivoVisita;
        this.diagnostico=diagnostico;
        this.tratamiento=tratamiento;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha=fecha;
    }

    public Veterinario getVeterinario() {
        return veterinario;
    }

    public void setVeterinario(Veterinario veterinario) {
        this.veterinario=veterinario;
    }

    public String getMotivoVisita() {
        return motivoVisita;
    }

    public void setMotivoVisita(String motivoVisita) {
        this.motivoVisita=motivoVisita;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico=diagnostico;
    }

    public String getTratamiento() {
        return tratamiento;
    }

    public void setTratamiento(String tratamiento) {
        this.tratamiento=tratamiento;
    }
    
    
}