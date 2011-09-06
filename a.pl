#!/usr/bin/perl
use strict;
use warnings;

my $n = 10000;
my $s = 100000;
print "$n $s\n";
print ((int((rand()*$s)).' ')) for(1..$n);
