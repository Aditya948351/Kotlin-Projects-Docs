
<h1 align="center">⭐1. More Kotlin Fundamenttals⭐</h1>

<h1>⭐1. Introduction</h1>
This codelab exposes you to several Kotlin concepts that help you structure larger apps:
<ul>
  <li>1. Generics</li>
  <li>2. Different kinds of classes (enum classes and data classes)</li>
  <li>3. Singleton and companion objects</li>
  <li>4. Extension properties and functions</li>
  <li>5. Scope Functions</li>
</ul>

<h2>What you'll learn</h2>
<ul>
  <li>How to define a generic type parameter for a class.</li>
  <li>How to instantiate a generic class.</li>
  <li>When to use enum and data classes.</li>
  <li>How to define a generic type parameter that must implement an interface.</li>
  <li>How to use scope functions to access class properties and methods.</li>
  <li>How to define singleton objects and companion objects for a class.</li>
  <li>How to extend existing classes with new properties and methods.</li>
</ul>

---

<h1>⭐2. Make a reasonable class with generics.</h1>
<ul>
  <p>🌟Let's say you are planning a Quizz App which invoves following Questions.</p>
  <li>Fill-in-the-blank question: The answer is a word represented by a <code>String</code>.</li>
  <li>True or false question: The answer is represented by a <code>Boolean</code>.</li>
  <li>Math problems: The answer is a numeric value. The answer for a simple arithmetic problem is represented by an <code>Int</code>.</li>
  <p>In Addition, Quizz question will also have difficulty rating like in String as 'easy','medium','hard'.</p>
</ul>
<strong>Now,Define classes to represent each type of quiz question:</strong>
<ul>
  <li>1. Navigate to <a href = "https://play.kotlinlang.org/"/>Kotlin Playground</a> to practice Kotlin Language on Web based IDE</li>
  <li>2. In Kotlin Playground, create three classes named <code>FillInTheBlankQuestion</code>,<code>TrueOrFalseQuestion</code><code>NumericQuestion</code></li>
  <li>3. Your code should be like this with answertext as String for FillInTheBlankQuestion,<code>Boolean</code> for TrueOrFalseQuestion,<code>Int</code> for NumericQuestion:</li>
  
```kotlin
class FillInTheBlankQuestion(
    val questionText: String,
    val answer: String,
    val difficulty: String
)

class TrueOrFalseQuestion(
    val questionText: String,
    val answer: Boolean,
    val difficulty: String
)

class NumericQuestion(
    val questionText: String,
    val answer: Int,
    val difficulty: String
)
```
</ul>
<ul> <li> <p>The only difference in all classes is the data type of the <code>answer</code> (<code>String</code>, <code>Boolean</code>, <code>Int</code>).</p> </li> <li> <p>You might think of using <strong>inheritance</strong> — creating a parent class for shared properties.</p> </li> <li> <p><strong>But that doesn't work well here because:</strong></p> <ul> <li>You still need to define a separate <code>answer</code> in each subclass.</li> <li>It’s awkward to have a parent class without an <code>answer</code> property.</li> </ul> </li> <li> <p>🔁 <strong>Instead of inheritance, use <code>generics</code> in Kotlin:</strong></p> </li> <li> <p><code>Generics</code> let you create one class where the <code>answer</code> can be any data type.</p> </li> <li> <p>This makes your code <strong>simpler, cleaner, and easier to manage</strong>.</p> </li> <li> <p>✅ So, one <code>Question&lt;T&gt;</code> class works for any type of question.</p> </li> </ul>


<h2>🤔So,What is Generic Datatype?</h2>
<ul>
  <p><strong>Generic types</strong> let you use a placeholder for a data type. Instead of creating different classes for each data type (like <code>String</code>, <code>Int</code>, or <code>Boolean</code>), you use a single class with a type parameter like <code>&lt;T&gt;</code>.</p>
</ul>

