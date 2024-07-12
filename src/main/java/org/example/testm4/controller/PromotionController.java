package org.example.testm4.controller;

import org.example.testm4.model.Promotion;
import org.example.testm4.model.PromotionDTO;
import org.example.testm4.service.IPromotionService;
import org.example.testm4.service.PromotionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/promotions")
public class PromotionController {
    @Autowired
    private IPromotionService promotionService;



    @RequestMapping("")
    public String index(
            @RequestParam(required = false) Double minRate,
            @RequestParam(required = false) Double maxRate,
            @RequestParam(required = false) String startDate,
            @RequestParam(required = false) String endDate,
            Model model
    ) {
        Iterable<PromotionDTO> promotions = promotionService.getPromotions(minRate, maxRate, startDate, endDate);
        model.addAttribute("promotions", promotions);
        model.addAttribute("minRate", minRate);
        model.addAttribute("maxRate", maxRate);
        model.addAttribute("startDate", startDate);
        model.addAttribute("endDate", endDate);
        return "promotions/index";
    }


    @RequestMapping("/create")
    public String create(Model model) {
        model.addAttribute("promotion", new Promotion());
        return "promotions/create";
    }


    @PostMapping("/create")
    public String create(
            @Validated @ModelAttribute Promotion promotion,
            BindingResult bindingResult,
            RedirectAttributes redirectAttributes
    ) {
        if (bindingResult.hasFieldErrors()) {
            return "promotions/create";
        }
        promotionService.save(promotion);
        redirectAttributes.addFlashAttribute("success", "Thêm mới thành công");
        return "redirect:/promotions";
    }

    @RequestMapping("/{id}/delete")
    public String delete(
            @PathVariable Long id,
            RedirectAttributes redirectAttributes
    ) {
        promotionService.deleteById(id);
        redirectAttributes.addFlashAttribute("success", "Xóa thành công");
        return "redirect:/promotions";
    }
}

