package com.example.listingapprestspring.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="category")
@Data
public class Category {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)

   private int id;
    private String name;
}
