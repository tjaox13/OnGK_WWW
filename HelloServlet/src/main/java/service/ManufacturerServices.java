package service;

import repository.CRUDreponsitory;

import java.util.List;

import entity.Manufacturer;

public class ManufacturerServices  {
    private CRUDreponsitory<Manufacturer, Long> cruDreponsitory;

    public ManufacturerServices() {
        cruDreponsitory = new CRUDreponsitory<>("Manufacturer");
    }

    public Manufacturer save(Manufacturer Manufacturer) {
        return cruDreponsitory.save(Manufacturer);
    }

    public List<Manufacturer> findAll() {
        return cruDreponsitory.findAll();

    }

//    public Manufacturer findById(long Manufacturerid) {
//        return gRepository.findById(Manufacturerid);
//    }

    public Manufacturer findById(Manufacturer Manufacturer, long Manufacturerid) {
        return cruDreponsitory.findByEntity(Manufacturer, Manufacturerid);
    }

    public Manufacturer updateManufacturer(Manufacturer Manufacturer) {
        return cruDreponsitory.update(Manufacturer);
    }

    public Manufacturer deleteManufacturer(Manufacturer Manufacturer, long id) {
        return cruDreponsitory.delete(Manufacturer, id);
    }
}
