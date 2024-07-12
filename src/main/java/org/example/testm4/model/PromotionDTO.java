package org.example.testm4.model;

import java.util.Date;

public interface PromotionDTO {
    Long getId();
    String getTitle();
    Double getDiscountRate();
    String getDescription();
    Date getStartDate();
    Date getEndDate();
}
