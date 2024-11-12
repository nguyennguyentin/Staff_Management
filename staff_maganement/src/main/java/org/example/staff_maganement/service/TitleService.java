package org.example.staff_maganement.service;

import org.example.staff_maganement.model.Title;
import org.example.staff_maganement.repository.TitleRepository;

import java.util.List;

public class TitleService implements IService<Title> {
    private TitleRepository titleRepository = new TitleRepository();

    @Override
    public List<Title> findAll() {
        return titleRepository.findAll();
    }

    @Override
    public Title findById(int id) {
        return titleRepository.findById(id);
    }

    @Override
    public void save(Title title) {
        titleRepository.save(title);
    }

    @Override
    public void update(Title title) {
        titleRepository.update(title);
    }

    @Override
    public void delete(int id) {
        titleRepository.delete(id);
    }
}
