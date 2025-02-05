package com.example.turistguide.service;

import com.example.turistguide.model.TouristAttraction;
import com.example.turistguide.repository.TouristRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// Markerer klassen som en service (altså forretningslogik)
@Service
public class TouristService
{
    private final TouristRepository repository;

    public TouristService(TouristRepository repository)
    {
        this.repository = repository;
    }

    public List<TouristAttraction> getAllAttractions()
    {
        return repository.getAllAttractions();
    }

    public Optional<TouristAttraction> getAttractionByName(String name)
    {
        return repository.getAttractionByName(name);
    }

    public void addAttraction(TouristAttraction attraction)
    {
        repository.addAttraction(attraction);
    }

    public boolean deleteAttraction(String name)
    {
        return repository.deleteAttraction(name);
    }

}
