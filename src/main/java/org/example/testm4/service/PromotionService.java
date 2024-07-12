package org.example.testm4.service;

import org.example.testm4.model.Promotion;
import org.example.testm4.model.PromotionDTO;
import org.example.testm4.repository.IPromotionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PromotionService implements IPromotionService {

    @Autowired
    private IPromotionRepository promotionRepository;

    @Override
    public Iterable<PromotionDTO> getPromotions(Double minRate, Double maxRate, String startDate, String endDate) {
        return promotionRepository.getPromotionsWithSearch(minRate, maxRate, startDate, endDate);
    }

    @Override
    public void save(Promotion promotion) {
        promotionRepository.save(promotion);
    }

    @Override
    public void deleteById(Long id) {
        promotionRepository.deleteById(id);
    }
}

