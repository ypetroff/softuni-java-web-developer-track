function factory(face, suit){

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
console.log(factory('10', 'H').toString);
// console.log(factory(8 , 'h').toString);
// console.log(factory('J' , 'd').toString);
// console.log(factory('A' , 'c').toString);
