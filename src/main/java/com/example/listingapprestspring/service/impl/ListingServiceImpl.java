package com.example.listingapprestspring.service.impl;

import com.example.listingapprestspring.model.Listing;
import com.example.listingapprestspring.repository.ListingRepository;
import com.example.listingapprestspring.service.ListingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service

public class ListingServiceImpl implements ListingService {
    public final ListingRepository listingRepository;

    public List<Listing> findAll() {
        return listingRepository.findAll();
    }

    public ResponseEntity <Listing> deleteListing(int id) {
        Optional<Listing> byId = listingRepository.findById(id);
        if (byId.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        listingRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    public Listing addListing(Listing listing) {
        return listingRepository.save(listing);
    }

    public ResponseEntity<Listing> findListingById(int id) {
        Optional<Listing> byId = listingRepository.findById(id);
        if (byId.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(byId.get());
    }

    public ResponseEntity<Listing> updateListing(int id, Listing listing) {
        Optional<Listing> byId = listingRepository.findById(id);
        if (byId.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        Listing listingFromDb = byId.get();
        listingFromDb.setTitle(listing.getTitle());
        listingFromDb.setDescription(listing.getDescription());
        listingFromDb.setPrice(listing.getPrice());

        return ResponseEntity.ok().body(listingRepository.save(listing));
    }

}
