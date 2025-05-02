package com.chris.userporfiles.Service;

import com.chris.userporfiles.Model.Entity.Languages;
import com.chris.userporfiles.Model.Entity.Skills;

public interface LanguajesServce {
    Languages saveLanguajes(Languages languages);

    void deleteLanguajes(Languages languages);

    boolean existsLanguajes(Integer id);

    Languages getLanguajesById(Integer id);

}
