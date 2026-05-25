package com.kinnn.catalogservice.domains.product;

class ProductMapper {

    static ProductRecord mapToProductRecord(ProductEntity productEntity) {
        return new ProductRecord(
                productEntity.getCode(),
                productEntity.getName(),
                productEntity.getDescription(),
                productEntity.getImageUrl(),
                productEntity.getPrice());
    }
}
