function printDeckOfCards(cards) {
let output = [];
for (const card of cards) {
    const[face, suit] = [ card.slice(0, card.length - 1), card.slice(-1)];
  try {
   const currentCard = createCard(face, suit);
    output.push(currentCard);
  } catch (Error) {
    console.log(`Invalid card: ${card}`);
    return;
}  
}
console.log(output.join(' '));

    function createCard (face, suit){
        const faces = ['2', '3', '4', '5', '6', '7', '8', '9', '10', 'J', 'Q', 'K', 'A'];
        const currentFace = typeof face === 'string' ? face.toUpperCase() : face;
        if(!faces.includes(currentFace)){
            throw new Error('Error');
        }
        const suits = {
            'S': '♠',
            'H': '♥',
            'D': '♦',
            'C': '♣'
        }
        const currentSuit =  typeof suit === 'string' ? suit.toUpperCase() : 'Error';
        if(currentFace === 'Error' || !suits.hasOwnProperty(currentSuit)) {
            throw new Error('Error');
        }
        return {
            currentFace,
            currentSuit,
            toString() {
                return `${currentFace}${suits[currentSuit]}`;
            }
        }
    }
}
// console.log(printDeckOfCards(['AS', '10D', 'KH', '2C']));
console.log(printDeckOfCards(['AS', '10D', 'KH', '2C', '1c']));