import java.util.*;
class LottoResult {
	private MyLottoNumbers myLottoNumbers;

	private ArrayList<Integer> winningNumberList;

	public final static int SLAP = 2;
    public final static int FIFTH = 3;
    public final static int FOURTH = 4;
    public final static int THIRTH = 5;
    public final static int FIRST = 6;
	public final static int SECOND = 6;
	public final static int WINNING_LOTTONUMBER_COUNT = 7;
	
	public LottoResult(MyLottoNumbers myLottoNumbers) {
		setLottoMachine(myLottoNumbers);
	}

	public MyLottoNumbers getLottoMachine() {
		return myLottoNumbers;
	}
	public void setLottoMachine(MyLottoNumbers myLottoNumbers) {
		this.myLottoNumbers = myLottoNumbers;
	}
	public ArrayList<Integer> getWinningNumberList() {
		return winningNumberList;
    }
	public void setWinningNumberList(ArrayList<Integer> winningNumberList) {
		this.winningNumberList = winningNumberList;
    }
	public ArrayList<Integer> winningNumber() {
		System.out.println("당첨번호를 추첨합니다"); 
		Set<Integer> lotto = new HashSet<>();

		while(lotto.size() != WINNING_LOTTONUMBER_COUNT) {
			lotto.add((int)(Math.random() * 45) + 1);
		}

		Integer[] array = lotto.toArray(new Integer[0]); //부분정렬 하기위해 Set -> 배열객체로 변환 

		Arrays.sort(array, 0, 6);//보너스 번호는 정렬에서 포함x

		ArrayList<Integer> winningNumberList = new ArrayList<>(Arrays.asList(array)); //배열객체 -> arraylist

		System.out.println("당첨번호 : " + winningNumberList);
		System.out.println("*마지막 번호가 보너스 번호입니다.");

		this.winningNumberList = winningNumberList;
		return winningNumberList;
	}
	public void result() {
        int count = 0;
        for(int i=0; i<myLottoNumbers.getBuyAmount(); i++) {  
            String winning = "";  
            ArrayList<Integer> lottoNumbers = myLottoNumbers.getLottoNumberLists().get(i); //산횟수만큼 로또번호들 차례대로 뽑기
            
            lottoNumbers.retainAll(getWinningNumberList()); //일치번호 뽑기
            if(lottoNumbers.size() <= SLAP) {
                winning += "꽝";
            } else if(lottoNumbers.size() == FIFTH) {
                winning += "5등 당첨";
            } else if(lottoNumbers.size() == FOURTH) {
                winning += "4등 당첨";
            } else if(lottoNumbers.size() == THIRTH) {
                winning += "3등 당첨";
            } else if(lottoNumbers.size() == SECOND &&   lottoNumbers.size() == FIRST) {
                winning += "1,2등 당첨";
            }			
            System.out.println(++count + "회 게임 결과 : " +	winning	+ "		일치번호 ->" + lottoNumbers);
        }
	}
	@Override
	public String toString() {
		return "";
	}
}
