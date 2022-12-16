package view.dto.request;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import domain.MainOption;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class MainOptionRequestTest {

    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "3"})
    public void 주요_기능_선택은_제공된_숫자_입력시_정상_작동한다(String input) {
        MainOptionRequest mainOptionRequest = MainOptionRequest.of(input);
    }

    @ParameterizedTest
    @ValueSource(strings = {" ", "a", "4", "1.1"})
    void 주요_기능_선택은_제공된_숫자만_입력_가능하다(String input) {
        assertThatThrownBy(() -> MainOptionRequest.of(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 입력된_숫자에_따라_주요_기능_선택으로_정상_변환_된다() {
        MainOptionRequest mainOptionRequest = MainOptionRequest.of("1");

        MainOption mainOption = mainOptionRequest.toMainOption();
        assertThat(mainOption).isEqualTo(MainOption.ENROLL);
    }



}