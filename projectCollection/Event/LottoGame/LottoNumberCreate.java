package kr.ac.green;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class LottoNumberCreate {
	public static final int MY_LOTTONUMBER_COUNT = 6;
	public static final int WINNING_LOTTONUMBER_COUNT = 7;
	
	private Set<Integer> lotto;
	private ArrayList<Integer> lottoNumberList;
	private Set<Integer> WinningNumber; 
	
	private ArrayList<Integer> winningNumberList;
	
	public LottoNumberCreate() {
		lottoNumberCreate();
	}
	public LottoNumberCreate(int i) {
		
	}
	public Set<Integer> getWinningNumber() {
		return WinningNumber;
	}


	public void setWinningNumber(Set<Integer> winningNumber) {
		WinningNumber = winningNumber;
	}


	public ArrayList<Integer> getLottoNumberList() {
		return lottoNumberList;
	}

	public void setLottoNumberList(ArrayList<Integer> lottoNumberList) {
		this.lottoNumberList = lottoNumberList;
	}
	
	
	public ArrayList<Integer> getWinningNumberList() {
		return winningNumberList;
	}
	public void setWinningNumberList(ArrayList<Integer> winningNumberList) {
		this.winningNumberList = winningNumberList;
	}
	public ArrayList<Integer> lottoNumberCreate() {
		lotto = new HashSet<>();
		while(lotto.size() != MY_LOTTONUMBER_COUNT) {
			lotto.add((int)(Math.random() * 45) + 1);
		}
		lottoNumberList = new ArrayList<Integer>(lotto);
		
		Collections.sort(lottoNumberList);
		return lottoNumberList;
	}
	//당첨번호 생성
	public ArrayList<Integer> winningNumberCreate() {
		WinningNumber = new HashSet<>();
		
		while(WinningNumber.size() != WINNING_LOTTONUMBER_COUNT) {
			WinningNumber.add((int)(Math.random() * 45) + 1);
		}
		
		Integer[] array = WinningNumber.toArray(new Integer[0]);
		
		Arrays.sort(array, 0, 6);
		
		winningNumberList = new ArrayList<>(Arrays.asList(array));
		
		return winningNumberList;
	}
	public static void main(String[] args) {
		LottoNumberCreate n = new LottoNumberCreate();
	}

}