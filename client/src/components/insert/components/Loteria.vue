<template>
  <div class="form-group">
    <label>Loteria:</label>
    <select
      class="form-control"
      v-model="sorteio.loteria"
      @change="loteriaType(sorteio.loteria)"
      required
    >
      <option value disabled hidden>Selecione uma Loteria</option>
      <option value="0">PT-RIO</option>
      <option value="1">PR</option>
      <option value="2">FEDERAL</option>
      <option value="3">MEGA SENA</option>
      <option value="4">QUINA BR</option>
    </select>
  </div>
</template>

<script>
export default {
  name: "loteria",
  props: ["sorteio"],
  methods: {
    loteriaType(loteria) {
      if (loteria < 2)
        this.sorteio.resultados = [
          {
            valor: 0,
            animal: ""
          },
          {
            valor: 0,
            animal: ""
          },
          {
            valor: 0,
            animal: ""
          },
          {
            valor: 0,
            animal: ""
          },
          {
            valor: 0,
            animal: ""
          },
          {
            valor: 0,
            animal: ""
          }
        ];
      else
        this.sorteio.resultados = [
          {
            valor: 0
          },
          {
            valor: 0
          },
          {
            valor: 0
          },
          {
            valor: 0
          },
          {
            valor: 0
          }
        ];
    }
  }
};
</script>

