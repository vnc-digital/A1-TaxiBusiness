package com.vnc.TaxiManagement.Controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vnc.TaxiManagement.Dao.CarRepository;
import com.vnc.TaxiManagement.Dto.CarDto;
import com.vnc.TaxiManagement.Entity.Car;
import com.vnc.TaxiManagement.Helper.CarRegenerator;
import com.vnc.TaxiManagement.ServiceImpl.CarServiceImpl;

@RestController
@RequestMapping("/taxi")
public class CarController {

	@Autowired
	CarServiceImpl carServiceImpl;

	@Autowired
	CarRepository carRepo;

	@Autowired
	CarRegenerator carRegenerator;

	/**
	 * 
	 * @param cardto 
	 */
	@RequestMapping(value = "/car", method = RequestMethod.POST)
	public void saveInfo(@RequestBody CarDto cardto) {
		Car car = new Car();
		BeanUtils.copyProperties(cardto, car);
		carServiceImpl.saveInfo(car);
		
		

	}
/**
 * 
 * @return All Cars
 */
	@RequestMapping(value = "/car", method = RequestMethod.GET)
	public Iterable<Car> getAllCars() {
		return carServiceImpl.getAllCars();
	}

	/**
	 * 
	 * @param car
	 * @param carId
	 * @return  Update Car Details
	 */
	@RequestMapping(value = "/car/{carId}", method = RequestMethod.PUT)
	public Car updateCar(@RequestBody Car car,@PathVariable("carId") String carId) {

		return carServiceImpl.updateCarDetails(car,carId);

	}
	
	/**
	 * 
	 * @param carId  Delete Car
	 */
	@RequestMapping(value = "/car/{carId}", method = RequestMethod.DELETE)
	public void deleteCar(@PathVariable("carId") String carId) {

		Car carDetail = carServiceImpl.findByCarId(carId);
		carServiceImpl.deleteCar(carDetail, carId);

	}

}
