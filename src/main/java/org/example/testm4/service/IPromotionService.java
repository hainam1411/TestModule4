package org.example.testm4.service;

import org.example.testm4.model.Promotion;
import org.springframework.validation.BindingResult;

import java.util.List;

public interface IPromotionService {
    Promotion save(Promotion promotion, BindingResult bindingResult);
    Promotion update(Promotion promotion, Long id, BindingResult bindingResult);
    Promotion findById(Long id);
    Promotion delete(Long id);
    List<Promotion> findAll();
}
