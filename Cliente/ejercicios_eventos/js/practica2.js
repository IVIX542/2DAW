const cuadrao = document.getElementById("cuadrao");

cuadrao.addEventListener("mouseover", () => {
    cuadrao.className = "size-32 bg-green-400";
});
cuadrao.addEventListener("mouseout", () => {
    cuadrao.className = "size-32 bg-gray-400";
});