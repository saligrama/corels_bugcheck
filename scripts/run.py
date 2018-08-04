#!/usr/bin/env python2
import os.path, subprocess, sys

def run_corels (fnoext):
	minsup = fnoext[fnoext.rfind('y'):fnoext.rfind('_', 0, fnoext.rfind('_')-1)]
	name = fnoext[fnoext.rfind('c'):fnoext.rfind('y')] + minsup
	fname = "~/bbcache/data/CrossValidation/census/" + minsup + "/" + name + "/" + fnoext
	fargs = fname + ".out " + fname + ".label " + fname + ".minor " + "../rule_lists_cold/" + fnoext + ".txt"
	command = "~/bbverify/src/corels-cli -c 2 -p 1 -r 0.01 -v progress,log -n 2000000000 " + fargs
	print(command)
	o = subprocess.Popen(command, stdout=subprocess.PIPE, stderr=None, shell=True).communicate()
	return o[0].decode()

def main ():
	for fname in os.listdir("../rule_lists_cold"):
		if "22" in fname:
			continue
		fbasename = fname[fname.rfind('/')+1:]
		noext = fbasename[:fbasename.rfind('.')]
		proclogout = "../proc-logs-warm/" + fbasename
		if os.path.isfile(proclogout):
			continue
		with open(proclogout, "w") as f:
			f.write(run_corels(noext))

main()
