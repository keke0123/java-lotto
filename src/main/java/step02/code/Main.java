package step02.code;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import step02.code.common.InputView;
import step02.code.common.ResultView;
import step02.code.domain.GradeEnum;
import step02.code.domain.Lotto;
import step02.code.domain.Lottos;
import step02.code.domain.Number;
import step02.code.domain.Outcome;

public class Main {
  public static void main(String[] args) {
    int money = InputView.buy();

    int passiveLottoSize = InputView.passiveLottoSize();
    List<Lotto> passiveLottos = new ArrayList<>();
    System.out.println("수동으로 구매할 번호를 입력해 주세요.");
    for(int i = 0; i < passiveLottoSize; i++) {
      passiveLottos.add(Lotto.makeLottoByString(InputView.passiveLotto()));
    }

    Lottos lottos = Lottos.buy(money, passiveLottos);
    ResultView.myLotto(lottos.lottos(), passiveLottoSize);

    Lotto winningNumber = Lotto.makeLottoByString(InputView.winningNumber());

    Number bonus = Number.numberByString(InputView.bonusNumber());

    // 결과
    System.out.println("당첨 통계");
    System.out.println("---------------");

    Outcome outcome = new Outcome(money, lottos);

    Map<GradeEnum, Integer> result = outcome.statistic(winningNumber, bonus);

    // GradeEnum.values() 대신 none 만 안나오도록 설정해서 다시
    GradeEnum.sorted()
      .stream()
      .forEach(gradeEnum -> {
        int size = result.getOrDefault(gradeEnum, 0);
        ResultView.result(gradeEnum, size);
        outcome.add(size * gradeEnum.prize());
      });
    
    ResultView.rate(outcome.profit());
    
    InputView.close();
  } 
}
