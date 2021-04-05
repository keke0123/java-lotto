package step02.code.common;

import java.util.List;
import java.util.Scanner;

import step02.code.domain.Lotto;

public class InputView {
  private static final Scanner scanner = new Scanner(System.in);
  
  public static int buy() {
    System.out.println("구입금액을 입력해 주세요.");
    return Integer.parseInt(scanner.nextLine());
  }

  public static String winningNumber() {
    System.out.println("지난 주 당첨 번호를 입력해 주세요.");
    return scanner.nextLine();
  }

  public static String bonusNumber() {
    System.out.println("보너스 볼을 입력해 주세요.");
    return scanner.nextLine();
  }

  public static int passiveLottoSize() {
    System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
    return Integer.parseInt(scanner.nextLine());
  }

  public static String passiveLotto() {
    return scanner.nextLine();
  }

  public static void close() {
    scanner.close();
  }
}
