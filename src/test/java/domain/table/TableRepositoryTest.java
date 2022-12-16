package domain.table;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class TableRepositoryTest {

    @Test
    public void 존재_하지_않는_테이블_번호는_조회_할_수_없다() {
        int nonexistentTableNumber = 4;

        Assertions.assertThatThrownBy(() -> TableRepository.findByTableNumber(
                nonexistentTableNumber
        )).isInstanceOf(IllegalArgumentException.class);
    }


}