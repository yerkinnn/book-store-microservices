package com.kinnn.catalogservice.web.controllers;

import com.kinnn.catalogservice.domains.product.PagedResult;
import com.kinnn.catalogservice.domains.product.ProductRecord;
import com.kinnn.catalogservice.domains.product.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping()
    PagedResult<ProductRecord> getProducts(@RequestParam(name = "page", defaultValue = "1") int page) {
        return productService.getProducts(page);
    }
}
