#!/usr/bin/perl


while (<STDIN>)
{

	my $line = $_;
	chomp($line);

	my $name = substr($line, 0, 15);
	$name =~ s/\s+$//g;

	print "$name\n";
}
