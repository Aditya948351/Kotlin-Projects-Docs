<h1>Use Collections and Ordered Functions in Jetpack Compose</h1>

```kotlin
/*data class Question<T>(
    val questionText: String,
    val answer: T,
    val difficulty: Difficulty
)

enum class Difficulty {
   EASY, MEDIUM, HARD
}

interface ProgressPrintable {
    val progressText: String
    fun printProgressBar()
}

class Quiz : ProgressPrintable {
    val question1 = Question<String>("Quoth the raven ___", "nevermore", Difficulty.EASY)
    val question2 = Question<Boolean>("The sky is green. True or false", false, Difficulty.MEDIUM)
    val question3 = Question<Int>("How many days are there between full moons?", 28, Difficulty.HARD)
    
    fun printQuiz() {
        question1.let {
        	println(it.questionText)
    		println(it.answer)
    		println(it.difficulty)
        }    
    	println()
    	question2.let {
        	println(it.questionText)
    		println(it.answer)
    		println(it.difficulty)
        }
    	println()
    	question3.let {
        	println(it.questionText)
    		println(it.answer)
    		println(it.difficulty)
        }
    	println()
    }
    
    override val progressText : String
    	get() = "{answered} of {total} answered"
    
    override fun printProgressBar() {
        repeat(Quiz.answered) { print("▓") }
    	repeat(Quiz.total - Quiz.answered) { print("▒") }
    	println()
     
    }
   
    
    companion object StudentProgress {
		var total: Int = 10
    	var answered: Int = 6
    }
}
*/
/*fun main() {
    val rockPlanets = arrayOf<String>("Mercury","Venus","Earth","Mars")
	val gasPlanets = arrayOf("Jupiter","Saturn","Uranus","Neptune")
	val solarSystem = rockPlanets + gasPlanets
    println(rockPlanets[1])
    rockPlanets[1]="Pluto"
    println(rockPlanets[1])
    
}
*/
/*
fun main() {
    val Avengers = listOf("Iron Man","Vision","Thor","Wanda","Valkayrie","Captain America")
    val WB = mutableListOf("Harry","Hermoine","Ron","Ginny","Neville","Dumbledore","Snape","Tom")
    println(Avengers[2])
    println(Avengers.size)
    println(Avengers.indexOf("Thanos"))
    for (planet in Avengers) {
        println(planet)
    }
    println(WB.size)
    WB.add("Voldemort")
    
    println(WB.size)
    
    WB.add(3, "Dobby")
    
    println(WB.size)
    WB.removeAt(3)
    for (Hogwarts in WB) {
        println(Hogwarts)
    }
    println(WB.size)
    WB.remove("Voldemort")
    println(WB.size)
    WB.contains("Voldemort")
} */


/*
fun main() {
    val solarSystem = mutableSetOf("Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune")
    println(solarSystem.size)
    println(solarSystem.contains("Pluto"))
    solarSystem.add("Pluto")
    println(solarSystem.contains("Pluto"))
    solarSystem.remove("Pluto")
} */

/*
fun main() {
    val solarSystem = mutableMapOf(
    	"Mercury" to 0,
        "Venus" to 0,
    	"Earth" to 1,
    	"Mars" to 2,
    	"Jupiter" to 79,
    	"Saturn" to 82,
    	"Uranus" to 27,
    	"Neptune" to 14
    )
    println(solarSystem.size)
    solarSystem["Pluto"] = 5
    println(solarSystem.size)    //get the size of the Map
    println(solarSystem["Pluto"])    //get a value
    println(solarSystem.get("Pluto"))   //if not present element get then returns null.
    solarSystem.remove("Pluto")
    println(solarSystem.size)
    
    println(solarSystem["Jupiter"])
    solarSystem["Jupiter"] = 78
	println(solarSystem["Jupiter"])
}
*/



//This is of third part


class Cookie (
	val name : String,
    val softBaked : Boolean,
    val hasFilling : Boolean,
    val price : Double
)
val cookies = listOf(
	Cookie(
        name = "Chocolate Chip",
        softBaked = false,
        hasFilling = false,
        price = 1.69
    ),
    Cookie(
        name = "Banana Walnut", 
        softBaked = true, 
        hasFilling = false, 
        price = 1.49
    ),
    Cookie(
        name = "Vanilla Creme",
        softBaked = false,
        hasFilling = true,
        price = 1.59
    ),
    Cookie(
        name = "Chocolate Peanut Butter",
        softBaked = false,
        hasFilling = true,
        price = 1.49
    ),
    Cookie(
        name = "Snickerdoodle",
        softBaked = true,
        hasFilling = false,
        price = 1.39
    ),
    Cookie(
        name = "Blueberry Tart",
        softBaked = true,
        hasFilling = true,
        price = 1.79
    ),
    Cookie(
        name = "Sugar and Sprinkles",
        softBaked = false,
        hasFilling = false,
        price = 1.39
    )
)

fun main() {
    /*cookies.forEach {
        println("Menu item: ${it.name}")
    }
    */
    val fullMenu = cookies.map {
        "${it.name} - $${it.price}"        
    }
    println("Full Menu:")
    fullMenu.forEach {
        println(it)
    }
    /*
    val softBakedMenu = cookies.filter {
        it.softBaked
        
    }
    println("Soft cookies:")
        softBakedMenu.forEach {
            println("${it.name} - $${it.price}")
        }
        */
    val groupedMenu = cookies.groupBy{ it.softBaked }
    val softBakedMenu = groupedMenu[true] ?: listOf()
    val crunchyMenu = groupedMenu[false] ?: listOf()
    println()
    println("Soft cookies:")
	softBakedMenu.forEach {
    	println("${it.name} - $${it.price}")
	}
    println()
    println("Crunchy Cookies:")
    crunchyMenu.forEach {
        println("${it.name} - $${it.price}")
    }
    println()
    val totalPrice = cookies.fold(0.0) { total, cookie -> 
        total + cookie.price
    }
    println("Total Price: $${totalPrice}")
    println()
    val alphabeticalMenu = cookies.sortedBy {
		it.price
    }
    println("Alphabetical Menu: ")
    alphabeticalMenu.forEach {
        println(it.name)
    }
}
```
