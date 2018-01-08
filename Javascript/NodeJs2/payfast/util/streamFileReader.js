var fs = require('fs');

fs.createReadStream('imagem.jpg')
  .pipe(fs.createWriteStream('imagem4.jpg'))
  .on('finish', function(){
    console.log('arquivo escrito com Stream')
  });