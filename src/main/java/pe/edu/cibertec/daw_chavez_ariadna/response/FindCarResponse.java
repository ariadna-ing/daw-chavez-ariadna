package pe.edu.cibertec.daw_chavez_ariadna.response;

import pe.edu.cibertec.daw_chavez_ariadna.dto.CarDetailDto;

public record FindCarResponse(
        String code,
        String error,
        CarDetailDto carDetailDto
) {
}
