import java.util.Scanner;

public class RunATM {
    Operations op = new OperationsImpl();
    int atmnumber = 12345;
    int atmpin = 123;

    RunATM() {
        start();
    }

    public void start() {
        Scanner in = new Scanner(System.in);
        System.out.println("Добро пожаловать");
        System.out.print("Введите номер : ");
        int atmNumber = in.nextInt();
        System.out.print("Введите пин: ");
        int pin = in.nextInt();
        if ((atmnumber == atmNumber) && (atmpin == pin)) {
            while (true) {
                System.out.println("1.Просмотр баланса\n2.Получить наличные\n3.Внести наличные\n4.Последнии операции\n5.Выход");
                System.out.println("Введите выбор : ");
                int ch = in.nextInt();
                if (ch == 1) {
                    op.viewBalance();

                } else if (ch == 2) {
                    System.out.println("Введите сумму для вывода ");
                    double withdrawAmount = in.nextDouble();
                    op.withdrawAmount(withdrawAmount);

                } else if (ch == 3) {
                    System.out.println("Введите сумму для внесения :");
                    double depositAmount = in.nextDouble();
                    op.depositAmount(depositAmount);

                } else if (ch == 4) {
                    op.viewMiniStatement();

                } else if (ch == 5) {
                    System.out.println("Заберите свою карточку\nБлагодарим вас за использование банкомата");
                    System.exit(0);
                } else {
                    System.out.println("Пожалуйста, введите правильный выбор");
                }
            }
        } else {
            System.out.println("Неверный номер банкомата или pin-код");
            System.exit(0);
        }
    }
}