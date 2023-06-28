package com.desaextremo.retodos.controller;

import com.desaextremo.retodos.entity.Gadget;
import com.desaextremo.retodos.service.GadgetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/gadget")
@CrossOrigin(origins = "*")
public class GadgetController {
    //atributo de relacion
    @Autowired
    private GadgetService service;

    //listar todos los gadgets
    @GetMapping("/all")
    public List<Gadget> getAll(){
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Gadget getGadget(@PathVariable("id") Integer id){
        return service.getGadget(id);
    }

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Gadget registrar(@RequestBody Gadget gadget){
        return service.registrar(gadget);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public  Gadget actualizar(@RequestBody Gadget gadget){
        return service.actualizar(gadget);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id){
        return service.delete(id);
    }
}
