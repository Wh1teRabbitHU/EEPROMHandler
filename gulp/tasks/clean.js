const del = require('del');

const cfg = require('../config.json');

function clean() {
	return del(cfg.clean.target, { force: true });
}

module.exports = () => clean;