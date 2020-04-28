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
		System.out.println("��÷��ȣ�� ��÷�մϴ�"); 
		Set<Integer> lotto = new HashSet<>();

		while(lotto.size() != WINNING_LOTTONUMBER_COUNT) {
			lotto.add((int)(Math.random() * 45) + 1);
		}

		Integer[] array = lotto.toArray(new Integer[0]); //�κ����� �ϱ����� Set -> �迭��ü�� ��ȯ 

		Arrays.sort(array, 0, 6);//���ʽ� ��ȣ�� ���Ŀ��� ����x

		ArrayList<Integer> winningNumberList = new ArrayList<>(Arrays.asList(array)); //�迭��ü -> arraylist

		System.out.println("��÷��ȣ : " + winningNumberList);
		System.out.println("*������ ��ȣ�� ���ʽ� ��ȣ�Դϴ�.");

		this.winningNumberList = winningNumberList;
		return winningNumberList;
	}
	public void result() {
        int count = 0;
        for(int i=0; i<myLottoNumbers.getBuyAmount(); i++) {  
            String winning = "";  
            ArrayList<Integer> lottoNumbers = myLottoNumbers.getLottoNumberLists().get(i); //��Ƚ����ŭ �ζǹ�ȣ�� ���ʴ�� �̱�
            
            lottoNumbers.retainAll(getWinningNumberList()); //��ġ��ȣ �̱�
            if(lottoNumbers.size() <= SLAP) {
                winning += "��";
            } else if(lottoNumbers.size() == FIFTH) {
                winning += "5�� ��÷";
            } else if(lottoNumbers.size() == FOURTH) {
                winning += "4�� ��÷";
            } else if(lottoNumbers.size() == THIRTH) {
                winning += "3�� ��÷";
            } else if(lottoNumbers.size() == SECOND &&   lottoNumbers.size() == FIRST) {
                winning += "1,2�� ��÷";
            }			
            System.out.println(++count + "ȸ ���� ��� : " +	winning	+ "		��ġ��ȣ ->" + lottoNumbers);
        }
	}
	@Override
	public String toString() {
		return "";
	}
}
