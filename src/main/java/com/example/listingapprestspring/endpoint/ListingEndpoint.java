package com.example.listingapprestspring.endpoint;

import com.example.listingapprestspring.model.Listing;
import com.example.listingapprestspring.repository.ListingRepository;
import com.example.listingapprestspring.service.impl.ListingServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ListingEndpoint {
    private final ListingRepository listingRepository;
    private final ListingServiceImpl listingServiceImpl;

    @GetMapping("/listings")
    public List<Listing> listings() {
        return listingServiceImpl.findAll();
    }

    @GetMapping("/listing/{id}")
    public ResponseEntity<Listing> getListingById(@PathVariable("is") int id) {

        return listingServiceImpl.findListingById(id);

    }

    @PostMapping("/listings")
    public Listing listing(@RequestBody Listing listing) {
        return listingServiceImpl.addListing(listing);
    }

    @DeleteMapping("/listings")
    public ResponseEntity<Listing> deleteById(@PathVariable("is") int id) {
        return listingServiceImpl.deleteListing(id);
    }

    @PutMapping("/listings/{id}")
    public ResponseEntity<Listing> updateListing(@PathVariable("id") int id, @RequestBody Listing listing) {
        return listingServiceImpl.updateListing(id, listing);
    }

}
