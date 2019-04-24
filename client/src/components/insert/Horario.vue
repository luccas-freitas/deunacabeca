<template>
  <div class="form-group">
    <label>Horário:</label>
    <select v-if="sorteio.loteria < 2" class="form-control" v-model="sorteio.horario" required>
      <option value disabled hidden>Selecione um Horário</option>
      <option value="0">11:20</option>
      <option value="1">14:20</option>
      <option value="2">16:20</option>
      <option value="3">18:20</option>
      <option value="5">21:20</option>
    </select>

    <select v-else class="form-control" v-model="sorteio.horario" required>
      <option value disabled hidden>Selecione um Horário</option>
      <option value="4">19:00</option>
    </select>
  </div>
</template>

<script>
export default {
  name: "horario",
  props: ["sorteio"]
};
</script>

