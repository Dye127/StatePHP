//index.js
//获取应用实例
var downloadTask //下载事件
var currentType
var count = 0

const app = getApp()
const innerAudioContext = wx.createInnerAudioContext()
Page({
  data: {
    btStatus: [
      [true, true, true, true, true],
      [true, true, false, false, false],
      [false, true, false, false, false],
      [true, false, true, false, false],
      [true, true, false, false, true],
      [false, true, false, false, true],
      [false, false, true, false, true],
      [false, true, true, false, false],
      [false, true, true, false, true],
      [false, false, true, false, false],
      [true, false, true, false, true]
    ],
    cruStatu: 0, //用于保存当前状态
    oldStatu: 0, //用于保存旧状态 似乎还没啥用
    proRecord: [], //记录播放的题目, 
    ansStatu: [
      ['default', 'default'],
      ['primary', 'default'],
      ['warn', 'default'],
      ['default', 'primary'],
      ['default', 'warn']
    ],
    num: 0, //当前题所在位置
    rnum: 0, //当前出题数
    minP: 2,
    maxP: 4, //实际题目maxP+1
    chordType: 0, //题型
    title: '', //题型题目
    flag: false, //按钮状态
    preDownPros: [], //此次题列表
    tmpProblemsSrc: [] //播放文件临时列表
  },
  //新题目
  newGet: function () {
    //题数
    if (this.data.rnum <= this.data.maxP) {
      this.setData({
        num: this.data.num + 1,
        rnum: this.data.rnum + 1
      })
    } else {
      return
    }

    switch (this.data.cruStatu) {
      case 0:
        this.setStatu(1, 0)
        break;
      case 1:
        this.setStatu(2, 1)
        break
      case 2:
      case 5:
        if (this.data.rnum <= this.data.maxP)
          this.setStatu(2, 2) //
        else{
            this.setStatu(7, 2) //到了最后一道题
            this.setData({ NextGroup: false })
          }
        break
      case 4:
        this.setStatu(2, 4)
        break
      default:
        break;
    }
    var that = this
    var chordType = this.data.chordType;
    //记录题目
    var _proRecord = that.data.proRecord
    var currentChordDetail = app.globalData.problemDetail[chordType];
    //题目显示顺序随机打乱
    currentChordDetail.sort(function () {
      return (0.5 - Math.random());
    })

    var res = that.data.preDownPros[that.data.num - 1] //数组从0开始
    var body = res.data
    var src = 'https://www.ranh941.com/audio/chord/midi'
    //记录当前的和弦
    _proRecord[that.data.num] = [res.answer, body.chord, currentChordDetail] //记录当前的和弦 数组从1开始
    //和弦对应的名称
    var allChoyrdType = app.globalData.chordType
    var tmp = []
    for (var x in currentChordDetail) {
      tmp.push({
        id: currentChordDetail[x],
        name: allChoyrdType[currentChordDetail[x]]
      });
    }
    that.setData({
      proRecord: _proRecord,
      currentChordDetail: tmp
    })
    innerAudioContext.stop() //防止多次播放的影响
    innerAudioContext.src = that.data.tmpProblemsSrc[that.data.num - 1]
    innerAudioContext.play()
  },
  //重放
  rePlay: function () {
    innerAudioContext.stop() //把上次的播放停止
    innerAudioContext.play()
  },
  //上一题
  lastGet: function () {
    switch (this.data.cruStatu) {
      case 5:
      case 2:
        if (this.data.num == this.data.minP)
          this.setStatu(3, 2)
        else
          this.setStatu(9, 2)
        break
      case 6:
      case 9:
        if (this.data.num == this.data.minP)
          this.setStatu(3, 9)
        else
          this.setStatu(9, 9)
        break
      case 7:
        this.setStatu(9, 7)
        break
      case 8:
        this.setStatu(9, 8)
        break
      default:
        break;
    }
    if (this.data.num >= this.data.minP) {
      this.setData({
        num: this.data.num - 1
      })
    }
    var src = 'https://www.ranh941.com/audio/chord/midi'
    var currentChordDetail = this.data.proRecord[this.data.num][2]
    var allChoyrdType = app.globalData.chordType
    var tmp = []
    for (var x in currentChordDetail) {
      tmp.push({
        id: currentChordDetail[x],
        name: allChoyrdType[currentChordDetail[x]]
      });
    }
    this.setData({
      currentChordDetail: tmp
    })
    innerAudioContext.stop() //防止多次播放的影响
    innerAudioContext.src = this.data.tmpProblemsSrc[this.data.num - 1]
    innerAudioContext.play()

  },
  //下一题
  nextGet: function () {
    switch (this.data.cruStatu) {
      case 3:
      case 10:
        if (this.data.rnum == this.data.minP) {
          this.setStatu(2, 3)
        } else {
          this.setStatu(9, 3)
        }
        break
      case 6:
      case 9:
        if (this.data.num < this.data.rnum - 1) {
          this.setStatu(9, 9)
        } else {
          if (this.data.rnum <= this.data.maxP) {
            this.setStatu(2, 9)
          } else {
            this.setStatu(7, 9)
          }
        }
        break

      default:
        break;
    }
    if (this.data.num <= this.data.maxP) {
      this.setData({
        num: this.data.num + 1
      })
    }
    var src = 'https://www.ranh941.com/audio/chord/midi'
    var currentChordDetail = this.data.proRecord[this.data.num][2]
    var allChoyrdType = app.globalData.chordType
    var tmp = []
    for (var x in currentChordDetail) {
      tmp.push({
        id: currentChordDetail[x],
        name: allChoyrdType[currentChordDetail[x]]
      });
    }
    this.setData({
      currentChordDetail: tmp
    })
    innerAudioContext.stop() //防止多次播放的影响
    innerAudioContext.src = this.data.tmpProblemsSrc[this.data.num - 1]
    innerAudioContext.play()

  },
  //答题
  checkAnswer: function (e) {
    switch (this.data.cruStatu) {
      case 1:
        this.setStatu(4, 1)
        break
      case 2:
        this.setStatu(5, 2)
        break
      case 3:
        this.setStatu(10, 3)
        break
      case 7:
        this.setStatu(8, 7)
        break
      case 9:
        this.setStatu(6, 9)
        break
      default:
        break;
    }
    var rightAnswer = this.data.proRecord[this.data.num][0]
    var current = this.data.currentChordDetail
    var cId = e.currentTarget.dataset.id

    this.setData({
      ans: rightAnswer,
      choose: cId

    });

  },
  //设置每个按钮的使用状态
  setStatu: function (currStatuPos, oldStatuPos) {

    var currStatu = this.data.btStatus[currStatuPos]
    this.setData({
      disabledLast: currStatu[0],
      disabledNext: currStatu[1],
      disabledNew: currStatu[2],
      disabledRe: currStatu[3],
      flag: currStatu[4],
      oldStatu: oldStatuPos,
      cruStatu: currStatuPos,
      ans: -1,
      choose: -2
    })
  },
  downloadFile: function (tmpPath) {
    var that = this

    downloadTask = wx.downloadFile({
      url: tmpPath, //
      success(res) {
        if (res.statusCode === 200) {
          var tmp = that.data.tmpProblemsSrc;
          tmp[tmp.length] = res.tempFilePath
          that.setData({
            tmpProblemsSrc: tmp
          })
        }
      },
      fail: function (err) {
      }
    })
  },
  //预下载
  preDownloadFile: function (srcArr) {
    var src = 'https://www.ranh941.com/audio/chord/midi'
    var typeFile = '.mp3'
    for (var x in srcArr) {
      this.downloadFile(src + srcArr[x].data.chord + typeFile)
      console.log(src + srcArr[x].data.chord + typeFile)
    }
    wx.hideLoading()  //showLoading 只能用此语句关闭 mine
    this.setData({ disabledNew: false })//mine
  },
  //获取题目列表
  getProblems: function (chordType) {
    var that = this
    console.log(chordType)
    //获取题列表
    wx.request({
      header: {
        'content-type': 'application/json',
      },
      url: 'https://www.ranh941.com/lib/GetChord.php?type=' + chordType + '&pNum=' + that.data.maxP, //生成小七和弦（小小七和弦）与大七和弦（大大七和弦）中的一组
      method: 'GET',
      success: function (res) {
        that.preDownloadFile(res.data)
        that.setData({
          preDownPros: res.data
        })
      },
      fail: function () {

      }
    })
  },
  //下一组
  nextGroup: function (e) {
    this.setData({
      num: 0, //当前题所在位置
      rnum: 0, //当前出题数
    })
    this.data.tmpProblemsSrc = [] //清空播放文件临时列表
    this.onLoad()
  },
  //事件处理函数
  onLoad: function (options) {
    wx.showLoading({ title: '加载中', })//mine
    if (count == 0)//mine
      currentType = options.type
    // var currentType = options.type
    var iniStatu = 0
    var oldStatu = 0
    this.setStatu(iniStatu, oldStatu);
    this.getProblems(currentType);
    var currentChordDetail = app.globalData.problemDetail[currentType];
    var allChoyrdType = app.globalData.chordType
    var tmp = []
    for (var x in currentChordDetail) {
      tmp.push({
        id: currentChordDetail[x],
        name: allChoyrdType[currentChordDetail[x]]
      });
    }
    //设置初始题目、选项
    this.setData({
      NextGroup: true,
      currentChordDetail: tmp,
      chordType: currentType,
      title: app.globalData.problemTitles[currentType]
    })
    let that = this
    innerAudioContext.onError((res) => { })
    innerAudioContext.onWaiting(() => { })
    innerAudioContext.onPlay(() => {
    })
    count++
  },
  //mine
  onUnload: function () {
    this.data.tmpProblemsSrc = [] //清空播放文件临时列表
    count = 0
  }
})