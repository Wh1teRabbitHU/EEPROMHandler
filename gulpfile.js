const gulp    = require('gulp');

const build   = require('./gulp/tasks/build');
const release = require('./gulp/tasks/release');

gulp.task('build', build());
gulp.task('release', release());
gulp.task('default', build());