package com.tusiji.partition;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.google.common.collect.Lists;

public class TestPartitionList{
	
	/**
	 * 手工实现list的分批
	 */
	//@Test
	public void testPartition1() {
		List<Integer> list = new ArrayList<Integer>();
		for (int j=0;j<18;j++) {
			list.add(j);
		}
		
		int count = list.size();
		int pageSize = 5;		
		int pageNum = ((count%pageSize==0)?count/pageSize:count/pageSize+1);
		
		for (int i=1;i<=pageNum;i++) {
			int fromIndex = (i-1)*pageSize;
			int endIndex = Math.min(count, i*pageSize);
			System.out.println("testPartition1 "+list.subList(fromIndex, endIndex));
		}
	}
	
	@Test
	public void testPartition2() {
		List<Integer> list = new ArrayList<Integer>();
		for (int j=0;j<18;j++) {
			list.add(j);
		}
		
		int pageSize = 7;
		List<List<Integer>> partitionList = Lists.partition(list, pageSize);
		for (List<Integer> listEle : partitionList) {
			System.out.println("testPartition2 "+listEle);
		}
	}
}
