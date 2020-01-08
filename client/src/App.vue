<template>
    <div id="app" class="container-fluid">
        <b-container>
            <b-row>
                <header class="b-table-sticky-header">
                    <b-navbar toggleable="lg" type="dark" variant="dark" fixed="top">
                        <b-navbar-brand href="#">Deu na Cabeça!</b-navbar-brand>
                        <b-navbar-toggle target="nav-collapse"/>

                        <b-collapse id="nav-collapse" is-nav>

                            <b-navbar-nav>
                                <b-nav-item active>
                                    <router-link to="/">Sorteios</router-link>
                                </b-nav-item>
                                <b-nav-item>
                                    <router-link to="/add">Inserir</router-link>
                                </b-nav-item>
                                <b-nav-item>
                                    <router-link to="/search">Buscar</router-link>
                                </b-nav-item>
                            </b-navbar-nav>
                        </b-collapse>
                    </b-navbar>
                </header>
            </b-row>
            <b-row>
                <router-view/>
            </b-row>
        </b-container>
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