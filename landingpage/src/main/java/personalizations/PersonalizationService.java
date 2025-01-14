package personalizations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonalizationService {

    public final PersonalizationRepository personalizationRepository;

    @Autowired
    public PersonalizationService(PersonalizationRepository personalizationRepository) {
        this.personalizationRepository = personalizationRepository;
    }

    public List<Personalization> getAllPersonalizations() {
        return personalizationRepository.findAll();
    }

    public Optional<Personalization> getPersonalizationById(String id) {
        return personalizationRepository.findById(id);
    }

    public Personalization addPersonalization(Personalization personalization) {
        return personalizationRepository.save(personalization);
    }

    public Personalization updatePersonalization(String id, Personalization updatedPersonalization) {
        return personalizationRepository.findById(id)
                .map(existing -> {
                    if (updatedPersonalization.getPreferences() != null) {
                        existing.setPreferences(updatedPersonalization.getPreferences());
                    }
                    return personalizationRepository.save(existing);
                })
                .orElseThrow(() -> new RuntimeException("Personalization nieznalezione."));
    }

    public void deletePersonalization(String id) {
        personalizationRepository.deleteById(id);
    }

}
