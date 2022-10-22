package racingcar.domain;

import racingcar.strategy.MoveStrategy;

public class Car {

	private Position position;
	private final Name name;

	public Car(final String name) {
		this.name = Name.trimmedFrom(name);
		this.position = new Position(0);
	}

	public void move(final MoveStrategy moveStrategy) {
		if (moveStrategy.isMovable()) {
			position = position.increase();
		}
	}

	public boolean hasPositionSameAs(Position otherPosition) {
		return this.position.equals(otherPosition);
	}

	public boolean hasPositionGreaterThan(Car other) {
		return this.position.compareTo(other.position) > 0;
	}

	public Position getPosition() {
		return position;
	}

	public String getName() {
		return name.getName();
	}

	@Override
	public String toString() {
		return "Car{" +
			"position=" + position +
			", name=" + name +
			'}';
	}
}
