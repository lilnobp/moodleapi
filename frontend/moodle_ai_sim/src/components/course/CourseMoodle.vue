<template>
  <b-container>
    <b-row class="justify-content-lg-start mt-3">
      <h3>
        My Courses :
      </h3>
      <b-button v-b-toggle.sidebar-1 class="mx-3">
        <b-icon icon="plus-circle-fill"></b-icon>
      </b-button>
      <b-sidebar id="sidebar-1" title="Add New Course " shadow>
        <div class="px-3 py-2">
          <b-img src="https://picsum.photos/500/300/?image=54" fluid thumbnail></b-img>
          <AddCourse></AddCourse>
        </div>
      </b-sidebar>
    </b-row>
    <b-row>
      <div class="my-3 mx-lg-4" v-for="course in this.courses" :key="course.id" >

        <b-skeleton-wrapper :loading="loading">
          <template #loading>
            <b-card>
              <b-skeleton width="85%"></b-skeleton>
              <b-skeleton width="55%"></b-skeleton>
              <b-skeleton width="70%"></b-skeleton>
            </b-card>
          </template>

        <b-card
            :title=course?.shortName
            img-src="https://picsum.photos/600/300/?image=25"
            img-alt="Image"
            img-top
            tag="article"
            style="max-width: 20rem;"
            class="mb-2"
        >
          <b-card-text>
            {{course?.fullName}}
          </b-card-text>
          <b-button v-b-modal="'modal-'+ course.id " variant="secondary">
            run evaluation
          </b-button>
          <b-modal  centered :id='"modal-" + course.id' :title="'Selected Course: '+ course?.fullName">
            <EvaluationForm></EvaluationForm>
          </b-modal>
        </b-card>
        </b-skeleton-wrapper>
      </div>
    </b-row>
  </b-container>
</template>
<script>
import axios from "axios";
import EvaluationForm from "@/components/course/EvaluationSetting.vue";
import AddCourse from "@/components/course/AddCourse.vue";
import backendPoint from "@/moodleconfig";
export default {
  name: 'CourseMoodle',
  components: {AddCourse, EvaluationForm},
  props: {},
  methods:{
    async getCourses(){
        const courseReq = await axios.get(backendPoint().concat("/course/all"))
        this.courses = courseReq?.data
        this.loading = false
        console.log(this.courses)
    },
  },

  data() {
    return { courses: [], loading: true }
  },
  mounted() {
    this.getCourses()
  }
}
</script>
<style scoped>
</style>