# Course Electron

* Apps building with Electron: https://electronjs.org/apps

* Electron-package: https://github.com/electron-userland/electron-packager
```
  To install: npm install electron-packager -g
  Mac: 
  electron-packager alura-timer/ alura-timer --platform=darwin --arch=x64 --icon=icon/icon.icns

  Windows:
  electron-packager alura-timer/ alura-timer --platform=win32 --arch=x64 --icon=icon/icon.ico

  Linux:
  electron-packager alura-timer/ alura-timer --platform=linux --arch=x64 --icon=icon/icon.png

  If you use Linux or Mac, you need install Wine

  Others way:
  electron-packager alura-timer/ alura-timer --platform=all --arch=x64
  electron-packager alura-timer/ alura-timer --platform=darwin,linux,win32 --arch=x64
  electron-packager alura-timer/ alura-timer --platform=darwin,linux,win32 --arch=x64 --icon=icon/icon

  
  To convert icon: https://iconverticons.com/online/  
```