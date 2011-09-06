#!/usr/bin/perl
use strict;
use warnings;

my @files = <*>;
for(@files){ 
    next unless /P(\d{0,3}).java/;
    my $num = ("0"x(3-length($1))).$1;
    print("git mv $_ P$num.java\n");
}
