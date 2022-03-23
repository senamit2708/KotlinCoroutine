import kotlinx.coroutines.*
import java.sql.Timestamp
import kotlin.concurrent.thread
import kotlin.coroutines.CoroutineContext
import kotlin.system.measureTimeMillis

//start[learning 1]

/*fun main(){
    println("Start of program and Thread is ${Thread.currentThread().name}")

    thread {//create a background thread
        println("fake work starts ${Thread.currentThread().name}")
        Thread.sleep(1000)//sleep the thread
        println("fake work finished ${Thread.currentThread().name}")
    }
    println("End of program and Thread is ${Thread.currentThread().name}")
}*/


/*
Start of program and Thread is main
fake work starts Thread-0
End of program and Thread is main
fake work finished Thread-0

Process finished with exit code 0 //here exit code 0 means its waiting for background thread to complete and then app got closed */

//End[learning 1]

//Start[learning 2]
/*fun main(){
    println("Start of program and Thread is ${Thread.currentThread().name}")

    GlobalScope.launch {//create a background coroutine that runs on background thread
        println("fake work starts ${Thread.currentThread().name}")
        delay(1000)//
        println("fake work finished ${Thread.currentThread().name}")
    }
    runBlocking {//another coroutine
       delay(2000)
    }
    println("End of program and Thread is ${Thread.currentThread().name}")
}

Start of program and Thread is main
fake work starts DefaultDispatcher-worker-1
fake work finished DefaultDispatcher-worker-1
End of program and Thread is main

Process finished with exit code 0*/
//End[learning 2]

//Start[learning 3]
/*fun main(){
    runBlocking {//here runblocking will run on main thread
        println("Start of program and Thread is ${Thread.currentThread().name}")//main thread

        GlobalScope.launch {//create a background coroutine that runs on background thread
            println("fake work starts ${Thread.currentThread().name}") //background thread
            delay(1000)//
            println("fake work finished ${Thread.currentThread().name}")
        }

        delay(2000) //main thread

        println("End of program and Thread is ${Thread.currentThread().name}")//main thread
    }

}*/
//End [learning 3]

//Start[learning 4]
//kotlin standard way of writing function
/*fun main() = runBlocking {//here runblocking will run on main thread
        println("Start of program and Thread is ${Thread.currentThread().name}")//main thread

        GlobalScope.launch {//create a background coroutine that runs on background thread
            println("fake work starts ${Thread.currentThread().name}") //background thread
            delay(1000)//
            println("fake work finished ${Thread.currentThread().name}")
        }

        delay(2000) //main thread

        println("End of program and Thread is ${Thread.currentThread().name}")//main thread
    }*/
//End [learning 4]

//Start [learning 5]
/*fun main() = runBlocking {//here runblocking will run on main thread
    println("Start of program and Thread is ${Thread.currentThread().name}")//main thread

    GlobalScope.launch {//create a background coroutine that runs on background thread
        println("fake work starts ${Thread.currentThread().name}") //background thread
        mySuspendFunction(1000)
        println("fake work finished ${Thread.currentThread().name}")
    }

    mySuspendFunction(2000) //main thread

    println("End of program and Thread is ${Thread.currentThread().name}")//main thread
}

suspend fun mySuspendFunction(time: Long){ //suspended function with help of suspend keyword
    delay(time)
}*/
//End [learning 5]

//Start [learning 6]
/*fun main() = runBlocking {//here runblocking will run on main thread
    println("Start of program and Thread is ${Thread.currentThread().name}")//main thread

    launch {//run on main thread..because of coroutine property, that coroutine inherit its scope from the scope of immediate inherited coroutine.
        println("fake work starts ${Thread.currentThread().name}") //main thread
        mySuspendFunction(1000)
        println("fake work finished ${Thread.currentThread().name}")//main thread
    }

    mySuspendFunction(2000) //main thread

    println("End of program and Thread is ${Thread.currentThread().name}")//main thread
}

suspend fun mySuspendFunction(time: Long){ //suspended function with help of suspend keyword
    delay(time)
}

Start of program and Thread is main
fake work starts main
fake work finished main
End of program and Thread is main

Process finished with exit code 0*/
//End [learning 6]

//Start [learning 7]

