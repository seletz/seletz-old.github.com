
// a number
def number = 42

// count to 42.  See, we're sending "upto" to the object "0", which
// is also a number
0.upto(number) { n ->
	println n
}
