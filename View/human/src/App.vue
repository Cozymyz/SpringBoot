<template>
  <div id="app">
    <router-view />
  </div>
</template>

<script>

export default {
  name: 'App'
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  font-size: 1rem;
  /* height: 100%; */
  box-sizing: border-box;
}
*,::before,::after{
  box-sizing: inherit;
  margin: 0;
}
ul,ol{
  list-style-type: none;
  margin: 0;
  padding: 0;
}
@media (min-width:800px){
  #app{
    font-size: 1.125em;
  }
}
@media(min-width:1200px){
  #app{
    font-size: 1.25em;
  }
}

</style>