/*fun main() = runBlocking {//here runblocking will run on main thread
    println("Start of program and Thread is ${Thread.currentThread().name}")//main thread

    val job: Job = launch {//run on main thread..because of coroutine property, that coroutine inherit its scope from the scope of immediate inherited coroutine.
        println("fake work starts ${Thread.currentThread().name}") //main thread
        mySuspendFunction(1000)//coroutine is suspended but thread:main is free(not blocked)
        println("fake work finished ${Thread.currentThread().name}")//either main thread or some other thread.
    }

    job.join()
    println("End of program and Thread is ${Thread.currentThread().name}")//main thread
}

suspend fun mySuspendFunction(time: Long){ //suspended function with help of suspend keyword
    delay(time)
}

Start of program and Thread is main
fake work starts main
fake work finished main
End of program and Thread is main

Process finished with exit code 0*/
//End [learning 7]

//start[learning 8]
/*fun main() = runBlocking {//here runblocking will run on main thread
    println("Start of program and Thread is ${Thread.currentThread().name}")//main thread

    val jobDeferred: Deferred<Int> = async {//run on main thread..because of coroutine property, that coroutine inherit its scope from the scope of immediate inherited coroutine.
        println("fake work starts ${Thread.currentThread().name}") //main thread
        mySuspendFunction(1000)//coroutine is suspended but thread:main is free(not blocked)
        println("fake work finished ${Thread.currentThread().name}")//either main thread or some other thread.
        15
    }

    val num:Int = jobDeferred.await()//its a suspended function
    println("End of program and Thread is ${Thread.currentThread().name}")//main thread
}

suspend fun mySuspendFunction(time: Long){ //suspended function with help of suspend keyword
    delay(time)
}*/
//end [learning 8]

//start[learning 9]
/*fun main() = runBlocking {
    println("start of program")
  val job:Job = launch {
      for (i in 1..500){
          print("$i.")
          delay(50)
      }
  }
    println("befor delay method ");
    delay(1000)
    println("after delay method ");
//    job.cancel()
//    job.join()
    //use the combintaion of above two method
    job.cancelAndJoin()

    println("end of program")
}*/
//End[learning 9]

//start[learning 10]
/*fun main() = runBlocking {
    println("start of program")
    val job:Job = launch {
        for (i in 1..500){
            print("$i.")
            yield() //in the above example we were using delay suspended function to cancel the coroutine, but in that u have to give some millisecond value,
            //so better to use yield()
        }
    }
    println("befor delay method ");
    delay(10)
    println("after delay method ");
//    job.cancel()
//    job.join()
    //use the combintaion of above two method
    job.cancelAndJoin()

    println("end of program")
}*/
//End[learning 10]

//start[learning 11]
/*fun main() = runBlocking {
    println("start of program")
    val job:Job = launch(Dispatchers.Default) {//use dispatchers.default here...we will discuss this later
        for (i in 1..500){
            if (!isActive){ //it will check if coroutine job is active or not
//                break
                return@launch
            }
            print("$i.")
            Thread.sleep(10)//just to slow the speed of for loop
        }
    }
    delay(10) //delay the coroutine for 10millisecond before calling the next line of code to execute
    job.cancelAndJoin()
    println("end of program")
}*/
//End[learning 11]

//start[learning 12]
/*fun main() = runBlocking {
    println("start of program")
    val job:Job = launch(Dispatchers.Default) {//use dispatchers.default here...we will discuss this later
        try {
            for (i in 1..500){
                print("$i.")
                delay(10)
            }
        }catch (ex: CancellationException){
            println("exception caught safely")
        }finally {
            println("closed resource in finally")
        }

    }
    delay(100) //delay the coroutine for 10millisecond before calling the next line of code to execute
    job.cancelAndJoin()
    println("end of program")
}*/
//End[learing 12]

//start[learning 13]
/*fun main() = runBlocking {
    println("start of program")
    val job:Job = launch(Dispatchers.Default) {
        try {
            for (i in 1..500){
                print("$i.")
                delay(10)
            }
        }catch (ex: CancellationException){
            println("exception caught safely")
        }finally {
            withContext(NonCancellable){//if u want to use suspended function in finally block create a new coroutine block because old coroutine is already canceled.
                delay(1000)
                println("closed resource in finally")
            }
        }

    }
    delay(100)
    job.cancelAndJoin()
    println("end of program")
}*/
//End [learning 13]

