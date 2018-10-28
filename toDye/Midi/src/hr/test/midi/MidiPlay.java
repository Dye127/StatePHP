package hr.test.midi;

import java.util.Random;

class MidiPlay {
	int rootnum;
	int which;
	Random rand=new Random();
	
	int [] erDu(MidiFile mf)
	{
		int num[]={-1,-1,-1,-1};
		rootnum=rand.nextInt(35)+40;
		which=rand.nextInt(4);
		num[0]=rootnum;
		num[1]=which;
		if(which==0)//大二度
		{
			mf.noteOn(0,rootnum, 127);
			mf.noteOff(16, rootnum);
			mf.noteOn(0,rootnum+2, 127);
			mf.noteOff(16, rootnum+2);
		}
		else if(which==1)//小二度
		{
			mf.noteOn(0,rootnum, 127);
			mf.noteOff(16, rootnum);
			mf.noteOn(0,rootnum+1, 127);
			mf.noteOff(16, rootnum+1);
		}
		
		else if(which==2)//小二度转位即大七度
		{
			mf.noteOn(0,rootnum+1, 127);
			mf.noteOff(16, rootnum+1);
			mf.noteOn(0,rootnum+12, 127);
			mf.noteOff(16, rootnum+12);
		}
		else//大二度转位即小七度
		{
			mf.noteOn(0,rootnum+2, 127);
			mf.noteOff(16, rootnum+2);
			mf.noteOn(0,rootnum+12, 127);
			mf.noteOff(16, rootnum+12);
		}
		return num;		
	}
	int [] sanDu(MidiFile mf)
	{
		int num[]={-1,-1,-1,-1};
		rootnum=rand.nextInt(35)+40;
		which=rand.nextInt(4);
		num[0]=rootnum;
		num[1]=which;
		if(which==0)//大三度
		{
			mf.noteOn(0,rootnum, 127);
			mf.noteOff(16, rootnum);
			mf.noteOn(0,rootnum+4, 127);
			mf.noteOff(16, rootnum+4);
		}
		else if(which==1)//小三度
		{
			mf.noteOn(0,rootnum, 127);
			mf.noteOff(16, rootnum);
			mf.noteOn(0,rootnum+3, 127);
			mf.noteOff(16, rootnum+3);
		}
		else if(which==2)//大六度
		{
			mf.noteOn(0,rootnum+3, 127);
			mf.noteOff(16, rootnum+3);
			mf.noteOn(0,rootnum+12, 127);
			mf.noteOff(16, rootnum+12);
		}
		else if(which==3)//小六度
		{
			mf.noteOn(0,rootnum+4, 127);
			mf.noteOff(16, rootnum+4);
			mf.noteOn(0,rootnum+12, 127);
			mf.noteOff(16, rootnum+12);
		}
		return num;		
	}
	int [] siWuDu(MidiFile mf)
	{
		int num[]={-1,-1,-1,-1};
		rootnum=rand.nextInt(30)+40;
		which=rand.nextInt(3);
		num[0]=rootnum;
		num[1]=which;
		if(which==0)//纯四度
		{
			mf.noteOn(0,rootnum, 127);
			mf.noteOff(16, rootnum);
			mf.noteOn(0,rootnum+5, 127);
			mf.noteOff(16, rootnum+5);
		}
		else if(which==2)//增四减五 
		{
			mf.noteOn(0,rootnum, 127);
			mf.noteOff(16, rootnum);
			mf.noteOn(0,rootnum+6, 127);
			mf.noteOff(16, rootnum+6);
		}
		else//纯五度
		{
			mf.noteOn(0,rootnum, 127);
			mf.noteOff(16, rootnum);
			mf.noteOn(0,rootnum+7, 127);
			mf.noteOff(16, rootnum+7);
		}
		return num;		
	}
	int [] chunYiChunBaDu(MidiFile mf)
	{
		int num[]={-1,-1,-1,-1};
		rootnum=rand.nextInt(30)+40;
		which=rand.nextInt(2);
		num[0]=rootnum;
		num[1]=which;
		if(which==0)//纯一度
		{
			mf.noteOn(0,rootnum, 127);
			mf.noteOn(0,rootnum, 127);
			mf.noteOff(16, rootnum);
			mf.noteOff(0, rootnum);
		}
		else//纯八度
		{
			mf.noteOn(0,rootnum, 127);
			mf.noteOn(0,rootnum+12, 127);
			mf.noteOff(16, rootnum);
			mf.noteOff(0, rootnum+12);
		}
		return num;		
	}
	int [] sanHeXian(MidiFile mf)
	{
		int num[]={-1,-1,-1,-1};
		rootnum=rand.nextInt(24)+40;
		which=rand.nextInt(12);
		num[0]=rootnum;
		num[1]=which;
		if(which==0)//原位大三和弦
		{
			mf.noteOn(0, rootnum, 127);
			mf.noteOn(0, rootnum+4, 127);
			mf.noteOn(0, rootnum+7, 127);
			mf.noteOff(32, rootnum);
			mf.noteOff(0, rootnum+4);
			mf.noteOff(0, rootnum+7);
		}
		else if(which==1)//大六和弦
		{
			mf.noteOn(0, rootnum+4, 127);
			mf.noteOn(0, rootnum+7, 127);
			mf.noteOn(0, rootnum+12, 127);
			mf.noteOff(32, rootnum+4);
			mf.noteOff(0, rootnum+7);
			mf.noteOff(0, rootnum+12);
		}
		else if(which==2)//大四六和弦
		{
			mf.noteOn(0, rootnum+7, 127);
			mf.noteOn(0, rootnum+12, 127);
			mf.noteOn(0, rootnum+16, 127);
			mf.noteOff(32, rootnum+7);
			mf.noteOff(0, rootnum+12);
			mf.noteOff(0, rootnum+16);
		}
		else if(which==3)//原位小三和弦
		{
			mf.noteOn(0, rootnum, 127);
			mf.noteOn(0, rootnum+3, 127);
			mf.noteOn(0, rootnum+7, 127);
			mf.noteOff(32, rootnum);
			mf.noteOff(0, rootnum+3);
			mf.noteOff(0, rootnum+7);
		}
		else if(which==4)//小六和弦
		{
			mf.noteOn(0, rootnum+3, 127);
			mf.noteOn(0, rootnum+7, 127);
			mf.noteOn(0, rootnum+12, 127);
			mf.noteOff(32, rootnum+3);
			mf.noteOff(0, rootnum+7);
			mf.noteOff(0, rootnum+12);
		}
		else if(which==5)//小四六和弦
		{
			mf.noteOn(0, rootnum+7, 127);
			mf.noteOn(0, rootnum+12, 127);
			mf.noteOn(0, rootnum+15, 127);
			mf.noteOff(32, rootnum+7);
			mf.noteOff(0, rootnum+12);
			mf.noteOff(0, rootnum+15);
		}
		else if(which==6)//增三和弦
		{
			mf.noteOn(0, rootnum, 127);
			mf.noteOn(0, rootnum+4, 127);
			mf.noteOn(0, rootnum+8, 127);
			mf.noteOff(32, rootnum);
			mf.noteOff(0, rootnum+4);
			mf.noteOff(0, rootnum+8);
		}
		else if(which==7)//增六和弦
		{
			mf.noteOn(0, rootnum+4, 127);
			mf.noteOn(0, rootnum+8, 127);
			mf.noteOn(0, rootnum+12, 127);
			mf.noteOff(32, rootnum+4);
			mf.noteOff(0, rootnum+8);
			mf.noteOff(0, rootnum+12);
		}
		else if(which==8)//增四六和弦
		{
			mf.noteOn(0, rootnum+8, 127);
			mf.noteOn(0, rootnum+12, 127);
			mf.noteOn(0, rootnum+16, 127);
			mf.noteOff(32, rootnum+8);
			mf.noteOff(0, rootnum+12);
			mf.noteOff(0, rootnum+16);
		}
		else if(which==9)//减三和弦
		{
			mf.noteOn(0, rootnum, 127);
			mf.noteOn(0, rootnum+3, 127);
			mf.noteOn(0, rootnum+6, 127);
			mf.noteOff(32, rootnum);
			mf.noteOff(0, rootnum+3);
			mf.noteOff(0, rootnum+6);
		}
		else if(which==10)//减六和弦
		{
			mf.noteOn(0, rootnum+3, 127);
			mf.noteOn(0, rootnum+6, 127);
			mf.noteOn(0, rootnum+12, 127);
			mf.noteOff(32, rootnum+3);
			mf.noteOff(0, rootnum+6);
			mf.noteOff(0, rootnum+12);
		}
		else if(which==11)//减四六和弦
		{
			mf.noteOn(0, rootnum+6, 127);
			mf.noteOn(0, rootnum+12, 127);
			mf.noteOn(0, rootnum+15, 127);
			mf.noteOff(32, rootnum+6);
			mf.noteOff(0, rootnum+12);
			mf.noteOff(0, rootnum+15);
		}
		
		return num;
	}
	int [] qiHeXian(MidiFile mf)
	{
		int num[]={-1,-1,-1,-1};
		rootnum=rand.nextInt(24)+40;
		which=rand.nextInt(8);
		num[0]=rootnum;
		num[1]=which;
		if(which==0)//大小七和弦原位
		{
			mf.noteOn(0, rootnum, 127);
			mf.noteOn(0, rootnum+4, 127);
			mf.noteOn(0, rootnum+7, 127);
			mf.noteOn(0, rootnum+10, 127);
			mf.noteOff(32,rootnum);
			mf.noteOff(0, rootnum+4);
			mf.noteOff(0, rootnum+7);
			mf.noteOff(0, rootnum+10);
		}
		else if(which==1)//大小五六和弦
		{
			mf.noteOn(0, rootnum+4, 127);
			mf.noteOn(0, rootnum+7, 127);
			mf.noteOn(0, rootnum+10, 127);
			mf.noteOn(0, rootnum+12, 127);
			mf.noteOff(32, rootnum+4);
			mf.noteOff(0, rootnum+7);
			mf.noteOff(0, rootnum+10);
			mf.noteOff(0, rootnum+12);
		}
		else if(which==2)//大小三四和弦
		{
			mf.noteOn(0, rootnum+7, 127);
			mf.noteOn(0, rootnum+10, 127);
			mf.noteOn(0, rootnum+12, 127);
			mf.noteOn(0, rootnum+16, 127);
			mf.noteOff(32, rootnum+7);
			mf.noteOff(0, rootnum+10);
			mf.noteOff(0, rootnum+12);
			mf.noteOff(0, rootnum+16);
		}
		else if(which==3)//大小二和弦
		{
			mf.noteOn(0, rootnum+10, 127);
			mf.noteOn(0, rootnum+12, 127);
			mf.noteOn(0, rootnum+16, 127);
			mf.noteOn(0, rootnum+19, 127);
			mf.noteOff(32, rootnum+10);
			mf.noteOff(0, rootnum+12);
			mf.noteOff(0, rootnum+16);
			mf.noteOff(0, rootnum+19);
		}
		else if(which==4)//小小七和弦原位
		{
			mf.noteOn(0, rootnum, 127);
			mf.noteOn(0, rootnum+3, 127);
			mf.noteOn(0, rootnum+7, 127);
			mf.noteOn(0, rootnum+10, 127);//从根音到小七度音之间有十个键
			mf.noteOff(32, rootnum);
			mf.noteOff(0, rootnum+3);
			mf.noteOff(0, rootnum+7);
			mf.noteOff(0, rootnum+10);
		}
		else if(which==5)//小小五六和弦
		{
			mf.noteOn(0, rootnum+3, 127);
			mf.noteOn(0, rootnum+7, 127);
			mf.noteOn(0, rootnum+10, 127);
			mf.noteOn(0, rootnum+12, 127);
			mf.noteOff(32, rootnum+3);
			mf.noteOff(0, rootnum+7);
			mf.noteOff(0, rootnum+10);
			mf.noteOff(0, rootnum+12);
		}
		else if(which==6)//小小三四和弦
		{
			mf.noteOn(0, rootnum+7, 127);
			mf.noteOn(0, rootnum+10, 127);
			mf.noteOn(0, rootnum+12, 127);
			mf.noteOn(0, rootnum+15, 127);
			mf.noteOff(32, rootnum+7);
			mf.noteOff(0, rootnum+10);
			mf.noteOff(0, rootnum+12);
			mf.noteOff(0, rootnum+15);
		}
		else if(which==7)//小小二和弦
		{
			mf.noteOn(0, rootnum+10, 127);
			mf.noteOn(0, rootnum+12, 127);
			mf.noteOn(0, rootnum+15, 127);
			mf.noteOn(0, rootnum+19, 127);
			mf.noteOff(32, rootnum+10);
			mf.noteOff(0, rootnum+12);
			mf.noteOff(0, rootnum+15);
			mf.noteOff(0, rootnum+19);
		}
		return num;
	}
	int [] shengzirandaxiaodiao(MidiFile mf)
	{
		int num[]={-1,-1,-1,-1};
		int r=rand.nextInt(2);
		if(r==0)
			rootnum=48;
		else
			rootnum=60;
		which=rand.nextInt(16);
		num[0]=rootnum;
		num[1]=which;
		if(which==0)//C大调
		{
			mf.noteOn(0,69, 127);//la
			mf.noteOff(32, 69);
			
			mf.noteOn(0,rootnum, 127);//1 c
			mf.noteOff(8, rootnum);
			mf.noteOn(0,rootnum+2, 127);//2  d
			mf.noteOff(8, rootnum+2);
			mf.noteOn(0,rootnum+4, 127);//3  e
			mf.noteOff(8, rootnum+4);
			mf.noteOn(0,rootnum+5, 127);//4  f
			mf.noteOff(8, rootnum+5);
			mf.noteOn(0,rootnum+7, 127);//5  g
			mf.noteOff(8, rootnum+7);
			mf.noteOn(0,rootnum+9, 127);//6  a
			mf.noteOff(8, rootnum+9);
			mf.noteOn(0,rootnum+11, 127);//7  b
			mf.noteOff(8, rootnum+11);
			mf.noteOn(0,rootnum+12, 127);//1  c2
			mf.noteOff(8, rootnum+12);
		}
		else if(which==1)//a小调
		{
			mf.noteOn(0,69, 127);//la
			mf.noteOff(32, 69);
			
			mf.noteOn(0,rootnum-2, 127);//6 .a
			mf.noteOff(8, rootnum-2);
			mf.noteOn(0,rootnum+11, 127);//7  b
			mf.noteOff(8, rootnum+11);
			mf.noteOn(0,rootnum, 127);//1  c
			mf.noteOff(8, rootnum);
			mf.noteOn(0,rootnum+2, 127);//2  d
			mf.noteOff(8, rootnum+2);
			mf.noteOn(0,rootnum+4, 127);//3  e
			mf.noteOff(8, rootnum+4);
			mf.noteOn(0,rootnum+5, 127);//4  f
			mf.noteOff(8, rootnum+5);
			mf.noteOn(0,rootnum+7, 127);//5  g
			mf.noteOff(8, rootnum+7);
			mf.noteOn(0,rootnum+9, 127);//6  a
			mf.noteOff(8, rootnum+9);
		}
		else if(which==2)//G大调
		{
			mf.noteOn(0,69, 127);//la
			mf.noteOff(32, 69);
			
			mf.noteOn(0,rootnum+7, 127);//5  g
			mf.noteOff(8, rootnum+7);
			mf.noteOn(0,rootnum+9, 127);//6  a
			mf.noteOff(8, rootnum+9);
			mf.noteOn(0,rootnum+11, 127);//7  b
			mf.noteOff(8, rootnum+11);
			mf.noteOn(0,rootnum+12, 127);//1  c.
			mf.noteOff(8, rootnum+12);
			mf.noteOn(0,rootnum+14, 127);//2  d.
			mf.noteOff(8, rootnum+14);
			mf.noteOn(0,rootnum+16, 127);//3  e.
			mf.noteOff(8, rootnum+16);
			mf.noteOn(0,rootnum+18, 127);//4#  #f.
			mf.noteOff(8, rootnum+18);
			mf.noteOn(0,rootnum+19, 127);//5  g
			mf.noteOff(8, rootnum+19);
		}
		else if(which==3)//e小调
		{
			mf.noteOn(0,69, 127);//la
			mf.noteOff(32, 69);
			
			mf.noteOn(0,rootnum+4, 127);//3  e
			mf.noteOff(8, rootnum+4);
			mf.noteOn(0,rootnum+6, 127);//4#  #f
			mf.noteOff(8, rootnum+6);
			mf.noteOn(0,rootnum+7, 127);//5  g
			mf.noteOff(8, rootnum+7);
			mf.noteOn(0,rootnum+9, 127);//6  a
			mf.noteOff(8, rootnum+9);
			mf.noteOn(0,rootnum+11, 127);//7  b
			mf.noteOff(8, rootnum+11);
			mf.noteOn(0,rootnum+12, 127);//1  c.
			mf.noteOff(8, rootnum+12);
			mf.noteOn(0,rootnum+14, 127);//2  d.
			mf.noteOff(8, rootnum+14);
			mf.noteOn(0,rootnum+16, 127);//3  e.
			mf.noteOff(8, rootnum+16);
		}
		else if(which==4)//D大调
		{
			mf.noteOn(0,69, 127);//la
			mf.noteOff(32, 69);
			
			mf.noteOn(0,rootnum+2, 127);//2  d
			mf.noteOff(8, rootnum+2);
			mf.noteOn(0,rootnum+4, 127);//3  e
			mf.noteOff(8, rootnum+4);
			mf.noteOn(0,rootnum+6, 127);//4#  #f
			mf.noteOff(8, rootnum+6);
			mf.noteOn(0,rootnum+7, 127);//5  g
			mf.noteOff(8, rootnum+7);
			mf.noteOn(0,rootnum+9, 127);//6  a
			mf.noteOff(8, rootnum+9);
			mf.noteOn(0,rootnum+11, 127);//7  b
			mf.noteOff(8, rootnum+11);
			mf.noteOn(0,rootnum+13, 127);//1#   #c.
			mf.noteOff(8, rootnum+13);
			mf.noteOn(0,rootnum+14, 127);//2  d.
			mf.noteOff(8, rootnum+14);
		}
		else if(which==5)//b小调
		{
			mf.noteOn(0,69, 127);//la
			mf.noteOff(32, 69);
			
			mf.noteOn(0, rootnum-1, 127);//.7     .b
			mf.noteOff(8, rootnum-1);
			mf.noteOn(0,rootnum+1, 127);//1#    #c
			mf.noteOff(8, rootnum+1);
			mf.noteOn(0,rootnum+2, 127);//2  d
			mf.noteOff(8, rootnum+2);
			mf.noteOn(0,rootnum+4, 127);//3  e
			mf.noteOff(8, rootnum+4);
			mf.noteOn(0,rootnum+6, 127);//4#   #f
			mf.noteOff(8, rootnum+6);
			mf.noteOn(0,rootnum+7, 127);//5  g
			mf.noteOff(8, rootnum+7);
			mf.noteOn(0,rootnum+9, 127);//6  a
			mf.noteOff(8, rootnum+9);
			mf.noteOn(0,rootnum+11, 127);//7  b
			mf.noteOff(8, rootnum+11);
		}
		else if(which==6)//A大调
		{
			mf.noteOn(0,69, 127);//la
			mf.noteOff(32, 69);
			
			mf.noteOn(0,rootnum-3,127);//.6   .a
			mf.noteOff(8,rootnum-3);
			mf.noteOn(0, rootnum-1, 127);//.7     .b
			mf.noteOff(8, rootnum-1);
			mf.noteOn(0,rootnum+1, 127);//1#    #c
			mf.noteOff(8, rootnum+1);
			mf.noteOn(0,rootnum+2, 127);//2  d
			mf.noteOff(8, rootnum+2);
			mf.noteOn(0,rootnum+4, 127);//3  e
			mf.noteOff(8, rootnum+4);
			mf.noteOn(0,rootnum+6, 127);//4#   #f
			mf.noteOff(8, rootnum+6);
			mf.noteOn(0,rootnum+8, 127);//5#   #g
			mf.noteOff(8, rootnum+8);
			mf.noteOn(0,rootnum+9, 127);//6  a
			mf.noteOff(8, rootnum+9);
		}
		else if(which==7)//#f小调
		{
			mf.noteOn(0,69, 127);//la
			mf.noteOff(32, 69);
			
			mf.noteOn(0,rootnum-6,127);//.4#   .#f
			mf.noteOff(8,rootnum-6);
			mf.noteOn(0,rootnum-4,127);//.5#   .#g
			mf.noteOff(8,rootnum-4);
			mf.noteOn(0,rootnum-3,127);//.6   .a
			mf.noteOff(8,rootnum-3);
			mf.noteOn(0, rootnum-1, 127);//.7     .b
			mf.noteOff(8, rootnum-1);
			mf.noteOn(0,rootnum+1, 127);//1#    #c
			mf.noteOff(8, rootnum+1);
			mf.noteOn(0,rootnum+2, 127);//2  d
			mf.noteOff(8, rootnum+2);
			mf.noteOn(0,rootnum+4, 127);//3  e
			mf.noteOff(8, rootnum+4);
			mf.noteOn(0,rootnum+6, 127);//4#   #f
			mf.noteOff(8, rootnum+6);
		}
		else if(which==8)//E大调
		{
			mf.noteOn(0,69, 127);//la
			mf.noteOff(32, 69);
			
			mf.noteOn(0,rootnum+4, 127);//3  e
			mf.noteOff(8, rootnum+4);
			mf.noteOn(0,rootnum+6, 127);//4#  #f
			mf.noteOff(8, rootnum+6);
			mf.noteOn(0,rootnum+8, 127);//5#   #g
			mf.noteOff(8, rootnum+8);
			mf.noteOn(0,rootnum+9, 127);//6  a
			mf.noteOff(8, rootnum+9);
			mf.noteOn(0,rootnum+11, 127);//7  b
			mf.noteOff(8, rootnum+11);
			mf.noteOn(0,rootnum+13, 127);//1#   #c.
			mf.noteOff(8, rootnum+13);
			mf.noteOn(0,rootnum+15, 127);//2#   #d.
			mf.noteOff(8, rootnum+15);
			mf.noteOn(0,rootnum+16, 127);//3.    e.
			mf.noteOff(8, rootnum+16);
		}
		else if(which==9)//#c小调
		{
			mf.noteOn(0,69, 127);//la
			mf.noteOff(32, 69);
			
			mf.noteOn(0,rootnum+1, 127);//1#    #c
			mf.noteOff(8, rootnum+1);
			mf.noteOn(0,rootnum+3, 127);//2#    #d
			mf.noteOff(8, rootnum+3);
			mf.noteOn(0,rootnum+4, 127);//3  e
			mf.noteOff(8, rootnum+4);
			mf.noteOn(0,rootnum+6, 127);//4#   #f
			mf.noteOff(8, rootnum+6);
			mf.noteOn(0,rootnum+8, 127);//5#   #g
			mf.noteOff(8, rootnum+8);
			mf.noteOn(0,rootnum+9, 127);//6  a
			mf.noteOff(8, rootnum+9);
			mf.noteOn(0,rootnum+11, 127);//7  b
			mf.noteOff(8, rootnum+11);
			mf.noteOn(0,rootnum+13, 127);//1#   #c.
			mf.noteOff(8, rootnum+13);
		}
		else if(which==10)//F大调
		{
			mf.noteOn(0,69, 127);//la
			mf.noteOff(32, 69);
			
			mf.noteOn(0,rootnum+5, 127);//4   f
			mf.noteOff(8, rootnum+5);
			mf.noteOn(0,rootnum+7, 127);//5  g
			mf.noteOff(8, rootnum+7);
			mf.noteOn(0,rootnum+9, 127);//6  a
			mf.noteOff(8, rootnum+9);
			mf.noteOn(0,rootnum+10, 127);//7b  bb
			mf.noteOff(8, rootnum+10);
			mf.noteOn(0,rootnum+12, 127);//1  c.
			mf.noteOff(8, rootnum+12);
			mf.noteOn(0,rootnum+14, 127);//2  d.
			mf.noteOff(8, rootnum+14);
			mf.noteOn(0,rootnum+16, 127);//3  e.
			mf.noteOff(8, rootnum+16);
			mf.noteOn(0,rootnum+17, 127);//4  f.
			mf.noteOff(8, rootnum+17);
		}
		else if(which==11)//d小调
		{
			mf.noteOn(0,69, 127);//la
			mf.noteOff(32, 69);
			
			mf.noteOn(0,rootnum+2, 127);//2  d
			mf.noteOff(8, rootnum+2);
			mf.noteOn(0,rootnum+4, 127);//3  e
			mf.noteOff(8, rootnum+4);
			mf.noteOn(0,rootnum+5, 127);//4  f
			mf.noteOff(8, rootnum+5);
			mf.noteOn(0,rootnum+7, 127);//5  g
			mf.noteOff(8, rootnum+7);
			mf.noteOn(0,rootnum+9, 127);//6  a
			mf.noteOff(8, rootnum+9);
			mf.noteOn(0,rootnum+10, 127);//7b  bb
			mf.noteOff(8, rootnum+10);
			mf.noteOn(0,rootnum+12, 127);//1  c.
			mf.noteOff(8, rootnum+12);
			mf.noteOn(0,rootnum+14, 127);//2  d.
			mf.noteOff(8, rootnum+14);
		}
		else if(which==12)//bB大调
		{
			mf.noteOn(0,69, 127);//la
			mf.noteOff(32, 69);
			
			mf.noteOn(0, rootnum-2, 127);//.b7     .bb
			mf.noteOff(8, rootnum-2);
			mf.noteOn(0,rootnum, 127);//1  c
			mf.noteOff(8, rootnum);
			mf.noteOn(0,rootnum+2, 127);//2  d
			mf.noteOff(8, rootnum+2);
			mf.noteOn(0,rootnum+3, 127);//3b  be
			mf.noteOff(8, rootnum+3);
			mf.noteOn(0,rootnum+5, 127);//4  f
			mf.noteOff(8, rootnum+5);
			mf.noteOn(0,rootnum+7, 127);//5  g
			mf.noteOff(8, rootnum+7);
			mf.noteOn(0,rootnum+9, 127);//6  a
			mf.noteOff(8, rootnum+9);
			mf.noteOn(0,rootnum+10, 127);//7b  bb
			mf.noteOff(8, rootnum+10);
		}
		else if(which==13)//g小调
		{
			mf.noteOn(0,69, 127);//la
			mf.noteOff(32, 69);
			
			mf.noteOn(0,rootnum-5,127);//.5   .g
			mf.noteOff(8,rootnum-5);
			mf.noteOn(0,rootnum-3,127);//.6   .a
			mf.noteOff(8,rootnum-3);
			mf.noteOn(0, rootnum-2, 127);//.b7     .bb
			mf.noteOff(8, rootnum-2);
			mf.noteOn(0,rootnum, 127);//1  c
			mf.noteOff(8, rootnum);
			mf.noteOn(0,rootnum+2, 127);//2  d
			mf.noteOff(8, rootnum+2);
			mf.noteOn(0,rootnum+3, 127);//3b  be
			mf.noteOff(8, rootnum+3);
			mf.noteOn(0,rootnum+5, 127);//4  f
			mf.noteOff(8, rootnum+5);
			mf.noteOn(0,rootnum+7, 127);//5  g
			mf.noteOff(8, rootnum+7);
		}
		else if(which==14)//bE大调
		{
			mf.noteOn(0,69, 127);//la
			mf.noteOff(32, 69);
			
			mf.noteOn(0,rootnum+3, 127);//3b  be
			mf.noteOff(8, rootnum+3);
			mf.noteOn(0,rootnum+5, 127);//4  f
			mf.noteOff(8, rootnum+5);
			mf.noteOn(0,rootnum+6, 127);//5b   bg
			mf.noteOff(8, rootnum+6);
			mf.noteOn(0,rootnum+9, 127);//6  a
			mf.noteOff(8, rootnum+9);
			mf.noteOn(0,rootnum+11, 127);//7  b
			mf.noteOff(8, rootnum+11);
			mf.noteOn(0,rootnum+12, 127);//1  c.
			mf.noteOff(8, rootnum+12);
			mf.noteOn(0,rootnum+14, 127);//2  d.
			mf.noteOff(8, rootnum+14);
			mf.noteOn(0,rootnum+15, 127);//3b   be.
			mf.noteOff(8, rootnum+15);
		}
		else if(which==15)//c小调
		{
			mf.noteOn(0,69, 127);//la
			mf.noteOff(32, 69);
			
			mf.noteOn(0,rootnum, 127);//1  c
			mf.noteOff(8, rootnum);
			mf.noteOn(0,rootnum+2, 127);//2  d
			mf.noteOff(8, rootnum+2);
			mf.noteOn(0,rootnum+3, 127);//3b  be
			mf.noteOff(8, rootnum+3);
			mf.noteOn(0,rootnum+5, 127);//4  f
			mf.noteOff(8, rootnum+5);
			mf.noteOn(0,rootnum+6, 127);//5b   bg
			mf.noteOff(8, rootnum+6);
			mf.noteOn(0,rootnum+9, 127);//6  a
			mf.noteOff(8, rootnum+9);
			mf.noteOn(0,rootnum+10, 127);//7b  bb
			mf.noteOff(8, rootnum+10);
			mf.noteOn(0,rootnum+12, 127);//1  c.
			mf.noteOff(8, rootnum+12);
		}
		return num;
	}
	
