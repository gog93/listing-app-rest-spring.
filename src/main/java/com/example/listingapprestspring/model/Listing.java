package com.example.listingapprestspring.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Entity
@AllArgsConstructor
@Builder
@Data
@Table(name="listing")

public class Listing {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id ;
    private String title;
    private String description;
    private double price;
    @ManyToOne
    private Category category;
    @ManyToOne
    private User user;

}
