function solve(heroInfo) {
  let heroArr = [];
  for (const hero of heroInfo) {
    let [name, lvl, strItems] = hero.split(' / ');
    let level = Number(lvl);
    let items = strItems ? strItems.split(', ') : [];
    
    heroObj = { name, level, items};
    heroArr.push(heroObj);
  }

  let outputAsJASON = JSON.stringify(heroArr);
  console.log(outputAsJASON);
}
solve([
  "Isacc / 25",
  "Derek / 12 / BarrelVest, DestructionSword",
  "Hes / 1 / Desolator, Sentinel, Antara",
]);
