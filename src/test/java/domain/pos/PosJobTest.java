package domain.pos;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PosJobTest {

    @ParameterizedTest
    @ValueSource(strings = {"-1", "0"})
    public void 포스기_기능_선택은_제공된_숫자인_경우에만_가능하다(String input) {
        int number = Integer.parseInt(input);
        Assertions.assertThatThrownBy(() -> PosJob.fromOptionNumber(number))
                .isInstanceOf(IllegalArgumentException.class);
    }

}