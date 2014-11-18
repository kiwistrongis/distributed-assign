# globals
default: build
freshen: clean build
clean:
	rm -rf bin/* pkg/*
	rm -f *.pdf

# vars
## java vars
cp = bin
dest = -d bin
java_warnings =
## rust vars
rust_warnings = -A dead_code -A unused_variable
rust_opts = $(rust_warnings) -g -L bin
## other vars
package_file = pkg/kalev_100425828_assign3.zip
pandoc_cmd = ~/.cabal/bin/pandoc

# includes
include deps.mk
include lists.mk

# compilation definitions
$(binaries): bin/% : src/%.rs
	rustc $(rust_opts) $< -o $@

$(class_files): bin/%.class : src/%.java
	javac -cp $(cp) $(dest) $(java_warnings) $<

$(package_file): $(class_files) report.pdf
	zip -FSr $(package_file) \
		bin src \
		deps.mk lists.mk makefile \
		report.pdf report.md \
		pkg/.gitignore

report.pdf: report.md
	$(pandoc_cmd) -r markdown_github $< -o $@

# commands
all: build report package
build: $(class_files) $(binaries)
report: report.pdf
package: $(package_file)

run: \
	test-q1-bad \
	test-q1-good \
	test-q2
run-bad: test-q1-bad
run-good: test-q1-good

test: test-q1-bad

# tests
test-q1-bad: bin/BadCounting.class
	java -cp $(cp) BadCounting

test-q1-good: bin/GoodCounting.class
	java -cp $(cp) GoodCounting

test-q2: bin/q2sim
	$<

test-report: report.pdf
	evince $<
