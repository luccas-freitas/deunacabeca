<template>
  <table>
    <tr>
      <td>
        <input
          type="text"
          class="form-control"
          minlength="4"
          maxlength="4"
          autocomplete="off"
          pattern="^[0-9]*$"
          required
          v-model="sorteio.resultados[id].valor"
          :id="'resultado-' + id"
          @change="getAnimal(id)"
        >
      </td>
      <td>
        <span :id="'span-' + id">{{ sorteio.resultados[id].animal }}</span>
      </td>
    </tr>
  </table>
</template>

<script>
export default {
  name: "Bicho",
  props: ["sorteio", "id"],
  methods: {
    getAnimal(id) {
      var res = this.sorteio.resultados[id].valor;
      if (res % 100 >= 1 && res % 100 <= 4)
        this.sorteio.resultados[id].animal = "Avestruz";
      if (res % 100 >= 5 && res % 100 <= 8)
        this.sorteio.resultados[id].animal = "Aguia";
      if (res % 100 >= 9 && res % 100 <= 12)
        this.sorteio.resultados[id].animal = "Burro";
      if (res % 100 >= 13 && res % 100 <= 16)
        this.sorteio.resultados[id].animal = "Borboleta";
      if (res % 100 >= 17 && res % 100 <= 20)
        this.sorteio.resultados[id].animal = "Cachorro";
      if (res % 100 >= 21 && res % 100 <= 24)
        this.sorteio.resultados[id].animal = "Cabra";
      if (res % 100 >= 25 && res % 100 <= 28)
        this.sorteio.resultados[id].animal = "Carneiro";
      if (res % 100 >= 29 && res % 100 <= 32)
        this.sorteio.resultados[id].animal = "Camelo";
      if (res % 100 >= 33 && res % 100 <= 36)
        this.sorteio.resultados[id].animal = "Cobra";
      if (res % 100 >= 37 && res % 100 <= 40)
        this.sorteio.resultados[id].animal = "Coelho";
      if (res % 100 >= 41 && res % 100 <= 44)
        this.sorteio.resultados[id].animal = "Cavalo";
      if (res % 100 >= 45 && res % 100 <= 48)
        this.sorteio.resultados[id].animal = "Elefante";
      if (res % 100 >= 49 && res % 100 <= 52)
        this.sorteio.resultados[id].animal = "Galo";
      if (res % 100 >= 53 && res % 100 <= 56)
        this.sorteio.resultados[id].animal = "Gato";
      if (res % 100 >= 57 && res % 100 <= 60)
        this.sorteio.resultados[id].animal = "Jacare";
      if (res % 100 >= 61 && res % 100 <= 64)
        this.sorteio.resultados[id].animal = "Leao";
      if (res % 100 >= 65 && res % 100 <= 68)
        this.sorteio.resultados[id].animal = "Macaco";
      if (res % 100 >= 69 && res % 100 <= 72)
        this.sorteio.resultados[id].animal = "Porco";
      if (res % 100 >= 73 && res % 100 <= 76)
        this.sorteio.resultados[id].animal = "Pavao";
      if (res % 100 >= 77 && res % 100 <= 80)
        this.sorteio.resultados[id].animal = "Peru";
      if (res % 100 >= 81 && res % 100 <= 84)
        this.sorteio.resultados[id].animal = "Touro";
      if (res % 100 >= 85 && res % 100 <= 88)
        this.sorteio.resultados[id].animal = "Tigre";
      if (res % 100 >= 89 && res % 100 <= 92)
        this.sorteio.resultados[id].animal = "Urso";
      if (res % 100 >= 93 && res % 100 <= 96)
        this.sorteio.resultados[id].animal = "Veado";
      if (res % 100 >= 97 || res % 100 == 0)
        this.sorteio.resultados[id].animal = "Vaca";

      this.getSoma();
    },
    getSoma() {
      this.sorteio.soma =
        parseInt(this.sorteio.resultados[0].valor) +
        parseInt(this.sorteio.resultados[1].valor) +
        parseInt(this.sorteio.resultados[2].valor) +
        parseInt(this.sorteio.resultados[3].valor) +
        parseInt(this.sorteio.resultados[4].valor);

      if(this.sorteio.soma < 99)
        this.sorteio.soma = "00".concat(this.sorteio.soma);
      else if(this.sorteio.soma <= 999)
        this.sorteio.soma = "0".concat(this.sorteio.soma);   
    }
  }
};
</script>

