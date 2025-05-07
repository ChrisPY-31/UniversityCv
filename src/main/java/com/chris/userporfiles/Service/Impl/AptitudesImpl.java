package com.chris.userporfiles.Service.Impl;

import com.chris.userporfiles.Mappers.AptitudesMappers;
import com.chris.userporfiles.Model.Dto.AptitudesDto;
import com.chris.userporfiles.Model.Entity.Aptitudes;
import com.chris.userporfiles.Repository.AptitudesRepository;
import com.chris.userporfiles.Service.AptitudesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AptitudesImpl implements AptitudesService {

    @Autowired
    private AptitudesRepository aptitudesRepository;

    @Override
    public List<AptitudesDto> getAptitudes() {
        return aptitudesRepository.findAll().stream().map(AptitudesMappers.INSTANCE::toAptitudesDto).toList();
    }

    @Override
    public AptitudesDto saveAptitudes(AptitudesDto aptitudesDto) {
        Aptitudes aptitudes = AptitudesMappers.INSTANCE.toAptitudes(aptitudesDto);
        aptitudesRepository.save(aptitudes);
        return aptitudesDto;
    }

    @Override
    public void deleteAptitudes(AptitudesDto aptitudesDto) {
        Aptitudes aptitudes = AptitudesMappers.INSTANCE.toAptitudes(aptitudesDto);
        aptitudesRepository.delete(aptitudes);
    }

    @Override
    public AptitudesDto aptitudGetId(Integer id) {
        return aptitudesRepository.findById(id).map(AptitudesMappers.INSTANCE::toAptitudesDto).orElse(null);
    }

    @Override
    public Boolean existAptitudes(Integer id) {
        return aptitudesRepository.existsById(id);
    }

}
