package dev.dolly.ProductService.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

//@Entity -->we do not need table of parent class here i.e BaseModel
@MappedSuperclass // tells spring, that we do not need table for this class,
// but we need these columns ,in all its child class tables
public class BaseModel{
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String createdBy;
    private String updatedBy;
}
