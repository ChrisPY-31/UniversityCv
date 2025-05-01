package com.chris.userporfiles.Service.Impl;

import com.chris.userporfiles.Model.Entity.Aptitudes;
import com.chris.userporfiles.Repository.AptitudesRepository;
import com.chris.userporfiles.Service.AptitudesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AptitudesImpl implements AptitudesService {

    @Autowired
    private AptitudesRepository aptitudesRepository;

    @Override
    public Aptitudes saveAptitudes(Aptitudes aptitudes) {
        return aptitudesRepository.save(aptitudes);
    }

    @Override
    public void deleteAptitudes(Aptitudes aptitudes) {
        aptitudesRepository.delete(aptitudes);
    }

    @Override
    public Aptitudes aptitudGetId(Integer id) {
        return aptitudesRepository.findById(id).orElse(null);
    }

    @Override
    public Boolean existAptitudes(Integer id) {
        return aptitudesRepository.existsById(id);
    }

}
