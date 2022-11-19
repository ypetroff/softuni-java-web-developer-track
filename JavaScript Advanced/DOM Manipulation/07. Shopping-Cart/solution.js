function solve() {
  const btnsElements = [...document.querySelectorAll('body > div > div > div.product-add > button')];
  let textAreaElement = document.querySelector('textarea');
  btnsElements.forEach(x => x.addEventListener('click', addProduct));

  let productsList = {};

  function addProduct(e) {

    const product = e.target.parentNode.parentNode;
    const productName = product.children[1].children[0].textContent;
    const productPrice = Number(product.children[3].textContent);

    productsList[productName] ? productsList[productName] += productPrice : productsList[productName] = productPrice;

   textAreaElement.textContent += `Added ${productName} for ${productPrice.toFixed(2)} to the cart.\n`;
  }

  let checkoutBtn = document.querySelector('body > div.shopping-cart > button');
  checkoutBtn.addEventListener('click', checkout);

  

  function checkout(e) {
   let boughtProducts = [];
   let totalPrice = 0;

   for (const [key, value] of Object.entries(productsList)) {
      boughtProducts.push(key);
      totalPrice+=value;
   }

   textAreaElement.textContent += `You bought ${boughtProducts.join(', ')} for ${totalPrice.toFixed(2)}.`;
   btnsElements.forEach(x => x.removeEventListener('click', addProduct));
   checkoutBtn.removeEventListener('click', checkout);
  }
}