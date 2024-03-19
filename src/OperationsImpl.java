import java.util.HashMap;
import java.util.Map;

public class OperationsImpl implements Operations {
    ATM atm = new ATM();
    Map<Double, String> ministmt = new HashMap<>();

    @Override
    public void viewBalance() {
        System.out.println("Доступный баланс : " + atm.getBalance());
    }

    @Override
    public void withdrawAmount(double withdrawAmount) {
        if (withdrawAmount % 500 == 0) {
            if (withdrawAmount <= atm.getBalance()) {
                ministmt.put(withdrawAmount, " Выдача наличных");
                System.out.println("Забирите наличные " + withdrawAmount);
                atm.setBalance(atm.getBalance() - withdrawAmount);
                viewBalance();
            } else {
                System.out.println("Недостаточно денег");
            }
        } else {
            System.out.println("Пожалуйста, введите сумму, кратную 500");
        }
    }

    @Override
    public void depositAmount(double depositAmount) {
        ministmt.put(depositAmount, " Внесение наличных");
        System.out.println(depositAmount + " Пополнение успешно");
        atm.setBalance(atm.getBalance() + depositAmount);
        viewBalance();
    }

    @Override
    public void viewMiniStatement() {
        for (Map.Entry<Double, String> m : ministmt.entrySet()) {
            System.out.println(m.getKey() + "" + m.getValue());
        }
    }
}