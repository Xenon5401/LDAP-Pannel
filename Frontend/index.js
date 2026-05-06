const express = require('express');
const reload = require('reload');
const path = require('path');
const app = express();
const PORT = 3000;

// Sert les fichiers statiques (HTML, CSS, JS)
app.use(express.static('.'));

app.get('/', (req, res) => {
  res.sendFile(path.join(__dirname, 'index.html'));
});

const server = app.listen(PORT, () => {
  console.log(`Serveur lancé sur : http://localhost:${PORT}`);
});

reload(app).then(() => {
  console.log('Reload activé, actualisez automatiquement le navigateur lors des modifications.');
}).catch(err => {
  console.error('Erreur lors de l’activation de reload :', err);
});
