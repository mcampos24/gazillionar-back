package com.proyecto.gazillionare_back.controller;
import com.proyecto.gazillionare_back.clases.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/portafolio")
public class PortafolioController{

    private final Portafolio portafolio = new Portafolio();

    @GetMapping
    public List<Inversion> listarTodas() {
        return portafolio.getInversiones();
    }
    @GetMapping("/total-invertido")
    public double getTotalInvertido() {
        return portafolio.calcularTotalInvertido();
    }

    @GetMapping("/info")
    public String getInfoPortafolio() {
        return portafolio.toString();
    }
    @PostMapping
    public ResponseEntity<Inversion> agregar(@RequestBody Inversion inv) {
        if (inv == null || inv.getNombre() == null || inv.getNombre().trim().isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        portafolio.agregar(inv);
        return ResponseEntity.ok(inv);
    }

    @DeleteMapping("/{nombre}")
    public ResponseEntity<Void> eliminar(@PathVariable String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        boolean eliminado = portafolio.eliminarPorNombre(nombre);
        if (eliminado) {
            return ResponseEntity.noContent().build(); // 204 No Content
        } else {
            return ResponseEntity.notFound().build(); // 404
        }
    }

    @PostMapping("/comparar")
    public ResponseEntity<ComparacionInversiones> comparar(@RequestBody List<String> nombres) {
        if (nombres == null || nombres.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }

        List<Inversion> seleccionadas = portafolio.obtenerInversionesPorNombres(nombres);

        if (seleccionadas.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        ComparacionInversiones comparacion = new ComparacionInversiones(seleccionadas);
        return ResponseEntity.ok(comparacion);
    }
    @GetMapping("/buscar/{nombre}")
    public ResponseEntity<Inversion> buscarPorNombre(@PathVariable String nombre) {
        Inversion inv = portafolio.buscarPorNombre(nombre);
        if (inv != null) {
            return ResponseEntity.ok(inv);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("/limpiar")
    public ResponseEntity<Void> limpiarPortafolio() {
        portafolio.limpiar();
        return ResponseEntity.noContent().build();
    }
}
