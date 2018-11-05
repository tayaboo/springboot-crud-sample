package com.yabubu.home.domain.service;

import com.yabubu.home.domain.entity.Praise;
import com.yabubu.home.domain.repository.PraiseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PraiseService {

    private final PraiseRepository praiseRepository;

    public PraiseService(PraiseRepository praiseRepository) {
        this.praiseRepository = praiseRepository;
    }

    public List<Praise> getAllPraise() {
        return praiseRepository.findAll();
    }

    public void registerPraise(Praise praise) {
        praiseRepository.save(praise);
    }
}
