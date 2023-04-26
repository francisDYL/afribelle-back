package com.afrimoov.afribelle.controller;

import com.afrimoov.afribelle.dto.CategoryDto;
import com.afrimoov.afribelle.dto.SearchCriteria;
import com.afrimoov.afribelle.exceptions.NotFoundException;
import com.afrimoov.afribelle.service.ICategoryService;
import com.afrimoov.afribelle.utils.SearchCriteriaUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/categories")
@Slf4j
public class CategoryController {

    static String SEARCH_PARAM = "%s:*%s*,";

    @Autowired
    ICategoryService categoryService;

    @PostMapping(value = "/saveCategories")
    public ResponseEntity<List<CategoryDto>> saveCategories(@RequestBody List<CategoryDto> categories) {
        return ResponseEntity.ok(categoryService.createCategories(categories));
    }

    @PutMapping(value = "/updateCategories")
    public ResponseEntity<List<CategoryDto>> updateCategories(@RequestBody List<CategoryDto> categories) throws NotFoundException {
        return ResponseEntity.ok(categoryService.updateCategories(categories));
    }

    @DeleteMapping(value = "/deleteCategories")
    public ResponseEntity<List<Long>> deleteCategories(@RequestBody List<Long> categories) {
        return ResponseEntity.ok(categoryService.deleteCategories(categories));
    }

    @GetMapping(value = "/getAll")
    public ResponseEntity<Page<CategoryDto>> getAll( @RequestParam(name="page", required = false, defaultValue = "0") int page,
                                          @RequestParam(name="size", required = false, defaultValue = "50") int size) {
        final Pageable pageable = PageRequest.of(page, size);
        return ResponseEntity.ok(categoryService.getAll(pageable));
    }

    @GetMapping(value = "/getCategorieById")
    public ResponseEntity<CategoryDto> getById(@RequestParam(name="id") Long id) throws NotFoundException {
        return ResponseEntity.ok(categoryService.getById(id));
    }

    @GetMapping(value = "/getCategoriesByType")
    public ResponseEntity<Page<CategoryDto>> getCategoryByType(
            @RequestParam(name="type") String type,
            @RequestParam(name="page", required = false, defaultValue = "0") int page,
            @RequestParam(name="size", required = false, defaultValue = "50") int size) {

        String searchToken = String.format(SEARCH_PARAM, "type", type);

        return ResponseEntity.ok(findByCriterais(searchToken, page, size));
    }

    @GetMapping(value = "/searchCategorieByName")
    public ResponseEntity<Page<CategoryDto>> searchByName(
            @RequestParam(name="name") String name,
            @RequestParam(name="page", required = false, defaultValue = "0") int page,
            @RequestParam(name="size", required = false, defaultValue = "50") int size
            ) {

        String searchToken = String.format(SEARCH_PARAM, "name", name);
        return ResponseEntity.ok(findByCriterais(searchToken, page, size));
    }

    private Page<CategoryDto> findByCriterais(String searchToken, int page, int size) {
        final Pageable pageRequest = PageRequest.of(page, size);

        final List<SearchCriteria> criterias = SearchCriteriaUtils.build(searchToken);
        return categoryService.findByCriteria(criterias, pageRequest);
    }
}
