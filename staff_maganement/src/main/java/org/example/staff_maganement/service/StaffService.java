package org.example.staff_maganement.service;

import org.example.staff_maganement.model.Staff;
import org.example.staff_maganement.repository.StaffRepository;

import java.util.List;

public class StaffService implements IService<Staff>{
    private StaffRepository staffRepository = new StaffRepository();

    @Override
    public List<Staff> findAll() {
        return staffRepository.findAll();
    }

    @Override
    public Staff findById(int id) {
        return staffRepository.findById(id);
    }

    @Override
    public void save(Staff staff) {
        staffRepository.save(staff);
    }

    @Override
    public void update(Staff staff) {
        staffRepository.update(staff);
    }

    @Override
    public void delete(int id) {
        staffRepository.delete(id);
    }
}
