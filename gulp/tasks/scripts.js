const gulp       = require('gulp');
const composer   = require('gulp-uglify/composer');
const browserify = require('browserify');
const source     = require('vinyl-source-stream');
const buffer     = require('vinyl-buffer');
const uglifyEs   = require('uglify-es');

const uglifyEs6  = composer(uglifyEs, console);

const cfg        = require('../config.json');

function scripts() {
	let bundle = browserify(cfg.scripts.source, {
		debug: true,
		cache: {},
		packageCache: {}
	});

	let errorCached = false;

	return bundle
		.bundle()
		.on('error', (err) => {
			if (!errorCached) {
				console.error('Unexpected error occured while building the project!');
				console.error('Message:\n', err.message);
				console.error('Stacktrace:\n', err.stack);

				errorCached = true;
			}
		})
		.pipe(source(cfg.scripts.targetFileName))
		.pipe(buffer())
		.pipe(uglifyEs6())
		.pipe(gulp.dest(cfg.scripts.targetFolderPath));
}

module.exports = () => scripts;