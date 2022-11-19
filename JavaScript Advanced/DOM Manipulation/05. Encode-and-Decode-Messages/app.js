function encodeAndDecodeMessages() {
  const encodeAndSendButtonElement = document.querySelector(
    "#main > div:nth-child(1) > button"
  );
  const outputTextAreaElement = document.querySelector(
    "#main > div:nth-child(2) > textarea"
  );

  let text = "";

  encodeAndSendButtonElement.addEventListener("click", encode);
  encodeAndSendButtonElement.addEventListener("click", putTextInOutputArea);

  const decodeAndReadButtonElement = document.querySelector(
    "#main > div:nth-child(2) > button"
  );

  decodeAndReadButtonElement.addEventListener("click", decode);
  decodeAndReadButtonElement.addEventListener("click", putTextInOutputArea);

  function encode() {
    const inputTextAreaElement = document.querySelector(
      "#main > div:nth-child(1) > textarea"
    );
    text = inputTextAreaElement.value;

    text = modifyText(1);

    inputTextAreaElement.value = "";
  }

  function putTextInOutputArea() {
    outputTextAreaElement.value = text;
  }

  function decode() {
    text = modifyText(-1);
    outputTextAreaElement.value = text;
  }

  function modifyText(modificationNumber) {
    let encryptedMessage = [];

    [...text].forEach((x) => {
      const letterEncoded = String.fromCharCode(
        x.charCodeAt(0) + modificationNumber
      );
      encryptedMessage.push(letterEncoded);
    });

    return encryptedMessage.join("");
  }
}
