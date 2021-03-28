package step02.code.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class WinningNumber {
  private List<Number> winningNumber;

  public WinningNumber(List<Number> winningNumber) {
    this.winningNumber = winningNumber;
  };

  public static WinningNumber makeWinningNumberByString(String str) {
    List<Number> winningNumber = Arrays.stream(str.split(","))
      .map(String::trim)
      .map(WinningNumber::check)
      .map(Integer::parseInt)
      .map(Number::new)
      .collect(Collectors.toList());
    return new WinningNumber(winningNumber);
  }
  
  public static String check(String str) {
    if(str == null || str.equals("")) {
      throw new IllegalArgumentException("null or 빈값이 들어올 수 없습니다.");
    }
    try {
      Integer.parseInt(str);
    } catch (Exception e) {
      throw new IllegalArgumentException("not int error");
    }
    return str;
  }

  public List<Number> number() {
    return Collections.unmodifiableList(winningNumber);
  }
}
