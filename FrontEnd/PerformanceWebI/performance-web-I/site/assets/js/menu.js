// $(window).on('load', function() {
// 	var menu = $('.header-menu');

// 	$('.header-menu-titulo').on('click', function() {
// 		if (menu.is('[data-ativo]')) {
// 			menu.removeAttr('data-ativo');
// 		} else {
// 			menu.attr('data-ativo', '');
// 		}
// 	});
// });


window.addEventListener('load', function(){
	var menu = document.querySelector('.header-menu');
	var titulo = document.querySelector('.header-menu-titulo');

	if(titulo){
		titulo.onclick = function(){
			if(menu.hasAttribute('data-ativo')){
				menu.removeAttribute('data-ativo');
			}else{
				menu.setAttribute('data-ativo', '');
			}
		}
	}
})