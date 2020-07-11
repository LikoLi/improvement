<template>
  <div id="app">
    <div id="bd-left">
      <el-form :inline="true" id="url-form">
        <el-form-item>
          <el-input id="url-input" v-model="inputUrl" placeholder="请输入网址"></el-input>
        </el-form-item>
        <el-form-item>
          <el-button id="url-button" type="primary" @click="changeIframeUrl">访问</el-button>
        </el-form-item>
      </el-form>
      <iframe id="show-iframe"  frameborder=0 :src="iframeUrl" width="100%" :style="{ height: iframeHeight + 'px'}" :key="iframeUrl"></iframe>
    </div>
    <div id="bd-right">

    </div>
  </div>
</template>

<script>
// import HelloWorld from './components/HelloWorld.vue'

export default {
  name: 'app',
  components: {
    // HelloWorld
  },
  data () {
    return {
      inputUrl: 'https://',
      iframeUrl: 'https://www.baidu.com',
      screenHeight: document.body.clientHeight,
      iframeHeight: document.documentElement.clientHeight - 85
    }
  },
  methods: {
    changeIframeUrl () {
      console.log(this.inputUrl)
      this.iframeUrl = this.inputUrl
    }
  },
  mounted () {
    const that = this
    window.onresize = () => {
      return (() => {
        that.screenHeight = document.documentElement.clientHeight
        that.iframeHeight = document.documentElement.clientHeight - 85
      })()
    }
  },
  watch: {
    screenHeight (val) {
      this.screenHeight = val
      this.iframeHeight = val - 85
    }
  }
}
</script>

<style>
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}

#bd-left {
  float: left;
  width: 50%;
}

#bd-right {
  float: right;
  width: 50%;
  height: 100px;
  background-color: aqua;
}

#url-form {
  float: right;
}

#url-input {
  width: 400px;
}
</style>
