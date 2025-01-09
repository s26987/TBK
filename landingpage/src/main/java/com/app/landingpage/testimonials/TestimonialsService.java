package com.app.landingpage.testimonials;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TestimonialsService {

    public final TestimonialsRepository testimonialsRepository;

    @Autowired
    public TestimonialsService(TestimonialsRepository testimonialsRepository) {
        this.testimonialsRepository = testimonialsRepository;
    }

    public Testimonials createTestimonials(Testimonials testimonials) {
        return testimonialsRepository.save(testimonials);
    }

    public List<Testimonials> getAllTestimonials() {
        return testimonialsRepository.findAll();
    }

    public Optional<Testimonials> getTestimonialsById(String id) {
        return testimonialsRepository.findById(id);
    }

    public Testimonials updateTestimonials(String id, Testimonials updatedTestimonials) {
        return testimonialsRepository.findById(id)
                .map(existing -> {
                    if (updatedTestimonials.getOpinions() != null) {
                        existing.setOpinions(updatedTestimonials.getOpinions());
                    }
                    return testimonialsRepository.save(existing);
                })
                .orElseThrow(() -> new RuntimeException("Testimonials nieznalezione."));
    }


    public void deleteTestimonials(String id) {
        testimonialsRepository.deleteById(id);
    }
}
