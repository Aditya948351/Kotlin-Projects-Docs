<h1 align="center">🚀 Jetpack Compose & Kotlin Hub</h1>
<p align="center">
  <strong>A curated collection of modern Android applications built using Jetpack Compose, Kotlin, and industry best practices.</strong>
</p>

<p align="center">
  <img src="https://img.shields.io/badge/Kotlin-1.9+-7F52FF?style=for-the-badge&logo=kotlin&logoColor=white" alt="Kotlin" />
  <img src="https://img.shields.io/badge/Android-12%2B-3DDC84?style=for-the-badge&logo=android&logoColor=white" alt="Android" />
  <img src="https://img.shields.io/badge/Jetpack_Compose-Latest-4285F4?style=for-the-badge&logo=jetpackcompose&logoColor=white" alt="Jetpack Compose" />
  <img src="https://img.shields.io/badge/Material_3-Modern-6750A4?style=for-the-badge&logo=materialdesign&logoColor=white" alt="Material 3" />
  <img src="https://img.shields.io/badge/License-MIT-green?style=for-the-badge" alt="License" />
</p>

---

## 🌟 Repository Overview

Welcome to the ultimate resource for mastering Android development with **Jetpack Compose**! This repository is organized into three distinct tiers of applications—ranging from simple API integrations to machine learning utilities and advanced state-managed student planners. It also hosts standalone reusable UI code snippets.

Whether you're a beginner wanting to understand network operations or an experienced engineer looking to inspect complex database architectures, you'll find structured, clean, and fully-functioning source code here.

---

## 📂 Repository Structure

The codebase is organized logically to separate simplicity, AI features, advanced engineering, and standalone code snippets:

```text
📁 Kotlin-Projects-Docs
│
├── 📁 simple-apps            # Beginner-friendly applications
│   └── 📁 MarsPhotos         # Rest API photo viewer using Retrofit & Coil
│
├── 📁 mlkit-apps             # Machine Learning utilities
│   └── 📁 TextExtractor      # OCR tool utilizing Google ML Kit Camera API
│
├── 📁 advanced-apps          # Advanced architectures (Room, MVI/MVVM, Flow)
│   ├── 📁 StudySmart         # Complete study planner with customized stats & timers
│   └── 📁 ToDoApp-JC         # Reactive local task management using Room Database
│
└── 📁 snippets               # Reusable production-grade Composable templates
    └── 📄 LoginScreen.kt     # High-end animated glassmorphism Login layout
```

---

## 📚 Branch Navigator

This repository uses targeted branches to host different phases of the educational material. Use the branch switcher to explore them:

| Branch | Description | Contents |
| :--- | :--- | :--- |
| **`main`** | *Default* | Stable completed applications, snippet library, and core readmes. |
| **`docs`** | *Informative* | Deep-dives into Jetpack Compose concepts (`Basics.md`, `Introduction.md`, `Navigation.md`). |
| **`App-Snippets`** | *Component-level* | Partially built templates & code segments (`Codes/1_codefor_Img1.kt`). |
| **`Demo`** | *Experimental* | Temporary workflows and sandbox layouts for active tests. |
| **`Videos`** | *Visual Guide* | Application screen recordings and visual demonstrations. |

---

## 📱 Application Catalog

Here is an overview of the projects included in this repository:

<details open>
<summary><strong>🟢 Simple Apps</strong></summary>
<br/>

### 🛰️ MarsPhotos
A clean, lightweight app displaying stunning photos of the Martian surface retrieved directly from NASA web services.
*   **Key Highlights**:
    *   Implements **Retrofit & Serialization** for asynchronous JSON networking.
    *   Leverages **Coil** for smooth image loading, error placeholders, and cache management.
    *   Utilizes the **Repository Pattern** to decouple networking from the UI layer.
    *   Graceful state management handling *Loading*, *Success*, and *Error* states with visual cues.
*   **Path**: [`simple-apps/MarsPhotos`](./simple-apps/MarsPhotos)

</details>

