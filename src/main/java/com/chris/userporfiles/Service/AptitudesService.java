package com.chris.userporfiles.Service;

import com.chris.userporfiles.Model.Entity.Aptitudes;

public interface AptitudesService {

    Aptitudes saveAptitudes(Aptitudes aptitudes);

    void deleteAptitudes(Aptitudes aptitudes);

    Aptitudes aptitudGetId(Integer id);

    Boolean existAptitudes(Integer id);
}
