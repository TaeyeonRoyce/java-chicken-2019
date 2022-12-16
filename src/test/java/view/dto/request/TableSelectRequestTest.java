package view.dto.request;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class TableSelectRequestTest {

    @ParameterizedTest
    @ValueSource(strings = {" ", "a", "-21", "1.1"})
    void 테이블_선택은_자연수만_입력_가능하다(String input) {
        assertThatThrownBy(() -> TableSelectRequest.of(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

}