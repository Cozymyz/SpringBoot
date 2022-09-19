const path = require('path')

function resolve(dir) {
  return path.join(__dirname, dir)
}
module.exports = {
  publicPath: '/',
  outputDir: 'dist',
  assetsDir: 'static',
  productionSourceMap: true,
  
  devServer:{
      port:8082,
      proxy: {
        '/api': {
          target: 'http://chengbei.site:8090/',
          // target:'http://223.104.244.191:8090/',
            changeOrigin: true,
              pathRewrite: {
            '^/api': ''
          }
        }
  }
},
  chainWebpack: config => {
    config.resolve.symlinks(true)
    config.resolve.alias
      .set('@', resolve('src'))
      .set('@assets', resolve('src/assets'))
      .set('@components', resolve('src/components'))
      .set('@views', resolve('src/views'))
  }
}
