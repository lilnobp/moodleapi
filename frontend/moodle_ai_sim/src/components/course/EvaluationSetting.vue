<script>
export default {
  name: "EvaluationForm",
  data() {
    return {
      form: {
        numberOfPoint: null,
        durations: null,
        difficulties: ""
      },
      show: true,
      options: [
        { value: null, text: "Enter the Levels of Difficulties of the Exams" },
        { value: "a", text: "L 1" },
        { value: "b", text: "SL" },
        { value: "d", text: 'XXL', disabled: true }
      ]
    }
  },
  methods: {
    onSubmit(event) {
      event.preventDefault()
      alert(JSON.stringify(this.form))
      this.$router.push("/question")
    },
    onReset(event) {
      event.preventDefault()
      // Reset our form values
      this.form.numberOfPoint = 1
      this.form.durations = 0
      this.form.difficulties =""
      // Trick to reset/clear native browser form validation state
      this.show = false
      this.$nextTick(() => {
        this.show = true
      })
    }
  }
}
</script>

<template>
    <b-form @submit="onSubmit" @reset="onReset" v-if="show">
      <b-form-group
          id="input-group-1"
          label="Maximum Number of Points of Evaluation:"
          label-for="input-1"
          description="This will be temporally save in the browser Cash"
      >
        <b-form-input
            id="input-1"
            v-model="form.numberOfPoint"
            type="number"
            placeholder="Enter 0 to infinity"
            min="1"
            required
        ></b-form-input>
      </b-form-group>
      <b-form-group
          id="input-group-2"
          label="Evaluation Durations in millisecond"
          label-for="input-2"
          description="This will be temporally save in the browser Cash"
      >
        <b-form-input
            id="input-2"
            v-model="form.durations"
            type="number"
            min="1"
            placeholder="Enter the durations in millisecond"
            required
        ></b-form-input>
      </b-form-group>

      <b-form-group
          id="input-group-3"
          label="Evaluation Difficulties "
          label-for="input-3"
          description="This will be temporally save in the browser Cash"
      >
        <b-form-select id="input-3" v-model:="form.difficulties" :options="options" size="sm" class="mt-3"></b-form-select>
      </b-form-group>
    </b-form>
</template>

<style scoped>

</style>