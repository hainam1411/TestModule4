package org.example.testm4.service;

import org.example.testm4.model.Promotion;
import org.example.testm4.repository.PromotionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import java.util.List;
import java.util.Optional;

@Service
public class PromotionService implements IPromotionService{
    private final PromotionRepository promotionRepository;
    @Autowired
    public PromotionService(PromotionRepository promotionRepository) {
        this.promotionRepository = promotionRepository;
    }

    @Override
    public Promotion save(Promotion promotion, BindingResult bindingResult) {
        return promotionRepository.save(promotion);
    }

    @Override
    public Promotion update(Promotion promotion, Long id, BindingResult bindingResult) {
        return promotionRepository.save(promotion);
    }

    @Override
    public Promotion findById(Long id) {
        Optional<Promotion> promotion = promotionRepository.findById(id);
        if (promotion.isPresent()) {
            return promotionRepository.findById(id).get();
        }
        throw new IllegalArgumentException();
    }

    @Override
    public Promotion delete(Long id) {
        Promotion promotion = findById(id);
        promotionRepository.deleteById(id);
        return promotion;
    }

    @Override
    public List<Promotion> findAll() {
        if( promotionRepository.findAll().isEmpty()){
            throw new IllegalArgumentException();
        }
        return promotionRepository.findAll();
    }
}