package com.example.demo.binding;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="Asset")
public class Asset {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer aid;
    private String name;
    private String description;


}
