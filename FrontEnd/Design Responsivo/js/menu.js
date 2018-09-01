document.querySelector('.menu-abrir').onclick = function() {
  console.log("clicou aqui1")
  document.documentElement.classList.add('menu-ativo');
};

document.querySelector('.menu-fechar').onclick = function() {
  console.log("clicou aqui2")
  document.documentElement.classList.remove('menu-ativo');
};

document.documentElement.onclick = function(event) {
  if (event.target === document.documentElement) {
      document.documentElement.classList.remove('menu-ativo');
  }
};

// $(".menu-abrir, .menu-fechar").click(function() {
//      $('html').toggleClass("menu-ativo");  
// });


// $(".menu-abrir").on("click", function() {
//   $(this).addClass("menu-ativo");  
// });
// $(".menu-fechar").on("click", function() {
//  $(this).removeClass("menu-ativo");  
// });

// $(".menu-acao").on("click", function() {
//   $(this).toggleClass("menu-ativo");  
// });