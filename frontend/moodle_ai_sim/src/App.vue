
<template>
  <div id="app">
    <HeaderPage></HeaderPage>
     <router-view></router-view>
    <FooterPage></FooterPage>
  </div>
</template>

<script>
import "./App.css"
import HeaderPage from "@/components/header/HeaderPage.vue";
import FooterPage from "@/components/header/FooterPage.vue";
export default {
  name: 'App',
  components: {
    FooterPage,
    HeaderPage
  }
}
</script>

<style>
</style>
