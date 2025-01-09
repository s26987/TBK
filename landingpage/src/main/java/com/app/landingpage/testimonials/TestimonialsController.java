package com.app.landingpage.testimonials;

import com.app.landingpage.herosections.HeroSection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/testimonials")
public class TestimonialsController {

    public final TestimonialsService testimonialsService;

    @Autowired
    public TestimonialsController(TestimonialsService testimonialsService) {
        this.testimonialsService = testimonialsService;
    }

    @PostMapping
    public Testimonials createTestimonials(@RequestBody Testimonials testimonials) {
        return testimonialsService.createTestimonials(testimonials);
    }

    @GetMapping
    public List<Testimonials> getAllTestimonials() {
        return testimonialsService.getAllTestimonials();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Testimonials> getTestimonialsById(@PathVariable String id) {
        return testimonialsService.getTestimonialsById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public Testimonials updateTestimonials(@PathVariable String id, @RequestBody Testimonials updatedTestimonials) {
        return testimonialsService.updateTestimonials(id, updatedTestimonials);
    }

    @DeleteMapping("/{id}")
    public void deleteTestimonials(@PathVariable String id) {
        testimonialsService.deleteTestimonials(id);
    }
}
