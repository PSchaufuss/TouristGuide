package com.example.turistguide.repository;

import com.example.turistguide.model.TouristAttraction;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

// Jeg opretter/markerer klassen som et Repository (datahåndtering) med min annotation
@Repository
public class TouristRepository
{
    private List<TouristAttraction> attractions = new ArrayList<>();

    public TouristRepository()
    {
        // Midlertidige testdata til listen
        attractions.add(new TouristAttraction("Tivoli", "Forlystelsespark i København"));
        attractions.add(new TouristAttraction("Den Lille Havfrue", "Ikonisk statue i København. Et symbol fra H.C. Andersens eventyr"));
    }

    // Metode til at hente alle attraktionerne
    public List<TouristAttraction> getAllAttractions()
    {
        return attractions;
    }

    // Optional fordi den enten returnere et optional-objekt eller en tom optional.empty(). Forhindrer null-point exceptions.
    // .stream() konverterer listen til en Java Stream, så vi kan bruges streams metoder som fx 'filter()'.
    // filter() bruger vi til at gå gennem hver attraktion på listen og beholder dem, hvor søgenavnet matcher. Det er et mere læsbart alternativ til fx 'contains'
    public Optional<TouristAttraction> getAttractionByName(String name)
    {
        return attractions.stream().filter(attraction -> attraction.getName().equalsIgnoreCase(name)).findFirst();
    }

    public void addAttraction(TouristAttraction attraction)
    {
        attractions.add(attraction);
    }

    public boolean deleteAttraction(String name)
    {
        return attractions.removeIf(attraction -> attraction.getName().equalsIgnoreCase(name));
    }
}
