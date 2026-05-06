# AGENTS Guide for `java_generic_code_exercise`

## Scope and intent
- This repository is a Gradle multi-project with a single active module: `app` (`settings.gradle`).
- The codebase is a Java practice sandbox for interview-style problems and threading demos, not a layered service/application architecture.
- Existing AI instruction files were searched via the requested glob and none were found; treat this file as the canonical agent guidance.

## Big-picture structure
- Entry-point app shell: `app/src/main/java/java_generic_code_exercise/App.java` (simple greeting used by Gradle `application` plugin).
- Algorithm exercises: `app/src/main/java/java_generic_code_exercise/interview_problem/` (one problem per class, usually static methods + local `main`).
- Concurrency exercises: `app/src/main/java/java_generic_code_exercise/concurrency/` (`Runnable`/`Callable` examples, thread lifecycle prints).
- Data structures exercises: `app/src/main/java/java_generic_code_exercise/data_structures/linked_list_operations/` (`Node`, `LLOperations`, etc.).
- Tests are minimal and currently only cover the root app class: `app/src/test/java/java_generic_code_exercise/AppTest.java`.

## Build, run, and test workflows (verified)
- Wrapper script currently lacks execute permission in this workspace (`./gradlew` returns permission denied).
- Use shell invocation unless execute bit is fixed:
```bash
cd /Users/deeptibisht/Documents/digamber_workspace/java_generic_code_exercise
sh ./gradlew --no-daemon test
sh ./gradlew --no-daemon :app:run
```
- If you need direct wrapper execution later, first run: `chmod +x gradlew`.
- Java toolchain is pinned to 21 (`app/build.gradle`), so keep language features compatible with Java 21.

## Project-specific coding patterns to preserve
- Package root is `java_generic_code_exercise`; keep new classes in meaningful subpackages rather than the default package.
- Exercise classes commonly include a self-contained `main` for quick manual runs (see `TwoSum.java`, `LLOperations.java`, `NumberPrinter.java`).
- Many problem solutions expose static helper methods and return `null` when no match exists (example: `TwoSum.findTwoSumOptimized`); do not silently change behavior without explicit request.
- This repo mixes naming styles (for example `ReverseString_1.java` and `First_Last_SortedArray.java`); follow local file naming when editing nearby code.
- `Node` fields are package-private in linked-list code; preserve access level unless refactor is explicitly requested.

## Dependencies and integration points
- Dependency management uses version catalogs in `gradle/libs.versions.toml`.
- Runtime dependency: Guava (`com.google.guava:guava`), currently not central to most exercises.
- Test stack: JUnit Jupiter (`org.junit.jupiter:junit-jupiter`) with `useJUnitPlatform()` in `app/build.gradle`.
- No external services, databases, HTTP clients, or inter-module APIs are present.

## Agent operating rules for this repo
- Prefer surgical edits in existing exercise files; avoid broad refactors across unrelated problem classes.
- Do not edit generated/compiled artifacts under `app/build/`.
- When adding a new problem implementation, include:
  1) the solution class under the relevant package,
  2) a focused JUnit test in `app/src/test/java/...`,
  3) optional `main` only if it matches neighboring files.
- Validate with `sh ./gradlew --no-daemon test` before finalizing changes.

