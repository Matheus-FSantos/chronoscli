# ChronosCLI ⏱️

**ChronosCLI** is a high-performance command-line interface (CLI) utility built in Java for real-time CPU monitoring and analysis. Designed to be lightweight, fast, and free from heavy enterprise frameworks (like Spring), ChronosCLI extracts hardware metrics directly from the operating system and renders them visually inside the terminal.

This project expands the ecosystem of utility tools initiated with [Chronologic](https://github.com/Matheus-FSantos/chronologic).

## 🧠 Architecture & Separation of Concerns

The project is structured following a strict separation between the presentation layer and the data collection engine:

*   **Front-end (CLI Interface):** Powered by **Picocli**, which handles argument parsing, command validation, help screens, and visual rendering (ANSI colors and text-based progress bars) in the terminal.
*   **Engine (Hardware Motor):** Powered by **OSHI (Operating System and Hardware Information)**, responsible for low-level native calls to extract per-core CPU usage, active processes, and technical specifications without degrading system performance.

## 🚀 Planned Features

*   `chronos specs`: Displays hardware details (Processor model, max clock speed, physical and logical cores).
*   `chronos live`: Dynamic real-time monitoring (Linux `top` style) with colored bar charts per CPU core.
*   `chronos top`: Instant identification of the top processes consuming CPU cycles.

## 🛠️ Tech Stack

*   **Java 17+** (Pure Java SE, zero framework overhead)
*   **Maven** (Dependency management and build automation)
*   **Picocli** (Command-line interface framework)
*   **OSHI** (Multi-platform native hardware monitoring)
*   **GraalVM** *(Future)* (Ahead-of-Time compilation to generate instant-on native binaries)

## 📦 Getting Started (Development Environment)

```bash
# Clone the repository
git clone https://github.com/Matheus-FSantos/chronoscli.git

# Navigate to the project directory
cd chronos

# Build the project
mvn clean package
```
