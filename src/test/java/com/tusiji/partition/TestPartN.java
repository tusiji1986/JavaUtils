package com.tusiji.partition;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class TestPartN{
	
	/**
	 * 手工实现list的分批
	 */
	//@Test
	public void testPartN1() {
		List<Integer> list = new ArrayList<Integer>();
		for (int j=0;j<18;j++) {
			list.add(j);
		}
		
		int N = 7;
		int pageNum = N;
		int count = list.size();
		int pageSize = count / pageNum;
		for (int i=1;i<=pageNum;i++) {
			int fromIndex = (i-1)*pageSize;
			int toIndex = (i==pageNum)?count:i*pageSize;
			System.out.println("testPartN1 "+list.subList(fromIndex, toIndex));
		}
	}
	
	@Test
	public void testPartN2() {
		List<Integer> list = new ArrayList<Integer>();
		for (int j=0;j<18;j++) {
			list.add(j);
		}	
		int N = 12;
		int pageNum = N;
		int count = list.size();
		int pageSize = count / pageNum;
		int remaider = count % pageNum;
		int offset=0;//偏移量
		for (int i=1;i<=pageNum;i++) {
			if (remaider > 0) {
				int fromIndex = (i-1)*pageSize+offset;
				int endIndex = i*pageSize+offset+1;
				System.out.println(list.subList(fromIndex, endIndex));
				
				remaider--;
				offset++;
			} else {
				int fromIndex = (i-1)*pageSize+offset;
				int endIndex = i*pageSize+offset;
				System.out.println(list.subList(fromIndex, endIndex));
			}
		}
	}
}
