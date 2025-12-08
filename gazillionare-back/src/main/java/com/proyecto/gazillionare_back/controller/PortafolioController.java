package com.proyecto.gazillionare_back.controller;


import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.proyecto.gazillionare_back.clases.*;
@RestController
@RequestMapping("/api/portafolio")
public class PortafolioController {

    private final Portafolio portafolio = new Portafolio();

    @GetMapping
    public List<Inversion> getAll() {
        return portafolio.getInversiones();
    }

    @PostMapping
    public void agregar(@RequestBody Inversion inv) {
        portafolio.agregar(inv);
    }
}
