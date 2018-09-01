# Curso Web Design Responsivo

## Design fluido
* Sites responsivos utilizam sempre % em vez de pixels (px).

* Largura em % sempre é relativa a largura do elemento pai.

* Não existe diferença entre utilizar em e %.

* Podemos utilzar em em qualquer propriedade que precise de alguma medida.

* max-width é uma ótima forma de limitar a fluidez de elementos da página (podemos utilizar em imagens tbem).

* O inline-block é interessante por simular uma linha de texto com seus elementos. Se não cabe mais um "caracter" na linha, a "palavra" escorrega pra linha de baixo.

* Apesar do em não ser fluído por natureza, sua característica permite que uma alteração na fonte base do texto escale proporcionalmente outros elementos na página.

## MediaQueries
* Media Queries realizam ajustes no estilo da página em função de condições como largura de tela (http://www.w3.org/TR/css3-mediaqueries/) 

### Exemplos:
* - @media (min-width: 400px)
* - @media (orientation: portrait)
* - @media (orientation: landscape)
* - @media (max-width: 400px)
* - @media (height: 400px)
* - @media (device-width: 400px)
* - @media (device-height: 400px)

## Tag viewport (Adapta de acordo com o tamanho da tela de cada dispositivo): 
* <meta name="viewport" content="width=device-width">
* <meta name="viewport" content="width=device-width, initial-scale=1">. => Utilizar essa tag para IOS

* Desktop Browser: Desenvolvimento, Ferramentas, Produtividade
* Emuladores: Compatibilidade, Bugs, Diferenças, Variedade, Custo Baixo
* Dispositivos: Touch, Tamanho, UX, Performance, Sem emulador


* Se você tem Node.js disponível na máquina, instale o weinre para debug remoto em dispositivos genéricos. Útil para navegadores Android antigos, Windows Phone ou iOS se você não tiver um Mac. (você pode instalar o node daqui: http://nodejs.org/):

* npm install -g weinre

* No mac: 

* sudo npm -g install weinre
* execute no terminal: weinre
* ps: caso o comando não seja reconhecido, instale globalmente usando npm install -g weinre

## Imagens Responsivas 
* DIP: Device Independent pixel
* DPR: Device Pixel Ratio
* DPR = Pixel físicos/DIPs

### Exemplo de como utilizar imagens para telas de retina:
.logo {
  background-image: url(logo.png);
}

@media (resolution: 2dppx) {
  .logo {
      background-image: url(logo@x2.png);
  }
}


## NÃO USE FRAMWORKS PARA IMAGENS RESPONSIVAS (picturefill, adaptative, imagens, retina.js, imager.js...)
<img src="logo.png" srcset="logohd.png 2x, logo.png 1x">

# COMPRESSIVE IMAGES
* É otimizar bastante uma imagem de tamanho grande, de forma a ficar com tamanho razoável para diversos dispositivos. Diminuímos a qualidade da imagem, aumentamos a compressão, usamos formatos mais leves etc.

## Imagens Vetoriais
* SVG

Exemplo de bordas:
.panel {
  border-radius: 10px;
}

.container {
  box-shadow: 3px 3px 10px rgba(0,0,0,.3); 
}

.main {
  background: linear-gradient(#F90, #FF0);
}

## ICON FONTS

* Tag Html SVG: <svg>

<img src="logo.svg" onerror="this.src='logo.png'; this.onerror=null">

## DICAS UX PARA MOBILE 

* CONTENT PARITY
* MOBILE FIRST
* TOUCH-FIRST
* Trabalhar com botoes no minimo 50px




