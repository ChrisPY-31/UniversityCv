package com.chris.userporfiles.Service.Impl;

import com.chris.userporfiles.Mappers.LanguageMappers;
import com.chris.userporfiles.Model.Dto.LanguageDto;
import com.chris.userporfiles.Model.Entity.Languages;
import com.chris.userporfiles.Repository.LanguajesRepository;
import com.chris.userporfiles.Service.LanguajesServce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LanguajesImpl implements LanguajesServce {

    @Autowired
    private LanguajesRepository languajesRepository;

    @Override
    public LanguageDto saveLanguajes(LanguageDto languageDto) {
        Languages languages = LanguageMappers.INSTANCE.toLanguage(languageDto);
        languajesRepository.save(languages);
        return languageDto;
    }

    @Override
    public void deleteLanguajes(LanguageDto languageDto) {
        languajesRepository.delete(LanguageMappers.INSTANCE.toLanguage(languageDto));
    }

    @Override
    public boolean existsLanguajes(Integer id) {
        return languajesRepository.existsById(id);
    }

    @Override
    public LanguageDto getLanguajesById(Integer id) {
        return languajesRepository.findById(id).map(LanguageMappers.INSTANCE::toLanguageDto).orElse(null);
    }
}
