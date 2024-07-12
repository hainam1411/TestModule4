package org.example.testm4.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
public class Promotion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Nhập tiêu đề")
    private String name;

    @NotEmpty(message = "Nhập ngày bắt đầu")
    private LocalDate startDate;

    @NotEmpty(message = "Nhập ngày kết thúc")
    private LocalDate endDate;

    @Min(value = 10000 ,message = "Mức giảm lớn hơn 10000")
    private double discount;

    private String detail;


}
