package com.example.listingapprestspring.endpoint;

import com.example.listingapprestspring.model.Category;
import com.example.listingapprestspring.model.Listing;
import com.example.listingapprestspring.repository.ListingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class ListingEndpoint {
    private final ListingRepository listingRepository;

    @GetMapping("/listings")
    public List<Listing> listings() {
        return listingRepository.findAll();
    }

    @GetMapping("/listing/{id}")
    public ResponseEntity<Listing> getListingById(@PathVariable("is") int id) {
        Optional<Listing> byId = listingRepository.findById(id);
        if (byId.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(byId.get());
    }

    @PostMapping("/listings")
    public Listing listing(@RequestBody Listing listing) {
        return listingRepository.save(listing);
    }

    @DeleteMapping("/listings")
    public ResponseEntity<Listing> deleteById(@PathVariable("is") int id) {
        Optional<Listing> byId = listingRepository.findById(id);
        if (byId.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        listingRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/listings/{id}")
    public ResponseEntity<Listing> category(@PathVariable ("id") int id, @RequestBody Listing listing) {
        Optional <Listing> byId=listingRepository.findById(id);
        if(byId.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        Listing listingFromDb=byId.get();
        listingFromDb.setTitle(listing.getTitle());
        listingFromDb.setDescription(listing.getDescription());
        listingFromDb.setPrice(listing.getPrice());

        return ResponseEntity.ok().body(listingRepository.save(listing));
    }


}
