<template>
  <div class="hello">

    <HeaderPage></HeaderPage>
    <CourseMoodle></CourseMoodle>
    <FooterPage></FooterPage>
  </div>
</template>

<script>
import HeaderPage from "@/components/header/HeaderPage.vue";
import FooterPage from "@/components/header/FooterPage.vue";
import CourseMoodle from "@/components/course/CourseMoodle.vue";

export default {
  name: 'HelloWorld',
  components: {CourseMoodle, FooterPage, HeaderPage},
  props: {
    msg: String
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h3 {
  margin: 40px 0 0;
}
ul {
  list-style-type: none;
  padding: 0;
}
li {
  display: inline-block;
  margin: 0 10px;
}
a {
  color: #42b983;
}
</style>
