package com.chris.userporfiles.Service.Impl;

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
    public Languages saveLanguajes(Languages languages) {
        return languajesRepository.save(languages);
    }

    @Override
    public void deleteLanguajes(Languages languages) {
        languajesRepository.delete(languages);
    }

    @Override
    public boolean existsLanguajes(Integer id) {
        return languajesRepository.existsById(id);
    }

    @Override
    public Languages getLanguajesById(Integer id) {
        return languajesRepository.findById(id).orElse(null);
    }
}
