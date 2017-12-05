Course Chrome DevTools By Alura

Comando para simular document.querySelector no console: $(nome do atributo html)
Comando para simular document.querySelectorAll no console: $$(nome do atributo html)
Comando para verificar os listeners de um determinado elemento: getEventListeners(document)

Modo debug
- variaveis com scope local, global e closure


Configure o DevTools para salvar as novas mudanças automaticamente. Para isso, abra a aba Sources do DevTools e na coluna janela esquerda, clique com o botão direito e em "Add Folder to Workspace". Clique com o botão direito no arquivo index.html e selecione a opção "Map to File System Resource" e escolha index.html. Normalmente se você mandar mapear apenas um arquivo da pasta, o resto é automaticamente mapeado também!

Ao clicar em {} o DevTools identa o codigo pra gente! Agora podemos deixar o desempenho otimizado e continuar podendo ler ele no navegador.

A aba Timeline permite gravar todo o processamento realizado pelo navegador por um determinado período para que se possa analisar possíveis gargalos na performance. Incluindo quadros por segundo, processamento da CPU e chamadas de funções JS.

Os profiles permitem uma análise bem baixo nível, mostrando processamento da CPU e alocação de memória. Isso permite que se identifique prolemas em casos de web apps muito dependentes de JS, como Gmail ou Facebook.

O localStorage é uma ferramenta que permite bastante versatilidade, mas ela está na mão do cliente. Portanto tome cuidado e evite colocar nele coisas essenciais.