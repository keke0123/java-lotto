package lotto.domain;

import lotto.LottoMain;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottoGameResultsTest {
    private LottoGameResults lottoGameResults;
    private List<Integer> winningNumbers;
    private LottoTickets lottoTickets;

    @BeforeEach
    void setUp(){
        // given
        int inputMoneyAmount = 14000;

        this.lottoTickets = new LottoTickets(inputMoneyAmount);

        this.lottoGameResults = new LottoGameResults(lottoTickets);

        int[] numbers = {1,2,3,4,5,6};

        this.winningNumbers = IntStream.of(numbers).boxed().collect(Collectors.toList());

    }

    @DisplayName("지난 당첨 번호 유효성 검증")
    @ParameterizedTest
    @ValueSource(strings = {"3%4%6%7%8%9", "q,w,e,r,t,y", "1,2,3", "1,2,3,4,5,66"})
    void illegalLastWinningNumberExceptionTest(String input){
        assertThatIllegalArgumentException().isThrownBy(() -> {
            lottoGameResults.addLastWinningNumber(input);
        }).withMessageContaining(LottoErrorMessage.ILLEGAL_WINNING_NUMBER.getErrorMessage());
    }



    @DisplayName("LottoGameResults 수익률 계산 테스트")
    @Test
    void getProfitTest(){

        Map<Integer, Integer> winningResults = new HashMap<>();
        winningResults.put(3, 1);
        winningResults.put(4, 1);

        double profitResult = lottoGameResults.getProfit(winningResults);

        assertThat(profitResult).isEqualTo(3.93);

    }
}
