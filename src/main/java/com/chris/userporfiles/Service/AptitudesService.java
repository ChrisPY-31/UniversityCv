package com.chris.userporfiles.Service;

import com.chris.userporfiles.Model.Dto.AptitudesDto;
import com.chris.userporfiles.Model.Entity.Aptitudes;

import java.util.List;

public interface AptitudesService {

    List<AptitudesDto> getAptitudes();

    AptitudesDto saveAptitudes(AptitudesDto aptitudesDto);

    void deleteAptitudes(AptitudesDto aptitudesDto);

    AptitudesDto aptitudGetId(Integer id);

    Boolean existAptitudes(Integer id);
}
