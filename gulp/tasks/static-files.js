const gulp  = require('gulp');
const merge = require('merge-stream');

const cfg   = require('../config.json');

function staticFiles(done) {
	let streams = [];

	for (let staticFile of cfg.staticFiles) {
		streams.push(gulp
			.src(staticFile.source)
			.pipe(gulp.dest(staticFile.target)));
	}

	return merge(streams).on('end', done);
}

module.exports = () => staticFiles;