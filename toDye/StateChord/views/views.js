Page({
  data: {
    // text:"这是一个页面"
    open: false,
    openZw:false
  },
  bdshowitem: function () {
    this.setData({
      open: !this.data.open,
      openZw: false
    })
  },
  zwshowitem: function () {
    this.setData({
      open: false,
      openZw: !this.data.openZw
    })
  },
  onLoad: function (options) {
    // 页面初始化 options为页面跳转所带来的参数
  },
  onReady: function () {
    // 页面渲染完成
  },
  onShow: function () {
    // 页面显示
  },
  onHide: function () {
    // 页面隐藏
  },
  onUnload: function () {
    // 页面关闭
  }
})