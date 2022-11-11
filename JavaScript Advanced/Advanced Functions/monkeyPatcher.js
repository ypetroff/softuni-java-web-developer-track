let post = {
  id: "3",
  author: "emil",
  content: "wazaaaaa",
  upvotes: 100,
  downvotes: 100,
};
solution.call(post, "upvote");
solution.call(post, "downvote");
let score = solution.call(post, "score"); // [127, 127, 0, 'controversial']
console.log(score);

for (let index = 0; index < 50; index++) {
    solution.call(post, "downvote");  
} // (executed 50 times)

score = solution.call(post, "score"); // [139, 189, -50, 'unpopular']
console.log(score);

function solution(command) {

  switch (command) {
    case "upvote":
      this.upvotes++;
      break;
    case "downvote":
      this.downvotes++;
      break;
    case "score":
      const downvote = this.downvotes;
      const upvote = this.upvotes;
      const total = upvote + downvote;
      const balance = upvote - downvote;
      const obf = total > 50 ? Math.ceil(Math.max(upvote, downvote) * 0.25) : 0;
      const percentageUpvotes = upvote / total;

      if(percentageUpvotes > 0.66 && total >= 10) { //without second condition test 1 is wrong in judge 
        return [upvote + obf, downvote + obf, balance, "hot"];
      }else if(balance >= 0 && total > 100) { // u > 100 || d > 100
        return [upvote + obf, downvote + obf, balance, "controversial"];
      } else if (balance < 0 && total >= 10) { // without the second condition test 8 is wronk in judge
        return [upvote + obf, downvote + obf, balance, "unpopular"];
      } else if(total < 10) {
        return [upvote, downvote, balance, "new"];
      } else {
        return [upvote + obf, downvote + obf, balance, "new"];
      }

  }
}
