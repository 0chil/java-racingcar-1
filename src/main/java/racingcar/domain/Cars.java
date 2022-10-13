package racingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import racingcar.exception.CarCountException;
import racingcar.strategy.MoveStrategy;

public class Cars {

	private final List<Car> cars;

	public Cars(List<Car> cars) {
		validateCarCount(cars);
		this.cars = new ArrayList<>(cars);
	}

	public static Cars ofNames(List<String> names) {
		List<Car> cars = names.stream()
			.map(Car::new)
			.collect(Collectors.toList());
		return new Cars(cars);
	}

	public void move(MoveStrategy moveStrategy) {
		for (Car car : cars) {
			car.move(moveStrategy);
		}
	}

	public List<String> findWinnerNames() {
		int maxPosition = getMaxPosition();
		return cars.stream()
			.filter(car -> !car.hasPositionGreaterThan(maxPosition))
			.map(Car::getName)
			.collect(Collectors.toList());
	}

	private int getMaxPosition() {
		int maxPosition = 0;
		for (Car car : cars) {
			maxPosition = getGreaterPosition(maxPosition, car);
		}
		return maxPosition;
	}

	private int getGreaterPosition(int maxPosition, Car car) {
		if (car.hasPositionGreaterThan(maxPosition)) {
			return car.getPosition();
		}
		return maxPosition;
	}

	private void validateCarCount(List<Car> cars) {
		if (cars.size() <= 0) {
			throw new CarCountException("자동차는 1개 이상이어야 합니다");
		}
	}

	public List<Integer> getPositions() {
		List<Integer> positions = new ArrayList<>();
		for (Car car : cars) {
			positions.add(car.getPosition());
		}
		return Collections.unmodifiableList(positions);
	}

	public List<String> getNames() {
		return cars.stream()
			.map(Car::getName)
			.collect(Collectors.toList());
	}
}
