package pe.edu.cibertec.daw_chavez_ariadna.response;

import pe.edu.cibertec.daw_chavez_ariadna.dto.CarDto;

import java.util.List;

public record FindCarsResponse(
        String code,
        String error,
        List<CarDto> cars) {
}
