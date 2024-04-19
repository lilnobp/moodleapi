import Vue from "vue"
import App from "./App.vue"
import BootstrapVue, {BootstrapVueIcons, IconsPlugin} from "bootstrap-vue";
Vue.config.productionTip = false
Vue.use(BootstrapVue)
Vue.use(IconsPlugin)
Vue.use(BootstrapVueIcons)
// Import Bootstrap and BootstrapVue CSS files (order is important)
import "bootstrap/dist/css/bootstrap.css"
import "bootstrap-vue/dist/bootstrap-vue.css"
import VueRouter from "vue-router"
import CourseMoodle from "@/components/course/CourseMoodle.vue";
import QuestionLayout from "@/components/question/QuestionLayout.vue";

const router = new VueRouter({
  mode: "history",
  routes: [

    {
      path: "/",
      name: "Course",
      component: CourseMoodle
    },
    {
      path: "/question",
      name: "Question",
      component: QuestionLayout
    }
  ]
});
Vue.use(VueRouter)

new Vue({
  el: "#app",
  router,
  components: { App },
  template: "<App/>"
}).$mount("#app")
