
// a simple class.   Note that we do not define a constructor.
class Person {
	public String name
	public Integer age
}

def anonymous = new Person()
def stefan    = new Person( name: "Stefan", age: 38)
def fritz     = new Person( name: "Fritz")

println "${stefan.name} is ${stefan.age} years old." // stefan is 38 years old.
println "${fritz.name} is ${fritz.age} years old." // fritz is null years old.

stefan.age = 35 // no setters and getters needed!
println "${stefan.name} is ${stefan.age} years old." // stefan is 35 years old.

// coerce a map to a class.  Will call named-arg automatic ctor
def maja = [name:"Maja", age:8] as Person
println "${maja.name} is ${maja.age} years old." // maja is 8 years old.

