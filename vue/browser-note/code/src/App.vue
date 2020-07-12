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
      <div class="bd-right-switch">
        <el-switch v-model="priview" active-color="#13ce66" inactive-color="#ccc" class="bd-switch" active-text="预览"></el-switch>
      </div>
      <div v-show="!priview" :style="{ height: screenHeight / 2 + 'px'}">
        <el-input type="textarea" :rows="30" v-model="content"></el-input>
      </div>
      <div v-show="priview" id="bd-markdown-show" :style="{ height: screenHeight / 2 + 'px'}">
        <markdown-it-vue class="md-body" :content="content" :options="options" />
      </div>
    </div>
  </div>
</template>

<script>
// import HelloWorld from './components/HelloWorld.vue'
import MarkdownItVue from 'markdown-it-vue'
import 'markdown-it-vue/dist/markdown-it-vue.css'

export default {
  name: 'app',
  components: {
    // HelloWorld
    MarkdownItVue
  },
  data () {
    return {
      inputUrl: 'https://lingcoder.github.io/OnJava8/#/',
      iframeUrl: 'https://lingcoder.github.io/OnJava8/#/',
      screenHeight: document.documentElement.clientHeight,
      iframeHeight: document.documentElement.clientHeight - 85,
      content: '# your markdown content',
      options: {
        markdownIt: {
          linkify: true
        },
        linkAttributes: {
          attrs: {
            target: '_self',
            rel: 'noopener'
          }
        }
      },
      priview: false
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
}

#url-form {
  float: right;
}

#url-input {
  width: 400px;
}

.md-body {
  text-align: left;
  margin-left: 20px;
}

.bd-right-switch {
  height: 62px;
}

.bd-switch {
  float: right;
  margin: 10px 10px 10px 0;
}
</style>
