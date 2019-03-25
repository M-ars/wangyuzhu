package com.soft.demo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

/**
 * 
 * @author cute
 * 
 * 
 *         ʵ�ִ��ļ��ж���Ӣ�����£�ͳ�Ƶ��ʸ���,����ֵ�Ӵ�С���
 */

public class WordCount {

	public static void main(String[] args) throws Exception { 

		BufferedReader infile = new BufferedReader(new FileReader("F:\\Download\\source.txt"));
		String string;
		StringBuilder sb = new StringBuilder();
		while ((string = infile.readLine()) != null) {
			sb.append(string).append(" ");
		}
		infile.close();
		String file = sb.toString();
		file = file.toLowerCase();
		file = file.replaceAll("[^a-z]", " ").replaceAll("\\n", " ").replaceAll("\\s+", " ");

		Map<String, Integer> wordsCount = new TreeMap<String, Integer>(); // �洢���ʼ�����Ϣ��keyֵΪ���ʣ�valueΪ������

		// ���ʵĴ�Ƶͳ��
		String[] wordsArr1 = file.split("[^a-zA-Z]"); // ���˳�ֻ������ĸ��
		
		
		for (String word : wordsArr1) {
			if (!wordsCount.containsKey(word)) {
				wordsCount.put(word, 0);
			}
			wordsCount.put(word, wordsCount.get(word) + 1);
		}

		SortMap(wordsCount); // ��ֵ��������

	}

	// ��value�Ĵ�С��������
	public static void SortMap(Map<String, Integer> oldmap) {

		ArrayList<Map.Entry<String, Integer>> list = new ArrayList<Map.Entry<String, Integer>>(oldmap.entrySet());

		Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
			@Override
			public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
				return o2.getValue() - o1.getValue(); // ����
			}
		});

		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).getKey() + ": " + list.get(i).getValue());
		}
	}

}