<h3>📝 Notes</h3>
<ul> <li>Generics make code reusable and reduce duplication.</li> <li><code>T</code> is the placeholder for any data type (you can also use other letters or names).</li> <li>Data type is decided when the class is instantiated.</li> </ul>

<h3>⚙️ Steps to Refactor Using Generics</h3>
<ol> <li><strong>Remove</strong> the separate classes: <ul> <li><code>FillInTheBlankQuestion</code></li> <li><code>TrueOrFalseQuestion</code></li> <li><code>NumericQuestion</code></li> </ul> </li> <li><strong>Create</strong> a generic class named <code>Question</code> with a type parameter <code>&lt;T&gt;</code>.</li> <li><strong>Add</strong> properties: <code>questionText: String</code>, <code>answer: T</code>, <code>difficulty: String</code>.</li> <li><strong>Use</strong> the class with different data types when creating objects.</li> </ol>

<strong>Your code will look like this : </strong>

```kotlin
class Question<T>(
    val questionText: String,
    val answer: T,
    val difficulty: String
)
fun main() {
    println("Hello, world!!!")
}
```

<p><strong>Modify the main function as : </strong></p>
<ul>
  <code>val instance name = class name &lt; generic datatypes &gt; (parameters) </code>
</ul>

```kotlin
class Question<T>(
    val questionText: String,
    val answer: T,
    val difficulty: String
)
fun main() {
    val question1 = Question<String>("Quoth the raven ___", "nevermore", "medium")
    val question2 = Question<Boolean>("The sky is green. True or false", false, "easy")
    val question3 = Question<Int>("How many days are there between full moons?", 28, "hard")
}
```
<ul>
<li>4. Run your code to make sure everything works. You should now have three instances of the Question class—each with different data types for the answer—instead of three different classes, or instead of using inheritance. If you want to handle questions with a different answer type, you can reuse the same Question class.</li>
</ul>

---

<h1>⭐3. Use an Enum Class.</h1>

In previous part, we used a String to represent difficulty:

```kotlin
val difficulty = "medium"
```
While this technically works, it has several downsides:

<ul> <li><strong>Prone to typos:</strong> e.g., <code>"medum"</code> instead of <code>"medium"</code></li> <li><strong>Hard to refactor:</strong> Renaming requires global changes</li> <li><strong>No type safety:</strong> Any string can be used mistakenly</li> <li><strong>Maintenance issues:</strong> Becomes unscalable with more levels</li> </ul>
<h3>💡 Solution: Use Kotlin’s <code>enum class</code></h3>
Enums are used when a property should be limited to a fixed set of values. They're ideal for improving <strong>type safety</strong>, <strong>readability</strong>, and <strong>maintainability</strong>.

<h3>🧱 Define the <code>enum class</code></h3>

```kotlin
enum class Difficulty {
    EASY, MEDIUM, HARD
}
```
<ul> <li>Constants should be in <strong>UPPERCASE</strong> (Kotlin convention)</li> <li>Use <code>Difficulty.EASY</code>, <code>Difficulty.MEDIUM</code>, etc., to access values</li> </ul>
<h3>🧩 Update the <code>Question</code> Class</h3>
Change the difficulty property type from String to Difficulty enum:

```kotlin
class Question<T>(
    val questionText: String,
    val answer: T,
    val difficulty: Difficulty
)
``` 
<h3>🛠️ Instantiate with Enum Constants</h3>
Replace string literals with enum constants:

```kotlin
val question1 = Question<String>("Quoth the raven ___", "nevermore", Difficulty.MEDIUM)
val question2 = Question<Boolean>("The sky is green. True or false", false, Difficulty.EASY)
val question3 = Question<Int>("How many days are there between full moons?", 28, Difficulty.HARD)
```
<h3>✅ Benefits of Using Enum</h3>
<ul> <li>🔐 <strong>Compile-time validation</strong></li> <li>🛠️ <strong>Easy to rename/refactor</strong></li> <li>🧼 <strong>Cleaner and self-explanatory</strong></li> <li>📈 <strong>Scales well with new difficulty levels</strong></li> </ul>
💡 <strong>Pro Tip:</strong> Enum classes in Kotlin can also have <em>properties</em> and <em>functions</em>. Perfect for assigning weight or metadata to each level.

