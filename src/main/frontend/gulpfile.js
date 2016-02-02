var gulp = require('gulp');
var connect = require('gulp-connect');
var ts = require('gulp-typescript');
var merge = require('merge2');

var tsProject = ts.createProject('tsconfig.json');

var ts_files = 'app/**/*.ts';

gulp.task('scripts', function() {
	var tsResult = gulp.src(ts_files)
					.pipe(ts(tsProject));

	return merge([ // Merge the two output streams, so this task is finished when the IO of both operations are done.
		tsResult.dts.pipe(gulp.dest('release/definitions')),
		tsResult.js.pipe(gulp.dest('release/js'))
	]);
});

gulp.task('watch', ['scripts'], function() {
    gulp.watch(ts_files, ['scripts']);
});

gulp.task('connect', function() {
  connect.server({
    livereload: true
  });
});

gulp.task('default', ['connect']);
