const { app, BrowserWindow, ipcMain, Tray, Menu } = require('electron')
const data = require('./data')
const templateGenerator  = require('./templates')

let mainWindow = null;
let tray = null;

app.on('ready', () => {
  mainWindow = new BrowserWindow({
    width: 800,
    height: 600
  })

  tray = new Tray(__dirname + '/app/img/icon-tray.png');  
  let template = templateGenerator.geraTrayTemplate(mainWindow)
  let trayMenu = Menu.buildFromTemplate(template)
  tray.setContextMenu(trayMenu)

  //mainWindow.loadURL('https://www.google.com')
  mainWindow.loadURL(`file://${__dirname}/app/index.html`)
})

app.on('window-all-closed', () => {
  app.quit()
})

let sobreWindow = null;

ipcMain.on('abrir-janela-sobre', () => {
  if (sobreWindow == null) {
      sobreWindow = new BrowserWindow({
      width: 300,
      height: 220,
      alwaysOnTop: true,
      //frame: false, este atributo esconde o Maximize and Minimize
    })

    sobreWindow.on('closed', () => {
      sobreWindow = null
    })
  }

  sobreWindow.loadURL(`file://${__dirname}/app/sobre.html`);
})

ipcMain.on('fechar-janela-sobre', () => {
  sobreWindow.close()
})

ipcMain.on('curso-parado', (event, curso, tempoEstudado) => {
   console.log(`O curso ${curso} foi estudado ${tempoEstudado}`)
   data.salvaDados(curso, tempoEstudado )
})

ipcMain.on('curso-adicionado', (event, novoCurso) => {
  let novoTemplate = templateGenerator.adicionaCursoNoTray(novoCurso, mainWindow);
  let novoTrayMenu = Menu.buildFromTemplate(novoTemplate);
  tray.setContextMenu(novoTrayMenu);
});