<template>
  <div class="hello">

    <HeaderPage></HeaderPage>
    <QuestionLayout></QuestionLayout>
    <FooterPage></FooterPage>
  </div>
</template>

<script>
import HeaderPage from "@/components/HeaderPage.vue";
import FooterPage from "@/components/FooterPage.vue";
import QuestionLayout from "@/components/question/QuestionLayout.vue";

export default {
  name: 'HelloWorld',
  components: {QuestionLayout, FooterPage, HeaderPage},
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
