<template>
  <table>
    <tr>
      <td>
  <input
    type="text"
    class="form-control"
    minlength="2"
    maxlength="2"
    autocomplete="off"
    pattern="^[0-9]*$"
    required
    v-model="sorteio.resultados[id].valor"
    :id="'resultado-' + id">
      </td></tr></table>
</template>

<script>
export default {
  name: "Loto",
  props: ["sorteio", "id"]
};
</script>

