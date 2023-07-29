package com.hand.content.model.dto;

import lombok.Data;

@Data
public class SubCategoryParams {
    private String categoryId;
    private Long page;
    private Long pageSize;
    private String sortField;
}
