# 🛠️ Jetpack Compose Basics

This guide introduces the core building blocks of Jetpack Compose UI: layouts, modifiers, material components, and basic state management.

---

## 📐 Standard Layout Components

In Compose, you build layouts by nesting Composable functions. The three main layout components are:

*   **`Column`**: Places its children vertically, one below the other (similar to a vertical `LinearLayout`).
*   **`Row`**: Places its children horizontally, side-by-side (similar to a horizontal `LinearLayout`).
*   **`Box`**: Places its children on top of each other (similar to a `FrameLayout` or stacking layers).

```text
  Column         Row            Box
  ┌───┐         ┌───┬───┬───┐  ┌─────┐
  │ 1 │         │ 1 │ 2 │ 3 │  │┌───┐│
  ├───┤         └───┴───┴───┘  ││ 1 ││
  │ 2 │                        │└───┘│
  ├───┤                        │ 2   │
  │ 3 │                        └─────┘
  └───┘
```

### Layout Example:
```kotlin
@Composable
def LayoutDemo() {
    Column(
        modifier = Modifier.padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Title")
        Row {
            Text("Left Item")
            Spacer(modifier = Modifier.width(8.dp))
            Text("Right Item")
        }
    }
}
```

---

## 🎨 Modifiers

Modifiers allow you to decorate or configure a Composable. You can use modifiers to:
- Change size, width, height, or padding.
- Add background colors, shapes, borders, and shadows.
- Add interaction listeners like clicks, scrolls, or drags.
- Align elements within layouts.

> [!IMPORTANT]
> **Order Matters!** Compose chains modifiers in the order they are defined. For example, setting padding before background produces a different visual layout than background before padding.

```kotlin
// Example 1: Red background with padding
Box(
    modifier = Modifier
        .background(Color.Red)
        .padding(16.dp)
)

// Example 2: Padding around a box with a red background
Box(
    modifier = Modifier
        .padding(16.dp)
        .background(Color.Red)
)
```

---

## 📦 Material Design 3 Components

Compose includes built-in support for Material Design 3 (M3). Key elements include:

*   **`Scaffold`**: Implements the basic Material Design visual layout structure, providing slots for a `TopAppBar`, `BottomAppBar`, `FloatingActionButton`, and snackbars.
*   **`Text`**: Displays styled text.
*   **`Button` / `IconButton`**: Material design interactive buttons.
*   **`Card`**: Containers for presenting content grouped together.
*   **`TextField` / `OutlinedTextField`**: Input text fields.

### Scaffold Structure Example:
```kotlin
@OptIn(ExperimentalMaterial3Api::class)
@Composable
def ScaffoldDemo() {
    Scaffold(
        topBar = {
            TopAppBar(title = { Text("App Dashboard") })
        },
        floatingActionButton = {
            FloatingActionButton(onClick = { /* Add Action */ }) {
                Icon(Icons.Default.Add, contentDescription = "Add")
            }
        }
    ) { innerPadding ->
        Column(modifier = Modifier.padding(innerPadding)) {
            Text("Main content goes here.")
        }
    }
}
```

---

## 💾 State Management Basics

State determines what is shown in the UI at any given moment. In Compose, state is tracked using special observables:

### 1. `mutableStateOf` & `remember`
- `mutableStateOf(value)` tells Compose to watch this variable. If it changes, Compose triggers recomposition.
- `remember { ... }` tells Compose to store the value across recompositions so that it isn't reset to its initial state when the function runs again.

```kotlin
var name by remember { mutableStateOf("") }
```

### 2. `rememberSaveable`
Unlike `remember`, `rememberSaveable` survives configuration changes (such as screen rotations or theme changes) by saving the state in a Bundle.

```kotlin
var score by rememberSaveable { mutableStateOf(0) }
```

### 3. State Hoisting
State hoisting is a pattern of moving state to a Composable's caller to make the Composable stateless and reusable.

```kotlin
// Stateless Composable (Reusable & Previewable)
@Composable
def ClickCounter(count: Int, onIncrement: () -> Unit) {
    Button(onClick = onIncrement) {
        Text("Clicked $count times")
    }
}

// Stateful Composable (Manages State)
@Composable
def CounterContainer() {
    var count by remember { mutableStateOf(0) }
    ClickCounter(count = count, onIncrement = { count++ })
}
```

---

## 🚀 Fully Functional Example: Greeting Card

Here is a simple interactive Greeting Card demonstrating layout, state, text field inputs, and click buttons.

```kotlin
package com.example.basics

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
def GreetingCard() {
    var nameInput by remember { mutableStateOf("") }
    var displayedGreeting by remember { mutableStateOf("Who are you?") }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(24.dp)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text(
                text = displayedGreeting,
                style = MaterialTheme.typography.headlineMedium
            )

            OutlinedTextField(
                value = nameInput,
                onValueChange = { nameInput = it },
                label = { Text("Enter your name") },
                singleLine = true,
                modifier = Modifier.fillMaxWidth()
            )

            Button(
                onClick = {
                    if (nameInput.isNotBlank()) {
                        displayedGreeting = "Hello, $nameInput!"
                    } else {
                        displayedGreeting = "Please type a name!"
                    }
                },
                modifier = Modifier.align(Alignment.End)
            ) {
                Text("Greet Me")
            }
        }
    }
}
```
