package org.example.testm4.controller;

import org.example.testm4.model.Promotion;
import org.example.testm4.service.IPromotionService;
import org.example.testm4.service.PromotionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/promotion")
public class PromotionController {
    private final PromotionService promotionService;

    @Autowired
    public PromotionController(PromotionService promotionService) {
        this.promotionService = promotionService;
    }

    @GetMapping
    public ResponseEntity<List<Promotion>> getAll() {
        return new ResponseEntity<>(promotionService.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Promotion> create(@Validated @RequestBody Promotion promotion, BindingResult bindingResult) {
        return new ResponseEntity<>(promotionService.save(promotion, bindingResult), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Promotion> update(@Validated @RequestBody Promotion promotion, @PathVariable Long id, BindingResult bindingResult) {
        return new ResponseEntity<>(promotionService.update(promotion, id, bindingResult), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Promotion> delete(@PathVariable Long id) {
        return new ResponseEntity<>(promotionService.delete(id), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Promotion> getCategoryById(@PathVariable Long id) {
        return new ResponseEntity<>(promotionService.findById(id), HttpStatus.OK);
    }
}