package step02.code.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.assertj.core.util.Arrays;

public class Lotto {
  private static final int LOTTO_SIZE = 6;
  private static final int MIN_NUM = 1;
  private static final int MAX_NUM = 45;

  private final List<Integer> lotto;

  public Lotto(List<Integer> lotto) {
    check(lotto);
    this.lotto = lotto;
  }

  public static void check(List<Integer> lotto) {
    if(lotto.size() != LOTTO_SIZE) {
      throw new IllegalArgumentException("lotto 는 6개의 숫자가 필요합니다");
    }
    boolean isNotCovered = lotto.stream().anyMatch((num) -> num < MIN_NUM || num > MAX_NUM);
    if(isNotCovered) {
      throw new IllegalArgumentException("lotto 는 " + MIN_NUM + " 부터 " + MAX_NUM + " 사이의 값이어야 합니다");
    }
    Set<Integer> overlapRemoved = new HashSet<>(lotto);
    if(overlapRemoved.size() != LOTTO_SIZE) {
      throw new IllegalArgumentException("lotto 는 중복된 숫자를 가질수 없습니다");
    }
  }

  public void check() {
    check(this.lotto);
  }

  public int match(List<Integer> winningNumber) {
    List<Integer> lotto = new ArrayList<>();
    lotto.addAll(this.lotto);
    lotto.removeAll(winningNumber);
    return LOTTO_SIZE - lotto.size();
  }
  
}
