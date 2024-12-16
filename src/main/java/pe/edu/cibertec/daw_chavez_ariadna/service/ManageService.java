package pe.edu.cibertec.daw_chavez_ariadna.service;

import pe.edu.cibertec.daw_chavez_ariadna.dto.CarDetailDto;
import pe.edu.cibertec.daw_chavez_ariadna.dto.CarDto;
import pe.edu.cibertec.daw_chavez_ariadna.dto.CarUpdateDto;

import java.util.List;
import java.util.Optional;

public interface ManageService {
    List<CarDto> getAllCars() throws Exception;

    Optional<CarDetailDto> getCarById(int carId) throws Exception;

    boolean updateCar(CarDto carDto) throws Exception;

    boolean deleteCarById(int carId) throws Exception;

    boolean addCar(CarUpdateDto carUpdateDto) throws Exception;

}