//start[learning 14]
/*fun main() = runBlocking {
    println("start of program")
    val job:Job = launch(Dispatchers.Default) {
        try {
            for (i in 1..500){
                print("$i.")
                delay(10)
            }
        }catch (ex: CancellationException){
            println("exception caught safely ${ex.message}")//pring the reason of cancelation of coroutine
        }finally {
            withContext(NonCancellable){
                delay(1000)
                println("closed resource in finally")
            }
        }

    }
    delay(100)
    job.cancel("My own crash reason")//if u want to give the reason of cancellation
    job.join()
    println("end of program")
}*/
//End [learning 14]

//start[learning 15]
/*fun main() = runBlocking {
    println("start of program")
    val job:Job = launch(Dispatchers.Default) {
        withTimeout(2000){//timeout of coroutine..if u like to use//here using try catch block is neccessary
            try {
                for (i in 1..500){
                    print("$i.")
                    delay(10)
                }
            }catch (ex: CancellationException){
                println("exception caught safely ${ex.message}")
            }finally {
                withContext(NonCancellable){
                    delay(1000)
                    println("closed resource in finally")
                }
            }
        }


    }
    delay(100)
    job.cancel("My own crash reason")
    job.join()
    println("end of program")
}*/
//End [learning 15]

//start[learning 16]
/*fun main() = runBlocking {
    println("start of program")
    val job: Job = launch(Dispatchers.Default) {
        withTimeoutOrNull(2000) {//timeout of coroutine..if u like to use//try catch is not required

            for (i in 1..500) {
                print("$i.")
                delay(10)
            }
        }


    }
    delay(100)
    job.cancel("My own crash reason")
    job.join()
    println("end of program")
}*/
//End[learning 16]

//Start[learning 17]
/*fun main() = runBlocking {
    println("start of program")
    val job: Job = launch(Dispatchers.Default) {
        val result: String? = withTimeoutOrNull(2000) {//

            for (i in 1..500) {
                print("$i.")
                delay(10)
            }
            "I am done"
        }

        println("end of program and result is $result")
    }

}*/
//End [learning 17]

//start[learing 18]
/*fun main() = runBlocking {
    println("start of progaram ${Thread.currentThread().name}")

    val time = measureTimeMillis {//this fun measuretimemillis is used to get the time taken to execute the block of code written inside it.
        val msgOne = getMessageOne()
        val msgTwo = getMessageTwo()//by default method are executed in sequenence
        println("entire msg is ${msgOne + msgTwo}")
    }
    println("time took to run the code is $time")


    println("end of program ${Thread.currentThread().name}")
}

suspend fun getMessageOne(): String{
    delay(1000)
    return "hello"
}
suspend fun getMessageTwo(): String{
    delay(1000)
    return "world"
}*/
//End[learning 18]

//Start[learning 19]
/*fun main() = runBlocking {
    println("start of progaram ${Thread.currentThread().name}")

    val time = measureTimeMillis {
        val msgOne:Deferred<String> = async { getMessageOne() }//concurrent
        val msgTwo:Deferred<String> = async {  getMessageTwo() }//concurrent
        println("entire msg is ${msgOne.await() + msgTwo.await()}")
    }
    println("time took to run the code is $time")


    println("end of program ${Thread.currentThread().name}")
}

suspend fun getMessageOne(): String{
    delay(1000)
    return "hello"
}
suspend fun getMessageTwo(): String{
    delay(1000)
    return "world"
}*/
//End[learning 19]

//Start[learning 20]
/*fun main() = runBlocking {
    println("start of progaram ${Thread.currentThread().name}")

        val msgOne:Deferred<String> = async(start = CoroutineStart.LAZY) { getMessageOne() }//here msgOne is not being used, so no need to run this suspended fun. thats why Lazy is being used to check run the suspend method only if its value being used.
        val msgTwo:Deferred<String> = async(start = CoroutineStart.LAZY) {  getMessageTwo() }//same above statment for this method also
//    println("entire msg is ${msgOne.await() + msgTwo.await()}")
    println("end of program ${Thread.currentThread().name}")
}

suspend fun getMessageOne(): String{
    delay(1000)
    println("after working in getMessageOne")
    return "hello"
}
suspend fun getMessageTwo(): String{
    delay(1000)
    println("after working in getMessageTwo")
    return "world"
}*/
//End[learning 20]

//Start [learning 21]
/*fun main()= runBlocking {
    println("runblocking is $this")

    launch {
        println("launch is $this")
    }
    async {
        println("async is $this")
    }
    println("some code")
}

runblocking is BlockingCoroutine{Active}@5d22bbb7
some code
launch is StandaloneCoroutine{Active}@136432db
async is DeferredCoroutine{Active}@1055e4af*/
//End [learning 21]

