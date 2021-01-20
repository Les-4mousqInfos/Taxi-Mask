

module.exports = {
  devServer: {
    port: 8081
  },
  publicPath: '/',
  transpileDependencies: [
    'vue-echarts',
    'resize-detector'
  ],
  configureWebpack: {
    optimization: {
      splitChunks: {
        chunks: 'all'
      }
    }
  },
  css: {
    loaderOptions: {
      sass: {

      }
    }
  }
}

