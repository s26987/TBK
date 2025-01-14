package com.app.landingpage.analytics;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/analytics")
public class AnalyticsController {

    public final AnalyticsService analyticsService;

    @Autowired
    public AnalyticsController(AnalyticsService analyticsService) {
        this.analyticsService = analyticsService;
    }

    @GetMapping
    public List<Analytics> getAllAnalytics() {
        return analyticsService.getAllAnalytics();
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Analytics> getAnalyticsById(@PathVariable String id) {
        return analyticsService.getAnalyticsById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Analytics addAnalytics(@RequestBody Analytics analytics) {
        return analyticsService.addAnalytics(analytics);
    }

    @PutMapping(path = "/{id}")
    public Analytics updateAnalytics(@PathVariable String id, @RequestBody Analytics updatedAnalytics) {
        return analyticsService.updateAnalytics(id, updatedAnalytics);
    }

    @DeleteMapping(path = "/{id}")
    public void deleteAnalytics(@PathVariable String id) {
        analyticsService.deleteAnalytics(id);
    }
}
