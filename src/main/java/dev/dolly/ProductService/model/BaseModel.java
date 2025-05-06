package dev.dolly.ProductService.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

//@Entity -->we do not need table of parent class here i.e BaseModel
// tells spring, that we do not need table for this class,// but we need these columns ,in all its child class tables
@Getter
@Setter
@MappedSuperclass
public class BaseModel{
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String createdBy;
    private String updatedBy;
}
