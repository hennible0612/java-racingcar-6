package racingcar.view;

public enum CarRaceMessages {
    START_RACE("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    REQUEST_RACE_ROUNDS("시도할 횟수는 몇회인가요?"),
    RACE_RESULT_MESSAGE("실행 결과"),
    RACE_WINNERS("최종 우승자 : ");

    private final String message;

    CarRaceMessages(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }

}
