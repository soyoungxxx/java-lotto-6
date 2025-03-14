package lotto.view;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.domain.Lotto;

public class OutputLottos {
    public OutputLottos(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            List<Integer> lottoNumber = new ArrayList<>(lotto.getLotto());
            Collections.sort(lottoNumber);
            System.out.println(lottoNumber);
        }
    }
}
