package com.kinnn.catalogservice.domains.product;

import java.math.BigDecimal;

public record ProductRecord(String code, String name, String description, String imageUrl, BigDecimal price) {}
