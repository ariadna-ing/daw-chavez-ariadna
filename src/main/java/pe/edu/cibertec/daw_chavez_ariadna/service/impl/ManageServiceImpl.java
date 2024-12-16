package pe.edu.cibertec.daw_chavez_ariadna.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.daw_chavez_ariadna.dto.CarDetailDto;
import pe.edu.cibertec.daw_chavez_ariadna.dto.CarDto;
import pe.edu.cibertec.daw_chavez_ariadna.dto.CarUpdateDto;
import pe.edu.cibertec.daw_chavez_ariadna.entity.Car;
import pe.edu.cibertec.daw_chavez_ariadna.repository.CarRepository;
import pe.edu.cibertec.daw_chavez_ariadna.service.ManageService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ManageServiceImpl implements ManageService {

    @Autowired
    CarRepository carRepository;

    @Override
    public List<CarDto> getAllCars() throws Exception {
        List<CarDto> cars = new ArrayList<CarDto>();
        Iterable<Car> iterable = carRepository.findAll();
        iterable.forEach(car -> {
            cars.add(new CarDto(
                    car.getCarId(),
                    car.getMake(),
                    car.getModel(),
                    car.getYear(),
                    car.getLicensePlate(),
                    car.getOwnerName(),
                    car.getColor()
            ));
        });
        return cars;
    }

    @Override
    public Optional<CarDetailDto> getCarById(int carId) throws Exception {
        Optional<Car> optional = carRepository.findById(carId);
        return optional.map(car -> new CarDetailDto(
                car.getCarId(),
                car.getMake(),
                car.getModel(),
                car.getYear(),
                car.getLicensePlate(),
                car.getOwnerName(),
                car.getEngineType(),
                car.getColor(),
                car.getRegistrationExpirationDate(),
                car.getServiceDueDate()
        ));
    }

    @Override
    public boolean updateCar(CarDto carDto) throws Exception {
        Optional<Car> optional = carRepository.findById(carDto.carId());
        return optional.map(car -> {
            car.setMake(carDto.make());
            car.setModel(carDto.model());
            car.setYear(carDto.year());
            car.setLicensePlate(carDto.licensePlate());
            car.setOwnerName(carDto.ownerName());
            car.setColor(carDto.color());
            carRepository.save(car);
            return true;
        }).orElse(false);
    }

    @Override
    public boolean deleteCarById(int carId) throws Exception {
        Optional<Car> optional = carRepository.findById(carId);
        return optional.map(car -> {
            carRepository.delete(car);
            return true;
        }).orElse(false);
    }

    @Override
    public boolean addCar(CarUpdateDto carUpdateDto) throws Exception {

        Optional<Car> optional = carRepository.findById(carUpdateDto.carId());
        if (optional.isPresent())
            return false;
        else {
            Car car = new Car();
            car.setMake(carUpdateDto.make());
            car.setModel(carUpdateDto.model());
            car.setYear(carUpdateDto.year());
            car.setLicensePlate(carUpdateDto.licensePlate());
            car.setOwnerName(carUpdateDto.ownerName());
            car.setColor(carUpdateDto.color());
            carRepository.save(car);
            return true;
        }
    }

}
