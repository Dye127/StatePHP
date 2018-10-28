package hr.test.midi;

import java.io.File;
import java.io.IOException;
import java.util.Random;

public class MidiTestHeSheng181009 {
	File mfname = null;
	MidiFile mf = null;
	int rootnum = 21;
	Random rand = new Random();

	// 获取单音的上限
	public int getMax(int rules[]) {
		int max = 62;//钢琴默认 0~87 ， 大字二组到小字二组  15~62 
		int len = rules.length;
		max -= rules[len - 1];
		return max;
	}

	// 生成midi文件
	public void makeMidi(String filePath, int rootnum, int rules[]) {
		rootnum += 21;//钢琴键88个音和mid128个音相差
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
		int minNum = 15;//钢琴默认 0~87 ， 大字二组到小字二组  15~62 
		// 不定长多维数组
		// 记录和弦类型的规则
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
				//大三和弦4 7 小三和弦3 7 增三和弦4 8 减三和弦3 6
				//大大七和弦4 7 11 大小七和弦4 7 10 小小七和弦3 7 10 减小七和弦3 6 10 减减七和弦3 6 9 小大七和弦3 7 11 增大七和弦4 8 11
				//转位 大三和弦：大六合弦3 8 大四六合弦5 9 小三和弦：小六合弦4 9 小四六和弦5 8 增三和弦：增六和弦4 8 增四六和弦4 7 减三和弦：减六和弦3 9 减四六和弦：6 9
				//大大七和弦转位 378 459 158 大小七和弦转位 368 359 269 小小七和弦转位：479 358 259 
				//减小七和弦转位 368 469 258 减减七和弦 358 369 368 小大七和弦 489 458 148 增大七和弦：478 318 159

				//改动两处：大小七和弦4,3,10 到 4,7,10 增大七和弦第二转位：4,1,8 到3,1,8


		//int[][] chordsRules = {{2,7},{5,7}};//40,43
		//int[][] chordsRules = {{2,7},{5,10}};//44=>[2,7],45=>[5,10]
		int rulesTypeNum = chordsRules.length; // 获取和弦种类

		MidiTestHeSheng181009 test = new MidiTestHeSheng181009();

		for (int i = 0; i < rulesTypeNum; i++) {
			maxNum = test.getMax(chordsRules[i]); // 确定最大的单音位置
			for (int j = minNum; j <= maxNum; j++) {
				//if(i==0){
				//	filePath = "E:\\Javaee\\Midi\\midi40_" + j + ".mid"; // 构造文件名		
				//}else if(i==1){
				//	filePath = "E:\\Javaee\\Midi\\midi43_" + j + ".mid"; // 构造文件名		
				//}
				filePath = "E:\\Javaee\\Midi\\midi" + i + "_" + j + ".mid"; // 构造文件名																		// 和弦种类、低音位置
				test.makeMidi(filePath, j, chordsRules[i]);
			}

		}
		
	}

}
