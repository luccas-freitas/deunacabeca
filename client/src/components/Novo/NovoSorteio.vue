<template>
  <form @submit.prevent="saveSorteio">
    <div class="submitform">
      <div v-if="!submitted"><br>
        <div class="form-group">
          <label>Loteria:</label>
          <select class="form-control" v-model="sorteio.loteria" required>
            <option disabled selected style="display: none;">Selecione uma Loteria</option>
            <option value="0">PT-RIO</option>
            <option value="1">PR</option>
            <option value="2">FEDERAL</option>
            <option value="3">MEGA SENA</option>
            <option value="4">QUINA BR</option>
          </select>
        </div>

        <div class="form-group">
          <label>Horario:</label>
          <select class="form-control" v-model="sorteio.horario" required>
            <option disabled selected style="display: none;">Selecione uma Horario</option>
            <option value="0">11:20</option>
            <option value="1">14:20</option>
            <option value="2">16:20</option>
            <option value="3">18:20</option>
            <option value="4">19:00</option>
            <option value="5">21:20</option>
          </select>
        </div>

        <div class="form-group">
          <label>Data:</label><br>
          <date-picker 
            v-model="sorteio.data" 
            :lang="lang"
            :input-attr="{ required: true }">
          </date-picker>
        </div>

        <div class="form-group">
          <label>Resultados:</label>
          <div v-for="(item, index) 
            in sorteio.resultados" :key="index">
            <table> <tr> <td>

              <input type="text" class="form-control" 
                  minlength="4" maxlength="4" 
                  autocomplete="off"
                  pattern="^[0-9]*$" required 
                  v-model="sorteio.resultados[index].valor"
                  :id="'resultado-' + index"
                  @change="getAnimal(index)">
              
            </td><td>
                  <span :id="'span-' + index"> {{ sorteio.resultados[index].animal }} </span>
            </td></tr></table>
          </div>
            <br>
        </div>

        <div class="form-group">
          <label>Soma:</label>
          <input type="number" class="form-control" required v-model="sorteio.soma">
        </div>

        <input class="btn btn-success" type="submit" value="Inserir">
      </div>

      <div v-else>
        <h4>Inserido com sucesso!</h4>
        <button class="btn btn-success" v-on:click="novoSorteio">Novo</button>
      </div>
    </div>
  </form>
</template>

<script>
import http from '../../http-common';
import DatePicker from 'vue2-datepicker';

export default {
  name: "novo",
  components: { DatePicker },
  data() {
    return {
      sorteio: {
        id: 0,
        resultados: [
          {
            valor: "",
            animal: "",
          },
          {
            valor: "",
            animal: "",
          }
        ],
        soma: "",
        loteria: "",
        horario: "",
        data: ""
      },
      submitted: false,
      lang: "pt-br",
    };
  },
  methods: {
    /* eslint-disable no-console */
    saveSorteio() {
      var data = {
        loteria: this.sorteio.loteria,
        horario: this.sorteio.horario,
        data: this.sorteio.data,
        resultados: [
          {
            valor: this.sorteio.resultados[0].valor,
            animal: this.sorteio.resultados[0].animal
          },
          {
            valor: this.sorteio.resultados[1].valor,
            animal: this.sorteio.resultados[1].animal
          }
        ],
        soma: this.sorteio.soma
      };
      http
        .post("/sorteios", data)
        .then(response => {
          this.sorteio.id = response.data.id;
          console.log(response.data);
        })
        .catch(e => {
          console.log(e);
        });

      this.submitted = true;
    },
    novoSorteio() {
      this.submitted = false;
      this.sorteio.resultados = {};
      this.sorteio = {};
    },
    getAnimal(id) {
        var res = document.getElementById('resultado-' + id).value;
        if(res % 100 >= 1 && res % 100 <= 4)
            this.sorteio.resultados[id].animal = "Avestruz";
        if(res % 100 >= 5 && res % 100 <= 8)
            this.sorteio.resultados[id].animal = "Aguia";
        if(res % 100 >= 9 && res % 100 <= 12)
            this.sorteio.resultados[id].animal = "Burro";
        if(res % 100 >= 13 && res % 100 <= 16)
            this.sorteio.resultados[id].animal = "Borboleta";
        if(res % 100 >= 17 && res % 100 <= 20)
            this.sorteio.resultados[id].animal = "Cachorro";
        if(res % 100 >= 21 && res % 100 <= 24)
            this.sorteio.resultados[id].animal = "Cabra";
        if(res % 100 >= 25 && res % 100 <= 28)
            this.sorteio.resultados[id].animal = "Carneiro";
        if(res % 100 >= 29 && res % 100 <= 32)
            this.sorteio.resultados[id].animal = "Camelo";
        if(res % 100 >= 33 && res % 100 <= 36)
            this.sorteio.resultados[id].animal = "Cobra";
        if(res % 100 >= 37 && res % 100 <= 40)
            this.sorteio.resultados[id].animal = "Coelho";
        if(res % 100 >= 41 && res % 100 <= 44)
            this.sorteio.resultados[id].animal = "Cavalo";
        if(res % 100 >= 45 && res % 100 <= 48)
            this.sorteio.resultados[id].animal = "Elefante";
        if(res % 100 >= 49 && res % 100 <= 52)
            this.sorteio.resultados[id].animal = "Galo";
        if(res % 100 >= 53 && res % 100 <= 56)
            this.sorteio.resultados[id].animal = "Gato";
        if(res % 100 >= 57 && res % 100 <= 60)
            this.sorteio.resultados[id].animal = "Jacare";
        if(res % 100 >= 61 && res % 100 <= 64)
            this.sorteio.resultados[id].animal = "Leao";
        if(res % 100 >= 65 && res % 100 <= 68)
            this.sorteio.resultados[id].animal = "Macaco";
        if(res % 100 >= 69 && res % 100 <= 72)
            this.sorteio.resultados[id].animal = "Porco";
        if(res % 100 >= 73 && res % 100 <= 76)
            this.sorteio.resultados[id].animal = "Pavao";
        if(res % 100 >= 77 && res % 100 <= 80)
            this.sorteio.resultados[id].animal = "Peru";
        if(res % 100 >= 81 && res % 100 <= 84)
            this.sorteio.resultados[id].animal = "Touro";
        if(res % 100 >= 85 && res % 100 <= 88)
            this.sorteio.resultados[id].animal = "Tigre";
        if(res % 100 >= 89 && res % 100 <= 92)
            this.sorteio.resultados[id].animal = "Urso";
        if(res % 100 >= 93 && res % 100 <= 96)
            this.sorteio.resultados[id].animal = "Veado";
        if(res % 100 >= 97 || res % 100 == 0)
            this.sorteio.resultados[id].animal = "Vaca";
    }
    /* eslint-enable no-console */
  }
};
</script>

<style>
.submitform {
  max-width: 300px;
  margin: auto;
}
</style>
