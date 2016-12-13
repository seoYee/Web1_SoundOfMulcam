package service;

import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import dao.pointDAO;
import vo.pointVO;

public class pointService {
	private static pointService instance = new pointService();

	public static pointService getinstance() {
		return instance;
	}

	private pointService() {

	}

	private pointDAO dao = pointDAO.getintance();

	public pointVO callPay(int memberNum) {
		pointVO result = dao.select(memberNum);

		return result;

	}

	public int aaa(int point, int memberNum) {
		int result = dao.insert(point, memberNum);
		return result;
	}

	// 2592000000
	public double purchase(int memberNum, int days) {
		double result = 0;
		
		if(dao.select(memberNum).getPoint()>=3000){
			dao.delete(memberNum);
			double remainDate = dao.selectDate(memberNum);
			double addDays = days * 86400000l;
			System.out.println("addDays"+addDays);
			double expirationDate = nowDate() + addDays;

			if (remainDate < nowDate()) {
				dao.setDate(memberNum, expirationDate); // 만료일 입력
			} else {
				dao.addDays(memberNum, addDays); // 기간 추가
			}
			result = dao.selectDate(memberNum);
		
		}else{
			result = 0;
		}
	
		return result;

	}

	public double nowDate() {
		Date d = new Date();
		Long time = d.getTime();
		return time;
	}
	
//	public DateTimeFormatter nowDay(){
//		Date d = new Date();
//		d.setTime(1483062898319l);
//		return null;
//	}
	
}
