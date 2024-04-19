<script setup>
</script>

<template>
  <div>
    <b-navbar sticky:=true toggleable="lg" type="dark" variant="dark">
      <b-navbar-brand href="/">
        <template>
          <b-avatar variant="sucess">
            <img src="../../assets/moodle.png" height="40" width="40"/>
          </b-avatar>
          <b-nav-text class="ml-2"> Moodle AI </b-nav-text>
        </template>
      </b-navbar-brand>
      <b-navbar-toggle target="nav-collapse"></b-navbar-toggle>
      <b-collapse id="nav-collapse" is-nav>
        <b-navbar-nav>
          <b-nav-item href="/">
            <template>
              <b-avatar variant="success" icon="book-fill"> </b-avatar>
              <b-nav-text class="ml-2"> Course </b-nav-text>
            </template>
          </b-nav-item>
          <b-nav-item href="/question">
            <template>
              <b-avatar variant="success" icon="question-circle-fill"></b-avatar>
              <b-nav-text class="ml-2"> Simulation </b-nav-text>
            </template>
          </b-nav-item>
          <b-nav-item>
            <template>
              <b-avatar variant="success" icon="bar-chart-fill"></b-avatar>
              <b-nav-text class="ml-2"> Statistic </b-nav-text>
            </template>
          </b-nav-item>
        </b-navbar-nav>

        <!-- Right aligned nav items -->
        <b-navbar-nav class="ml-auto">
          <b-nav-form>
            <b-form-input size="sm" class="mr-sm-2" placeholder="Search"></b-form-input>
            <b-button size="sm" class="my-2 my-sm-0" type="submit">Search</b-button>
          </b-nav-form>

          <b-nav-item-dropdown right>
            <!-- Using 'button-content' slot -->
            <template #button-content>
              <b-avatar></b-avatar>
            </template>
            <b-dropdown-item href="#">Profile</b-dropdown-item>
            <b-dropdown-item href="#">Sign Out</b-dropdown-item>
          </b-nav-item-dropdown>
        </b-navbar-nav>
      </b-collapse>
    </b-navbar>
  </div>

</template>

<style scoped>
</style>