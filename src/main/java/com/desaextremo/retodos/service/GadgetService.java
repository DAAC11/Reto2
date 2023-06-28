package com.desaextremo.retodos.service;

import com.desaextremo.retodos.entity.Gadget;
import com.desaextremo.retodos.repository.GadgetRepositoy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GadgetService {
    @Autowired
    private GadgetRepositoy repositorio;

    public List<Gadget> getAll() {
        return repositorio.findAll();
    }

    public Gadget getGadget(Integer id) {
        Optional<Gadget> optional = repositorio.findById(id);

        if (optional.isPresent()) return optional.get();
        else return new Gadget();
    }

    public Gadget registrar(Gadget gadget) {
        Gadget gadgetError = null;

        //comprueba id
        if (gadget.getId() != null) {
            //comprueba que no exita el id
            Optional<Gadget> optional = repositorio.findById(gadget.getId());
            if (optional.isPresent()) {
                gadgetError = new Gadget();
                gadgetError.setName("ID " + gadget.getId() + " ya existe");
                return gadgetError;
            } else {
                return repositorio.save(gadget);
            }
        } else {
            gadgetError = new Gadget();
            gadgetError.setName("ERROR");
            return gadgetError;
        }
    }

    public Gadget actualizar(Gadget gadget) {
        Gadget gadgetError;
        Gadget gadgetDB;

        //tiene id
        if (gadget.getId() != null) {
            //valdar si existe un gadget con el mismo id en la base de datos
            Optional<Gadget> optional = repositorio.findById(gadget.getId());
            if (optional.isPresent()) {
                gadgetDB = optional.get();
                if ((gadget.getBrand() != null) && (!gadget.getBrand().equals(""))) {
                    if (!gadgetDB.getBrand().equals(gadget.getBrand())) gadgetDB.setBrand(gadget.getBrand());
                }
                if ((gadget.getCategory() != null) && (!gadget.getCategory().equals(""))) {
                    if (!gadgetDB.getCategory().equals(gadget.getCategory()))
                        gadgetDB.setCategory(gadget.getCategory());
                }
                if ((gadget.getName() != null) && (!gadget.getName().equals(""))) {
                    if (!gadgetDB.getName().equals(gadget.getName()))
                        gadgetDB.setName(gadget.getName());
                }
                if ((gadget.getDescription() != null) && (!gadget.getDescription().equals(""))) {
                    if (!gadgetDB.getDescription().equals(gadget.getDescription()))
                        gadgetDB.setDescription(gadget.getDescription());
                }
                if (gadget.getPrice() != gadgetDB.getPrice()) {
                    gadgetDB.setPrice(gadget.getPrice());
                }
                if ((gadget.isAvailability() != gadgetDB.isAvailability())) {
                    gadgetDB.setAvailability(gadget.isAvailability());
                }
                if (gadget.getQuantity() != gadgetDB.getQuantity()) {
                    gadgetDB.setQuantity(gadget.getQuantity());
                }
                if ((gadget.getPhotography() != null) && (!gadget.getPhotography().equals(""))) {
                    if (!gadgetDB.getPhotography().equals(gadget.getPhotography()))
                        gadgetDB.setPhotography(gadget.getPhotography());
                }
                return repositorio.save(gadgetDB);
            } else {
                gadgetError = new Gadget();
                gadgetError.setDescription("No se envió un valor para la ID");
                return gadgetError;
            }

        } else {
            gadgetError = new Gadget();
            gadgetError.setDescription("No se envió un valor para la ID");
            return gadgetError;
        }
    }

    public boolean delete(int id){
        Gadget gadgetDelete;
        Optional<Gadget> optional = repositorio.findById(id);

        if (optional.isPresent()){
            gadgetDelete = optional.get();
            repositorio.delete(gadgetDelete);
            return true;
        }else {
            return false;
        }
    }
}

