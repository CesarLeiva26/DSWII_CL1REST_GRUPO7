package edu.pe.cibertec.DSWII_CL1REST_GRUPO7.Service;

import edu.pe.cibertec.DSWII_CL1REST_GRUPO7.Model.MensajeResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Service
public class EjercicioService {

    public MensajeResponse calcularCostoEstacionamiento(Integer horas, Integer minutos) {
        double costo = (horas + (minutos / 60.0)) * 1500.0;
        return MensajeResponse.builder().resultado(
        "El costo de estacionamiento es: $/." + costo).build();
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

    public MensajeResponse numerosParesDescendentes() {
        List<Integer> numerosPares = new ArrayList<>();
        for (int i = 20; i >= 10; i--) {
            if (i % 2 == 0) {
                numerosPares.add(i);
            }
        }
        return MensajeResponse.builder().resultado(numerosPares.toString()).build();
    }

    public MensajeResponse calcularPago(int cantidad, double precio) {
        double valorPagar = cantidad * precio;
        if (valorPagar > 200.0) {
            valorPagar *= 0.8;
        }
        String mensaje = "El valor a pagar es: $/." + valorPagar;
        return MensajeResponse.builder().resultado(mensaje).build();
    }
}




