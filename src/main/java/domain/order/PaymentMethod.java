package domain.order;

import domain.pos.PosJob;
import java.util.Arrays;

public enum PaymentMethod {
    CARD(1),
    CASH(2);
    private int commandCode;

    PaymentMethod(int commandCode) {
        this.commandCode = commandCode;
    }

    public static PaymentMethod fromCommandCode(int commandCode) {
        return Arrays.stream(PaymentMethod.values())
                .filter(paymentMethod -> paymentMethod.commandCode == commandCode)
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
