<template>
  <div class="searchform">
    <h4>Buscar por data</h4>
    <div class="form-group">
      <date-picker
        id="datePicker" 
        v-model="currentDate" 
        :lang="lang" 
        :format="format"
        :input-attr="{ required: true }">
      </date-picker>
    </div>
    <div class="btn-group">
      <button v-on:click="busca" class="btn btn-success">Pesquisar</button>
    </div>

    <div v-if="this.find && this.size > 0">
    <ul class="search-result">
      <li v-for="(sorteio, index) in sorteios" :key="index">
        <h6>{{ sorteio.loteria }}</h6>
        <h6>{{ sorteio.horario }}</h6>
        <h6>
          <ul>
            <li v-for="(resultado, i) in sorteio.resultados" 
                v-bind:key="`${i}-${resultado}`">
              {{ resultado.valor }}
             - 
            {{ resultado.animal }}
            </li>
          </ul>
        </h6>
        <h6>{{ sorteio.soma }}</h6>
      </li>
    </ul>
    </div>
    
    <div v-else-if="this.size == 0">
      <p>{{ message }}</p>
    </div>
    <div v-else>
      <p>{{ message }}</p>
    </div>
    
  </div>
</template>

<script>
import http from "../http-common";
import DatePicker from "vue2-datepicker";
import moment from "moment";

export default {
  name: "busca",
  components: { DatePicker },
  data() {
    return {
        format: 'DD/MM/YYYY',
        currentDate: '',
        lang: 'pt-br',
        sorteios: [],
        find : true,
        size: 0,
        message: ''
    };
  },
  methods: {
    /* eslint-disable no-console */
    busca() {
      var dataParsed = moment(this.currentDate).format('YYYY-MM-DD');   
      http
        .get("/sorteios/data/" + dataParsed)
        .then(response => {
          this.sorteios = response.data;
          this.size = response.data.length;
          this.message = 'Não há resultados lançados para esta data.';
          this.find = true;
        },
        () => {
          this.message = 'Insira uma data válida.';
          this.find = false;
        })
        ;
    }
    /* eslint-enable no-console */
  }
};
</script>

<style>
.searchform {
  max-width: 300px;
  margin: auto;
}
.search-result {
  margin-top: 20px;
  text-align: left;
}
</style>
