package com.software2.backend.controlador;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.software2.backend.modelo.Casa;

@RestController
@RequestMapping("/api/casas")
public class CasaControlador {
    private List<Casa> casas;

    public CasaControlador(){
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            Casa[] casasArray= objectMapper.readValue(new  ClassPathResource("casas.json").getFile(), Casa[].class);
            casas = new ArrayList<>(Arrays.asList(casasArray));
        } catch (Exception e) {
            e.printStackTrace();
            casas = new ArrayList<>();
        }
    }

    @GetMapping
    public List<Casa> getAllCasas(){
        return casas;
    }

    @GetMapping("/{id}")
    public Casa getCasaById(@PathVariable Long id){
        return casas.stream().filter(casa -> casa.getId().equals(id)).findFirst().orElse(null);
    }

    @PostMapping
    public Casa createCasa(@RequestBody Casa casa) {
        casas.add(casa);
        return casa;
    }

    @PutMapping("/{id}")
    public Casa updateCasa(@PathVariable Long id, @RequestBody Casa updatedCasa) {
        Casa casa = getCasaById(id);
        if (casa != null) {
            casa.setBarrio(updatedCasa.getBarrio());
            casa.setDireccion(updatedCasa.getDireccion());
            casa.setPrecio(updatedCasa.getPrecio());
            return casa;
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteCasa(@PathVariable Long id) {
        casas.removeIf(casa -> casa.getId().equals(id));
    }
}
