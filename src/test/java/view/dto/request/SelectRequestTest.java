package view.dto.request;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class SelectRequestTest {
    @ParameterizedTest
    @ValueSource(strings = {"0", "-21", "a", "b1", " ", "1.1"})
    public void 옵션_선택은_자연수만_가능_하다(String input) {
        Assertions.assertThatThrownBy(() ->
                SelectRequest.of(input)
        ).isInstanceOf(IllegalArgumentException.class);
    }


}