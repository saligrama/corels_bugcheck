#!/usr/bin/env python2

import csv, sys

fname = sys.argv[1]

with open(fname, "r") as fin:
	reader = csv.reader(fin)
	npos = 0
	nneg = 0
	for line in reader:
		cl = line[len(line)-1]
		if cl == "1":
			npos += 1
		else:
			nneg += 1
	basename = fname[fname.rfind('/')+1:]
	print basename, npos, nneg, (npos-nneg)
