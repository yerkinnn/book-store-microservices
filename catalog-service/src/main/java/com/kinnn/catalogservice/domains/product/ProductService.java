package com.kinnn.catalogservice.domains.product;

import com.kinnn.catalogservice.ApplicationProperties;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ProductService {

    private final ProductRepository productRepository;

    private final ApplicationProperties applicationProperties;

    ProductService(ProductRepository productRepository, ApplicationProperties applicationProperties) {
        this.productRepository = productRepository;
        this.applicationProperties = applicationProperties;
    }

    public PagedResult<ProductRecord> getProducts(int page) {
        Sort sort = Sort.by("name").ascending();
        page = page <= 1 ? 0 : page - 1;
        PageRequest pageRequest = PageRequest.of(page, applicationProperties.pageSize(), sort);

        Page<ProductRecord> productRecordsPage =
                productRepository.findAll(pageRequest).map(ProductMapper::mapToProductRecord);

        return new PagedResult<>(
                productRecordsPage.getContent(),
                productRecordsPage.getTotalElements(),
                productRecordsPage.getNumber() + 1,
                productRecordsPage.getTotalPages(),
                productRecordsPage.isFirst(),
                productRecordsPage.isLast(),
                productRecordsPage.hasNext(),
                productRecordsPage.hasPrevious());
    }
}
