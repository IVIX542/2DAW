// Escucha el clic y calcula
document.getElementById("btnCalcular").addEventListener("click", () => {
  const texto = document.getElementById("nums").value;
  const numeros = parsearNumeros(texto);

  const media = calcularMedia(numeros); // ← bug intencional
  actualizarUI(media);
});
// Convierte "10, 20, x" -> [10, 20]
function parsearNumeros(texto) {
  return texto
    .split(",")
    .map((s) => Number(s.trim()))
    .filter((n) => !Number.isNaN(n));
}

function calcularMedia(nums) {
  if (nums.length === 0) return NaN;
  let total = 0;
  for (let i = 0; i < nums.length; i++) {
    total += nums[i];
  }
  return total / nums.length;
}

function actualizarUI(media) {
  document.getElementById("salida").textContent = `Media: ${media}`;
}
