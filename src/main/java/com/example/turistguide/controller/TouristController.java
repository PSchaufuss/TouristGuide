package com.example.turistguide.controller;

import com.example.turistguide.model.TouristAttraction;
import com.example.turistguide.service.TouristService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// RestController markerer klassen som REST API Controller
// RequestMapping skaber en base-URL for alle endpoints
@RestController
@RequestMapping("/attractions")
public class TouristController
{
    private final TouristService service;

    public TouristController(TouristService service)
    {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<TouristAttraction>> getAllAttractions()
    {
        return ResponseEntity.ok(service.getAllAttractions());
    }

    @GetMapping("/{name}")
    public ResponseEntity<TouristAttraction> getAttractionByName(@PathVariable String name)
    {
        return service.getAttractionByName(name).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<String> addAttraction(@RequestBody TouristAttraction attraction)
    {
        service.addAttraction(attraction);
        return ResponseEntity.ok("Attraction added successfully");
    }

    @DeleteMapping("/{name}")
    public ResponseEntity<String> deleteAttraction(@PathVariable String name)
    {
        if (service.deleteAttraction(name))

        {
            return ResponseEntity.ok("Attraction deleted successfully");
        }
        else
        {
            return ResponseEntity.notFound().build();
        }
    }
}
