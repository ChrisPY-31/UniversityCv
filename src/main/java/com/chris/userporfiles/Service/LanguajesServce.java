package com.chris.userporfiles.Service;

import com.chris.userporfiles.Model.Dto.LanguageDto;

public interface LanguajesServce {
    LanguageDto saveLanguajes(LanguageDto languageDto);

    void deleteLanguajes(LanguageDto languageDto);

    boolean existsLanguajes(Integer id);

    LanguageDto getLanguajesById(Integer id);

}