<details>
<summary><strong>🟡 ML Kit Apps</strong></summary>
<br/>

### 🔍 TextExtractor
An on-device OCR (Optical Character Recognition) application that extracts text from camera streams or photo uploads using AI.
*   **Key Highlights**:
    *   Integrates **Google ML Kit Text Recognition** for high-accuracy local processing.
    *   Features a custom-configured **CameraX** camera viewport for live-view scanning.
    *   Interactive OCR results card showing structured paragraphs with a fast Copy-to-Clipboard action.
*   **Path**: [`mlkit-apps/TextExtractor`](./mlkit-apps/TextExtractor)

</details>

<details>
<summary><strong>🔴 Advanced Apps</strong></summary>
<br/>

### 🎓 StudySmart
A sophisticated student planner designed to monitor study sessions, track dashboard tasks, and visual goal-setting.
*   **Key Highlights**:
    *   Complex state handling using Kotlin **StateFlow** and asynchronous Coroutines.
    *   Custom theme configuration supporting dynamic Material 3 color variations and premium dark mode.
    *   Deep modular Jetpack Navigation hierarchy with safe arguments.
*   **Path**: [`advanced-apps/StudySmart`](./advanced-apps/StudySmart)

###  📝 ToDoApp-JC
A fully offline task manager showcasing reactive programming and persistent state.
*   **Key Highlights**:
    *   Implements a local **Room Database** for offline-first architecture.
    *   Structured using a clean MVVM pattern.
    *   Interactive swipe-to-delete cards, task category filtering, and item prioritization.
*   **Path**: [`advanced-apps/ToDoApp-JC`](./advanced-apps/ToDoApp-JC)

</details>

---

## ✨ Code Snippet Spotlight: Glassmorphic Login Screen

Located under the [`snippets/`](./snippets) directory, [LoginScreen.kt](./snippets/LoginScreen.kt) is a production-ready, beautiful Glassmorphism Login screen template. It is fully animated and showcases advanced Jetpack Compose canvas techniques.

### 🌟 Features Included:
1.  **Breathing Animations**: Subtle infinity scales applied to the brand logo.
2.  **Shimmering Borders**: Borders that shift alpha states continuously to simulate a glass reflection.
3.  **Horizontal Gradient Shift**: The CTA buttons utilize shifting gradient start positions to capture focus.
4.  **rememberMe Interaction**: Floating icons and custom-colored active toggle switches.
5.  **Clean Code Structure**: Ready to drop directly into your project with dynamic `TextFieldColors` overlays.

*   **View Code**: [`snippets/LoginScreen.kt`](./snippets/LoginScreen.kt)

---

## 🛠️ How to Run the Projects

Getting started with any of the projects inside the repository is easy:

### 1️⃣ Clone the Repository
```bash
git clone https://github.com/Aditya948351/Kotlin-Projects-Docs.git
cd Kotlin-Projects-Docs
```

### 2️⃣ Open in Android Studio
1.  Launch **Android Studio** (Koala or newer recommended).
2.  Select **Open...**
3.  Navigate to the repository folder and select any sub-folder containing a project (e.g., `advanced-apps/StudySmart`).
4.  Wait for the Gradle Sync to complete successfully.

### 3️⃣ Run on Device
*   Select your physical device or emulator.
*   Click the green **Run** (Play) button in Android Studio.

---

## 🤝 Contribution & Feedback

We welcome contributions to expand the list of projects or enhance the existing ones!

*   Read the [Contributing Guidelines](./CONTRIBUTING.md) to get started.
*   Check the [Issues](https://github.com/Aditya948351/Kotlin-Projects-Docs/issues) board for open tasks.

### 📬 Connect With Us
Have a question, feedback, or a feature request? Let's connect:
*   📧 **Email**: ap8548328@gmail.com
*   📷 **Instagram**: DM us with your ideas!

---

## 📄 License

This repository is licensed under the [MIT License](./LICENSE). Feel free to adapt and use the code snippets in your personal or commercial applications.
