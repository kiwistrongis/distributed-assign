# globals
default: build
freshen: clean build
clean:
	rm -rf bin/* pkg/*
	rm *.pdf

# vars
## java vars
cp = bin
dest = -d bin
warnings =
## other vars
package_file = pkg/kalev_100425828_assign3.zip
pandoc = ~/.cabal/bin/pandoc

# includes
#include deps.mk
#include lists.mk

# compilation definitions
$(class_files): bin/%.class : src/%.java
	javac -cp $(cp) $(dest) $(warnings) $<

report.pdf: report.md
	$(pandoc) -r markdown_github $< -o $@

$(package_file): $(class_files) report.pdf
	zip -FSr $(package_file) \
		bin src \
		deps.mk lists.mk makefile \
		report.pdf report.md \
		pkg/.gitignore

# commands
all: build report package
build: $(class_files)
report: report.pdf
package: $(package_file)

test: test-counter
run: test-counter

# tests
test-counter: bin/Counter.class
	java -cp $(cp) Counter

test-report: report.pdf
	evince $<
