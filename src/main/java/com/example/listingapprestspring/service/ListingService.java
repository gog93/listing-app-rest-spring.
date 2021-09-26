package com.example.listingapprestspring.service;

import com.example.listingapprestspring.model.Listing;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface ListingService {
    ResponseEntity <Listing> findListingById(int id);

    ResponseEntity <Listing> updateListing(int id, Listing listing);

    Listing addListing(Listing listing);

    ResponseEntity <Listing> deleteListing(int id);

    List<Listing> findAll();

}
