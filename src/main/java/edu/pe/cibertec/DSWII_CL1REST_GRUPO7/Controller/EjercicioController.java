package edu.pe.cibertec.DSWII_CL1REST_GRUPO7.Controller;

import edu.pe.cibertec.DSWII_CL1REST_GRUPO7.Model.MensajeResponse;
import edu.pe.cibertec.DSWII_CL1REST_GRUPO7.Service.EjercicioService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping(path = "/api/ejercicio")
public class EjercicioController {

    public EjercicioService ejercicioService;

    @GetMapping("/calcularCostoEstacionamiento")
    public ResponseEntity<MensajeResponse> calcularCostoEstacionamiento(
            @RequestParam Integer horas,
            @RequestParam Integer minutos) {
        return new ResponseEntity<>(
                ejercicioService.calcularCostoEstacionamiento(horas, minutos), HttpStatus.OK);
    }
    @GetMapping("/calcularPromedio")
    public ResponseEntity<MensajeResponse> calcularPromedio(
            @RequestParam Double nota1,
            @RequestParam Double nota2,
            @RequestParam Double nota3,
            @RequestParam Double nota4) {
        MensajeResponse response = ejercicioService.calcularPromedio(nota1, nota2, nota3, nota4);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/averiguarDNI")
    public ResponseEntity<MensajeResponse> averiguarDNI(
            @RequestParam int anioNacimiento) {
        MensajeResponse respuesta = ejercicioService.averiguarDNI(anioNacimiento);
        return ResponseEntity.ok(respuesta);
    }

    @GetMapping("/paresDescendentes")
    public ResponseEntity<MensajeResponse> numerosParesDescendentes() {
        MensajeResponse respuesta = ejercicioService.numerosParesDescendentes();
        return ResponseEntity.ok(respuesta);
    }

    @GetMapping("/calcularPago")
    public ResponseEntity<MensajeResponse> calcularPago(
            @RequestParam int cantidad,
            @RequestParam double precio) {
        MensajeResponse respuesta = ejercicioService.calcularPago(cantidad, precio);
        return ResponseEntity.ok(respuesta);
    }
}