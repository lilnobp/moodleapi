<script>
export default {
  name: "AddCourse",
  data() {
    return {
      form: {
        shortName: null,
        name: null,
        summary: null
      },
      show: true
    }
  },
  methods: {
    onSubmit(event) {
      event.preventDefault()
      alert(JSON.stringify(this.form))
    },
    onReset(event) {
      event.preventDefault()
      // Reset our form values
      this.form.shortName = null
      this.form.name = null
      this.form.summary = null
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
        label="Name of the Course :"
        label-for="input-1"
        description="This will be temporally save in the browser Cash"
    >
      <b-form-input
          id="input-1"
          v-model="form.name"
          type="text"
          placeholder="For Example Chemistry"
          required
      ></b-form-input>
    </b-form-group>
    <b-form-group
        id="input-group-2"
        label="Short name of the course"
        label-for="input-2"
        description="This will be temporally save in the browser Cash"
    >
      <b-form-input
          id="input-2"
          v-model="form.shortName"
          type="text"
          placeholder="CHEM for chemistry"
          required
      ></b-form-input>
    </b-form-group>

    <b-form-group
        id="input-group-3"
        label="Course Summary  "
        label-for="input-3"
        description="This will be temporally save in the browser Cash"
    >
      <b-form-textarea
          id="input-3"
          v-model="form.summary"
          placeholder="Enter something..."
          rows="3"
          max-rows="6"
      ></b-form-textarea>
    </b-form-group>

    <b-button class="mt-3 mx-auto">
      <b-icon icon="plus-circle-fill"></b-icon>
      Add
    </b-button>
  </b-form>
</template>

<style>

</style>