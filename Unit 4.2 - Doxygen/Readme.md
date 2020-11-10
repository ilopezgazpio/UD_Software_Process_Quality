Instalation
===========
http://www.doxygen.nl/download.html

If you need to generate pdf documents you will also need a tex processor, such as MikTeX (http://www.doxygen.nl/download.html)
 and a pdf renderer such as Ghostscript (http://pages.cs.wisc.edu/~ghost/)


Useful doxygen commands
========================
To use doxygen you must follow these steps:

1. Create a configuration file and modify pom.xml so that points to it
2. Document the source
3. Run doxygen report generator with: mvn doxygen:report

To copy generated html directory into docs folder: mvn validate
To remove generated target files including dir docs with html code: mvn clean

To generate a pdf you need to access the target/doxygen/latex path and manually generate the pdf from the *.tex sources (make command)
