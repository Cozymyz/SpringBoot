import Vue from 'vue'
function capitalizeFirstLetter(string) {
    return string.charAt(0).toUpperCase() + string.slice(1)
}
const requireComponent = require.context(
    '.', true, /\.vue$/
)

requireComponent.keys().forEach(fileName => {
    const componentConfig = requireComponent(fileName)
    const componentName = capitalizeFirstLetter(
        fileName.replace(/^\.\//, '').replace(/\.\w+$/, '')
        // 因为得到的filename格式是：'./componentX.vue',所以去掉头和尾保留真正的文件名
    )
    Vue.component(componentName, componentConfig.default || componentConfig)
})
