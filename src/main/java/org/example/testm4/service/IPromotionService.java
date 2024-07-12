package org.example.testm4.service;

import org.example.testm4.model.Promotion;
import org.example.testm4.model.PromotionDTO;

import java.util.List;

public interface IPromotionService {
    Iterable<PromotionDTO> getPromotions(Double minRate, Double maxRate, String startDate, String endDate);

    void save(Promotion promotion);

    void deleteById(Long id);
}
