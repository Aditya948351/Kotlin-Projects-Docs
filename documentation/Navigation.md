# 🗺️ Navigation in Jetpack Compose

This guide outlines how to handle multi-screen architectures and screen-to-screen navigation in Jetpack Compose using the Jetpack Navigation component.

---

## 🏗️ Core Navigation Concepts

The Jetpack Navigation Compose library is built around three main components:

1.  **`NavController`**: The central coordinator that keeps track of the back stack of screens and lets you navigate forward, backward, or reset the navigation history.
2.  **`NavHost`**: A container Composable that displays the current screen destination. It links the `NavController` with a navigation graph.
3.  **Navigation Graph (Graph)**: A mapping of routes to specific Composable destinations.

---

## 🛠️ Dependency Setup

To use Navigation in Jetpack Compose, add the following dependency to your application's `build.gradle.kts` file:

```kotlin
dependencies {
    implementation("androidx.navigation:navigation-compose:2.7.7") // Use the latest stable version
}
```

---

## 🚦 Basic Navigation Graph Setup

To set up navigation, instantiate a `NavController` using `rememberNavController()`, and define a `NavHost` with a starting destination:

```kotlin
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
def AppNavigation() {
    // 1. Create the NavController
    val navController = rememberNavController()

    // 2. Define the NavHost container
    NavHost(
        navController = navController,
        startDestination = "home" // Start route
    ) {
        // 3. Register destinations
        composable("home") { HomeScreen(onNavigateToDetails = { navController.navigate("details") }) }
        composable("details") { DetailsScreen(onBack = { navController.popBackStack() }) }
    }
}
```

---

## 📦 Passing Arguments Between Screens

Often you need to pass data (like an ID, username, or boolean toggle) from one screen to another. This is done by appending parameters directly into the route path.

### 1. Define the Route with Arguments
Define the route string using path variables, like `"details/{itemId}"`. You must also define a list of `arguments` for the destination:

```kotlin
import androidx.navigation.NavType
import androidx.navigation.navArgument

composable(
    route = "details/{itemId}",
    arguments = listOf(navArgument("itemId") { type = NavType.StringType })
) { backStackEntry ->
    // Extract the parameter from the backstack entry arguments
    val itemId = backStackEntry.arguments?.getString("itemId") ?: "default"
    DetailsScreen(itemId = itemId)
}
```

### 2. Navigate and Pass the Value
To trigger navigation with the argument, construct the path dynamically:

```kotlin
val itemIdToSend = "1024"
navController.navigate("details/$itemIdToSend")
```

---

## 🔒 Type-Safe Navigation with Sealed Classes

Using raw strings for routes can lead to typos and runtime crashes. A common best practice is to structure routes using sealed classes/objects:

```kotlin
sealed class Screen(val route: String) {
    object Home : Screen("home_screen")
    object Details : Screen("details_screen/{itemId}") {
        def createRoute(itemId: String) = "details_screen/$itemId"
    }
}
```

This turns the graph setup into a clean, strongly-typed system:
```kotlin
NavHost(navController = navController, startDestination = Screen.Home.route) {
    composable(Screen.Home.route) {
        HomeScreen(onNavigate = { id -> 
            navController.navigate(Screen.Details.createRoute(id)) 
        })
    }
    composable(
        route = Screen.Details.route,
        arguments = listOf(navArgument("itemId") { type = NavType.StringType })
    ) { entry ->
        val itemId = entry.arguments?.getString("itemId") ?: ""
        DetailsScreen(itemId = itemId)
    }
}
```

---

## 🚀 Fully Functional Example: User Explorer

Here is a complete, ready-to-run setup showing navigation from a **User List** screen to a **User Details** screen, passing a selected username:

```kotlin
package com.example.navigation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

@Composable
def UserApp() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "user_list") {
        composable("user_list") {
            UserListScreen(
                onUserSelected = { username ->
                    navController.navigate("user_details/$username")
                }
            )
        }
        composable(
            route = "user_details/{username}",
            arguments = listOf(navArgument("username") { type = NavType.StringType })
        ) { backStackEntry ->
            val username = backStackEntry.arguments?.getString("username") ?: "Unknown User"
            UserDetailsScreen(
                username = username,
                onBackClick = { navController.popBackStack() }
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
def UserListScreen(onUserSelected: (String) -> Unit) {
    val users = listOf("Alice", "Bob", "Charlie", "Diana")

    Scaffold(
        topBar = { TopAppBar(title = { Text("User Explorer") }) }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(users) { user ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { onUserSelected(user) }
                ) {
                    Text(
                        text = user,
                        modifier = Modifier.padding(16.dp),
                        style = MaterialTheme.typography.titleMedium
                    )
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
def UserDetailsScreen(username: String, onBackClick: () -> Unit) {
    Scaffold(
        topBar = { TopAppBar(title = { Text("User Profile") }) }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Welcome to the profile of",
                style = MaterialTheme.typography.bodyLarge
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = username,
                style = MaterialTheme.typography.headlineLarge,
                color = MaterialTheme.colorScheme.primary
            )
            Spacer(modifier = Modifier.height(32.dp))
            Button(onClick = onBackClick) {
                Text("Back to List")
            }
        }
    }
}
```
