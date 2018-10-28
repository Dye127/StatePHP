package hr.test.midi;

import java.awt.List;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class MidiTest181716 {
	File mfname = null;
	MidiFile mf = null;
	int rootnum = 0;
	Random rand = new Random();

	// 获取单音的上限
	public int getMax(int rules[]) {
		int max = 127;
		int len = rules.length;
		max -= rules[len - 1];
		return max;
	}

	// 生成midi文件
	public void makeMidi(String filePath, int rootnum, int rules[]) {

		mfname = new File(filePath);
		mfname.setReadable(true, false);
		mf = new MidiFile();

		int len = rules.length;
//		rootnum = 50;
//		mf.noteOn(0, rootnum, 127);
//		mf.noteOn(0, rootnum+4, 127);
//		mf.noteOn(0, rootnum+7, 127);
//		mf.noteOff(32, rootnum);
//		mf.noteOff(0, rootnum+4);
//		mf.noteOff(0, rootnum+7);
		
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
		// 不定长多维数组
		// 记录和弦类型的规则
		int[][] chordsRules = { { 4, 7 }, { 3, 7 }, { 4, 8 }, { 3, 6 }, { 4, 7, 11 }, { 4, 3, 10 }, { 3, 7, 10 },
				{ 3, 6, 10 }, { 3, 6, 9 }, { 3, 7, 11 }, { 4, 8, 11 }, { 3, 8 }, { 5, 9 }, { 4, 9 }, { 5, 8 }, { 4, 8 },
				{ 4, 7 }, { 3, 9 }, { 6, 9 }, { 3, 7, 8 }, { 4, 5, 9 }, { 1, 5, 8 }, { 3, 6, 8 }, { 3, 5, 9 },
				{ 2, 6, 9 }, { 4, 7, 9 }, { 3, 5, 8 }, { 2, 5, 9 }, { 3, 6, 8 }, { 4, 6, 9 }, { 2, 5, 8 }, { 3, 5, 8 },
				{ 3, 6, 9 }, { 3, 6, 8 }, { 4, 8, 9 }, { 4, 5, 8 }, { 1, 4, 8 }, { 4, 7, 8 }, { 4, 1, 8 },
				{ 1, 5, 9 } };
		int rulesTypeNum = chordsRules.length; // 获取和弦种类

		MidiTest181716 test = new MidiTest181716();

		for (int i = 0; i < rulesTypeNum; i++) {
			maxNum = test.getMax(chordsRules[i]); // 确定最大的单音位置
			for (int j = 0; j <= maxNum; j++) {
				filePath = "E:\\Javaee\\Midi\\midi" + i + "_" + j + ".mid"; // 构造文件名																		// 和弦种类、低音位置
				test.makeMidi(filePath, j, chordsRules[i]);
			}

		}
		
		//test.makeMidi(filePath, 50, chordsRules[0]);

	}

}
