def map = [:]

map.some_key = "value"
map.another_key = "foo"
map["yet another key"] = "bar"

map.each { item ->
	println "$item.key => $item.value"
}

// implicit maps
def errors = [ EINVAL: -1, ENOSPC: -3, EPROTO: -42] // just some example
println errors.EINVAL  // -1
