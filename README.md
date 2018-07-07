# WebWriter
A Java Program for Parsing HTML Course Notes


## Background
Many of today's University courses offer two features that this program attemps to leverage:


1. Online course notes (often linked from a central outline)
2. Examinations that allow open notes

## The Problem
Even the most astute student will find the task of consuming all of the available information
found in a modern course outline to be quite daunting. The ability to have notes available for
test time is very valuable. Unfortunately, however, the process of accessing these online notes
during exam time comes with its own set of challenges.

In my experience, the biggest challege is having to open tens of browser tabs to search through
each course notes page. This is the problem the WebWriter program aims to address.

## The Solution
While this program is in early developments, the current prototype allows a user parse out all
HTML tags from an array of course notes HTML files. Then, upon parsing out all of the HTML tags
the WebWriter creates an output file that contains all paragraphs from each page in the array of
course notes. This output file allows a student to run a Find search on the output file for terms
that might appear on an examination but for which the answer may be found within any of the notes pages.
