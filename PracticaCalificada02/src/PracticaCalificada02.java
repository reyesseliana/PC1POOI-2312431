
import java.util.List;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Lenovo
 */

import java.util.List;

public class PracticaCalificada02 {
    public static void main(String[] args) {
      
        SistemaDelHospital hospital = new SistemaDelHospital();

        Medico medico1 = new Medico(1, "Dr. Smith", "Cardiología");
        Medico medico2 = new Medico(2, "Dr. Johnson", "Pediatría");

        Paciente paciente1 = new Paciente(123456, "Juan Perez", "Calle Arevalo 1203", 70.5, 98.6);
        Paciente paciente2 = new Paciente(789012, "Ana Rodriguez", "Calle Bendita 3320", 65.2, 99.2);
        Paciente paciente3 = new Paciente(345678, "Carlos Gonzalez", "Calle C", 80.0, 97.5);
        Paciente paciente4 = new Paciente(901234, "Laura Martinez", "Calle D", 55.8, 98.9);

        paciente1.medicoAsignado = medico1;
        paciente2.medicoAsignado = medico2;
        paciente3.medicoAsignado = medico1;
        paciente4.medicoAsignado = medico2;

        hospital.registrarPaciente(paciente1);
        hospital.registrarPaciente(paciente2);
        hospital.registrarPaciente(paciente3);
        hospital.registrarPaciente(paciente4);

        hospital.mostrarPesoMayorMenor();
        hospital.dividirRangoPesos();
        hospital.mostrarListaPacientesOrdenados();

        Paciente pacienteBusqueda = hospital.pacientes.get(0);
        Medico medicoAtendio = hospital.obtenerMedicoDePaciente(pacienteBusqueda);
        System.out.println("El paciente " + pacienteBusqueda.nombre + " fue atendido por el " + medicoAtendio.nombre);

        List<Medico> doctoresPediatras = hospital.buscarDoctoresPorEspecialidad("Pediatria");
        System.out.println("Doctor en Pediatria");
        for (Medico medico : doctoresPediatras) {
            System.out.println(medico.nombre);
        }
    }
}

        
