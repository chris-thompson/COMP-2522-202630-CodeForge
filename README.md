# Welcome to COMP 2522

## What is this?

This is every piece of Java I write on the board, and quite a lot that I do not
have time to. As we examine the language we will pull examples from here.

There are over 240 files in 38 topics, plus a test suite. By the end of the term you
will have studied most of them.

## How should you use it?

1. During each lecture I will open files from this repository.
2. After each lecture I will assign reading from it. **Reading code is a skill
   and it is trained by reading code.**
3. Before each quiz, reread the topics we have covered.

## How do you study a Java file?

Not by skimming it. Skimming teaches you nothing and feels like studying, which
is the worst combination available.

1. Read the Javadoc at the top. What is this class *for*?
2. Run it, if it has a `main` method.
3. Compare what it printed with the code that printed it. Line by line.
4. Read the file top to bottom and, out loud, **say what each line does** using
   the language of computing. Name the class, the instance variables, the
   constructors, the methods. In each method, name the control structures, the
   data types, the objects, and the methods being called.
5. Ask what each class, method, and block is *trying to achieve*. Not what it
   does — what it is for.
6. Now change something in `main`, and **predict the output before you run it**.
7. Were you right?

Step 6 is the one that matters. Prediction is the only way to find out what you
actually believe, and being wrong out loud is how you stop being wrong.

## Running things

There is no single main class — every sample has its own.

| What | How |
|---|---|
| Run a sample in IntelliJ | green arrow beside its `main` method |
| Run a sample from the terminal | `./gradlew runSample -Psample=ca.bcit.comp2522.arrays.MatrixDriver` |
| Run the test suite | `./gradlew test` |
| Check the whole repository | `./gradlew courseCheck` |

On Windows use `gradlew.bat` instead of `./gradlew`.

`courseCheck` runs the tests plus Checkstyle, PMD, SpotBugs and JaCoCo over
every sample and leaves reports in `build/reports/`. None of them can fail the
build — they are there so you can see what a clean report looks like before you
start producing messy ones.

### About the reports

The code here compiles with **zero compiler warnings** and is close to clean
under Checkstyle. The violations that remain are **deliberate**, and every one
of them is explained in a comment in the file that causes it.

They fall into three groups:

- files where the flagged thing *is* the lesson — `operators/OperatorPrecedence`
  is reported for magic numbers because `2 + 3 * 4` is the example, not a
  number that needs a name;
- files that demonstrate a bad practice on purpose, such as
  `exceptions/DontDoThis` and `innerClasses/ShadowingDemo`;
- two methods in `innerClasses` that are "too long" because they contain class
  definitions, which is the point of a local class.

A static analysis report is advice from a tool that cannot read your mind. Learn
to read it, act on almost all of it, and be able to say out loud why you are
ignoring the rest. "The tool told me to" is not an engineering argument, and
neither is ignoring it silently.

## The topics

Roughly in the order we meet them, with the week each one belongs to:

| Topic | Week | Topic | Week |
|---|---|---|---|
| `helloWorld` | 1 | `printingAndConcatenation` | 1 |
| `dataTypes` | 1 | `operators` | 1 |
| `controlStatements` | 1 | `numbers` | 1, 4 |
| `name` | 2 | `books` | 2 |
| `dice` | 2 | `geometry` | 2 |
| `banking` | 2 | `javafx` | 2, 6 |
| `strings` | 3 | `students` | 3 |
| `finalUsage` | 4 | `variableLength` | 4 |
| `decimalformat` | 4 | `numberformat` | 4 |
| `randomWalker` | 4 | `arrays` | 5 |
| `arraylist` | 5 | `maps` | 5 |
| `enums` | 5 | `staticModifier` | 5 |
| `inheritance` | 6, 7 | `interfaces` | 5, 7 |
| `sorting` | 7 | `exceptions` | 9 |
| `fileIO` | 9 | `serializing` | 9 |
| `scanner` | 9 | `dataStructures` | 10 |
| `innerClasses` | 11 | `iterators` | 11 |
| `generics` | 12 | `streams` | 13 |
| `pigLatin` | any | `commandLineArgs` | any |

`inheritance` and `dataStructures` have subfolders. They are the two largest
topics and the two you will spend the most time in.

## The tests

`src/test/java` holds a JUnit 5 suite covering ten of the classes here. **Read
it as well as running it.** It is written to exactly the conventions your own
labs are held to, so it is the closest thing available to a worked example of
what I am asking you for from Lab 02 onward:

- one logical assertion per test method;
- every test named for the partition or boundary it covers;
- all branches covered;
- **no negative tests** — only arguments that satisfy the preconditions;
- but every **documented** exception covered, because a promise in the Javadoc
  is part of the contract. `arrays/MatrixTest` is the example.

`javafx/TaskItemTest` is worth reading twice. It is the reason model classes
may not contain JavaFX types: because `TaskItem` has no JavaFX in it, it can be
tested in milliseconds with no window and no toolkit.

## What else should you know?

This is a living collection. I will update it during the term and tell you when
I do. If something here is wrong, unclear, or could be better, say so in Slack
— you will not be the only person who noticed.

Good luck, and have fun.
