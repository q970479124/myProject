<template>
  <div class="box">
    <h1>webStock Demo</h1>
    <div class="red">{{ one }}</div>
  </div>
</template>
<script>
export default {
  data () {
    return {
      one: '0',
      ws: null, // 建立的连接
      lockReconnect: false, // 是否真正建立连接
      timeout: 28 * 100, // 30秒一次心跳
      timeoutObj: null, // 心跳心跳倒计时
      serverTimeoutObj: null, // 心跳倒计时
      timeoutnum: null, // 断开 重连倒计时
      url: 'ws://localhost:8081/webSocket/enter/success'
    }
  },
  created () {
    this.initWebpack()
  },
  methods: {
    initWebpack () {
      this.ws = new WebSocket(this.url)
      this.ws.onopen = this.onopen
      this.ws.onmessage = this.onmessage
      this.ws.onclose = this.onclose
      this.ws.onerror = this.onerror
    },
    reconnect () { // 重新连接
      var that = this
      if (that.lockReconnect) {
        return
      };
      that.lockReconnect = true
      // 没连接上会一直重连，设置延迟避免请求过多
      that.timeoutnum && clearTimeout(that.timeoutnum)
      that.timeoutnum = setTimeout(function () {
        // 新连接
        that.initWebpack()
        that.lockReconnect = false
      }, 500)
    },
    reset () { // 重置心跳
      var that = this
      // 清除时间
      clearTimeout(that.timeoutObj)
      clearTimeout(that.serverTimeoutObj)
      // 重启心跳
      that.start()
    },
    start () { // 开启心跳
      var self = this
      self.timeoutObj && clearTimeout(self.timeoutObj)
      self.serverTimeoutObj && clearTimeout(self.serverTimeoutObj)
      self.timeoutObj = setTimeout(function () {
        // 这里发送一个心跳，后端收到后，返回一个心跳消息，
        if (self.ws.readyState === 1) { // 如果连接正常
          self.ws.send(Math.random(10))
        } else { // 否则重连
          self.reconnect()
        }
        self.serverTimeoutObj = setTimeout(function () {
          // 超时关闭
          self.ws.close()
        }, self.timeout)
      }, self.timeout)
    },
    onopen () {
      this.ws.send(Math.random(10))
      console.log('open')
      // 开启心跳
      this.start()
    },
    onmessage (e) {
      this.one = e.data
      console.log(e.data)
      // 收到服务器信息，心跳重置
      this.reset()
    },
    onclose (e) {
      console.log('连接关闭')
      console.log('websocket 断开: ' + e.code + ' ' + e.reason + ' ' + e.wasClean)
      this.ws.send(Math.random(10))
      // 重连
      this.reconnect()
    },
    onerror (e) {
      console.log('出现错误')
      // 重连
      this.reconnect()
    }
  }
}
</script>
<style scoped>
.box {
  width: 100%;
  height: 100%;
  display: flex;
  justify-content: center;
  align-items: center;
  flex-direction: column;
}
.box > div {
    margin-top: 20px;
}
.red {
    color: red;
}
</style>
