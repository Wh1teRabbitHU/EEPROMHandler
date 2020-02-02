const gulp      = require('gulp');
const stylus    = require('gulp-stylus');
const cleanCss  = require('gulp-clean-css');
const concatCss = require('gulp-concat-css');

const cfg       = require('../config.json');

function styles() {
	return gulp.src(cfg.styles.source)
		.pipe(stylus())
		.pipe(concatCss(cfg.styles.targetFileName))
		.pipe(cleanCss())
		.pipe(gulp.dest(cfg.styles.targetFolderPath));
}

module.exports = () => styles;