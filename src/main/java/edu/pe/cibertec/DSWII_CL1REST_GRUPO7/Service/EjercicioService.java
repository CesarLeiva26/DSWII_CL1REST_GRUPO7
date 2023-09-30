package edu.pe.cibertec.DSWII_CL1REST_GRUPO7.Service;

import edu.pe.cibertec.DSWII_CL1REST_GRUPO7.Model.MensajeResponse;
import org.springframework.stereotype.Service;

import java.util.Calendar;

@Service
public class EjercicioService {

    public MensajeResponse calcularCostoEstacionamiento(Integer horas, Integer minutos) {
        double costo = (horas + (minutos / 60.0)) * 1500.0;
        return MensajeResponse.builder().resultado(
        "El costo de estacionamiento es: $" + costo).build();
    }

    public MensajeResponse calcularPromedio(
            Double nota1,
            Double nota2,
            Double nota3,
            Double nota4) {
        double promedio = (nota1 * 0.2) + (nota2 * 0.3) + (nota3 * 0.3) + (nota4 * 0.2);
        return MensajeResponse.builder().resultado(
        "El promedio es: " + promedio).build();
    }

    public MensajeResponse averiguarDNI(int anioNacimiento) {
        Calendar calendar = Calendar.getInstance();
        int anioActual = calendar.get(Calendar.YEAR);
        int edad = anioActual - anioNacimiento;
        String mensaje = edad >= 18 ? "Debe sacar su DNI" : "No nesecita sacar su DNI";
        return MensajeResponse.builder().resultado(mensaje).build();
    }
}




