
sealed class Shape{
    class Circle(var radius:Int):Shape()
    class Square(var side:Int): Shape()
    class Rectange(var length:Int, var breadth:Int)

    object NotAShape: Shape()
}

fun main(){
    var circle = Shape.Circle(10)
    var square = Shape.Square(5)
    var rectangle =Shape.Rectange(10,20)

    checkShape(circle)
}

fun checkShape(shape: Shape) {
   when(shape){
       is Shape.Circle -> println("circle area is ${shape.radius}")
       is Shape.Square -> println("square area is ${shape.side}")
       Shape.NotAShape-> println("no shape found") //if the object is created inside selaed file no need of is keyword

   }

}
