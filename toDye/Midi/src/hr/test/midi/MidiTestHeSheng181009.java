package hr.test.midi;

import java.io.File;
import java.io.IOException;
import java.util.Random;

public class MidiTestHeSheng181009 {
	File mfname = null;
	MidiFile mf = null;
	int rootnum = 21;
	Random rand = new Random();

	// ��ȡ����������
	public int getMax(int rules[]) {
		int max = 62;//����Ĭ�� 0~87 �� ���ֶ��鵽С�ֶ���  15~62 
		int len = rules.length;
		max -= rules[len - 1];
		return max;
	}

	// ����midi�ļ�
	public void makeMidi(String filePath, int rootnum, int rules[]) {
		rootnum += 21;//���ټ�88������mid128�������
		mfname = new File(filePath);
		mfname.setReadable(true, false);
		mf = new MidiFile();

		int len = rules.length;
		
		mf.noteOn(0, rootnum, 127);

		for (int i = 0; i < len; i++) {
			mf.noteOn(0, rootnum + rules[i], 127);
		}
		mf.noteOff(32, rootnum);
		for (int i = 0; i < len; i++) {
			mf.noteOff(0, rootnum + rules[i]);
		}
		
		try {
			mf.writeToFile(filePath);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String filePath = "E:\\Javaee\\Midi\\midi.mid";
		int maxNum = 0;
		int minNum = 15;//����Ĭ�� 0~87 �� ���ֶ��鵽С�ֶ���  15~62 
		// ��������ά����
		// ��¼�������͵Ĺ���
		//version 1
		int[][] chordsRules = { { 4, 7 }, { 3, 7 }, { 4, 8 }, { 3, 6 }, 
								{ 4, 7, 11 }, { 4, 7, 10 }, { 3, 7, 10 },{ 3, 6, 10 }, { 3, 6, 9 }, { 3, 7, 11 }, { 4, 8, 11 }, 
								{ 3, 8 }, { 5, 9 }, { 4, 9 }, { 5, 8 }, { 4, 8 },{ 4, 7 }, { 3, 9 }, { 6, 9 }, 
								{ 3, 7, 8 }, { 4, 5, 9 }, { 1, 5, 8 }, 
								{ 3, 6, 8 }, { 3, 5, 9 },{ 2, 6, 9 }, 
								{ 4, 7, 9 }, { 3, 5, 8 }, { 2, 5, 9 }, 
								{ 3, 6, 8 }, { 4, 6, 9 }, { 2, 5, 8 }, 
								{ 3, 5, 8 },{ 3, 6, 9 }, { 3, 6, 8 }, 
								{ 4, 8, 9 }, { 4, 5, 8 }, { 1, 4, 8 }, 
								{ 4, 7, 8 }, { 3, 1, 8 },{ 1, 5, 9 } };//0~39
				//��������4 7 С������3 7 ��������4 8 ��������3 6
				//����ߺ���4 7 11 ��С�ߺ���4 7 10 СС�ߺ���3 7 10 ��С�ߺ���3 6 10 �����ߺ���3 6 9 С���ߺ���3 7 11 �����ߺ���4 8 11
				//תλ �������ң���������3 8 ����������5 9 С�����ң�С������4 9 С��������5 8 �������ң���������4 8 ����������4 7 �������ң���������3 9 ���������ң�6 9
				//����ߺ���תλ 378 459 158 ��С�ߺ���תλ 368 359 269 СС�ߺ���תλ��479 358 259 
				//��С�ߺ���תλ 368 469 258 �����ߺ��� 358 369 368 С���ߺ��� 489 458 148 �����ߺ��ң�478 318 159

				//�Ķ���������С�ߺ���4,3,10 �� 4,7,10 �����ߺ��ҵڶ�תλ��4,1,8 ��3,1,8


		//int[][] chordsRules = {{2,7},{5,7}};//40,43
		//int[][] chordsRules = {{2,7},{5,10}};//44=>[2,7],45=>[5,10]
		int rulesTypeNum = chordsRules.length; // ��ȡ��������

		MidiTestHeSheng181009 test = new MidiTestHeSheng181009();

		for (int i = 0; i < rulesTypeNum; i++) {
			maxNum = test.getMax(chordsRules[i]); // ȷ�����ĵ���λ��
			for (int j = minNum; j <= maxNum; j++) {
				//if(i==0){
				//	filePath = "E:\\Javaee\\Midi\\midi40_" + j + ".mid"; // �����ļ���		
				//}else if(i==1){
				//	filePath = "E:\\Javaee\\Midi\\midi43_" + j + ".mid"; // �����ļ���		
				//}
				filePath = "E:\\Javaee\\Midi\\midi" + i + "_" + j + ".mid"; // �����ļ���																		// �������ࡢ����λ��
				test.makeMidi(filePath, j, chordsRules[i]);
			}

		}
		
	}

}
