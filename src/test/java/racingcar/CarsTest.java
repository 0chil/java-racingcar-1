package racingcar;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import racingcar.movestrategy.MoveStrategy;
import racingcar.movestrategy.NumberOverFourStrategy;
import racingcar.numberstrategy.FixedNumber;
import racingcar.numberstrategy.NumberStrategy;

public class CarsTest {

	@Test
	@DisplayName("n대의 자동차는 전진할 수 있다")
	void n_cars_can_move() {
		NumberStrategy numberStrategy = new FixedNumber(4);
		MoveStrategy moveStrategy = new NumberOverFourStrategy(numberStrategy);
		List<Car> carList = createCarList();
		Cars cars = new Cars(carList);
		cars.move(moveStrategy);

		assertThat(carList).allSatisfy(
			car -> assertThat(car).isGreaterThan(new Car()));
	}

	@Test
	@DisplayName("n대의 자동차는 정지할 수 있다")
	void n_cars_can_stay() {
		NumberStrategy numberStrategy = new FixedNumber(3);
		MoveStrategy moveStrategy = new NumberOverFourStrategy(numberStrategy);
		List<Car> carList = createCarList();
		Cars cars = new Cars(carList);
		cars.move(moveStrategy);

		assertThat(carList).allSatisfy(
			car -> assertThat(car).isEqualByComparingTo(new Car()));
	}

	@Test
	@DisplayName("n번 움직일 수 있다")
	void cars_can_move_n_times() {
		NumberStrategy numberStrategy = new FixedNumber(4);
		MoveStrategy moveStrategy = new NumberOverFourStrategy(numberStrategy);
		List<Car> carListMovedOne = createCarList();
		Cars carsMovedOne = new Cars(carListMovedOne);
		carsMovedOne.move(moveStrategy, 1);

		List<Car> carListMovedTwo = createCarList();
		Cars carsMovedTwo = new Cars(carListMovedTwo);
		carsMovedTwo.move(moveStrategy, 2);

		assertThat(carListMovedTwo).allSatisfy(
			carMovedTwo -> assertThatCarIsGreaterThanList(carListMovedOne, carMovedTwo));
	}

	private void assertThatCarIsGreaterThanList(List<Car> smallerCarList, Car greaterCar) {
		assertThat(smallerCarList).allSatisfy(
			carMovedOne -> assertThat(greaterCar).isGreaterThan(carMovedOne));
	}

	private List<Car> createCarList() {
		List<Car> carList = new ArrayList<>();
		for (int i = 0; i < 5; ++i) {
			carList.add(new Car());
		}
		return carList;
	}
}