	int [] jiezouxing(MidiFile mf)
	{
		int num[]={-1,-1,-1,-1};
		rootnum=65;
		which=rand.nextInt(12);
		num[0]=rootnum;
		num[1]=which;
		if(which==0)//双八
		{
			mf.noteOn(0,rootnum, 127);
			mf.noteOff(8, rootnum);
			mf.noteOn(0,rootnum, 127);
			mf.noteOff(8, rootnum);
		}
		else if(which==1)//四十六
		{
			mf.noteOn(0,rootnum, 127);
			mf.noteOff(4, rootnum);
			mf.noteOn(0,rootnum, 127);
			mf.noteOff(4, rootnum);
			mf.noteOn(0,rootnum, 127);
			mf.noteOff(4, rootnum);
			mf.noteOn(0,rootnum, 127);
			mf.noteOff(4, rootnum);
		}
		else if(which==2)//前十六
		{
			mf.noteOn(0,rootnum, 127);
			mf.noteOff(4, rootnum);
			mf.noteOn(0,rootnum, 127);
			mf.noteOff(4, rootnum);
			mf.noteOn(0,rootnum, 127);
			mf.noteOff(8, rootnum);
		}
		else if(which==3)//后十六
		{
			mf.noteOn(0,rootnum, 127);
			mf.noteOff(8, rootnum);
			mf.noteOn(0,rootnum, 127);
			mf.noteOff(4, rootnum);
			mf.noteOn(0,rootnum, 127);
			mf.noteOff(4, rootnum);
		}
		else if(which==4)//小切分
		{
			mf.noteOn(0,rootnum, 127);
			mf.noteOff(4, rootnum);
			mf.noteOn(0,rootnum, 127);
			mf.noteOff(8, rootnum);
			mf.noteOn(0,rootnum, 127);
			mf.noteOff(4, rootnum);
		}
		else if(which==5)//小前符点
		{
			mf.noteOn(0,rootnum, 127);
			mf.noteOff(12, rootnum);
			mf.noteOn(0,rootnum, 100);
			mf.noteOff(4, rootnum);
		}
		else if(which==6)//小后符点
		{
			mf.noteOn(0,rootnum, 127);
			mf.noteOff(4, rootnum);
			mf.noteOn(0,rootnum, 127);
			mf.noteOff(12, rootnum);
		}
		else if(which==7)//大切分
		{
			mf.noteOn(0,rootnum, 127);
			mf.noteOff(8, rootnum);
			mf.noteOn(0,rootnum, 127);
			mf.noteOff(16, rootnum);
			mf.noteOn(0,rootnum, 127);
			mf.noteOff(8, rootnum);
		}
		else if(which==8)//大前符点
		{
			mf.noteOn(0,rootnum, 127);
			mf.noteOff(24, rootnum);
			mf.noteOn(0,rootnum, 100);
			mf.noteOff(8, rootnum);
		}
		else if(which==9)//大后符点
		{
			mf.noteOn(0,rootnum, 100);
			mf.noteOff(8, rootnum);
			mf.noteOn(0,rootnum, 127);
			mf.noteOff(24, rootnum);
		}
		else if(which==10)//大前符点后变型
		{
			mf.noteOn(0,rootnum, 127);
			mf.noteOff(24, rootnum);
			mf.noteOn(0,rootnum, 127);
			mf.noteOff(4, rootnum);
			mf.noteOn(0,rootnum, 127);
			mf.noteOff(4, rootnum);
		}
		else if(which==11)//大后符点前变型
		{
			mf.noteOn(0,rootnum, 100);
			mf.noteOff(4, rootnum);
			mf.noteOn(0,rootnum, 100);
			mf.noteOff(4, rootnum);
			mf.noteOn(0,rootnum, 127);
			mf.noteOff(24, rootnum);
		}
		
		return num;
	}

}

