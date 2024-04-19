<template>
  <b-container class="my-3">
    <b-list-group horizontal >
      <b-list-group-item id="points" class="d-flex justify-content-between align-items-center mt-1">
        Total Question:
        <b-badge class="ml-3" variant="primary" pill>{{this.questions.length}}</b-badge>
      </b-list-group-item>
      <b-list-group-item id="points" class="d-flex justify-content-between align-items-center mt-1">
        Total Points:
        <b-badge class="ml-3" variant="primary" pill>{{totalPoint}}</b-badge>
      </b-list-group-item>
      <b-list-group-item id="points" class="d-flex justify-content-between align-items-center mt-1">
        Total Duration:
        <b-badge class="ml-3" variant="primary" pill>{{totalDuration}}</b-badge>
      </b-list-group-item>
    </b-list-group>
    <div class="mt-2" v-for="question in questions" :key="question?.id">
      <b-card>
        <b-row>
          <b-col cols="9">
            <b-form-group
                :label="question?.name"
                v-slot="{ ariaDescribedby }"
            >
              <b-card-text v-html="question?.questionText">
              </b-card-text>
              <b-form-checkbox-group
                  v-model="selected"
                  :options="question?.answers"
                  :aria-describedby="ariaDescribedby"
                  name="flavour-2a"
                  stacked
              ></b-form-checkbox-group>
            </b-form-group>
          </b-col>
          <b-col>
              <b-list-group  v-for="props in question?.properties" :key="props?.id">
                <b-list-group-item class="d-flex justify-content-between align-items-center mt-1">
                   {{props?.propertyName}}
                  <b-badge class="ml-3" variant="primary" pill>{{props?.value}}</b-badge>
                </b-list-group-item>
              </b-list-group>
          </b-col>
        </b-row>
      </b-card>
    </div>
  </b-container>
</template>
<script>
import axios from "axios";
import backendPoint from "@/moodleconfig";
export default {
  name: 'QuestionLayout',
  components: {},
  props: {},
  methods:{
    async getQuestions(){
      const questionsReq = await axios.get(backendPoint().concat("/question/questionCustomFields"))
      this.questions = questionsReq?.data
      this.loading = false
      for ( const question of questionsReq?.data){
        for (const props of question?.properties){
          if(props?.propertyName?.includes("Duration"))
            this.totalDuration += Number(props?.value)
          if(props?.propertyName?.includes("Point"))
            this.totalPoint += Number(props?.value)
        }
      }
      console.log(this.questions)
    },
  },
  data() {
    return { questions: [], loading: true,  selected: [], totalPoint: 0, totalDuration: 0}
  },
  mounted() {
    this.getQuestions()
  }
}
</script>
<style scoped>
</style>