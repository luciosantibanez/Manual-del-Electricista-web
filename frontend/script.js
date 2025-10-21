document.getElementById("btnCables").addEventListener("click", async () => {
  const res = await fetch("http://localhost:8080/cables");
  const datos = await res.json();
  document.getElementById("resultado").innerHTML = JSON.stringify(datos);
});
