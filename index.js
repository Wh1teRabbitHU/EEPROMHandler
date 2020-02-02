const { app, BrowserWindow } = require('electron');

let mainWindow = null;

function createMainWindow() {
	if (mainWindow !== null) {
		return;
	}

	mainWindow = new BrowserWindow({
		width: 800,
		height: 600,
		show: false,
		webPreferences: {
			nodeIntegration: true
		}
	});

	mainWindow.loadFile('generated/index.html');

	mainWindow.once('ready-to-show', mainWindow.show);
	mainWindow.on('closed', () => { mainWindow = null; });
}

app.on('ready', createMainWindow);
app.on('activate', createMainWindow);
app.on('window-all-closed', () => {
	if (process.platform !== 'darwin') {
		app.quit();
	}
});