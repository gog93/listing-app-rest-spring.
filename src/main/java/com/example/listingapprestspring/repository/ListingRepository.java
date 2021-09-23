package com.example.listingapprestspring.repository;

import com.example.listingapprestspring.model.Listing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface ListingRepository extends JpaRepository<Listing, Integer> {
}