//Start[learning 22]
//coroutine context have two important component  job and dispatcher
//dispatcher decides on which thread the coroutine will run
//four types of dispatcher ..Default, Unconfined, Main, IO
fun main() = runBlocking {//thread main
    //coroutineContext: CoroutineContext instance

    //without paramter:Confirmed
    launch {//if there is no parameter in coroutine block then it will inherit its context from immediate parent coroutine...here launch has no paramter
        println("C0: ${Thread.currentThread().name}")//main
        delay(1000)
        println("C1: ${Thread.currentThread().name}")//main
        //in case of no parameter using delay also ....the context will still remain on the immediate parent coroutine context
    }

    //with parameter: Dispatchers.Default[its similar to GlobarScope.launch{} ]
    launch(Dispatchers.Default){
        println("C2: ${Thread.currentThread().name}")// thread T1
        delay(1000)
        println("C3: ${Thread.currentThread().name}")// thread: ? //either on T1 or some other thread depending on thread avaialbiltiy
    }

    //with parameter:Dispatchers.
    launch(Dispatchers.Unconfined) {//for Dispatchers.Unconfined it will take the context of immediate parent coroutine
        println("C4: ${Thread.currentThread().name}")// main
        delay(1000)
        println("C5: ${Thread.currentThread().name}")// thread t2 : here after delay it will not run on main thread, it will run on some other thread

        launch(coroutineContext) {//if the parameter is coroutineContext, then the context is immediate parent coroutine.
            println("C5.1: ${Thread.currentThread().name}")//thread t2 ..because its parent coroutine is on thread t2
            delay(1000)
            println("C5.2: ${Thread.currentThread().name}")//thread t2 because its coroutineContext...it will hold t2
            //in case of coroutineContext using delay also ....the context will still remain on the immediate parent coroutine context
        }
    }

    launch(coroutineContext) {//if the parameter is coroutineContext, then the context is immediate parent coroutine.
        println("C6: ${Thread.currentThread().name}")//main
        delay(1000)
        println("C7: ${Thread.currentThread().name}")//main
        //in case of coroutineContext using delay also ....the context will still remain on the immediate parent coroutine context
    }
    println("program ends")
}

/*/Library/Java/JavaVirtualMachines/jdk-16.0.1.jdk/Contents/Home/bin/java -javaagent:/Applications/IntelliJ IDEA CE.app/Contents/lib/idea_rt.jar=50320:/Applications/IntelliJ IDEA CE.app/Contents/bin -Dfile.encoding=UTF-8 -classpath /Users/smitaen/D drive/KotlinCoroutineLearning/KotlinCoroutine/build/classes/kotlin/main:/Users/smitaen/.gradle/caches/modules-2/files-2.1/org.jetbrains.kotlinx/kotlinx-coroutines-android/1.3.9/df17db5e329363c4e9cc7bf5b661ce3723a3e460/kotlinx-coroutines-android-1.3.9.jar:/Users/smitaen/.gradle/caches/modules-2/files-2.1/org.jetbrains.kotlin/kotlin-stdlib/1.5.10/da6a904b132f0402fa4d79169a3c1770598d4702/kotlin-stdlib-1.5.10.jar:/Users/smitaen/.gradle/caches/modules-2/files-2.1/org.jetbrains/annotations/13.0/919f0dfe192fb4e063e7dacadee7f8bb9a2672a9/annotations-13.0.jar:/Users/smitaen/.gradle/caches/modules-2/files-2.1/org.jetbrains.kotlin/kotlin-stdlib-common/1.5.10/6b84d926e28493be69daf673e40076f89492ef7/kotlin-stdlib-common-1.5.10.jar:/Users/smitaen/.gradle/caches/modules-2/files-2.1/org.jetbrains.kotlinx/kotlinx-coroutines-core-jvm/1.3.9/4be434f5e86c1998a273e7f19a7286440894f0b0/kotlinx-coroutines-core-jvm-1.3.9.jar KotlinCoroutinesKt
C4: main
C2: DefaultDispatcher-worker-1
program ends
C0: main
C6: main
C1: main
C5: kotlinx.coroutines.DefaultExecutor
C7: main
C5.1: kotlinx.coroutines.DefaultExecutor
C3: DefaultDispatcher-worker-1
C5.2: kotlinx.coroutines.DefaultExecutor

Process finished with exit code 0*/

//End[learning 22]






