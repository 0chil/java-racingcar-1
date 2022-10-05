package racingcar;

import java.util.ArrayList;
import java.util.List;

import racingcar.domain.Cars;
import racingcar.result.Result;
import racingcar.strategy.MoveStrategy;
import racingcar.strategy.NumberOverFourStrategy;
import racingcar.strategy.NumberStrategy;
import racingcar.strategy.RandomNumberStrategy;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Game {

	private static final InputView INPUT_VIEW = new InputView();
	private static final OutputView OUTPUT_VIEW = new OutputView();
	private static final int RANDOM_NUMBER_BOUND_INCLUSIVE = 9;

	public static void main(String[] args) {
		List<String> names = getNames();
		Cars cars = Cars.ofNames(names);

		int trialCount = getTrialCount();

		move(cars, trialCount);
	}

	private static void move(Cars cars, int trialCount) {
		List<Result> results = new ArrayList<>();
		for (int i = 0; i < trialCount; ++i) {
			moveOnce(cars);
			results.add(new Result(cars));
		}
		OUTPUT_VIEW.printResults(results);
		OUTPUT_VIEW.printWinners(cars.findWinnerNames());
	}

	private static void moveOnce(Cars cars) {
		NumberStrategy numberStrategy = new RandomNumberStrategy(RANDOM_NUMBER_BOUND_INCLUSIVE);
		MoveStrategy moveStrategy = new NumberOverFourStrategy(numberStrategy);
		cars.move(moveStrategy);
	}

	private static int getTrialCount() {
		OUTPUT_VIEW.promptTrialCount();
		return INPUT_VIEW.readTrialCount();
	}

	private static List<String> getNames() {
		OUTPUT_VIEW.promptNames();
		return INPUT_VIEW.readNames();
	}
}
