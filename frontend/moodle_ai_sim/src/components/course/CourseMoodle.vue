<template>
  <b-container>

    <b-row style="justify-content: start; margin-top: 10px">
      <h3>
        My Courses :
      </h3>

      <b-button class="mx-3">
        <b-icon icon="plus-circle-fill"></b-icon>
      </b-button>
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
export default {
  name: 'CourseMoodle',
  components: {EvaluationForm},
  props: {},
  methods:{
    async getCourses(){
        const courseReq = await axios.get("http://localhost:8084/course/all")
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