---

<h1>⭐4. Use a Data Class.</h1>

<li><strong>Classes like the Question class, on the other hand, only contain data. They don't have any methods that perform an action. These can be defined as a Data class.</strong></li>
<li><strong>Defining a class as a data class allows the Kotlin compiler to make certain assumptions, and to automatically implement some methods.</strong></li>
<ul>
  <p>Data Class can be defined as :</p>
  <code>data class Classname</code>
</ul>
<h3>Convert <code>Question</code> to a Data class with steps.</h3>
<ul>
  <li>1. In <code>main()</code>, print the result of calling <code>toString()</code> on <code>question1</code>.</li>
  
  ```kotlin
  fun main() {
    val question1 = Question<String>("Quoth the raven ___", "nevermore", Difficulty.MEDIUM)
    val question2 = Question<Boolean>("The sky is green. True or false", false, Difficulty.EASY)
    val question3 = Question<Int>("How many days are there between full moons?", 28, Difficulty.HARD)
    println(question1.toString())
}
  ```
  <li>2. Run your code. The output only shows the class name and a unique identifier for the object.</li>
  <code><strong>Question@37f8bb67</strong></code>

  <li>3. Make <code>Question</code> into a data class using the <code>data</code> keyword.</li>
  
  ```kotlin
``data class Question<T> (
    val questionText: String,
    val answer: T,
    val difficulty: Difficulty
  )
  ```
  <li>4. Now, Run the Code.</li>

  <p>When a class is defined as a data class, the following methods are implemented.<p>
  <ul>
    <li>equals()</li>
    <li>hashCode(): you'll see this method when working with certain collection types</li>
    <li>toString()</li>
    <li>componentN(): component1(), component2(), etc.</li>
    <li>copy()</li>
  </ul>
   <h2>Note: A data class needs to have at least one parameter in its constructor, and all constructor parameters must be marked with val or var. A data class also cannot be abstract, open, sealed, or inner.</h2>
</ul>

---

<h1>⭐5. Use a Singleton Set and Companion Object.</h1>
<h2>✅ What is a Singleton?</h2> <p>A <strong>singleton</strong> is a special kind of object that is designed to have only one instance in the system. Kotlin makes creating singleton objects very straightforward using the <code>object</code> keyword.</p> <h3>💼 Use Cases of Singleton:</h3> <ul> <li>Managing <strong>user session or authentication</strong></li> <li>Accessing a <strong>single hardware resource</strong> (e.g., speaker, camera)</li> <li>Storing <strong>shared data</strong> like app-wide stats or settings</li> <li>Fetching/storing data using APIs like <strong>Firebase</strong> or local storage</li> </ul>
<h2>🛠 How to Define a Singleton Object</h2> 

```kotlin
object StudentProgress {
  var total: Int = 10
  var answered: Int = 3
}
```
<p>This defines a <code>StudentProgress</code> object with two properties. Since it's an <code>object</code>, only one instance will exist — always.</p>
<h2>🎯 Accessing Singleton Properties</h2> <p>You don’t need to create an object instance. You simply access its properties like this:</p> 

```kotlin
fun main() {
 println("${StudentProgress.answered} of ${StudentProgress.total} answered.")
}
```
<h3>✅ Output:</h3> <pre><code> 3 of 10 answered. </code></pre>
<h2>🔄 Making It More Organized Using <code>companion object</code></h2> <h3>🤔 Why Companion Object?</h3> <p>When the singleton logic is directly related to a class, it makes sense to encapsulate it within that class. This helps in better organization and improves readability. Kotlin supports this via the <strong>companion object</strong>.</p> <h3>👇 Here's how to implement it:</h3> <h4>Step 1: Define a Class</h4> 

