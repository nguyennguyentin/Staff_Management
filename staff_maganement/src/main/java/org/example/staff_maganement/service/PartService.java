package org.example.staff_maganement.service;
import org.example.staff_maganement.model.Part;
import org.example.staff_maganement.repository.PartRepository;

import java.util.List;

public class PartService implements IService<Part> {
    private PartRepository partRepository = new PartRepository();

    @Override
    public List<Part> findAll() {
        return partRepository.findAll();
    }

    @Override
    public Part findById(int id) {
        return partRepository.findById(id);
    }

    @Override
    public void save(Part part) {
        partRepository.save(part);
    }

    @Override
    public void update(Part part) {
        partRepository.update(part);
    }

    @Override
    public void delete(int id) {
        partRepository.delete(id);
    }
}
