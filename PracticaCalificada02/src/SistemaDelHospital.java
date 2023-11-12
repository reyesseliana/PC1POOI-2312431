
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Lenovo
 */
public class SistemaDelHospital {
     List<Paciente> pacientes = new ArrayList<>();
    List<Medico> medicos = new ArrayList<>();

    public void registrarPaciente(Paciente paciente) {
        pacientes.add(paciente);
    }

    public void eliminarPaciente(int posicion) {
        pacientes.remove(posicion);
    }

    public void modificarPaciente(int posicion, Paciente nuevoPaciente) {
        pacientes.set(posicion, nuevoPaciente);
    }

    public double mostrarPesoMasRepetido() {
        Map<Double, Integer> pesoFrecuencia = new HashMap<>();

        for (Paciente paciente : pacientes) {
            double peso = paciente.peso;
            pesoFrecuencia.put(peso, pesoFrecuencia.getOrDefault(peso, 0) + 1);
        }

        return pesoFrecuencia.entrySet().stream().max(Map.Entry.comparingByValue()).map(Map.Entry::getKey).orElse(0.0);
    }

    public int mostrarCantidadPacientesPesoMasRepetido() {
        double pesoMasRepetido = mostrarPesoMasRepetido();
        return (int) pacientes.stream().filter(paciente -> paciente.peso == pesoMasRepetido).count();
    }

    public void mostrarPesoMayorMenor() {
        double pesoMayor = pacientes.stream().mapToDouble(paciente -> paciente.peso).max().orElse(0.0);
        double pesoMenor = pacientes.stream().mapToDouble(paciente -> paciente.peso).min().orElse(0.0);

        System.out.println("Peso Mayor: " + pesoMayor);
        System.out.println("Peso Menor: " + pesoMenor);
    }

    public void dividirRangoPesos() {
        int[] rangos = new int[4];
        double pesoMinimo = pacientes.stream().mapToDouble(paciente -> paciente.peso).min().orElse(0.0);
        double pesoMaximo = pacientes.stream().mapToDouble(paciente -> paciente.peso).max().orElse(0.0);
        double rango = (pesoMaximo - pesoMinimo) / 4;

        for (Paciente paciente : pacientes) {
            double peso = paciente.peso;
            if (peso >= pesoMinimo && peso < pesoMinimo + rango) {
                rangos[0]++;
            } else if (peso >= pesoMinimo + rango && peso < pesoMinimo + 2 * rango) {
                rangos[1]++;
            } else if (peso >= pesoMinimo + 2 * rango && peso < pesoMinimo + 3 * rango) {
                rangos[2]++;
            } else {
                rangos[3]++;
            }
        }

        for (int i = 0; i < 4; i++) {
            System.out.println("Rango " + (i + 1) + ": " + rangos[i] + " personas");
        }
    }

    public void mostrarListaPacientesOrdenados() {
        pacientes.sort((p1, p2) -> p1.nombre.compareTo(p2.nombre));
        for (Paciente paciente : pacientes) {
            System.out.println(paciente.nombre);
        }
    }

    public Medico obtenerMedicoDePaciente(Paciente paciente) {
        return paciente.medicoAsignado;
    }

    public List<Medico> buscarDoctoresPorEspecialidad(String especialidad) {
        List<Medico> doctoresEncontrados = new ArrayList<>();
        for (Medico medico : medicos) {
            if (medico.especialidad.equals(especialidad)) {
                doctoresEncontrados.add(medico);
            }
        }
        return doctoresEncontrados;
    }}

    
