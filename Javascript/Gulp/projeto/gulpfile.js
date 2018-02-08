var gulp = require('gulp')
  ,imagemin = require('gulp-imagemin')
  ,clean = require('gulp-clean');

// Task copy
gulp.task('copy', ['clean'], function() {
    return gulp.src('src/**/*')
    .pipe(gulp.dest('dist'));
});

// Task clean
gulp.task('clean', function() {
  return gulp.src('dist')
    .pipe(clean());
});

// Task opmitize images
gulp.task('build-img', ['copy'], function() {
  gulp.src('dist/img/**/*')
    .pipe(imagemin())
    .pipe(gulp.dest('dist/img'));
});