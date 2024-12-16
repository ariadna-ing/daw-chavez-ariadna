package pe.edu.cibertec.daw_chavez_ariadna.dto;

public record CarDto(
         Integer carId,
         String make,
         String model,
         Integer year,
         String licensePlate,
         String ownerName,
         String color
) {
}
