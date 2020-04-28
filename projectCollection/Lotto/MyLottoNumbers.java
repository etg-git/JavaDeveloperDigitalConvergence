import java.util.*;
class MyLottoNumbers  {
    private ArrayList<ArrayList<Integer>> lottoNumberLists;

    private int buyAmount;

    public static final int MY_LOTTONUMBER_COUNT = 6;
	public int getBuyAmount() {
		return buyAmount;
	}
    public ArrayList<ArrayList<Integer>> getLottoNumberLists() {
        return lottoNumberLists;
	}
	public void setBuyAmount(int buyAmount) {
		this.buyAmount = buyAmount;
	}
    public void setLottoNumberLists(ArrayList<ArrayList<Integer>> lottoNumberLists) {
        this.lottoNumberLists = lottoNumberLists;
    }
	private ArrayList<Integer> lottoNumberCreate() {
		Set<Integer> lotto = new HashSet<>();
		while(lotto.size() != MY_LOTTONUMBER_COUNT) {
			lotto.add((int)(Math.random() * 45) + 1);
		}
		ArrayList<Integer> lottoNumberList = new ArrayList<Integer>(lotto);
		
		Collections.sort(lottoNumberList);
		return lottoNumberList;
	}
	public ArrayList<ArrayList<Integer>> howManyLotto() {
		Scanner sc = new Scanner(System.in);
		System.out.print("몇개를 살까요? : ");
	    buyAmount = sc.nextInt();
        int count = 1;
        lottoNumberLists = new ArrayList<>();
		while(count <= buyAmount) {
            ArrayList<Integer> lottoNumbers = lottoNumberCreate(); //반복문 돌때까지 로또번호 생성	
            System.out.println(count + "회 번호 : " + lottoNumbers);
            lottoNumberLists.add(lottoNumbers); //생성된 로또 번호 add
            count++;
        }
        return lottoNumberLists;
	}
	@Override
	public String toString() {
		return "";
	}
}