```kotlin
class Quiz {
  val question1 = Question<String>("Quoth the raven ___", "nevermore", Difficulty.MEDIUM)
  val question2 = Question<Boolean>("The sky is green. True or false", false, Difficulty.EASY)
  val question3 = Question<Int>("How many days are there between full moons?", 28, Difficulty.HARD)
  companion object StudentProgress {
    var total: Int = 10
    var answered: Int = 3
  }
}
```
<h4>Step 2: Access Companion Object Properties</h4> <p>Since <code>StudentProgress</code> is now a companion object of <code>Quiz</code>, you can directly access its properties through the class name.</p>

```kotlin
fun main() {
  println("${Quiz.answered} of ${Quiz.total} answered.")
}
```
<h3>✅ Output:</h3> <pre><code> 3 of 10 answered. </code></pre>
<h2>✅ Best Practices</h2> <ul> <li>Use <strong><code>object</code></strong> when you need a truly global singleton (e.g., logging, analytics, network manager).</li> <li>Use <strong><code>companion object</code></strong> when you want class-related static behavior (e.g., constants, factories).</li> </ul>
<h2>📌 Final Thoughts</h2> <p>Understanding the concept of <strong>singleton</strong> and <strong>companion object</strong> in Kotlin helps you write efficient, bug-free, and maintainable code. These constructs are widely used in real-world Android development and system-level architecture.</p>

---

<h1>⭐6. Extending Classes with New Properties and Methods</h1>
<h2>💡 Why Extend Classes?</h2>
<p>When building Android apps using Jetpack Compose, you often encounter expressions like <code>16.dp</code> or <code>12.sp</code>. These aren't native properties of numbers—they're **extension properties** added to Kotlin's numeric types.</p> <p>This approach allows developers to add meaningful, readable functionality to existing types—without modifying their source code.</p>
<h2>📌 What Are Extension Properties?</h2>
<p><strong>Extension properties</strong> allow you to add custom properties to existing classes. They’re especially useful when working with SDK classes you can’t edit directly. However, keep in mind:</p> <ul> <li>They are read-only (must use <code>get()</code>).</li> <li>They cannot store state.</li> </ul>
<h3>🧪 Example: StudentProgress Extension Property</h3>
<p>Let’s say we have a singleton object inside a class that tracks a student’s quiz progress. We want to add a human-readable text for the progress.</p>

```kotlin

val Quiz.StudentProgress.progressText: String
    get() = "$answered of $total answered"
```
<h2>🛠 Accessing the Extension Property</h2>
<p>Since <code>StudentProgress</code> is a <code>companion object</code> inside the <code>Quiz</code> class, we can access this property like this:</p>

```kotlin
fun main() {
    println(Quiz.progressText)
}
```

<h3>Output : </h3>
<blockquote>
<p>▓▓▓▒▒▒▒▒▒▒</p>
<p>3 of 10 answered</p>
</blockquote>
<h2>🔧 Extension Function Example</h2>
<p>Let's define a <strong>retro-style text progress bar</strong> using an extension function on <code>StudentProgress</code>.</p>
<h3>📄 Full Extension Function Code</h3>

```kotlin

fun Quiz.StudentProgress.printProgressBar() {
    repeat(answered) { print("▓") }                       // Dark bar for answered questions
    repeat(total - answered) { print("▒") }               // Light bar for remaining questions
    println()
    println(progressText)                                 // Using our extension property
}
```

<h2>🏁 Final Code</h2>

```kotlin
data class Question<T>(
    val questionText: String,
    val answer: T,
    val difficulty: Difficulty
)

enum class Difficulty {
    EASY, MEDIUM, HARD
}

class Quiz {
    val question1 = Question("Quoth the raven ___", "nevermore", Difficulty.EASY)
    val question2 = Question("The sky is green. True or false", false, Difficulty.MEDIUM)
    val question3 = Question("How many days are there between full moons?", 28, Difficulty.HARD)

    companion object StudentProgress {
        var total: Int = 10
        var answered: Int = 3
    }
}

// Extension property
val Quiz.StudentProgress.progressText: String
    get() = "$answered of $total answered"

// Extension function
fun Quiz.StudentProgress.printProgressBar() {
    repeat(answered) { print("▓") }
    repeat(total - answered) { print("▒") }
    println()
    println(progressText)
}

fun main() {
    Quiz.printProgressBar()
}
```

