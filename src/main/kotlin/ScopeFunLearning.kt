


/*
there are five types of scope functions: makes your code clear, concise and more readable
with
let
run
apply
also

two main difference between them
1. the way to refer the context object -> either this or it
2. the return value either contextObject or the lambda result

with:
context-> this
return -> lambda
 */

//start[learning with]
/*class Person(){
    var name: String = "amit"
    var age: Int = 23
}


fun main(){
    val person = Person()
//    println("name is ${person.name}")
//    println("age is${person.age}")

    //simple example
    with(person){
        println(this.name)//this keyword is also not required because bydefault its taking this
        println(this.age)
    }

    //here return is lambda and context is this
    val ageAfterfiveYear: Int = with(person){
    println(this.name)
    println(this.age)
        age+5
    }
    println("age after 5 years is $ageAfterfiveYear")
}*/
//End [learning with]

//Start[apply]
/*class Person(){
    var name: String = ""
    var age: Int = 23
}

fun main(){

    //used to assign the value to the variables of the class
    val person = Person().apply {
        this.name = "amit sen"
        this.age = 30
    }

    with(person){
        println(name)
        println(age)
    }

}*/
//End[apply]

//Start[also]
/*fun main(){
    val numberList = mutableListOf<Int>(1,3,4)

    val duplicateNumber = numberList.also {
        it.add(5)
        it.remove(3)
        println("the list elements are $it")
    }
    println("origianl numberlist $numberList")
    println("duplicate numberlist $duplicateNumber")
}
the list elements are [1, 4, 5]
origianl numberlist [1, 4, 5]
duplicate numberlist [1, 4, 5]*/

//second example

/*class Person(){
    var name: String = ""
    var age: Int = 23
}

fun main(){

    //used to assign the value to the variables of the class
    val person = Person().apply {
        this.name = "amit sen"
        this.age = 30
    }

    with(person){
        println(name)
        println(age)
    }

    //so here it is used if u want to do some varaible data changes use also function
    person.also {
        it.name = "amit new name"
        println("name is ${it.name}")
    }

    println("name is ${person.name}")//amit new name
}*/

//End[also]

//Start[let]
//used for avoiding nullpoint exceptions
/*fun main(){
    val name:String? = "amit"

   val nameLength =  name?.let {
        println("name reversed ${it.reversed()}")
        println("captalized ${it.capitalize()}")
        it.length
    }

    println("length of name $nameLength")
}*/

//End[let]

//Start[Run]
//this function is a combination of with and let scope function
class Person(){
    var name: String = "amit"
    var age: Int = 23
}

fun main(){

    val person = Person()

    //so here with is used alsong with let
    person?.run {
        println(name)
        println(age)
        age+5
    }


}

//with -> lambda,this
//let-> lambda, it
//run-> lambda, this
//apply-> context obj, this
//also-> context Obj, it






















