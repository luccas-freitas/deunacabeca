<template>
  <div id="app" class="container-fluid">
    <nav>
      <router-link class="btn btn-primary" to="/">Sorteios</router-link>
      <router-link class="btn btn-primary" to="/add">Inserir</router-link>
      <router-link class="btn btn-primary" to="/search">Buscar</router-link>
    </nav>
    <router-view/>
  </div>
</template>

<script>
export default {
  name: "app"
}
</script>

<style lang="scss">
  @import 'node_modules/bootstrap/scss/bootstrap';
  @import 'node_modules/bootstrap-vue/src/index.scss';
</style>