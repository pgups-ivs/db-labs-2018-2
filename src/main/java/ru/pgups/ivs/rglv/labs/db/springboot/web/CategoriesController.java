package ru.pgups.ivs.rglv.labs.db.springboot.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ru.pgups.ivs.rglv.labs.db.repository.CategoryRepository;
import ru.pgups.ivs.rglv.labs.db.repository.FilmRepository;

@Controller
public class CategoriesController {
    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    FilmRepository filmRepository;

    @GetMapping("/category")
    public String listCategories(Model model) {
        model.addAttribute(
            "catogories",
            categoryRepository.findAll(Sort.by(Sort.Order.asc("name")))
        );
        return "categoriesList";
    }

    @GetMapping("/category/{categoryId}")
    public String categoryDetails(Model model, @PathVariable Long categoryId) {
        model.addAttribute("category", categoryRepository.getOne(categoryId));
        model.addAttribute("films", filmRepository.findAllForCategory(categoryId));

        return "categoryView";
    }
}
