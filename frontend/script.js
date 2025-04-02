const apiUrl = "http://localhost:8080/inventory";

async function loadInventory() {
  const response = await fetch(apiUrl);
  const items = await response.json();

  const list = document.getElementById("inventoryList");
  list.innerHTML = "";

  items.forEach(item => {
    const li = document.createElement("li");
    li.innerText = `${item.id} - ${item.name} (${item.type}) - $${item.price} - ${item.volume}ml - Qty: ${item.quantity}`;
    list.appendChild(li);
  });
}

document.getElementById("addForm").addEventListener("submit", async function (e) {
  e.preventDefault();

  const item = {
    id: document.getElementById("id").value,
    name: document.getElementById("name").value,
    type: document.getElementById("type").value,
    price: parseFloat(document.getElementById("price").value),
    volume: parseFloat(document.getElementById("volume").value),
    quantity: parseInt(document.getElementById("quantity").value)
  };

  const response = await fetch(apiUrl, {
    method: "POST",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify(item)
  });

  const result = await response.text();
  alert(result);
  loadInventory();
});