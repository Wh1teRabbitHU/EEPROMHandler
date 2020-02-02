const gulp        = require('gulp');

const clean       = require('./clean');
const staticFiles = require('./static-files');
const styles      = require('./styles');
const scripts     = require('./scripts');

module.exports = () => gulp.series(clean(), gulp.parallel(staticFiles(), styles(), scripts()));