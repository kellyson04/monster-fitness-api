package dev.kellyson.monster_fitness.exception;

import lombok.Builder;

import java.time.Instant;

@Builder
public record ErrorResponse(
        Instant timestamp,
        int status,
        String error,
        String message
) {
    public ErrorResponse {
        if (timestamp == null) {
            timestamp = Instant.now();
        }
    }
}
