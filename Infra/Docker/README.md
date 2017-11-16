Course Docker by Alura

https://github.com/docker

Docker Compose: Um jeito fácil de definir e orquestrar multiplos containers.
Docker Swarm: Ferramenta para colocar multiplos Dockers Host's para trabalharem juntos em cluster
Docker Hub: Repositório com mais de 250 mil imagens diferentes para os seus containers.
Docker Machine: Ferramenta que permite instalar e configurar em hosts virtuais.

Install Docker Windows
https://store.docker.com/editions/community/docker-ce-desktop-windows
https://download.docker.com/win/stable/InstallDocker.msi
https://download.docker.com/win/stable/DockerToolbox.exe

Install Docker Mac
https://store.docker.com/editions/community/docker-ce-desktop-mac
https://download.docker.com/mac/stable/Docker.dmg
https://download.docker.com/mac/stable/DockerToolbox.pkg
https://docs.docker.com/docker-for-mac/install/#what-to-know-before-you-install

Install Docker Ubuntu
sudo apt-get remove docker docker-engine docker.io
sudo apt-get update
curl -fsSL https://download.docker.com/linux/ubuntu/gpg | sudo apt-key add -

sudo add-apt-repository \
   "deb [arch=amd64] https://download.docker.com/linux/ubuntu \
   $(lsb_release -cs) \
   stable"

sudo apt-get update
sudo apt-get install docker-ce
sudo docker version
sudo usermod -aG docker $(whoami)

docker version
docker run hello-world

