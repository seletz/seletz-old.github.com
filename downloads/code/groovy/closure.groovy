
// a closure
def closure = { a, b -> a + b }

// let's call it
println closure.call(1, 2)  // 3

// same, less verbose
println closure(1, 2)  // 3

// we can also accept a closure as a parameter
def when(condition, closure) {
	if (condition)
		closure()
}

when (4<5) {
	println "yay!"
}

def local = 2
def test = { x -> local + x }

println "test(2) => ${test(2)}" // test(2) => 4
local = 3
println "test(2) => ${test(2)}" // test(2) => 5

def test2 = { x ->
	def local2 = x
	return { k -> k + local2 }
}

def test_2 = test2(2)
def test_3 = test2(3)

println "test_2(2) => ${test_2(2)}" // test_2(2) => 4
println "test_3(2) => ${test_3(2)}" // test_3(2) => 5
