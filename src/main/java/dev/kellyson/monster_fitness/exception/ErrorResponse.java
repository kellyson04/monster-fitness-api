package dev.kellyson.monster_fitness.exception;

import lombok.Builder;

@Builder
public record ErrorResponse(
        int status,
        String error,
        String message
) {
}
