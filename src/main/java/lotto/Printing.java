package lotto;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import lotto.WinningDetails;
import lotto.Calculate;

public class Printing {
    private final List<Lotto> lottos;
    private final static String END = "당첨 통계\n---";
    private final static String RESULT_MESSAGE = "%d개 일치 (%s원) - %d개";
    private final static String RESULT_MESSAGE_OTHER = "%d개 일치. 보너스 볼 일치 (%s원) - %d개";
    private final static String RATE_OF_RETURN = "총 수익률은 %.1f%%입니다.";

    public Printing(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public void printLotto(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            lotto.printLotto();
        }
    }

    public void printResult(LinkedHashMap<WinningDetails, Integer> rank, int money) {
        System.out.println(END);
        for (WinningDetails win : rank.keySet()) {
            int key = rank.get(win);

            System.out.println(getString(win, key));
        }
    }

    private String getString(WinningDetails win, int key) {
        if (win == WinningDetails.SECOND) {
            return String.format(RESULT_MESSAGE_OTHER
                    , win.getCount()
                    , String.format("%,d", win.getPrize())
                    , key);
        }
        return String.format(RESULT_MESSAGE
                , win.getCount()
                , String.format("%,d", win.getPrize())
                , key);
    }
}
