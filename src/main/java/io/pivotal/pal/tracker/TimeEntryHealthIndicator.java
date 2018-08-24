package io.pivotal.pal.tracker;

import io.pivotal.pal.tracker.db.TimeEntryRepository;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class TimeEntryHealthIndicator implements HealthIndicator {

    private TimeEntryRepository timeEntryRepository;

    public TimeEntryHealthIndicator(TimeEntryRepository repository) {
        this.timeEntryRepository = repository;
    }

    @Override
    public Health health() {
        return timeEntryRepository.list().size() < 5 ? Health.up().build() : Health.down().build();
    }
}
