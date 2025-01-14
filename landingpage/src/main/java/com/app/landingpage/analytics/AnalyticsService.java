package com.app.landingpage.analytics;

import com.app.landingpage.users.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AnalyticsService {

    private final AnalyticsRepository analyticsRepository;

    @Autowired
    public AnalyticsService(AnalyticsRepository analyticsRepository) {
        this.analyticsRepository = analyticsRepository;
    }

    public List<Analytics> getAllAnalytics() {
        return analyticsRepository.findAll();
    }

    public Optional<Analytics> getAnalyticsById(String id) {
        return analyticsRepository.findById(id);
    }

    public Analytics addAnalytics(Analytics analytics) {
        return analyticsRepository.save(analytics);
    }

    public Analytics updateAnalytics(String id, Analytics updatedAnalytics) {
        return analyticsRepository.findById(id)
                .map(existing -> {
                    if (updatedAnalytics.getTotalVisits() != null) {
                        existing.setTotalVisits(updatedAnalytics.getTotalVisits());
                    }
                    if (updatedAnalytics.getConversionCount() != null) {
                        existing.setConversionCount(updatedAnalytics.getConversionCount());
                    }
                    return analyticsRepository.save(existing);
                })
                .orElseThrow(() -> new RuntimeException("Analytics o id: " + id + " nie zostalo znalezione"));
    }

    public void deleteAnalytics(String id) {
        analyticsRepository.deleteById(id);
    }
}
