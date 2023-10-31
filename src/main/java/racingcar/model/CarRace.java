package racingcar.model;

import java.util.List;
import java.util.stream.Collectors;

public class CarRace {
    private final List<RacingCar> racingCars;
    private final int targetRound;
    private final RandomDistanceGenerator randomDistanceGenerator;

    public CarRace(List<RacingCar> racingCars, int targetTurn, RandomDistanceGenerator randomDistanceGenerator) {
        this.racingCars = racingCars;
        this.targetRound = targetTurn;
        this.randomDistanceGenerator = randomDistanceGenerator;
    }

    public List<RacingCar> race() {
        moveCars();
        return racingCars;
    }

    public int getTargetRound() {
        return targetRound;
    }

    public List<RacingCar> getWinners() {
        int maxDistance = getMaxDistance();
        return racingCars.stream()
                .filter(car -> car.getDistance() == maxDistance)
                .collect(Collectors.toList());
    }

    private void moveCars() {
        for (RacingCar racingCar : racingCars) {
            racingCar.moveForward(randomDistanceGenerator.moveDistance());
        }
    }

    private int getMaxDistance() {
        return racingCars.stream()
                .mapToInt(RacingCar::getDistance)
                .max()
                .orElse(0);
    }

}
