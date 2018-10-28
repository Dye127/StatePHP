package hr.test.midi;

import java.io.File;
import java.io.IOException;
import java.util.Random;

public class MidiTest {
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
		
		//����
//		mf.noteOn(0, rootnum, 127);
//		mf.noteOff(16, rootnum);
//
//		for (int i = 0; i < len; i++) {
//			mf.noteOn(0, rootnum + rules[i], 127);
//			mf.noteOff(16, rootnum + rules[i]);
//		}
		
		//����


		for (int i = len-1; i >= 0; i--) {
			mf.noteOn(0, rootnum + rules[i], 127);
			mf.noteOff(16, rootnum + rules[i]);
		}
		
		mf.noteOn(0, rootnum, 127);
		mf.noteOff(16, rootnum);
		
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
		//int[][] chordsRules = { { 4, 7 }};
		int[][] chordsRules = { { 4, 7 }, { 3, 7 }, { 4, 8 }, { 3, 6 }, { 4, 7, 11 }, { 4, 3, 10 }, { 3, 7, 10 },
				{ 3, 6, 10 }, { 3, 6, 9 }, { 3, 7, 11 }, { 4, 8, 11 }, { 3, 8 }, { 5, 9 }, { 4, 9 }, { 5, 8 }, { 4, 8 },
				{ 4, 7 }, { 3, 9 }, { 6, 9 }, { 3, 7, 8 }, { 4, 5, 9 }, { 1, 5, 8 }, { 3, 6, 8 }, { 3, 5, 9 },
				{ 2, 6, 9 }, { 4, 7, 9 }, { 3, 5, 8 }, { 2, 5, 9 }, { 3, 6, 8 }, { 4, 6, 9 }, { 2, 5, 8 }, { 3, 5, 8 },
				{ 3, 6, 9 }, { 3, 6, 8 }, { 4, 8, 9 }, { 4, 5, 8 }, { 1, 4, 8 }, { 4, 7, 8 }, { 4, 1, 8 },
				{ 1, 5, 9 } };//0~39 
	//	int[][] chordsRules = {{2,7},{5,7}};//40,43  89 92      138  141
		//int[][] chordsRules = {{2,7},{5,10}};//44=>[2,7],45=>[5,10]   93 94     142 143
		//����+49
		//����+98
		int rulesTypeNum = chordsRules.length; // ��ȡ��������

		MidiTest test = new MidiTest();

		for (int i = 0; i < rulesTypeNum; i++) {
			maxNum = test.getMax(chordsRules[i]); // ȷ�����ĵ���λ��
			for (int j = minNum; j <= maxNum; j++) {
//				if(i==0){
//					filePath = "E:\\Javaee\\Midi\\midi138_" + j + ".mid"; // �����ļ���		
//				}else if(i==1){
//					filePath = "E:\\Javaee\\Midi\\midi141_" + j + ".mid"; // �����ļ���		
//				}
				filePath = "E:\\Javaee\\Midi\\midi" + (i+98) + "_" + j + ".mid"; // �����ļ���																		// �������ࡢ����λ��
				test.makeMidi(filePath, j, chordsRules[i]);
			}

		}
		
	}

}