<h3>Output : </h3>
<blockquote>
<p>▓▓▓▒▒▒▒▒▒▒</p>
<p>3 of 10 answered</p>
</blockquote>
<h2>📈 Why Use Extensions?</h2>
<ul> <li>Cleaner and more intuitive syntax</li> <li>No need to clutter original class definitions</li> <li>Ideal for utility-style functionality</li> <li>Helps create readable and scalable UI logic (like Compose's <code>16.dp</code>)</li> </ul>


---

<h1>⭐ 7. Rewriting Extension Functions Using Interfaces</h1> <h2>🔁 Why Move from Extensions to Interfaces?</h2> <p>While extension functions and properties are great for **adding features without touching the original class**, they fall short when:</p> <ul> <li>Multiple classes need the same behavior.</li> <li>You want to enforce implementation.</li> <li>You control the class source code and want tighter structure.</li> </ul> <p>In such cases, <strong>interfaces</strong> help you enforce consistency and reuse functionality across unrelated classes—like <code>Quiz</code>, <code>Survey</code>, or <code>RecipeStep</code>—which all might have <em>progress</em>.</p>
<h2>📦 Define the Interface</h2> <p>We’ll create a contract interface named <strong>ProgressPrintable</strong> for any class that needs to print a progress bar.</p>

```kotlin
interface ProgressPrintable {
    val progressText: String
    fun printProgressBar()
}
```
<h2>🧩 Update the <code>Quiz</code> Class</h2> <p>Now, let’s make <code>Quiz</code> implement this interface.</p>

```kotlin
class Quiz : ProgressPrintable {
    val question1 = Question("Quoth the raven ___", "nevermore", Difficulty.EASY)
    val question2 = Question("The sky is green. True or false", false, Difficulty.MEDIUM)
    val question3 = Question("How many days are there between full moons?", 28, Difficulty.HARD)
    var total: Int = 10
    var answered: Int = 3

    override val progressText: String
        get() = "$answered of $total answered"

    override fun printProgressBar() {
        repeat(answered) { print("▓") }
        repeat(total - answered) { print("▒") }
        println()
        println(progressText)
    }
}
```
<h3>🧹 Clean Up Old Code</h3> <p>✅ Remove the following since logic now lives inside the class:</p> <ul> <li><code>val Quiz.StudentProgress.progressText</code> (extension property)</li> <li><code>fun Quiz.StudentProgress.printProgressBar()</code> (extension function)</li> </ul>
<h2>🧪 Testing with <code>main()</code></h2>

```kotlin
fun main() {
    Quiz().printProgressBar()
}
```
<h3>📤 Output:</h3> <blockquote> <p>▓▓▓▒▒▒▒▒▒▒</p> <p>3 of 10 answered</p> </blockquote>
<h2>🔍 Why Interfaces Matter</h2> <p><strong>Interfaces provide structure and flexibility.</strong> Here’s how:</p> <ul> <li><strong>Code reuse</strong> without inheritance</li> <li><strong>Cleaner separation</strong> of concerns</li> <li><strong>Scalability</strong> across unrelated data types</li> <li><strong>Mocking and testing</strong> via dependency injection</li> </ul>
<h2>🏁 Final Code Summary</h2>

```kotlin
data class Question<T>(
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
    val question1 = Question("Quoth the raven ___", "nevermore", Difficulty.EASY)
    val question2 = Question("The sky is green. True or false", false, Difficulty.MEDIUM)
    val question3 = Question("How many days are there between full moons?", 28, Difficulty.HARD)
    var total: Int = 10
    var answered: Int = 3
    override val progressText: String
        get() = "$answered of $total answered"
    override fun printProgressBar() {
        repeat(answered) { print("▓") }
        repeat(total - answered) { print("▒") }
        println()
        println(progressText)
    }
}
fun main() {
    Quiz().printProgressBar()
}
```

<h2>🧠 Future Use Cases</h2> <ul> <li><strong>Dependency Injection</strong>: Interfaces allow for loosely-coupled implementations.</li> <li><strong>Mocking for Testing</strong>: Swap real objects with test doubles.</li> <li><strong>Multiplatform Compose</strong>: Share behavior between Android/Desktop implementations.</li> <li><strong>Composable Design</strong>: Like <code>Modifier</code> in Compose, interfaces power extensibility.</li> </ul>

---

<h1>⭐ 8. Use Scope Functions to Access Class Properties and Methods</h1>

<h2>🎯 What Are Scope Functions?</h2> <p>Scope functions in Kotlin are <strong>higher-order functions</strong> that allow you to access an object’s members (properties/methods) concisely and cleanly within a lambda block.</p> <p>They reduce boilerplate by eliminating the need to repeatedly reference an object’s name.</p> <h3>📌 Common Scope Functions:</h3> <ul> <li><code>let</code> — use <code>it</code> to reference the object</li> <li><code>apply</code> — use <code>this</code> implicitly to configure/initiate objects</li> </ul>
<h2>📘 Use Case 1: Replacing Repetitive References with <code>let()</code></h2> <h3>🎯 Objective:</h3> <p>Use <code>let</code> to clean up verbose references when printing quiz questions.</p>
🛠 Step-by-Step:
✅ Step 1: Add printQuiz() to Quiz Class

```kotlin
fun printQuiz() {
    println(question1.questionText)
    println(question1.answer)
    println(question1.difficulty)
    println()
    println(question2.questionText)
    println(question2.answer)
    println(question2.difficulty)
    println()
    println(question3.questionText)
    println(question3.answer)
    println(question3.difficulty)
    println()
}
```

⚡ Replace With let() for Cleaner Code

```kotlin

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
```
✅ Advantage: No need to repeatedly write question1, question2, etc. It scales better and reduces refactor headaches.

<h2>📘 Use Case 2: Instantiating & Using Objects with <code>apply()</code></h2> <h3>🎯 Objective:</h3> <p>Use <code>apply()</code> to initialize and call methods without explicitly assigning to a variable.</p>
🛠 Step-by-Step:
❌ Old Way (Verbose):

```kotlin
fun main() {
    val quiz = Quiz()
    quiz.printQuiz()
}
```
✅ New Way With apply():

```kotlin
fun main() {
    Quiz().apply {
        printQuiz()
    }
}
```
✅ Advantage: No variable assignment needed, yet you can initialize or configure the object directly.

<h2>📤 Expected Output:</h2>

```output
Quoth the raven ___
nevermore
EASY

The sky is green. True or false
false
MEDIUM

How many days are there between full moons?
28
HARD
```
<h2>🧠 When to Use Which?</h2>
Function	Use Case
let	When you want to operate on an object as it, and maybe return a different result
apply	When initializing/configuring an object using this, usually for builders or configuration blocks

<h2>🧭 Summary: Final Code Structure</h2>

```kotlin
data class Question<T>(
    val questionText: String,
    val answer: T,
    val difficulty: Difficulty
)

enum class Difficulty {
    EASY, MEDIUM, HARD
}

class Quiz {
    val question1 = Question("Quoth the raven ___", "nevermore", Difficulty.EASY)
    val question2 = Question("The sky is green. True or false", false, Difficulty.MEDIUM)
    val question3 = Question("How many days are there between full moons?", 28, Difficulty.HARD)

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
}
fun main() {
    Quiz().apply {
        printQuiz()
    }
}
```
<h2>📚 Tip for Developers</h2> <p>As you advance in Jetpack Compose and Android app development, you'll frequently encounter scope functions in ViewModels, Repositories, Composables, and Builders. Mastering their behavior will lead to cleaner, more idiomatic Kotlin code.</p>
