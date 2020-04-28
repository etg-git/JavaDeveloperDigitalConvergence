import java.util.*;
class LottoTest {
	public static void main(String[] args) {
		MyLottoNumbers myNumbers = new MyLottoNumbers();

		myNumbers.howManyLotto();
		
		LottoResult lotto = new LottoResult(myNumbers);

		lotto.winningNumber();
		lotto.result();
	}
}