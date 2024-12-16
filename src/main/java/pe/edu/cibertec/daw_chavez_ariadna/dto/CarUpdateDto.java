package pe.edu.cibertec.daw_chavez_ariadna.dto;

import java.util.Date;

public record CarUpdateDto(
        Integer carId,
        String make,
        String model,
        Integer year,
        String licensePlate,
        String ownerName,
        String engineType,
        String color,
        Date registrationExpirationDate,
        Date serviceDueDate
) {
}
