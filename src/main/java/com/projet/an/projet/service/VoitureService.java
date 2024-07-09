package com.projet.an.projet.service;

import com.projet.an.projet.model.Voiture;
import com.projet.an.projet.repository.VoitureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VoitureService {

    @Autowired
    private VoitureRepository voitureRepository;

    public List<Voiture> getAllVoitures() {
        return voitureRepository.findAll();
    }

    public Optional<Voiture> getVoitureById(Long id) {
        return voitureRepository.findById(id);
    }

    public Voiture saveVoiture(Voiture voiture) {
        return voitureRepository.save(voiture);
    }

    public Voiture updateVoiture(Long id, Voiture voiture) {
        if (voitureRepository.existsById(id)) {
            voiture.setId(id); // Ensure the ID is set on the entity
            return voitureRepository.save(voiture);
        } else {
            System.out.print(
                    "Voiture not found with id " + id); // Handle not found scenario
        }
        return voiture;
    }

    public void deleteVoiture(Long id) {
        voitureRepository.deleteById(id);
    }
}
