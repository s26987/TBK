package com.app.landingpage.footers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/footers")
public class FooterController {

    public final FooterService footerService;

    @Autowired
    public FooterController(FooterService footerService) {
        this.footerService = footerService;
    }

    @GetMapping
    public List<Footer> getFooters() {
        return footerService.getAllFooters();
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Footer> getFooter(@PathVariable String id) {
        return footerService.getFooterById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Footer addFooter(@RequestBody Footer footer) {
        return footerService.addFooter(footer);
    }

    @PutMapping(path = "/{id}")
    public Footer updateFooter(@PathVariable String id, @RequestBody Footer updatedFooter) {
        return footerService.updateFooter(id, updatedFooter);
    }

    @DeleteMapping(path = "/{id}")
    public void deleteFooter(@PathVariable String id) {
        footerService.deleteFooter(id);
    }
}
