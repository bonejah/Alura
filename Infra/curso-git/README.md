Study project using GIT

github - ferramenta online para guardar os arquivos
ssh-keygen -t rsa -C "seu_email@provedor.com" - comando para configurar o github

git clone https://github.com/urlDoProjeto - Copia o projeto para sua m·quina

git config --global user.name = "seuNome"
git config --global user.email = "seuEmail"

Estados do Git: Working Directory, Index e Head.

mkdir curso-git
cd curso-git

git ini = Comando que inicia um repositorio Git
git ls-files = Comando que verifica quais arquivos pertencem ao diretorio
git	blame nomedoarquivo - verifica as alteracoes do arquivo

git tag - comando para verificar a vers„o do arquivo
v0.1
v0.2

git checkout v0.1
git diff v0.1 v0.2 - comando para verificar a diferenÁa de versoes

git add nomedoarquivo = Comando para adicionar arquivo no repositorio
git add .. = Comando que adiciona todos os arquivos da pasta atual
git add *.txt = Comando que adiciona todos os arquivos .txt
git add -i = … mais recomendado quando temos um numero muito grande de alteracoes a serem adicionadas ao Index

git commit -m "Inicio do Projeto"
git commit -a j· cria um novo HEAD com todas as alteracoes detectadas no repositorio, porem novos arquivos nao serao adicionados. 

git remote add [alias_do_repositorio] [uri_do_repositorio]. = Comando para adicionar um repositorio remoto
Exemplo: git remote add origin git@github.com:[seu_nome_de_usuario]/curso-git.git.

git push origin master = Comando para enviar os commits locais para o repositorio remoto

git clone git://github.com/[usuario_do_dono_do_repositorio]/curso-git.git meuprojeto = Comando utilizado para baixar um projeto do GitHub para sua m·quina local

git pull origin master = Comando utilizado para sincronizar as alteracoes do repositorio remoto

git log = Comando utilizado para visualizar os logs dos commits
git log --pretty=oneline
git whatchanged -p = Comando para verificar os arquivos modificados

git branch = Comando que lista as branchs locais
git branch = Comando que listas as branchs remotas
git branch -a = Comando que lista tanto as branchs locais como as remotas
git branch -d design = Comando que deleta a branch design
git push origin :design = Comando que deleta um branch remota
git branch design = Comando que cria a nova branch "design"
git ckeckout -b design = Comando que cria e j· muda para a branch design
git checkout desing = Comando que muda a branch atual (master) para a nova (design)
git push -u origin design = Comando que enviar as modificacoes da branch design para a branch master
git checkout -t origin/design = Uma nova branch local chamada design È criada, muda-se para essa branch, copiamos todo o conte˙do da branch remota design do repositorio referente ao origin e trackeamos as duas branches.
git fetch origin = Verifica todas as atualizaÁıes que foram realizadas no repositorio referente ao origin.
git mergetool -t nome_do_programa
git merge design = Comando que envia as alteracoes de design para o master
git rebase master design = Comando que atualiza a branch design com base na branch master
git rebase:
- Continue deve ser utilizado apos a resolucao manual dos conflitos, 
- Skip faz com que suas alteracoes sejam descartadas 
- Abort volta atr·s em todo o processo de rebase.

git checkout nomeDoArquivo = Comando que retira as alteracoes de um arquivo do Working Directory.
git checkout -- nomeDoArquivo = Caso tenha um arquivo com o nome igual ao da branc
git reset HEAD nomeDoArquivo = Comando que descarta as alteracoes do Index e as envia para o Working Directory.
git reset --soft
git reset --hard
git stash
git stash pop
git stash drop = Deleta um estado
git stash list
git stash pop stash@{1}
git revert
HEAD~1 = Atalho para o penultimo commit
git bisect = Possibilita navegar em v·rios commits de uma maneira mais simples e verificar onde um possÌvel bug foi inserido.

fork = Permite que vocÍ tenha uma cÛpia de repositorio (que vocÍ não tenha permissao) para voce realizar as suas prÛprias alteracoes;

Pull Request = ode ser criado pela prÛpria interface gr·fica do Github, onde indicaremos quais usu·rios ser„o notificados das alteracoes que 
`desejamos enviar. Por fim, basta dar uma descriÁ„o para as alteracoes que est„o sendo enviadas e aguardar se o Pull Request ser· aceito ou não.

git remote add original [caminho_do_repositorio_remoto] = Comando utilizado para rastrear todas as alteracoes existentes no repositorio original em nosso novo fork.

git fetch original = Carrega as alteracoes existentes no repositorio. O comando fetch apenas realizar· o download das novas alteracoes que não temos ainda em nosso repositorio,
mas não vai aplic·-las ainda.

git merge original = Comando que aplica as alteracoes do repositorio original 

git cherry-pick idDoCommitQueSeDesejaFazer

Git-Cola = Ferramenta Gr·fica (http://git-cola.github.com/downloads.html)








